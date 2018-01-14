<%@page import="baseball.schedule.model.ScheduleDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<%
	ScheduleDao awayBean = new ScheduleDao();
	ArrayList awayList = new ArrayList();
	ArrayList homeList = new ArrayList();
	ArrayList stadiumList = new ArrayList();
	awayList = awayBean.getaway(request);
	homeList = awayBean.gethome(request);
	stadiumList = awayBean.getstadium(request);
%>

<%-- <%=awayBean.getgameNum(request)%> --%>
<%-- <%=awayBean.getawayState(request)%>
<%=awayBean.gethomeState(request)%>
<%=awayBean.getstadiumState(request)%>
<%=awayBean.getstadiumState1(request)%>
<%=awayBean.getstadiumState2(request)%> --%>
<script type="text/javascript">
	function reLoading(key) {
		if (key == "away") {
			var set1 = document.getElementsByName("home");
			var set2 = document.getElementsByName("stadium");
			set1[0].selectedIndex = 0;
			set2[0].selectedIndex = 0;
		}
		var res = document.gameRegister.stadium.options[gameRegister.stadium.selectedIndex].value;
		var abc = "?game_num=" + res.replace(/[^0-9]/g, "");
		var res1 = document.gameRegister.game_num.value;
		var abc1 = "?game_num=" + res1;

		document.gameRegister.action = "gameRegister" + abc1
		document.gameRegister.submit();
	}

	var monthtext = [ '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11',
			'12' ];
	function populatedropdown(yearfield, monthfield, dayfield) {
		var today = new Date()
		var dayfield = document.getElementById(dayfield)
		var monthfield = document.getElementById(monthfield)
		var yearfield = document.getElementById(yearfield)
		for (var i = 0; i < 31; i++)
			dayfield.options[i] = new Option(i + 1, i + 1)
		dayfield.options[today.getDate()] = new Option(today.getDate(), today
				.getDate(), true, true) //select today's day
		for (var m = 0; m < 12; m++)
			monthfield.options[m] = new Option(monthtext[m], monthtext[m])
		monthfield.options[today.getMonth()] = new Option(monthtext[today
				.getMonth()], monthtext[today.getMonth()], true, true) //select today's month
		var thisyear = today.getFullYear()
		for (var y = 0; y < 20; y++) {
			yearfield.options[y] = new Option(thisyear, thisyear)
			thisyear += 1
		}
		yearfield.options[0] = new Option(today.getFullYear(), today
				.getFullYear(), true, true) //select today's year
	}
</script>
</head>
<body>

	<form action="gameRegisterDetail" method="post" id="gameRegister"
		name="gameRegister">
		<table border="2" align="center">
			<tr>
				<td>경기번호</td>
				<td>
					<%-- <input type="text" value="<%=awayBean.getgameNum(request)%>"> --%>
					<input type="hidden" name="game_num"
					value="<%=awayBean.getgameNum(request)%>" /><%=awayBean.getgameNum(request)%></td>
			</tr>


			<tr>
				<td colspan="2" align="center"><select id="away" name="away"
					onchange="javascript:reLoading('away')">
						<option value="">==원정팀선택==</option>
						<%
							for (int i = 0; i < awayList.size(); i++) {
						%>
						<option value="<%=awayList.get(i)%>"
							<%if (awayList.get(i).equals(awayBean.getawayState(request))) {
					out.print("selected");
				}%>>
							<%=awayList.get(i)%></option>
						<%
							}
						%>
				</select> <select name="home" onchange="javascript:reLoading('home')">
						<option value="">==홈팀선택==</option>
						<%
							for (int i = 0; i < homeList.size(); i++) {
						%>
						<option value="<%=homeList.get(i)%>"
							<%if (homeList.get(i).equals(awayBean.gethomeState(request))) {
					out.print("selected");
				}%>><%=homeList.get(i)%></option>
						<%
							}
						%>
				</select> <select name="stadium" id="stadium"
					onchange="javascript:reLoading('stadium')">
						<!-- id="stadium"  -->
						<option value="">==구장선택==</option>
						<%
							for (int i = 0; i < stadiumList.size(); i++) {
						%>
						<option value="<%=stadiumList.get(i)%>"
							<%if (stadiumList.get(i).equals(awayBean.getstadiumState(request))) {
					out.print("selected");
				}%>><%=stadiumList.get(i)%></option>

						<%
							}
						%>
				</select> <%-- <c:forEach items="${data.dd2 }" var="vo">
		<input type="hidden" name="game_num" value="${vo.game_num }"></c:forEach>
				</select>  --%> <%--  <input type="hidden" name="game_num" value="${ }"> --%>
					<%--<input type="hidden" name="playerName" value="<%=awayBean.getstadiumState2(request)%>"> --%>
				</td>
			</tr>

			<tr>
				<td colspan="2" align="center"><select id="year" name="year"></select>
					<select id="month" name="month"></select> <select id="day"
					name="day"></select><select name="yoil" id="yoil">

						
						<option selected="selected" value="화">화</option>
						<option value="수">수</option>
						<option value="목">목</option>
						<option value="금">금</option>
						<option value="토">토</option>
						<option value="일">일</option>

				</select></td></tr>
			<tr>
				<td>중계방송사</td>
				<td><select name="channel" id="channel">

						<option selected="selected" value="KBS">KBS</option>
						<option value="SBS">SBS</option>
						<option value="MBC">MBC</option>


				</select></td>
			</tr>
			<tr>
				<td>경기시간</td>
				<td><select name="game_time" id="game_time">

						<option selected="selected" value="14:00">14:00</option>
						<option value="16:00">16:00</option>
						<option value="18:00">18:00</option>

				</select></td>
			</tr>
			<tr>
				<td>경기상태</td>
				<td><select name="status" id="status">

						<option selected="selected" value="on">정상</option>
						<option value="raincancel">우천취소</option>
						<option value="calledgame">강우콜드</option>

				</select></td>
			</tr>


			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="입력" />
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		window.onload = function() {
			populatedropdown("year", "month", "day")
		}
	</script>

</body>
</html>