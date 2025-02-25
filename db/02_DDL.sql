# CREAT : 생성 
# ALTER : 수정
# DROP : 삭제
# TRUNCATE : 테이블 초기화

# 데이터베이스 생성
# CREATE DATABASE [IF NOT EXISTS] DB명
# CREATE SCHEMA [IF NOT EXISTS] DB명
# IF NOT EXISTS가 없으면 DB를 생성하려는 경우 쿼리에 에러가 발생
# -> 이후 쿼리를 실행할 수 없음
create database if not exists student;


# 데이터베이스 삭제
# DROP DATABASE [IF EXISTS] DB명
# DROP SCHEMA [IF EXISTS] DB명
-- DROP DATABASE if exists student;


# 데이터베이스 문자 집합을 설정
# ALTER SCHEMA DB명 default character set 새character default collate 새collate

# 테이블 생성
/*
create table [if not exists] 테이블명(
	컬럼명 타입 [zerofill] [unique] [not null] [default 값] [primary key] [auto_increment], ...,
    [ constraint 제약조건명 primary key(컬럼명),]
    [ primary key(컬럼명),]
    [ constraint 제약조건명 foreign key(컬럼명) reference 참조테이블명(기본키명),]
    [ foreign key(컬럼명) reference 참조테이블명(기본키명),]
    [ constraint check(논리식),]
    [ check(논리식),]
);

ZEROFILL : 앞에 0으로 채울 때 사용
	- 5자리 숫자로 정하고, 1을 저장했을 때 앞에 4자리를 0으로 채움 (00001)
    
UNIQUE : 컬럼들의 값들이 중복되면 안되는 경우 지정(보통 대체키에)

NOT NULL : 컬럼이 NULL값을 가지면 안될 때 사용

PRIMARY KEY : 기본키
	- 제약 조건으로 설정할 수도 있지만 컬럼명 옆에 지정할 수 있음
    - NOT NULL + UNIQUE
    
AUTO_INCEMENT : 데이터를 추가할 때 기본키에 값을 지정하지 않으면 자동으로 1증가 되어 추가 됨
	- 기본키에만 가능, 정수형 속성에 지정 가능
*/
USE STUDENT;
CREATE TABLE IF NOT EXISTS STUDENT(
	st_key int primary key auto_increment,
    st_grade int not null default 1,
    st_class int not null default 1,
    st_num int not null default 1,
    st_name varchar(20) not null, #20자 이내 null 허용X
    check(st_grade >=1),
    check(st_class >=1),
    check(st_num >=1)
);


# 테이블 삭제
# DROP TABLE [IF EXISTS] 테이블명;
-- DROP TABLE STUDENT;

# 테이블 수정 - 컬럼 추가
# ALTER TABLE 테이블명 ADD 컬럼명 타입[...];
-- ALTER TABLE STUDENT ADD st_test DATETIME DEFAULT CURRENT_TIMESTAMP;


# 테이블 수정 - 컬럼 수정
# ALTER TABLE 테이블명 CHANGE 기존컬럼명 새컬럼명 타입[...];
-- ALTER TABLE STUDENT change st_test test char(3) not null;


# 테이블 수정 - 컬럼 삭제
# ALTER TABLE STUDENT DROP 컬럼명;
-- ALTER TABLE STUDENT DROP st_test;

# 등록된 모든 check 제약 조건 확인
SELECT * FROM information_schema.check_constraints;

# 테이블 수정 - 제약 조건 추가
# ALTER table 테이블명 add constraint 제약조건명 제약조건
alter table student add constraint student_ch4 check(st_name !='');

# 테이블 수정 - 제약 조건 삭제
# ALTER table 테이블명 drop constraint 제약조건명
alter table student drop constraint student_ch4;

# 테이블 초기화 : AUTO_INCREMENT 값을 1로 초기화 및 데이터 제거
# truncate table 테이블명


INSERT INTO student (st_grade, st_class, st_num, st_name)
values(1,1,3,"홍길동"), (1,1,4,"임꺽정");

select * from student.student;
truncate table student;

INSERT INTO student (st_grade, st_class, st_num, st_name)
values(1,1,1,"홍길동"), (1,1,2,"임꺽정");
select * from student.student;
