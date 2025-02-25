/*
SELECT * FORM 테이블명;
# 테이블에 있는 모든 데이터들을 조회화는 쿼리.
*/
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


# 번호까지도 초기화 버튼
truncate table student.student;