### 학과 등록
## 컴퓨터공학를 등록. 학과코드 : COM, 학과코드번호 : 160, 학과사무실 : KH 1관 401호
INSERT INTO department(DE_NUM, DE_NAME, DE_OFFICE, DE_NAME_NUM) VALUES
("COM", "컴퓨터공학", "KH 1관 401호", 160);
## 디자인공학을 등록. 학과코드 : DEG, 학과코드번호 : 123, 학과사무실 : KH 3관 101호
INSERT INTO department(DE_NUM, DE_NAME, DE_OFFICE, DE_NAME_NUM) VALUES
("DEG", "디자인공학", "KH 3관 101호", 123);
## 기계공학을 등록. 학과코드 : MEC, 학과코드번호 : 456, 학과사무실 : KH 4관 201호
INSERT INTO department VALUES
("MEC", "기계공학", "KH 4관 201호", 456, null);


### 교수 등록
## 이름 : 홍교수, 연락처 : 012-1234-5678, 주민번호 : 600111-1, 취임연도 2000, 전공 : 컴퓨터공학과
INSERT INTO professor
SELECT 
	CONCAT("P", 2000, DE_NAME_NUM, LPAD(COUNT(PR_NUM)+1, 3, "0")),
    "홍교수","012-1234-5678", "600111-1", 2000, DE_NUM
FROM 
	(SELECT * FROM professor WHERE PR_YEAR = 2000) P
RIGHT JOIN 
	department ON DE_NUM = PR_DE_NUM
WHERE 
	DE_NAME = "컴퓨터공학";



## 이름 : 김교수, 연락처 : 012-1111-5555, 주민번호 : 630101-2, 취임연도 2000, 전공 : 컴퓨터공학과
INSERT INTO professor
SELECT 
	CONCAT("P", 2000, DE_NAME_NUM, LPAD(COUNT(PR_NUM)+1, 3, "0")),
    "김교수", "012-1111-5555", "630101-2", 2000, DE_NUM
FROM 
	(SELECT * FROM professor WHERE PR_YEAR = 2000) P
RIGHT JOIN 
	department ON DE_NUM = PR_DE_NUM
WHERE 
	DE_NAME = "컴퓨터공학";


## 이름 : 박교수, 연락처 : 012-7788-4455, 주민번호 : 670331-1, 취임연도 2005, 전공 : 디자인공학과
INSERT INTO professor
SELECT 
	CONCAT("P", 2005, DE_NAME_NUM, LPAD(COUNT(PR_NUM)+1, 3, "0")),
    "박교수", "012-7788-4455", "670331-1", 2005, DE_NUM
FROM 
	(SELECT * FROM professor WHERE PR_YEAR = 2005) P
RIGHT JOIN 
	department ON DE_NUM = PR_DE_NUM
WHERE 
	DE_NAME = "디자인공학";


## 이름 : 이교수, 연락처 : 012-7781-4451, 주민번호 : 701231-2, 취임연도 2010, 전공 : 디자인공학과
INSERT INTO professor
SELECT 
	CONCAT("P", 2010, DE_NAME_NUM, LPAD(COUNT(PR_NUM)+1, 3, "0")),
    "이교수", "012-7781-4451", "701231-2", 2010, DE_NUM
FROM 
	(SELECT * FROM professor WHERE PR_YEAR = 2010) P
RIGHT JOIN 
	department ON DE_NUM = PR_DE_NUM
WHERE 
	DE_NAME = "디자인공학";
    
    
## 이름 : 최교수, 연락처 : 012-3333-4444, 주민번호 : 650101-1, 취임연도 2005, 전공 : 기계공학과
INSERT INTO professor
SELECT 
	CONCAT("P", 2005, 456, LPAD(COUNT(PR_NUM)+1, 3, "0")),
    "최교수", "012-3333-4444", "650101-1", 2005, "MEC"
FROM 
	(SELECT * FROM professor WHERE PR_YEAR = 2005) P
RIGHT JOIN 
	department ON DE_NUM = PR_DE_NUM
WHERE 
	DE_NAME = "기계공학";
    
    
