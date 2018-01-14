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
	<form action="bList" method="post">
		<table border="" bordercolor="silver">
			<tr>
				<td colspan="3"
				style="border-right: 0.1px solid #FFFFFF; border-left: 0.1px solid #FFFFFF; border-top: 0.1px solid #FFFFFF;"
				><select name="year">
						<option value="2018">2018</option>
						<option value="2017">2017</option>
						<option value="2016">2016</option>
				</select> <!-- 	<select name="month">
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
				<td colspan="19" align="center"
				style="border-right: 0.1px solid #FFFFFF;
							border-top: 0.1px solid #FFFFFF;"
				><strong><span
						style="font-size: 2em; color: green;">시즌별 타격기록</span></strong></td>
			</tr>



			<tr>
				<td>년</td>

				<td>팀</td>
				<td>선수이름</td>
				<td>포지션</td>
				<td>경기</td>
				<td>선발</td>
				<td>타석</td>
				<td>득점</td>
				<td>안타</td>
				<td>2<br>루<br>타</td>
				<td>3<br>루<br>타</td>
				<td>홈런</td>
				<td>타점</td>
				<td>볼넷</td>
				<td>삼진</td>
				<td>도루</td>
				<td>도실</td>
				<td>타율</td>
				<td>출루율</td>
				<td>장타율</td>
				<td>OPS</td>


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


					<td><a href="../../info/notice/view?playerId=${vo.playerId}">${vo.playerName}</a></td>
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
					<td>${vo.ab}</td>
					<td>${vo.r}</td>
					<td>${vo.h}</td>
					<td>${vo.twoBase}</td>
					<td>${vo.thirdBase}</td>
					<td>${vo.hr}</td>
					<td>${vo.rbi}</td>
					<td>${vo.bb}</td>
					<td>${vo.so}</td>
					<td>${vo.sb}</td>
					<td>${vo.cs}</td>
					<td>${vo.avg}</td>
					<td>${vo.obp}</td>
					<td>${vo.slg}</td>
					<td>${vo.ops}</td>
				</tr>
			</c:forEach>

		</table>
</body>
</html>