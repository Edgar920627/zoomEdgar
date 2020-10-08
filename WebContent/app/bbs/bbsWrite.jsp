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

<!--
   Faction by Pixelarity
   pixelarity.com | hello@pixelarity.com
   License: pixelarity.com/license
-->
<html>

<style>


table {
width: 100%; 
border: 0px solid #C0C0C0; 
background-color: #FFFFFF; 
color: #ffa500; 
font-size: 15px; 
font-weight: bold;
}

tr {
width: 100%; 
border: 0px solid #C0C0C0; 
background-color: #FFFFFF; 
color: #ffa500; 
font-size: 20px; 
font-weight: bold;
}
</style>


 
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
	<header id="header"></header>
	
	<c:set var="bbsList" value="${requestScope.bbsList}" />
	<c:set var="bbsBean" value="${requestScope.bbsBean}" />
	


		<div class="wrapper">	
	<section class="main">
		<section>

		<h9 style="width: 100%; color: #ffa500; font-size: 30px; font-weight: bold;" id ="title">${bbsBean.getBbs_maindiv}</h9>
	
	</br>
	</br>

	 
<!-- 	<div class="col-12" style="float:right; width:17%; margin-top:70px;">
	<select name="category" id="category">
	<option value="">- Category -</option>
	<option value="1">Manufacturing</option>
	<option value="1">Shipping</option>
	<option value="1">Administration</option>
	<option value="1">Human Resources</option>
	</select>
	</div> -->
	
	
