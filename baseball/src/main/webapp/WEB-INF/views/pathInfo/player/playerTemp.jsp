<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<table style="background-color: #ffa" width="100%">


	<tr>

		<%-- <c:when test="${data.topMenu2.url eq 'stat' }">

		</c:when>
		<c:otherwise> --%>
			<td><c:forEach items="${data.topMenu2 }" var="mm">
					<c:choose>
						<c:when test="${mm.url eq 'blist' }">
							<a href="../../${mm.name}/${mm.url }/bList?year=2018">${mm.korName }</a>
						</c:when>
						<c:when test="${mm.url eq 'dlist' }">
							<a href="../../${mm.name}/${mm.url }/dList?year=2018">${mm.korName }</a>
						</c:when>
						<c:otherwise>
							<a href="../../${mm.name}/${mm.url }/list?year=2018">${mm.korName }</a>
						</c:otherwise>
					</c:choose>
				</c:forEach></td>
		<%-- </c:otherwise> --%>


	</tr>
	<tr>

		<td><jsp:include page="${data.service }.jsp" /></td>

	</tr>


</table>
