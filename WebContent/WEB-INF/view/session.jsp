<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = CmmUtil.nvl((String)session.getAttribute("userId"));
	String userName = CmmUtil.nvl((String)session.getAttribute("userName"));
	String userSeq = CmmUtil.nvl((String)session.getAttribute("userSeq"));
%>

<!-- loginBody.jsp에서 쓰이는 변수들 가져옴-->