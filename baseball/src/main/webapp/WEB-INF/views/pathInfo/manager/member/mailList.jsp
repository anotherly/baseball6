<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%System.out.println("@#@#@#@#@#@#@#���ϸ���Ʈ jsp"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<br>
	<table border="1">
		<tr>
			<td></td>
			<td>���� ��¥</td>
			<td>���� ���</td>
			<td>����</td>
		</tr>
		<c:forEach items="${data.dd }" var="mail" varStatus="no">
			<tr>
				<td>${no.index+1 }</td>
				<td>${mail.maildate }</td>
				<td>${mail.sendid }</td>
				<td><a href="mailDetail?mailid=${mail.mailid }">${mail.title }</a></td>
			</tr>
		</c:forEach>
		<!-- <tr>
			<td colspan="4" align="center"><a href="mailInsert">����������</a></td>
		</tr> -->
	</table>
	<br>
</body>
</html>