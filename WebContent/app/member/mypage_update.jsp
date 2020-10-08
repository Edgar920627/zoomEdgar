<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function() {
		$("#header").load("${pageContext.request.contextPath}/app/include/header.jsp")
	});
</script>

<body class="is-preload">

	<header id="header"></header> 

      <!-- Main -->
			<section class="main">
				<section>
				  <h1 style="text-align: center;">회원 정보 수정</h1>
				
					
					<form action="${pageContext.request.contextPath}/member/MypageUpdateOk.me" method="post" name="updateForm">
						<table class="alt" style="width:60%; margin:40px auto; ">
						

						
						
						
							<tr>
								<td><h7>아이디</h7></td>
								<td>
									<label><input type="text" name="user_id" placeholder="id" value="${session_id}" readonly/></label>
									<p id="idCheck_text"></p>
								</td>
							</tr>
							<tr>
								<td><h7>비밀번호</h7></td>
								<td><input type="password" name="user_pw" placeholder="pw" /></td>
							</tr>
							<tr>
								<td><h7>닉네임</h7></td>
								<td><input type="text" name="user_name" value="${session_name}"/></td>
							</tr>
					
							<tr>
								<td><h7>이메일</h7></td>
								<td><input type="text" name="user_email" placeholder="E-mail" value="${session_email}" readonly /></td>
							</tr>

						</table>
						
						
						</br>
						</br>
						<ul class="actions fit" >
							<li class="login" style="width:10%; marin:0 auto; text-align:center;">
							<a href="javascript:updateSubmit()" class="button primary fit">수정하기</a></li>
                     <li class="login" style="width: 10%; margin: 0 auto; text-align: center;">
                        <a href="${pageContext.request.contextPath}/member/MemberInformation.me?user_id=${session_id}" class="button primary fit">취소</a></li>
						</ul>
						
			
           
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
<!-- Scripts -->
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<script>var contextPath = "${pageContext.request.contextPath}";</script>


<script>
	function updateSubmit(){
		updateForm.submit();
	}
</script>	
</html>