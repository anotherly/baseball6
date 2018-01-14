 <%@page import="baseball.ticket.model.TicketVo"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set value="${ paramValues.chk}" var="abc" />
<% int a = 0;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title> 
<style type="text/css">
.kb{
font-family:'Jeju Myeongjo', serif;
	font-size:30px;
		color: #004080;
			text-decoration:none;
}
.a{
width:25px;
}
.b{
width:25px;
}
.c{
width:25px;
}
.d{
width:50px;}
.e{
width:50px;}
.mo{
color:red;}
.ney{
font-family:'Jeju Myeongjo', serif;
	font-size:30px;
		color: black;
			text-decoration:none;
}
hr { border-top:1px solid #9C9C9C; border-bottom:1px solid #F6F6F6; }
</style>
<script type="text/javascript">
		window.resizeTo(826,386); 

		function pay(){
		var newwin = window.open('_blank','winname','width=565, height=300');
		var fr = document.frm;
		fr.action = "card";
		frm.target= 'winname';
		frm.submit();
	 	/* window.opener.close();  */
		
		}; 

		
</script>
</head>
<body>

	<p class="kb"> 선택하신 티켓 정보 :</p>

	<form action="insertticket" method="post" name="frm">
		<input type="hidden" value="${param.userid }" name="userid"/>
		<input type="hidden" value="${param.stadium }" name="stadium" />
		<input type="hidden" value="${param.match_year}" name="match_year"/>
		<input type="hidden" value="${param.match_month}" name="match_month"/>
		<input type="hidden" value="${param.match_day}" name="match_day"/>
		
		<c:forEach items="${abc}" var="i" varStatus="num">
		
			<c:set value="${param.stadium }" var="stadium" />
			<c:set value="${param.seat }" var="seat" />
			<c:set value="${param.stadium }${i }${param.seat }" var="ticketinfo" />
			<c:set value="${i.substring(0,1) }" var="listt" />
			<c:set value="${i.substring(1) }" var="line" />

			<c:set value="${ticketinfo}" var="ticketinfo" />
			<c:set value="${listt}" var="listt" />
			<c:set value="${line}" var="line" />
			<c:set value="${seat}" var="seat" />
			<c:set value="${stadium}" var="stadium" />
			
			티켓 번호 : <input type="text" value="${ticketinfo }"
				name="reallist[${ num.index}].ticketinfo" />
			행 : <input class="a" type="text" value="${listt}"
				name="reallist[${ num.index}].listt" />
			열 : <input class="b" type="text" value="${line}"
				name="reallist[${ num.index}].line" />
			등급 : <input class="c" type="text" value="${seat}"
				name="reallist[${ num.index}].seat" />
			구장 : <input class="d" type="text" value="${stadium}"
				name="reallist[${ num.index}].stadium" />
			티켓 가격 : <input class="e" width="100px"type="text" value="${data.dd.price }"
				name="reallist[${ num.index}].price" />
			
			<br>

		</c:forEach>
		<hr>
		<p class="ney">금액:
		<c:choose>
			<c:when test="${param.seat eq 'b1' }">]${param.cnt * 15000 }
			<input type="hidden" value="${param.cnt * 15000 }" name="money" />
			</c:when>
			<c:when test="${param.seat eq 'b2' or param.seat eq 'b3' }">
			${param.cnt * 12000 }
			<input type="hidden" value="${param.cnt * 12000 }" name="money" />
			</c:when>
			<c:when test="${param.seat eq 'b4' or param.seat eq 'b5'}">
			${param.cnt * 10000 }
			<input type="hidden" value="${param.cnt * 10000 }" name="money" />
			</c:when>
			<c:when test="${param.seat eq 'b6' or param.seat eq 'b7'}">
			${param.cnt * 8000 }
			<input type="hidden" value="${param.cnt * 8000 }" name="money" />
			</c:when>
		</c:choose>원
	</p>
		<p class="kb">예매하시겠습니까 ? <a href="javascript:pay()">결제하기</a></p> 
	</form>
</body>
</html>