<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function delalert() {
		if (confirm('�����Ͻðڽ��ϱ�?')) {
			fmt.submit()
		} else {

		}

	};
</script>
</head>
<body>
	<form action="delete" name="fmt">
		<input type="hidden" name="userid" value="${data.dd.userid }" /> <input
			type="hidden" name="boardid" value="${data.dd.boardid }" />
	</form>
	<table border="1">
		<tr>
			<td>���̵�</td>
			<td>${data.dd.userid }</td>
		</tr>
		<tr>
			<td>��¥</td>
			<td>${data.dd.regdate}</td>
		</tr>
	
		<tr>
			<td>����</td>
			<td>${data.dd.title }</td>
		</tr>
		<tr>
			<td>����</td>
			<td>${data.dd.content }</td>
		</tr>
		<c:choose>
			<c:when test="${data.dd.sysname eq null}">
			</c:when>
			<c:otherwise>
				<tr>
					<td>����</td>
					<td><img alt=""
						src="../../../resources/board/${data.dd.sysname }" width="200px"></td>
				</tr>
			</c:otherwise>
		</c:choose>
		<tr><td>��ȸ��</td>
		<td>${data.dd.cnt }</td>
				<tr>
			<td colspan="3" align="center"><a href="list">�������</a>
			<c:choose>
					<c:when
						test="${loginVo.grade eq 'admin'|| data.dd.userid eq loginVo.userid }">
						<a href="modify?boardid=${data.dd.boardid }">�����ϱ�</a>
						<a href="javascript:delalert()">�����ϱ�</a>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
				</td>
		</tr>
	</table>
</body>
</html>