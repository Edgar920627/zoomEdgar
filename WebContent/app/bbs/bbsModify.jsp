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
	
	<c:set var="bbs_smalldiv" value="${requestScope.bbs_smalldiv}" />
	<c:set var="bbs_maindiv" value="${requestScope.bbs_maindiv}" />
	<c:set var="bbsList" value="${requestScope.bbsList}" />
	<c:set var="bbsBean" value="${requestScope.bbsBean}" />
	


		<div class="wrapper">	
	<section class="main">
		<section>

		<h9 style="width: 100%; color: #ffa500; font-size: 30px; font-weight: bold;" id ="title">${bbs_maindiv}</h9>
	
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
			

		<form action="${pageContext.request.contextPath}/bbs/BbsModifyOk.bb?bbs_num=${bbsBean.getBbs_num()}" method="post" enctype="multipart/form-data" name="bbsModifyform"> 
				
				
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
								<option value="${bbs_maindiv}">${bbs_maindiv}</option>
				     	   		<option id="bbs_maindiv" value="인터넷방송">인터넷방송</option>
				     	   		<option id="bbs_maindiv" value="게임">게임</option>
				     	   		<option id="bbs_maindiv" value="스포츠">스포츠</option>
				     	   		<option id="bbs_maindiv" value="금융/주식">금융/주식</option>
				     	   		<option id="bbs_maindiv" value="여행/음식">여행/음식</option>
				     	   		<option id="bbs_maindiv" value="기타">기타</option>
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
								<option value="${bbs_smalldiv}">${bbs_smalldiv}</option>
				     	   		<option id="bbs_smalldiv" value="자유게시판">자유게시판</option>
				     	   		<option id="bbs_smalldiv" value="질문/답변">질문/답변</option>
				     	   		<option id="bbs_smalldiv" value="기타">기타</option>
							</select>
							</div>
						</td>
						
					</tr>
			
				
					<tr style="width: 100px; border: 0px solid #C0C0C0; background-color: #FFFFFF; color: #ffa500; font-size: 20px; font-weight: bold;">
			
						<td align="center">
							<div align="center">제 목</div>
						</td>
						
						<td style="padding-left:10px; color: black;">
							<input name="bbs_title" type="text" size="50" maxlength="30" value="${bbsBean.getBbs_title()}" />
						</td>
						
					</tr>
					<tr  style="width: 100px; border: 0px solid #C0C0C0; background-color: #FFFFFF; color: #ffa500; font-size: 20px; font-weight: bold;">
						<td align="center">
							<div align="center">글쓴이</div>
						</td>
						<td style="padding-left:10px;  color: black;">
							<input name="user_id" type="text" size="10"  value="${bbsBean.getUser_id()}" readonly />
							
							 	<!-- <input name="user_id" type="text" size="10" maxlength="10" value="admin" readonly /> -->
							
						</td>
					</tr>
					
					
					<tr height="100px" style="width: 100%; border: 0px solid #C0C0C0; background-color: #FFFFFF; color: #ffa500; font-size: 20px; font-weight: bold;">
						<td align="center" >
							<div align="center">내 용</div>
						</td>
						<td style="padding-left:10px; color: black;" >
							<textarea name="bbs_explanation"  maxlength="2000"  rows="16"  style="resize: none;">${bbsBean.getBbs_explanation()}</textarea>

						</td>
					</tr>
					
					
					
					<!-- 첨부 파일 -->
				<tr height="30px" style="width: 100%; border: 0px solid #C0C0C0; background-color: #FFFFFF; color: #ffa500; font-size: 20px; font-weight: bold;">
						<td align="center" width="150px">
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
							<a href="javascript:addbbsModify()" class="button">
							수정완료
							</a>&nbsp;&nbsp;&nbsp;&nbsp;
							
		
							
							
							<a href="javascript:history.back();" class="button">뒤로가기</a>&nbsp;&nbsp;&nbsp;&nbsp;
							
							
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
		
		function addbbsModify(){
			

			bbsModifyform.submit();
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