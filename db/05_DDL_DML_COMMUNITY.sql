/*
다음을 만족하는 쿼리를 작성해서 데이터베이스와 테이블을 생성하시오
데이터베이스명 : COMMUNITY
테이블명 : BOARD
	- 게시글을 제목, 내용, 작성자를 입력하여 등록한다.
	- 제목은 최대 50자, 내용은 긴 문자열, 작성자는 최대 15자
	- 게시글은 게시글 목록에서 번호, 제목, 작성자, 작성일, 조회수를 확인할 수 있음
    - 작성일은 년,월,일,시,분,초를 확인할 수 있음
*/
-- DROP DATABASE IF EXISTS COMMUNITY;

CREATE DATABASE IF NOT EXISTS COMMUNITY;
use COMMUNITY;

-- drop table IF EXISTS BORAD;
CREATE TABLE IF NOT EXISTS BOARD(
	b_num int primary key auto_increment,
    b_title varchar(50) not null,
    b_content longtext not null,
    b_writer varchar(15) not null,
    b_day DATETIME DEFAULT CURRENT_TIMESTAMP,
    b_view int not null default 0
);

INSERT INTO BOARD(b_title, b_content, b_writer) values("반갑안녕습니다","외않되","마춤뻡파괴자");
-- DELETE from community.board WHERE b_num=2;

select
	b_num as 번호,
    b_title as 제목,
    b_content as 내용,
    b_writer as 작성자,
    b_day as 작성일,
    b_view as 조회수
FROM 
	community.board;
    
# 1번 게시글을 클릭해서 게시글 정보을 조회할 때 필요한 쿼리
# 조회수 증가
update community.board 
set
	b_view = b_view + 1
where
	b_num =1;
# 내용 조회
select * from community.board where b_num =1;


#abc123 회원이 1번 게시글을 삭제할 때 쿼리
-- delete from community.board where b_num =1 and b_writer = "abc123";

select * from community.board;

#2025년 2월 25일에 작성된 게시글을 조회하는 쿼리. 문자열인데도 크기 비교 가능함 ㄷㄷ
 select * from community.board
 where b_day between "2025-02-25" and "2025-02-25 23:59:59";
 
 
 # 제목이나 내용에 "안녕"을 포함하는 게시글을 조회하는 쿼리
select * from community.board
where b_title Like "%안녕%" or b_content Like "%안녕%";

# 번호까지도 초기화 버튼
truncate table community.board;