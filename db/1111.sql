SELECT CONCAT("P", 2000, "160", LPAD(COUNT(PR_NUM)+1, 3, "0")) FROM professor
RIGHT JOIN department ON DE_PR_NUM = PR_NUM
WHERE DE_NAME = "컴퓨터공학" AND PR_YEAR = 2000;


SELECT 
	CONCAT("P", 2000, DE_NAME_NUM, LPAD(COUNT(PR_NUM)+1, 3, "0"))     
FROM 
	(SELECT * FROM professor WHERE PR_YEAR = 2000) P
    
RIGHT JOIN 
	department ON DE_NUM = PR_DE_NUM
WHERE 
	DE_NAME = "컴퓨터공학";


#######################################################################
SELECT 
	CONCAT(FP_YEAR, DE_NAME_NUM, LPAD(RANK() OVER(ORDER BY FP_NAME, FP_RES_NUM),3,"0")) AS ST_NUM,  
    FP_NAME, 
    FP_PHONE, 
    FP_YEAR, 
    FP_RES_NUM
FROM final_pass 
JOIN department ON ST_DE_NUM = DE_NUM
WHERE FP_DE_NUM ="MEC" AND FP_YEAR = YEAR(NOW());



INSERT INTO menu (ME_CODE, ME_CA_NUM, ME_NAME, ME_PRICE, ME_HOT_ICE, ME_CONTENT) 
SELECT 
	CONCAT(LPAD(CA_NUM,6,"0")),
    CA_NAME,
    "에스프레소",
    1300,
    "H",
    "쓰디쓴 커피"


VALUES (#{menu.meCode}, #{menu.meCaNum}, #{menu.meName}, #{menu.mePrice}, #{menu.meHotIce}, #{menu.meContent})

