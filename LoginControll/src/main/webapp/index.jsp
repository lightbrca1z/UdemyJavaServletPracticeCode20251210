<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// ログイン画面にリダイレクト
	String contextPath = request.getContextPath();
	response.sendRedirect(contextPath + "/Login");
%>

