<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
/* 	function complete(){
 
		frm.action = "insertticket";
		frm.submit();
		 	alert('������ �Ϸ�Ǿ����ϴ�');
		 	self.close();
			window.opener.close();
	};
		 */
	/* function closewindow(){
 		if(confirm('������������ �����ðڽ��ϱ�?')){
			self.close();
			window.opener.close();
 		}
	} */
	
	function goSubmit() {
	    window.opener.name = "parent"; // �θ�â�� �̸� ����
	    document.frm.target = "parent"; // Ÿ���� �θ�â���� ����
 	    document.frm.action = "insertticket"; 
	    document.frm.submit();
	
	    self.close();
	}
	
</script><!-- 
window.onload = function() {
		alert("���Ű� �Ϸ�Ǿ����ϴ�."); 
	}; -->
</head>
<body>
	<form action="" method="post" name="frm">
		<input type="hidden" value="${param.userid }" name="userid"/>
		<input type="hidden" value="${param.user_name }" name="user_name"/>
		<input type="hidden" value="${param.user_phone}" name="user_phone"/>
		<input type="hidden" value="${param.money }" name="money"/>
		<input type="hidden" value="${param.stadium }" name="stadium" />
		<input type="hidden" value="${param.match_year}" name="match_year"/>
		<input type="hidden" value="${param.match_month}" name="match_month"/>
		<input type="hidden" value="${param.match_day}" name="match_day"/>	
		<input type="hidden" value="${param.price }" name="price"/>
		
		<table border=1>
			<tr>
				<td>�Ǹ���</td>
				<td>: (��) �������丮</td>
			</tr>
			<tr>
				<td>�ݾ�</td>
				<td>: ${param.money }</td>
			</tr>
			<tr>
				<td>����</td>
				<td>${param.match_year }�� ${param.match_month }�� ${param.match_day }��<br>
				${param.stadium } Ȩ ���</td>
			</tr>
			<tr>
				<td>ī���ȣ</td>
				<td><input type="text" name="12num"></td>
			<tr>
			</tr>
			<tr>
				<td colspan="2" align="right">('-'���� ī���ȣ�� �Է����ּ���.)</td>
			</tr>
			<tr align="center">
				<td colspan="3"><a href="card2">���</a>
<!-- <a href="javascript:complete()">���ſϷ�</a></td>
 -->	
 <input type="button" onclick="goSubmit()" value="���ſϷ�">
 		</tr>
		</table>
	</form>
</body>
</html>