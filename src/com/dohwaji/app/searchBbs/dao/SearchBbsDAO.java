package com.dohwaji.app.searchBbs.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.config.SqlMapConfig;

public class SearchBbsDAO {
	
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;

	public SearchBbsDAO() {
		sqlsession = sessionf.openSession(true);
	}


}
