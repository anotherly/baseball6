<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table width="100%" class="menu">
	<tr>
		<c:choose>
			<c:when test="${loginVo!=null }">
				<td width="60%"></td>
				<td>${loginVo.name }님환영합니다.</td>
				<td><a href="../../login/loginSub/logout" class="top_upper">로그아웃</a></td>
				<c:choose>
					<c:when test="${loginVo.grade ne 'admin' }">
						<td><a
							href="../../member/memberSub/detail?userid=${loginVo.userid }"
							class="top_upper">마이페이지</a></td>
					</c:when>
				</c:choose>
			</c:when>
			<c:otherwise>
				<td width="70%"></td>
				<c:forEach items="${data.loginMenu }" var="mm">
					<td align="right"><a href="../../${mm.name}/${mm.url }/first"
						class="top_upper">${mm.korName }</a></td>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tr>
	<tr align="right">
		<td colspan="5" align="center" >
		<a href="../../../../../../baseball/pathInfo/home/notice/first">
		<img src="../../../resources/homePhoto/kbologo.png" height=140 width="100%">
		</a></td>
	</tr>

</table>
