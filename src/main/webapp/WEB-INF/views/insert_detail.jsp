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
	<table>
		<tr>
			<td>이름</td>
			<td></td>
		</tr>
		<form action="insert_movie">
			<c:forEach items="${cinemaList}" var="c">
				<tr>
					<input type="hidden" name="name" value="${c.name}">
					<td><input type="radio" name="cinema" value=${c.name}>${c.name}</td>
				</tr>	
			</c:forEach>
		</form>
		
	</table>
</body>
</html>