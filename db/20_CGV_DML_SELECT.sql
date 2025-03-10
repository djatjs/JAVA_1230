# 상영중인 영화 조회하는 쿼리 : 영화 제목, 개봉일
select MV_TITLE, MV_DATE from movie
where MV_STATE = "상영중";

# CGV/강남을 선택하고, 미키17를 선택했을 때 상영 가능한 날짜를 조회하는 쿼리
select MV_TITLE, SD_DATE, SD_TIME from schedule
join movie on SD_MV_NUM = MV_NUM
join screen on SD_SC_NUM = SC_NUM
join theater on SC_TT_NUM = TT_NUM 		# screen과 theater join시킴
where MV_TITLE = "미키17" and TT_NAME = "CGV/강남"
order by SD_TIME;

# CGV/강남 1관의 등록된 모든 좌석을 조회하는 쿼리
select * from seat
join `screen` on SE_SC_NUM = SC_NUM
join theater on SC_TT_NUM = TT_NUM
where SC_NAME = "1관" and TT_NAME = "CGV/강남";

# CGV/강남 1관의 3월 11일 16:20에 상영하는 미키17의 예약 가능한 좌석을 조회하는 쿼리
select SE_NAME from seat
join `screen` on SE_SC_NUM = SC_NUM
join `theater` on SC_TT_NUM = TT_NUM
join `schedule` on SD_SC_NUM = SC_NUM
join `movie` on SD_MV_NUM = MV_NUM
where 
	SC_NAME = "1관" and TT_NAME = "CGV/강남" and 
    MV_TITLE = "미키17" and SD_DATE = "2025-03-11" and 
    SD_TIME = "16:20" and SE_POS = "Y";
    
# CGV/강남 1관(1)의 3월 11일 16:20에 상영하는 미키17(3)의 예약 가능한 좌석을 조회하는 쿼리
# 예매 리스트와 join해서 예매가 안된 좌석 조회
select * from seat
join schedule on SD_SC_NUM = SE_SC_NUM
left join ticket on TI_SD_NUM = SD_NUM
left join ticket_list on TL_SE_NUM = SE_NUM
where 
	 SE_POS = "Y" and SD_NUM = 3 and # 조인 좀 줄이려고 이렇게 함
     TL_SE_NUM is null;
    


# 2번 스케쥴에서 예약된 좌석들
SELECT SEAT.* FROM SEAT 
	JOIN SCHEDULE ON SD_SC_NUM = SE_SC_NUM
	LEFT JOIN TICKET ON TI_SD_NUM = SD_NUM
	LEFT JOIN TICKET_LIST ON TI_NUM = TL_TI_NUM
	WHERE SE_POS = "Y" AND SD_NUM = 2 AND TL_SE_NUM = SE_NUM;

# CGV강남 4관의 3월 11일 19:10에 상영하는 미키 17의 예약 가능한 좌석을 조회하는 쿼리 
# 예매 리스트와 JOIN해서 예매가 안된 좌석을 조회 
SELECT * FROM SEAT 
WHERE SE_SC_NUM = 4 AND SE_NUM NOT IN(
	SELECT SE_NUM FROM SEAT 
	JOIN SCHEDULE ON SD_SC_NUM = SE_SC_NUM
	LEFT JOIN TICKET ON TI_SD_NUM = SD_NUM
	LEFT JOIN TICKET_LIST ON TI_NUM = TL_TI_NUM
	WHERE SE_POS = "Y" AND SD_NUM = 2 AND TL_SE_NUM = SE_NUM AND TI_STATE = "결제");
    
    
# 장르별 등록된 영화수 조회하는 쿼리
select GR_NAME, count(MG_GR_NAME) from genre
left join movie_genre on MG_GR_NAME = GR_NAME
group by GR_NAME;

# 현재 시간을 기준으로 한달 사이에 개봉한 영화 조회하는 쿼리
select * from movie
where MV_DATE between date_sub(now(), interval 1 month) and now();

# 각 영화별 예매수 조회하는 쿼리
# 예매수는 상영시간이 지나지 않은 예매만 해당
select MV_TITLE 영화, sum(TI_ADULT + TI_TEEN) 예매수 from ticket
join schedule on TI_SD_NUM = SD_NUM
right join movie on SD_MV_NUM = MV_NUM
where TI_STATE = "결제" AND concat(SD_DATE, " ", SD_TIME) >= now()
group by MV_TITLE;

