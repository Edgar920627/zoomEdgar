package com.dohwaji.app.bbs;

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

public class BbsReplyResultViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		BbsBean b_bean = new BbsBean();
		BbsDAO b_dao = new BbsDAO();
		BbsFilesDAO bf_dao = new BbsFilesDAO();
		BbsReplyBean br_bean = new BbsReplyBean();
		BbsReplyDAO br_dao = new BbsReplyDAO();

		int bbs_num = Integer.parseInt(request.getParameter("bbs_num"));

		String user_id = request.getParameter("user_id");

		b_dao.readCount(bbs_num);

		b_bean = b_dao.getBbsDetail(bbs_num);
		List<BbsFilesBean> bbsFilesBeanList = bf_dao.getBbsFilesDetail(bbs_num);

//		List<BbsReplyBean> bbsReplyList = br_dao.getBbsReply(bbs_num);
//		System.out.println("3. bbsReplyList " + bbsReplyList);

		// 페이징 처리 [ 1 ... 10 ]
		// 임시 페이지
		String temp = request.getParameter("page");

		int page = temp == null ? 1 : Integer.parseInt(temp);
		int pageSize = 10;

		// 해당 댓글 갯수
		int totalCnt = br_dao.getBbsReplyCnt(bbs_num);

		// 한페이지 게시물 갯수 끝
		int endRow = page * 10;
		// 한페이지 게시물 갯수 시작
		int startRow = endRow - 9;
		int startPage = ((page - 1) / pageSize) * pageSize + 1;
		int endPage = startPage + 9;
		int totalPage = (totalCnt - 1) / pageSize + 1;

		endPage = endPage > totalPage ? totalPage : endPage;

		// 별점 모양 ★★★★★
		String avgPoint = "☆☆☆☆☆";
		
		
		// 댓글 있을경우
		if (br_dao.getBbsReplyCnt(bbs_num) > 0 && br_dao.getBbsReplyCnt(bbs_num) != 0) {

			// 별점 1점 ~ 5점
			int pointCoun0 = br_dao.starZeroCnt(bbs_num);
			int pointCoun1 = br_dao.starOneCnt(bbs_num);
			int pointCoun2 = br_dao.starTwoCnt(bbs_num);
			int pointCoun3 = br_dao.starThreeCnt(bbs_num);
			int pointCoun4 = br_dao.starFourCnt(bbs_num);
			int pointCoun5 = br_dao.starFiveCnt(bbs_num);

			b_bean.setPointCount0(pointCoun0);
			b_bean.setPointCount1(pointCoun1);
			b_bean.setPointCount2(pointCoun2);
			b_bean.setPointCount3(pointCoun3);
			b_bean.setPointCount4(pointCoun4);
			b_bean.setPointCount5(pointCoun5);

			int tempScore = (pointCoun1 * 1) + (pointCoun2 * 2) + (pointCoun3 * 3) + (pointCoun4 * 4)
					+ (pointCoun5 * 5);

			System.out.println("tempScore = " + tempScore);

			int commentCount = br_dao.getBbsReplyCnt(bbs_num);
			int avgValue = tempScore / commentCount;

			System.out.println("commentCount = " + commentCount);
			System.out.println("avgValue = " + avgValue);


	
			if (b_bean.getAvgValue() == 5) {
				avgPoint = "★★★★★";
				b_bean.setAvgPoint(avgPoint);
			} else if (b_bean.getAvgValue() == 4) {
				avgPoint = "★★★★☆";
				b_bean.setAvgPoint(avgPoint);

			} else if (b_bean.getAvgValue() == 3) {
				avgPoint = "★★★☆☆";
				b_bean.setAvgPoint(avgPoint);

			} else if (b_bean.getAvgValue() == 2) {
				avgPoint = "★★☆☆☆";
				b_bean.setAvgPoint(avgPoint);

			} else if (b_bean.getAvgValue() == 1) {
				avgPoint = "★☆☆☆☆";
				b_bean.setAvgPoint(avgPoint);


			} else if (b_bean.getAvgValue() == 0) {
				avgPoint = "☆☆☆☆☆";
				b_bean.setAvgPoint(avgPoint);
			} else {
				System.out.println("별점 오류");
			}

			avgPoint = b_bean.getAvgPoint();
			
			System.out.println("avgPoint = "+b_bean.getAvgPoint()  + " = " + avgPoint);
			
			b_bean.setBbs_num(bbs_num);
			
			// 평균점수
			b_bean.setAvgValue(avgValue);

			// 댓글 갯수
			b_bean.setCommentCount(commentCount);
			
			
			b_bean.setAvgPoint(avgPoint);
			
			
			b_dao.bbsStars(b_bean);
			
			
			
			session.setAttribute("session_avgPoint", b_bean.getAvgPoint());
			session.setAttribute("session_avgValue", b_bean.getAvgValue());
			session.setAttribute("session_commentCount", b_bean.getCommentCount());
			
			
		}

//		result	=	latest && likeCount  &&  grade
		// 최신순 , 평점순, 추천순

		String result = "";
		result = request.getParameter("result");
		System.out.println(result);

		if (result.equals("latest")) { // 최신순

			// 댓글 리스트 페이징 처리
			List<BbsReplyBean> bbsReplyList = br_dao.getBbsReplyList(startRow, endRow, bbs_num);
			request.setAttribute("bbsReplyList", bbsReplyList);

		} else if (result.equals("likeCount")) { // 추천순

			List<BbsReplyBean> bbsReplyList = br_dao.replyLikeCntList(startRow, endRow, bbs_num);
			request.setAttribute("bbsReplyList", bbsReplyList);

		} else if (result.equals("grade")) { // 평점순

			List<BbsReplyBean> bbsReplyList = br_dao.replyStarList(startRow, endRow, bbs_num);
			request.setAttribute("bbsReplyList", bbsReplyList);
			

		} else {
			
			// 댓글 리스트 페이징 처리
			List<BbsReplyBean> bbsReplyList = br_dao.getBbsReplyList(startRow, endRow, bbs_num);
			request.setAttribute("bbsReplyList", bbsReplyList);
		}

		System.out.println();

		if (b_bean != null) {

			request.setAttribute("totalPage", totalPage);
			request.setAttribute("totalCnt", totalCnt);
			request.setAttribute("nowPage", page);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);


			request.setAttribute("bbsBean", b_bean);
			request.setAttribute("bbs_num", bbs_num);
			request.setAttribute("result", result);

			if (bbsFilesBeanList != null) {
				request.setAttribute("bbsFilesBeanList", bbsFilesBeanList);
			}

			ActionForward forward = new ActionForward();

			forward.setRedirect(false);

			forward.setPath("/app/bbs/bbsView.jsp");

			return forward;
		}

		return null;
	}

}