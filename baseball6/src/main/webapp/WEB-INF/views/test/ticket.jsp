<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
.pp{
	font-family:'Jeju Myeongjo', serif;
	font-size:20px;
		color: #004080;
			text-decoration:none;
			font-weight:bold;
}
.seat{
	font-family:'Jeju Myeongjo', serif;
	font-size:20px;
		color:red;
			text-decoration:none;
			font-weight:bold;
}

</style>

</head>
<body>	
	<form action="cnt" method="post" > <!-- Ƽ�� �� �� ����ȭ��. -->
		<input type="hidden" value="${data.dd.match_year }" name="match_year"/>
		<input type="hidden" value="${data.dd.match_month }" name="match_month"/>
		<input type="hidden" value="${data.dd.match_day }" name="match_day"/>
		<input type="hidden" value="${param.userid }" name="userid"/>
		<input type="hidden" value="${param.stadium }" name="stadium"/>
		<input type="hidden" value="${param.seat }" name="seat"/>
		<table border="1">
			<tr>
<td><p class="pp">${param.stadium }����</p></td><td><p class="seat">${param.seat}</p></td>
	</tr><tr>
				<td colspan="2">
				Ƽ�� �� ���� �����ϼ���
					<select name="cnt" id="cnt">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="�����ܰ�"/></td>
			</tr>
		</table>
	</form>
</body>
</html>