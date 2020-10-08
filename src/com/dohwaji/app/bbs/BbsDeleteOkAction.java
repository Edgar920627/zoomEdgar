package com.dohwaji.app.bbs;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.bbs.dao.BbsBean;
import com.dohwaji.app.bbs.dao.BbsDAO;
import com.dohwaji.app.bbs.dao.BbsFilesBean;
import com.dohwaji.app.bbs.dao.BbsFilesDAO;
import com.dohwaji.app.bbs.dao.BbsReplyBean;
import com.dohwaji.app.bbs.dao.BbsReplyDAO;
import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.member.dao.MemberDAO;

import com.dohwaji.config.ProjectConfig;

public class BbsDeleteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		MemberBean m_bean = new MemberBean();
		MemberDAO m_dao = new MemberDAO();
		BbsBean b_bean = new BbsBean();
		BbsDAO b_dao = new BbsDAO();
		BbsFilesBean bf_bean = new BbsFilesBean();
		BbsFilesDAO bf_dao = new BbsFilesDAO();
		BbsReplyDAO br_dao = new BbsReplyDAO();
		BbsReplyBean br_bean = new BbsReplyBean();
		

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		ActionForward forward = new ActionForward();

		int bbs_num = Integer.parseInt(request.getParameter("bbs_num"));

		// 파일 업로드 위치 
		String saveFolder = ProjectConfig.BBS_UPLOAD_LOCATION;
		
		for (BbsFilesBean file : bf_dao.getBbsFilesDetail(bbs_num)) {
			File f = new File(saveFolder + "\\" + file.getBbs_file_name());
			if (f.exists()) {
				f.delete();
			}
		}
		
		
		int m = bbs_num;
		// 댓글 추천
		br_dao.bbs_delete(m);
		
		
		
		// 댓글 전체 삭제
		br_dao.deleteReply(bbs_num);  
		
		// 게시글 첨부파일 삭제
		bf_dao.deleteBbsFiles(bbs_num);
		
		// 게시글 삭제
		b_dao.deleteBbs(bbs_num);
		
	
		b_bean = b_dao.getBbsDetail(bbs_num);
		

		
		

		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/bbs/BbsList.bb");


		return forward;
	}

}