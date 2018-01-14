<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="sub" width="10">
	<c:forEach items="${data.subMenu }" var="mm">
		<c:choose>
			<c:when test="${loginVo.grade ne 'admin'}">
				<c:choose>
					<c:when test="${mm.korName eq '기록 입력/수정'||mm.korName eq '경기일정등록'}">
						<tr>
							<td align="center" width="10"></td>

						</tr>
					</c:when>
					<c:otherwise>
						<ul width="10">
							<li width="10"><c:choose>
									<c:when test="${mm.korName eq '쪽지함' }">
										<a href="../${mm.name}/${mm.url }?userid=${loginVo.userid }">${mm.korName }</a>
									</c:when>
									<c:otherwise>
										<a href="../${mm.name}/${mm.url }">${mm.korName }</a>
									</c:otherwise>
								</c:choose>
							</li>
						</ul>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<tr>
					<td align="center" width="10">
						<ul width="10">
							<li width="10"><c:choose>
									<c:when test="${mm.korName eq '쪽지함' }">
										<a href="../${mm.name}/${mm.url }?userid=${loginVo.userid }">${mm.korName }</a>
									</c:when>
									<c:otherwise>
										<a href="../${mm.name}/${mm.url }">${mm.korName }</a>
									</c:otherwise>
								</c:choose></li>
						</ul>
					</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</table>