select movie.*, sum(TI_ADULT + TI_TEEN) 예매수 from movie
left join schedule on SD_MV_NUM = MV_NUM
left join ticket on TI_SD_NUM = SD_NUM
where TI_STATE = "결제" AND concat(SD_DATE, " ", SD_TIME) >= now()
group by MV_NUM;
 
# 각 영화별 예매수 조회하여 예매가 높은 순으로 조회하는 쿼리
select movie.*, sum(TI_ADULT + TI_TEEN) 예매수 from movie
left join schedule on SD_MV_NUM = MV_NUM
left join ticket on TI_SD_NUM = SD_NUM
where TI_STATE = "결제" AND concat(SD_DATE, " ", SD_TIME) >= now()
group by MV_NUM
order by 예매수 desc;

# 각 영화별 예매수를 조회하여 예매율을 조회하는 쿼리 => 예매율 = 영화 예매수/전체 영화 예매수*100
select movie.*, 
sum(TI_ADULT + TI_TEEN) 예매수,
sum(TI_ADULT + TI_TEEN)*100/Sum(sum(TI_ADULT + TI_TEEN)) OVER() 예매율 
from movie
left join schedule on SD_MV_NUM = MV_NUM
left join ticket on TI_SD_NUM = SD_NUM
where TI_STATE = "결제" AND concat(SD_DATE, " ", SD_TIME) >= now()
group by MV_NUM
order by 예매율 desc;

select M.*, 예매수*100/sum(예매수) as 예매율 from (
	select movie.*, sum(TI_ADULT + TI_TEEN) 예매수 from movie
		left join schedule on SD_MV_NUM = MV_NUM
		left join ticket on TI_SD_NUM = SD_NUM
		where TI_STATE = "결제" AND concat(SD_DATE, " ", SD_TIME) >= now()
		group by MV_NUM
		order by 예매수 desc) M
;

# 개복잡하게 해보기
SELECT 
    M.*, 예매수 * 100 / 전체예매수 AS 예매율 
FROM (
    SELECT 
        movie.*, 
        SUM(TI_ADULT + TI_TEEN) AS 예매수 FROM movie
		LEFT JOIN schedule ON SD_MV_NUM = MV_NUM
		LEFT JOIN ticket ON TI_SD_NUM = SD_NUM AND TI_STATE = '결제'
		WHERE CONCAT(SD_DATE, " ", SD_TIME) >= NOW()
		GROUP BY MV_NUM
) M,
(
    SELECT SUM(TI_ADULT + TI_TEEN) AS 전체예매수 FROM ticket 
    LEFT JOIN schedule ON TI_SD_NUM = SD_NUM 
    WHERE 
		TI_STATE = '결제' AND CONCAT(SD_DATE, " ", SD_TIME) >= NOW()
) AS 전체;

# 각 예매율 순으로 순위 조회하는 쿼리
select RANK() OVER(ORDER BY 예매율 DESC) 순위, M2.* from
(SELECT 
        movie.*, 
        SUM(TI_ADULT + TI_TEEN)AS 예매수,
        SUM(TI_ADULT + TI_TEEN) * 100 /SUM(SUM(TI_ADULT + TI_TEEN)) OVER () AS 예매율
    FROM movie
    LEFT JOIN schedule ON SD_MV_NUM = MV_NUM
    LEFT JOIN ticket ON TI_SD_NUM = SD_NUM AND TI_STATE = "결제"
    WHERE CONCAT(SD_DATE, " ", SD_TIME) >= NOW()
    GROUP BY MV_NUM) M2;

# 영화를 등록순으로 10개 조회하는 쿼리
-- select  RANK() OVER(ORDER BY MV_NUM asc) 등록순, movie.* from movie limit 10; 
select * from movie limit 10;

# 봉준호 감독이 참여한 모든 영화를 조회하는 쿼리
select * from movie
join movie_actor on MA_MV_NUM =MV_NUM
join actor on AT_NUM = MA_AT_NUM
join person on AT_PR_NUM = PR_NUM
where PR_NAME = "봉준호" and AT_POSITION = "감독";


# 청소년들이 가장 많이 예매한 영화를 조회하는 쿼리
select movie.* , sum(TI_TEEN) as 예매수 from movie
left join schedule on SD_MV_NUM = MV_NUM
left join ticket on TI_SD_NUM = SD_NUM
where TI_STATE = "결제" group by MV_NUM
order by 예매수 desc
limit 1;
