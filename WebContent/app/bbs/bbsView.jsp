<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.dohwaji.app.member.dao.MemberBean"%>
<%@page import="com.dohwaji.app.member.dao.MemberDAO"%>
<%@page import="com.dohwaji.app.bbs.dao.BbsDAO"%>
<%@page import="com.dohwaji.app.bbs.dao.BbsBean"%>
<%@page import="com.dohwaji.app.bbs.dao.BbsFilesDAO"%>
<%@page import="com.dohwaji.app.bbs.dao.BbsFilesBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 
      <title>${pageContext.request.contextPath}</title>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/app/assets/css/main.css" />
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	  
	  <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>

 	  <!--// plugin-specific resources //-->
 	  <script src="${pageContext.request.contextPath}/app/assets/js/jquery.MetaData.js" type="text/javascript" language="javascript"></script>
  	  <script src="${pageContext.request.contextPath}/app/assets/js/jquery.rating.js" type="text/javascript" language="javascript"></script>
  	  <link href="${pageContext.request.contextPath}/app/assets/css/jquery.rating.css" type="text/css" rel="stylesheet"/>


</head>



<script>

	var stars = 0;
	$(document).ready(function(){ 
		$('#star-container').rating({stars:5,callback:function(value){
		    	 stars = value;
		    	 if(stars != null){
		    		 document.getElementById('stars-point').innerHTML = "&nbsp;&nbsp;"+stars+" 점"; 
		    		 document.getElementById('reply_point').value = stars;
		    	 }else{
		    		 document.getElementById('stars-point').innerHTML = "&nbsp;&nbsp;";
		    		 document.getElementById('reply_point').value = 0;
		    	 }
	     } });
	
	});
</script>   

<style>
table {
 	border: 0px solid #FFFFFF;
}

th, td {
	background-color: #FFFFFF;
	border: 0px solid #FFFFFF;
	

}

      
            a:link {
             
                text-decoration: none;
            }



</style>

<style>

