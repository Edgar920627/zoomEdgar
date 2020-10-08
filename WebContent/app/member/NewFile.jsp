<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Document</title>
        <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
        
   
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
    
    <style>
        #wrapper{
            border:2px solid salmon;
            border-radius: 5px;;
            width: 400px;
            height:400px;
            margin:auto;
        }
        .title{
            text-align: center;
            font-size: 20px;
           font-weight: bold;
           color:black;
           margin:20px 0px 20px 0px;
          
        }
        label{
            width:95px;
            display: inline-block;
            text-align: right;
            font-size: 13px;
           
        }
        input{
            margin:3px 5px;
            border-radius: 3px;
            background-color: transparent;
            border:1px solid darkgray;
            height:20px;
            outline:none;
            
        }
        
        #signup{
        text-align: center;
        margin:5px;
        }
        input[type=button],input[type=reset]{
            border:1px solid salmon;
            border-radius: 3px;
            background-color: transparent;
            margin:0px;
            height:24px;
            color:salmon;
        }
        
        input[type=button]:hover,input[type=reset]:hover{
        background-color: salmon;
        transition-duration:1s;
        color:white;
      	outline:none;
        }
        
		#roadAddress,#detailAddress{
			width: 280px;
		}
        .regex{
            font-size: 12px;
            text-align: center;
        }
    </style>
    <body>
    
    	<header id="header"></header> 
    	
    	
    	<!-- Main -->
			<section class="main">
				<section>
				<h1 style="text-align:center; color: #777474; font-weight: bolder;">회원가입</h1>
			
				
					
    <form action="${pageContext.request.contextPath}/member/MemberJoinOk.me" method="post" id="joinForm" name="joinForm">
    
    <div align="center">
    <table class="alt"  style="width:40%; margin:40px auto; height:100%; border: 2px solid #FFBF00; background-color: #FFFFFF; ">
						
							<colgroup>
								<col width="25%" />
								<col width="70%" />
								<col width="5%" />
	
							</colgroup>
							<thead>

							
							<tr style="background-color: #FFBF00; color: #FFFFFF; font-size: 15px;">
								<td align="center" colspan="3">
									회원 가입 정보 입력
								</td>
							</tr>
							
							<tr>
								<td align="center" colspan="3">
								</td>
							</tr>
							
							<tr>
								 <td align="left" style="font-size: 11px;"><b>아이디:</b></td>
								<td align="center" >
         						   <input type="text" name="user_id" id="user_id" style="width:250px; font-size: 10px;" placeholder="※4-12자의 영문 대소문자와 숫자로만 입력">
           						 <div class="user_id regex" align="left"></div>
								</td>
								<td align="left">
								
          						  <input type="button" value="중복확인" id="duplcheck" style="width:80px; font-size: 10px;">
								</td>
							</tr>
							
							
							<tr>
								<td align="left" style="font-size: 11px;"><b>비밀번호:</b></td>
								<td align="center" >
								<input type="password" style="width:250px; font-size: 10px;" name="user_pw" id="user_pw" placeholder="※영어대소문자,숫자 8-11자리"/>
								<div class="user_pw regex"></div>
								</td>
								
							</tr>
							<tr>
								<td align="left" style="font-size: 11px;"><b>비번 확인:</b></td>
								<td align="center" >
								<input type="password" style="width:250px; font-size: 10px;" name="repw" id="repw" placeholder="※영어대소문자,숫자 8-11자리"/>
								<div class="repw regex"></div>
								</td>
								
							</tr>
							
							<tr>
								<td align="left" style="font-size: 11px;"><b>이름 :</b></td>
								<td align="center" >
								<input type="text" style="width:250px; font-size: 10px;" name="user_name" id="user_name" placeholder="※한글만 입력"/>
								<div class="user_name regex"></div>
								</td>
							</tr>
							
							
							<tr>
								<td align="left" style="font-size: 11px;"><b>이메일 :</b></td>
								<td align="center" >
								<input type="text" style="width:250px; font-size: 10px;" name="user_email" id="user_email"  placeholder="E-mail"/>
								 <div class="user_email regex"></div>
								</td>
							</tr>
							
							<tr>
								<td align="center" colspan="3">
								</td>
							</tr>
							
							
							<tr>
								<td align="center" colspan="3" >
								
					<!-- 			<input type="reset" value="다시입력" id="resignupbtn" style="font-size: 10px;"> -->
								
							
								
								<a href="javascript:formSubmit()" class="button" id="signupbtn" style=" padding: 1px; font-size: 10px; width:100px">
								이메일 인증하기
								</a>
								</td>
							
							</tr>
							
							
				</thead>
				</table>
				</div>
				</form>
				
				
				<br />
				<br />
				<br />
				<br />
				
				
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
				
														
   


        <script>
   
         $(function(){
            // 중복확인 & id 유효성검사             
            $("#duplcheck").on("click",function(){
                var user_id = $("#user_id").val();
                if(user_id == ""){
                	alert("아이디를 입력해주세요");
                	return;
                }
                var regex = /^[a-z][a-z\d]{4,11}$/;
            	var result = regex.exec(user_id);
                
            	 if(result != null){
                     $(".user_id.regex").html("");
                window.open("/njnj/member/MemberCheckIdOk.me?user_id="+ user_id,"","width=500px,height=300px,top=300px,left=200px");
                 }else{
                     $(".user_id.regex").html("영어 소문자,숫자 4-12자리");
                     $(".user_id.regex").css("color","red")
                 }
                
                
            })
                
         
    	//비밀번호 유효성검사
            $("#user_pw").on("input",function(){
                var regex = /^[A-Za-z\d]{8,12}$/;
                var result = regex.exec($("#user_pw").val())
                
                if(result != null){
                    $(".user_pw.regex").html("");
                }else{
                    $(".user_pw.regex").html("영어대소문자,숫자 8-11자리");
                    $(".user_pw.regex").css("color","red")
                }
            });
            
           //비밀번호 확인    
               $("#repw").on("keyup",function(){
                    if($("#user_pw").val()==$("#repw").val()){
                       $(".repw.regex").html("비밀번호가 일치합니다"); 
                    }else{
                     $(".repw.regex").html("비밀번호가 일치하지않습니다"); 
                    }
               })
            
            //이름 유효성검사
                $("#user_name").on("input",function(){
                    var regex = /[가-힣]{2,}/;
                    var result = regex.exec($("#user_name").val());
                    
                    if(result != null){
                       $(".user_name.regex").html("");  
                    }else{
                        $(".user_name.regex").html("한글만 입력 가능합니다.");
                    }
                    
                })
            

            
            //email유효성 검사
                $("#user_email").on("input",function(){
                     var regex = /.+@[a-z]+(\.[a-z]+){1,2}$/;
                     var result = regex.exec($("#user_email").val());
                    
                    if(result != null){
                       $(".user_email.regex").html("");  
                    }else{
                        $(".user_email.regex").html("올바른 이메일이 아닙니다");
                    }
                })
          //회원가입 버튼 눌렀을 때, 빈칸 있으면 다시 유효성 검사진행    
           $("#signupbtn").on("click",function(){
        	   var user_id = $("#user_id").val();
        	   var user_pw = $("#user_pw").val();
        	   var user_name = $("#user_name").val();

        	   var user_email = $("#user_email").val();
        	   
        	   var idregex = /^[a-z][a-z\d]{4,11}$/;
        	   var pwregex = /^[A-Za-z\d]{8,12}$/;
        	   var nameregex = /[가-힣]{2,}/;
 
        	   var emailregex = /.+@[a-z]+(\.[a-z]+){1,2}$/;
        	   
        	   var idregex = idregex.exec(user_id);
        	   if(idregex == null){
        		   alert("아이디양식을 다시 확인해주세요");
        		   return;
        	   }
        	   var pwregex = pwregex.exec(user_pw);
        	   if(pwregex == null){
        		   alert("비밀번호양식을 다시 확인해주세요");
        		   retrun;
        	   }
        	   var nameregex = nameregex.exec(user_name);
        	   if(nameregex == null){
        		   alert("이름양식을 다시 확인해주세요");
        		   retrun;
        	   }

        	   var emailregex = emailregex.exec(user_email);
        	   if(emailregex == null){
        		   alert("이메일양식을 다시 확인해주세요");
        		   retrun;
        	   }
        	   

               //빈칸 없을 때 제출.
        	   $("#joinForm").formSubmit();
           })
        })
        </script>
        
        		function formSubmit(){
        			joinForm.submit();
        		}
        
        <script>

</script>	
    </body>
</html>