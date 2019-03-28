<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="booking">
		<input type="hidden" name="m_no" value=${movie.m_no}>
		아이디 : <input type="text" name="id">
		비밀번호 : <input type="password" name="pw">
		<input type="submit" value="비회원 예매">
	</form>
</body>
</html>