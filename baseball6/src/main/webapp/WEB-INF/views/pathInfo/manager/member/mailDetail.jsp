<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>���� ��¥</td>
			<td>${data.dd.maildate }</td>
		</tr>
		<tr>
			<td>���� ���</td>
			<td>${data.dd.sendid }</td>
		</tr>
		<tr>
			<td>����</td>
			<td>${data.dd.title }</td>
		</tr>
		<tr>
			<td>����</td>
			<td><textarea rows="5" cols="30" name="content" readonly="readonly">${data.dd.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><a href="mailDelete?mailid=${data.dd.mailid }">�����ϱ�</a></td>
		</tr>
	</table>
</body>
</html>