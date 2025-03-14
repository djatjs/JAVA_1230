# 아이디 등록
insert into member(M_ID,M_PW,M_NUMBER,M_NICKNAME) values
("user0001","12341234","010-1234-1234","유저1");

# 아이디 등록시 스탬프와 쿠폰 테이블에도 같이 등록
insert into stamp(ST_M_ID, ST_COUNT) values
("user0001",0); 
insert into coupon(CO_M_ID, CO_COUNT) values
("user0001",0);

# 메뉴 등록 전 카테고리 등록
insert into category(CA_NAME, CA_CODE) values
("커피","COF");

## 메뉴 등록
insert into menu(ME_CODE, ME_CA_NUM, ME_NAME, ME_PRICE, ME_CONTENT, ME_THUMB, ME_HOT_ICE) values
("COF001",1,"아메리카노",1500, "진한 커피", "coffee.americano.jpg", "I");
insert into menu(ME_CODE, ME_CA_NUM, ME_NAME, ME_PRICE, ME_CONTENT, ME_THUMB, ME_HOT_ICE) values
("COF002",1,"아메리카노",1500, "마음을 녹여주는 커피", "coffee.americano.jpg", "H");

INSERT INTO menu (ME_CODE, ME_CA_NUM, ME_NAME, ME_PRICE, ME_CONTENT, ME_HOT_ICE)
SELECT 
    CONCAT("COF", LPAD(COUNT(ME_CODE) + 1, 3, '0')), 4, "바닐라라떼", 3500, "ㅋㅋ", "H"
FROM menu
WHERE ME_CODE LIKE "COF%";


# USER0001의 장바구니 생성
insert into cart(CT_M_ID) values
("user0001");

# 장바구니에 메뉴 담기
insert into cart_list(CL_ME_CODE, CL_CT_NUM, CL_AMOUNT) values
("COF001",1,2),("COF002",1,1);


## 결제
insert into `order`(OR_CT_NUM, OR_M_ID, OR_USE, OR_TOTAL, OR_FINAL) values
(1,"user0001", 0, 4500, 4500);

# 스탬프 적립
update stamp
set ST_COUNT = ST_COUNT+1
where ST_M_ID = "user0001";

# 구매 상태 : YES
UPDATE cart
SET CT_STATUS = "Y"
WHERE CT_NUM = 1;

# 최종 결제 금액만큼 매출 기록
INSERT INTO income(IN_MONEY) 
SELECT OR_FINAL FROM `order` WHERE OR_NUM =2;