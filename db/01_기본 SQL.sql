# 주석
-- 주석
/* 여러줄 주석 */ 

# 데이터베이스 목록 확인
show databases;

# 데이터베이스 선택 # 워크벤치에서 데이터베이스를 더블 클릭 => 왼쪽 네이게이터보면 해당 db가 두꺼운 글자색으로 변경됨
# use db명
use world;

# 선택된 데이터베이스에 있는 테이블 목록 확인
show tables;

# 테이블 정보 확인
# EXPLAIN 테이블명
# DESC 테이블명
explain city;
desc city;