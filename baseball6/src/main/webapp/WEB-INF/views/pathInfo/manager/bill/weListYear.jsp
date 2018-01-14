<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>

<body>

	<c:choose>
		<c:when test="${loginVo.grade ne 'admin' }">
			유효하지 않은 접근입니다.
		</c:when>
		<c:otherwise>

			<br>
			<table border="1" width="500px">
				<tr>
					<td align="center"><a href="weList" />일별 검색</td>
					<td align="center"><a href="weListM" />월별 검색</td>
					<td align="center"><a href="weListY" />연도별 검색</td>
				</tr>
			</table>
			<br>

			<form action="weListYear" method="get">
				<table border=1 width="600px">
					<tr>
						<c:forEach begin="0" end="1" var="i">
							<td colspan="4" align="center"><select
								name="list[${i }].year">
									<c:forEach items="${yearArr }" var="kk">
										<c:choose>
											<c:when test="${kk[1]==sch.list.get(i).kind }">
												<option value="${kk[1] }" selected="selected">${kk[1] }</option>
											</c:when>
											<c:otherwise>
												<option value="${kk[1] }">${kk[1] }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
							</select>년
						</c:forEach>
						<select name="list[${0 }].steam">
							<c:forEach items="${steamArr }" var="kk">
								<c:choose>
									<c:when test="${kk[1]==sch.list.get(i).kind }">
										<option value="${kk[1] }" selected="selected">${kk[1] }</option>
									</c:when>
									<c:otherwise>
										<option value="${kk[1] }">${kk[1] }</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>구장
						</td>
					</tr>
					<tr>
						<td colspan="5" align="center"><input type="submit"
							value="검색" /></td>
					</tr>
				</table>
			</form>


			<br>
			<table border="1" align="center">
				<tr>
					<td align="center">날짜</td>
					<td>구장명</td>
					<td>실 수익</td>
				</tr>
				<c:set var="income" value="0" />
				<c:set var="refund" value="0" />
				<c:set var="deposit" value="0" />
				<c:set var="withdraw" value="0" />
				<c:set var="home" value="0" />
				<c:set var="away" value="0" />
				<c:set var="kbo" value="0" />
				<c:set var="we" value="0" />
				<c:forEach items="${data.dd }" var="sta">
					<c:set var="income" value="${sta.income+income }" />
					<c:set var="refund" value="${sta.refund+refund }" />
					<c:set var="deposit" value="${sta.deposit+deposit }" />
					<c:set var="withdraw" value="${sta.withdraw+withdraw }" />
					<c:set var="home" value="${sta.home+home }" />
					<c:set var="away" value="${sta.away+away }" />
					<c:set var="kbo" value="${sta.kbo+kbo }" />
					<c:set var="we" value="${sta.we+we }" />
					<tr>
						<td>${sta.billdate }</td>
						<td align="center">${sta.stadium }</td>
						<td>${sta.we }</td>
					</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td>총합</td>
					<td>${we }</td>
				</tr>
			</table>
			<br>
		</c:otherwise>
	</c:choose>

</body>
</html>