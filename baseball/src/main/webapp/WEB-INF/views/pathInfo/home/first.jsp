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
	<form action="" border=1 bordercolor="white">

		<table align="center" >
			<tr align="left">
				<!-- ����������� -->
				<td colspan="2" >
					<table width=100% height=100% border=2 cellspacing=0 align="center" bordercolor="silver">
						<tr>

							<td colspan="2" align="center"
							style="border-right: 0.1px solid #FFFFFF; border-left: 0.1px solid #FFFFFF;
							border-top: 0.1px solid #FFFFFF;"
							><strong><span style="font-size: 16pt"> 
							�����</span></strong></td>
						</tr>

						<tr>
							<c:set var="tic" value="${ticketOk}" />
							<%-- <c:set var="tic2" value="${data.dd4}" /> --%>

							<!-- ��¥ -->
							<td colspan="1" align="center"
							style="border-right: 0.1px solid #FFFFFF; border-left: 0.1px solid #FFFFFF;"
							><span style="font-size: 13pt">${tic[1]}</span></td>
						</tr>


						<c:forEach items="${data.home10 }" var="vo">


							<c:choose>
								<c:when test="${tic[4] eq vo.year && tic[5] eq vo.month && tic[7] eq vo.day}">
									<tr>

										<td align="center">
											<c:choose>
													<c:when test="${vo.away eq 'doosan'}">
														<img src="../../../resources/teamPhoto/emblem_OB.png">
														�λ� ���</c:when>
													<c:when test="${vo.away eq 'kia'}">
														<img src="../../../resources/teamPhoto/emblem_HT.png">
														KIA Ÿ�̰���</c:when>
													<c:when test="${vo.away eq 'lg'}">
														<img src="../../../resources/teamPhoto/emblem_LG.png">
														LG Ʈ����</c:when>
													<c:when test="${vo.away eq 'hanhwa'}">
														<img src="../../../resources/teamPhoto/emblem_HH.png">
														��ȭ �̱۽�</c:when>
													<c:when test="${vo.away eq 'lotte'}">
														<img src="../../../resources/teamPhoto/emblem_LT.png">
														�Ե� ���̾���</c:when>
													<c:when test="${vo.away eq 'nexen'}">
														<img src="../../../resources/teamPhoto/emblem_WO.png">
														�ؼ� �������</c:when>
													<c:when test="${vo.away eq 'sk'}">
														<img src="../../../resources/teamPhoto/emblem_SK.png">
														SK ���̹���</c:when>
													<c:when test="${vo.away eq 'kt'}">
														<img src="../../../resources/teamPhoto/emblem_KT.png">
														KT ����</c:when>
													<c:when test="${vo.away eq 'samsung'}">
														<img src="../../../resources/teamPhoto/emblem_SS.png">
														�Ｚ ���̿���</c:when>
													<c:when test="${vo.away eq 'nc'}">
														<img src="../../../resources/teamPhoto/emblem_NC.png">
														NC ���̳뽺</c:when>
												</c:choose>
										
										vs
										
										
										<c:choose>
													<c:when test="${vo.home eq 'doosan'}">
														�λ� ���<img src="../../../resources/teamPhoto/emblem_OB.png">
														</c:when>
													<c:when test="${vo.home eq 'kia'}">
														KIA Ÿ�̰���<img src="../../../resources/teamPhoto/emblem_HT.png">
														</c:when>
													<c:when test="${vo.home eq 'lg'}">
														LG Ʈ����<img src="../../../resources/teamPhoto/emblem_LG.png">
														</c:when>
													<c:when test="${vo.home eq 'hanhwa'}">
														��ȭ �̱۽�<img src="../../../resources/teamPhoto/emblem_HH.png">
														</c:when>
													<c:when test="${vo.home eq 'lotte'}">
														�Ե� ���̾���<img src="../../../resources/teamPhoto/emblem_LT.png">
														</c:when>
													<c:when test="${vo.home eq 'nexen'}">
														�ؼ� �������<img src="../../../resources/teamPhoto/emblem_WO.png">
														</c:when>
													<c:when test="${vo.home eq 'sk'}">
														SK ���̹���<img src="../../../resources/teamPhoto/emblem_SK.png">
														</c:when>
													<c:when test="${vo.home eq 'kt'}">
														KT ����<img src="../../../resources/teamPhoto/emblem_KT.png">
														</c:when>
													<c:when test="${vo.home eq 'samsung'}">
														�Ｚ ���̿���<img src="../../../resources/teamPhoto/emblem_SS.png">
														</c:when>
													<c:when test="${vo.home eq 'nc'}">
														NC ���̳뽺<img src="../../../resources/teamPhoto/emblem_NC.png">
														</c:when>
												</c:choose>
												<br>
												<a
											href="../../../pathInfo/schedule/notice/gameRegisterView?game_num=${vo.game_num}&home=${vo.home }&away=${vo.away }">�����</a></td>
									</tr>
									<tr>

										<td align="center">
										<c:choose>
							<c:when test="${vo.stadium eq 'doosan ��Ǿ߱���'}">
					��Ǿ߱���
					</c:when>
							<c:when test="${vo.stadium eq 'kia ���ֱ��è�Ǿ��ʵ�'}">
					����-��� è�Ǿ��ʵ�
					</c:when>
							<c:when test="${vo.stadium eq 'lg ��Ǿ߱���'}">
					��Ǿ߱���
					</c:when>
							<c:when test="${vo.stadium eq 'nc ����߱���'}">
					����߱���
					</c:when>
							<c:when test="${vo.stadium eq 'sk ��õ���о߱���'}">
					��õ���� �ູ�帲�߱���
					</c:when>
							<c:when test="${vo.stadium eq 'kt �����߱���'}">
					KT������ũ
					</c:when>
							<c:when test="${vo.stadium eq 'nexen ��ô��ī�̵�'}">
					��ô��ī�̵�
					</c:when>
							<c:when test="${vo.stadium eq 'hanhwa �����ѹ�߱���'}">
					��ȭ���� �̱۽���ũ
					</c:when>
							<c:when test="${vo.stadium eq 'samsung ���̿�����ũ'}">
					���̿��� ��ũ
					</c:when>
							<c:when test="${vo.stadium eq 'lotte �����߱���'}">
					�����߱���
					</c:when>

						</c:choose>
										
										
										
										${vo.home_r}${vo.away_r}
										</td>
									</tr>
									
								</c:when>

							</c:choose>



						</c:forEach>

					</table>
				</td>


				<!-- ������������ -->

				<td width="50%">
					<table width="50" height=100% border=2 cellspacing=0 bordercolor="silver">
						<tr>

							<td colspan="3" align="center"
							style="border-right: 0.1px solid #FFFFFF; border-left: 0.1px solid #FFFFFF;
							border-top: 0.1px solid #FFFFFF;"
							><strong><span style="font-size: 16pt"> 
							�������</span></strong></td>

						</tr>

						<c:set var="tic" value="${ticketOk}" />

						<c:forEach items="${data.home9 }" var="vo">
							<tr>



								<c:choose>

									<c:when test="${tic[4] eq vo.year && tic[5] eq vo.month && tic[6] eq vo.day}">

										<tr>
											<!-- ��¥ -->
											<td colspan="3" align="center"
											style="border-right: 0.1px solid #FFFFFF; border-left: 0.1px solid #FFFFFF;"
											>${vo.month}��${vo.day}��
												${vo.yoil}����</td>
										</tr>
										<tr>
											<td colspan="3" align="center">${vo.channel}</td>
										</tr>
										<tr>
											<td rowspan="2" align="center"><c:choose>
													<c:when test="${vo.away eq 'doosan'}">
														<img src="../../../resources/teamPhoto/emblem_OB.png">
														<br>�λ� ���</c:when>
													<c:when test="${vo.away eq 'kia'}">
														<img src="../../../resources/teamPhoto/emblem_HT.png">
														<br>KIA Ÿ�̰���</c:when>
													<c:when test="${vo.away eq 'lg'}">
														<img src="../../../resources/teamPhoto/emblem_LG.png">
														<br>LG Ʈ����</c:when>
													<c:when test="${vo.away eq 'hanhwa'}">
														<img src="../../../resources/teamPhoto/emblem_HH.png">
														<br>��ȭ �̱۽�</c:when>
													<c:when test="${vo.away eq 'lotte'}">
														<img src="../../../resources/teamPhoto/emblem_LT.png">
														<br>�Ե� ���̾���</c:when>
													<c:when test="${vo.away eq 'nexen'}">
														<img src="../../../resources/teamPhoto/emblem_WO.png">
														<br>�ؼ� �������</c:when>
													<c:when test="${vo.away eq 'sk'}">
														<img src="../../../resources/teamPhoto/emblem_SK.png">
														<br>SK ���̹���</c:when>
													<c:when test="${vo.away eq 'kt'}">
														<img src="../../../resources/teamPhoto/emblem_KT.png">
														<br>KT ����</c:when>
													<c:when test="${vo.away eq 'samsung'}">
														<img src="../../../resources/teamPhoto/emblem_SS.png">
														<br>�Ｚ ���̿���</c:when>
													<c:when test="${vo.away eq 'nc'}">
														<img src="../../../resources/teamPhoto/emblem_NC.png">
														<br>NC ���̳뽺</c:when>
												</c:choose></td>
											<td colspan="1" align="center"><a
												href="../../../test/list?home=${vo.home }&away=${vo.away }&year=${vo.year }&month=${vo.month }&day=${vo.day }&game_time=${vo.game_time }">������</a></td>
											<td rowspan="2" align="center"><c:choose>
													<c:when test="${vo.home eq 'doosan'}">
														<img src="../../../resources/teamPhoto/emblem_OB.png">
														<br>�λ� ���</c:when>
													<c:when test="${vo.home eq 'kia'}">
														<img src="../../../resources/teamPhoto/emblem_HT.png">
														<br>KIA Ÿ�̰���</c:when>
													<c:when test="${vo.home eq 'lg'}">
														<img src="../../../resources/teamPhoto/emblem_LG.png">
														<br>LG Ʈ����</c:when>
													<c:when test="${vo.home eq 'hanhwa'}">
														<img src="../../../resources/teamPhoto/emblem_HH.png">
														<br>��ȭ �̱۽�</c:when>
													<c:when test="${vo.home eq 'lotte'}">
														<img src="../../../resources/teamPhoto/emblem_LT.png">
														<br>�Ե� ���̾���</c:when>
													<c:when test="${vo.home eq 'nexen'}">
														<img src="../../../resources/teamPhoto/emblem_WO.png">
														<br>�ؼ� �������</c:when>
													<c:when test="${vo.home eq 'sk'}">
														<img src="../../../resources/teamPhoto/emblem_SK.png">
														<br>SK ���̹���</c:when>
													<c:when test="${vo.home eq 'kt'}">
														<img src="../../../resources/teamPhoto/emblem_KT.png">
														<br>KT ����</c:when>
													<c:when test="${vo.home eq 'samsung'}">
														<img src="../../../resources/teamPhoto/emblem_SS.png">
														<br>�Ｚ ���̿���</c:when>
													<c:when test="${vo.home eq 'nc'}">
														<img src="../../../resources/teamPhoto/emblem_NC.png">
														<br>NC ���̳뽺</c:when>
												</c:choose></td>
										</tr>
										<tr>

											<td colspan="1" align="center">${vo.stadium}<br>${vo.game_time}</td>

										</tr>

									</c:when>

								</c:choose>

							</tr>

						</c:forEach>

					</table>
				</td>
			</tr>


			<!-- Ÿ��top3������ -->

			<tr>
				<td align="right" align="center">
					<table width=100% height=100% border=2 cellspacing=0 align="center" bordercolor="silver">
						<tr>
							<td colspan="2" align="center"
							style="border-right: 0.1px solid #FFFFFF; border-left: 0.1px solid #FFFFFF;
							border-top: 0.1px solid #FFFFFF;"
							><strong><span style="font-size: 15pt"> 
							Ÿ��TOP3</span></strong></td>
						</tr>

						<tr>
							<td colspan="2" align="center">Ÿ��</td>
						</tr>
						<c:forEach items="${data.home2 }" var="vo" varStatus="no">
							<tr>
								<td align="center">${vo.playerName }</td>
								<td align="center">${vo.avg }</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="2" align="center">Ȩ��</td>
						</tr>
						<c:forEach items="${data.home4 }" var="vo" varStatus="no">
							<tr>
								<td align="center">${vo.playerName }</td>
								<td align="center">${vo.hr }</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="2" align="center">Ÿ��</td>
						</tr>
						<c:forEach items="${data.home6 }" var="vo" varStatus="no">
							<tr>
								<td align="center">${vo.playerName }</td>
								<td align="center">${vo.rbi }</td>
							</tr>

						</c:forEach>

					</table>
				</td>

				<!-- ����top3������ -->

				<td align="center">
					<table width=100% height=100% border=2 cellspacing=0 bordercolor="silver">
						<tr>
							<td colspan="2" align="center"
							style="border-right: 0.1px solid #FFFFFF; border-left: 0.1px solid #FFFFFF;
							border-top: 0.1px solid #FFFFFF;"
							><strong><span style="font-size: 15pt"> 
							����TOP3</span></strong></td>
						</tr>

						<tr>
							<td colspan="2" align="center">�����å��</td>
						</tr>
						<c:forEach items="${data.home3 }" var="vo" varStatus="no">
							<tr>
								<td align="center">${vo.playerName }</td>
								<td align="center">${vo.era }</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="2" align="center">�¸�</td>
						</tr>
						<c:forEach items="${data.home7 }" var="vo" varStatus="no">
							<tr>
								<td align="center">${vo.playerName }</td>
								<td align="center">${vo.w }</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="2" align="center">Ż����</td>
						</tr>
						<c:forEach items="${data.home5 }" var="vo" varStatus="no">
							<tr>
								<td align="center">${vo.playerName }</td>
								<td align="center">${vo.pitcherSo }</td>
							</tr>

						</c:forEach>

					</table>
				</td>

				<!-- ������������ -->

				<td align="left" align="center">
					<table width="50" height=100% border=2 cellspacing=0 align="center" bordercolor="silver">
						<tr>
							<td colspan="7" align="center"
							style="border-right: 0.1px solid #FFFFFF; border-left: 0.1px solid #FFFFFF;
							border-top: 0.1px solid #FFFFFF;"
							><strong><span style="font-size: 15pt"> 
							TEAM RANKING</span></strong></td>
						</tr>
						<tr>

							<td align="center">����</td>
							<td align="center">��</td>
							<td align="center">���</td>
							<td align="center">��</td>
							<td align="center">��</td>
							<!-- <td>��</td> -->
							<td align="center">�·�</td>
							<td align="center">������</td>

						</tr>
						<c:forEach items="${data.home8 }" var="vo" varStatus="no">
							<tr>
								<td align="center">${no.count }</td>
								<td align="center">${vo.teamName }</td>
								<td align="center">${vo.g }</td>
								<td align="center">${vo.w }</td>
								<td align="center">${vo.l }</td>
								<td align="center">${vo.winPer }</td>
								<td align="center">${vo.cha }</td>
							</tr>



						</c:forEach>

					</table>
				</td>
			</tr>
		</table>

	</form>

</body>
</html>