# 윈도우 함수
# 테이블의 행과 행 사이의 관계를 정의하는 함수
# OVER절이 들어간 함수
# 순위를 표현할 때 사용


# ROW_NUMBER() OVER(ORDER BY 속성 정렬방법)
# - 값이 같더라도 다른 번호를 부여

USE WINDOW_FUNC;
SELECT ROW_NUMBER() OVER(ORDER BY TS_SCORE DESC) AS 순위, TEAM_SCORE.* FROM WINDOW_FUNC.TEAM_SCORE;

# RANK() OVER(ORDER BY 속성 정렬방법)
# - 값이 같으면 같은 등수로 표시. 다음 등수는 같은 등수가 있는 개수만큼 건너 뜀
SELECT RANK() OVER(ORDER BY TS_SCORE DESC) AS 순위, TEAM_SCORE.* FROM WINDOW_FUNC.TEAM_SCORE;

# DENSE_RANK() OVER(ORDER BY 속성 정렬방법)
# - 값이 같으면 같은 등수로 표시. 다음 등수는 건너 뛰지 않고 이어서 진행
SELECT DENSE_RANK() OVER(ORDER BY TS_SCORE DESC) AS 순위, TEAM_SCORE.* FROM WINDOW_FUNC.TEAM_SCORE;

