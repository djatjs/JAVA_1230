USE SHOPPINGMALL;

# 회원이 다음의 정보로 회원가입을 했을 때 필요한 쿼리
# 아이디 : abc123, 비번 abc123, 이메일 : abc123@db.com, 전화번호 : 111-1234-5678
insert into `member`(ME_ID, ME_PW, ME_EMAIL, ME_NUMBER) 
value("abc123","abc123","abc123@db.com","111-1234-5678");

insert into `member`(ME_ID, ME_PW, ME_EMAIL, ME_NUMBER) 
value("abc001","abc001","abc001@db.com","111-5432-9876");

# 관리자가 다음의 정보로 회원 가입을 했을 때 필요한 쿼리
# 아이디 : admin123, 비번 : admin123, 이메일 : admin123@db.com, 전화번호 : 111-2222-3333
insert into `member`(ME_ID, ME_PW, ME_EMAIL, ME_NUMBER, ME_AUTHORITY) 
valueS("admin123","admin123","admin123@db.com","111-2222-3333","ADMIN");



# 카테고리를 등록할 때 필요한 쿼리
# 상의 : TOP, 하의 : PAN, 악세사리 : ACC, 모자 : CAP, 신발 : SHO
insert into `category`(CA_NAME, CA_CODE) 
VALUES("상의","TOP"),("하의", "PAN"),("악세사리","ACC"),("모자","CAP"),("신발","SHO");

# 제품을 등록하기 위한 프로시저
DROP PROCEDURE IF EXISTS INSERT_PRODUCT;

DELIMITER //
CREATE PROCEDURE INSERT_PRODUCT(
	# 5개의 변수를 선언
    IN _CA_CODE CHAR(3),
    IN _TITLE VARCHAR(100),
    IN _CONTENT LONGTEXT,
    IN _PRICE INT,
    IN _THUMB VARCHAR(200)
    
)
BEGIN
	DECLARE _COUNT INT;
    DECLARE _COUNT_STR CHAR(3);
    DECLARE _PR_CODE CHAR(6);
    DECLARE _CA_NUM INT;
    
    # PR_CODE가 _CA_CODE로 시작하는 제품의 개수를 구함
    SET _COUNT = (SELECT COUNT(*) + 1 FROM product WHERE PR_CODE LIKE CONCAT(_CA_CODE,'%'));
    
    # 제품의 개수를 이용하여 3자리 문자열을 만듬. 빈자리는 앞에 0자리로 채움
    SET _COUNT_STR = LPAD(_COUNT, 3, "0");
    
    # 제품 코드는 _CA_CODE와 위에서 구한 3자리 문자열을 합해서 구함
    SET _PR_CODE = CONCAT(_CA_CODE, _COUNT_STR);
    
    # _CA_CODE를 이용해서 PR_CA_NUM을 구함
    SET _CA_NUM = (SELECT CA_NUM FROM CATEGORY WHERE CA_CODE = _CA_CODE);
    
    # 위에서 구한 값들을 이용하여 INSERT문 작성
    INSERT INTO PRODUCT(PR_CODE, PR_TITLE, PR_CONTENT, PR_PRICE, PR_THUMB, PR_CA_NUM) VALUES
		(_PR_CODE, _TITLE, _CONTENT, _PRICE, _THUMB, _CA_NUM);
    
END //
DELIMITER ;

CALL INSERT_PRODUCT("TOP", "셔츠입니다","셔츠를 싸게 팝니다.", 10000, "/IMG/TOP_01.JPG");
CALL INSERT_PRODUCT("TOP", "반팔","반팔팝니다.", 5000, "/IMG/TOP_02.JPG");
CALL INSERT_PRODUCT("TOP", "긴팔","긴팔팝니다.", 15000, "/IMG/TOP_03.JPG");

CALL INSERT_PRODUCT("PAN", "반바지","반바지요", 5000, "/IMG/PAN_01.JPG");
CALL INSERT_PRODUCT("PAN", "바지","느좋 바지요", 30000, "/IMG/PAN_02.JPG");
CALL INSERT_PRODUCT("PAN", "면바지","편한 면바지입니다", 40000, "/IMG/PAN_03.JPG");


CALL INSERT_PRODUCT("ACC", "반지 14K","커플링", 100000, "/IMG/ACC_01.JPG");
CALL INSERT_PRODUCT("ACC", "목걸이 14K","금목걸이", 150000, "/IMG/ACC_02.JPG");
CALL INSERT_PRODUCT("ACC", "순금 반지 1돈","돌반지", 400000, "/IMG/ACC_03.JPG");

CALL INSERT_PRODUCT("CAP", "빈티지 모자","모자링", 12000, "/IMG/CAP_01.JPG");
CALL INSERT_PRODUCT("CAP", "모자","모자람", 15000, "/IMG/CAP_02.JPG");
CALL INSERT_PRODUCT("CAP", "선캡","모자이긴함", 40000, "/IMG/CAP_03.JPG");

