
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
			<td><strong>선수고유번호</strong></td>
			<td>${data.dd.playerId}</td>
		</tr>
		<tr>
			<td><strong>등록년도</strong></td>
			<td>${data.dd.year}</td>
		</tr>
		<tr>
			<td><strong>이름</strong></td>
			<td>${data.dd.playerName}</td>
		</tr>
		<tr>
			<td><strong>팀명</strong></td>
			<td>${data.dd.teamId}</td>
		</tr>
		<tr>
			<td><strong>사진</strong></td>
			<td><img alt=""
				src="../../../resources/playerPhoto/${data.dd.sysFile}"
				width="150px" height="200px"></td>
		</tr>

		<tr>
			<td><strong>등번호</strong></td>
			<td>${data.dd.backNum}</td>
		</tr>

		<tr>
			<td><strong>포지션</strong></td>
			<c:choose>
				<c:when test="${data.dd.position eq 'p, pitcher, 투수'}">
					<td>투수</td>
				</c:when>
				<c:when test="${data.dd.position eq 'c, catcher, 포수'}">
					<td>포수</td>
				</c:when>
				<c:when test="${data.dd.position eq '1b, infielder, 1루수'}">
					<td>1루수</td>
				</c:when>
				<c:when test="${data.dd.position eq '2b, infielder, 2루수'}">
					<td>2루수</td>
				</c:when>
				<c:when test="${data.dd.position eq '3b, infielder, 3루수'}">
					<td>3루수</td>
				</c:when>
				<c:when test="${data.dd.position eq 'ss, infielder, 유격수'}">
					<td>유격수</td>
				</c:when>
				<c:when test="${data.dd.position eq 'lf, outfielder, 좌익수'}">
					<td>좌익수</td>
				</c:when>
				<c:when test="${data.dd.position eq 'cf, outfielder, 중견수'}">
					<td>중견수</td>
				</c:when>
				<c:otherwise>
						<td>우익수</td>
				</c:otherwise>
			</c:choose>
			
		</tr>
		<tr>
			<td><strong>생년월일</strong></td>
			<td>${data.dd.playerBirth}</td>
		</tr>
		<tr>
			<td><strong>출신교</strong></td>
			<td>${data.dd.schoolName}</td>
		</tr>
		<tr>
			<td><strong>신장</strong></td>
			<td>${data.dd.height}cm</td>
		</tr>
		<tr>
			<td><strong>체중</strong></td>
			<td>${data.dd.weight}kg</td>
		</tr>
		<tr>
			<td><strong>국적</strong></td>
			<td>${data.dd.country}</td>
		</tr>
		<tr>
			<td><strong>연봉</strong></td>
			<td>${data.dd.salary}</td>
		</tr>
		<tr>
			<td><strong>투구</strong></td>
			<c:choose>
				<c:when test="${data.dd.pitchingHand eq 'r'}">
					<td>우투</td>
				</c:when>
				<c:otherwise>
					<td>좌투</td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<td><strong>타격</strong></td>
			<c:choose>
				<c:when test="${data.dd.battingHand eq 'r'}">
					<td>우타</td>
				</c:when>
				<c:when test="${data.dd.battingHand eq 'l'}">
					<td>좌타</td>
				</c:when>
				<c:otherwise>
					<td>양타</td>
				</c:otherwise>
			</c:choose>
			
		</tr>
		<tr>

			<td colspan="2" align="right"><a
				href="playerModify?playerId=${data.dd.playerId}">선수정보수정</a> <a
				href="list">리스트로</a></td>
		</tr>

	</table>
</form>
</body>
</html>
