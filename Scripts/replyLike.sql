

-- z_replyLike
DROP TABLE z_replyLike;


-- 좋아요  테이블		// 오라클  //
CREATE TABLE z_replyLike (
   reply_num NUMBER(10),
   login_ip VARCHAR2(100),
   bbs_num NUMBER(10),
   CONSTRAINTS z_fk FOREIGN KEY(reply_num) REFERENCES Z_BBsReply(reply_num),
   CONSTRAINTS Z_fk2 FOREIGN KEY(bbs_num) REFERENCES Z_BBS(bbs_num)
);



-- 좋아요  테이블		// MariaDB  //
CREATE TABLE z_replyLike (
   reply_num int(11) NOT NULL auto_increment PRIMARY KEY,
   login_ip VARCHAR(100),
   bbs_num int(11),
  FOREIGN KEY(bbs_num) REFERENCES Z_BBS(bbs_num)
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;





SELECT * FROM z_replyLike;


SELECT * FROM z_replyLike
WHERE bbs_num=19 AND reply_num=51;

















