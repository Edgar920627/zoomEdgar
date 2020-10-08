<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function() {
		$("#header").load("${pageContext.request.contextPath}/app/include/header.jsp")
	});
</script>
<body class="is-preload">

	<header id="header"></header> 
		<!-- Wrapper -->
		<div class="wrapper">
	
			<!-- Main -->
			<section class="main">
				<section>
					<div align="center">
					<h4>회원 정보</h4>
					
					</div>					
					
				<form action="${pageContext.request.contextPath}/member/MemberNewPwOk.me" method="post" id="emailForm" name="emailForm">
   
   				 <table class="alt"  style="width:35%; margin:40px auto; height:100%; border: 2px solid #FFBF00; background-color: #FFFFFF; ">
						
	
							<thead>
														
							<tr style="background-color: #FFBF00; color: #FFFFFF; font-size: 15px; padding: 5px;">
								<td align="center" colspan="3">
									회원 정보
								</td>
							</tr>
							<tr>
								<td align="center" >
								</td>
							</tr>
							
						<tr style="padding: 20px;">
								 <td align="left" style="font-size: 11px; padding: 20px;"><b>아이디:</b></td>
								<td>
									<input type="text" value="${temp_user_id}" style="width:250px; font-size: 10px;" id="user_id" name="user_id" readonly />
									
								</td>
							</tr>
							
							<tr style="padding: 20px;">
								<td align="left" style="font-size: 11px; padding: 20px;"><b>이메일 :</b></td>
								<td><input type="text" value="${temp_user_email}" style="width:250px; font-size: 10px;" name="user_email" readonly/></td>
							</tr>
							
							<tr style="padding: 20px;">
								<td align="left" style="font-size: 11px; padding: 20px;"><b>비밀번호:</b></td>
								<td><input type="password" style="width:250px; font-size: 10px;" name="user_pw" placeholder="※영어대소문자,숫자 8-11자리"/></td>
							</tr>
							
							<tr>
								<td align="center" >
								</td>
							</tr>

						</table>
						<ul class="actions fit" >
							<li class="login" style="width:10%; marin:0 auto; text-align:center;">
							<a href="javascript:formSubmit()" class="button primary fit" style="width:150px; font-size: 13px;">비밀번호 변경하기</a></li>
						</ul>
					</form>	
					
				</section>
			</section>
		</div>
    <br />
    <br />
    <br />
       <!-- Footer -->
      <footer id="footer">
         <div class="inner">
            <section class="info">
               <h3>About Us</h3>
               <div class="about">
                  <p>Morbi mattis mi consectetur tortor elementum, varius pellentesque velit convallis. Aenean tincidunt lectus auctor mauris maximus, ac scelerisque ipsum tempor. Duis vulputate ex et ex tincidunt, quis lacinia velit aliquet. Duis non efficitur malesuada.</p><p>Sagittis felis ac sagittis semper. Curabitur purus leo donec vel dolor at arcu tincidunt bibendum. Interdum et malesuada fames ac ante ipsum primis.</p>
                  <ul class="actions">
                     <li><a href="#" class="button">Learn More</a></li>
                  </ul>
               </div>
               <div class="team">
                  <article>
                     <span class="image"><img src="${pageContext.request.contextPath}/app/images/pic06.jpg" alt=""></span>
                     <p>
                        <strong class="name">John Doe</strong>
                        <span class="title">Lorem semper magna etiam</span>
                     </p>
                  </article>
                  <article>
                     <span class="image"><img src="${pageContext.request.contextPath}/app/images/pic07.jpg" alt=""></span>
                     <p>
                        <strong class="name">Jane Anderson</strong>
                        <span class="title">Etiam feugiat adipiscing veroeros</span>
                     </p>
                  </article>
                  <article>
                     <span class="image"><img src="${pageContext.request.contextPath}/app/images/pic08.jpg" alt=""></span>
                     <p>
                        <strong class="name">Mike Smith</strong>
                        <span class="title">Consequat nulla dolor blandit</span>
                     </p>
                  </article>
               </div>
            </section>
            <section class="contact">
               <h3>Contact Us</h3>
               <ul class="contact-icons">
                  <li class="icon solid fa-home"><a href="#">1234 Somewhere Road #80486<br>Nashville, TN 00000</a></li>
                  <li class="icon solid fa-phone"><a href="#">(800) 555-0000 x12345</a></li>
                  <li class="icon solid fa-envelope"><a href="#">hello@untitled.tld</a></li>
                  <li class="icon brands fa-facebook"><a href="#">facebook.com/untitled-tld</a></li>
                  <li class="icon brands fa-twitter"><a href="#">twitter.com/untitled-tld</a></li>
               </ul>
            </section>
         </div>
         <div class="copyright">
            &copy; Untitled. All rights reserved.
         </div>
      </footer>
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
<script src="${pageContext.request.contextPath}/app/member/join.js"></script>
<script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>	

  </body>
  
  	<script>
	function formSubmit(){
		emailForm.submit();
	}
</script>

</html>

