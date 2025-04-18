## CGV 사이트를 참고하여 마키17 영화를 등록할 때 필요한 쿼리들 작성하기

## 영화 정보 등록
# 관람등급 테이블에 값 추가
INSERT INTO movie_ratings VALUES
("전체 관람가"),("12세 관람가"),("15세 관람가"),("18세 이상 관람가"),("청소년 관람 불가");

# 제목, 러닝타임, 개봉일, 영화설명, 상영상태, 관람등급명(이건 영화 테이블 전에 만들어놔야함)을 INSERT하기
INSERT INTO MOVIE(MV_TITLE, MV_TIME, MV_DATE, MV_CONTENT, MV_STATE, MV_MR_AGE) VALUES
("미키17", 137, "2025-02-28", "당신은 몇 번째 미키입니까?", "상영중","15세 관람가");

# 장르 테이블에 값 추가
INSERT INTO genre VALUES
("액션"),("어드벤처"),("애니메이션"),("코미디"),("드라마"),("공포"),("로맨스"),("SF"),("판타지"),("스릴러"),("범죄"),("전쟁");

# 영화 장르 등록
INSERT INTO movie_genre(MG_MV_NUM, MG_GR_NAME) VALUES
(1,"어드벤처"),(1,"SF"),(1,"드라마");

# 국가 추가
INSERT INTO country VALUES
("미국"),("영국"),("한국"),("오스트레일리아"),("일본");

# 제작 국가 등록
INSERT INTO movie_country(MC_CT_NAME,MC_MV_NUM) VALUES("미국",1);

# 인물 추가(국가 추가 후 해야함) : 봉준호, 로버트 패틴슨, 나오미 애키, 스티븐 연, 토니 콜렛, 마크 러팔로 
# 국가 등록 안되어 있는 경우도 있어서 PR_CT_NAME 설정할 때 NOT NULL 해제
INSERT INTO PERSON(PR_NAME, PR_BIRTH, PR_DETAIL, PR_CT_NAME) VALUES
("봉준호","1969-09-14","","한국"),
("로버트 패틴슨","1986-05-13","국내에서는 ...","영국"),
("나오미 애키","1992-11-02","",NULL),
("스티븐 연","1983-12-21","한국계 미국인","미국"),
("토니 콜렛","1972-11-01","","오스트레일리아"),
("마크 러팔로","1967-11-22","1968년 위스콘신 출생.","미국");

# 영화인 등록
INSERT INTO actor(AT_POSITION, AT_PR_NUM) VALUES
("감독",1),("배우",2),("배우",3),("배우",4),("배우",5),("배우",6);

# 영화 참여 등록 ("역할",몇번째 영화, 몇번째 영화인)
INSERT INTO movie_actor(MA_ROLE, MA_MV_NUM, MA_AT_NUM) VALUES
("감독",1,1),("미키 반스",1,2),("나샤 배릿지",1,3),("티모",1,4),("일파 마샬",1,5),("케네스 마샬",1,6);

# 트레일러와 스틸컷 등록
INSERT INTO file(FI_NAME, FI_TYPE, FI_MV_NUM) VALUES
("미키17_1.JPG", "S", 1),
("미키17_2.JPG", "S", 1),
("미키17_3.JPG", "S", 1),
("미키17_1.MP4", "T", 1),
("미키17_2.MP4", "T", 1),
("미키17_3.MP4", "T", 1);

## 예매 기능
# 지역 추가
INSERT INTO region VALUES
("서울"),("경기"),("인천"),("대전/충청"),("대구"),("부산/울산"),("경상"),("광주/전라/제주");

# 요금
INSERT INTO FEE(FE_TYPE,FE_PRICE,FE_DATE) VALUES
("성인", 15000,"2025-03-01"),("청소년", 12000,"2025-03-01"),("조조", 11000,"2025-03-01");

## 미키17 강남 3/11 상영시간을 등록할 때 필요한 쿼리들을 작성
## 4관 13:50, 19:10
## 1관 16:20
## 3관 09:00, 11:50
## 5관 10:00

# 극장 등록
INSERT INTO theater(TT_NAME, TT_ADDR, TT_COUNT, TT_RG_NAME) VALUES
("CGV강남", "서울특별시 강남구 강남대로 438 (역삼동)", 5, "서울");

# 상영관 등록
INSERT INTO screen(SC_NAME, SC_SEAT, SC_TT_NUM)VALUES
("1관", 12,1),("2관", 10,1),("3관", 15,1),("4관", 16,1),("5관", 20,1);

# 좌석 등록
INSERT INTO seat(SE_NAME, SE_SC_NUM)VALUES
("A1",1),("A2",1),("A3",1),("A4",1),
("B1",1),("B2",1),("B3",1),("B4",1),
("C1",1),("C2",1),("C3",1),("C4",1),

