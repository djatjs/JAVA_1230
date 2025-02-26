/*
SELECT * FORM 테이블명;
# 테이블에 있는 모든 데이터들을 조회화는 쿼리.
*/

# 번호까지도 초기화 버튼
-- truncate table student.student;



SELECT * FROM student.student;

# SELECT 속성1, ..., 속성n FORM 테이블명;
# 테이블에 있는 속성1, ..., 속성n의 데이터를 조회하는 쿼리
# 학생들의 학년, 반, 번호, 이름을 조회하는 쿼리
# 속성명 옆에 AS 새속성명을 입력하면 결과창에 '보이는' 속성 이름을 변경할 수 있음
# 	- AS 생략 가능하긴 함
SELECT st_grade AS 학년, st_class AS "반", st_num 번호, st_name 이름 FROM student.student;


# SELECT [DISTINCT] 속성1, ..., 속성N FROM 테이블명 [WHERE 조건식]
# 조건식을 만족하는 속성들을 조회하는 쿼리. 
# 중복된 행은 제거 => 기본키 속성을 포함하지 않은 경우 중복이 가능
# 논리 연산자 
#	- AND, OR, NOT
# 	- AND의 우선순위가 OR보다 높음
# 비교 연산자
# 	=, !=, <>, <, <=, >=
#	속성 BETWEEN A AND B : A이상 B이하 =>     							(속성 >= A AND 속성 <= B)와 같음
#	속성 NOT BETWEEN A AND B : A미만 또는 B초과 =>    					(속성 < A OR 속성 > B)와 같음
#	속성 IN(값1, ...,값N) : 속성의 값이 값1, ..., 값N 중에 있을 때 참. =>   	(속성 = 값1) OR (...) OR (속성 = 값N)
#	속성 NOT IN(값1, ...,값N) : 속성의 값이 값1, ..., 값N 중에 없을 때 참.   	(속성 != 값1) AND (...) AND (속성 != 값N)
#	LIKE "패턴" : 패턴과 일치하는 값을 조회할 때 사용
#		- _ : 한 글자
#		- % : 0글자 이상
#		- ___ : 3글자
#		- 홍% : '홍'으로 시작하는 문자열
#		- NULL 확인
#			- IS NULL : NULL이면 참
#			- IS NOT NULL : NULL이 아니면 참

# 등록된 학생들의 학년 조회하는 쿼리
SELECT DISTINCT st_grade 학년 FROM student.student;
# 1학년 학생들을 조회하는 쿼리
SELECT * FROM student.student WHERE st_grade=1;


# 1학년 1반에서 1번~3번 사이의 학생들을 조회하는 쿼리
SELECT * FROM student.student 
where st_grade =1 and st_class=1 and st_num between 1 and 3;
SELECT * FROM student.student 
where st_grade =1 and st_class=1 and st_num in(1,2,3);


# 성이 홍씨인 학생들을 조회하는 쿼리
select * from student.student
where st_name LIKE "홍%";
select * from student.student
where st_name LIKE concat("홍","%");

# 성이 홍씨가 아닌 학생들을 조회하는 쿼리
select * from student.student
where st_name not LIKE "홍%";

# 이름에 길이 들어가는 학생들을 조회하는 쿼리
select * from student.student
where st_name LIKE "%길%";

# 성이 고씨이고 이름이 3글자인 학생들을 조회하는 쿼리
select * from student.student
where st_name LIKE "고%__";


/*
정렬
SELECT [DISTINCT]
	속성1, ..., 속성N
FROM
	테이블명
[WHERE 조건]
[ORDER BY 속성A [ASC | DESC] [,속성B [ASC | DESC]]]

ASC : 오름차순, 생략하면 기본 ASC
DESC : 내림차순
*/

select * from student.student;

# 3학년, 2학년, 1학년 순으로 조회하고 학년이 같은 경우 1반, 2반 순으로 조회하고, 반이 같은 경우 1번, 2번 순으로 조회하는 쿼리
select * from student.student 
order by st_grade desc, st_class, st_num;
    
