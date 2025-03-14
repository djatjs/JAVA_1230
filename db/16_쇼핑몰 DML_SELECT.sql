# 카테고리 상의를 클릭했을 때 조회하는 쿼리. (3개 다 같은 결과)
select * from product
where pr_code like "TOP%";

select * from product
where pr_ca_num = (select ca_num from category where ca_name ="상의");

select * from product
join category on PR_CA_NUM = CA_NUM
where ca_name ="상의";

SELECT * FROM PRODUCT 
WHERE PR_CA_NUM = (SELECT CA_NUM FROM CATEGORY WHERE CA_CODE = 'TOP');

SELECT * FROM PRODUCT
WHERE PR_CODE LIKE CONCAT('TOP', '%');

# abc123회원이 구매한 제품들 목록을 조회하는 쿼리 
SELECT DISTINCT PRODUCT.* FROM BUY 
JOIN BUY_LIST ON BU_NUM = BL_BU_NUM
JOIN PRODUCT ON PR_CODE = BL_PR_CODE 
WHERE BU_ME_ID = 'abc123';

# 제품 가격이 만원 이상인 제품들을 조회하는 쿼리 
SELECT * FROM PRODUCT WHERE PR_PRICE >= 10000;

# 제품을 금액이 높은 순으로 조회하는 쿼리 
SELECT * FROM PRODUCT ORDER BY PR_PRICE DESC;

# 제품별 판매 개수를 조회하는 쿼리 => OUTER JOIN, SUM(), BUY_LIST, PRODUCT, GROUP BY
SELECT PRODUCT.*, IFNULL(SUM(BL_AMOUNT), 0) AS 판매수 FROM PRODUCT
LEFT JOIN BUY_LIST ON PR_CODE = BL_PR_CODE 
GROUP BY PR_CODE;

# 판매량이 제일 많은 제품을 조회하는 쿼리 
SELECT PRODUCT.*, IFNULL(SUM(BL_AMOUNT), 0) AS 판매수 FROM PRODUCT
LEFT JOIN BUY_LIST ON PR_CODE = BL_PR_CODE 
GROUP BY PR_CODE 
ORDER BY 판매수 DESC LIMIT 1;

SELECT * FROM (
	SELECT DENSE_RANK() OVER(ORDER BY 판매수 DESC) RNK, BUY_PRODUCT.*  FROM (
		SELECT PRODUCT.*, IFNULL(SUM(BL_AMOUNT), 0) AS 판매수 FROM PRODUCT
		LEFT JOIN BUY_LIST ON PR_CODE = BL_PR_CODE 
		GROUP BY PR_CODE) BUY_PRODUCT) T
WHERE RNK = 1;

# 카테고리별 최고 금액을 조회하는 쿼리 
SELECT PR_CA_NUM 카테고리, MAX(PR_PRICE) 최고금액 FROM PRODUCT GROUP BY PR_CA_NUM;

# 카테고리별 최고 금액의 제품을 조회하는 쿼리 
SELECT * FROM PRODUCT 
JOIN (SELECT PR_CA_NUM 카테고리, MAX(PR_PRICE) 최고금액 FROM PRODUCT GROUP BY PR_CA_NUM) T 
ON PR_CA_NUM = 카테고리
WHERE PR_PRICE = 최고금액
ORDER BY 카테고리;

# 사용자별 누적 구매액을 조회하는 쿼리 
# - OUTER JOIN : 구매내역이 없는 사용자도 조회를 하기 위해 
# - GROUP BY, SUM() : 사용자별 구매액을 계산하기 위해
SELECT ME_ID, IFNULL(SUM(BU_TOTAL_PRICE),0) AS 누적구매량 FROM BUY 
RIGHT JOIN MEMBER ON ME_ID = BU_ME_ID
GROUP BY ME_ID;

# "반"으로 제품을 검색했을 때 조회하는 쿼리 
SELECT * FROM PRODUCT 
WHERE PR_TITLE LIKE CONCAT("%", "반", "%") OR PR_CONTENT LIKE CONCAT("%", "반", "%");