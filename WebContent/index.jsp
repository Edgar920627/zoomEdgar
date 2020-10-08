<%@page import="com.dohwaji.app.member.dao.MemberBean"%>
<%@page import="com.dohwaji.app.member.dao.MemberDAO"%>
<%@page import="com.dohwaji.app.bbs.dao.BbsBean"%>
<%@page import="com.dohwaji.app.bbs.dao.BbsDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

<script language="JavaScript">
   $(document).ready(function() {
      var $banner = $(".banners").find("ul");

      var $bannerWidth = $banner.children().outerWidth();
      var $bannerHeight = $banner.children().outerHeight(); 
      var $bannerLength = $banner.children().length;
      var rollingId;

      rollingId = setInterval(function() { rollingStart(); }, 3000);
      
      function rollingStart() {
         $banner.css("width", $bannerWidth * $bannerLength + "px");
         $banner.css("height", $bannerHeight + "px");
         $banner.animate({left: - $bannerWidth + "px"}, 2000, function() { 
            $(this).append("<li>" + $(this).find("li:first").html() + "</li>");
            $(this).find("li:first").remove();
            $(this).css("left", 0);
         });
      }
   }); 
</script>

</head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<script>
   $(document).ready(function(){ $("#header").load("${pageContext.request.contextPath}/app/include/header.jsp") });
