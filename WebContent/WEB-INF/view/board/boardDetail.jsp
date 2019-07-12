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
<title>게시글 상세내용</title>
</head>
<body>
	<form action="/board/boardModify.do" method="post">
	
		<input type="hidden" name="seq" value="<%=bDTO.getSeq() %>">
		<table border="1">
			<col width="100px" />
			<col width="500px" />
			<tr>
				<td align="center">제목</td>
				<td><input type="text" readonly="readonly" name="title" maxlength="100" style="width: 450px;" value="<%=bDTO.getTitle()%>" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea readonly="readonly" name="contents" style="width: 550px; height: 400px"><%=bDTO.getContent() %></textarea>
			</tr>
			<tr>
			<td align="center" colspan="2">
				<input type="submit" value="수정">
				<input type="button" onclick="location.href='/board/boardDelete.do?seq=<%=bDTO.getSeq() %>'" value="삭제" />
				<input type="button" onclick="location.href='/board/boardList.do'" value="돌아가기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>