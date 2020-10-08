package com.dohwaji.app.bbs.dao;

import java.util.Enumeration;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.app.bbs.dao.BbsFilesBean;
import com.dohwaji.config.SqlMapConfig;
import com.oreilly.servlet.MultipartRequest;

public class BbsFilesDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public BbsFilesDAO() {
		sqlsession = sessionf.openSession(true);
	}
	
	
	
	// 첨부파일 등록하기
	public boolean insertBbsFile(MultipartRequest multi, int bbs_num) {
		HashMap<String, Object> fileMap = new HashMap<>();
		Enumeration<String> files = multi.getFileNames();
		System.out.println(files);
		boolean check = true;
		
		fileMap.put("bbs_num", bbs_num);
		
		while(files.hasMoreElements()) {
			String data = files.nextElement();
			System.out.println("1");
			System.out.println(data);
			if(multi.getFilesystemName(data) == null) {continue;}
			fileMap.put("bbs_file_name", multi.getFilesystemName(data));
			if(sqlsession.insert("BbsFiles.insertBbsFile", fileMap) != 1) {
				check = false;
				break;
			}
		}
		return check;
	}
	
	
	// 첨부파일 상세보기 
	public List<BbsFilesBean> getBbsFilesDetail(int bbs_num) {
		List<BbsFilesBean> filesBeanList =  sqlsession.selectList("BbsFiles.getBbsFilesDetail", bbs_num);
		return filesBeanList;
	}
	
	
	// 첨부파일 삭제
	public void deleteBbsFiles(int bbs_num) {
		sqlsession.delete("BbsFiles.deleteBbsFiles", bbs_num);
	}
	
	
	

}
