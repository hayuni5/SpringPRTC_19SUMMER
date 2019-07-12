<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="session.jsp" %> <!-- 추가된 부분 -->
<div style="margin: 3% 15%; text-align: center">
<% if(userId =="") { %> <!-- index.jsp에서 잘라온 부분 -->
	
	<div>=============로그인 시작=============</div>
	
	<form action="/userLogin.do" method="POST">
		<div style="display: inline-block">
		<div style="display: flex; ">
			<div>아이디 </div>
			<input type="text" name="userId">
			<div>비밀번호 </div>
			<input type="text" name="userPassword">
			<button class = "bth btn-primary" type="submit">로그인</button>
		</div>
		</div>	
	</form>
	<div>=============로그인 끝=============</div>
	<button style="cursor:pointer;" onclick="location.href='/userReg.do'"> 회원가입 페이지로 이동하기 </button>
	<%} else { %>
	<div>=============로그인 성공=============</div>
		<div style="display: inline-block">
		<div style="background-color: beige; text-align: center;">
			<div style="font-size: 25px;"><%=userName%> 님 안녕하세요 :)</div>
			
			<button onclick="location.href='/logout.do'" class="btn btn-danger">로그아웃</button>
			<br/>
		</div>
	</div>
<div>=============로그인 성공=============</div>
<button style="cursor:pointer;" onclick="location.href='/board/boardList.do'"> 게시판 목록으로 이동하기 </button>
<%} %>
</div>