## 이름 : 최교수, 연락처 : 012-4567-4444, 주민번호 : 750101-1, 취임연도 2020, 전공 : 기계공학과
INSERT INTO professor
SELECT 
	CONCAT("P", 2020, 456, LPAD(COUNT(PR_NUM)+1, 3, "0")),
    "최교수", "012-4567-4444", "750101-1", 2020, "MEC"
FROM 
	(SELECT * FROM professor WHERE PR_YEAR = 2020) P
RIGHT JOIN 
	department ON DE_NUM = PR_DE_NUM
WHERE 
	DE_NAME = "기계공학";
    
    
### 최종 합격 명단
# 이름 : 홍길동, 연락처 : 013-1234-5678, 입학년도 : 2025, 주민번호 : 060603-3, 전공 : 컴퓨터공학과
# 이름 : 고길동, 연락처 : 013-1111-5222, 입학년도 : 2025, 주민번호 : 060403-3, 전공 : 컴퓨터공학과
# 이름 : 김길동, 연락처 : 013-1234-5678, 입학년도 : 2025, 주민번호 : 060503-3, 전공 : 컴퓨터공학과
# 이름 : 하니, 연락처 : 013-1111-5223, 입학년도 : 2025, 주민번호 : 060503-4, 전공 : 컴퓨터공학과
INSERT INTO final_pass(FP_NAME, FP_PHONE, FP_YEAR, FP_RES_NUM, FP_DE_NUM) VALUES
("홍길동", "013-1234-5678", 2025, "060603-3", "COM"),
("고길동", "013-1111-5222", 2025, "060403-3", "COM"),
("김길동", "013-1234-5678", 2025, "060503-3", "COM"),
("하니", "013-1111-5223", 2025, "060503-4", "COM");

# 이름 : 나애리, 연락처 : 013-1234-4444, 입학년도 : 2025, 주민번호 : 060603-4, 전공 : 디자인공학과
# 이름 : 오영심, 연락처 : 013-1234-5555, 입학년도 : 2025, 주민번호 : 060703-4, 전공 : 디자인공학과
# 이름 : 오두리, 연락처 : 013-1234-6666, 입학년도 : 2025, 주민번호 : 060803-4, 전공 : 디자인공학과
# 이름 : 전지현, 연락처 : 013-1234-7777, 입학년도 : 2025, 주민번호 : 050903-4, 전공 : 디자인공학과
INSERT INTO final_pass(FP_NAME, FP_PHONE, FP_YEAR, FP_RES_NUM, FP_DE_NUM) VALUES
("나애리", "013-1234-4444", 2025, "060603-4", "DEG"),
("오영심", "013-1234-5555", 2025, "060703-4", "DEG"),
("오두리", "013-1234-6666", 2025, "060803-4", "DEG"),
("전지현", "013-1234-7777", 2025, "060903-4", "DEG");

# 이름 : 김둘리, 연락처 : 013-1111-2222, 입학년도 : 2025, 주민번호 : 060604-3, 전공 : 기계공학과
# 이름 : 김군, 연락처 : 013-1111-3333, 입학년도 : 2025, 주민번호 : 070604-3, 전공 : 기계공학과
# 이름 : 박명수, 연락처 : 013-1111-4444, 입학년도 : 2025, 주민번호 : 060609-3, 전공 : 기계공학과
# 이름 : 유재석, 연락처 : 013-1111-5555, 입학년도 : 2025, 주민번호 : 060610-3, 전공 : 기계공학과
INSERT INTO final_pass(FP_NAME, FP_PHONE, FP_YEAR, FP_RES_NUM, FP_DE_NUM) VALUES
("김둘리", "013-1111-2222", 2025, "060604-3", "MEC"),
("김군", "013-1111-3333", 2025, "070604-3", "MEC"),
("박명수", "013-1111-4444", 2025, "060609-3", "MEC"),
("유재석", "013-1111-5555", 2025, "060610-3", "MEC");


## 최종 합격한 컴퓨터공학과 학생들을 학생으로 등록하는 쿼리
INSERT INTO student
SELECT 
	CONCAT(FP_YEAR, DE_NAME_NUM, LPAD(RANK() OVER(ORDER BY FP_NAME, FP_RES_NUM),3,"0")) AS ST_NUM,  
    FP_NAME, 
    FP_RES_NUM,
    FP_PHONE, 
    FP_YEAR,
    DE_NUM,
    NULL
