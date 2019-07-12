<%@page import="poly.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<BoardDTO> bList = (List<BoardDTO>)request.getAttribute("bList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
<link rel="stylesheet" href="/css/bootstrap.css"> <!-- 경로는 절대경로 사용하는 것 추천 -->
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="/js/bootstrap.js"></script>
</head>
<body>
<%@include file="/WEB-INF/view/loginBody.jsp" %> <!-- 화면 상단에 떠있도록.. -->

<div style="width: 800px; margin: 5% 15%;">
	<div style="text-align:center; font-size:2em;">
		게시판
	</div>
	<table class="table table-striped">
	
	<thead>
		<tr>
			<th width="100px">글번호</th>
			<th width="500px">글제목</th>
			<th width="200px">날짜</th>
		</tr>
	</thead>
	<tbody>
		<%for(BoardDTO bDTO : bList){ %>
		<tr>
			<td><%=bDTO.getSeq() %></td>
			<td><a href="/board/boardDetail.do?seq=<%= bDTO.getSeq() %>"><%=bDTO.getTitle() %></a></td>
			<td><%=bDTO.getRegDate() %></td>
		</tr>
		<%} %>
		
	</tbody>
	
	</table>
	
	<hr/>
	<a class="btn btn-primary" href="/board/boardReg.do" role="button">글작성</a>
</div>

</body>
</html>