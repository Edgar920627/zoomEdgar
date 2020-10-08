package com.dohwaji.app.member;

import java.io.File;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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

public class MemberDeleteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

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

		String user_id = request.getParameter("user_id");

//		int bbs_num = Integer.parseInt(request.getParameter("bbs_num"));

		// 파일 업로드 위치

		List<BbsBean> bbsNumList = b_dao.listBbs_num(user_id);

		bbsNumList.add(b_bean);

		for (int i = 0; i < bbsNumList.size(); i++) {

			int bbs_num = bbsNumList.get(i).getBbs_num();

			if (bbs_num > 0) {

				String saveFolder = ProjectConfig.BBS_UPLOAD_LOCATION;

				for (BbsFilesBean file : bf_dao.getBbsFilesDetail(bbs_num)) {
					File f = new File(saveFolder + "\\" + file.getBbs_file_name());
					if (f.exists()) {
						f.delete();
					}
				}

				// 댓글 추천
				br_dao.bbs_delete(bbs_num);

				// 댓글 전체 삭제
				br_dao.deleteReply(bbs_num);

				// 게시글 첨부파일 삭제
				bf_dao.deleteBbsFiles(bbs_num);

				// 게시글 삭제
				b_dao.deleteBbs(bbs_num);

				b_bean = b_dao.getBbsDetail(bbs_num);

				System.out.println(i + ".  [ getBbsDetail bbs_num ] = " + bbs_num);
			}

		}

		List<BbsReplyBean> listReply_num = br_dao.listReply_num(user_id);
		System.out.println(" [ listReply_num ] = " + listReply_num);
		listReply_num.add(br_bean);

		for (int i = 0; i < listReply_num.size(); i++) {

			int reply_num = listReply_num.get(i).getReply_num();

			if (reply_num > 0) {

				// 댓글 추천 삭제
				br_dao.replyLikeDel(reply_num);

			}
		}

		// 댓글 삭제
		br_dao.idReplydel(user_id);

		// 세션 초기화
		session.invalidate();

		// 로그 기록 삭제
		m_dao.loginDelete(user_id);

		// 회원 삭제
		m_dao.memberdelete(user_id);

		m_bean = m_dao.getMemberDetail(user_id);

		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/index.jsp");

		return forward;
	}

}