# 3학년 학생들을 이름 사전순으로 정렬하고, 이름이 같으면 반, 번호 순으로 오름차순으로 정렬하는 쿼리
select * from student.student 
where st_grade =3
order by st_name, st_class, st_num;
    
# 3학년 중 번호가 2에 가까운 학생 순으로 정렬
select *, abs(st_num - 2) as num from student.student where st_grade =3 order by num, st_num;


/*
결과에서 원하는 개수를 가져오는 쿼리 => 페이지에서 자주 쓰인다고 함
SELECT [DISTINCT]
	속성1, ..., 속성N
FROM
	테이블명
[WHERE 조건]
[ORDER BY 속성A [ASC | DESC] [,속성B [ASC | DESC]]]
[LIMIT 번지, 개수]
 - 검색 결과에서 번지부터 개수만큼 가져옴
 - 번지는 0번지.
 - 번지를 생략할 수 있고, 생략하면 0번지
 => 결과중에 컷한다는 느낌같음 slice 느낌?
*/
select * from student.student limit 3;
select * from student.student limit 0,3;
select * from student.student limit 8,3; # 8번지부터 3개

# 한 페이지에 학생 3명의 정보를 조회하는 페이지가 있고, 학생 등록순으로 조회를 한다.
# 이 때 3페이지에서 조회 가능한 학생들을 선택하는 쿼리
select * from student.student 
-- order by st_key
limit 6,3; # 6 => 3명 * (3페이지 -1), 3=> 3명

/*
그룹화
SELECT [DISTINCT]
	속성1, ..., 속성N
FROM
	테이블명
[WHERE 조건]
[GROUP BY 속성A [, 속성2, ...]]
[HAVING 조건]
[ORDER BY 속성A [ASC | DESC] [,속성B [ASC | DESC]]]
[LIMIT 번지, 개수]
 - 결과들을 그룹으로 묶어서 처리할 때
	- 1학년 1반 학생수는?
    - 각학년별 각반의 학생수는?
    - 각학년의 학생수는?
 - 보통 집계함수와 함께 사용
 - GROUP BY는 묶는 기준
	- 학년, 반을 기준으로 묶음
    - 학년, 반을 기준으로 묶음
    - 학년을 기준으로 묶음
 - HAVING절은 집계함수에 조건을 걸 때 사용
 
 집계함수
  - COUNT(속성) : 결과의 개수를 셈 => 속성의 값이 null이 아닌 개수를 반환
  - SUM(속성) : 속성의 합
  - AVG(속성) : 속성의 평균
  - MIN(속성) : 속성의 최소값
  - MAX(속성) : 속성의 최대값
*/
# 3학년 3반의 끝번호 조회
select max(st_num) as "3학년 3반 끝번호" from student.student
WHERE st_grade =3 and st_class =3;

# 2학년 1반의 학생수 조회
select count(*) as "2학년 1반 학생수" from student.student 
WHERE st_grade =2 and st_class =1;

# 각학년 각반의 학생수 조회
select st_grade, st_class, count(*) as 학생수 from student.student
group by st_grade, st_class;

# 학년별 학생수 조회
select st_grade, count(*) as 학생수 from student.student
group by st_grade;

# 학생수가 5명 이상인 학년 조회
select st_grade, count(*) as `학생수` from student.student 
group by st_grade
having `학생수` >=5;

# Q : GROUP BY가 있는 쿼리에서 조건이 필요하면 무조건 HAVING절에 써야 함 : x
# -> 조건에 집계함수가 없으면 WHERE절, 있으면 HAVING절




/*
JOIN
- 테이블A가 테이블B에 참조되고 있으면 B에는 외래키, A에는 기본키로 연결이 되어 있을 때 JOIN 사용
	-> 학생테이블이 성적테이블에 참조되고 있으면 성적테이블의 외래키는 SC_ST_KET이고, 학생 테이블 ST_KEY에 연결되어있음
- 여러 테이블을 묶어서 하나의 결과 테이블을 만들 때 사용

INNER JOIN : 두 테이블의 교집합
	- 성적이 등록된 학생들의 과목 성적을 조회
      -> 성적이 등록되지 않은 학생들은 조회 안됨 
	  -> 성적이 등록되지 않은 과목들은 조회 안됨
      
OUTER JOIN : 두 테이블의 합집합
	- 모든 과목의 성적들을 조회
      -> 성적이 등록되지 않은 과목들 조회 됨
      -> 성적이 등록되지 않은 학생들 조회 안됨
	- 모든 학생들의 과목 성적들을 조회
      -> 성적이 등록되지 않은 과목들 조회 안됨
      -> 성적이 등록되지 않은 학생들 조회 됨

SELF JOIN : 하나의 테이블로 JOIN
*/


