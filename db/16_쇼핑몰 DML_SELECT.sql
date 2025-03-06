# 카테고리 상의를 클릭했을 때 조회하는 쿼리. (3개 다 같은 결과)
select * from product
where pr_code like "TOP%";

select * from product
where pr_ca_num = (select ca_num from category where ca_name ="상의");

select * from product
join category on PR_CA_NUM = CA_NUM
where ca_name ="상의";