insert into member(M_ID,M_PW,M_NUMBER,M_NICKNAME) values
("user0001","12341234","010-1234-1234","유저1");


insert into category(CA_NAME, CA_CODE) values
("커피","COF");


insert into menu(ME_CODE, ME_CA_NUM, ME_NAME, ME_PRICE, ME_CONTENT, ME_THUMB, ME_HOT_ICE) values
("COF001",1,"아메리카노",1500, "진한 커피", "coffee.americano.jpg", "I");
insert into menu(ME_CODE, ME_CA_NUM, ME_NAME, ME_PRICE, ME_CONTENT, ME_THUMB, ME_HOT_ICE) values
("COF002",1,"아메리카노",1500, "마음을 녹여주는 커피", "coffee.americano.jpg", "H");


insert into cart(CT_M_ID) values
("user0001");

insert into cart_list(CL_ME_CODE, CL_CT_NUM, CL_AMOUNT) values
("COF001",1,2),("COF002",1,1);