/*

1. INNER JOIN

SELECT 테이블A.속성1, 테이블A.속성2, ..., 테이블B.속성1,테이블B.속성2
FROM
	테이블A
JOIN
	테이블B ON 테이블A.기본키 = 테이블B.외래키
     - 속성명이 겹치지 않으면 테이블명을 쓰지 않아도 됨
;
*/

# 성적이 등록된 모든 학생들의 성적 조회하는 쿼리
SELECT  
	ST_GRADE 학년, ST_CLASS 반, ST_NUM 번호, ST_NAME 이름,
	SJ_GRADE 학년, SJ_SEMESTER 학기, SJ_NAME 과목명, SC_SCORE 성적
FROM SCORE
JOIN student ON student.ST_KEY = SCORE.SC_ST_KEY
JOIN SUBJECT ON SCORE.SC_SJ_NUM = SUBJECT.SJ_NUM;

# 뷰(테이블처럼 쓸거여서 속성이름 다르게 설정해야됨. 보여주기만 하기 위한 SELECT와는 다름)
# 뷰를 이용한 쿼리 재사용 
# 뷰는 미리 정의된 쿼리를 이용해서 마치 일반 테이블처럼 사용하는 가상의 테이블
# 뷰의 장점. 1. 재사용 2. 가독성 3. 쿼리 단순화 4. 보안 강화 => 특정 컬럼이나 데이터만 보여줄수 있음 
/*
CREATE VIEW 뷰명 AS SELECT쿼리문;
*/
DROP VIEW STUDENT_SCORE;
CREATE VIEW STUDENT_SCORE AS
	SELECT  
	ST_GRADE 학년, ST_CLASS 반, ST_NUM 번호, ST_NAME 이름,
	SJ_GRADE `과목 학년`, SJ_SEMESTER 학기, SJ_NAME 과목명, SC_SCORE 성적,
    ST_KEY 학생번호
	FROM SCORE
	JOIN student ON student.ST_KEY = SCORE.SC_ST_KEY
	JOIN SUBJECT ON SCORE.SC_SJ_NUM = SUBJECT.SJ_NUM;


# 1학년의 1학년 1학기 국어 성적을 조회하는 쿼리 
SELECT * FROM STUDENT_SCORE 
where 학년 =1  AND `과목 학년`=1 AND 학기=1 AND 과목명='국어';

# 1학년의 1학년 1학기 국어 성적의 평균을 조회하는 쿼리 
SELECT 학년, `과목 학년`, 학기, 과목명, avg(성적) 평균 FROM STUDENT_SCORE 
where 학년 =1  AND `과목 학년`=1 AND 학기=1 AND 과목명='국어';

# 2학년의 1학년 2학기 국어 성적의 평균을 각 반별로 조회하는 쿼리 
SELECT 학년, 반, `과목 학년`, 학기, 과목명, avg(성적) 평균 FROM STUDENT_SCORE 
where 학년 =2  AND `과목 학년`=1 AND 학기=2 AND 과목명='국어'
GROUP BY 반;

# 각 학생의 전체 평균(1~3년 종합)을 조회하는 쿼리
SELECT 학년, 반, 번호, 이름, avg(성적) 평균 FROM STUDENT_SCORE
group by 학년, 반, 번호, 이름;

# 각 학생의 학년별 평균을 조회하는 쿼리
SELECT 학년, 반, 번호, 이름, `과목 학년`, avg(성적) 평균 FROM STUDENT_SCORE
group by 학생번호, `과목 학년`;

