<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%System.out.println("@@@@@@@@@@@@@@@���� ����Ʈ.jsp"); %>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<td>�� ��ȣ</td>
			<td>�� �̸�</td>
			<td>������</td>
			<td>��� ��</td>
		</tr>
		
<c:forEach items="${data.dd }" var="vo">	
		<tr>
			
			<td>${vo.teamId }</td>
			<td><a href="teamdetail?teamId=${vo.teamId }">${vo.teamName }</a></td>
			<td>${vo.home }</td>
			<td>${vo.win }</td>
		</tr>
</c:forEach>		
		<tr>
			<td colspan="4" align="right">
				<c:choose>
					<c:when test="${loginVo.grade eq 'admin' }">
						<a href="teamRegister">���� �߰�</a>
					</c:when>
				</c:choose>
			</td>
		</tr>
	</table>
</body>
</html>