<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%System.out.println("템플레이트 3.jsp");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="../../../resources/css/layout.css?ver=1">
<link rel="stylesheet" href="../../../resources/css/layout2.css?ver=1">
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script src="../../../resources/js/common.js"  type="text/javascript"></script>
</head>
<body>
	<table border="" align="center" class="center_fixed">
		<colgroup>
			<col width="250px"/>
			<col width="*"/>
		</colgroup>
		<tbody>
		<tr>
			<td colspan="2"><jsp:include page="inc/top_upper.jsp" /></td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="inc/top_lower.jsp" /></td>
		</tr>
		<tr>
			<td class="meme"><jsp:include page="inc/sub.jsp" /></td>
			<td align="center">
			<jsp:include page="manager/${data.cate2 }/${data.service }.jsp" /></td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="inc/bottom.jsp" /></td>
		</tr>
		</tbody>
	</table>
</body>
</html>