FROM final_pass 
JOIN department ON FP_DE_NUM = DE_NUM
WHERE DE_NAME ="컴퓨터공학" AND FP_YEAR = YEAR(NOW());

## 최종 합격한 디자인공학과 학생들을 학생으로 등록하는 쿼리
INSERT INTO student
SELECT 
	CONCAT(FP_YEAR, DE_NAME_NUM, LPAD(RANK() OVER(ORDER BY FP_NAME, FP_RES_NUM),3,"0")) AS ST_NUM,  
    FP_NAME, 
    FP_RES_NUM,
    FP_PHONE, 
    FP_YEAR,
    DE_NUM,
    NULL
FROM final_pass 
JOIN department ON FP_DE_NUM = DE_NUM
WHERE DE_NAME ="디자인공학" AND FP_YEAR = YEAR(NOW());

## 최종 합격한 기계공학과 학생들을 학생으로 등록하는 쿼리
INSERT INTO student
SELECT 
	CONCAT(FP_YEAR, DE_NAME_NUM, LPAD(RANK() OVER(ORDER BY FP_NAME, FP_RES_NUM),3,"0")) AS ST_NUM,  
    FP_NAME, 
    FP_RES_NUM,
    FP_PHONE, 
    FP_YEAR,
    DE_NUM,
    NULL
FROM final_pass 
JOIN department ON FP_DE_NUM = DE_NUM
WHERE DE_NAME ="기계공학" AND FP_YEAR = YEAR(NOW());


## 과목분류를 등록하는 쿼리
# 학과 코드 등록
INSERT INTO subjcet_category SELECT DE_NUM FROM department;
INSERT INTO subjcet_category VALUE ("MSC"),("CUL"),("TEA");