</script>   
<body class="is-preload">


   <c:set var="memberBean" value="${requestScope.memberBean}"/>
   <c:set var="user_id" value="${session_id}"/>
   <c:set var="session_ip" value="${session_ip}"/>
   
   	
	<!-- jsp:useBean : ProductReplyDAO    -->
	<jsp:useBean id="m_dao" class="com.dohwaji.app.member.dao.MemberDAO"></jsp:useBean>
	<jsp:useBean id="memberBean" class="com.dohwaji.app.member.dao.MemberBean"></jsp:useBean>
	
	<jsp:useBean id="b_dao" class="com.dohwaji.app.bbs.dao.BbsDAO"></jsp:useBean>
	<jsp:useBean id="bbsBean" class="com.dohwaji.app.bbs.dao.BbsBean"></jsp:useBean>
 	
	<% 
	BbsDAO bbsDAO = new BbsDAO();
	List<BbsBean> noticeList = bbsDAO.noticeBbs();
	
	%>


   <header id="header"></header>
      <!-- Wrapper -->
      <div class="wrapper">

         <!-- Main -->
            <section class="main">


                  
                  
                  <!-- Banner -->
							<section id="banner">
								<article data-position="bottom right">
									<div class="inner">
										<img src="images/slide01.jpg" alt="">
										<h2>Ultricies sed magna</h2>
										<p>Mauris neque quam, fermentum ut nisl vitae, convallis maximus nisl. Sed mattis nunc id lorem euismod placerat. Vivamus porttitor magna enim, ac accumsan tortor ipsum dolor.</p>
										<ul class="actions">
											<li><a class="button large" href="#">Magna sed dolor</a></li>
										</ul>
									</div>
								</article>
								<article data-position="top right">
									<div class="inner">
										<img src="images/slide02.jpg" alt="">
										<h2>Sed mattis nunc lorem</h2>
										<p>Phasellus sed ultricies mi non congue ullam corper. Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida fringilla.</p>
										<ul class="actions">
											<li><a class="button large" href="#">Magna sed dolor</a></li>
										</ul>
									</div>
								</article>
								<article data-position="right">
									<div class="inner">
										<img src="images/slide03.jpg" alt="">
										<h2>Nisl sed vitae</h2>
										<p>Fusce tincidunt, nisl eget mattis egestas, purus ipsum consequat orci, sit amet lobortis lorem lacus in tellus. Sed ac magna consequat purus ipsum consequat.</p>
										<ul class="actions">
											<li><a class="button large" href="#">Magna sed dolor</a></li>
										</ul>
									</div>
								</article>
								<article data-position="center">
									<div class="inner">
										<img src="images/slide04.jpg" alt="">
										<h2>Porta ultricies consectetur</h2>
										<p>Mattis ante fermentum, malesuada neque vitae, eleifend erat. Phasellus non pulvinar erat. Fusce tincidunt lorem ipsum dolor sit amet. Magna tellus fusce tincidunt lorem.</p>
										<ul class="actions">
											<li><a class="button large" href="#">Magna sed dolor</a></li>
										</ul>
									</div>
								</article>
							</section>
							
						
                  
                  
                  
          					<!-- 공지사항_text부분 -->
					
					<div style="padding: 5px;">
					
					<h7><div style="padding: 5px;  font-size: 20px; font-weight: bold;">공지사항</div></h7>
					
	
						<table id="bbs" class="bbs" cellpadding="0" cellspacing="0"
							style="width:100%; border: 2px solid #FDF5E6;">
							<colgroup>
								<col width="4%" />
								<col width="10%" />
								<col width="30%" />
								<col width="7%" />
								<col width="15%" />
								<col width="10%" />
								<col width="1%" />
							</colgroup>
							<thead>
								<tr style=" background-color: #FDF5E6; font-size: 12px; font-weight: bold; color: #000000;">
									<th><div align="left">번호</div></th>
									<th><div align="center">분류</div></th>
									<th><div align="left">제목</div></th>
									<th><div align="center">글쓴이</div></th>
									<th><div align="center">날짜</div></th>
									<th><div align="center">조회수</div></th>
									<th><div align="center"></div></th>
								</tr>
							</thead>
							<tbody>
					<%
					
					BbsBean b_bean = new BbsBean();
					
					for(int i=0; i<3; i++) {
						
					
						%>
											<tr style="font-weight: bold; font-size: 9px; color: #000000;"  valign="middle">


												<td style=" background-color: #FFFFFF;">
													<div align="left"><%=noticeList.get(i).getBbs_num() %></div>
												</td>
												<td style="background-color: #FFFFFF; font-weight: bold; font-size: 9px; color: #FF0000;">
													<div align="center"><%=noticeList.get(i).getBbs_smalldiv() %></div>
												</td>
													
													
													
													<!-- 제목 & 댓글 수  -->
												<td style="background-color: #FFFFFF;">
													<div align="left"><%=noticeList.get(i).getBbs_title() %></div>
												</td>

												<td style="background-color: #FFFFFF;">
													<div align="center"><%=noticeList.get(i).getUser_id() %></div>
												</td>
												<td style="background-color: #FFFFFF;">
													<div align="center"><%=noticeList.get(i).getBbs_date() %></div>
												</td>
												<td style="background-color: #FFFFFF;">
													<div align="center"><%=noticeList.get(i).getBbs_readcount() %></div>
												</td>

												<td style="background-color: #FFFFFF;">
													<div align="center"></div>
												
												</td>
											</tr>
						
					<%
					}
					
					%>
						</table> 
					</div>
	
	
