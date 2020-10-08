package com.dohwaji.app.bbs;

import java.io.File;
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

public class BbsModifyOkAction implements Action {


	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("start ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		BbsBean b_bean = new BbsBean();
		BbsDAO b_dao = new BbsDAO();
		BbsFilesBean bf_bean = new BbsFilesBean();
		BbsFilesDAO bf_dao = new BbsFilesDAO();

		ActionForward forward = new ActionForward();

		String saveFolder = ProjectConfig.BBS_UPLOAD_LOCATION;
		int fileSize = 5 * 1024 * 1024; // 5M
		


		try {
			MultipartRequest multi = null;
			multi = new MultipartRequest(request, saveFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());

			System.out.println("multi");
			
			int bbs_num = Integer.parseInt(multi.getParameter("bbs_num"));
			System.out.println("1");
			String bbs_title = multi.getParameter("bbs_title");
			System.out.println("2");
			String bbs_explanation = multi.getParameter("bbs_explanation");
			String bbs_smalldiv = multi.getParameter("bbs_smalldiv");
			System.out.println("3");
			String bbs_maindiv = multi.getParameter("bbs_maindiv");
			String user_id = multi.getParameter("user_id");
			

			
//			b_bean.setBbs_num(Integer.parseInt(multi.getParameter("bbs_num")));
//			b_bean.setBbs_maindiv(multi.getParameter("bbs_maindiv"));
//			b_bean.setBbs_smalldiv(multi.getParameter("bbs_smalldiv"));
//			b_bean.setBbs_title(multi.getParameter("bbs_title"));
//			b_bean.setBbs_explanation(multi.getParameter("bbs_explantion"));
//			b_bean.setUser_id(multi.getParameter("user_id"));
			
			
			System.out.println("[ bbs_num ] = " + bbs_num);
			System.out.println("[ bbs_title ] = " + bbs_title);
			System.out.println("[ bbs_explanation ] = " + bbs_explanation);
			System.out.println("[ user_id ] = " + user_id);
			System.out.println("[ bbs_maindiv ] = " + bbs_maindiv);
			System.out.println("[ bbs_smalldiv ] = " + bbs_smalldiv);

			for(BbsFilesBean file : bf_dao.getBbsFilesDetail(bbs_num)) {
				File f = new File(saveFolder + "\\" + file.getBbs_file_name());
				if(f.exists()) {f.delete();}
			}
			bf_dao.deleteBbsFiles(bbs_num);
			
			
			
			b_bean.setBbs_num(bbs_num);
			b_bean.setBbs_title(bbs_title);
			b_bean.setBbs_explanation(bbs_explanation);
			b_bean.setBbs_maindiv(bbs_maindiv);
			b_bean.setBbs_smalldiv(bbs_smalldiv);
			
			b_dao.updateBbs(b_bean);

			bf_dao.insertBbsFile(multi, bbs_num);
			
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath(request.getContextPath() + "/bbs/BbsView.bb?bbs_num="+bbs_num);
			
			
			System.out.println("end ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			
		} catch (Exception e) {
			System.out.println(e);
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('게시글 수정 실패. 다시 시도해주세요.');history.back();");
			out.println("</script>");
			out.close();
		}
		return forward;
	}
}












