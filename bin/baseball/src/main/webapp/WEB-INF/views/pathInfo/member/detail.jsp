<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
			<tr><td>���̵�</td>
			<td>${data.dd.userid }</td></tr>
			<tr><td>�г���</td>
			<td>${data.dd.nick }</td></tr>
			<tr><td>�̸�</td>
			<td>${data.dd.name }</td></tr>
			<c:choose>
			<c:when test="${data.dd.sysname eq null}">
			</c:when>
			<c:otherwise>
			<tr><td>����</td><td>
			<img alt="" src="../../../resources/memberPhoto/${data.dd.sysname }" width="200px"></td></tr>
			</c:otherwise>
			</c:choose>
			<tr><td>�������</td>
			<td>${data.dd.birth }</td></tr>
			<tr><td>�ּ�</td>
			<td>${data.dd.address }</td></tr>
			<tr><td>�޴���</td>
			<td>${data.dd.phone }</td></tr>
			<tr><td>���ŵ���</td>
			<td>${data.dd.receivemail }</td></tr>
			<tr><td>��ȣ����</td>
			<td>${data.dd.preferTeam }
			</td></tr>
			<tr><td colspan="2" align="center">
			<%-- <a href="mailList?userid=${data.dd.userid }">������</a> --%>
			<a href="modify?userid=${data.dd.userid }">�����ϱ�</a>
			<a href="deleteForm?userid=${data.dd.userid }">Ż���ϱ�</a></td>

		</table>
	</body>
</html>