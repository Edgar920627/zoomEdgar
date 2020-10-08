
-- 시퀀스
CREATE SEQUENCE BBSReply_SEQ
INCREMENT BY 1 
START WITH 1
MINVALUE 1
MAXVALUE 9999999999999999999999999999;


-- 댓글  // 오라클 //
CREATE TABLE Z_BBSReply(
	Reply_num NUMBER(10) PRIMARY KEY,
	bbs_num NUMBER(10) NOT NULL,
	user_id VARCHAR2(20) NOT NULL,
	reply_write VARCHAR2(3000) NOT NULL,
	reply_point NUMBER(1),
	reply_likeCnt NUMBER(10),
	reply_hateCnt NUMBER(10),
	reply_likeCheck CHAR(1) CONSTRAINT booleantest_likeCheck 
	CHECK (reply_likeCheck = '0' OR reply_likeCheck = '1'),
	reply_date DATE NOT NULL,
	CONSTRAINTS userID_fk FOREIGN KEY(user_id) REFERENCES Z_MEMBER(user_id),
	CONSTRAINTS bbsNUMfk FOREIGN KEY(bbs_num) REFERENCES Z_BBS(bbs_num)
);








-- 댓글  	// MariaDB //
CREATE TABLE Z_BBSReply(
	Reply_num int(11) NOT NULL auto_increment PRIMARY KEY,
	bbs_num int(11) NOT NULL,
	user_id VARCHAR(20) NOT NULL,
	reply_write VARCHAR(3000) NOT NULL,
	reply_point int(1),
	reply_likeCnt int(11),
	reply_hateCnt int(11),
	reply_likeCheck CHAR(1),
	reply_date DATE NOT NULL,
	FOREIGN KEY(user_id) REFERENCES Z_MEMBER(user_id),
	FOREIGN KEY(bbs_num) REFERENCES Z_BBS(bbs_num)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


ALTER TABLE Z_BBSReply ADD (reply_stars VARCHAR(20));


-- test -----------------------------------------------------------------------------



		SELECT * FROM
			(SELECT ROWNUM R, D.* FROM 
				(SELECT 
			 Reply_num       	Reply_num  
			,bbs_num      		bbs_num  
			,user_id            user_id      
			,reply_write      	reply_write
			,reply_point      	reply_point
			,reply_date      	reply_date 
			,CASE WHEN reply_point = 1 THEN '★☆☆☆☆'
			      WHEN reply_point = 2 THEN '★★☆☆☆'
			      WHEN reply_point = 3 THEN '★★★☆☆'
			      WHEN reply_point = 4 THEN '★★★★☆'
			      WHEN reply_point = 5 THEN '★★★★★'
			      ELSE '☆☆☆☆☆'
			 END                reply_stars
				FROM z_bbsReply
			WHERE  bbs_num = ${bbs_num}  ORDER BY reply_date DESC) D) B
		 WHERE B.R BETWEEN ${startRow} AND ${endRow}
		 

select * from z_bbsreply zb ;
 

  select @rownum:=@rownum+1 as no, 
		  	Reply_num       	Reply_num  
			,bbs_num      		bbs_num  
			,user_id            user_id      
			,reply_write      	reply_write
			,reply_point      	reply_point
			,reply_date      	reply_date 
			,reply_stars		reply_stars
	FROM z_bbsReply zb 
  	WHERE  bbs_num = 24 and 
  	(@rownum:=0)=0 ORDER BY reply_num desc 
  	limit 1, 10;


  select @rownum:=@rownum+1 as no, 
  			Reply_num       	Reply_num  
			,bbs_num      		bbs_num  
			,user_id            user_id      
			,reply_write      	reply_write
			,reply_point      	reply_point
			,reply_date      	reply_date 
			,CASE WHEN reply_point = 1 THEN '★☆☆☆☆'
			      WHEN reply_point = 2 THEN '★★☆☆☆'
			      WHEN reply_point = 3 THEN '★★★☆☆'
			      WHEN reply_point = 4 THEN '★★★★☆'
			      WHEN reply_point = 5 THEN '★★★★★'
			      ELSE '☆☆☆☆☆'
			 END                reply_stars
	FROM z_bbsreply zb 
  	WHERE bbs_num = 2 and 
  	(@rownum:=0)=0 ORDER BY reply_num DESC
  	 limit 1, 10;



SELECT * FROM Z_BBSREPLY;




--테이블 삭제
DROP SEQUENCE BBSReply_SEQ;
DROP TABLE Z_BBSReply;





-- test 


		INSERT INTO z_bbsReply (
		bbs_num, 
		user_id, 
		reply_write, 
		reply_point, 
		reply_likeCnt, 
		reply_hateCnt, 
		reply_likeCheck, 
		reply_date, 
		reply_stars
		)
		VALUES(
		 24
		, 'qweqweqwe'
		, '123'
		, 5
		, 0
		, 0
		, 0
		, NOW()
		, '★★★★★'
		);
	


		SELECT * FROM
			(SELECT ROWNUM R, D.* FROM 
				(SELECT 
			 Reply_num       	Reply_num  
			,bbs_num      		bbs_num  
			,user_id            user_id      
			,reply_write      	reply_write
			,reply_point      	reply_point
			,reply_date      	reply_date 
			,CASE WHEN reply_point = 1 THEN '★☆☆☆☆'
			      WHEN reply_point = 2 THEN '★★☆☆☆'
			      WHEN reply_point = 3 THEN '★★★☆☆'
			      WHEN reply_point = 4 THEN '★★★★☆'
			      WHEN reply_point = 5 THEN '★★★★★'
			      ELSE '☆☆☆☆☆'
			 END                reply_stars
				FROM Z_BBSReply
				 WHERE  user_id = '123'  ORDER BY reply_date DESC) D) B;

		INSERT INTO z_bbsReply (
		bbs_num, 
		user_id, 
		reply_write, 
		reply_point, 
		reply_likeCnt, 
		reply_hateCnt, 
		reply_likeCheck, 
		reply_date, 
		reply_stars
		)
		VALUES(
		 24
		, 'qweqweqwe'
		, '123'
		, 5
		, 0
		, 0
		, 0
		, NOW()
		, '★★★★★'
		);



	
		SELECT 
			 Reply_num       	Reply_num  
			,bbs_num      		bbs_num  
			,user_id            user_id      
			,reply_write      	reply_write
			,reply_point      	reply_point
			,reply_date      	reply_date 
			,CASE WHEN reply_point = 1 THEN '★☆☆☆☆'
			      WHEN reply_point = 2 THEN '★★☆☆☆'
			      WHEN reply_point = 3 THEN '★★★☆☆'
			      WHEN reply_point = 4 THEN '★★★★☆'
			      WHEN reply_point = 5 THEN '★★★★★'
			      ELSE '☆☆☆☆☆'
			 END                commentStars
		FROM Z_BBSReply
       WHERE bbs_num = ${bbs_num} ORDER BY reply_date DESC
	
       

		SELECT DISTINCT
		BBS_NUM 
       		,(SELECT COUNT(*) FROM Z_BBSReply WHERE bbs_num = 51 AND reply_point = 1) AS POINT_COUNT1
       		,(SELECT COUNT(*) FROM Z_BBSReply WHERE bbs_num = 51 AND  reply_point = 2) AS POINT_COUNT2
       		,(SELECT COUNT(*) FROM Z_BBSReply WHERE bbs_num = 51 AND  reply_point = 3) AS POINT_COUNT3
       		,(SELECT COUNT(*) FROM Z_BBSReply WHERE bbs_num = 51 AND  reply_point = 4) AS POINT_COUNT4
       		,(SELECT COUNT(*) FROM Z_BBSReply WHERE bbs_num = 51 AND  reply_point = 5) AS POINT_COUNT5
       	FROM Z_BBS WHERE bbs_num = 51;

             
       
       SELECT COUNT('BBS_NUM = 19') FROM Z_BBSReply WHERE reply_point = 1;
                       
      SELECT COUNT(*) FROM Z_BBSReply WHERE bbs_num = 51 AND reply_point = 1;
                       
       			 SELECT DISTINCT
                        reply_num
                       ,(SELECT COUNT(*) FROM Z_BBSReply WHERE reply_point = 1) AS POINT_COUNT1 --1점
                       ,(SELECT COUNT(*) FROM Z_BBSReply WHERE  reply_point = 2) AS POINT_COUNT2 --2점
                       ,(SELECT COUNT(*) FROM Z_BBSReply WHERE  reply_point = 3) AS POINT_COUNT3 --3점
                       ,(SELECT COUNT(*) FROM Z_BBSReply WHERE reply_point = 4) AS POINT_COUNT4 --4점
                       ,(SELECT COUNT(*) FROM Z_BBSReply WHERE  reply_point = 5) AS POINT_COUNT5 --5점
                   FROM Z_BBSReply
                   WHERE BBS_NUM = 51;
	
                  
    
	