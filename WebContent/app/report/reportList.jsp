<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.dohwaji.app.member.dao.MemberBean"%>
<%@page import="com.dohwaji.app.member.dao.MemberDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE HTML>
<html>
<head>

<title>${pageContext.request.contextPath}</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app/assets/css/main.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>


<style>
table {
	border: 0px solid #FFFFFF;
}

th, td {
	background-color: #FFFFFF;
	border: 0px solid #FFFFFF;
}

a {
	text-decoration: none
}
</style>

<style>

.dropbtn {
  background-color: #ffa500;
  color: white;
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



<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>

<script>
	$(document)
			.ready(
					function() {
						$("#header")
								.load(
										"${pageContext.request.contextPath}/app/include/header.jsp")
					});
</script>


<body class="is-preload">
	<header id="header"></header>



	<%-- 
		<c:if test="${session_id eq null}">
			<script>
				alert("로그인 후 이용해주세요");
				location.replace("${pageContext.request.contextPath}/member/MemberLogin.me");
			</script>
		</c:if> 
 --%>
	
	<c:set var="nowPage" value="${requestScope.nowPage}" />
	<c:set var="startPage" value="${requestScope.startPage}" />
	<c:set var="endPage" value="${requestScope.endPage}" />
	<c:set var="totalCnt" value="${requestScope.totalCnt}" />
	<c:set var="totalPage" value="${requestScope.totalPage}" />
	
	<c:set var="reportList" value="${requestScope.reportList}" />
	
	
	<c:set var="reportCnt" value="${requestScope.reportCnt}" />
	




<jsp:useBean id="reportdao" class="com.dohwaji.app.report.dao.ReportDAO"></jsp:useBean>

	<!-- Wrapper -->
	<div class="wrapper">
		<section class="main">

			<section>



				<br />
				<br />
				<div>
				<h1>신고 목록</h1>
				</div>
				<br />
				
				
				<table style="width: 96%; border: 0px solid #FFFFFF;">

					<tr align="right" style="width: 96%; border: 0px solid #FFFFFF;">
						<c:if test="${session_id != null}">	
						<td >
						<div class="dropdown">
  						<a class="dropbtn" class="button" style="font-size: 16px;">결과 분류</a>
  						<div class="dropdown-content">
   						<a href="${pageContext.request.contextPath}/report/ReportList.re" onclick="return confirm('준비중 입니다')" align="left">확인중</a>
						
						<a href="${pageContext.request.contextPath}/report/ReportList.re" onclick="return confirm('준비중 입니다')" align="left">전체</a>

  							</div>
						</div>
						
						</td>
	
					</c:if>
					</tr>
					</table>
					
					<br />
					<br />
				

				<form action="${pageContext.request.contextPath}/bbs/BbsSearchList.bb"
					method="GET" enctype="multipart/form-data" name="bbsSearchform">
					<div class="bbs_table" align="center">
						<table id="bbs" class="bbs" cellpadding="0" cellspacing="0"
							style="width: 96%; border: 1px solid #FFFFFF;">
							<colgroup>
								<col width="6%" />
								<col width="8%" />
								<col width="8%" />
								<col width="8%" />
								<col width="12%" />
								<col width="12%" />
								<col width="8%" />
								<col width="14%" />
								<col width="7%" />
								<col width="7%" />
								<col width="7%" />
							</colgroup>
							<thead>
								<tr style="font-size: 11px; font-weight: bold; color: #000000;">
									<th><div align="left">번호</div></th>
									<th><div align="center">타입</div></th>
									<th><div align="center">게시글 번호</div></th>
									<th><div align="center">구분</div></th>
									<th><div align="center">신고당한자 ID</div></th>
									<th><div align="center">신고자 ID</div></th>
									<th><div align="center">결과</div></th>
									<th><div align="center">신고날짜</div></th>
									<th><div align="center">접수 갯수</div></th>
									<th><div align="center">해당글 통과</div></th>
									<th><div align="center">해당글 삭제</div></th>
								</tr>
							</thead>
							<tbody>
								<c:choose>


									<c:when test="${reportList != null and fn:length(reportList) > 0}">
										<c:forEach var="r_bean" items="${reportList}">
											<tr style="font-size: 10px;" center" valign="middle">


												<td>
													<div align="left">${r_bean.getReport_num()}</div>
												</td>
												<td>
													<div align="center">${r_bean.getReport_type()}</div>
												</td>

												<td>
													<div align="center">${r_bean.getPk_num()}</div>
												</td>

												<td>
													<div align="center">${r_bean.getReport_div()}</div>
												</td>
												<td>
													<div align="center">${r_bean.getUser_id()}</div>
												</td>
												<td>
													<div align="center">${r_bean.getReport_id()}</div>
												</td>

												<td>
													<div align="center"> ${r_bean.getReport_result()}</div>
												</td>
												
												<td>
													<div align="center"> ${r_bean.getReport_date()}</div>
												
												</td>
												
													
												
												<td>
													<div align="center">${r_bean.getReport_cnt()}</div>
												
												</td>
												
												<td style="font-size: 8px;">
													<div align="center">
													<a class="button large" href="${pageContext.request.contextPath}/report/ReportResultOk.re
														?report_num=${r_bean.getReport_num()}
														&pk_num=${r_bean.getPk_num()}
														&report_type=${r_bean.getReport_type()}
														&report_result=${r_bean.getReport_result()}
														&report_div=${r_bean.getReport_div()}
														&div=pass" onclick="return confirm('통과 하시겠습니까?')">통과
													</a>
													</div>
												</td>
												
												
												<td style="font-size: 8px;">
													<div align="center">
													<a class="button large" href="${pageContext.request.contextPath}/report/ReportResultOk.re
														?report_num=${r_bean.getReport_num()}
														&pk_num=${r_bean.getPk_num()}
														&report_type=${r_bean.getReport_type()}
														&report_result=${r_bean.getReport_result()}
														&report_div=${r_bean.getReport_div()}
														&div=delete" onclick="return confirm('삭제 하시겠습니까?')">삭제
													</a>
													</div>
												</td>
											

											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr height="50px">
											<td colspan="11" align="center">등록된 게시물이 없습니다.</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</tbody>


						</table>

					</div>




					<!-- 분류 및 검색 테이블  -->




<%-- 
					<div>



						<table id="bbs_sdiv" class="bbs_sdiv"
							style="width: 100%; height: 100%; border: 2px solid #FFFFFF; background-color: #FFFFFF; font-size: 13px; font-weight: bold;">

							<colgroup>

								<col width="10%" />
								<col width="10%" />
								<col width="10%" />
								<col width="13%" />
								<col width="30%" />
								<col width="10%" />
								<col width="12%" />

							</colgroup>


							<tr
								style="width: 50px; border: 0px solid #C0C0C0; background-color: #FFFFFF; font-size: 11px; font-weight: bold;">




								<!-- 대 분류 -->
								<td align="center">
									<div style="width: 100%; color: black; font-size: 5px;">
										<select name="bbs_maindiv" id="bbs_maindiv"
											style="width: 100%; color: #000000; font-size: 9px;">
											<option id="bbs_maindiv" value="전체">전체</option>
											<option id="bbs_maindiv" value="인터넷방송">인터넷방송</option>
											<option id="bbs_maindiv" value="게임">게임</option>
											<option id="bbs_maindiv" value="스포츠">스포츠</option>
											<option id="bbs_maindiv" value="금융/주식">금융/주식</option>
											<option id="bbs_maindiv" value="여행/음식">여행/음식</option>
											<option id="bbs_maindiv" value="기타">기타</option>
										</select>
									</div>
								</td>



								<!-- 소 분류 -->
								<td align="center">
									<div style="width: 100%; color: black;">
										<select name="bbs_smalldiv" id="bbs_smalldiv"
											style="width: 100%; color: black; font-size: 9px;">
											<option id="bbs_smalldiv" value="전체">전체</option>
											<option id="bbs_smalldiv" value="자유게시판">자유게시판</option>
											<option id="bbs_smalldiv" value="질문/답변">질문/답변</option>
											<option id="bbs_smalldiv" value="기타">기타</option>
										</select>
									</div>
								</td>




								<!-- 최신순  조회순  댓글순-->
								<td align="center">
									<div style="width: 100%; color: black;">
										<select name="bbs_result" id="bbs_result"
											style="width: 100%; color: black; font-size: 9px;">
											<option value="latest">최신순</option>
											<option value="read">조회순</option>
											<option value="likeCount">추천순</option>
											<option value="comment">댓글순</option>
										</select>
									</div>
								</td>




								<!-- 제목+내용+사용자 -->
								<td align="center">
									<div style="width: 100%; color: black;">
										<select name="bbs_target" id="bbs_target"
											style="width: 100%; color: black; font-size: 9px;">
											<option value="all_target">제목+내용+글쓴이</option>
											<option value="bbs_title">제목</option>
											<option value="bbs_explanation">내용</option>
											<option value="user_id">글쓴이</option>
										</select>
									</div>
								</td>




								<!-- 검색 창 -->
								<td align="center"
									style="padding-left: 10px; color: black; font-size: 13px;">
									<input name="bbs_search" type="text" placeholder="검색"
									size="100" maxlength="30" value=""
									style="width: 100%; color: black; font-size: 9px;" />
								</td>



								<!-- 검색 버튼 -->
								<td align="left" style="color: #000000; font-size: 13px;">
									<div style="width: 100%; color: black; font-size: 9px;">
										<a href="javascript:addbbsSearch()" class="button">검색</a>
									</div>
								</td>










							</tr>

						</table>



					</div> --%>
				</form>






				<!-- 페이징 구현  (페이지, 게시판 페이지) -->
				<table style="border: 1px solid #FFFFFF;">

					<colgroup>
						<col width="20%" />
						<col width="50%" />

						<col width="20%" />

					</colgroup>

					<tr align="center" valign="middle"
						style="border: 2px solid #FFFFFF;">

						<td>
					
						
						
						</td>




						<td align="center"><c:choose>


								<c:when test="${nowPage > 1}">
							&nbsp;&nbsp;<a
										href="${pageContext.request.contextPath}/report/ReportList.re?
										page=${nowPage - 1}">이전</a>&nbsp;&nbsp;
										
								
							</c:when>
							</c:choose> <c:forEach var="i" begin="${startPage}" end="${endPage}">
								<c:choose>
									<c:when test="${i eq nowPage}">
								${i}
							</c:when>
									<c:otherwise>
							&nbsp;&nbsp;
							<a href="${pageContext.request.contextPath}/report/ReportList.re?
										page=${i}">${i}</a>&nbsp;&nbsp;
						</c:otherwise>
								</c:choose>
							</c:forEach> <c:choose>
								<c:when test="${nowPage < totalPage}">
								&nbsp;&nbsp;<a
										href="${pageContext.request.contextPath}/report/ReportList.re?
										page=${nowPage + 1}">다음</a>&nbsp;&nbsp;
						</c:when>
							</c:choose></td>
								<td>
					
						
						
						</td>

<%-- 

						<!-- 회원가입 한 사용자만 게시글 등록 가능 -->
						<td align="right" style="border: 1px solid #FFFFFF;"><c:if
								test="${bbsBean.getUser_id() eq session_id}">
								<a onclick="return confirm('로그인 해주세요!')"
									href="${pageContext.request.contextPath}/member/MemberLogin.me">
									<input type="submit" value="글쓰기" class="primary">
								</a>
							</c:if> <c:if test="${bbsBean.getUser_id() != session_id}">
								<a href="${pageContext.request.contextPath}/bbs/BbsWrite.bb">
									<input type="submit" value="글쓰기" class="primary">
								</a>
							</c:if></td>

 --%>
					</tr>
				</table>
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

	<!-- Scripts -->
	<script
		src="${pageContext.request.contextPath}/app/assets/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/app/assets/js/jquery.dropotron.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/app/assets/js/browser.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/app/assets/js/breakpoints.min.js"></script>
	<script src="${pageContext.request.contextPath}/app/assets/js/util.js"></script>
	<script src="${pageContext.request.contextPath}/app/assets/js/main.js"></script>



</body>


<!-- 검색 제한 -->
<script>
	$(document).ready(
			function() {
				$('#bbs_search').keyup(
						function() {
							if ($(this).val().length > $(this)
									.attr('maxlength')) {
								alert('제한길이 초과');
								$(this).val(
										$(this).val().substr(0,
												$(this).attr('maxlength')));
							}
						});
			});
</script>




<!-- <tr> 테이블 클릭시 상세페이지 이동 -->
<!-- <script>
	$("#bbs tr")
			.click(
					function() {
						var str = ""
						var tdArr = new Array();

						// 현재 클릭된 Row(<tr>)
						var tr = $(this);
						var td = tr.children();
						var no = td.eq(0).text();
						console.log("bbs_num: " + no);

						var params = {
							bbs_num : no
						};

						window.location.href = "${pageContext.request.contextPath}/bbs/BbsView.bb?bbs_num="
								+ no;

					});
</script>

 -->


<!-- 검색기능   -->
<script>
	function addbbsSearch() {

		bbsSearchform.submit();
	}
</script>






</html>