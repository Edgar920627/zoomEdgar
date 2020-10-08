package com.dohwaji.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	private static SqlSessionFactory sqlsession;

	static {
		try {
			String resource = "./com/dohwaji/config/config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlsession = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			System.out.println("초기화 문제 발생 : " + e);
		}
	}

	
	public static SqlSessionFactory getSqlMapInstance() {
		return sqlsession;
	}
}
