
CREATE SEQUENCE BBS_SEQ
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 9999999999999999999999999999;



--테이블 삭제
DROP SEQUENCE BBS_SEQ;
DROP TABLE Z_BBS;
DROP TABLE Z_BBS_FILES;


-- 게시판 테이블			// 오랄클  //
CREATE TABLE Z_BBS(
	bbs_num NUMBER(10) PRIMARY KEY,
	user_id VARCHAR2(20) NOT NULL,
	bbs_maindiv VARCHAR2(500) NOT NULL,
	bbs_smalldiv VARCHAR2(500) NOT NULL,
	bbs_title VARCHAR2(1000) NOT NULL,
	bbs_explanation VARCHAR2(3000) NOT NULL,
	bbs_likeCount NUMBER(10),
	bbs_likeCheck CHAR(1),
	bbs_readcount NUMBER(10),
	bbs_date DATE NOT NULL,
	avgPoint VARCHAR2(500),
	commentCount NUMBER(10),
	avgValue NUMBER(10),
	CONSTRAINTS suer FOREIGN KEY(user_id) REFERENCES Z_MEMBER(USER_ID)
);

-- 컬럼 추가 ( 별점 , 평점 등)
	ALTER TABLE Z_BBS ADD (avgPoint VARCHAR2(500));
	ALTER TABLE Z_BBS ADD (commentCount NUMBER(10));
	ALTER TABLE Z_BBS ADD (avgValue NUMBER(10));


-- 게시판 파일첨부 테이블		// 오라클  //
CREATE TABLE Z_BBS_FILES(
	bbs_file_name VARCHAR2(500) PRIMARY KEY,
	bbs_num,
	CONSTRAINTS bbs_num_fk FOREIGN KEY(bbs_num) REFERENCES Z_BBS(bbs_num)
);







