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
<form action="dList" method="post">
		<table border="">
			<tr>
				<td colspan="2">
					<select name="year">
						<option value="2018">2018</option>
						<option value="2017">2017</option>
						<option value="2016">2016</option>
					</select>
					<!-- <select name="month">
						<option value="1" selected="selected">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						
				</select> --> <input type="submit" value="검색"></td>
				<td colspan="16" align="center"><strong><span
						style="font-size: 2em; color: green;">시즌별 수비기록</span></strong></td>
			</tr>
			
			
	
		<tr>
			<td>년</td>
			
			<td>팀</td>
			<td>선수이름</td>
			<td>포지션</td>
			<td>경기</td>
			<td>선발</td>
			<td>이닝</td>
			<td>총수비기회</td>
			<td>자살</td>
			<td>보살</td>
			<td>실책</td>
			<td>병살</td>
			<td>수비율</td>
			
		</tr>

		 <c:forEach items="${data.dd }" var="vo">
			<tr>

				<td>${vo.year}</td>
				
				<td><c:choose>
							<c:when test="${vo.teamId eq 'doosan'}">
								
								두산</c:when>
							<c:when test="${vo.teamId eq 'kia'}">
								KIA
							</c:when>
							<c:when test="${vo.teamId eq 'lg'}">
								LG
								</c:when>
							<c:when test="${vo.teamId eq 'hanhwa'}">
								한화
								</c:when>
							<c:when test="${vo.teamId eq 'lotte'}">
								롯데
								</c:when>
							<c:when test="${vo.teamId eq 'nexen'}">
								넥센
								</c:when>
							<c:when test="${vo.teamId eq 'sk'}">
								SK
								</c:when>
							<c:when test="${vo.teamId eq 'kt'}">
								KT
								</c:when>
							<c:when test="${vo.teamId eq 'samsung'}">
								삼성
								</c:when>
							<c:when test="${vo.teamId eq 'nc'}">
								NC
								</c:when>
						</c:choose></td>
				<td><a href="view?playerId=${vo.playerId}">${vo.playerName}</a></td>
				<td><c:choose>
							<c:when test="${vo.position eq 'p, pitcher'}">
								
								투수</c:when>
							<c:when test="${vo.position eq 'c, catcher'}">
								포수
							</c:when>
							<c:when test="${vo.position eq '1b, infielder'}">
								1루수
								</c:when>
							<c:when test="${vo.position eq '2b, infielder'}">
								2루수
								</c:when>
							<c:when test="${vo.position eq '3b, infielder'}">
								3루수
								</c:when>
							<c:when test="${vo.position eq 'ss, infielder'}">
								유격수
								</c:when>
							<c:when test="${vo.position eq 'lf, outfielder'}">
								좌익수
								</c:when>
							<c:when test="${vo.position eq 'cf, outfielder'}">
								중견수
								</c:when>
							<c:when test="${vo.position eq 'rf, outfielder'}">
								우익수
								</c:when>
							
						</c:choose></td>
				<td>${vo.g}</td>
				<td>${vo.gs}</td>
				<td>${vo.inn}</td>
				<td>${vo.tc}</td>
				<td>${vo.po}</td>
				<td>${vo.a}</td>
				<td>${vo.e}</td>
				<td>${vo.dp}</td>
				<td>${vo.fpct}</td>
			
				
			
			</tr>
		</c:forEach>

	</table>

</body>
</html>