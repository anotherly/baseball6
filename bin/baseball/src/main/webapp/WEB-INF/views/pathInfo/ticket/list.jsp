<%@page import="org.springframework.web.util.UrlPathHelper"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${loginVo.grade eq 'user' || loginVo.grade eq 'admin' }">
		
<a href= "../../../../../../baseball/pathInfo/schedule/notice/list">예매하러가기</a>
</c:when>
<c:otherwise>
<script type="text/javascript">
function needlogin(){
      alert("비회원 또는 블랙회원은 이용하실 수 없습니다.");
      window.location = "../../../../../baseball/pathInfo/login/loginSub/first";
  }
needlogin();
  </script>
</c:otherwise>
</c:choose>
</body>
</html>