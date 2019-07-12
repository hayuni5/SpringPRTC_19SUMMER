<%@page import="poly.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDTO bDTO = (BoardDTO)request.getAttribute("bDTO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 수정</title>
</head>
<body>
	<form action="/board/boardModifyProc.do" method="post">
		<input type="hidden" name="seq" value="<%=bDTO.getSeq() %>">
		<div style="text-align:left; font-size:2em">글 수정</div>
		<table border="1">
			<col width="100px" />
			<col width="500px" />
			<tr>
				<td align="center">제목</td>
				<td><input type="text" name="title" maxlength="100" style="width: 450px;" value="<%=bDTO.getTitle()%>" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea name="contents" style="width: 550px; height: 400px"><%=bDTO.getContent() %></textarea>
				</td>
			</tr>
		<tr>
			<td align="center" colspan="2">
				<input type="submit" value="수정" />
			</td>
		</tr>
		</table>
	</form>
</body>
</html>