<!-- 게시판 등록 -->
			

				<form action="${pageContext.request.contextPath}/bbs/BbsWriteOk.bb" method="post" enctype="multipart/form-data" name="bbsform">
				
				
				<table style="width: 100%; border: 5px solid #ffa500; background-color: #FFFFFF; color: #ffa500; font-size: 20px; font-weight: bold;">
				
				
				
				<colgroup>
          		<col width="5%" />
         		<col width="20%" />
   
				</colgroup>
				
		

	
	
						
					<tr style="width: 100px; border: 0px solid #C0C0C0; background-color: #FFFFFF; color: #ffa500; font-size: 20px; font-weight: bold;">
			
						<td align="center">
							<div align="center">대 분류</div>
						</td>
						
						<td>
							<div style="width: 25%; color: black;">
							<select name="bbs_maindiv" id="bbs_maindiv" >
								<option value="">- 대 분류 -</option>
								
								<c:if test="${session_id != 'admin'}">
				     	   		<option id="bbs_maindiv" value="인터넷방송">인터넷방송</option>
				     	   		<option id="bbs_maindiv" value="게임">게임</option>
				     	   		<option id="bbs_maindiv" value="스포츠">스포츠</option>
				     	   		<option id="bbs_maindiv" value="금융/주식">금융/주식</option>
				     	   		<option id="bbs_maindiv" value="여행/음식">여행/음식</option>
				     	   		<option id="bbs_maindiv" value="기타">기타</option>
				     	   		</c:if>
				     	   		
				     	   		<c:if test="${session_id eq 'admin'}">
		<!-- admin 계정만 공지  -->	<option id="bbs_maindiv" value="공지">공지</option>
				     	   		</c:if>
							</select>
							</div>
						</td>
						
					</tr>
					
					
					<tr style="width: 100px; border: 0px solid #C0C0C0; background-color: #FFFFFF; color: #ffa500; font-size: 20px; font-weight: bold;">
					<td align="center">
							<div align="center">소 분류</div>
						</td>
						
						<td>
							<div style="width: 25%; color: black;">
							<select name="bbs_smalldiv" id="bbs_smalldiv" >
								<option value="">- 소 분류 -</option>
								<c:if test="${session_id != 'admin'}">
				     	   		<option id="bbs_smalldiv" value="자유게시판">자유게시판</option>
				     	   		<option id="bbs_smalldiv" value="질문/답변">질문/답변</option>
				     	   		<option id="bbs_smalldiv" value="기타">기타</option>
				     	   		</c:if>
				     	   		
				     	   		<c:if test="${session_id eq 'admin'}">
				     	   		<option id="bbs_smalldiv" value="공지">공지</option>	<!-- admin 계정만 공지  -->
				     	   		</c:if>
							</select>
							</div>
						</td>
						
					</tr>
			
				
					<tr style="width: 100px; border: 0px solid #C0C0C0; background-color: #FFFFFF; color: #ffa500; font-size: 20px; font-weight: bold;">
			
						<td align="center">
							<div align="center">제 목</div>
						</td>
						
						<td style="padding-left:10px; color: black;">
							<input name="bbs_title" type="text" size="50" maxlength="50" value=""/>
						</td>
						
					</tr>
					<tr  style="width: 100px; border: 0px solid #C0C0C0; background-color: #FFFFFF; color: #ffa500; font-size: 20px; font-weight: bold;">
						<td align="center">
							<div align="center">글쓴이</div>
						</td>
						<td style="padding-left:10px;  color: black;">
							<input name="user_id" type="text" size="10"  value="${session_id}" readonly />
							
							 	<!-- <input name="user_id" type="text" size="10" maxlength="10" value="admin" readonly /> -->
							
						</td>
					</tr>
					
					
					<tr height="100px" style="width: 100%; border: 0px solid #C0C0C0; background-color: #FFFFFF; color: #ffa500; font-size: 20px; font-weight: bold;">
						<td align="center" >
							<div align="center">내 용</div>
						</td>
						<td style="padding-left:10px; color: black;" >
							 <textarea name="bbs_explantion"  maxlength="2000"  rows="16"  wrap="physical" placeholder="내용 적어주세요" style="resize: none;"></textarea>
							 
							<!--  test
							<textarea name="bbs_explantion"  maxlength="2000"  rows="16"  wrap="hard" placeholder="내용 적어주세요" style="resize: none;"></textarea> 
							-->

						</td>
					</tr>
					
					
					
					<!-- 첨부 파일 -->
				<tr height="30px" style="width: 100%; border: 0px solid #C0C0C0; background-color: #FFFFFF; color: #ffa500; font-size: 20px; font-weight: bold;">
						<td align="center">
							<div align="center">파일 첨부</div>
						</td>
						<td style="padding-left:10px;">
							<input name="board_file1" type="file"/>
							<input type="button" onclick="cancleFile('board_file1')" value="첨부 삭제">
						</td>
					</tr>
					
					
	
				</table>
				
			
				
				<table  style="width: 100%; border: 0px solid #ffa500; background-color: #FFFFFF; color: #ffa500; font-size: 20px; font-weight: bold;">
					<tr align="right" valign="middle" style="width: 100%; border: 0px solid #C0C0C0; background-color: #FFFFFF; color: #ffa500; font-size: 20px; font-weight: bold;">
						<td>
						
						<!-- admin 관리자 계정 준비중 -->
						<c:if test="${session_id eq 'admin'}">
						
							</c:if>
							
							<div>
							<a href="javascript:addbbs()" class="button">
							등록
							</a>&nbsp;&nbsp;
							
							
							
							
							<a href="${pageContext.request.contextPath}/bbs/BbsSearchList.bb?bbs_maindiv=${session_maindiv}&bbs_smalldiv=${session_smalldiv}" class="button">
						목록
						</a>&nbsp;&nbsp;
							</div>
						
						</td>
					</tr>
				</table>
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
	<script>
	
	
	
	
		
		
		var check = true;
		
		function addbbs(){
			

			bbsform.submit();
		}
		
		
		
		function cancleFile(fileTagName){
			//ie일 때
			if($.browser.msie){
				$("input[name='"+fileTagName+"']").replaceWith(("input[name='"+fileTagName+"']").clone(true));
			}else{
			//그 외 브라우저	
				$("input[name='"+fileTagName+"']").val("");
			}
		}
		
	</script>
</html>