# 각 학생별 평균(학년, 학기별)을 조회하는 쿼리
SELECT 학년, 반, 번호, 이름, `과목 학년`, 학기, avg(성적) 평균 FROM STUDENT_SCORE
group by 학생번호, `과목 학년`, 학기;

# 각 학생의 1학년 평균이 가장 높은 학생을 조회하는 쿼리
SELECT 학년, 반, 번호, 이름, `과목 학년`, avg(성적) 평균 FROM STUDENT_SCORE
WHERE `과목 학년` = 1
group by 학생번호, `과목 학년`
ORDER BY 평균 DESC
LIMIT 1;


/*
 SELECT 속성,...
 FROM 테이블A
 LEFT | RIGHT JOIN 테이블 B ON 테이블A.속성1=테이블B.속성2
	- OUTER 조인은 순서가 중요
    - 왼쪽 테이블을 기준으로 연결
 */
 
 # 모든 과목의 평균을 조회하는 쿼리
 SELECT SUBJECT.*, IFNULL(AVG(SC_SCORE),0) 평균 FROM subject
 LEFT JOIN score ON SJ_NUM = SC_SJ_NUM
 GROUP BY SJ_NUM; # GROUP BY를 적용한 속성이 기본키니까 SUBJECT.*를 조회하려 할 때 오류가 나지 않는거임. 중복될 일이 없으니까 ㅇㅇ
 
# 모든 학생의 학생 평균을 조회하는 쿼리. 성적이 없는 경우는 0이 나오도록 처리
SELECT STUDENT.*, ifnull(AVG(SC_SCORE),0) 평균 from student
LEFT JOIN score ON ST_KEY = SC_ST_KEY
GROUP BY ST_KEY ;

# DB에 등록된 학생수를 조회하는 쿼리
SELECT COUNT(ST_KEY) 학생수 FROM  student.student;


/*
JOIN USING : 테이블B의 외래키와 A의 외래키가 같은 경우(속성이름이)

SELECT * FROM 테이블A JOIN 테이블B ON 테이블B.속성1 = 테이블A.속성1;
SELECT * FROM 테이블A JOIN 테이블B USING(속성1);
*/

/*
서브 쿼리 : 쿼리 안에 쿼리가 들어가는 형태
	- 장점
		- 쿼리의 구조화
        - JOIN보다 가독성 좋음
        - 속도를 향상 시킬 수 있음
		ex) 홍길동이란 사람이 학원에 다니는 아들을 찾으러 옴
			일반 JOIN : 모든 강의장에 있는 학생 중 성이 홍씨인 남자 찾고, 그중에 아들 찾음.
            서브 쿼리 : 각 강의장에서 성이 홍씨고 남자인 학생들을 찾고, 그중에서 아들을 찾음
	
    - 서브쿼리 적용 위치
		1. SELECT문에서 속성 위치
        2. SELECT문에서 FROM 다음에 나오는 테이블명 위치
        3. SELECT문에서 WHERE절에서 특정 값 위치
        4. SELECT문에서 HAVING절에서 특정 값 위치
        5. INSERT SELECT
        6. UPDATE문에서 수정할 값 위치
*/

/*
내장 함수 - 조건
IF(식, 식1, 식2) : 식이 참이면 식1을, 거시이면 식2를 반환
IFNULL(식1, 식2) : 식1이 NULL이면 식2를, 아니면 식1을 반환.
NULLIF(식1, 식2) : 식1과 식2가 같으면 NULL, 다르면 식1을 반환
CASE 속성 WHEN 값 THEN 결과 ELSE 결과 END
  CASE 속성
	WHEN 값
    THEN 결과
    ELSE 값
  END
*/

# 성적이 60이상이면 통과, 60미만이면 실패라고 출력하는 쿼리
SELECT *, IF(SC_SCORE>=60, "통과","실패") AS 통과여부 FROM SCORE;
SELECT *, CASE WHEN SC_SCORE >=60 THEN "O" ELSE "X" END AS 통과 FROM SCORE;

# 성적이 90이상이면 A, 80이상이면 b 70이상이면 C, 60이상이면 D, 60 미만이면 F로 출력하는 쿼리
SELECT SC_SCORE 점수,
CASE 
	WHEN SC_SCORE >=90 THEN "A"
	WHEN SC_SCORE >= 80 THEN "B"
	WHEN SC_SCORE >= 70 THEN "C"
	WHEN SC_SCORE >= 60 THEN "D"
    ELSE "F" 
