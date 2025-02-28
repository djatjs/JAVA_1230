# 프로시저 : 일련의 쿼리를 하나의 함수처럼 실행하기 위한 쿼리의 집합
# 프로시저 목록 확인

 SHOW PROCEDURE STATUS;
 # 프로시저 스크립트 확인
 # SAKILA DB에 있는 FILM_IN_STOCK 프로시저 확인
 -- use sakila;
 # CREATE PROCEDURE에 있는 내용이 프로시저 스크립트
--  SHOW CREATE PROCEDURE film_in_stock;
 
 /*
프로시저 삭제
DROP PROCEDURE IF EXISTS 프로시저명;
 
프로시저 정의
DELIMITER 기호
CREATE PROCEDURE 프로시저명(
	[IN|OUT|INOUT 변수명1 타입,]
	[...]
)
BEGIN
	프로시저 구현;
END 기호
DELIMITER;

- 설명
DELIMITER 
	- 문장의 끝을 나타내는 기호를 정할 때 사용
	- 사용하는 이유 : 프로시저 안에 사용되는 ;이 프로시저를 정의하는 동안 실행되면 안되기 때문에,
				  프로시저를 정의하는 동안에 ;이 문장의 끝을 나타내는 기호가 아닌것처럼 사용하기 위해.

IN : 매개변수처럼 값을 프로시저 안에서 사용
OUT : 프로시저 안에서 나온 결과를 넘길 때 사용
INOUT : 매개변수처럼 값을 가져와서 프로시저에서 사용하고 결과를 받아서 밖에서 사용

프로시저 호출
CALL 프로시저명(매개변수 또는 값들)

 */
# 학생 성적을 추가할 때 성적 0미만, 100초과면 추가하지 않는 프로시저
DROP PROCEDURE IF EXISTS INSERT_SCORE;

DELIMITER //
CREATE PROCEDURE INSERT_SCORE(
	IN _ST_KEY INT,
    IN _SJ_NUM INT,
    IN _SCORE INT
)
BEGIN
	IF _SCORE BETWEEN 0 AND 100 THEN
		INSERT INTO SCORE(SC_ST_KEY, SC_SJ_NUM, SC_SCORE) VALUES (_ST_KEY, _SJ_NUM, _SCORE);
    END IF;
END //
DELIMITER ;

-- CALL INSERT_SCORE(16,7,70);
-- CALL INSERT_SCORE(16,8,120);


# 프로시저 예제
DROP PROCEDURE IF EXISTS P_TEST1;

DELIMITER //
CREATE PROCEDURE P_TEST1(
	IN _NUM INT,
    OUT _RES INT
)
BEGIN
	SET _RES = _NUM *2;
END //
DELIMITER ;


SET @VALUE = 3; # VALUE라는 변수 만듦. 3은 뭐.. 안쓰여서 의미없긴함 여기선
CALL P_TEST1(10, @VALUE);
SELECT @VALUE;


/*
프로시서에서 사용하는 문법
1. 변수 선언
	- 변수는 프로시저 시작 위치에 모아 놔야함. 중간에 선언할 수 없음
Declare 변수명 자료형 [default 초기값];

2. 검색 결과를 변수에 저장
변수 = (SELECTE 속성 FROM 테이블명 [WHERE ...]); # sql에서는 이게 비교 연산자. 대입할거면 set을 앞에 붙여야함

3. 조건문 - IF
IF 조건식 THEN
	실행문;
ELSEIF 조건식 THEN
	실행문;
ELSE
	실행문;
END IF;

4. 조건문 - CASE
CASE 변수
	WHEN 값 THEN
		실행문;
	WHEN 값 THEN
		실행문;
	ELSE
		실행문;
END CASE;

5. 반복문 - WHILE
WHILE 조건식 DO
	실행문;
END WHILE;

6. 반복문 - REFEAT
REFEAT
	실행문;
UNTIL 조건식
END REFEAT;

7. 반복문 - CURSOR
- 검색 결과를 반복문으로 활용할 때
DECLARE 변수명A BOOLEAN DEFAULT FALSE;
DECLARE 커서명 CURSOR FOR SELECT 속성1, ...  FROM 테이블명;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET 변수명A = TRUE;
OPEN 커서명;
루프명 : LOOP
FETCH 커서명 INTO 변수명1, ...;

IF 변수명A THEN
	LEAVE 루프명;
END IF;
반복문 실행문;
END LOOP;
CLOSE 커서명;
*/
# AVERAGE 테이블에 등록된 학생만큼 1학년 1학기~3학년 2학기 평균 초기 데이터를 추가하는 프로시저 

