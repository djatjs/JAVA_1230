# 회원이 다음의 정보로 회원가입을 했을 때 필요한 쿼리
# 아이디 : abc123, 비번 abc123, 이메일 : abc123@db.com, 전화번호 : 111-1234-5678
insert into `member`(ME_ID, ME_PW, ME_EMAIL, ME_NUMBER) 
value("abc123","abc123","abc123@db.com","111-1234-5678");

# 관리자가 다음의 정보로 회원 가입을 했을 때 필요한 쿼리
# 아이디 : admin123, 비번 : admin123, 이메일 : admin123@db.com, 전화번호 : 111-2222-3333
insert into `member`(ME_ID, ME_PW, ME_EMAIL, ME_NUMBER, ME_AUTHORITY) 
valueS("admin123","admin123","admin123@db.com","111-2222-3333","ADMIN");

# 카테고리를 등록할 때 필요한 쿼리
# 상의 : TOP, 하의 : PAN, 악세사리 : ACC, 모자 : CAP, 신발 : SHO
insert into `category`(CA_NAME, CA_CODE) 
VALUES("상의","TOP"),("하의", "PAN"),("악세사리","ACC"),("모자","CAP"),("신발","SHO");