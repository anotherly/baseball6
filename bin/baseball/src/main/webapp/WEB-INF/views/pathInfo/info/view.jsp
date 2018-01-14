
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form align="center">
	<table border="1">
		<tr>
			<td><strong>����������ȣ</strong></td>
			<td>${data.dd.playerId}</td>
		</tr>
		<tr>
			<td><strong>��ϳ⵵</strong></td>
			<td>${data.dd.year}</td>
		</tr>
		<tr>
			<td><strong>�̸�</strong></td>
			<td>${data.dd.playerName}</td>
		</tr>
		<tr>
			<td><strong>����</strong></td>
			<td>${data.dd.teamId}</td>
		</tr>
		<tr>
			<td><strong>����</strong></td>
			<td><img alt=""
				src="../../../resources/playerPhoto/${data.dd.sysFile}"
				width="150px" height="200px"></td>
		</tr>

		<tr>
			<td><strong>���ȣ</strong></td>
			<td>${data.dd.backNum}</td>
		</tr>

		<tr>
			<td><strong>������</strong></td>
			<c:choose>
				<c:when test="${data.dd.position eq 'p, pitcher, ����'}">
					<td>����</td>
				</c:when>
				<c:when test="${data.dd.position eq 'c, catcher, ����'}">
					<td>����</td>
				</c:when>
				<c:when test="${data.dd.position eq '1b, infielder, 1���'}">
					<td>1���</td>
				</c:when>
				<c:when test="${data.dd.position eq '2b, infielder, 2���'}">
					<td>2���</td>
				</c:when>
				<c:when test="${data.dd.position eq '3b, infielder, 3���'}">
					<td>3���</td>
				</c:when>
				<c:when test="${data.dd.position eq 'ss, infielder, ���ݼ�'}">
					<td>���ݼ�</td>
				</c:when>
				<c:when test="${data.dd.position eq 'lf, outfielder, ���ͼ�'}">
					<td>���ͼ�</td>
				</c:when>
				<c:when test="${data.dd.position eq 'cf, outfielder, �߰߼�'}">
					<td>�߰߼�</td>
				</c:when>
				<c:otherwise>
						<td>���ͼ�</td>
				</c:otherwise>
			</c:choose>
			
		</tr>
		<tr>
			<td><strong>�������</strong></td>
			<td>${data.dd.playerBirth}</td>
		</tr>
		<tr>
			<td><strong>��ű�</strong></td>
			<td>${data.dd.schoolName}</td>
		</tr>
		<tr>
			<td><strong>����</strong></td>
			<td>${data.dd.height}cm</td>
		</tr>
		<tr>
			<td><strong>ü��</strong></td>
			<td>${data.dd.weight}kg</td>
		</tr>
		<tr>
			<td><strong>����</strong></td>
			<td>${data.dd.country}</td>
		</tr>
		<tr>
			<td><strong>����</strong></td>
			<td>${data.dd.salary}</td>
		</tr>
		<tr>
			<td><strong>����</strong></td>
			<c:choose>
				<c:when test="${data.dd.pitchingHand eq 'r'}">
					<td>����</td>
				</c:when>
				<c:otherwise>
					<td>����</td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<td><strong>Ÿ��</strong></td>
			<c:choose>
				<c:when test="${data.dd.battingHand eq 'r'}">
					<td>��Ÿ</td>
				</c:when>
				<c:when test="${data.dd.battingHand eq 'l'}">
					<td>��Ÿ</td>
				</c:when>
				<c:otherwise>
					<td>��Ÿ</td>
				</c:otherwise>
			</c:choose>
			
		</tr>
		<tr>

			<td colspan="2" align="right"><a
				href="playerModify?playerId=${data.dd.playerId}">������������</a> <a
				href="list">����Ʈ��</a></td>
		</tr>

	</table>
</form>
</body>
</html>