DROP PROCEDURE IF EXISTS INIT_AVERAGE;

DELIMITER //
CREATE PROCEDURE INIT_AVERAGE()
BEGIN
	DECLARE _COUNT INT;
    DECLARE _DONE BOOLEAN DEFAULT FALSE;
    DECLARE _ST_KEY INT;
    DECLARE _GRADE INT DEFAULT 1;
    DECLARE _SEMESTER INT DEFAULT 1;
    
    DECLARE _CURSOR CURSOR FOR SELECT ST_KEY FROM STUDENT;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET _DONE = TRUE;
    
    
    
    SET _COUNT = (SELECT COUNT(*) FROM AVERAGE);
	
    IF _COUNT = 0 THEN
		OPEN _CURSOR;
		CURSOR_LOOP : LOOP 
			
			FETCH _CURSOR INTO _ST_KEY;
			SET _GRADE = 1;
            IF _DONE THEN
				LEAVE CURSOR_LOOP;
			END IF;
            
            WHILE _GRADE <= 3 DO
				REPEAT
					INSERT AVERAGE(AV_ST_KEY, AV_GRADE, AV_SEMESTER, AV_SUM, AV_COUNT)
                    VALUES(_ST_KEY, _GRADE, _SEMESTER, 0, 0);
                    SET _SEMESTER = _SEMESTER + 1;
                UNTIL _SEMESTER > 2
                END REPEAT;
                SET _SEMESTER = 1;
                SET _GRADE = _GRADE + 1;
            END WHILE;
        END LOOP;
        CLOSE _CURSOR;
    END IF;
    
END //
DELIMITER ;
CALL INIT_AVERAGE();

# AVERAGE 테이블에 SUM과 COUNT를 모두 0으로 초기화 
DROP PROCEDURE IF EXISTS ZERO_SUM_COUNT;

DELIMITER //
CREATE PROCEDURE ZERO_SUM_COUNT()
BEGIN
	UPDATE AVERAGE SET AV_SUM = 0, AV_COUNT = 0;
END //
DELIMITER ;
CALL ZERO_SUM_COUNT();














# SCORE 테이블에 있는 학생 성적 들을 이용하여 AVERAGE 테이블에 SUM과 COUNT를 계산하는 프로시저
DROP PROCEDURE IF EXISTS CALC_AVERAGE;

DELIMITER //
CREATE PROCEDURE CALC_AVERAGE()
BEGIN

    DECLARE _DONE BOOLEAN DEFAULT FALSE;
    DECLARE _SC_ST_KEY INT;
    DECLARE _SC_SCORE INT;
    DECLARE _SJ_GRADE INT;
    DECLARE _SJ_SEMESTER INT;

    DECLARE _CURSOR CURSOR FOR 
		SELECT SC_ST_KEY, SC_SCORE, SJ_GRADE, SJ_SEMESTER 
        FROM SCORE
        JOIN SUBJECT ON SJ_NUM = SC_SJ_NUM;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET _DONE = TRUE;
    
	CALL ZERO_SUM_COUNT();
	
		OPEN _CURSOR;
		CURSOR_LOOP : LOOP 
			
			FETCH _CURSOR INTO _SC_ST_KEY, _SC_SCORE, _SJ_GRADE, _SJ_SEMESTER;

            IF _DONE THEN
				LEAVE CURSOR_LOOP;
			END IF;
            
            UPDATE AVERAGE 
            SET 
				AV_SUM = AV_SUM + _SC_SCORE,
                AV_COUNT = AV_COUNT +1
			WHERE
				AV_GRADE = _SJ_GRADE AND AV_SEMESTER = _SJ_SEMESTER AND AV_ST_KEY = _SC_ST_KEY;
            
        END LOOP;
        CLOSE _CURSOR;
    
END //
DELIMITER ;
CALL CALC_AVERAGE();

# AVERAGE 테이블에 SUM과 COUNT를 모두 0으로 초기화 
DROP PROCEDURE IF EXISTS ZERO_SUM_COUNT;

DELIMITER //
CREATE PROCEDURE ZERO_SUM_COUNT()
BEGIN
	UPDATE AVERAGE SET AV_SUM = 0, AV_COUNT = 0;
END //
DELIMITER ;
CALL ZERO_SUM_COUNT();


