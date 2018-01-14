<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
.a td{
background-color: silver;
}
</style>
</head>
<body>
	<table border="1" width="100%">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>게시일자</td>
			<td>조회수</td>
		</tr>
		<c:if test="${data.dd.get(0).category1 != 'boardinfo' }">
	 		<c:forEach items="${data.dd2 }" var="vo2" varStatus="no">
				<tr class="a">
				<td align="center" >${fn:length(data.dd2)-no.index }</td> 
			<td><strong><a href="detail?boardid=${vo2.boardid}&nowPage=${data.nowPage}">${vo2.title }</a></strong></td>
			<td>${vo2.userid }</td> 
			<td>${vo2.regdate }</td> 
			<td>${vo2.cnt}</td>
			</tr>
			</c:forEach>
		</c:if>		
 			<c:forEach items="${data.dd}" var="vo" varStatus="no">
		<c:choose>
		<c:when test="${data.dd.get(0).category1 == 'boardinfo' }">
		<tr class="a">
		</c:when>
		<c:otherwise>
			<tr>
		</c:otherwise>
		</c:choose>
				<td align="center">${data.total-(data.startNum+no.index)+1} </td> 
				<td><a href="detail?boardid=${vo.boardid}&nowPage=${data.nowPage}">${vo.title }</a></td>
				<c:choose>
				<c:when test="${loginVo.userid eq null || loginVo.userid eq 'null' }">
				<td>${vo.userid }</td>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${loginVo.grade eq 'admin' }">
							<td><a href="../../../../baseball/pathInfo/manager/member/mailInsert?userid=${vo.userid }">${vo.userid }</a></td>
						</c:when>
						<c:otherwise>
							<td><a href="../../../../baseball/pathInfo/member/memberSub/mailInsert?userid=${vo.userid }">${vo.userid }</a></td>
						</c:otherwise>
					</c:choose>
					
				
				</c:otherwise>
				</c:choose>
				<td>${vo.regdate }</td>
				<td>${vo.cnt }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="center">
			<c:if test="${data.startPage > 1}">
					<a href="?nowPage=1">[처음으로]</a>
					<a href="nowPage=${data.startPage-1 }">&gt;</a>
				</c:if> 
				
				<c:forEach begin="${data.startPage }" end="${data.endPage }" var="i">
					<c:choose>
						<c:when test="${data.nowPage==i }"> [${i}]
					</c:when>
						<c:otherwise>
							<a href="?nowPage=${i }">${i }</a>
						</c:otherwise>
					</c:choose>
				</c:forEach> 
				<c:if test="${data.endPage<data.totalPage }">
					<a href="?nowPage=${data.endPage+1 }">></a>
					<a href="?nowPage=${data.totalPage }">[마지막으로]</a>
				</c:if></td>
		<tr>
		<c:choose>
		<c:when test="${loginVo.grade eq 'user' ||loginVo.grade eq 'admin'}">
			<td colspan="5" align="center"><a href="insertForm"> 글쓰기</a></td>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
			<!-- InsertForm으로 이동 -->
		</tr>
	</table>
</body>
</html>