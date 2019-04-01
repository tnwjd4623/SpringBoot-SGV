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
		</tr>
		<tr>
			<c:forEach items="${scheduleList}" var="s" varStatus="status">
					<td>
					<form action="booking_action">
						<input type="hidden" name="m_no" value=${m_no}>
						<input type="hidden" name="id" value=${id}>
						<input type="hidden" name="pw" value=${pw}>
						<input type="hidden" name="c_no" value=${s.c_no}>
						<input type="hidden" name="date" value=${s.date}>
						<input type="hidden" name="s_time" value=${s.s_time}>
						<input type="hidden" name="e_time" value=${s.e_time}>
						${cinema[status.index]}<br/>
						상영 날짜 : ${s.date}<br/>
						상영 시작 시간 : ${s.s_time}<br/>
						상영 종료 시간 : ${s.e_time}<br/>
						<input type="submit" value="예매하기">
					</form>
					</td>
			</c:forEach>
		</tr>
	</table>
</body>
</html>