-- 게시판 테이블			// MariaDB  //
CREATE TABLE Z_BBS(
	bbs_num int(11) NOT NULL auto_increment PRIMARY KEY,
	user_id VARCHAR(20) NOT NULL,
	bbs_maindiv VARCHAR(500) NOT NULL,
	bbs_smalldiv VARCHAR(500) NOT NULL,
	bbs_title VARCHAR(1000) NOT NULL,
	bbs_explanation VARCHAR(3000) NOT NULL,
	bbs_likeCount int(11),
	bbs_likeCheck CHAR(1),
	bbs_readcount int(11),
	bbs_date DATE NOT NULL,
	avgPoint VARCHAR(500),
	commentCount int(11),
	avgValue int(11),
	FOREIGN KEY(user_id) REFERENCES Z_MEMBER(user_id)
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



-- 게시판 파일첨부 테이블		// MariaDB  //
CREATE TABLE Z_BBS_FILES(
	bbs_file_name VARCHAR(500) PRIMARY KEY,
	bbs_num int(11),
	FOREIGN KEY(bbs_num) REFERENCES Z_BBS(bbs_num)
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;




-- test -----------------------------------------------------------------------------

select * from z_bbs zb ;

-- MariaDB

  select @rownum:=@rownum+1 as no,
	 zb.*
  from z_bbs zb WHERE
  (@rownum:=0)=0
  ORDER BY bbs_num DESC
  limit 1,10;
 
 select * from z_bbs zb ;
 

-- 마지막 번호 선택
 SELECT max(bbs_num) from z_bbs;
 
 
 INSERT INTO z_bbs (    
	 user_id, bbs_maindiv, bbs_smalldiv, bbs_title, bbs_explanation, bbs_date   
	)   
	values (    
	'23451', '9444', '944444', '911134523', '1233',  NOW()  
	);




   set @rownum:=0;
  select @rownum:=@rownum+1 as no,
	 zl.*
  from z_login zl 
  (@rownum:=0)=0
  ORDER BY login_date DESC
  limit 01,10;

 select * from z_login zl;

 
 

/*

		 BBS_TITLE LIKE CONCAT('%', #{bbs_maindiv},'%') or 
		 bbs_explanation LIKE CONCAT('%', #{bbs_explanation},'%') OR 
		 user_id LIKE CONCAT('%', #{user_id},'%')  AND


		SELECT * FROM
			(SELECT ROWNUM R, D.* FROM 
				(SELECT * FROM Z_BBS
				 WHERE bbs_maindiv != '공지' AND
				 (BBS_TITLE LIKE '%'||#{bbs_title}||'%' OR 
				 bbs_explanation LIKE '%'||#{bbs_explanation}||'%' OR 
				 user_id LIKE '%'||#{user_id}||'%') ORDER BY bbs_date DESC) D) B
				 WHERE B.R BETWEEN ${startRow} AND ${endRow}
				 
				 
				  AND TITLE LIKE CONCAT('%', '테스트','%')

*/


		 
		 
		 
	SELECT 
   A.*
   , (SELECT NAME FROM Z WHERE USER_ID = A.USER_ID) AS NAME
   FROM ( 
     SELECT 
      @ROWNUM:=@ROWNUM+1 AS RNUM
     ,	BD.* 
     FROM TB_BOARD_DOC BD, 
     (SELECT @ROWNUM := (#{page}-1)*#{rows}) TMP
     WHERE MAP_ID = #{mapId} 
     ORDER BY DOC_ID DESC
     LIMIT (#{page}-1)*#{rows}, #{rows}
   ) A
   ORDER BY RNUM asc
		 
		 

   
   
   set @rownum:=0;
  select @rownum:=@rownum+1 as no,
   USER_NUM ,
   USER_ID ,
   USER_NAME ,
   USER_date 
  from z_member zm 
  WHERE  (@rownum:=0)=0
  ORDER BY USER_NUM DESC
  limit 1,10;

 
 select * from z_bbs zb ORDER BY bbs_NUM DESC;
-- end







select BBS_NUM 
from Z_BBS  
where USER_ID = 'werwerwer';







		UPDATE Z_BBS 
		SET 
		BBS_LIKECOUNT = 
		WHERE bbs_num = 21;



SELECT * FROM Z_BBS;


select * from Z_BBS ORDER BY BBS_DATE DESC;

select * from Z_BBS where bbs_smalldiv like '자유게시판';


		SELECT *
		FROM Z_BBS 
		WHERE user_id = 'werwerwer';
	
	

  -- DESC (내림차순) 
  -- ASC (오름차순) 
  
	
	
	SELECT COUNT(*) FROM Z_BBS
	WHERE bbs_maindiv !='공지' OR bbs_smalldiv != '공지';
	
	SELECT COUNT(*) FROM Z_BBS
	WHERE bbs_maindiv ='공지' OR bbs_smalldiv = '공지';
	
SELECT COUNT(*) FROM Z_BBS;
    
    
    UPDATE Z_BBS
		SET  bbs_maindiv='인터넷방송', bbs_smalldiv = '자유게시판', bbs_title = '123123', bbs_explanation = '123123'
		WHERE BBS_NUM = 49;
	
	
	
	
	
			SELECT * FROM
			(SELECT ROWNUM RR, DD.* FROM 
				(SELECT * FROM Z_BBS ORDER BY BBS_NUM DESC) DD) BB 
			WHERE bbs_maindiv='인터넷방송' AND BBS_SMALLDIV = '자유게시판' ORDER BY BBS_NUM ASC;
		
		
		
		-- 전체 리스트
			SELECT * FROM
			(SELECT ROWNUM RR, DD.* FROM 
				(SELECT * FROM Z_BBS ORDER BY BBS_NUM DESC) DD) BB ORDER BY BBS_NUM ASC;
			
			
			
			SELECT * FROM
			(SELECT ROWNUM RR, DD.* FROM 
				(SELECT * FROM Z_BBS) DD) BB ORDER BY BBS_NUM DESC;
			
			
			
	
	
	
				SELECT * FROM Z_BBS WHERE bbs_maindiv='인터넷방송' AND BBS_SMALLDIV = '자유게시판' ORDER BY BBS_NUM DESC;
			


	
	
			
			
		SELECT * FROM
			(SELECT ROWNUM R, D.* FROM 
				(SELECT * FROM Z_BBS
				 WHERE bbs_maindiv != '공지' ORDER BY bbs_date DESC) D) B;
	
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
	
	
	
	

