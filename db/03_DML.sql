# INSERT : 데이터 추가
# SELECT : 데이터 조회
# UPDATE : 데이터 수정
# DELETE : 데이터 삭제

# 데이터 추가
# INSERT INTO 테이블명 VALUE(값1, ..., 값N);
# 	- 값들의 순서는 속성 순서에 맞게 넣어줘야함 -> 그래서 별로 안쓰긴 함
#	- 테이블명 대신 DB명.테이블명으로 해도 됨 -> 선택된 DB와 상관없이 실행
#	- 테이블명만 쓰려면 USE DB명으로 DB를 선택한 후에 사용 -> 테이블명만 쓰면 선택된 DB에 따라 동작되지 않을 수도 있음
use student;
INSERT INTO student VALUE(1, 1, 1, 1, "홍길동"); # 근데 이거 대체키까지도 맞춰줘야됨 Duplicate entry '1' for key 'student.PRIMARY'



# INSERT INTO 테이블명(속성1, ..., 속성N) VALUE(값1, ..., 값N);
# 일부 속성 값을 생략할 때 사용
# 생략할 수 있는 속성들
#	1. null 허용 속성들
#	2. not null이지만 default를 이용하여 기본값을 지정한 속성들
insert into student(st_grade, st_class, st_num, st_name) value(1,1,2,"임꺽정");
insert into student(st_num, st_name) value(3,"고길동");


# INSERT INTO 테이블명(속성1, ..., 속성N) VALUES(값1, ..., 값N), (값1, ..., 값N), ...;
insert into student(st_num, st_name) values(4,"둘리"),(5,"또치"),(6,"희동이");


#INSERT INTO 테이블명 SELECT 값1, 값2, ..., 속성A FROM 테이블명 WHERE 조건
#	- 테이블에서 검색된 값을 이용하여 추가할 때 사용
# 	- 여기서 값1, 값2... 들은 지정된 값이고, 속성 A는 검색 결과 값


# 데이터 수정 ->update는 safeupdates 해제 후에 해야됨
# UPDATE 테이블명 SET 속성1=값1, ..., 속성N=값N WHERE 조건
# 조건에서 같다는 =, 같지 않다는 != 또는 <>
# NULL과 같다는 IS NULL, NULL과 같지 않다는 IS NOT NULL
# 1학년 1반 1번 학생의 이름을 SUN으로 수정하는 쿼리
UPDATE student.student 
SET 
    st_name = '홍길동a'
WHERE
    st_grade = 1 AND st_class = 1 AND st_num = 1;
    
    
# 데이터 삭제
# DELETE FROM 테이블명 WHERE 조건;
# 1학년 1반 2번 학생의 데이터를 삭제하는 쿼리
DELETE FROM student.student 
WHERE
    st_grade = 1 AND st_class = 1
    AND st_num = 2;
    
