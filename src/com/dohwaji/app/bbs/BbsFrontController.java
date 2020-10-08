package com.dohwaji.app.bbs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;

public class BbsFrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

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

		// 게시글 목록
		if (command.equals("/bbs/BbsList.bb")) {
			action = new BbsListAction();

			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

			// 게시글 검색 기능
		} else if (command.equals("/bbs/BbsSearchList.bb")) {
			action = new BbsSearchListAction();

			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

			// 게시글 작성
		} else if (command.equals("/bbs/BbsWrite.bb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/bbs/bbsWrite.jsp");

			// 게시글 등록
		} else if (command.equals("/bbs/BbsWriteOk.bb")) {
			action = new BbsWriteOkAction();

			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

			// 게시글 상세보기
		} else if (command.equals("/bbs/BbsView.bb")) {
			action = new BbsViewAction();

			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
			
			
			// 댓글 =  최신순 & 추천순 & 평점순 
		} else if (command.equals("/bbs/BbsReplyResultView.bb")) {
			action = new BbsReplyResultViewAction();
			
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

			
			// 게시글 파일 다운로드
		} else if (command.equals("/bbs/BbsFileDownload.bb")) {
			action = new BbsFileDownloadAction();
			try {
				action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

			// 게시글 수정 정보 입력
		} else if (command.equals("/bbs/BbsModify.bb")) {
			action = new BbsModifyAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

			// 게시글 수정 확인
		} else if (command.equals("/bbs/BbsModifyOk.bb")) {
			action = new BbsModifyOkAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

			
			// 게시글 삭제
		} else if (command.equals("/bbs/bbsDeleteOk.bb")) {
			action = new BbsDeleteOkAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

			
			
			// 댓글 등록
		} else if (command.equals("/bbs/BbsReplyOk.bb")) {
			String mode = req.getParameter("mode");
			// 등록
			if (mode.equalsIgnoreCase("add")) {
				action = new BbsReplyOkAction();
				try {
					forward = action.execute(req, resp);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			// 댓글 추천 +1
		} else if (command.equals("/bbs/BbsReplyLikeOk.bb")) {
			action = new BbsReplyLikeOkAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}
			
			
			// 댓글 삭제
		} else if (command.equals("/bbs/ReplyDeleteOk.bb")) {
			action = new ReplyDeleteOkAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				System.out.println(e);
			}

			
			
			
			// 오류 404 페이지
		} else {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/error/404.jsp");
		}

		// 일괄처리
		if (forward != null) {
			if (forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			} else {
				// forward를 함
				RequestDispatcher dispather = req.getRequestDispatcher(forward.getPath());
				dispather.forward(req, resp);
			}
		}
	}
}