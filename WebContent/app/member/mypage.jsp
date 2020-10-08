<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.dohwaji.app.member.dao.MemberBean"%>
<%@page import="com.dohwaji.app.member.dao.MemberDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>




<!DOCTYPE HTML>
<!--
   Faction by Pixelarity
   pixelarity.com | hello@pixelarity.com
   License: pixelarity.com/license
-->
<html>
<style>
  table, th, td {
    border: 1px solid #bcbcbc;
  }
  table.info {
    width: 800px;

    float: right;
  }
</style>

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


	<head>
      <title>${pageContext.request.contextPath}</title>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/app/assets/css/main.css" />
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	</head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script>
   $(document).ready(function(){ $("#header").load("${pageContext.request.contextPath}/app/include/header.jsp") });
</script>  
<body class="is-preload">

	<c:set var="nowPage" value="${requestScope.nowPage}" />
	<c:set var="startPage" value="${requestScope.startPage}" />
	<c:set var="endPage" value="${requestScope.endPage}" />
	<c:set var="totalCnt" value="${requestScope.totalCnt}" />
	<c:set var="totalPage" value="${requestScope.totalPage}" />


	<c:set var="userInfo" value="${requestScope.userInfo}"/>
	<c:set var="state" value="${requestScope.state}"/>
	<c:set var="bttipList" value="${requestScope.bttipList}"/>
	<c:set var="reviewList" value="${requestScope.reviewList}"/>
	<c:set var="memberBean" value="${requestScope.memberBean}"/>
	<c:set var="loginList" value="${requestScope.loginList}"/>
	
	
	
	<c:set var="loginBean" value="${requestScope.loginBean}"/>


  	<c:set var="user_id" value="${session_id}"/>
   
	<jsp:useBean id="m_dao" class="com.dohwaji.app.member.dao.MemberDAO"></jsp:useBean>
	<jsp:useBean id="memberBean" class="com.dohwaji.app.member.dao.MemberBean"></jsp:useBean>
	<jsp:useBean id="LoginBean" class="com.dohwaji.app.member.dao.LoginBean"></jsp:useBean>
	

	<header id="header"></header>

	<!-- Wrapper -->
	<div class="wrapper">

		<!-- Main -->
		<section class="main">
			<section>
			
			
			<table width="40px" border="0" cellpadding="0" cellspacing="0" style="border: 0px solid #ffa500;">
				<tr align="center" valign="middle" style="border: 0px solid #ffa500;">
					<td><h1>마이페이지</h1></td>
				</tr>
			</table>
			

				<form action="${pageContext.request.contextPath}/notice/NoticeReport.no?num=${noticeBean.getNotice_num()}&add=1"
				method="post" enctype="multipart/form-data" name="reportform">

				<table width="150px" class="info" border="1" cellpadding="0" cellspacing="0">

					<tr height="30px">
						<td align="center" width="150px">아이디</td>
						<td style="padding-left: 10px;">${session_id}</td>
					</tr>


					<tr height="30px">
						<td align="center" width="150px">닉네임</td>
						<td style="padding-left: 10px;">${session_name}</td>
					</tr>


					<tr height="30px">
						<td align="center" width="150px">이메일</td>
						<td style="padding-left: 10px;">${session_email}</td>
					</tr>
					<tr height="30px">
						<td align="center" width="150px">가입날짜</td>
						<td style="padding-left: 10px;">${session_date}</td>
					</tr>

				</table>
			</form>
				
		
				<div class="my_intro_btn">
					<div class="col-3 col-12-small">
						<ul class="actions stacked">
							<li><a href="${pageContext.request.contextPath}/member/memberEnterPW.me" class="button primary fit">회원 정보 수정</a></li>
							<li><a href="${pageContext.request.contextPath}/member/MemberDeleteOk.me?user_id=${session_id}" class="button primary fit" onclick="return confirm('삭제 하시겠습니까?')" >회원 탈퇴</a></li>
						</ul>
					</div>
				</div>
			

	


			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			
				<div>
					<table style="width: 100%; height: 100%; border: 2px solid #FFFFFF; background-color: #FFFFFF; color: #ffa500; font-size: 17px; font-weight: bold;">
						<tr style="width: 100%; height: 100%; border: 2px solid #FFFFFF; background-color: #FFFFFF; color: #ffa500; font-size: 17px; font-weight: bold;">
							<td align="center">
								<h17>로그인 기록</h17>
							</td>
						</tr>
					</table>
				</div>

			<br />
		
		
		
			<div align="center">
						<!-- 로그인  테이블 -->
				<table id="bbs" class="bbs"  cellpadding="0" cellspacing="0" style="width: 80%; font-size: 13px; border: 1px solid #FFFFFF;">
							<colgroup>
							
								<col width="10%" />	
								<col width="25%" />
								<col width="25%" />
								<col width="25%" />
								
								
							</colgroup>
							<thead>
								<tr style="font-size: 13px; font-weight: bold; color: #000000;">
						
									<th><div align="center">분류</div></th>
									<th><div align="center">IP</div></th>
									<th><div align="center">사용자(ID)</div></th>
									<th><div align="center">날짜</div></th>
								
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${loginList != null and fn:length(loginList) > 0}">
										<c:forEach var="loginList" items="${loginList}">
											<tr style="font-size: 13px;" valign="middle">


											
												
												<td>
													<c:if test="${loginList.getLogin_check() != 1}">
													<div align="center">실패</div>
													</c:if>
													<c:if test="${loginList.getLogin_check() == 1}">
													<div align="center">성공</div>
													</c:if>
												</td>
												
												<td>
													<div align="center">${loginList.getLogin_ip()}</div>
												</td>

												<td>
													<div align="center">${loginList.getUser_id()}</div>
												</td>
												<td>
													<div align="center">${loginList.getLogin_date()}</div>
												</td>
												
												
											
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr height="50px">
											<td colspan="7" align="center">등록된 게시물이 없습니다.</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</tbody>


						</table>				
				</div>
								<!-- 페이징 구현  (페이지, 게시판 페이지) -->
				<table style="border: 0px solid #FFFFFF;">

					<colgroup>
						<col width="20%" />
						<col width="50%" />

						<col width="20%" />

					</colgroup>

					<tr align="center" valign="middle"
						style="border: 0px solid #FFFFFF;">




						<td align="center">
						<c:choose>
								<c:when test="${nowPage > 1}">
							&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/member/MemberInformation.me?page=${nowPage - 1}&user_id=${session_id}">이전</a>&nbsp;&nbsp;
								</c:when>
							</c:choose>
							
							 <c:forEach var="i" begin="${startPage}" end="${endPage}">
								<c:choose>
									<c:when test="${i eq nowPage}">${i}
								</c:when>
									<c:otherwise>
							&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/member/MemberInformation.me?page=${i}&user_id=${session_id}">${i}</a>&nbsp;&nbsp;
							</c:otherwise>
							
								</c:choose>
							</c:forEach> 
							
							<c:choose>
								<c:when test="${nowPage < totalPage}">
								&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/member/MemberInformation.me?page=${nowPage + 1}&user_id=${session_id}">다음</a>&nbsp;&nbsp;
							</c:when>
						</c:choose>
							
						</td>

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





<c:if test='${btlist eq ""}'>
<script>
document.getElementById("delete1").style.visibility="hidden";
</script>
</c:if>
<c:if test='${btlist2 eq ""}'>
<script>
document.getElementById("delete2").style.visibility="hidden";
</script>
</c:if>
<c:if test='${btlist3 eq ""}'>
<script>
document.getElementById("delete3").style.visibility="hidden";
</script>
</c:if>


	<!-- Scripts -->
	<script src="../assets/js/jquery.min.js"></script>
	<script src="../assets/js/jquery.dropotron.min.js"></script>
	<script src="../assets/js/browser.min.js"></script>
	<script src="../assets/js/breakpoints.min.js"></script>
	<script src="../assets/js/util.js"></script>
	<script src="../assets/js/main.js"></script>

</body>
</html>