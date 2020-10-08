<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML>
<!--
   Faction by Pixelarity
   pixelarity.com | hello@pixelarity.com
   License: pixelarity.com/license
-->
<html>
	<head>
      <title>${pageContext.request.contextPath}</title>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
      <link rel="stylesheet" href="${pageContext.request.contextPath}/app/assets/css/main.css" />
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>>
	</head>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){ $("#header").load("${pageContext.request.contextPath}/app/include/header.jsp") });
	</script>
	<body class="is-preload">
		<c:if test="${not empty param.check}">
			<c:if test="${not param.check}">
				<script>alert("비밀번호를 다시 확인해주세요.");</script>
			</c:if>
		</c:if>
		<header id="header"></header>
	
		<!-- Wrapper -->
		<div class="wrapper">
	
			<!-- Main -->
			<section class="main">
				<section>
				
					<form method="post" action="${pageContext.request.contextPath}/member/memberCheckOk.me" name="pwform">
						<div class="row gtr-uniform" style="marin: 0 auto; width: 100%; text-align: center;">
							<h8>비밀번호</h8>
							
							<label class="center"><input type="password" name="pw" placeholder="PassWord" /></label>
						</div>
						
						<br />
						<br />
						<br />
						<ul class="actions fit">
							<li class="login" style="width: 10%; marin: 0 auto; text-align: center;">
									<a href="javascript:pwform.submit()" class="button primary fit"  style="font-size: 12px; ">회원정보 수정</a></li>
						</ul>
					</form>
					
				</section>
			</section>
		</div>
	
	
	
	<!-- Scripts -->
	<script src="${pageContext.request.contextPath}/app/assets/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/app/assets/js/jquery.dropotron.min.js"></script>
	<script src="${pageContext.request.contextPath}/app/assets/js/browser.min.js"></script>
	<script src="${pageContext.request.contextPath}/app/assets/js/breakpoints.min.js"></script>
	<script src="${pageContext.request.contextPath}/app/assets/js/util.js"></script>
	<script src="${pageContext.request.contextPath}/app/assets/js/main.js"></script>
	<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.js"></script>
	<script>var contextPath = "${pageContext.request.contextPath}";</script>
	<script src="${pageContext.request.contextPath}/app/join/join.js"></script>
	<script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>	
	
	</body>
</html>
