package com.dohwaji.app.bbs;

import java.io.PrintWriter;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.bbs.dao.BbsBean;
import com.dohwaji.app.bbs.dao.BbsDAO;
import com.dohwaji.app.bbs.dao.BbsReplyBean;
import com.dohwaji.app.bbs.dao.BbsReplyDAO;
import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.member.dao.MemberDAO;


public class BbsListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		MemberBean m_bean = new MemberBean();
		MemberDAO m_dao = new MemberDAO();
		BbsBean b_bean = new BbsBean();
		BbsDAO b_dao = new BbsDAO();
		BbsReplyBean br_bean = new BbsReplyBean();
		BbsReplyDAO br_dao = new BbsReplyDAO();

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		ActionForward forward = new ActionForward();
		
		
		String bbs_title = "";
		String bbs_explanation = "";
		String user_id = "";

		// 대 분류
		String bbs_maindiv = "";
		bbs_maindiv = request.getParameter("bbs_maindiv");
		// 소 분류
		String bbs_smalldiv ="";
		bbs_smalldiv = request.getParameter("bbs_smalldiv");
		// 임시 페이지
		String temp = request.getParameter("page");
		
		
		
		
		
		int bbs_num = 0;
		
		int tempReplyCnt = br_dao.getBbsReplyCnt(bbs_num);
		b_bean.setCommentCount(tempReplyCnt);
		
		request.setAttribute("commentCount", br_dao.getBbsReplyCnt(bbs_num));
		
		
		if(bbs_maindiv == null) {
			bbs_maindiv = "전체";
			
		}
		if(bbs_smalldiv == null) {
			bbs_smalldiv = "전체";
			
		}
		

		// 분류 전체

		System.out.println("1. bbs_maindiv = " + bbs_maindiv);
		System.out.println("2. bbs_smalldiv = " + bbs_smalldiv);
//		b_bean.setBbs_maindiv(bbs_maindiv);
//		b_bean.setBbs_smalldiv(bbs_smalldiv);
		
		
		b_bean.getAvgPoint();
		
		
		
		// 공지사항
		request.setAttribute("noticeBbs", b_dao.noticeBbs());
	
		

		
		
		
		// ip 가져오기  test_1
		InetAddress inet = InetAddress.getLocalHost();
		String svrIP = inet.getHostAddress();
		String login_ip = svrIP;
		session.setAttribute("session_ip", login_ip);
		
		if (bbs_maindiv.equals("전체") && bbs_smalldiv.equals("전체"))  {
			
			System.out.println("1");

			// 이전 1 ~ 10 다음 페이지

			int page = temp == null ? 1 : Integer.parseInt(temp);
			int pageSize = 10;
			
			// 게시물 수
			int totalCnt = b_dao.getBbsCnt();

			// 공지 게시글 갯수
			int noticeCnt = b_dao.noticeCnt();
	
	
			
			System.out.println(" [ noticeCnt ] " + noticeCnt);
			System.out.println(" [ totalCnt ] " + totalCnt);

			// 한페이지 게시물 갯수 끝
			int endRow = page * 10;
			// 한페이지 게시물 갯수 시작
			int startRow = endRow - 10;
			int startPage = ((page - 1) / pageSize) * pageSize + 1;
			int endPage = startPage + 9;
			int totalPage = (totalCnt - 1) / pageSize + 1;

			endPage = endPage > totalPage ? totalPage : endPage;
			
			
			System.out.println("-   [ endRow ] = " + endRow);
			System.out.println("-   [ startRow ] = " + startRow);
			
			
			System.out.println("- 전체 페이지  [ totalPage ] = " + totalPage);
			System.out.println("- 총 게시글 갯수  [ totalCnt ] = " + totalCnt);
			System.out.println("- 현재 페이지  [ nowPage ] = " + page);
			System.out.println("- 첫 페이지  [ startPage ] = " + startPage);
			System.out.println("- 끝 페이지  [ endPage ] = " + endPage);


			request.setAttribute("totalPage", totalPage);
			request.setAttribute("totalCnt", totalCnt);
			request.setAttribute("nowPage", page);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("bbs_maindiv", b_bean.getBbs_maindiv());
			request.setAttribute("bbs_smalldiv", b_bean.getBbs_smalldiv());
			request.setAttribute("bbsList", b_dao.getBbsList(startRow, endRow, bbs_title, bbs_explanation, user_id));
			

		}

		
		// 대분류 
		else {

			// 이전 1 ~ 10 다음 페이지

			int page = temp == null ? 1 : Integer.parseInt(temp);
			int pageSize = 10;
			// 게시물 수
			int totalMainDivCnt = b_dao.getBbsMainDivCnt(bbs_maindiv);
			
			
			int noticeCnt = b_dao.noticeCnt();
			

			
			System.out.println(" [ noticeCnt ] " + noticeCnt);
			System.out.println(" [ totalMainDivCnt ] " + totalMainDivCnt);

			// 한페이지 게시물 갯수 끝
			int endRow = page * 10;
			// 한페이지 게시물 갯수 시작
			int startRow = endRow - 9;
			int startPage = ((page - 1) / pageSize) * pageSize + 1;
			int endPage = startPage + 9;
			int totalPage = (totalMainDivCnt - 1) / pageSize + 1;

			endPage = endPage > totalPage ? totalPage : endPage;
			


			request.setAttribute("totalPage", totalPage);
			request.setAttribute("totalCnt", totalMainDivCnt);
			request.setAttribute("nowPage", page);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			

			
			request.setAttribute("bbs_maindiv", b_bean.getBbs_maindiv());
			request.setAttribute("bbs_smalldiv", b_bean.getBbs_smalldiv());
			request.setAttribute("bbsList", b_dao.listMainDivAll(startRow, endRow, bbs_maindiv));
		
		}
		
		
		
		// 소 분류 
		session.setAttribute("session_smalldiv", bbs_smalldiv);
		
		// 대 분류
		session.setAttribute("session_maindiv", bbs_maindiv);
		


		forward.setRedirect(false);
		forward.setPath("/app/bbs/bbsList.jsp");
		return forward;

	}

}
