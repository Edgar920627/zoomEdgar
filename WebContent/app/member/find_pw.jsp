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

		<header id="header"></header>
	
		<!-- Wrapper -->
		<div class="wrapper">
	
			<!-- Main -->
			<section class="main">
				<section>
					<div align="center">
					<h4>비밀번호 찾기</h4>
					
					</div>					
					
					
					<!-- 2 -->
				<form action="${pageContext.request.contextPath}/member/MemberFind_pw.me" method="post" id="emailForm" name="emailForm">
   
   				 <table class="alt"  style="width:35%; margin:40px auto; height:100%; border: 2px solid #FFBF00; background-color: #FFFFFF; ">
						
	
							<colgroup>
								<col width="25%" />
								<col width="70%" />
								<col width="5%" />
	
							</colgroup>
							<thead>

							
							<tr style="background-color: #FFBF00; color: #FFFFFF; font-size: 15px; padding: 5px;">
								<td align="center" colspan="3">
									회원 가입 정보 입력
								</td>
							</tr>
							
							
							<tr>
								<td align="center" >
								</td>
							</tr>
							
							<tr style="padding: 20px;">
								 <td align="left" style="font-size: 11px; padding: 20px;"><b>아이디:</b></td>
								<td>
									<label><input type="text" style="width:250px; font-size: 10px;" id="user_id" name="user_id" placeholder="※4-12자의 영문 대소문자와 숫자로만 입력" maxlength="13" /></label>
									<p id="idCheck_text" style="font-size: 11px; color: #FF0000;"></p>
								</td>
							</tr>
							
							<tr style="padding: 20px;">
								<td align="left" style="font-size: 11px; padding: 20px;"><b>이메일 :</b></td>
								<td><input type="text" style="width:250px; font-size: 10px;" name="user_email" placeholder="E-mail"/></td>
							</tr>
							
							<tr>
								<td align="center" >
								</td>
							</tr>

						</table>
						<ul class="actions fit" >
							<li class="login" style="width:10%; marin:0 auto; text-align:center;">
							<a href="javascript:formSubmit()" class="button primary fit" style="width:150px; font-size: 13px;">이메일 인증하기</a></li>
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
	
	
	<script>
	function formSubmit(){
		emailForm.submit();
	}
</script>
</html>
