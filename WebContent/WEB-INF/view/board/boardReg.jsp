<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>19.07.10 게시판</title>
</head>
<body>
<%@include file="/WEB-INF/view/loginBody.jsp" %> <!-- 줄줄줄 써놓은 것 잘라서 loginBody.jsp로 만들고 요렇게 써넣어서 집어넣었음 -->
<form action="/board/boardRegProc.do" method="post">
	<table border="1">
		<col width="100px" />
		<col width="500px" />
	<tr>
		<td align="center">제목</td>
		<td><input type="text" name="title" maxlength="100" style="width: 450px" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<textarea name="contents" style="width: 550px; height: 400px;"></textarea>
		</td>
	</tr>
	<tr>
		<td align="center" colspan="2">
			<input type="submit" value="등록" />
		</td>
	</tr>
	</table>
	<input type="hidden" name="userSeq" value="<%=userSeq %>"/>
</form>

</body>
</html>