package com.dohwaji.app.report;

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
import com.dohwaji.app.report.dao.ReportBean;
import com.dohwaji.app.report.dao.ReportDAO;
import com.dohwaji.config.ProjectConfig;

public class ReportResultOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		ActionForward forward = new ActionForward();

		BbsBean b_bean = new BbsBean();
		BbsDAO b_dao = new BbsDAO();
		BbsFilesDAO bf_dao = new BbsFilesDAO();
		BbsReplyBean br_bean = new BbsReplyBean();
		BbsReplyDAO br_dao = new BbsReplyDAO();
		ReportBean r_bean = new ReportBean();
		ReportDAO r_dao = new ReportDAO();
		

		int report_num = Integer.parseInt(request.getParameter("report_num")); // 신고 pk 넘버
		String report_type = request.getParameter("report_type"); // 게시글 타입 ( 게시글, 댓글)

		int pk_num = Integer.parseInt(request.getParameter("pk_num")); // 게시글 넘버, 댓글 넘버

		String report_result = request.getParameter("report_result"); // 결과 통과 삭제
		String report_div = request.getParameter("report_div"); // 구분 성인물 홍보 기타

		String admin = (String) request.getSession().getAttribute("session_id"); // admin 관리자 계정인지 확인
		String div = request.getParameter("div"); // 통과 삭제 구분

		r_bean.setReport_num(report_num);
		r_bean.setReport_type(report_type);
		r_bean.setPk_num(pk_num);
		r_bean.setReport_result(report_result);
		r_bean.setReport_div(report_div);

		// 관리자 계정 확인
		if (!admin.equals("admin")) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('관리자 계정이 아닙니다.');history.back();");
			out.println("</script>");
			out.close();
			return null;
		}

		System.out.println(" [ report_num ] =" + report_num);
		System.out.println(" [ report_type ] =" + report_type);
		System.out.println(" [ pk_num ] =" + pk_num);
		System.out.println(" [ report_result ] =" + report_result);
		System.out.println(" [ report_div ] =" + report_div);
		System.out.println(" [ admin ] =" + admin);
		System.out.println(" [ div ] =" + div);

		System.out.println("r_dao.resultCheck(r_bean) = " + r_dao.resultCheck(r_bean));

		if (!r_dao.resultCheck(r_bean)) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('해당 게시글이 없습니다.');history.back();");
			out.println("</script>");
			out.close();
			return null;
		}

		// 통과
		if (div.equals("pass")) {

			System.out.println("pass");

			r_dao.passReport(r_bean);

		}

		// 삭제
		else if (div.equals("delete")) {
			
			
			// 삭제  통과  판정
			r_dao.deleteReport(r_bean);
			

			if (report_type.equals("게시글")) {

				int bbs_num = pk_num;
				
				
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
				
			}

			else if (report_type.equals("댓글")) {

				
				
				
				int reply_num = pk_num;
				
				// 댓글 추천 전체 삭제
				br_dao.replyLikeDel(reply_num);
				
				
				br_dao.deleteOneReply(reply_num);
				
				
				

			} 
			
			else {

				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('오류 발생');history.back();");
				out.println("</script>");
				out.close();
				return null;

			}
			


		}

		forward.setRedirect(true);
		forward.setPath(request.getContextPath() + "/report/ReportList.re");

		return forward;
	}
}