END AS 학점
FROM SCORE;

SELECT SC_SCORE 점수,
IF (SC_SCORE >=90, "A",
	IF (SC_SCORE >= 80, "B",
		IF (SC_SCORE >= 70, "C",
			IF (SC_SCORE >= 60, "D", "F")
		)
	)
) AS 학점
FROM SCORE;

# 성적이 최고성적과 같으면 NULL, 다르면 성적을 출력하는 쿼리
SELECT SC_SCORE, NULLIF(SC_SCORE, (SELECT MAX(SC_SCORE)FROM SCORE)) AS 결과 FROM SCORE;


#내장함수 - 문자열
#1. CHAR_LENGTH(문자열) : 문자열 개수
SELECT CHAR_LENGTH("너무힘들다") AS CHAR_LENGTH;
#2. LENGTH(문자열) : 바이트 수
SELECT LENGTH("너무힘들다") AS LENGTH;
#3. CONCAT(문자열1, ...) : 문자열을 이어 붙임
SELECT CONCAT("너무","힘","들다") AS CONCAT;
#4. FIELD(찾을문자열, 문자열1, ...) : 찾을 문자열의 위치를 찾아 반환
SELECT FIELD("힘", "너무","힘","들다") AS FIELD;
#5. INSTR(기준문자열, 부분문자열) : 기준 문자열에서 부분 문자열의 위치를 찾아 반환. 위치는 1부터 시작
SELECT INSTR("HELLO SQL", "SQL") AS INSTR;
#6. LOCATE(부분문자열, 기준문자열) : 기준 문자열에서 부분 문자열의 위치를 찾아 반환. 위치는 1부터 시작
#7. FORMAT(숫자, 소수점자리) : 숫자를 소수점이하 자리까지 표현. 1000단위마다 ,를 추가
SELECT FORMAT(10000.123456,2) AS FORMAT;
#8. BIN(숫자), OCT(숫자), HEX(숫자) : 2, 8, 16진수로 변환
SELECT BIN(255)AS BIN, OCT(255) AS OCT, HEX(255) AS HEX;
#9. INSERT(기준문자열, 위치, 길이, 삽입할문자열) : 기준문자열의 위치부터 길이만큼 지우고 삽입할 문자열을 끼움
SELECT INSERT("HELLO SQL", 7, 3, "WORLD") AS `INSERT`;
#10. LEFT(문자열, 길이), RIGHT(문자열, 길이) : 왼쪽/오른쪽에서 문자열의 길이만큼 반환
SELECT LEFT("TEXT.TXT", 4) AS `LEFT`, RIGHT("TEXT.TXT", 3) AS `RIGHT`;
#11. LOWER(문자열), UPPER(문자열) : 소문자로/대문자로
SELECT LOWER("HELLO SQL") AS `LOWER`, UPPER("hello world") AS `UPPER`;
#12. LPAD(문자열, 길이, 채울 문자열)/RPAD(문자열, 길이, 채울문자열) : 문자열을 길이만큼 늘리고 빈곳을 채울문자열로 채움
SELECT LPAD(1,3,"0") AS LPAD, RPAD(1,3,"0") AS RPAD;
#13. REPEAT(문자열, 횟수) : 문자열을 횟수만큼 반복
SELECT REPEAT(1,3) AS `REPEAT`;
#14. REPLACE(문자열, 문자열A, 문자열B) : 문자열에서 문자열A를 문자열B로 바꿈
SELECT REPLACE("HELLO SQL", "SQL", "WORLD") AS `REPLACE`;
#15. REVERSE(문자열) : 문자열 순서를 역순으로 반환
SELECT REVERSE("ABCDEF") AS `REVERSE`;
#16. SUBSTRING(문자열, 시작위치, 길이) : 문자열에서 시작위치에서 길이만큼 부분문자열을 반환
SELECT SUBSTRING("HELLO SQL", 7, 3) AS SUBSTRING;
