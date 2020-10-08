package com.dohwaji.app.bbs;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dohwaji.action.Action;
import com.dohwaji.action.ActionForward;
import com.dohwaji.app.bbs.dao.BbsBean;
import com.dohwaji.app.bbs.dao.BbsDAO;
import com.dohwaji.app.member.dao.MemberBean;
import com.dohwaji.app.member.dao.MemberDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import oracle.net.aso.i;

public class BbsSearchListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		System.out.println("seachlist ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

		MemberBean m_bean = new MemberBean();
		MemberDAO m_dao = new MemberDAO();
		BbsBean b_bean = new BbsBean();
		BbsDAO b_dao = new BbsDAO();

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ActionForward forward = new ActionForward();

		String bbs_title = "";
		String user_id = "";
		String bbs_explanation = "";
		String bbs_result = "";

		int bbs_likeCount = 0;
		int bbs_readcount = 0;

		// 임시 페이지
		String temp = request.getParameter("page");
		// 대분류
		String bbs_maindiv = request.getParameter("bbs_maindiv");
		
		
		// 공지사항
		request.setAttribute("noticeBbs", b_dao.noticeBbs());

		if (bbs_maindiv == "인터넷방송") {
			System.out.println("bbs_maindiv = " + bbs_maindiv);
			b_bean.setBbs_maindiv("bbs_maindiv");
		}

		// 소분류 ( 전체 , 자유게시판, 질문/답변, 기타 )
		String bbs_smalldiv = request.getParameter("bbs_smalldiv");
		b_bean.setBbs_smalldiv("bbs_smalldiv");

		//
		user_id = b_bean.getUser_id();

		// 최신 조회수 추천순 댓글 순
		bbs_result = request.getParameter("bbs_result");

		b_bean.setBbs_title("bbs_title");
		b_bean.setBbs_explanation("bbs_explanation");
		b_bean.setUser_id("user_id");

		// 제목 내용 글쓴이 댓글
		String bbs_target = request.getParameter("bbs_target");

		// 검색 창
		String bbs_search = request.getParameter("bbs_search");

		String all_target = "";

		// 추천 순
		b_bean.setBbs_likeCount(bbs_likeCount);

		// 조회순
		b_bean.setBbs_readcount(bbs_readcount);

		// 이전 1 ~ 10 다음 페이지




		System.out.println("[ bbs_target ] =" + bbs_target);
		System.out.println("[ bbs_maindiv ] =" + bbs_maindiv);
		System.out.println("[ bbs_smalldiv ] =" + bbs_smalldiv);
		System.out.println("[ bbs_title ] =" + bbs_title);
		System.out.println("[ bbs_explanation ] =" + bbs_explanation);
		System.out.println("[ bbs_likeCount ] =" + bbs_likeCount);
		System.out.println("[ bbs_readcount ] =" + bbs_readcount);





		System.out.println("bbs_result = " + bbs_result);

		

		
		

		
		
		
		if (bbs_maindiv.equals("전체")) {
			
			
			bbs_title = "";
			user_id = "";
			bbs_explanation = "";
			


			int page = temp == null ? 1 : Integer.parseInt(temp);
			int pageSize = 10;
			// 게시물 수
//			int totalMainDivCnt = b_dao.getBbsMainDivCnt(bbs_maindiv);
			int totalCnt = b_dao.getBbsCnt();
			
			
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

			request.setAttribute("totalPage", totalPage);
			request.setAttribute("totalCnt", totalCnt);
			request.setAttribute("nowPage", page);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			
			if(bbs_result == null ) {
				bbs_result = "최신순";
			}
			if(bbs_target == null ) {
				bbs_target = "전체";
			}
			
			
			request.setAttribute("bbsList", b_dao.getBbsList(startRow, endRow, bbs_title, bbs_explanation, user_id));
			
			if(bbs_result.equals("latest")) {
				bbs_result = "최신순";
			}else if(bbs_result.equals("read")) {
				bbs_result = "조회순";
				
			}else if(bbs_result.equals("likeCount")) {
				
				bbs_result = "추천순";
			}else if(bbs_result.equals("comment")) {
				
				bbs_result = "댓글순";
			}else {
				
				bbs_result = "최신순";
				
			}
	
			
			if(bbs_target.equals("all_target")) {
				bbs_target = "전체";
			}else if(bbs_target.equals("bbs_title")) {
				bbs_target = "제목";
				
			}else if(bbs_target.equals("bbs_explanation")) {
				
				bbs_target = "내용";
			}else if(bbs_target.equals("user_id")) {
				
				bbs_target = "글쓴이";
			}else {
				
				bbs_target = "전체";
				
			}
	
			
			
			
			System.out.println("카테고리 전체 = " + bbs_maindiv);
	
			
			// 게시물 수
			
			
			System.out.println("[ totalCnt ] = "+totalCnt);
			
			
			System.out.println("------------------------------------");
			System.out.println("MainDivList [ page _ 현재페이지 ] = "+ page);
			System.out.println("MainDivList [ pageSize _ 페이지 수] = "+ pageSize);
			System.out.println("MainDivList [ totalCnt _ 게시글 갯수] = "+ totalCnt);
			System.out.println("MainDivList [ endRow _ 게시글 끝 수] = "+ endRow);
			System.out.println("MainDivList [ startRow _ 게시글 시작 수] = "+ startRow);
			System.out.println("MainDivList [ startPage _ 시작페이지 ] = "+ startPage);
			System.out.println("MainDivList [ endPage _ 끝 페이지] = "+ endPage);
			System.out.println("MainDivList [ totalPage _ 총 페이지 수] = "+ totalPage);
			

			System.out.println("------------------------------------");
			
			


			// 카테고리 대분류 메뉴   전체 대 분류 뺴고 그외 전부
		} else if (!(bbs_maindiv.equals("전체")) && (bbs_smalldiv == null || bbs_smalldiv == "")) {
			
			bbs_title = "";
			user_id = "";
			bbs_explanation = "";
			bbs_smalldiv = "";


			int page = temp == null ? 1 : Integer.parseInt(temp);
			int pageSize = 10;
			// 게시물 수
			int totalMainDivCnt = b_dao.getBbsMainDivCnt(bbs_maindiv);
//			int totalCnt = b_dao.getBbsCnt();
			
			int noticeCnt = b_dao.noticeCnt();
			
		
			
			System.out.println(" [ noticeCnt ] " + noticeCnt);
			System.out.println(" [ totalMainDivCnt ] " + totalMainDivCnt);

			// 한페이지 게시물 갯수 끝
			int endRow = page * 10;
			// 한페이지 게시물 갯수 시작
			int startRow = endRow - 10;
			int startPage = ((page - 1) / pageSize) * pageSize + 1;
			int endPage = startPage + 9;
			int totalPage = (totalMainDivCnt - 1) / pageSize + 1;

			endPage = endPage > totalPage ? totalPage : endPage;

			request.setAttribute("totalPage", totalPage);
			request.setAttribute("totalCnt", totalMainDivCnt);
			request.setAttribute("nowPage", page);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			
			
			System.out.println("------------------------------------");
			System.out.println("MainDivList [ page _ 현재페이지 ] = "+ page);
			System.out.println("MainDivList [ pageSize _ 페이지 수] = "+ pageSize);
			System.out.println("MainDivList [ totalMainDivCnt _ 게시글 갯수] = "+ totalMainDivCnt);
			System.out.println("MainDivList [ endRow _ 게시글 끝 수] = "+ endRow);
			System.out.println("MainDivList [ startRow _ 게시글 시작 수] = "+ startRow);
			System.out.println("MainDivList [ startPage _ 시작페이지 ] = "+ startPage);
			System.out.println("MainDivList [ endPage _ 끝 페이지] = "+ endPage);
			System.out.println("MainDivList [ totalPage _ 총 페이지 수] = "+ totalPage);
			System.out.println("------------------------------------");
			
			

			
			
			System.out.println("카테고리 메뉴 진입  = " + bbs_maindiv + " _ " + bbs_smalldiv);

			request.setAttribute("bbsList", b_dao.listMainDivAll(startRow, endRow, bbs_maindiv));

		} else {
			
			
			bbs_title = "";
			user_id = "";
			bbs_explanation = "";


			int page = temp == null ? 1 : Integer.parseInt(temp);
			int pageSize = 10;
			// 게시물 수
			int totalMainDivCnt = b_dao.getBbsMainDivCnt(bbs_maindiv);
//			int totalCnt = b_dao.getBbsCnt();
			
			int noticeCnt = b_dao.noticeCnt();
			

			
			System.out.println(" [ noticeCnt ] " + noticeCnt);
			System.out.println(" [ totalMainDivCnt ] " + totalMainDivCnt);

			// 한페이지 게시물 갯수 끝
			int endRow = page * 10;
			// 한페이지 게시물 갯수 시작
			int startRow = endRow - 10;
			int startPage = ((page - 1) / pageSize) * pageSize + 1;
			int endPage = startPage + 9;
			int totalPage = (totalMainDivCnt - 1) / pageSize + 1;

			endPage = endPage > totalPage ? totalPage : endPage;

			request.setAttribute("totalPage", totalPage);
			request.setAttribute("totalCnt", totalMainDivCnt);
			request.setAttribute("nowPage", page);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			
			
			System.out.println("------------------------------------");
			System.out.println("MainDivList [ page _ 현재페이지 ] = "+ page);
			System.out.println("MainDivList [ pageSize _ 페이지 수] = "+ pageSize);
			System.out.println("MainDivList [ totalMainDivCnt _ 게시글 갯수] = "+ totalMainDivCnt);
			System.out.println("MainDivList [ endRow _ 게시글 끝 수] = "+ endRow);
			System.out.println("MainDivList [ startRow _ 게시글 시작 수] = "+ startRow);
			System.out.println("MainDivList [ startPage _ 시작페이지 ] = "+ startPage);
			System.out.println("MainDivList [ endPage _ 끝 페이지] = "+ endPage);
			System.out.println("MainDivList [ totalPage _ 총 페이지 수] = "+ totalPage);
			System.out.println("------------------------------------");
			
			

			

			// 조회 순 > 대.소 분류 > ALL 제목 . 내용 . 글쓴이
			if (bbs_result.equals("read") || bbs_result.equals("조회순")) {
				System.out.println("read");

				bbs_result = "조회순";

				if (bbs_target.equals("bbs_title") || bbs_target.equals("제목")) {
					bbs_title = bbs_search;
					user_id = "";
					bbs_explanation = "";

					System.out.println("read _ bbs_title = " + bbs_target);

					request.setAttribute("bbsList", b_dao.divRead(startRow, endRow, bbs_maindiv, bbs_smalldiv,
							bbs_title, bbs_explanation, user_id));

					bbs_target = "제목";

				} else if (bbs_target.equals("all_target") || bbs_target.equals("전체")) {

					bbs_title = "";
					user_id = "";
					bbs_explanation = "";

					System.out.println("read _ all_target = " + bbs_target);

					request.setAttribute("bbsList", b_dao.divAllRead(startRow, endRow, bbs_maindiv, bbs_smalldiv,
							bbs_title, bbs_explanation, user_id));

					bbs_target = "전체";

				} else if (bbs_target.equals("bbs_explanation") || bbs_target.equals("내용")) {
					bbs_title = "";
					user_id = "";
					bbs_explanation = bbs_search;
					System.out.println("read bbs_explanation = " + bbs_target);
					request.setAttribute("bbsList", b_dao.divRead(startRow, endRow, bbs_maindiv, bbs_smalldiv,
							bbs_title, bbs_explanation, user_id));

					bbs_target = "내용";

				} else if (bbs_target.equals("user_id") || bbs_target.equals("글쓴이")) {

					user_id = bbs_search;
					System.out.println("read user_id = " + bbs_target);
					request.setAttribute("bbsList", b_dao.divRead(startRow, endRow, bbs_maindiv, bbs_smalldiv,
							bbs_title, bbs_explanation, user_id));

					bbs_target = "글쓴이";

				}
			}

			// 최신 순 > 대.소 분류 > ALL 제목 . 내용 . 글쓴이

			if (bbs_result.equals("latest") || bbs_result.equals("최신순")) {
				System.out.println("- latest");

				bbs_result = "최신순";

				if (bbs_target.equals("bbs_title") || bbs_target.equals("제목")) {
					bbs_title = bbs_search;
					System.out.println("latest _ bbs_title = " + bbs_target);
					request.setAttribute("bbsList", b_dao.divLatest(startRow, endRow, bbs_maindiv, bbs_smalldiv,
							bbs_title, bbs_explanation, user_id));
					bbs_target = "제목";

				} else if (bbs_target.equals("all_target") || bbs_target.equals("전체")) {

					System.out.println("latest _ all_target = " + bbs_target);
					request.setAttribute("bbsList", b_dao.divAllLatest(startRow, endRow, bbs_maindiv, bbs_smalldiv,
							bbs_title, bbs_explanation, user_id));

					bbs_target = "전체";

				} else if (bbs_target.equals("bbs_explanation") || bbs_target.equals("내용")) {
					bbs_explanation = bbs_search;
					System.out.println("latest _ bbs_explanation = " + bbs_target);
					request.setAttribute("bbsList", b_dao.divLatest(startRow, endRow, bbs_maindiv, bbs_smalldiv,
							bbs_title, bbs_explanation, user_id));

					bbs_target = "내용";

				} else if (bbs_target.equals("user_id") || bbs_target.equals("글쓴이")) {

					user_id = bbs_search;
					System.out.println("latest _ user_id = " + bbs_target);
					request.setAttribute("bbsList", b_dao.divLatest(startRow, endRow, bbs_maindiv, bbs_smalldiv,
							bbs_title, bbs_explanation, user_id));

					bbs_target = "글쓴이";

				}
			}

			// 추천 순 > 대.소 분류 > ALL 제목 . 내용 . 글쓴이
			if (bbs_result.equals("likeCount") || bbs_result.equals("추천순")) {

				System.out.println("- likeCount");
				bbs_result = "추천순";

				System.out.println("진입 likeCount = " );
				if (bbs_target.equals("bbs_title") || bbs_target.equals("제목")) {
					bbs_title = bbs_search;
					System.out.println("bbs_title = " + bbs_target);
					request.setAttribute("bbsList", b_dao.divLikeCount(startRow, endRow, bbs_maindiv, bbs_smalldiv,
							bbs_title, bbs_explanation, user_id));

					bbs_target = "제목";

				} else if (bbs_target.equals("all_target") || bbs_target.equals("전체")) {

					System.out.println("all_target = " + bbs_target);
					request.setAttribute("bbsList", b_dao.divAllLikeCount(startRow, endRow, bbs_maindiv, bbs_smalldiv,
							bbs_title, bbs_explanation, user_id));

					bbs_target = "전체";

				} else if (bbs_target.equals("bbs_explanation") || bbs_target.equals("내용")) {
					bbs_explanation = bbs_search;
					System.out.println("bbs_explanation = " + bbs_target);
					request.setAttribute("bbsList", b_dao.divLikeCount(startRow, endRow, bbs_maindiv, bbs_smalldiv,
							bbs_title, bbs_explanation, user_id));

					bbs_target = "내용";

				} else if (bbs_target.equals("user_id") || bbs_target.equals("글쓴이")) {

					user_id = bbs_search;
					System.out.println("user_id = " + bbs_target);
					request.setAttribute("bbsList", b_dao.divLikeCount(startRow, endRow, bbs_maindiv, bbs_smalldiv,
							bbs_title, bbs_explanation, user_id));
					bbs_target = "글쓴이";
				}

			}

			// 댓글 순 > 대.소 분류 > ALL 제목 . 내용 . 글쓴이
			if (bbs_result.equals("comment")) {

			}
		}


		request.setAttribute("bbs_maindiv", b_bean.getBbs_maindiv());
		request.setAttribute("bbs_smalldiv", b_bean.getBbs_smalldiv());
		


		// ALL 제목 . 내용 . 글쓴이
		session.setAttribute("session_target", bbs_target);

		// 검색
		session.setAttribute("session_search", bbs_search);

		// 소 분류
		session.setAttribute("session_smalldiv", bbs_smalldiv);

		// 대 분류
		session.setAttribute("session_maindiv", bbs_maindiv);

		// 최신순 , 조회순 , 추천순, 댓글순
		session.setAttribute("session_result", bbs_result);

		System.out.println("end ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		forward.setRedirect(false);
		forward.setPath("/app/bbs/bbsList.jsp");
		return forward;

	}
}