.dropbtn {
  background-color: white;
  color: #ffa500;
  padding: 12px;
  font-size: 12px;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #C0C0C0;}
</style>



<!-- F5 ,  새로고침 방지 -->
<script language="javascript">
    function LockF5() {
        if (event.keyCode == 116) {
            event.keyCode = 0;
            return false;
        }
    }
    document.onkeydown = LockF5;
</script>



<script>
   $(document).ready(function(){ $("#header").load("${pageContext.request.contextPath}/app/include/header.jsp") });
</script>  


<body class="is-preload">
<header id="header"></header>



	 <c:set var="session_id" value="${session_id}"/>
	<c:set var="bbs_num" value="${requestScope.bbs_num}" />
	<c:set var="bbsBean" value="${requestScope.bbsBean}" />
	<c:set var="result" value="${requestScope.result}" />
	<c:set var="bbsFilesBeanList" value="${requestScope.bbsFilesBeanList}" />
	<c:set var="bbsReplyList" value="${requestScope.bbsReplyList}" />
	<c:set var="starCount" value="${requestScope.starCount}" />
	
	
	<c:set var="nowPage" value="${requestScope.nowPage}" />
	<c:set var="startPage" value="${requestScope.startPage}" />
	<c:set var="endPage" value="${requestScope.endPage}" />
	<c:set var="totalCnt" value="${requestScope.totalCnt}" />
	<c:set var="totalPage" value="${requestScope.totalPage}" />

	<jsp:useBean id="br_dao" class="com.dohwaji.app.bbs.dao.BbsReplyDAO"></jsp:useBean>

		<!-- Wrapper -->
	<div class="wrapper">
		<section class="main">
		
			<section>
			

			<!-- 게시글 번호 -->
			

			
			<!-- 게시판 수정 -->
		
			
			
	

				<table style="width: 100%; border: 0px solid #ffa500; background-color: #FFFFFF; color: #000000; font-size: 20px; font-weight: bold;">
				
			

						<colgroup>
				
							<col width="15%" />
							<col width="1%" />
							
							<col width="15%" />
							<col width="30%" />
						</colgroup>
						
					

					<tr height="20px" style="width: 100%; border: 0px solid #ffa500; background-color: #FFFFFF;">
		
						<td align="left" style="padding-left: 10px; font-size: 25px; font-weight: bold; color: #ffa500;">${bbsBean.getBbs_maindiv()}</td>
						<td align="left" style="color: #C0C0C0;">|</td>
					
						<td align="left" style="padding-left: 10px; font-size: 15px; font-weight: bold; color: #ffa500;">${bbsBean.getBbs_smalldiv()}</td>
						
						<td align="right" style="width: 100%; border: 0px solid #ffa500; background-color: #FFFFFF; color: #C0C0C0; font-size: 15px; font-weight: bold;">
						<div>
			<span>&nbsp;&nbsp;번호&nbsp;&nbsp;${bbsBean.getBbs_num()}&nbsp;&nbsp;</span>|
			<span>사용자&nbsp;&nbsp;${bbsBean.getUser_id()}&nbsp;&nbsp;</span>
			</div>
			<div>
			<span>&nbsp;&nbsp;조회수 &nbsp;&nbsp;${bbsBean.getBbs_readcount()}&nbsp;&nbsp;</span>|
			<span>&nbsp;&nbsp;댓글수&nbsp;&nbsp;${bbsBean.getCommentCount()}&nbsp;&nbsp;</span>
			</div>
	
							</td>
						
					
					</tr>
				
			</table>

		<table style="width: 100%; border: 0px solid #ffa500; background-color: #FFFFFF; color: #000000; font-size: 20px; font-weight: bold;">
		
						<colgroup>
							
							<col width="80%" />
							<col width="20%" />
			
						</colgroup>
			
	<thead>
					<!-- 제목, 날자  -->
					<tr height="50px" style="width: 100%; height:100%; border: 0px solid #C0C0C0; background-color: #FFFFFF;">
						
						<td style="padding-left: 10px;">${bbsBean.getBbs_title()}</td>
						
						<td align="right" style="width: 100%; border: 0px solid #ffa500; background-color: #FFFFFF; color: #C0C0C0; font-size: 15px; font-weight: bold;">
						<span>${bbsBean.getBbs_date()}</span>
						</td>
					</tr>
					
						<thead>
					
	



						<tr><td></td></tr>
		
					<!-- 게시글 상세보기  img 구현 -->
					<c:if test="${bbsFilesBeanList != null}">
					<tr  style="width: 100%; height:100%; border: 0px solid #C0C0C0; background-color: #FFFFFF;">

							<td style="padding-left: 10px;" colspan="2">
								<c:forEach var="file" items="${bbsFilesBeanList}">
									<img alt="사진이 아닙니다." src="${pageContext.request.contextPath}/bbs/BbsFileDownload.bb?bbs_file_name=${file.getBbs_file_name()}" 
									style="width: 100%; height:50%;">

								</c:forEach>
							</td>
							
						</tr>
						</c:if>
						
						
						
						
							<tr  style="width: 100%; height:100%; border: 0px solid #C0C0C0; background-color: #FFFFFF;">
								<td height=100px; style="padding-left: 10px;" colspan="2">
								<!-- 공백 및 광고 -->
						
							</td>
						</tr>
						
						
				
						
						<tr height="100px" style="width: 100%; height: 100%; border: 0px solid #C0C0C0; background-color: #FFFFFF;">
							
							<td colspan="2" valign="top" style="padding-top: 10px; padding-left: 10px;">${bbsBean.getBbs_explanation()}</td>
							
						</tr>
					
			<tr  style="width: 100%; height:100%; border: 0px solid #C0C0C0; background-color: #FFFFFF;">
								<td height=100px; style="padding-left: 10px;" colspan="2">
								<!-- 공백 및 광고 -->
						
							</td>
						</tr>
						
		

					</table>
	
	
			<br />
		
						
		
			
			
			<table  style="width: 100%; border: 0px solid #C0C0C0; background-color: #FFFFFF; color: #ffa500; font-size: 20px; font-weight: bold;">
			
					
						<colgroup>
							<col width="10%" />
							<col width="70%" />
							<col width="15%" />
			
						</colgroup>
						
						
			
			
					<tr height="30px" style="width: 100%; border: 0px solid #C0C0C0; background-color: #FFFFFF; color: #ffa500; font-size: 18px; font-weight: bold;">
						<c:if test="${bbsFilesBeanList != null}">
						<td align="left" style="color: #ffa500">첨부파일</td>
						
							<td style="padding-left: 10px;">
								<c:forEach var="file" items="${bbsFilesBeanList}">
									<a href="${pageContext.request.contextPath}/bbs/BbsFileDownload.bb?bbs_file_name=${file.getBbs_file_name()}">
									<div>${file.getBbs_file_name()}</div>
									</a>
								</c:forEach>
							</td>
						</c:if>
						
						
						
						 <!-- 공지사항  일경우 댓글 없에기 -->	
 					<c:if test="${bbsBean.getBbs_maindiv() != '공지' || bbsBean.getBbs_smalldiv() != '공지' }">
						<c:if test="${session_id != null}">	
						<td>
						<div class="dropdown">
  						<a class="dropbtn" class="button" style="font-size: 18px; color: #c10000;">신고</a>
  						<div class="dropdown-content">
   						<a href="${pageContext.request.contextPath}/report/ReportWriteOk.re
						?user_id=${bbsBean.getUser_id()}
						&report_id=${session_id}
						&bbs_num=${bbsBean.getBbs_num()}
						&pk_num=${bbsBean.getBbs_num()}
						&report_type=게시글
						&report_div=성인물"  onclick="return confirm('신고 하시겠습니까?')" >성인물</a>
						
						
   						 <a href="${pageContext.request.contextPath}/report/ReportWriteOk.re
						?user_id=${bbsBean.getUser_id()}
						&report_id=${session_id}
						&bbs_num=${bbsBean.getBbs_num()}
						&pk_num=${bbsBean.getBbs_num()}
						&report_type=게시글
						&report_div=홍보"  onclick="return confirm('신고 하시겠습니까?')" >홍보</a>
						
						
   						<a href="${pageContext.request.contextPath}/report/ReportWriteOk.re
						?user_id=${bbsBean.getUser_id()}
						&report_id=${session_id}
						&bbs_num=${bbsBean.getBbs_num()}
						&pk_num=${bbsBean.getBbs_num()}
						&report_type=게시글
						&report_div=기타" onclick="return confirm('신고 하시겠습니까?')" >기타</a>
  							</div>
						</div>
						
						</td>
						</c:if>
				</c:if>
					</tr> 
			</table>
			
				<br />
			<br />
			<br />
		

	
			

			<table style="width: 100%; border: 0px solid #C0C0C0; background-color: #FFFFFF; color: #ffa500; font-size: 15px; font-weight: bold;">
					<thead>
				<tr align="right" valign="middle" height="30px" style="width: 100%; border: 0px solid #C0C0C0; background-color: #FFFFFF; color: #ffa500; font-size: 20px; font-weight: bold;">
					<td style="font-size: 15px;">
						<c:if test="${bbsBean.getUser_id() eq session_id}">	
							
							<a href="${pageContext.request.contextPath}/bbs/BbsModify.bb?bbs_num=${bbs_num}&bbs_maindiv=${bbsBean.getBbs_maindiv()}&bbs_smalldiv=${bbsBean.getBbs_smalldiv()}" class="button" onclick="return confirm('수정 하시겠습니까?')">
							수정
							</a>&nbsp;&nbsp;
								
							<a href="javascript:deleteBbs()" class="button" onclick="return confirm('삭제 하시겠습니까?')">
							삭제
							</a>&nbsp;&nbsp;
							
						</c:if> 
							

						
						<a href="${pageContext.request.contextPath}/bbs/BbsSearchList.bb?bbs_maindiv=${session_maindiv}&bbs_smalldiv=${session_smalldiv}" class="button">
						목록
						</a>&nbsp;&nbsp;
						
						
						
		
					</td>

				</tr>
				
				<tr>
				<td></td>
				</tr>
						<thead>
			</table>
			
			<br />
			<br />
			<br />
			<br />
			
			

 <!-- 공지사항  일경우 댓글 없에기 -->	
 		<c:if test="${bbsBean.getBbs_maindiv() != '공지' || bbsBean.getBbs_smalldiv() != '공지' }">

			
			<!-- 점수별  별점 -->

			<div class="p_middle" style="width: 100%; height: 100%;">
		
			
			
				<div class="m_left">
					<p class="m1" style="font-size: 20px;">사용자 총 평점 </p>
					<p class="m2" style="font-size: 20px;">${bbsBean.getAvgValue()} / 5</p>
					<p class="m3" style="font-size: 20px;">${bbsBean.getAvgPoint()}</p>
					<p class="m4" style="font-size: 20px;">(총 ${bbsBean.getCommentCount()}개)</p>
				</div>
				
				
				<div class="m_right">
					<table class="m_right_table">
					<colgroup>
						<col width="60%" />
						<col width="40%" />
					</colgroup>
						<c:if test="${bbsBean.getPointCount0() > 0}">
							<tr height="10px;" style="font-size: 15px;"><td class="redzone">☆☆☆☆☆</td><td>${bbsBean.getPointCount0()}개</td></tr>
						</c:if>
						<c:if test="${bbsBean.getPointCount1() > 0}">
							<tr height="10px;" style="font-size: 15px;"><td class="redzone">★☆☆☆☆</td><td>${bbsBean.getPointCount1()}개</td></tr>
						</c:if>						
						<c:if test="${bbsBean.getPointCount2() > 0}">
							<tr height="10px;" style="font-size: 15px;"><td class="redzone">★★☆☆☆</td><td>${bbsBean.getPointCount2()}개</td></tr>
						</c:if>						
						<c:if test="${bbsBean.getPointCount3() > 0}">
							<tr height="10px;" style="font-size: 15px;"><td class="redzone">★★★☆☆</td><td>${bbsBean.getPointCount3()}개</td></tr>
						</c:if>						
						<c:if test="${bbsBean.getPointCount4() > 0}">
							<tr height="10px;" style="font-size: 15px;"><td class="redzone">★★★★☆</td><td>${bbsBean.getPointCount4()}개</td></tr>
						</c:if>						
						<c:if test="${bbsBean.getPointCount5() > 0}">
							<tr height="10px;"style="font-size: 15px;"><td class="redzone">★★★★★</td><td>${bbsBean.getPointCount5()}개</td></tr>
						</c:if>
					</table>
				</div>
				
			
			</div>
			
	

			
				<!-- 댓글  등록-->	
				
			<div class="p_comment">
				<table class="comment_table">
					<tr>
						<td><p>평점
						     <div id="star-container">						     
    <input class="star" type="radio" name="test-2-rating-5" value="1"/>
    <input class="star" type="radio" name="test-2-rating-5" value="2"/>
    <input class="star" type="radio" name="test-2-rating-5" value="3"/>
    <input class="star" type="radio" name="test-2-rating-5" value="4"/>
    <input class="star" type="radio" name="test-2-rating-5" value="5" checked="checked"/>
						     </div>
						     <div id="stars-point"></div>
						</p></td>
					</tr>
					<tr>
						<td style=”word-break:break_all; padding: 0;>
							<div class="comment" >
								
								<input type="hidden" id="reply_point" value="0">
								<textarea  id="reply_write" name="reply_write" rows="3" cols="70" maxlength="200"  wrap="physical"></textarea>
							</div>
						</td>
					</tr>
					
					<tr>
						<td align="right">
				<%-- 		
					<c:if test="${session_id != null}">
				 --%>		
							<button id="btnComment" onclick="onClickComment()">등록</button>
							<script>
						      function onClickComment() {
						    	  var reply_write = $('#reply_write').val();
						    	  var reply_point = $('#reply_point').val();
						    	  var url = "${pageContext.request.contextPath}/bbs/BbsReplyOk.bb?mode=add&bbs_num=${bbsBean.getBbs_num()}";
						    	  url = url +"&reply_point="+reply_point;
						    	  url = url +"&reply_write="+reply_write;
						    	  location.href = url;
						      }
						    </script>
						    
						    
		
					
					<%-- 
					<c:if test="${session_id eq null}">
							<a onclick="return confirm('로그인 해주세요!')" href="${pageContext.request.contextPath}/member/MemberLogin.me">
							<button id="btnComment" onclick="onClickComment()">등록</button>
							</a>
					</c:if>
					 --%>
					
					
						</td>
						
						
					</tr>
				</table>
			</div>
			
			
			<br />
			<br />
			
			<div class="p_bottom">
				<ul class="comment_list">
					<li><a href="${pageContext.request.contextPath}/bbs/BbsReplyResultView.bb?bbs_num=${bbsBean.getBbs_num()}&result=latest">최신순</a></li>
					
					<li><a href="${pageContext.request.contextPath}/bbs/BbsReplyResultView.bb?bbs_num=${bbsBean.getBbs_num()}&result=likeCount">추천순</a></li> 
					
					<li><a href="${pageContext.request.contextPath}/bbs/BbsReplyResultView.bb?bbs_num=${bbsBean.getBbs_num()}&result=grade">평점순</a></li>
				</ul>
			</div>
			
	
		<div class="p_bottom_list">	
				<table   border="2" class="comment_list_table"  cellpadding="0" cellspacing="0" style="border: 1px solid #FFFFFF; width:100%; ">
				
				
					<colgroup>
                  <col width="13%" />
                  <col width="13%" />
                  <col width="10%" />
                  <col width="5%" />
                  <col width="5%" />
                  <col width="45%" />
                  <col width="8%" />
               
                
					</colgroup>
					<tbody>
				
								
						<c:choose>
							<c:when test="${bbsReplyList != null and fn:length(bbsReplyList) > 0}">
								<c:forEach var="bbsReplyList" items="${bbsReplyList}" varStatus="status">
								
								
								
								<thead>
									<tr height="10px" style="width:100%; height:10%; font-size: 13px; font-weight: bold; ">
									
								
									
										<!-- id -->
										<td class="cm8" style="font-size: 11px; color: #000000; padding:10px;">
										${bbsReplyList.getUser_id()}
										</td>
										
										
										<!-- 별 평점 -->
										<td class="cm8" style="font-size: 13px; color: #c10000;">
										평점 (${bbsReplyList.getReply_point()}/5): ${bbsReplyList.getReply_stars()}
										</td>
										
										<td class="cm8" style="font-size: 10px;">${bbsReplyList.getReply_date()}</td>
								
						<!-- 리뷰 신고  -->
						<c:if test="${session_id != null}">	
						<td>
						<div class="dropdown">
  						<a class="dropbtn" class="button" style="font-size: 8px; color: #c10000;">신고</a>
  						<div class="dropdown-content">
   						<a href="${pageContext.request.contextPath}/report/ReportWriteOk.re
						?user_id=${bbsReplyList.getUser_id()}
						&report_id=${session_id}
						&bbs_num=${bbsReplyList.getBbs_num()}
						&pk_num=${bbsReplyList.getReply_num()}
						&report_type=댓글
						&report_div=성인물"  onclick="return confirm('신고 하시겠습니까?')" >성인물</a>
						
						
   						 <a href="${pageContext.request.contextPath}/report/ReportWriteOk.re
						?user_id=${bbsReplyList.getUser_id()}
						&report_id=${session_id}
						&bbs_num=${bbsReplyList.getBbs_num()}
						&pk_num=${bbsReplyList.getReply_num()}
						&report_type=댓글
						&report_div=홍보"  onclick="return confirm('신고 하시겠습니까?')" >홍보</a>
						
						
   						<a href="${pageContext.request.contextPath}/report/ReportWriteOk.re
						?user_id=${bbsReplyList.getUser_id()}
						&report_id=${session_id}
						&bbs_num=${bbsReplyList.getBbs_num()}
						&pk_num=${bbsReplyList.getReply_num()}
						&report_type=댓글
						&report_div=기타" onclick="return confirm('신고 하시겠습니까?')" >기타</a>
  							</div>
						</div>
						
						</td>
						</c:if>
										
										<c:if test="${bbsReplyList.getUser_id() eq session_id}">	
										<!-- 삭제 -->
										<td class="cm8" style="font-size: 8px;">
										<a onclick="return confirm('삭제하시겠습니까?')" 
										href="${pageContext.request.contextPath}/bbs/ReplyDeleteOk.bb
										?reply_num=${bbsReplyList.getReply_num()}
										&bbs_num=${bbsReplyList.getBbs_num()}">삭제</a>
										</td>
										</c:if>
										
										
										<c:if test="${bbsReplyList.getUser_id() != session_id}">	
										<td class="cm8" style="font-size: 8px;"></td>
										</c:if>
										
										<c:if test="${session_id eq null}">	
										<td class="cm8" style="font-size: 8px;"></td>
										</c:if>
										
										<!-- 공백 -->
										<td></td>
										
										
										<!-- 추천 기능 -->
										<td class="cm8" style="font-size: 12px;">
										<a onclick="return confirm('추천하시겠습니까?')" 
										href="${pageContext.request.contextPath}/bbs/BbsReplyLikeOk.bb
										?bbs_num=${bbsReplyList.getBbs_num()}
										&user_id=${session_id}
										&reply_num=${bbsReplyList.getReply_num()}
										&login_ip=${session_ip}">좋아요(${br_dao.like_count(bbsReplyList.getReply_num())})</a>
										</td>
										

										
									</tr>
									
									
										
										
									<tr style="font-size: 13px; font-weight: bold;  ">
										<td class="cm8" width="1000px" height="70px" colspan="7" style="font-size: 15px; padding:20px; ">
											<div>${bbsReplyList.getReply_write()}</div>
										</td>
									</tr>
						</thead>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr height="50px">
									<td colspan="5" align="center">등록된 게시물이 없습니다.</td>
								</tr>
							</c:otherwise>
						</c:choose>
						
					</tbody>
			
				</table>
			</div> 
			
			
			
			
			
			
			<!-- 페이징 구현  (페이지, 게시판 페이지) -->
				<table align="center" style="border: 1px solid #FFFFFF;">

					<colgroup>
						<col width="20%" />
						<col width="50%" />

						<col width="20%" />

					</colgroup>

					<tr align="center" valign="middle"
						style="border: 2px solid #FFFFFF;">

				




						<td align="center"><c:choose>


								<c:when test="${nowPage > 1}">
							&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/bbs/BbsReplyResultView.bb?
										page=${nowPage - 1}&
										bbs_num=${bbsBean.getBbs_num()}&
										user_id=${bbsBean.getUser_id()}&
										result=${result}">이전</a>&nbsp;&nbsp;
										
								
							</c:when>
							</c:choose>
							 <c:forEach var="i" begin="${startPage}" end="${endPage}">
								<c:choose>
									<c:when test="${i eq nowPage}">
								${i}
							</c:when>
									<c:otherwise>
							&nbsp;&nbsp;
							<a href="${pageContext.request.contextPath}/bbs/BbsReplyResultView.bb?
										page=${i}&
										bbs_num=${bbsBean.getBbs_num()}&
										user_id=${bbsBean.getUser_id()}&
										result=${result}">${i}</a>&nbsp;&nbsp;
							
							
						</c:otherwise>
								</c:choose>
							</c:forEach> <c:choose>
								<c:when test="${nowPage < totalPage}">
								&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/bbs/BbsReplyResultView.bb?
										page=${nowPage + 1}&
										bbs_num=${bbsBean.getBbs_num()}&
										user_id=${bbsBean.getUser_id()}&
										result=${result}
										">다음</a>&nbsp;&nbsp;
						</c:when>
							</c:choose></td>


					</tr>
				</table>
			
			
			</c:if>
	

			<!-- 게시판 삭제 -->

			<form action="${pageContext.request.contextPath}/bbs/bbsDeleteOk.bb"
				method="post" name="bbsform">

				<input type="hidden" name="bbs_num"
					value="${bbsBean.getBbs_num()}" />
			</form>

	</section>


	</section>
	</div>
	
	<!-- Footer -->
	<footer id="footer">
		<div class="inner">
			<section class="info">
				<h3>About Us</h3>
				<div class="about">
					<p>Morbi mattis mi consectetur tortor elementum, varius
						pellentesque velit convallis. Aenean tincidunt lectus auctor
						mauris maximus, ac scelerisque ipsum tempor. Duis vulputate ex et
						ex tincidunt, quis lacinia velit aliquet. Duis non efficitur
						malesuada.</p>
					<p>Sagittis felis ac sagittis semper. Curabitur purus leo donec
						vel dolor at arcu tincidunt bibendum. Interdum et malesuada fames
						ac ante ipsum primis.</p>
					<ul class="actions">
						<li><a href="#" class="button">Learn More</a></li>
					</ul>
				</div>
				<div class="team">
					<article>
						<span class="image"><img src="images/pic06.jpg" alt=""></span>
						<p>
							<strong class="name">John Doe</strong> <span class="title">Lorem
								semper magna etiam</span>
						</p>
					</article>
					<article>
						<span class="image"><img src="images/pic07.jpg" alt=""></span>
						<p>
							<strong class="name">Jane Anderson</strong> <span class="title">Etiam
								feugiat adipiscing veroeros</span>
						</p>
					</article>
					<article>
						<span class="image"><img src="images/pic08.jpg" alt=""></span>
						<p>
							<strong class="name">Mike Smith</strong> <span class="title">Consequat
								nulla dolor blandit</span>
						</p>
					</article>
				</div>
			</section>
			<section class="contact">
				<h3>Contact Us</h3>
				<ul class="contact-icons">
					<li class="icon solid fa-home"><a href="#">1234 Somewhere
							Road #80486<br>Nashville, TN 00000
					</a></li>
					<li class="icon solid fa-phone"><a href="#">(800) 555-0000
							x12345</a></li>
					<li class="icon solid fa-envelope"><a href="#">hello@untitled.tld</a></li>
					<li class="icon brands fa-facebook"><a href="#">facebook.com/untitled-tld</a></li>
					<li class="icon brands fa-twitter"><a href="#">twitter.com/untitled-tld</a></li>
				</ul>
			</section>
		</div>
		<div class="copyright">&copy; Untitled. All rights reserved.</div>
	</footer>


</body>
<script src="https://rawgit.com/jackmoore/autosize/master/dist/autosize.min.js"></script>
<script>
	var check = true;

	/* 신고하기 */
	function addreport() {
		reportform.submit();

	}

	
	/* 삭제 */
	function deleteBbs() {
		bbsform.submit();
	}
	
	
	
</script>

<!--     <script>
        var userName = prompt("당신의 이름은 무엇인가요 ?", "글쎄요");
        
        document.write("<h1> 당신의 이름은 :" + userName + " 이군요 </h1>")
    </script> -->


</html>