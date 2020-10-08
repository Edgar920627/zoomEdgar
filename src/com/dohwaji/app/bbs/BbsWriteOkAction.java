package com.dohwaji.app.bbs;

import java.io.PrintWriter;





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.bbs.dao.BbsBean;
import com.dohwaji.app.bbs.dao.BbsDAO;
import com.dohwaji.app.bbs.dao.BbsFilesBean;
import com.dohwaji.app.bbs.dao.BbsFilesDAO;
import com.dohwaji.config.ProjectConfig;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BbsWriteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		BbsBean b_bean = new BbsBean();
		BbsDAO b_dao = new BbsDAO();
		BbsFilesBean bf_bean = new BbsFilesBean();
		BbsFilesDAO bf_dao = new BbsFilesDAO();

		ActionForward forward = new ActionForward();
		

		

//		servlet.com/cos : 파일 업로드 라이브러리
//		requset.getServletContext().getRealPath("/") : 서버 경로
		String saveFolder = ProjectConfig.BBS_UPLOAD_LOCATION;
		int fileSize = 5 * 1024 * 1024; // 5M
		boolean b_result = false;
		boolean bf_result = false;

		String bbs_title = null;
		String bbs_explantion = null;
		
		
		String bbs_smalldiv = null;
		String bbs_maindiv = null;
		
		 String avgPoint = "☆☆☆☆☆";
		 int commentCount = 0;
		 int avgValue     = 0;
		
		
		String user_id = (String) request.getSession().getAttribute("session_id");
		

		
		bbs_title = b_bean.getBbs_title();
		bbs_explantion = b_bean.getBbs_explanation();
		bbs_smalldiv = b_bean.getBbs_maindiv();
		bbs_maindiv = b_bean.getBbs_smalldiv();
		
		
//		avgPoint = b_bean.getAvgPoint();
//		avgValue = b_bean.getAvgValue();
//		commentCount = b_bean.getCommentCount();
		
		b_bean.setAvgPoint(avgPoint);
		b_bean.setAvgValue(avgValue);
		b_bean.setCommentCount(commentCount);
		
		System.out.println(bbs_title);

		try {
			MultipartRequest multi = null;

			multi = new MultipartRequest(request, saveFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());

			b_bean.setBbs_maindiv(multi.getParameter("bbs_maindiv"));
			b_bean.setBbs_smalldiv(multi.getParameter("bbs_smalldiv"));
			b_bean.setBbs_title(multi.getParameter("bbs_title"));
			b_bean.setBbs_explanation(multi.getParameter("bbs_explantion"));
			b_bean.setUser_id(multi.getParameter("user_id"));
		

		
			
			System.out.println("b_bean.getBbs_title() = " + b_bean.getBbs_title());
			
			
			
		
			
			
			// 게시글 실패 및  게시글 등록 조건
			if(b_bean.getUser_id() == "") {
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('게시글 등록 실패. 로그인을 해주세요');history.back();");
				out.println("</script>");
				out.close();
				return null;
		
			}
			
			// 제목 글자수 제한
			String title = b_bean.getBbs_explanation();
			if(title.length() > 200 && title.length() > 0) {
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('게시글 등록 실패. 제목 글자 수 제한 있습니다.');history.back();");
				out.println("</script>");
				out.close();
				return null;
		
			}
			
			
			// 내용 글자수 제한
			String explanation = b_bean.getBbs_explanation();
			if(explanation.length() > 2000 && explanation.length() > 0) {
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('게시글 등록 실패. 내용 글자 수 제한 있습니다.');history.back();");
				out.println("</script>");
				out.close();
				return null;
		
			}
			
			
			
			// 분류 입력 안했을시 팝업창
			String smalldiv = "";
			String maindiv = "";
			bbs_smalldiv = b_bean.getBbs_smalldiv();
			bbs_maindiv = b_bean.getBbs_maindiv();
			if(smalldiv.equals(bbs_smalldiv) || maindiv.equals(bbs_maindiv)) {
				
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('게시글 등록 실패. 분류 확인 해주세요');history.back();");
				out.println("</script>");
				out.close();
				return null;
		
			}
			
			
			
			System.out.println("11");
			

			
			
		
			
			b_result = b_dao.insertBbs(b_bean);
			
			System.out.println(" [ b_dao.getBbsSeq() ] =" + b_dao.getBbsSeq());
			
			
			bf_result = bf_dao.insertBbsFile(multi, b_dao.getBbsSeq());

			// null , 공백 글쓰기 등록 수정중

			if (!b_result || !bf_result) {
			
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script>");
				out.println("alert('게시글 등록 실패. 다시 시도해주세요.');");
				out.println("</script>");
				out.close();
				return null;


			}
		
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() + "/bbs/BbsList.bb");
			
			return forward;

		} catch (Exception e) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('게시글 수정 실패. 다시 시도해주세요.');history.back();");
			out.println("</script>");
			out.close();
			System.out.println(e);
			return null;
		}

		
	}
}
