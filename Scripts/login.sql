-- 로그인 기록
CREATE SEQUENCE LOGIN_SEQ
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 9999999999999999999999999999;

-- 로그인 기록 			// 오라클  //
CREATE TABLE Z_LOGIN(
	login_num NUMBER(10) PRIMARY KEY,
	user_id VARCHAR2(100),
	login_check CHAR(1) CONSTRAINT booleantest_login_check CHECK (login_check = '0' OR login_check = '1'),
	login_ip VARCHAR2(500),
	login_date DATE,
	CONSTRAINTS Z_LOGIN_fk FOREIGN KEY(user_id) REFERENCES Z_MEMBER(user_id)
	);


DROP SEQUENCE LOGIN_SEQ;
DROP TABLE Z_LOGIN;


SELECT * FROM Z_Login;
SELECT * FROM Z_MEMBER zm ;


/*

DROP TABLE IF EXISTS buyTBL, userTBL; -- 테이블이 존재할 경우 삭제(DROP) 
CREATE TABLE userTBL ( 
userID CHAR(8) NOT NULL PRIMARY KEY, -- 기본키로 설정, 기본키는 반드시 NOT NULL 
name VARCHAR(10) NOT NULL, 
birthYear INT NOT NULL ); 
CREATE TABLE buyTBL ( 
num INT AUTO_INCREMENT NOT NULL PRIMARY KEY , -- 기본키, NOT NULL, 자동증가 설정 
userID CHAR(8) NOT NULL, 
prodName CHAR(6) NOT NULL, 
FOREIGN KEY(userID) REFERENCES userTBL(userID) -- 이 테이블의 외래키는 userID이고, userTBL 테이블의 userID 와 연결 );

*/




-- 로그인 기록 			// MariaDB  //
CREATE TABLE Z_LOGIN(
	login_num int(11) NOT NULL auto_increment PRIMARY KEY,
	user_id VARCHAR(100),
	login_check CHAR(1),
	login_ip VARCHAR(500),
	login_date DATE,
	FOREIGN KEY(user_id) REFERENCES Z_MEMBER(user_id)
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;








-- tset
		 
				 
		select @rownum:=@rownum+1 as no,
		 zl.* from z_login zl  
	 	 WHERE user_id = 'qweqweqwe' and 
	 		 (@rownum:=0)=0 ORDER BY login_num DESC
			  limit 0, 10;
			  

