SELECT * FROM LECTURE JOIN SUBJECT ON LE_SJ_NUM = SJ_NUM;

# 둘이 같은 기능
SELECT lecture_schedule.* FROM university.lecture_schedule
JOIN lecture ON LC_LE_NUM = LE_NUM
JOIN subject ON LE_SJ_NUM = SJ_NUM
WHERE SJ_NAME = "교육 방법론" AND LE_CLASS = 1;

SELECT * FROM university.lecture_schedule
WHERE LC_LE_NUM = 10;


# 컴공 학생들의 전공 수업 강의을 조회하는 쿼리
SELECT 
	SJ_NAME 강의명, LE_CLASS_ROOM 강의실, SJ_POINT 학점, SJ_TIME 시간, LE_CLASS 분반, LE_MAX 정원
FROM lecture
JOIN subject ON LE_SJ_NUM = SJ_NUM
WHERE SJ_SC_CODE = (SELECT DE_NUM FROM department WHERE DE_NAME = "컴퓨터공학");

## 홍교수(P2000160001)가 강의하는 강의들을 조회하는 쿼리
SELECT 
	SJ_NAME 강의명, LE_CLASS_ROOM 강의실, SJ_POINT 학점, SJ_TIME 시간, LE_CLASS 분반, LE_MAX 정원
FROM lecture
JOIN subject ON LE_SJ_NUM = SJ_NUM
WHERE LE_PR_NUM = "P2000160001";

SELECT 
	SJ_NAME 강의명, LE_CLASS_ROOM 강의실, SJ_POINT 학점, SJ_TIME 시간, LE_CLASS 분반, LE_MAX 정원
FROM lecture
JOIN subject ON LE_SJ_NUM = SJ_NUM
JOIN professor ON LE_PR_NUM = PR_NUM
WHERE PR_NAME = "홍교수";

SELECT 
	SJ_NAME 강의명, LE_CLASS_ROOM 강의실, SJ_POINT 학점, SJ_TIME 시간, LE_CLASS 분반, LE_MAX 정원
FROM lecture
JOIN subject ON LE_SJ_NUM = SJ_NUM
WHERE LE_PR_NUM = (SELECT PR_NUM FROM professor WHERE PR_NAME = "홍교수");

## 고길동(2025160001) 학생이 수강 신청한 목록
SELECT CO_NUM " ",SJ_NAME 강의명, LE_CLASS_ROOM 강의실 FROM course
JOIN lecture ON CO_LE_NUM = LE_NUM
JOIN student ON CO_ST_NUM = ST_NUM
JOIN subject ON LE_SJ_NUM = SJ_NUM
WHERE ST_NAME = "고길동";

SELECT subject.*, lecture.*  
FROM course
JOIN lecture ON CO_LE_NUM = LE_NUM # 강의를 알아야 하고
JOIN subject ON LE_SJ_NUM = SJ_NUM # 강의 이름까지 알아내기
WHERE CO_ST_NUM = "2025160001";

# 고길동(2025160001) 학생이 컴퓨터개론(1), 프로그래밍 언어(2), 확률과 통계(5), 음악과 감상(8)을 수강 신청했을 때 쿼리
INSERT INTO course(CO_ST_NUM, CO_LE_NUM) VALUES
("2025160001",1),("2025160001",2),("2025160001",5),("2025160001",8);

# 각 강의별 수간신청 인원수를 조회하는 쿼리(이건 내가 짠 쿼리라 강사님꺼 답 원하면 깃에서 보셈)
SELECT subject.*,lecture.*, COUNT(CO_LE_NUM) 인원수 FROM subject
LEFT JOIN lecture ON LE_SJ_NUM = SJ_NUM
LEFT JOIN course ON CO_LE_NUM = LE_NUM 
WHERE LE_YEAR IS NOT NULL
GROUP BY SJ_NAME, CO_LE_NUM
;