## 과목을 등록하는 쿼리
# 과목명 : 컴퓨터 개론, 학점 : 2, 시간 : 2, 분류 : COM, 과목코드 : COM001
INSERT INTO `subject`(SJ_NAME, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "컴퓨터 개론", 2, 2, CONCAT("COM", LPAD(COUNT(SJ_NUM)+1,3,"0")), "COM" FROM `subject` WHERE SJ_SC_CODE = "COM";
# 과목명 : 프로그래밍 언어, 학점 : 3, 시간 : 3, 분류 : COM, 과목코드 : COM002
INSERT INTO `subject`(SJ_NAME, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "프로그래밍 언어", 3, 3, CONCAT("COM", LPAD(COUNT(SJ_NUM)+1,3,"0")), "COM" FROM `subject` WHERE SJ_SC_CODE = "COM";
# 과목명 : 알고리즘, 학점 : 3, 시간 : 3, 분류 : COM, 과목코드 : COM003
INSERT INTO `subject`(SJ_NAME, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "알고리즘", 3, 3, CONCAT("COM", LPAD(COUNT(SJ_NUM)+1,3,"0")), "COM" FROM `subject` WHERE SJ_SC_CODE = "COM";

# 과목명 : 확률과 통계, 학점 : 3, 시간 : 3, 분류 : MSC, 과목코드 : MSC001
INSERT INTO `subject`(SJ_NAME, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "확률과 통계", 3, 3, CONCAT("MSC", LPAD(COUNT(SJ_NUM)+1,3,"0")), "MSC" FROM `subject` WHERE SJ_SC_CODE = "MSC";
# 과목명 : 미분과 적분, 학점 : 4, 시간 : 4, 분류 : MSC, 과목코드 : MSC002
INSERT INTO `subject`(SJ_NAME, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "미분과 적분", 4, 4, CONCAT("MSC", LPAD(COUNT(SJ_NUM)+1,3,"0")), "MSC" FROM `subject` WHERE SJ_SC_CODE = "MSC";

# 과목명 : 영어1, 학점 : 3, 시간 : 3, 분류 : CUL, 과목코드 : CUL001
INSERT INTO `subject`(SJ_NAME, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "영어1", 3, 3, CONCAT("CUL", LPAD(COUNT(SJ_NUM)+1,3,"0")), "CUL" FROM `subject` WHERE SJ_SC_CODE = "CUL";
# 과목명 : 음악과 감상, 학점 : 2, 시간 : 2, 분류 : CUL, 과목코드 : CUL002
INSERT INTO `subject`(SJ_NAME, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "음악과 감상", 2, 2, CONCAT("CUL", LPAD(COUNT(SJ_NUM)+1,3,"0")), "CUL" FROM `subject` WHERE SJ_SC_CODE = "CUL";


# 과목명 : 교육학 개론, 학점 : 2, 시간 : 3, 분류 : TEA, 과목코드 : TEA001
INSERT INTO `subject`(SJ_NAME, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "교육학 개론", 2, 3, CONCAT("TEA", LPAD(COUNT(SJ_NUM)+1,3,"0")), "TEA" FROM `subject` WHERE SJ_SC_CODE = "TEA";
# 과목명 : 교육 방법론, 학점 : 3, 시간 : 3, 분류 : TEA, 과목코드 : TEA002
INSERT INTO `subject`(SJ_NAME, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "교육 방법론", 3, 3, CONCAT("TEA", LPAD(COUNT(SJ_NUM)+1,3,"0")), "TEA" FROM `subject` WHERE SJ_SC_CODE = "TEA";



# 과목명 : 디자인의 이해, 학점 : 2, 시간 : 2, 분류 : DEG, 과목코드 : DEG001
INSERT INTO `subject`(SJ_NAME, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "디자인의 이해", 2, 2, CONCAT("DEG", LPAD(COUNT(SJ_NUM)+1,3,"0")), "DEG" FROM `subject` WHERE SJ_SC_CODE = "DEG";
# 과목명 : 시각 디자인, 학점 : 3, 시간 : 3, 분류 : DEG, 과목코드 : DEG002
INSERT INTO `subject`(SJ_NAME, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "시각 디자인", 3, 3, CONCAT("DEG", LPAD(COUNT(SJ_NUM)+1,3,"0")), "DEG" FROM `subject` WHERE SJ_SC_CODE = "DEG";
# 과목명 : 제품 디자인, 학점 : 3, 시간 : 3, 분류 : DEG, 과목코드 : DEG003
INSERT INTO `subject`(SJ_NAME, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "제품 디자인", 3, 3, CONCAT("DEG", LPAD(COUNT(SJ_NUM)+1,3,"0")), "DEG" FROM `subject` WHERE SJ_SC_CODE = "DEG";

# 과목명 : 프로그래밍 언어, 학점 : 3, 시간 : 3, 분류 : MEC, 과목코드 : MEC001
INSERT INTO `subject`(SJ_NAME, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "프로그래밍 언어", 3, 3, CONCAT("MEC", LPAD(COUNT(SJ_NUM)+1,3,"0")), "MEC" FROM `subject` WHERE SJ_SC_CODE = "MEC";
# 과목명 : 동역학, 학점 : 3, 시간 : 3, 분류 : MEC, 과목코드 : MEC002
INSERT INTO `subject`(SJ_NAME, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "동역학", 3, 3, CONCAT("MEC", LPAD(COUNT(SJ_NUM)+1,3,"0")), "MEC" FROM `subject` WHERE SJ_SC_CODE = "MEC";
# 과목명 : 기계의 이해, 학점 : 3, 시간 : 3, 분류 : MEC, 과목코드 : MEC003
INSERT INTO `subject`(SJ_NAME, SJ_POINT, SJ_TIME, SJ_CODE, SJ_SC_CODE)
SELECT "기계의 이해", 3, 3, CONCAT("MEC", LPAD(COUNT(SJ_NUM)+1,3,"0")), "MEC" FROM `subject` WHERE SJ_SC_CODE = "MEC";

## 강의 등록
# 강의명 : 컴퓨터 개론(1), 2025, 학기 : 1, 강의실 : KH 1관 501호, 분반 : 1, 정원 : 30, 강의 계획서 : 없음, 교수 : 홍교수(P2000160001),
# 시간 월1A, 월1B, 월2A, 월2B
INSERT INTO lecture(LE_YEAR, LE_SEMESTER, LE_CLASS_ROOM, LE_PLAN, LE_CLASS, LE_MAX, LE_SJ_NUM, LE_PR_NUM) VALUES
(2025, "1", "KH 1관 501호", "없음", 1, 30, 1, "P2000160001");
INSERT INTO lecture_schedule(LC_LE_NUM, LC_DAY, LC_TIME, LC_MINUTE) VALUES
(1,"월","1","A"),(1,"월","1","B"),(1,"월","2","A"),(1,"월","2","B");

# 강의명 : 프로그래밍 언어(2), 2025, 학기 : 1, 강의실 : KH 1관 501호, 분반 : 1, 정원 : 30, 강의 계획서 : 없음, 교수 : 홍교수(P2000160001),
# 시간 월4A, 월4B, 월5A, 수4A, 수4B, 수5A
INSERT INTO lecture(LE_YEAR, LE_SEMESTER, LE_CLASS_ROOM, LE_PLAN, LE_CLASS, LE_MAX, LE_SJ_NUM, LE_PR_NUM) VALUES
(2025, "1", "KH 1관 501호", "없음", 1, 30, 2, "P2000160001");
INSERT INTO lecture_schedule(LC_LE_NUM, LC_DAY, LC_TIME, LC_MINUTE) VALUES
(2,"월","4","A"),(2,"월","4","B"),(2,"월","5","A"),(2,"수","4","A"),(2,"수","4","B"),(2,"수","5","A");

# 강의명 : 프로그래밍 언어(2), 2025, 학기 : 1, 강의실 : KH 1관 502호, 분반 : 2, 정원 : 30, 강의 계획서 : 없음, 교수 : 김교수(P2000160002),
# 시간 월4A, 월4B, 월5A, 수4A, 수4B, 수5A
INSERT INTO lecture(LE_YEAR, LE_SEMESTER, LE_CLASS_ROOM, LE_PLAN, LE_CLASS, LE_MAX, LE_SJ_NUM, LE_PR_NUM) VALUES
(2025, "1", "KH 1관 502호", "없음", 2, 30, 2, "P2000160002");
INSERT INTO lecture_schedule(LC_LE_NUM, LC_DAY, LC_TIME, LC_MINUTE) VALUES
(3,"월","4","A"),(3,"월","4","B"),(3,"월","5","A"),(3,"수","4","A"),(3,"수","4","B"),(3,"수","5","A");

# 강의명 : 알고리즘(3), 2025, 학기 : 1, 강의실 : KH 1관 502호, 분반 : 1, 정원 : 30, 강의 계획서 : 없음, 교수 : 김교수(P2000160002),
# 시간 목1A, 목1B, 목2A, 목2B, 목3A, 목3B
INSERT INTO lecture(LE_YEAR, LE_SEMESTER, LE_CLASS_ROOM, LE_PLAN, LE_CLASS, LE_MAX, LE_SJ_NUM, LE_PR_NUM) VALUES
(2025, "1", "KH 1관 502호", "없음", 1, 30, 3, "P2000160002");
INSERT INTO lecture_schedule(LC_LE_NUM, LC_DAY, LC_TIME, LC_MINUTE) VALUES
(4,"목","1","A"),(4,"목","1","B"),(4,"목","2","A"),(4,"목","2","B"),(4,"목","3","B"),(4,"목","3","A");


# 강의명 : 확률과 통계(4), 2025,학기 : 1,강의실 : KH 3관 501호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 김교수(P2000160002)
# 시간 : 화1A, 화1B, 화2A, 금1A,금1B,금2A
INSERT INTO lecture(LE_YEAR, LE_SEMESTER, LE_CLASS_ROOM, LE_PLAN, LE_CLASS, LE_MAX, LE_SJ_NUM, LE_PR_NUM) VALUES
(2025, "1", "KH 3관 501호", "없음", 1, 30, 4, "P2000160002");
INSERT INTO lecture_schedule(LC_LE_NUM, LC_DAY, LC_TIME, LC_MINUTE) VALUES
(5,"화","1","A"),(5,"화","1","B"),(5,"화","2","A"),(5,"금","1","A"),(5,"금","1","B"),(5,"금","2","A");


# 강의명 : 미분과 적분(5), 2025,학기 : 1,강의실 : KH 3관 502호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 홍교수(P2000160001)
# 시간 : 화1A, 화1B, 화2A, 금1A,금1B,금2A
INSERT INTO lecture(LE_YEAR, LE_SEMESTER, LE_CLASS_ROOM, LE_PLAN, LE_CLASS, LE_MAX, LE_SJ_NUM, LE_PR_NUM) VALUES
(2025, "1", "KH 3관 502호", "없음", 1, 30, 5, "P2000160001");
INSERT INTO lecture_schedule(LC_LE_NUM, LC_DAY, LC_TIME, LC_MINUTE) VALUES
(6,"화","1","A"),(6,"화","1","B"),(6,"화","2","A"),(6,"금","1","A"),(6,"금","1","B"),(6,"금","2","A");

# 강의명 : 영어1(6), 2025,학기 : 1,강의실 : KH 2관 501호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 이교수(P2010123001)
# 시간 : 화1A, 화1B, 화2A, 금1A,금1B,금2A
INSERT INTO lecture(LE_YEAR, LE_SEMESTER, LE_CLASS_ROOM, LE_PLAN, LE_CLASS, LE_MAX, LE_SJ_NUM, LE_PR_NUM) VALUES
(2025, "1", "KH 2관 502호", "없음", 1, 30, 6, "P2010123001");
INSERT INTO lecture_schedule(LC_LE_NUM, LC_DAY, LC_TIME, LC_MINUTE) VALUES
(7,"화","1","A"),(7,"화","1","B"),(7,"화","2","A"),(7,"금","1","A"),(7,"금","1","B"),(7,"금","2","A");

# 강의명 : 음악감상(7), 2025,학기 : 1,강의실 : KH 2관 502호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 최교수(P2020456001)
# 시간 : 월6A,월6B,월7A,월7B,월8A,월8B
INSERT INTO lecture(LE_YEAR, LE_SEMESTER, LE_CLASS_ROOM, LE_PLAN, LE_CLASS, LE_MAX, LE_SJ_NUM, LE_PR_NUM) VALUES
(2025, "1", "KH 2관 502호", "없음", 1, 30, 7, "P2020456001");
INSERT INTO lecture_schedule(LC_LE_NUM, LC_DAY, LC_TIME, LC_MINUTE) VALUES
(8,"월","6","A"),(8,"월","6","B"),(8,"월","7","A"),(8,"월","7","B"),(8,"월","8","A"),(8,"월","8","B");

# 강의명 : 교육학 개론(8), 2025,학기 : 1,강의실 : KH 4관 501호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 최교수(P2005456001)
# 시간 : 화1A,화1B,화2A,화2B,화3A,화3B
INSERT INTO lecture(LE_YEAR, LE_SEMESTER, LE_CLASS_ROOM, LE_PLAN, LE_CLASS, LE_MAX, LE_SJ_NUM, LE_PR_NUM) VALUES
(2025, "1", "KH 4관 501호", "없음", 1, 30, 8, "P2005456001");
INSERT INTO lecture_schedule(LC_LE_NUM, LC_DAY, LC_TIME, LC_MINUTE) VALUES
(9,"화","1","A"),(9,"화","1","B"),(9,"화","2","A"),(9,"화","2","B"),(9,"화","3","A"),(9,"화","3","B");

# 강의명 : 교육 방법론(9), 2025,학기 : 1,강의실 : KH 4관 502호, 분반 : 1, 정원 : 30,강의계획서 : 없음,교수 : 박교수(P2005123001)
# 시간 : 화1A,화1B,화2A,화2B,화3A,화3B
INSERT INTO lecture(LE_YEAR, LE_SEMESTER, LE_CLASS_ROOM, LE_PLAN, LE_CLASS, LE_MAX, LE_SJ_NUM, LE_PR_NUM) VALUES
(2025, "1", "KH 4관 502호", "없음", 1, 30, 9, "P2005123001");
INSERT INTO lecture_schedule(LC_LE_NUM, LC_DAY, LC_TIME, LC_MINUTE) VALUES
(10,"화","1","A"),(10,"화","1","B"),(10,"화","2","A"),(10,"화","2","B"),(10,"화","3","A"),(10,"화","3","B");