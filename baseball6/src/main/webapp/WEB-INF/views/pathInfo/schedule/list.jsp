<%@page import="org.springframework.web.util.UrlPathHelper"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<!-- <style>
      table, th, td {
        border: 1px solid #bcbcbc;
        
      }
    </style> -->
<body>
	<form action="list" method="post">
		<!-- class="scroll" -->
		<table border="1">
			<!-- class="type04" -->

			<tr>
				<td colspan="1" width="190"
					style="border-right: 0.1px solid #FFFFFF;"><select name="year">
						<option value="2018">2018</option>
						<option value="2017">2017</option>
						<option value="2016">2016</option>
				</select> <select name="month">
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

				</select> <input type="submit" value="검색" /></td>
				<td colspan="7" align="center"><strong><span
						style="font-size: 2em; color: green;">2018시즌 경기일정</span></strong></td>
			</tr>
			<tr align="center">

				<td>일자</td>
				<td colspan="3" width="230">결과</td>
				<td width="50">구장</td>
				<td width="50">시간</td>
				<td width="30">중계</td>
				<td>비고</td>
				<%-- <c:forEach items="${data.dd3 }" var="vo">
				<td>오면되는데${vo.w }</td>
				</c:forEach> --%>


			</tr>
			<c:set var="tic" value="${ticketOk}" />
			<c:forEach items="${data.dd }" var="vo">
				<tr align="center">
					<td>${vo.year}년${vo.month}월${vo.day}일 ${vo.yoil}요일<input
						type="hidden" value="${vo.game_num}"></td>
					<td><c:choose>
							<c:when test="${vo.away eq 'doosan'}">
								<img src="../../../resources/teamPhoto/emblem_OB.png" width="40">두산 베어스
								
								</c:when>
							<c:when test="${vo.away eq 'kia'}">
								<img src="../../../resources/teamPhoto/emblem_HT.png" width="40">
								KIA 타이거즈</c:when>
							<c:when test="${vo.away eq 'lg'}">
								<img src="../../../resources/teamPhoto/emblem_LG.png" width="40">
								LG 트윈스</c:when>
							<c:when test="${vo.away eq 'hanhwa'}">
								<img src="../../../resources/teamPhoto/emblem_HH.png" width="40">
								한화 이글스</c:when>
							<c:when test="${vo.away eq 'lotte'}">
								<img src="../../../resources/teamPhoto/emblem_LT.png" width="40">
								롯데 자이언츠</c:when>
							<c:when test="${vo.away eq 'nexen'}">
								<img src="../../../resources/teamPhoto/emblem_WO.png" width="40">
								넥센 히어로즈</c:when>
							<c:when test="${vo.away eq 'sk'}">
								<img src="../../../resources/teamPhoto/emblem_SK.png" width="40">
								SK 와이번스</c:when>
							<c:when test="${vo.away eq 'kt'}">
								<img src="../../../resources/teamPhoto/emblem_KT.png" width="40">
								KT 위즈</c:when>
							<c:when test="${vo.away eq 'samsung'}">
								<img src="../../../resources/teamPhoto/emblem_SS.png" width="40">
								삼성 라이온즈</c:when>
							<c:when test="${vo.away eq 'nc'}">
								<img src="../../../resources/teamPhoto/emblem_NC.png" width="40">
								NC 다이노스</c:when>
						</c:choose> ${vo.away_r}</td>
					<td width="1"
						style="border-right: 0.1px solid #FFFFFF; border-left: 0.1px solid #FFFFFF;">
						vs</td>
					<td>${vo.home_r}<c:choose>
							<c:when test="${vo.home eq 'doosan'}">
								<img src="../../../resources/teamPhoto/emblem_OB.png" width="40">
								두산 베어스</c:when>
							<c:when test="${vo.home eq 'kia'}">
								KIA 타이거즈<img src="../../../resources/teamPhoto/emblem_HT.png"
									width="40">
							</c:when>
							<c:when test="${vo.home eq 'lg'}">
								LG 트윈스<img src="../../../resources/teamPhoto/emblem_LG.png" width="40">
								</c:when>
							<c:when test="${vo.home eq 'hanhwa'}">
								한화 이글스<img src="../../../resources/teamPhoto/emblem_HH.png" width="40">
								</c:when>
							<c:when test="${vo.home eq 'lotte'}">
								롯데 자이언츠<img src="../../../resources/teamPhoto/emblem_LT.png" width="40">
								</c:when>
							<c:when test="${vo.home eq 'nexen'}">
								넥센 히어로즈<img src="../../../resources/teamPhoto/emblem_WO.png" width="40">
								</c:when>
							<c:when test="${vo.home eq 'sk'}">
								SK 와이번스<img src="../../../resources/teamPhoto/emblem_SK.png" width="40">
								</c:when>
							<c:when test="${vo.home eq 'kt'}">
								KT 위즈<img src="../../../resources/teamPhoto/emblem_KT.png" width="40">
								</c:when>
							<c:when test="${vo.home eq 'samsung'}">
								삼성 라이온즈<img src="../../../resources/teamPhoto/emblem_SS.png" width="40">
								</c:when>
							<c:when test="${vo.home eq 'nc'}">
								NC 다이노스<img src="../../../resources/teamPhoto/emblem_NC.png" width="40">
								</c:when>
						</c:choose></td>
					<td><c:choose>
							<c:when test="${vo.stadium eq 'doosan 잠실야구장'}">
					잠실
					</c:when>
							<c:when test="${vo.stadium eq 'kia 광주기아챔피언스필드'}">
					광주
					</c:when>
							<c:when test="${vo.stadium eq 'lg 잠실야구장'}">
					잠실
					</c:when>
							<c:when test="${vo.stadium eq 'nc 마산야구장'}">
					창원
					</c:when>
							<c:when test="${vo.stadium eq 'sk 인천문학야구장'}">
					인천
					</c:when>
							<c:when test="${vo.stadium eq 'kt 수원야구장'}">
					수원
					</c:when>
							<c:when test="${vo.stadium eq 'nexen 고척스카이돔'}">
					고척
					</c:when>
							<c:when test="${vo.stadium eq 'hanhwa 대전한밭야구장'}">
					대전
					</c:when>
							<c:when test="${vo.stadium eq 'samsung 라이온즈파크'}">
					대구
					</c:when>
							<c:when test="${vo.stadium eq 'lotte 사직야구장'}">
					부산
					</c:when>

						</c:choose></td>
					<td>${vo.game_time}</td>
					<td>${vo.channel}</td>
					<c:choose>
						<c:when test="${tic[0] eq vo.day}">
							<td><a
								href="../../../test/list?home=${vo.home }&away=${vo.away }&year=${vo.year }&month=${vo.month }&day=${vo.day }&game_time=${vo.game_time }">예매중</a></td>
						</c:when>
						<c:when test="${tic[0]+1 eq vo.day}">
							<td><a
								href="../../../test/list?home=${vo.home }&away=${vo.away }&year=${vo.year }&month=${vo.month }&day=${vo.day }&game_time=${vo.game_time }">예매중</a></td>
						</c:when>
						<c:when test="${tic[0]+2 eq vo.day}">
							<td><a
								href="../../../test/list?home=${vo.home }&away=${vo.away }&year=${vo.year }&month=${vo.month }&day=${vo.day }&game_time=${vo.game_time }">예매중</a></td>
						</c:when>
						<c:when test="${tic[0] ge vo.day}">
							<td><a
								href="gameRegisterDetail2?game_num=${vo.game_num}&home=${vo.home }&away=${vo.away }">경기결과</a></td>
						</c:when>
						<c:otherwise>
							<td><a
								href="gameRegisterDetail2?game_num=${vo.game_num}&home=${vo.home }&away=${vo.away }">경기정보</a></td>
						</c:otherwise>
					</c:choose>

				</tr>
				<tr>

				</tr>
			</c:forEach>
			<c:set var="tic" value="${ticketOk}" />
			<c:forEach items="${data.dd2}" var="vo">
				<c:choose>
					<c:when test="${tic[0] eq vo.year+vo.month+vo.day}">
						<tr align="center">

							<td>${vo.year}년${vo.month}월${vo.day}일${vo.yoil}요일<input
								type="hidden" value="${vo.game_num}"></td>
							<td><c:choose>
									<c:when test="${vo.away eq 'doosan'}">
										<img src="../../../resources/teamPhoto/emblem_OB.png"
											width="40">
										두산 베어스</c:when>
									<c:when test="${vo.away eq 'kia'}">
										<img src="../../../resources/teamPhoto/emblem_HT.png"
											width="40">
										KIA 타이거즈</c:when>
									<c:when test="${vo.away eq 'lg'}">
										<img src="../../../resources/teamPhoto/emblem_LG.png"
											width="40">
										LG 트윈스</c:when>
									<c:when test="${vo.away eq 'hanhwa'}">
										<img src="../../../resources/teamPhoto/emblem_HH.png"
											width="40">
										한화 이글스</c:when>
									<c:when test="${vo.away eq 'lotte'}">
										<img src="../../../resources/teamPhoto/emblem_LT.png"
											width="40">
										롯데 자이언츠</c:when>
									<c:when test="${vo.away eq 'nexen'}">
										<img src="../../../resources/teamPhoto/emblem_WO.png"
											width="40">
										넥센 히어로즈</c:when>
									<c:when test="${vo.away eq 'sk'}">
										<img src="../../../resources/teamPhoto/emblem_SK.png"
											width="40">
										SK 와이번스</c:when>
									<c:when test="${vo.away eq 'kt'}">
										<img src="../../../resources/teamPhoto/emblem_KT.png"
											width="40">
										KT 위즈</c:when>
									<c:when test="${vo.away eq 'samsung'}">
										<img src="../../../resources/teamPhoto/emblem_SS.png"
											width="40">
										삼성 라이온즈</c:when>
									<c:when test="${vo.away eq 'nc'}">
										<img src="../../../resources/teamPhoto/emblem_NC.png"
											width="40">
										NC 다이노스</c:when>
								</c:choose> ${vo.away_r}</td>
							<td
								style="border-right: 0.1px solid #FFFFFF; border-left: 0.1px solid #FFFFFF;">
								vs</td>
							<td>${vo.home_r}<c:choose>
									<c:when test="${vo.home eq 'doosan'}">
										두산 베어스<img src="../../../resources/teamPhoto/emblem_OB.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'kia'}">
										KIA 타이거즈<img src="../../../resources/teamPhoto/emblem_HT.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'lg'}">
										LG 트윈스<img src="../../../resources/teamPhoto/emblem_LG.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'hanhwa'}">
										한화 이글스<img src="../../../resources/teamPhoto/emblem_HH.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'lotte'}">
										롯데 자이언츠<img src="../../../resources/teamPhoto/emblem_LT.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'nexen'}">
										넥센 히어로즈<img src="../../../resources/teamPhoto/emblem_WO.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'sk'}">
										SK 와이번스<img src="../../../resources/teamPhoto/emblem_SK.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'kt'}">
										KT 위즈<img src="../../../resources/teamPhoto/emblem_KT.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'samsung'}">
										삼성 라이온즈<img src="../../../resources/teamPhoto/emblem_SS.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'nc'}">
										NC 다이노스<img src="../../../resources/teamPhoto/emblem_NC.png"
											width="40">
										</c:when>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${vo.stadium eq 'doosan 잠실야구장'}">
					잠실
					</c:when>
									<c:when test="${vo.stadium eq 'kia 광주기아챔피언스필드'}">
					광주
					</c:when>
									<c:when test="${vo.stadium eq 'lg 잠실야구장'}">
					잠실
					</c:when>
									<c:when test="${vo.stadium eq 'nc 마산야구장'}">
					창원
					</c:when>
									<c:when test="${vo.stadium eq 'sk 인천문학야구장'}">
					인천
					</c:when>
									<c:when test="${vo.stadium eq 'kt 수원야구장'}">
					수원
					</c:when>
									<c:when test="${vo.stadium eq 'nexen 고척스카이돔'}">
					고척
					</c:when>
									<c:when test="${vo.stadium eq 'hanhwa 대전한밭야구장'}">
					대전
					</c:when>
									<c:when test="${vo.stadium eq 'samsung 라이온즈파크'}">
					대구
					</c:when>
									<c:when test="${vo.stadium eq 'lotte 사직야구장'}">
					부산
					</c:when>

								</c:choose></td>
							<td>${vo.game_time}</td>
							<td>${vo.channel}</td>
							<c:choose>
								<c:when test="${tic[0] eq vo.year+vo.month+vo.day}">
									<td><a
										href="../../../test/list?home=${vo.home }&away=${vo.away }&year=${vo.year }&month=${vo.month }&day=${vo.day }&game_time=${vo.game_time }">예매중</a></td>
								</c:when>
								<c:when test="${tic[0]+1 eq vo.year+vo.month+vo.day}">
									<td><a
										href="../../../test/list?home=${vo.home }&away=${vo.away }&year=${vo.year }&month=${vo.month }&day=${vo.day }&game_time=${vo.game_time }">예매중</a></td>
								</c:when>
								<c:when test="${tic[0]+2 eq vo.year+vo.month+vo.day}">
									<td><a
										href="../../../test/list?home=${vo.home }&away=${vo.away }&year=${vo.year }&month=${vo.month }&day=${vo.day }&game_time=${vo.game_time }">예매중</a></td>
								</c:when>
							</c:choose>

						</tr>
					</c:when>
				</c:choose>
				<tr>

				</tr>
			</c:forEach>

			<c:set var="tic" value="${ticketOk}" />
			<c:forEach items="${data.dd2}" var="vo">
				<c:choose>
					<c:when test="${tic[1] eq vo.year+vo.month+vo.day}">
						<tr align="center">
							<td>${vo.year}년${vo.month}월${vo.day}일${vo.yoil}요일<input
								type="hidden" value="${vo.game_num}"></td>
							<td><c:choose>
									<c:when test="${vo.away eq 'doosan'}">
										<img src="../../../resources/teamPhoto/emblem_OB.png"
											width="40">
										두산 베어스</c:when>
									<c:when test="${vo.away eq 'kia'}">
										<img src="../../../resources/teamPhoto/emblem_HT.png"
											width="40">
										KIA 타이거즈</c:when>
									<c:when test="${vo.away eq 'lg'}">
										<img src="../../../resources/teamPhoto/emblem_LG.png"
											width="40">
										LG 트윈스</c:when>
									<c:when test="${vo.away eq 'hanhwa'}">
										<img src="../../../resources/teamPhoto/emblem_HH.png"
											width="40">
										한화 이글스</c:when>
									<c:when test="${vo.away eq 'lotte'}">
										<img src="../../../resources/teamPhoto/emblem_LT.png"
											width="40">
										롯데 자이언츠</c:when>
									<c:when test="${vo.away eq 'nexen'}">
										<img src="../../../resources/teamPhoto/emblem_WO.png"
											width="40">
										넥센 히어로즈</c:when>
									<c:when test="${vo.away eq 'sk'}">
										<img src="../../../resources/teamPhoto/emblem_SK.png"
											width="40">
										SK 와이번스</c:when>
									<c:when test="${vo.away eq 'kt'}">
										<img src="../../../resources/teamPhoto/emblem_KT.png"
											width="40">
										KT 위즈</c:when>
									<c:when test="${vo.away eq 'samsung'}">
										<img src="../../../resources/teamPhoto/emblem_SS.png"
											width="40">
										삼성 라이온즈</c:when>
									<c:when test="${vo.away eq 'nc'}">
										<img src="../../../resources/teamPhoto/emblem_NC.png"
											width="40">
										NC 다이노스</c:when>
								</c:choose> ${vo.away_r}</td>
							<td
								style="border-right: 0.1px solid #FFFFFF; border-left: 0.1px solid #FFFFFF;">
								vs</td>
							<td>${vo.home_r}<c:choose>
									<c:when test="${vo.home eq 'doosan'}">
										두산 베어스<img src="../../../resources/teamPhoto/emblem_OB.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'kia'}">
										KIA 타이거즈<img src="../../../resources/teamPhoto/emblem_HT.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'lg'}">
										LG 트윈스<img src="../../../resources/teamPhoto/emblem_LG.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'hanhwa'}">
										한화 이글스<img src="../../../resources/teamPhoto/emblem_HH.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'lotte'}">
										롯데 자이언츠<img src="../../../resources/teamPhoto/emblem_LT.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'nexen'}">
										넥센 히어로즈<img src="../../../resources/teamPhoto/emblem_WO.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'sk'}">
										SK 와이번스<img src="../../../resources/teamPhoto/emblem_SK.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'kt'}">
										KT 위즈<img src="../../../resources/teamPhoto/emblem_KT.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'samsung'}">
										삼성 라이온즈<img src="../../../resources/teamPhoto/emblem_SS.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'nc'}">
										NC 다이노스<img src="../../../resources/teamPhoto/emblem_NC.png"
											width="40">
										</c:when>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${vo.stadium eq 'doosan 잠실야구장'}">
					잠실
					</c:when>
									<c:when test="${vo.stadium eq 'kia 광주기아챔피언스필드'}">
					광주
					</c:when>
									<c:when test="${vo.stadium eq 'lg 잠실야구장'}">
					잠실
					</c:when>
									<c:when test="${vo.stadium eq 'nc 마산야구장'}">
					창원
					</c:when>
									<c:when test="${vo.stadium eq 'sk 인천문학야구장'}">
					인천
					</c:when>
									<c:when test="${vo.stadium eq 'kt 수원야구장'}">
					수원
					</c:when>
									<c:when test="${vo.stadium eq 'nexen 고척스카이돔'}">
					고척
					</c:when>
									<c:when test="${vo.stadium eq 'hanhwa 대전한밭야구장'}">
					대전
					</c:when>
									<c:when test="${vo.stadium eq 'samsung 라이온즈파크'}">
					대구
					</c:when>
									<c:when test="${vo.stadium eq 'lotte 사직야구장'}">
					부산
					</c:when>

								</c:choose></td>
							<td>${vo.game_time}</td>
							<td>${vo.channel}</td>
							<c:choose>
								<c:when test="${tic[0] eq vo.year+vo.month+vo.day}">
									<td><a
										href="../../../test/list?home=${vo.home }&away=${vo.away }&year=${vo.year }&month=${vo.month }&day=${vo.day }&game_time=${vo.game_time }">예매중</a></td>
								</c:when>
								<c:when test="${tic[0]+1 eq vo.year+vo.month+vo.day}">
									<td><a
										href="../../../test/list?home=${vo.home }&away=${vo.away }&year=${vo.year }&month=${vo.month }&day=${vo.day }&game_time=${vo.game_time }">예매중</a></td>
								</c:when>
								<c:when test="${tic[0]+2 eq vo.year+vo.month+vo.day}">
									<td><a
										href="../../../test/list?home=${vo.home }&away=${vo.away }&year=${vo.year }&month=${vo.month }&day=${vo.day }&game_time=${vo.game_time }">예매중</a></td>
								</c:when>
							</c:choose>

						</tr>
					</c:when>
				</c:choose>
				<tr>

				</tr>
			</c:forEach>

			<c:set var="tic" value="${ticketOk}" />
			<c:forEach items="${data.dd2}" var="vo">
				<c:choose>
					<c:when test="${tic[2] eq vo.year+vo.month+vo.day}">
						<tr align="center">
							<td>${vo.year}년${vo.month}월${vo.day}일${vo.yoil}요일<input
								type="hidden" value="${vo.game_num}"></td>
							<td><c:choose>
									<c:when test="${vo.away eq 'doosan'}">
										<img src="../../../resources/teamPhoto/emblem_OB.png"
											width="40">
										두산 베어스</c:when>
									<c:when test="${vo.away eq 'kia'}">
										<img src="../../../resources/teamPhoto/emblem_HT.png"
											width="40">
										KIA 타이거즈</c:when>
									<c:when test="${vo.away eq 'lg'}">
										<img src="../../../resources/teamPhoto/emblem_LG.png"
											width="40">
										LG 트윈스</c:when>
									<c:when test="${vo.away eq 'hanhwa'}">
										<img src="../../../resources/teamPhoto/emblem_HH.png"
											width="40">
										한화 이글스</c:when>
									<c:when test="${vo.away eq 'lotte'}">
										<img src="../../../resources/teamPhoto/emblem_LT.png"
											width="40">
										롯데 자이언츠</c:when>
									<c:when test="${vo.away eq 'nexen'}">
										<img src="../../../resources/teamPhoto/emblem_WO.png"
											width="40">
										넥센 히어로즈</c:when>
									<c:when test="${vo.away eq 'sk'}">
										<img src="../../../resources/teamPhoto/emblem_SK.png"
											width="40">
										SK 와이번스</c:when>
									<c:when test="${vo.away eq 'kt'}">
										<img src="../../../resources/teamPhoto/emblem_KT.png"
											width="40">
										KT 위즈</c:when>
									<c:when test="${vo.away eq 'samsung'}">
										<img src="../../../resources/teamPhoto/emblem_SS.png"
											width="40">
										삼성 라이온즈</c:when>
									<c:when test="${vo.away eq 'nc'}">
										<img src="../../../resources/teamPhoto/emblem_NC.png"
											width="40">
										NC 다이노스</c:when>
								</c:choose>${vo.away_r}</td>

							<td
								style="border-right: 0.1px solid #FFFFFF; border-left: 0.1px solid #FFFFFF;">
								vs</td>
							<td>${vo.home_r}<c:choose>
									<c:when test="${vo.home eq 'doosan'}">
										두산 베어스<img src="../../../resources/teamPhoto/emblem_OB.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'kia'}">
										KIA 타이거즈<img src="../../../resources/teamPhoto/emblem_HT.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'lg'}">
										LG 트윈스<img src="../../../resources/teamPhoto/emblem_LG.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'hanhwa'}">
										한화 이글스<img src="../../../resources/teamPhoto/emblem_HH.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'lotte'}">
										롯데 자이언츠<img src="../../../resources/teamPhoto/emblem_LT.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'nexen'}">
										넥센 히어로즈<img src="../../../resources/teamPhoto/emblem_WO.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'sk'}">
										SK 와이번스<img src="../../../resources/teamPhoto/emblem_SK.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'kt'}">
										KT 위즈<img src="../../../resources/teamPhoto/emblem_KT.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'samsung'}">
										삼성 라이온즈<img src="../../../resources/teamPhoto/emblem_SS.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'nc'}">
										NC 다이노스<img src="../../../resources/teamPhoto/emblem_NC.png"
											width="40">
										</c:when>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${vo.stadium eq 'doosan 잠실야구장'}">
					잠실
					</c:when>
									<c:when test="${vo.stadium eq 'kia 광주기아챔피언스필드'}">
					광주
					</c:when>
									<c:when test="${vo.stadium eq 'lg 잠실야구장'}">
					잠실
					</c:when>
									<c:when test="${vo.stadium eq 'nc 마산야구장'}">
					창원
					</c:when>
									<c:when test="${vo.stadium eq 'sk 인천문학야구장'}">
					인천
					</c:when>
									<c:when test="${vo.stadium eq 'kt 수원야구장'}">
					수원
					</c:when>
									<c:when test="${vo.stadium eq 'nexen 고척스카이돔'}">
					고척
					</c:when>
									<c:when test="${vo.stadium eq 'hanhwa 대전한밭야구장'}">
					대전
					</c:when>
									<c:when test="${vo.stadium eq 'samsung 라이온즈파크'}">
					대구
					</c:when>
									<c:when test="${vo.stadium eq 'lotte 사직야구장'}">
					부산
					</c:when>

								</c:choose></td>
							<td>${vo.game_time}</td>
							<td>${vo.channel}</td>
							<c:choose>
								<c:when test="${tic[0] eq vo.year+vo.month+vo.day}">
									<td><a
										href="../../../test/list?home=${vo.home }&away=${vo.away }&year=${vo.year }&month=${vo.month }&day=${vo.day }&game_time=${vo.game_time }">예매중</a></td>
								</c:when>
								<c:when test="${tic[0]+1 eq vo.year+vo.month+vo.day}">
									<td><a
										href="../../../test/list?home=${vo.home }&away=${vo.away }&year=${vo.year }&month=${vo.month }&day=${vo.day }&game_time=${vo.game_time }">예매중</a></td>
								</c:when>
								<c:when test="${tic[0]+2 eq vo.year+vo.month+vo.day}">
									<td><a
										href="../../../test/list?home=${vo.home }&away=${vo.away }&year=${vo.year }&month=${vo.month }&day=${vo.day }&game_time=${vo.game_time }">예매중</a></td>
								</c:when>
							</c:choose>

						</tr>
					</c:when>
				</c:choose>
				<tr>

				</tr>
			</c:forEach>

			<c:set var="tic" value="${ticketOk}" />
			<c:forEach items="${data.dd2}" var="vo">
				<c:choose>
					<c:when test="${tic[3] eq vo.year+vo.month+vo.day}">
						<tr align="center">
							<td>${vo.year}년${vo.month}월${vo.day}일${vo.yoil}요일<input
								type="hidden" value="${vo.game_num}"></td>
							<td><c:choose>
									<c:when test="${vo.away eq 'doosan'}">
										<img src="../../../resources/teamPhoto/emblem_OB.png"
											width="40">
										두산 베어스</c:when>
									<c:when test="${vo.away eq 'kia'}">
										<img src="../../../resources/teamPhoto/emblem_HT.png"
											width="40">
										KIA 타이거즈</c:when>
									<c:when test="${vo.away eq 'lg'}">
										<img src="../../../resources/teamPhoto/emblem_LG.png"
											width="40">
										LG 트윈스</c:when>
									<c:when test="${vo.away eq 'hanhwa'}">
										<img src="../../../resources/teamPhoto/emblem_HH.png"
											width="40">
										한화 이글스</c:when>
									<c:when test="${vo.away eq 'lotte'}">
										<img src="../../../resources/teamPhoto/emblem_LT.png"
											width="40">
										롯데 자이언츠</c:when>
									<c:when test="${vo.away eq 'nexen'}">
										<img src="../../../resources/teamPhoto/emblem_WO.png"
											width="40">
										넥센 히어로즈</c:when>
									<c:when test="${vo.away eq 'sk'}">
										<img src="../../../resources/teamPhoto/emblem_SK.png"
											width="40">
										SK 와이번스</c:when>
									<c:when test="${vo.away eq 'kt'}">
										<img src="../../../resources/teamPhoto/emblem_KT.png"
											width="40">
										KT 위즈</c:when>
									<c:when test="${vo.away eq 'samsung'}">
										<img src="../../../resources/teamPhoto/emblem_SS.png"
											width="40">
										삼성 라이온즈</c:when>
									<c:when test="${vo.away eq 'nc'}">
										<img src="../../../resources/teamPhoto/emblem_NC.png"
											width="40">
										NC 다이노스</c:when>
								</c:choose>${vo.away_r} ${vo.home_r}</td>
							<td
								style="border-right: 0.1px solid #FFFFFF; border-left: 0.1px solid #FFFFFF;">
								vs</td>
							<td><c:choose>
									<c:when test="${vo.home eq 'doosan'}">
										두산 베어스<img src="../../../resources/teamPhoto/emblem_OB.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'kia'}">
										KIA 타이거즈<img src="../../../resources/teamPhoto/emblem_HT.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'lg'}">
										LG 트윈스<img src="../../../resources/teamPhoto/emblem_LG.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'hanhwa'}">
										한화 이글스<img src="../../../resources/teamPhoto/emblem_HH.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'lotte'}">
										롯데 자이언츠<img src="../../../resources/teamPhoto/emblem_LT.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'nexen'}">
										넥센 히어로즈<img src="../../../resources/teamPhoto/emblem_WO.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'sk'}">
										SK 와이번스<img src="../../../resources/teamPhoto/emblem_SK.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'kt'}">
										KT 위즈<img src="../../../resources/teamPhoto/emblem_KT.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'samsung'}">
										삼성 라이온즈<img src="../../../resources/teamPhoto/emblem_SS.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'nc'}">
										NC 다이노스<img src="../../../resources/teamPhoto/emblem_NC.png"
											width="40">
										</c:when>
								</c:choose></td>

							<td><c:choose>
									<c:when test="${vo.stadium eq 'doosan 잠실야구장'}">
					잠실
					</c:when>
									<c:when test="${vo.stadium eq 'kia 광주기아챔피언스필드'}">
					광주
					</c:when>
									<c:when test="${vo.stadium eq 'lg 잠실야구장'}">
					잠실
					</c:when>
									<c:when test="${vo.stadium eq 'nc 마산야구장'}">
					창원
					</c:when>
									<c:when test="${vo.stadium eq 'sk 인천문학야구장'}">
					인천
					</c:when>
									<c:when test="${vo.stadium eq 'kt 수원야구장'}">
					수원
					</c:when>
									<c:when test="${vo.stadium eq 'nexen 고척스카이돔'}">
					고척
					</c:when>
									<c:when test="${vo.stadium eq 'hanhwa 대전한밭야구장'}">
					대전
					</c:when>
									<c:when test="${vo.stadium eq 'samsung 라이온즈파크'}">
					대구
					</c:when>
									<c:when test="${vo.stadium eq 'lotte 사직야구장'}">
					부산
					</c:when>

								</c:choose></td>
							<td>${vo.game_time}</td>
							<td>${vo.channel}</td>
							<c:choose>
								<c:when test="${tic[0] eq vo.year+vo.month+vo.day}">
									<td><a
										href="../../../test/list?home=${vo.home }&away=${vo.away }&year=${vo.year }&month=${vo.month }&day=${vo.day }&game_time=${vo.game_time }">예매중</a></td>
								</c:when>
								<c:when test="${tic[0]+1 eq vo.year+vo.month+vo.day}">
									<td><a
										href="../../../test/list?home=${vo.home }&away=${vo.away }&year=${vo.year }&month=${vo.month }&day=${vo.day }&game_time=${vo.game_time }">예매중</a></td>
								</c:when>
								<c:when test="${tic[0]+2 eq vo.year+vo.month+vo.day}">
									<td><a
										href="../../../test/list?home=${vo.home }&away=${vo.away }&year=${vo.year }&month=${vo.month }&day=${vo.day }&game_time=${vo.game_time }">예매중</a></td>
								</c:when>
							</c:choose>

						</tr>
					</c:when>
				</c:choose>
				<tr>

				</tr>
			</c:forEach>

			<c:set var="tic" value="${ticketOk}" />
			<c:forEach items="${data.dd2}" var="vo">
				<c:choose>
					<c:when test="${tic[4] eq vo.year+vo.month+vo.day}">
						<tr align="center">
							<td>${vo.year}년${vo.month}월${vo.day}일${vo.yoil}요일<input
								type="hidden" value="${vo.game_num}"></td>
							<td><c:choose>
									<c:when test="${vo.away eq 'doosan'}">
										<img src="../../../resources/teamPhoto/emblem_OB.png"
											width="40">
										두산 베어스</c:when>
									<c:when test="${vo.away eq 'kia'}">
										<img src="../../../resources/teamPhoto/emblem_HT.png"
											width="40">
										KIA 타이거즈</c:when>
									<c:when test="${vo.away eq 'lg'}">
										<img src="../../../resources/teamPhoto/emblem_LG.png"
											width="40">
										LG 트윈스</c:when>
									<c:when test="${vo.away eq 'hanhwa'}">
										<img src="../../../resources/teamPhoto/emblem_HH.png"
											width="40">
										한화 이글스</c:when>
									<c:when test="${vo.away eq 'lotte'}">
										<img src="../../../resources/teamPhoto/emblem_LT.png"
											width="40">
										롯데 자이언츠</c:when>
									<c:when test="${vo.away eq 'nexen'}">
										<img src="../../../resources/teamPhoto/emblem_WO.png"
											width="40">
										넥센 히어로즈</c:when>
									<c:when test="${vo.away eq 'sk'}">
										<img src="../../../resources/teamPhoto/emblem_SK.png"
											width="40">
										SK 와이번스</c:when>
									<c:when test="${vo.away eq 'kt'}">
										<img src="../../../resources/teamPhoto/emblem_KT.png"
											width="40">
										KT 위즈</c:when>
									<c:when test="${vo.away eq 'samsung'}">
										<img src="../../../resources/teamPhoto/emblem_SS.png"
											width="40">
										삼성 라이온즈</c:when>
									<c:when test="${vo.away eq 'nc'}">
										<img src="../../../resources/teamPhoto/emblem_NC.png"
											width="40">
										NC 다이노스</c:when>
								</c:choose>${vo.away_r}</td>
							<td
								style="border-right: 0.1px solid #FFFFFF; border-left: 0.1px solid #FFFFFF;">vs</td>
							<td>${vo.home_r}<c:choose>
									<c:when test="${vo.home eq 'doosan'}">
										두산 베어스<img src="../../../resources/teamPhoto/emblem_OB.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'kia'}">
										KIA 타이거즈<img src="../../../resources/teamPhoto/emblem_HT.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'lg'}">
										LG 트윈스<img src="../../../resources/teamPhoto/emblem_LG.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'hanhwa'}">
										한화 이글스<img src="../../../resources/teamPhoto/emblem_HH.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'lotte'}">
										롯데 자이언츠<img src="../../../resources/teamPhoto/emblem_LT.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'nexen'}">
										넥센 히어로즈<img src="../../../resources/teamPhoto/emblem_WO.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'sk'}">
										SK 와이번스<img src="../../../resources/teamPhoto/emblem_SK.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'kt'}">
										KT 위즈<img src="../../../resources/teamPhoto/emblem_KT.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'samsung'}">
										삼성 라이온즈<img src="../../../resources/teamPhoto/emblem_SS.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'nc'}">
										NC 다이노스<img src="../../../resources/teamPhoto/emblem_NC.png"
											width="40">
										</c:when>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${vo.stadium eq 'doosan 잠실야구장'}">
					잠실
					</c:when>
									<c:when test="${vo.stadium eq 'kia 광주기아챔피언스필드'}">
					광주
					</c:when>
									<c:when test="${vo.stadium eq 'lg 잠실야구장'}">
					잠실
					</c:when>
									<c:when test="${vo.stadium eq 'nc 마산야구장'}">
					창원
					</c:when>
									<c:when test="${vo.stadium eq 'sk 인천문학야구장'}">
					인천
					</c:when>
									<c:when test="${vo.stadium eq 'kt 수원야구장'}">
					수원
					</c:when>
									<c:when test="${vo.stadium eq 'nexen 고척스카이돔'}">
					고척
					</c:when>
									<c:when test="${vo.stadium eq 'hanhwa 대전한밭야구장'}">
					대전
					</c:when>
									<c:when test="${vo.stadium eq 'samsung 라이온즈파크'}">
					대구
					</c:when>
									<c:when test="${vo.stadium eq 'lotte 사직야구장'}">
					부산
					</c:when>

								</c:choose></td>
							<td>${vo.game_time}</td>
							<td>${vo.channel}</td>
							<td><a
								href="../../../test/list?home=${vo.home }&away=${vo.away }&year=${vo.year }&month=${vo.month }&day=${vo.day }&game_time=${vo.game_time }">경기정보</a></td>

						</tr>
					</c:when>
				</c:choose>
				<tr>

				</tr>
			</c:forEach>

			<c:set var="tic" value="${ticketOk}" />
			<c:forEach items="${data.dd2}" var="vo">
				<c:choose>
					<c:when test="${tic[5] eq vo.year+vo.month+vo.day}">
						<tr align="center">
							<td>${vo.year}<input type="hidden" value="${vo.game_num}"></td>
							<td>${vo.month}</td>
							<td>${vo.day}</td>
							<td>${vo.yoil}</td>
							<td><c:choose>
									<c:when test="${vo.away eq 'doosan'}">
										<img src="../../../resources/teamPhoto/emblem_OB.png"
											width="40">
										두산 베어스</c:when>
									<c:when test="${vo.away eq 'kia'}">
										<img src="../../../resources/teamPhoto/emblem_HT.png"
											width="40">
										KIA 타이거즈</c:when>
									<c:when test="${vo.away eq 'lg'}">
										<img src="../../../resources/teamPhoto/emblem_LG.png"
											width="40">
										LG 트윈스</c:when>
									<c:when test="${vo.away eq 'hanhwa'}">
										<img src="../../../resources/teamPhoto/emblem_HH.png"
											width="40">
										한화 이글스</c:when>
									<c:when test="${vo.away eq 'lotte'}">
										<img src="../../../resources/teamPhoto/emblem_LT.png"
											width="40">
										롯데 자이언츠</c:when>
									<c:when test="${vo.away eq 'nexen'}">
										<img src="../../../resources/teamPhoto/emblem_WO.png"
											width="40">
										넥센 히어로즈</c:when>
									<c:when test="${vo.away eq 'sk'}">
										<img src="../../../resources/teamPhoto/emblem_SK.png"
											width="40">
										SK 와이번스</c:when>
									<c:when test="${vo.away eq 'kt'}">
										<img src="../../../resources/teamPhoto/emblem_KT.png"
											width="40">
										KT 위즈</c:when>
									<c:when test="${vo.away eq 'samsung'}">
										<img src="../../../resources/teamPhoto/emblem_SS.png"
											width="40">
										삼성 라이온즈</c:when>
									<c:when test="${vo.away eq 'nc'}">
										<img src="../../../resources/teamPhoto/emblem_NC.png"
											width="40">
										NC 다이노스</c:when>
								</c:choose>${vo.away_r}</td>
							<td
								style="border-right: 0.1px solid #FFFFFF; border-left: 0.1px solid #FFFFFF;">vs</td>
							<td>${vo.home_r}<c:choose>
									<c:when test="${vo.home eq 'doosan'}">
										두산 베어스<img src="../../../resources/teamPhoto/emblem_OB.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'kia'}">
										KIA 타이거즈<img src="../../../resources/teamPhoto/emblem_HT.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'lg'}">
										LG 트윈스<img src="../../../resources/teamPhoto/emblem_LG.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'hanhwa'}">
										한화 이글스<img src="../../../resources/teamPhoto/emblem_HH.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'lotte'}">
										롯데 자이언츠<img src="../../../resources/teamPhoto/emblem_LT.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'nexen'}">
										넥센 히어로즈<img src="../../../resources/teamPhoto/emblem_WO.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'sk'}">
										SK 와이번스<img src="../../../resources/teamPhoto/emblem_SK.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'kt'}">
										KT 위즈<img src="../../../resources/teamPhoto/emblem_KT.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'samsung'}">
										삼성 라이온즈<img src="../../../resources/teamPhoto/emblem_SS.png"
											width="40">
										</c:when>
									<c:when test="${vo.home eq 'nc'}">
										NC 다이노스<img src="../../../resources/teamPhoto/emblem_NC.png"
											width="40">
										</c:when>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${vo.stadium eq 'doosan 잠실야구장'}">
					잠실
					</c:when>
									<c:when test="${vo.stadium eq 'kia 광주기아챔피언스필드'}">
					광주
					</c:when>
									<c:when test="${vo.stadium eq 'lg 잠실야구장'}">
					잠실
					</c:when>
									<c:when test="${vo.stadium eq 'nc 마산야구장'}">
					창원
					</c:when>
									<c:when test="${vo.stadium eq 'sk 인천문학야구장'}">
					인천
					</c:when>
									<c:when test="${vo.stadium eq 'kt 수원야구장'}">
					수원
					</c:when>
									<c:when test="${vo.stadium eq 'nexen 고척스카이돔'}">
					고척
					</c:when>
									<c:when test="${vo.stadium eq 'hanhwa 대전한밭야구장'}">
					대전
					</c:when>
									<c:when test="${vo.stadium eq 'samsung 라이온즈파크'}">
					대구
					</c:when>
									<c:when test="${vo.stadium eq 'lotte 사직야구장'}">
					부산
					</c:when>

								</c:choose></td>
							<td>${vo.game_time}</td>
							<td>${vo.channel}</td>
							<td><a
								href="../../../test/list?home=${vo.home }&away=${vo.away }&year=${vo.year }&month=${vo.month }&day=${vo.day }&game_time=${vo.game_time }">경기정보</a></td>

						</tr>
					</c:when>
				</c:choose>
				<tr>

				</tr>
			</c:forEach>

		</table>
	</form>
</body>

</html>
