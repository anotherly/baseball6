<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<p class="kb">Stat Factory �α���</p>
<form action="loginCheck" method="post" style="
    padding-left: 260px; padding-right: 310px;">
${title }
	<table class="type04">
		<tr>
			<td class="test">���̵�</td>
			<td><input type="text" name="userid" /></td>
		</tr>
		<tr>
			<td class="test">��й�ȣ</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td colspan="2" align="left"><input class="button button4" type="submit" value="�α���" />
			<a href="../../home/notice/first" class="button button4">Ȩ����</a>
			<a href="findIdGo" class="button button4">ID ã��</a>
			<a href="findPWGo" class="button button4">PW ã��</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>