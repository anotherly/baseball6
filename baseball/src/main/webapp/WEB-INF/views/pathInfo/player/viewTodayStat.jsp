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

	<table border="" align="center">
		<tr>
			<td colspan="8" align="center"><strong>기본정보</strong></td>
			<td colspan="7" align="center"><strong>수비지표</strong></td>
			<td colspan="11" align="center"><strong>타자지표</strong></td>
			<td colspan="11" align="center"><strong>투수지표</strong></td>
		</tr>
		<tr>
			<td>NO</td>
			<td>sN</td>
			<td>gN</td>
			<td>date</td>
			<td>team</td>
			<td>pName</td>
			<td>g</td>
			<td>gs</td>
			<!-- ------------- -->
			<td>position</td>
			<td>inn</td>
			<td>tc</td>
			<td>po</td>
			<td>a</td>
			<td>e</td>
			<td>dp</td>
			<!-- 수비지표 -->
			<td>ab</td>
			<td>r</td>
			<td>h</td>
			<td>2b</td>
			<td>3b</td>
			<td>hr</td>
			<td>rbi</td>
			<td>bb</td>
			<td>so</td>
			<td>sb</td>
			<td>cs</td>
			<!-- 투수지표 -->
			<td>w</td>
			<td>l</td>
			<td>ho</td>
			<td>sv</td>
			<td>svo</td>
			<td>ip</td>
			<td>ph</td>
			<td>per</td>
			<td>phr</td>
			<td>pbb</td>
			<td>so</td>

		</tr>
		<c:forEach items="${data.dd }" var="vo" varStatus="no">
			<tr>
				<td>${no.count }</td>
				<td>${vo.statnum}</td>
				<td>${vo.game_num}</td>
				<td>${vo.year}/${vo.month}/${vo.day}</td>
				<td>${vo.teamId}</td>
				<td>${vo.playerName}</td>
				<td>${vo.g}</td>
				<td>${vo.gs}</td>

				<td>${vo.positionToday}</td>
				<td>${vo.inn}</td>
				<td>${vo.tc}</td>
				<td>${vo.po}</td>
				<td>${vo.a}</td>
				<td>${vo.e}</td>
				<td>${vo.dp}</td>

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

				<td>${vo.w}</td>
				<td>${vo.l}</td>
				<td>${vo.hold}</td>
				<td>${vo.sv}</td>
				<td>${vo.svo}</td>
				<td>${vo.ip}</td>
				<td>${vo.pitcherH}</td>
				<td>${vo.pitcherR}</td>
				<td>${vo.pitcherHr}</td>
				<td>${vo.pitcherBb}</td>
				<td>${vo.pitcherSo}</td>
			</tr>
			
		</c:forEach>
		
	
	<tr>
			<td colspan="38" align="right"><%-- <a
				href="gameResRegister">결과등록</a> <a
				href="modifyTodayStat?playerId=${vo.playerId}">선수정보수정</a> --%> 
				<a href="gameResComplete">결과반영</a>
				<a href="list">리스트로</a>
			</td>
		</tr>
	
		
	</table>

</body>
</html>