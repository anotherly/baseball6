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
						
				</select> --> <input type="submit" value="�˻�"></td>
				<td colspan="16" align="center"><strong><span
						style="font-size: 2em; color: green;">���� ������</span></strong></td>
			</tr>
			
			
	
		<tr>
			<td>��</td>
			
			<td>��</td>
			<td>�����̸�</td>
			<td>������</td>
			<td>���</td>
			<td>����</td>
			<td>�̴�</td>
			<td>�Ѽ����ȸ</td>
			<td>�ڻ�</td>
			<td>����</td>
			<td>��å</td>
			<td>����</td>
			<td>������</td>
			
		</tr>

		 <c:forEach items="${data.dd }" var="vo">
			<tr>

				<td>${vo.year}</td>
				
				<td><c:choose>
							<c:when test="${vo.teamId eq 'doosan'}">
								
								�λ�</c:when>
							<c:when test="${vo.teamId eq 'kia'}">
								KIA
							</c:when>
							<c:when test="${vo.teamId eq 'lg'}">
								LG
								</c:when>
							<c:when test="${vo.teamId eq 'hanhwa'}">
								��ȭ
								</c:when>
							<c:when test="${vo.teamId eq 'lotte'}">
								�Ե�
								</c:when>
							<c:when test="${vo.teamId eq 'nexen'}">
								�ؼ�
								</c:when>
							<c:when test="${vo.teamId eq 'sk'}">
								SK
								</c:when>
							<c:when test="${vo.teamId eq 'kt'}">
								KT
								</c:when>
							<c:when test="${vo.teamId eq 'samsung'}">
								�Ｚ
								</c:when>
							<c:when test="${vo.teamId eq 'nc'}">
								NC
								</c:when>
						</c:choose></td>
				<td><a href="view?playerId=${vo.playerId}">${vo.playerName}</a></td>
				<td><c:choose>
							<c:when test="${vo.position eq 'p, pitcher'}">
								
								����</c:when>
							<c:when test="${vo.position eq 'c, catcher'}">
								����
							</c:when>
							<c:when test="${vo.position eq '1b, infielder'}">
								1���
								</c:when>
							<c:when test="${vo.position eq '2b, infielder'}">
								2���
								</c:when>
							<c:when test="${vo.position eq '3b, infielder'}">
								3���
								</c:when>
							<c:when test="${vo.position eq 'ss, infielder'}">
								���ݼ�
								</c:when>
							<c:when test="${vo.position eq 'lf, outfielder'}">
								���ͼ�
								</c:when>
							<c:when test="${vo.position eq 'cf, outfielder'}">
								�߰߼�
								</c:when>
							<c:when test="${vo.position eq 'rf, outfielder'}">
								���ͼ�
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