CALL INSERT_PRODUCT("SHO", "장화","장화팜", 20000, "/IMG/SHO_01.JPG");
CALL INSERT_PRODUCT("SHO", "런닝화","한정판일수도", 200000, "/IMG/SHO_02.JPG");
CALL INSERT_PRODUCT("SHO", "구두","스타일 좋은 구두", 300000, "/IMG/SHO_03.JPG");


# abc123 회원이 TOP001 제품을 장바구니에 3개 담았을 때 쿼리
insert into cart(CT_ME_ID, CT_PR_CODE, CT_AMOUNT) values ("abc123", "TOP001" ,3);

# abc123 회원이 SHO001 제품을 장바구니에 1개 담았을 때 쿼리
insert into cart(CT_ME_ID, CT_PR_CODE, CT_AMOUNT) values ("abc123", "SHO001" ,1);

# abc123 회원이 장바구니에 담긴 모든 제품을 구매할 때 쿼리
# 구매 테이블에 총 가격과 구매자를 추가하는 쿼리
insert into buy(BU_TOTAL_PRICE,BU_ME_ID) values ("50000","abc123");

-- insert into buy(BU_TOTAL_PRICE,BU_ME_ID)
-- values (
-- 	(select sum(pr_price) from product join cart on ct_pr_code = pr_code),
--     (CT_ME_ID)
-- );
# 구매 리스트에 장바구니에 담긴 제품들을 추가하는 쿼리
insert into buy_list(BL_AMOUNT, BL_PRICE, BL_BU_NUM, BL_PR_CODE)
select 3, 30000, MAX(bu_num), "TOP001" From buy;
insert into buy_list(BL_AMOUNT, BL_PRICE, BL_BU_NUM, BL_PR_CODE)
select 1, 20000, MAX(bu_num), "SHO001" From buy;

# 장바구니에 있는 목록들을 제거하는 쿼리
delete from cart where CT_ME_ID ="abc123" and CT_PR_CODE = "TOP001";
delete from cart where CT_ME_ID ="abc123" and CT_PR_CODE = "SHO001";

# abc123 회원이 구매한 제품들 목록을 조회하는 쿼리
select distinct product.*
from buy_list 
join buy on BU_NUM = BL_BU_NUM 
join product on BL_PR_CODE = PR_CODE
where BU_ME_ID = "abc123";

# 제품 가격이 만원 이상인 제품들을 조회하는 쿼리
select * from product where pr_price >= 10000;

# 제품을 금액이 높은 순으로 조회하는 쿼리
select ROW_NUMBER() OVER(ORDER BY pr_price DESC) 가격순, product.* from product;

select * from product order by pr_price desc;

# 제품별 판매 개수를 조회하는 쿼리
-- select ifnull(BL_AMOUNT,0) 판매량, product.* from product
-- left join buy_list on BL_PR_CODE = PR_CODE
-- order by BL_AMOUNT desc;

select product.*, ifnull(sum(BL_AMOUNT),0) 판매수 from product
left join buy_list on BL_PR_CODE = PR_CODE
group by PR_CODE
order by 판매수 desc;

# 판매량이 제일 많은 제품을 확인하는 쿼리
select product.*, ifnull(sum(BL_AMOUNT),0) 판매수 from product
left join buy_list on BL_PR_CODE = PR_CODE
group by PR_CODE
order by 판매수 desc
limit 1;


# 아니 이게 뭐임 select 안에 select 안에 select ㄷㄷ
select * from(
select dense_rank() over(order by 판매수 desc) 판매순위, buy_product.* from (
	select product.*, ifnull(sum(BL_AMOUNT),0) 판매수 from product
	left join buy_list on BL_PR_CODE = PR_CODE
	group by PR_CODE) buy_product
    )t
where 판매순위 =1; 

# 카테고리별 최고 금액을 조회하는 쿼리
select PR_CA_NUM 카테고리, max(PR_PRICE) 최고금액 from product
group by PR_CA_NUM;

# 카테고리별 최고 금액 제품들을 조회하는 쿼리
select * from product
join (select pr_ca_num 카테고리, max(pr_price) 최고금액 from product group by pr_ca_num) t
on pr_ca_num = 카테고리
where pr_price = 최고금액
order by 카테고리;

# 사용자별 누적 구매액을 조회하는 쿼리
select ME_ID, ifnull(sum(BU_TOTAL_PRICE),0) from `member`
left join buy on BU_ME_ID = ME_ID
group by ME_ID;

# "반"으로 제품을 검색했을 때 조회하는 쿼리
select * from product
where PR_TITLE like concat("%","반","%") or PR_CONTENT like concat("%","반","%");



# abc123 회원이 구매한 제품들을 구매확정 했을 때 쿼리
update buy
set BU_STATE = "구매확정",
	BU_FINAL_DATE = now() #CURRENT_TIMESTAMP
where BU_ME_ID = "abc123"; # 실제는 BU_NUM을 이용
