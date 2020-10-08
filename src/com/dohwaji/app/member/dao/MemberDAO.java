package com.dohwaji.app.member.dao;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dohwaji.app.bbs.dao.BbsBean;
import com.dohwaji.config.SqlMapConfig;

public class MemberDAO {
	
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public MemberDAO() {
		sqlsession = sessionf.openSession(true);
	}
	
	
	
	
	
	private final int KEY = 1029389044;
	
	
	// 암호화
	public String encrypt(String user_pw) {
		String en_pw = "";
		for (int i = 0; i < user_pw.length(); i++) {
			en_pw += (char) (user_pw.charAt(i) * KEY);
		}
		return en_pw;
	}
	
	
	

	// 복호화
	public String decrypt(String pw) {
		String de_pw = "";
		for (int i = 0; i < pw.length(); i++) {
			de_pw += (char) (pw.charAt(i) / KEY);
		}
		return de_pw;
	}
	
	
	
	
	
	
	
	// 로그인 카운터
	public int loginCnt(String user_id) {
		return sqlsession.selectOne("Member.loginCnt",user_id);
	}

	
	// 로그인 기록
	// 게시글 [이전] [다음] 10개씩 표시
	public List<LoginBean> loginHistory(int startRow, int endRow, String user_id) {
		HashMap<String, String> pageMap = new HashMap<>();
		pageMap.put("startRow", String.valueOf(startRow));
		pageMap.put("endRow", String.valueOf(endRow));
		pageMap.put("user_id", user_id);
		List<LoginBean> history = sqlsession.selectList("Member.loginHistory", pageMap);
		return history;
	}

	
	
	// 로그인 성공
	public boolean loginTrue(LoginBean loginBean) {
		boolean check = false;
		if(sqlsession.insert("Member.loginTrue", loginBean) == 1) {
			check = true;
		}
		return check;
	}

	
	// 로그인 실패
	public boolean loginFalse(LoginBean loginBean) {
		boolean check = false;
		if(sqlsession.insert("Member.loginFalse", loginBean) == 1) {
			check = true;
		}
		return check;
	}


	
	// 리턴 닉네임
	public String nameBring(String user_id) {
		return sqlsession.selectOne("Member.nameBring", user_id);
	}
	
	
	// 리턴 아이디
	public String getUserID(String user_email) {
		return sqlsession.selectOne("Member.getUserID", user_email);
	}
	
	
	// 리턴 이메일 
	public String getUserEmail(String user_id) {
		return sqlsession.selectOne("Member.getUserEmail", user_id);
	}

	
	// 이메일 인증 체크
	public boolean getUserEmailChecked(String user_id) {
		boolean check = false;
		if((Integer)sqlsession.selectOne("Member.getUserEmailChecked", user_id) == 1) {
			check = true;
		}
		return check;
	}
	
	// 이메일 등록
	public boolean setUserEmailChecked(MemberBean m_bean) {
		boolean result = false;
		if(sqlsession.update("Member.setUserEmailChecked", m_bean) == 1) {
			result = true;
		}		
		return result;
	}
	
	
	
	
	
	
	// 회원 탈퇴
	public void loginDelete(String user_id) {
		sqlsession.delete("Member.loginDelete", user_id);
	}
	
	// 회원 탈퇴
	public void memberdelete(String user_id) {
		sqlsession.delete("Member.memberdelete", user_id);
	}
	
	
	// 회원가입 
	public boolean join(MemberBean bean) {
		boolean check = false;
		if(sqlsession.insert("Member.join", bean) == 1) {
			check = true;
		}
		return check;
	}

	
	// id 중복 체크
	public boolean checkId(String id) {
		boolean check = false;
		if((Integer)sqlsession.selectOne("Member.checkid", id) == 1) {
			check = true;
		}
		return check;
	}
	
	// name 중복 체크
	public boolean checkName(String user_name) {
		boolean check = false;
		if((Integer)sqlsession.selectOne("Member.checkName", user_name) == 1) {
			check = true;
		}
		return check;
	}
	
	// email 중복 체크
	public boolean checkEmail(String user_email) {
		boolean check = false;
		if((Integer)sqlsession.selectOne("Member.checkEmail", user_email) == 1) {
			check = true;
		}
		return check;
	}
	
	
	
	
	// 로그인
	public Map<String, String> login(String id, String pw) {
		HashMap<String, String> datas = new HashMap<>();
		datas.put("id", id);
		datas.put("pw", pw);
		
		Map<String, String> loginDatas = sqlsession.selectOne("Member.login", datas);
		return loginDatas;
	}
	
	
	
	// 회원정보 가져오기
	public MemberBean getMemberDetail(String user_id) {
		return sqlsession.selectOne("Member.getMemberDetail", user_id);
	}
	
	

	// 회원정보 수정
	public boolean updateuser(MemberBean memberBean) {
		boolean result = false;
		if(sqlsession.update("Member.updateuser", memberBean) != 0) {
			result = true;
		}		
		return result;
	}
	
	
	// 비밀번호 변경
	public boolean newPw(MemberBean memberBean) {
		boolean result = false;
		if(sqlsession.update("Member.newPw", memberBean) != 0) {
			result = true;
		}		
		return result;
	}
	
	

}














