package com.dohwaji.app.report;

import java.io.IOException;





import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;



public class ReportFrontController extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		
		
		// 신고 목록
		if (command.equals("/report/ReportList.re")) {

			action = new ReportListAction();

			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

			
			// 신고 접수
		} else if (command.equals("/report/ReportWriteOk.re")) {

			action = new ReportWriteOkAction();

			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

			
			
			
			// 신고  결과  (통과, 삭제)
		} else if (command.equals("/report/ReportResultOk.re")) {
			action = new ReportResultOkAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
			
	
			
			
			
			
			

		} else {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/error/404.jsp");
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
		}
	}
}