("A1",2),("A2",2),("A3",2),("A4",2),("A5",2),
("B1",2),("B2",2),("B3",2),("B4",2),("B5",2),

("A1",3),("A2",3),("A3",3),
("B1",3),("B2",3),("B3",3),
("C1",3),("C2",3),("C3",3),
("D1",3),("D2",3),("D3",3),
("E1",3),("E2",3),("E3",3),

("A1",4),("A2",4),("A3",4),("A4",4),
("B1",4),("B2",4),("B3",4),("B4",4),
("C1",4),("C2",4),("C3",4),("C4",4),
("D1",4),("D2",4),("D3",4),("D4",4),

("A1",5),("A2",5),("A3",5),("A4",5),("A5",5),
("B1",5),("B2",5),("B3",5),("B4",5),("B5",5),
("C1",5),("C2",5),("C3",5),("C4",5),("C5",5),
("D1",5),("D2",5),("D3",5),("D4",5),("D5",5);

# 상영 시간 등록
INSERT INTO `schedule`(SD_DATE, SD_TIME, SD_POS_SEAT, SD_EARLY, SD_MV_NUM, SD_SC_NUM) VALUES
("2025-03-11","13:50",16,"N",1,4),
("2025-03-11","19:10",16,"N",1,4),
("2025-03-11","16:20",12,"N",1,1),
("2025-03-11","09:00",15,"Y",1,3),
("2025-03-11","11:50",15,"Y",1,3),
("2025-03-11","10:00",20,"Y",1,5);


# 회원가입하는 쿼리. 아이디 : abc123, 비번 : abc123, 사용자
insert into `member` (ME_ID, ME_PW) values
("abc123","abc123");


# abc123 회원이 3번 스케쥴(미키 17, 1관 3월 11일 16:20)의 예약 가능한 좌석 A1, A2를 예매했을 때 필요한 쿼리
insert into ticket(TI_ADULT, TI_TEEN, TI_PRICE, TI_STATE, TI_ME_NUM, TI_SD_NUM) values
(1,1,27000,"결제", 1, 3);
insert into ticket_list(TL_TI_NUM, TL_SE_NUM) values
(1,1),(1,2);
# 스케줄에 예매 가능 좌석 수 변경
update schedule
set SD_POS_SEAT = SD_POS_SEAT -2
where SD_NUM = 3;


# abc123 회원이 1번 스케쥴(미키 17, 4관 3월 11일 13:50)의 예약 가능한 좌석 A1, A2를 예매했을 때 필요한 쿼리
insert into ticket(TI_ADULT, TI_TEEN, TI_PRICE, TI_STATE, TI_ME_NUM, TI_SD_NUM) 
values (1,1,27000,"결제", 1, 1);
insert into ticket_list(TL_TI_NUM, TL_SE_NUM) values (2,38),(2,39);
update schedule
set SD_POS_SEAT = SD_POS_SEAT -2
where SD_NUM = 1;

# abc123 회원이 2번 스케쥴(미키 17, 4관 3월 11일 19:10)의 예약 가능한 좌석 A1, A2를 예매했을 때 필요한 쿼리 
insert into ticket(TI_ADULT, TI_TEEN, TI_PRICE, TI_STATE, TI_ME_NUM, TI_SD_NUM) values
(1,1,27000,"결제", 1, 2);
INSERT INTO TICKET_LIST(TL_TI_NUM, TL_SE_NUM) VALUES(3, 38), (3,39);
update schedule
set SD_POS_SEAT = SD_POS_SEAT -2
where SD_NUM = 2;

# abc123 회원이 2번 스케쥴(미키 17, 4관 3월 11일 19:10)의 예약 가능한 좌석 A3, A4를 예매했을 때 필요한 쿼리 
INSERT INTO TICKET(TI_ADULT, TI_TEEN, TI_PRICE, TI_ME_NUM, TI_SD_NUM)
VALUES(1, 1, 27000, 1, 2);
INSERT INTO TICKET_LIST(TL_TI_NUM, TL_SE_NUM) VALUES(4, 40), (4,41);
update schedule
set SD_POS_SEAT = SD_POS_SEAT -2
where SD_NUM = 2;


# abc123 회원이 2번 스케줄에 예약한 A3, A4 좌석을 취소할 때 필요한 쿼리(TI_NUM을 알고 있다는 가정하에 update)
-- select TI_NUM from ticket
-- join ticket_list on TL_TI_NUM = TI_NUM
-- join seat on TL_SE_NUM = SE_NUM
-- where SE_NAME = "A3" OR SE_NAME = "A4";
update ticket set TI_STATE = "취소" where TI_NUM =4;
delete from ticket_list where TL_TI_NUM  = 4;
update schedule
set SD_POS_SEAT = SD_POS_SEAT +2
where SD_NUM = 2;
    
