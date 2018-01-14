<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1 bordercolor="silver">
		<form action="list" method="post">
			<c:forEach begin="0" end="0" var="i">
				<tr>
					<td colspan="7" align="center"
					style="border-right: 0.1px solid #FFFFFF; border-left: 0.1px solid #FFFFFF;
							border-top: 0.1px solid #FFFFFF;"
					><strong><span
							style="font-size: 2em; color: green;">등록선수정보</span></strong></td>
					<td colspan="12"
					style="border-right: 0.1px solid #FFFFFF; border-left: 0.1px solid #FFFFFF;
							border-top: 0.1px solid #FFFFFF;">
						<!-- 셀렉트밸류만들기 --> <select name="list[${i }].kind">
							<c:forEach items="${kindArr }" var="kk">
								<c:choose>
									<c:when test="${kk[0]==list.get(i).kind }">
										<option value="${kk[0] }" selected="selected">${kk[1] }</option>
									</c:when>
									<c:otherwise>
										<option value="${kk[0] }">${kk[1] }</option>
									</c:otherwise>
								</c:choose>

							</c:forEach>
					</select> <input type="text" name="list[${i }].what"
						value="${list.get(i).what}" /> <input type="submit" value="검색" />
						<a href="list">초기화</a>
					</td>

				</tr>
			</c:forEach>





		</form>



		<tr>
			<td>번호</td>
			<td>선수이름</td>
			<td>소속팀</td>
			<td>포지션</td>
			<td>투</td>
			<td>타</td>
			<td>연봉</td>
			<td>생년월일</td>
			<!-- <td>조회수</td> -->
		</tr>
		<c:forEach items="${data.dd }" var="vo" varStatus="no">
			<tr>
				<td>${no.count }</td>
				<td>
					<%-- <c:forEach begin="1" end="${vo.lev }">
				&nbsp;&nbsp;
			</c:forEach>
			<c:if test="${vo.lev>0 }">
				└
			</c:if> --%> <a href="view?playerId=${vo.playerId }">${vo.playerName}</a>
					<%-- view?playerId=${vo.playerId } --%>
				</td>
				<td><c:choose>
						<c:when test="${vo.teamId eq 'doosan'}">
								
								두산 베어스</c:when>
						<c:when test="${vo.teamId eq 'kia'}">
								KIA 타이거즈
							</c:when>
						<c:when test="${vo.teamId eq 'lg'}">
								LG 트윈스
								</c:when>
						<c:when test="${vo.teamId eq 'hanhwa'}">
								한화 이글스
								</c:when>
						<c:when test="${vo.teamId eq 'lotte'}">
								롯데 자이언츠
								</c:when>
						<c:when test="${vo.teamId eq 'nexen'}">
								넥센 히어로즈
								</c:when>
						<c:when test="${vo.teamId eq 'sk'}">
								SK 와이번스
								</c:when>
						<c:when test="${vo.teamId eq 'kt'}">
								KT 위즈
								</c:when>
						<c:when test="${vo.teamId eq 'samsung'}">
								삼성 라이온즈
								</c:when>
						<c:when test="${vo.teamId eq 'nc'}">
								NC 다이노스
								</c:when>
					</c:choose></td>
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



				<td><c:choose>
						<c:when test="${vo.pitchingHand eq 'r'}">
								
								우투</c:when>
						<c:when test="${vo.pitchingHand eq 'l'}">
								좌타
							</c:when>

					</c:choose></td>
				<td><c:choose>
						<c:when test="${vo.battingHand eq 'r'}">
								
								우타</c:when>
						<c:when test="${vo.battingHand eq 'l'}">
								좌타
							</c:when>
						<c:when test="${vo.battingHand eq 'b'}">
								양타
								</c:when>
					</c:choose></td>
				<td>${vo.salary }</td>
				<td>${vo.playerBirth }</td>
				<%-- <td>${vo.regDate }</td> --%>
				<%-- <td>${vo.cnt }</td> --%>
			</tr>
		</c:forEach>

		<tr>
			<c:choose>
				<c:when test="${loginVo.grade eq 'admin' }">
					<td colspan="10" align="right"><a href="playerRegister">선수등록</a></td>
				</c:when>
			</c:choose>
		</tr>
	</table>
</body>
</html>