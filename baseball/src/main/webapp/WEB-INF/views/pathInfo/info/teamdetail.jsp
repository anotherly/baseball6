<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	System.out.println("@@@@@@@@@@@@@@@@view.jsp");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>�� ���̵� �ѹ�</td>
			<td>${data.dd.teamId }</td>
		</tr>
		<tr>
			<td>�̸�</td>
			<td>${data.dd.teamName }</td>
		</tr>
		<tr>
			<td>�繫��</td>
			<td>${data.dd.office }</td>
		</tr>
		<tr>
			<td>��ȭ</td>
			<td>${data.dd.tel }</td>
		</tr>
		<tr>
			<td>Ȩ������</td>
			<td>${data.dd.homepage }</td>
		</tr>
		<tr>
			<td>â�ܳ⵵</td>
			<td>${data.dd.teamBirth }</td>
		</tr>
		<tr>
			<td>������</td>
			<td>${data.dd.home }</td>
		</tr>
		<tr>
			<td>������</td>
			<td>${data.dd.owner }</td>
		</tr>
		<tr>
			<td>��ǥ�̻�</td>
			<td>${data.dd.president }</td>
		</tr>
		<tr>
			<td>����</td>
			<td>${data.dd.captin }</td>
		</tr>
		<tr>
			<td>����</td>
			<td>${data.dd.manager }</td>
		</tr>
		<tr>
			<td>����</td>
			<td>${data.dd.sysFile }<img alt=""
				src="../../resources/teamPhoto/${data.dd.sysFile}">
			</td>
		</tr>
		<tr>
			<td>����</td>
			<td>${data.dd.sysFile }<img alt=""
				src="../../../resources/teamPhoto/${data.dd.sysFile}">
			</td>
		</tr>

		<tr>
			<td colspan="2" align="center"><a href="teaminfolist">�������</a> 
				<%-- <c:choose>
					<c:when test="${loginVo.grade eq 'admin' }">
						<a href="modify?teamId=${data.dd.teamId }">�����ϱ�</a>
						<a href="delete?teamId=${data.dd.teamId }">�����ϱ�</a>
					</c:when>
				</c:choose> --%>
			</td>
	</table>
</body>
</html>