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
							style="font-size: 2em; color: green;">��ϼ�������</span></strong></td>
					<td colspan="12"
					style="border-right: 0.1px solid #FFFFFF; border-left: 0.1px solid #FFFFFF;
							border-top: 0.1px solid #FFFFFF;">
						<!-- ����Ʈ�������� --> <select name="list[${i }].kind">
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
						value="${list.get(i).what}" /> <input type="submit" value="�˻�" />
						<a href="list">�ʱ�ȭ</a>
					</td>

				</tr>
			</c:forEach>





		</form>



		<tr>
			<td>��ȣ</td>
			<td>�����̸�</td>
			<td>�Ҽ���</td>
			<td>������</td>
			<td>��</td>
			<td>Ÿ</td>
			<td>����</td>
			<td>�������</td>
			<!-- <td>��ȸ��</td> -->
		</tr>
		<c:forEach items="${data.dd }" var="vo" varStatus="no">
			<tr>
				<td>${no.count }</td>
				<td>
					<%-- <c:forEach begin="1" end="${vo.lev }">
				&nbsp;&nbsp;
			</c:forEach>
			<c:if test="${vo.lev>0 }">
				��
			</c:if> --%> <a href="view?playerId=${vo.playerId }">${vo.playerName}</a>
					<%-- view?playerId=${vo.playerId } --%>
				</td>
				<td><c:choose>
						<c:when test="${vo.teamId eq 'doosan'}">
								
								�λ� ���</c:when>
						<c:when test="${vo.teamId eq 'kia'}">
								KIA Ÿ�̰���
							</c:when>
						<c:when test="${vo.teamId eq 'lg'}">
								LG Ʈ����
								</c:when>
						<c:when test="${vo.teamId eq 'hanhwa'}">
								��ȭ �̱۽�
								</c:when>
						<c:when test="${vo.teamId eq 'lotte'}">
								�Ե� ���̾���
								</c:when>
						<c:when test="${vo.teamId eq 'nexen'}">
								�ؼ� �������
								</c:when>
						<c:when test="${vo.teamId eq 'sk'}">
								SK ���̹���
								</c:when>
						<c:when test="${vo.teamId eq 'kt'}">
								KT ����
								</c:when>
						<c:when test="${vo.teamId eq 'samsung'}">
								�Ｚ ���̿���
								</c:when>
						<c:when test="${vo.teamId eq 'nc'}">
								NC ���̳뽺
								</c:when>
					</c:choose></td>
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



				<td><c:choose>
						<c:when test="${vo.pitchingHand eq 'r'}">
								
								����</c:when>
						<c:when test="${vo.pitchingHand eq 'l'}">
								��Ÿ
							</c:when>

					</c:choose></td>
				<td><c:choose>
						<c:when test="${vo.battingHand eq 'r'}">
								
								��Ÿ</c:when>
						<c:when test="${vo.battingHand eq 'l'}">
								��Ÿ
							</c:when>
						<c:when test="${vo.battingHand eq 'b'}">
								��Ÿ
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
					<td colspan="10" align="right"><a href="playerRegister">�������</a></td>
				</c:when>
			</c:choose>
		</tr>
	</table>
</body>
</html>