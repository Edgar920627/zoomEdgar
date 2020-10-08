CREATE SEQUENCE USER_SEQ
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 1000000000000;


DROP SEQUENCE USER_SEQ;
DROP TABLE Z_MEMBER;



-- 회원 테이블    오라클
CREATE TABLE Z_MEMBER(
	USER_NUM NUMBER(10) PRIMARY KEY,
	USER_ID VARCHAR2(100) UNIQUE NOT NULL,
	USER_PW VARCHAR2(100) NOT NULL,
	USER_NAME VARCHAR2(100) NOT NULL,
	USER_EMAIL VARCHAR2(100) NOT NULL,
	USER_EMAIL_HASH VARCHAR2(100),
	USER_EMAIL_CHECKED char(1),
	USER_date DATE
);



-- MariaDB
-- 회원 테이블	
CREATE TABLE Z_MEMBER(
	USER_NUM int(11) NOT NULL AUTO_INCREMENT,
	USER_ID VARCHAR(100) UNIQUE NOT NULL,
	USER_PW VARCHAR(100) NOT NULL,
	USER_NAME VARCHAR(100) NOT NULL,
	USER_EMAIL VARCHAR(100) NOT NULL,
	USER_EMAIL_HASH VARCHAR(100),
	USER_EMAIL_CHECKED char(1),
	USER_date DATE,
	PRIMARY KEY(USER_NUM, USER_ID)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;





-- test -----------------------------------------------------------------------------


-- MariaDB   start

INSERT INTO Z_MEMBER (    
	 user_id, user_pw, user_name, user_email, user_email_checked, user_date   
	)   
	values (    
	'admin', 'admin', 'admin', 'admin@admin', 1,  NOW()  
	);



select * from z_member;


		UPDATE Z_MEMBER SET 
		USER_PW = 'ִ杬䉄ִ杬䉄ִ杬䉄'
		WHERE user_id = 'admin';
	





-- MariaDB   end

-- 오라클 


DELETE FROM Z_MEMBER
  WHERE USER_NUM = 20;

INSERT 


DELETE 


SELECT * FROM Z_MEMBER;


		UPDATE Z_MEMBER SET 
		USER_PW = '䉄䂨뚐䉄䂨뚐䉄䂨뚐'
		WHERE user_id = 'admin';
	
	
		UPDATE Z_MEMBER SET 
		user_email_checked = '0' , USER_EMAIL = 'q'
		WHERE user_id = 'qweqweqwe';


SELECT user_num, user_id, user_pw, user_name, user_email, user_date
FROM Z_MEMBER;


-- xml  테스트

SELECT COUNT(*) FROM Z_MEMBER WHERE USER_ID = 'admin' AND user_email_checked = '1';


		SELECT USER_ID FROM Z_MEMBER
		WHERE USER_ID = '123' AND USER_PW = '123' AND user_email_checked = '1';
		
		

SELECT * FROM Z_MEMBER;
UPDATE Z_MEMBER SET user_email_checked = '1' WHERE user_id = 'admin';
UPDATE Z_MEMBER SET user_id = 'asdasd' WHERE user_num = 19;
UPDATE Z_MEMBER SET user_pw = 'asdasd' WHERE user_num = 19;


		UPDATE Z_MEMBER
		SET USER_PW='1', USER_NAME='1'
		WHERE USER_ID='1' OR USER_EMAIL='123@12';
	
	
		UPDATE Z_MEMBER
		SET USER_PW='12', USER_NAME='12'
		WHERE USER_ID='1' AND USER_EMAIL='123@12';


		UPDATE Z_MEMBER
		SET USER_EMAIL_CHECKED=1
		WHERE USER_ID='11';
	
	
	SELECT COUNT(*) FROM Z_MEMBER WHERE USER_EMAIL='123@123';


