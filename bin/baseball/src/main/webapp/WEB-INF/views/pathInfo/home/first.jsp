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
	<form action="" border=1>

		<table align="center">
			<tr align="left">
				<!-- 경기결과↓↓↓↓↓ -->
				<td colspan="2">
					<table width=100% height=100% border=2 cellspacing=0 align="center">
						<tr>

							<td colspan="2" align="center">.........경기결과</td>
						</tr>

						<tr>
							<c:set var="tic" value="${ticketOk}" />
							<%-- <c:set var="tic2" value="${data.dd4}" /> --%>

							<!-- 날짜 -->
							<td colspan="1" align="center">${tic[1]}</td>
						</tr>


						<c:forEach items="${data.home9 }" var="vo">


							<c:choose>
								<c:when test="${tic[3] eq vo.year+vo.month+vo.day}">
									<tr>

										<td align="center">
											<c:choose>
													<c:when test="${vo.away eq 'doosan'}">
														<img src="../../../resources/teamPhoto/emblem_OB.png">
														<br>두산 베어스</c:when>
													<c:when test="${vo.away eq 'kia'}">
														<img src="../../../resources/teamPhoto/emblem_HT.png">
														<br>KIA 타이거즈</c:when>
													<c:when test="${vo.away eq 'lg'}">
														<img src="../../../resources/teamPhoto/emblem_LG.png">
														<br>LG 트윈스</c:when>
													<c:when test="${vo.away eq 'hanhwa'}">
														<img src="../../../resources/teamPhoto/emblem_HH.png">
														<br>한화 이글스</c:when>
													<c:when test="${vo.away eq 'lotte'}">
														<img src="../../../resources/teamPhoto/emblem_LT.png">
														<br>롯데 자이언츠</c:when>
													<c:when test="${vo.away eq 'nexen'}">
														<img src="../../../resources/teamPhoto/emblem_WO.png">
														<br>넥센 히어로즈</c:when>
													<c:when test="${vo.away eq 'sk'}">
														<img src="../../../resources/teamPhoto/emblem_SK.png">
														<br>SK 와이번스</c:when>
													<c:when test="${vo.away eq 'kt'}">
														<img src="../../../resources/teamPhoto/emblem_KT.png">
														<br>KT 위즈</c:when>
													<c:when test="${vo.away eq 'samsung'}">
														<img src="../../../resources/teamPhoto/emblem_SS.png">
														<br>삼성 라이온즈</c:when>
													<c:when test="${vo.away eq 'nc'}">
														<img src="../../../resources/teamPhoto/emblem_NC.png">
														<br>NC 다이노스</c:when>
												</c:choose>
										
										vs
										
										
										<c:choose>
													<c:when test="${vo.home eq 'doosan'}">
														<img src="../../../resources/teamPhoto/emblem_OB.png">
														<br>두산 베어스</c:when>
													<c:when test="${vo.home eq 'kia'}">
														<img src="../../../resources/teamPhoto/emblem_HT.png">
														<br>KIA 타이거즈</c:when>
													<c:when test="${vo.home eq 'lg'}">
														<img src="../../../resources/teamPhoto/emblem_LG.png">
														<br>LG 트윈스</c:when>
													<c:when test="${vo.home eq 'hanhwa'}">
														<img src="../../../resources/teamPhoto/emblem_HH.png">
														<br>한화 이글스</c:when>
													<c:when test="${vo.home eq 'lotte'}">
														<img src="../../../resources/teamPhoto/emblem_LT.png">
														<br>롯데 자이언츠</c:when>
													<c:when test="${vo.home eq 'nexen'}">
														<img src="../../../resources/teamPhoto/emblem_WO.png">
														<br>넥센 히어로즈</c:when>
													<c:when test="${vo.home eq 'sk'}">
														<img src="../../../resources/teamPhoto/emblem_SK.png">
														<br>SK 와이번스</c:when>
													<c:when test="${vo.home eq 'kt'}">
														<img src="../../../resources/teamPhoto/emblem_KT.png">
														<br>KT 위즈</c:when>
													<c:when test="${vo.home eq 'samsung'}">
														<img src="../../../resources/teamPhoto/emblem_SS.png">
														<br>삼성 라이온즈</c:when>
													<c:when test="${vo.home eq 'nc'}">
														<img src="../../../resources/teamPhoto/emblem_NC.png">
														<br>NC 다이노스</c:when>
												</c:choose></td>
									</tr>
									<tr>

										<td align="center">..........${vo.stadium}
										${vo.home_r},${vo.away_r}
										</td>
									</tr>
									<tr>
										<td align="center"><a
											href="../../../pathInfo/schedule/notice/gameRegisterView?game_num=${vo.game_num}&home=${vo.home }&away=${vo.away }">경기결과</a></td>
									</tr>
								</c:when>

							</c:choose>



						</c:forEach>

					</table>
				</td>


				<!-- 다음경기↓↓↓↓↓ -->

				<td>
					<table width="50%" height=100% border=2 cellspacing=0>
						<tr>

							<td colspan="3" align="center">다음 경기</td>

						</tr>

						<c:set var="tic" value="${ticketOk}" />

						<c:forEach items="${data.home9 }" var="vo">
							<tr>


								<c:choose>

									<c:when test="${tic[2] eq vo.year+vo.month+vo.day}">

										<tr>
											<!-- 날짜 -->
											<td colspan="3" align="center">${vo.month}월${vo.day}일
												${vo.yoil}요일</td>
										</tr>
										<tr>
											<td colspan="3" align="center">${vo.channel}</td>
										</tr>
										<tr>
											<td rowspan="2" align="center"><c:choose>
													<c:when test="${vo.away eq 'doosan'}">
														<img src="../../../resources/teamPhoto/emblem_OB.png">
														<br>두산 베어스</c:when>
													<c:when test="${vo.away eq 'kia'}">
														<img src="../../../resources/teamPhoto/emblem_HT.png">
														<br>KIA 타이거즈</c:when>
													<c:when test="${vo.away eq 'lg'}">
														<img src="../../../resources/teamPhoto/emblem_LG.png">
														<br>LG 트윈스</c:when>
													<c:when test="${vo.away eq 'hanhwa'}">
														<img src="../../../resources/teamPhoto/emblem_HH.png">
														<br>한화 이글스</c:when>
													<c:when test="${vo.away eq 'lotte'}">
														<img src="../../../resources/teamPhoto/emblem_LT.png">
														<br>롯데 자이언츠</c:when>
													<c:when test="${vo.away eq 'nexen'}">
														<img src="../../../resources/teamPhoto/emblem_WO.png">
														<br>넥센 히어로즈</c:when>
													<c:when test="${vo.away eq 'sk'}">
														<img src="../../../resources/teamPhoto/emblem_SK.png">
														<br>SK 와이번스</c:when>
													<c:when test="${vo.away eq 'kt'}">
														<img src="../../../resources/teamPhoto/emblem_KT.png">
														<br>KT 위즈</c:when>
													<c:when test="${vo.away eq 'samsung'}">
														<img src="../../../resources/teamPhoto/emblem_SS.png">
														<br>삼성 라이온즈</c:when>
													<c:when test="${vo.away eq 'nc'}">
														<img src="../../../resources/teamPhoto/emblem_NC.png">
														<br>NC 다이노스</c:when>
												</c:choose></td>
											<td colspan="1" align="center"><a
												href="../../../test/list?home=${vo.home }&away=${vo.away }&year=${vo.year }&month=${vo.month }&day=${vo.day }&game_time=${vo.game_time }">예매중</a></td>
											<td rowspan="2" align="center"><c:choose>
													<c:when test="${vo.home eq 'doosan'}">
														<img src="../../../resources/teamPhoto/emblem_OB.png">
														<br>두산 베어스</c:when>
													<c:when test="${vo.home eq 'kia'}">
														<img src="../../../resources/teamPhoto/emblem_HT.png">
														<br>KIA 타이거즈</c:when>
													<c:when test="${vo.home eq 'lg'}">
														<img src="../../../resources/teamPhoto/emblem_LG.png">
														<br>LG 트윈스</c:when>
													<c:when test="${vo.home eq 'hanhwa'}">
														<img src="../../../resources/teamPhoto/emblem_HH.png">
														<br>한화 이글스</c:when>
													<c:when test="${vo.home eq 'lotte'}">
														<img src="../../../resources/teamPhoto/emblem_LT.png">
														<br>롯데 자이언츠</c:when>
													<c:when test="${vo.home eq 'nexen'}">
														<img src="../../../resources/teamPhoto/emblem_WO.png">
														<br>넥센 히어로즈</c:when>
													<c:when test="${vo.home eq 'sk'}">
														<img src="../../../resources/teamPhoto/emblem_SK.png">
														<br>SK 와이번스</c:when>
													<c:when test="${vo.home eq 'kt'}">
														<img src="../../../resources/teamPhoto/emblem_KT.png">
														<br>KT 위즈</c:when>
													<c:when test="${vo.home eq 'samsung'}">
														<img src="../../../resources/teamPhoto/emblem_SS.png">
														<br>삼성 라이온즈</c:when>
													<c:when test="${vo.home eq 'nc'}">
														<img src="../../../resources/teamPhoto/emblem_NC.png">
														<br>NC 다이노스</c:when>
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


			<!-- 타자top3↓↓↓↓↓ -->

			<tr>
				<td align="right" align="center">
					<table width=100% height=100% border=2 cellspacing=0 align="center">
						<tr>
							<td colspan="2" align="center">타자 TOP3</td>
						</tr>

						<tr>
							<td colspan="2" align="center">타율</td>
						</tr>
						<c:forEach items="${data.home2 }" var="vo" varStatus="no">
							<tr>
								<td>${vo.playerName }</td>
								<td>${vo.avg }</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="2" align="center">홈런</td>
						</tr>
						<c:forEach items="${data.home4 }" var="vo" varStatus="no">
							<tr>
								<td>${vo.playerName }</td>
								<td>${vo.hr }</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="2" align="center">타점</td>
						</tr>
						<c:forEach items="${data.home6 }" var="vo" varStatus="no">
							<tr>
								<td>${vo.playerName }</td>
								<td>${vo.rbi }</td>
							</tr>

						</c:forEach>

					</table>
				</td>

				<!-- 투수top3↓↓↓↓↓ -->

				<td align="center">
					<table width=100% height=100% border=2 cellspacing=0>
						<tr>
							<td colspan="2" align="center">투수 TOP3</td>
						</tr>

						<tr>
							<td colspan="2" align="center">평균자책점</td>
						</tr>
						<c:forEach items="${data.home3 }" var="vo" varStatus="no">
							<tr>
								<td>${vo.playerName }</td>
								<td>${vo.era }</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="2" align="center">승리</td>
						</tr>
						<c:forEach items="${data.home7 }" var="vo" varStatus="no">
							<tr>
								<td>${vo.playerName }</td>
								<td>${vo.w }</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="2" align="center">탈삼진</td>
						</tr>
						<c:forEach items="${data.home5 }" var="vo" varStatus="no">
							<tr>
								<td>${vo.playerName }</td>
								<td>${vo.pitcherSo }</td>
							</tr>

						</c:forEach>

					</table>
				</td>

				<!-- 팀순위↓↓↓↓↓ -->

				<td align="left" align="center">
					<table width="50%" height=100% border=2 cellspacing=0 align="center">
						<tr>
							<td colspan="7" align="center">TEAM RANKING</td>
						</tr>
						<tr>

							<td align="center">순위</td>
							<td align="center">팀</td>
							<td align="center">경기</td>
							<td align="center">승</td>
							<td align="center">패</td>
							<!-- <td>무</td> -->
							<td align="center">승률</td>
							<td align="center">게임차</td>

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