
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<form action="" align="center">

		<table border="2">

			<tr>
				<td colspan="3" align="center"><strong>2018 KBO����</strong></td>

			</tr>


			<tr>
				<td><c:choose>
						<c:when test="${data.dd.away eq 'doosan'}">
							<img src="../../../resources/teamPhoto/emblem_OB.png">
							<br>�λ� ���<br>
						</c:when>
						<c:when test="${data.dd.away eq 'kia'}">
							<img src="../../../resources/teamPhoto/emblem_HT.png">
							<br>KIA Ÿ�̰���<br>
						</c:when>
						<c:when test="${data.dd.away eq 'lg'}">
							<img src="../../../resources/teamPhoto/emblem_LG.png">
							<br>LG Ʈ����<br>
						</c:when>
						<c:when test="${data.dd.away eq 'hanhwa'}">
							<img src="../../../resources/teamPhoto/emblem_HH.png">
							<br>��ȭ �̱۽�<br>
						</c:when>
						<c:when test="${data.dd.away eq 'lotte'}">
							<img src="../../../resources/teamPhoto/emblem_LT.png">
							<br>�Ե� ���̾���<br>
						</c:when>
						<c:when test="${data.dd.away eq 'nexen'}">
							<img src="../../../resources/teamPhoto/emblem_WO.png">
							<br>�ؼ� �������<br>
						</c:when>
						<c:when test="${data.dd.away eq 'sk'}">
							<img src="../../../resources/teamPhoto/emblem_SK.png">
							<br>SK ���̹���<br>
						</c:when>
						<c:when test="${data.dd.away eq 'kt'}">
							<img src="../../../resources/teamPhoto/emblem_KT.png">
							<br>KT ����<br>
						</c:when>
						<c:when test="${data.dd.away eq 'samsung'}">
							<img src="../../../resources/teamPhoto/emblem_SS.png">
							<br>�Ｚ ���̿���<br>
						</c:when>
						<c:when test="${data.dd.away eq 'nc'}">
							<img src="../../../resources/teamPhoto/emblem_NC.png">
							<br>NC ���̳뽺<br>
						</c:when>
					</c:choose> <strong><br></td>


				<td><strong>${data.dd.year }��${data.dd.month }��${data.dd.day }��
						${data.dd.yoil }����<br>${data.dd.stadium }<br> <c:choose>
							<c:when test="${data.dd.status eq 'on'}">
					${data.dd.game_time }
					</c:when>
							<c:when test="${data.dd.status ne 'on'}">
					��õ���
					</c:when>
						</c:choose> <br>${data.dd.channel }<br>
				</strong></td>
				<td><c:choose>
						<c:when test="${data.dd.home eq 'doosan'}">
							<img src="../../../resources/teamPhoto/emblem_OB.png">
							<br>�λ� ���<br>
						</c:when>
						<c:when test="${data.dd.home eq 'kia'}">
							<img src="../../../resources/teamPhoto/emblem_HT.png">
							<br>KIA Ÿ�̰���<br>
						</c:when>
						<c:when test="${data.dd.home eq 'lg'}">
							<img src="../../../resources/teamPhoto/emblem_LG.png">
							<br>LG Ʈ����<br>
						</c:when>
						<c:when test="${data.dd.home eq 'hanhwa'}">
							<img src="../../../resources/teamPhoto/emblem_HH.png">
							<br>��ȭ �̱۽�<br>
						</c:when>
						<c:when test="${data.dd.home eq 'lotte'}">
							<img src="../../../resources/teamPhoto/emblem_LT.png">
							<br>�Ե� ���̾���<br>
						</c:when>
						<c:when test="${data.dd.home eq 'nexen'}">
							<img src="../../../resources/teamPhoto/emblem_WO.png">
							<br>�ؼ� �������<br>
						</c:when>
						<c:when test="${data.dd.home eq 'sk'}">
							<img src="../../../resources/teamPhoto/emblem_SK.png">
							<br>SK ���̹���<br>
						</c:when>
						<c:when test="${data.dd.home eq 'kt'}">
							<img src="../../../resources/teamPhoto/emblem_KT.png">
							<br>KT ����<br>
						</c:when>
						<c:when test="${data.dd.home eq 'samsung'}">
							<img src="../../../resources/teamPhoto/emblem_SS.png">
							<br>�Ｚ ���̿���<br>
						</c:when>
						<c:when test="${data.dd.home eq 'nc'}">
							<img src="../../../resources/teamPhoto/emblem_NC.png">
							<br>NC ���̳뽺<br>
						</c:when>
					</c:choose> <br></td>
			</tr>
			<tr>

				<td><strong> <c:choose>
							<c:when test="${data.dd4.w eq 1 }">

								<br>�¸����� : ${data.dd4.playerName }
				
				</c:when>
							<c:when test=" ${data.dd4.l eq 1 }">

								<br>�������� : ${data.dd4.playerName }
				
				</c:when>
							<c:when test=" ${data.dd4.hold eq 1 }">

								<br>Ȧ�� : ${data.dd4.playerName }
				
				</c:when>
							<c:when test=" ${data.dd4.sv eq 1 }">

								<br>���̺� : ${data.dd4.playerName }
				
				</c:when>
						</c:choose></strong></td>
				<td><strong>${data.dd3.r }
				<c:choose>
				<c:when test="${data.dd3.r ne null}">
				:
				</c:when>
				<c:otherwise>
				�����
				</c:otherwise>
				</c:choose>
				${data.dd2.r }</strong></td>
				<td><strong> <c:choose>
							<c:when test="${data.dd5.w eq 1 }">
								<strong> �¸����� : ${data.dd5.playerName } </strong>
							</c:when>
							<c:when test=" ${data.dd5.l eq 1 }">
								<strong> �������� : ${data.dd5.playerName } </strong>
							</c:when>
							<c:when test=" ${data.dd5.sv eq 1 }">
								<strong> ���̺� : ${data.dd5.playerName } </strong>
							</c:when>
							<c:when test=" ${data.dd5.hold eq 1 }">
								<strong> Ȧ�� : ${data.dd5.playerName } </strong>
							</c:when>
						</c:choose>




				</strong></td>
			</tr>
			<tr>
				<td>${data.dd3.h }</td>
				<td><strong>��Ÿ</strong></td>
				<td>${data.dd2.h }</td>
			</tr>
			<tr>
				<td>${data.dd3.hr }</td>
				<td><strong>Ȩ��</strong></td>
				<td>${data.dd2.hr }</td>
			</tr>
			<tr>
				<td>${data.dd3.sb }</td>
				<td><strong>����</strong></td>
				<td>${data.dd2.sb }</td>
			</tr>
			<tr>
				<td>${data.dd3.so }</td>
				<td><strong>����</strong></td>
				<td>${data.dd2.so }</td>
			</tr>
			<tr>
				<td>${data.dd3.dp }</td>
				<td><strong>����</strong></td>
				<td>${data.dd2.dp }</td>
			</tr>
			<tr>
				<td>${data.dd3.e }</td>
				<td><strong>��å</strong></td>
				<td>${data.dd2.e }</td>
			</tr>

		</table>
	</form>


</body>
</html>