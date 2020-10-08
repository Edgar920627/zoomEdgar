/*	
 * 	private int report_num;
	private String report_type;		// 게시글 , 댓글
	private int pk_num;				// pk 번호
	private String report_div;		// 홍보글, 19 음란물, 기타
	private String user_id;			// 신고당한자
	private String report_id;		// 신고자
	private String report_contents;	// 내용
	private String report_result;	// 통과, 실패
	private String report_date;		// 날짜
	
	
	reply_likeCheck CHAR(1) CONSTRAINT booleantest_likeCheck 
	CHECK (reply_likeCheck = '0' OR reply_likeCheck = '1'),
	
	
	report_cnt
*/
--테이블 삭제
DROP SEQUENCE report_SEQ;
DROP TABLE z_report;

-- 시퀀스
CREATE SEQUENCE report_SEQ
INCREMENT BY 1 
START WITH 1
MINVALUE 1
MAXVALUE 9999999999999999999999999999;


-- 신고 테이블
CREATE TABLE z_report (
	report_num NUMBER(10) PRIMARY KEY,
	report_type VARCHAR2(100) NOT NULL,		-- 게시글 , 댓글
	pk_num NUMBER(10) NOT NULL,
	report_div VARCHAR2(100) NOT NULL,		-- 성인물 , 홍보 , 기타
	user_id VARCHAR2(100) NOT NULL,			-- 신고 당한 자
	report_id VARCHAR2(100) NOT NULL,		-- 신고자
	report_contents VARCHAR2(2000),
	report_result VARCHAR2(100) NOT NULL, 	-- 확인중, 통과, 삭제 
	report_date DATE, 
	report_cnt NUMBER(10)
);


-- MariaDB  신고 테이블
CREATE TABLE z_report (
	report_num int(11) NOT NULL auto_increment PRIMARY KEY,
	report_type VARCHAR(100) NOT NULL,		-- 게시글 , 댓글
	pk_num int(11) NOT NULL,
	report_div VARCHAR(100) NOT NULL,		-- 성인물 , 홍보 , 기타
	user_id VARCHAR(100) NOT NULL,			-- 신고 당한 자
	report_id VARCHAR(100) NOT NULL,		-- 신고자
	report_contents VARCHAR(2000),
	report_result VARCHAR(100) NOT NULL, 	-- 확인중, 통과, 삭제 
	report_date DATE, 
	report_cnt int(11)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;





SELECT * FROM z_report;



	-- test 
	
				 
		select @rownum:=@rownum+1 as no,
		 z_report.* from z_report 
	 	 WHERE report_result=#{report_result} AND report_type=#{report_type} AND report_div=#{report_div} and
	 		 (@rownum:=0)=0 ORDER BY report_num DESC
			  limit 0, 10;
			  
	

		SELECT * FROM
			(SELECT ROWNUM R, D.* FROM 
				(SELECT * FROM z_report
				 WHERE report_result=#{report_result} ORDER BY report_date DESC) D) B
					 WHERE B.R BETWEEN ${startRow} AND ${endRow}

					 
					 
					 
					 
