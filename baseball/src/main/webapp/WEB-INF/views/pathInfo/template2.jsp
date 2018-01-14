<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="../../../resources/css/layout.css?ver=1"> -->
<link rel="stylesheet" href="../../../resources/css/layout2.css?ver=1">
<script src="http://code.jquery.com/jquery-latest.min.js"
	type="text/javascript"></script>
<!-- <script src="../../../resources/js/common.js" type="text/javascript"> </script>-->
</head>
<body>
	<table border="" align="center" class="center_fixed">
		<colgroup>
			<col width="120px" />
			<col width="*" />
		</colgroup>
		
			<tr>
				<td colspan="2"><jsp:include page="inc/top_upper.jsp" /></td>
			</tr>
			<tr>
				<td colspan="2"><jsp:include page="inc/top_lower.jsp" /></td>
			</tr>
			<tr>
				<c:set var="name" value="${data.cate1}" />
				<c:choose>
					<c:when test="${name eq 'home' && data.service eq 'first'}">

					</c:when>
					<c:otherwise>
						<td class="hehehehehe"><jsp:include page="inc/sub.jsp" /></td>
					</c:otherwise>
				</c:choose>


				<c:set var="name" value="${data.cate2}" />
				<td align="center"><c:choose>
						<c:when
							test="${name eq 'stat' && data.service eq 'todayRegister'}">
							<jsp:include page="${data.cate1 }/${data.service }.jsp" />
						</c:when>
						<c:when
							test="${name eq 'statTeam' && data.service eq 'teamStatList'}">
							<jsp:include page="${data.cate1 }/${data.service }.jsp" />
						</c:when>
						<c:otherwise>
							<jsp:include page="${data.cate1 }/${data.serviceTemp }.jsp" />
						</c:otherwise>
					</c:choose></td>
			</tr>



			<tr>
				<td colspan="2"><jsp:include page="inc/bottom.jsp" /></td>
			</tr>
		
	</table>
</body>
</html>