<!-- 	
               Features
                  <section class="features alt">
                     <article class="icon fa-gem">
                        <h3></h3>
                        <p>나를 바꿔 줄 화장법을 찾아보세요!</p>
                     </article>
                     <article class="icon fa-save">
                        <h3>제품 리뷰</h3>
                        <p>화장품의 모든 정보를 알아보세요!</p>
                     </article>
                  </section>
 -->


               <!-- Spotlights -->
                  <section class="spotlights alt">
                     <article>
                        <a href="#" class="image fit"><img src="${pageContext.request.contextPath}/app/images/배너 광고.png" alt=""></a>
                     <h10><a href=""><div align="center" style="font-size: 13px;"></div></a></h10>
                     </article>
                     
                     <article>
                        <a href="#" class="image fit"><img src="${pageContext.request.contextPath}/app/images/배너 광고.png" alt=""></a>
                     <h10><a href=""><div align="center" style="font-size: 13px;"></div></a></h10>
                     </article>
                     
                     <article>
                        <a href="#" class="image fit"><img src="${pageContext.request.contextPath}/app/images/배너 광고.png" alt=""></a>
                     <h10><a href=""><div align="center" style="font-size: 13px;"></div></a></h10>
                     </article>
                     
                     <article>
                        <a href="#" class="image fit"><img src="${pageContext.request.contextPath}/app/images/배너 광고.png" alt=""></a>
                     <h10><a href=""><div align="center" style="font-size: 13px;"></div></a></h10>
                     </article>
                     

                     
                  </section>

            </section>

         <!-- Sidebar -->
         <aside class="sidebar">
         <c:choose>
            <c:when test="${session_id != null}">
            <section style="text-align:center;">
               <h2 style="font-weight: bold;">내 정보</h2>
               
               
               <div align="center" ></div>
               <div>${session_name}(${session_id})</div>
               <div>IP&nbsp;&nbsp;${session_ip}</div>
               <p class="m1">${memberBean.getUser_name()}</p>
               
               <p style="font-weight: bold;"><%=session.getAttribute("session_id")%></p> 
             
               <ul class="actions" style="width:100%; display: inline-block;">
                  <li><a href="${pageContext.request.contextPath}/member/MemberInformation.me?user_id=${session_id}" class="button">프로필 보기</a></li> 
               </ul>
           	</section>
            </c:when>
            <c:otherwise>
            <section style="text-align:center; padding-top:20px; padding-bottom:50px;">
				<div class="login_index_center">
					<p class="login_top">로그인 해주세요!</p>
					<div style="width:100%; text-align:center">
						<ul class="actions fit" style="display:inline-block; width:80%; margin:0px;">
							<li><a href="${pageContext.request.contextPath}/member/MemberLogin.me" class="button primary fit">로그인</a></li>
						</ul>
					</div>
					<div class="login_bottom">
						<div class="login_bottom_left">
							<a href="${pageContext.request.contextPath}/member/find_id.me"><span>아이디 찾기</span></a><!-- 1 -->
							<span>/</span>
							<a href="${pageContext.request.contextPath}/member/find_pw.me"><span>비밀번호 찾기</span></a>
						</div>
						<div class="login_bottom_right">
							<a href="${pageContext.request.contextPath}/member/MemberJoin.me"><span>회원가입</span></a>
						</div>
                    </div> 
				</div>
			</section>
            </c:otherwise>
         </c:choose>
         
               
               <!-- Featured posts -->
               <!-- 광고 동영상  -->
               <section class="featured-posts" style="padding:20px;">
                  <video controls loop autoplay width="100%" height="auto" > 
                  <%--       <source src="${pageContext.request.contextPath}/app/video/video01.mp4" type="video/mp4">  --%>
                  </video>
               </section>
               
               
               
						<!-- Featured posts -->
							<section class="featured-posts">
								<h2>Sed aliquam</h2>
								<article>
									<a href="#" class="image fit"><img src="images/pic05.jpg" alt=""></a>
									<header>
										<span class="date">September 19, 2016</span>
										<h3><a href="#">Non velit accumsan cursus gravida amet sapien</a></h3>
									</header>
									<p>Phasellus in odio at ipsum porttitor mollis id vel diam. Praesent sit amet posuere risus, eu faucibus lectus. Vivamus ex ligula, tempus pulvinar ipsum in, auctor porta quam. Proin nec commodo, vel scelerisque nisi scelerisque. Suspendisse id quam vel tortor tincidunt suscipit. Nullam auctor orci eu dolor consectetur, interdum ullamcorper ante tincidunt. Mauris felis nec felis varius.</p>
									<ul class="actions">
										<li><a href="#" class="button">Continue Reading</a></li>
									</ul>
								</article>
							</section>
							
							

         <!-- Posts -->
   
         </aside>

      </div>

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

   </body>
   
   <!-- <tr> 테이블 클릭시 상세페이지 이동 -->
<script>
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
</html>