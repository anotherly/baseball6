<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<script type="text/javascript">
function fileDelete(){
	if(confirm("������ �����Ͻðڽ��ϱ�?"))
	{
		fmt.action="fileDelete"
		fmt.submit()
	}
	
}
</script>

</head>
<body>
<form action="modifyGo" method="post" enctype="multipart/form-data" name="fmt">
	<input type="hidden" value="${data.dd.boardid }" name="boardid" width="100%" />
		<table border="1">
			<tr><td>���̵�</td>
			<td><input type="text" name="userid" value="${data.dd.userid }" readonly="readonly"></td></tr>
			<tr><td>����</td>
			<td><input type="text" name="title" value="${data.dd.title }"></td></tr>
			<tr>
				<td>����</td>
				<td><textarea name="content" cols="40" rows="8">${data.dd.content }</textarea></td>
			</tr>
			<tr><td>�ۼ���</td>
			<td><input type="text" name=regdate value="${data.dd.regdate }" readonly="readonly"></td></tr>
			<tr><td>����</td>
			<td><c:choose>
			<c:when test="${data.dd.sysname!=null && data.dd.sysname!='null'}">
				<input type="hidden" name="sysname" value="${data.dd.sysname }" />	
				<a href="javascript:fileDelete();">���ϻ���</a>
			</c:when>
			<c:otherwise>
				<input type="file" name="file" />
			</c:otherwise>
		</c:choose>	
			
			<tr>
			<td colspan="2" align="center">
				<input type="submit" value="����" />
				<a href="detail?boardid=${data.dd.boardid }">�ڷΰ���</a>
			</td>
			</tr>
		</table>
	</form>
</body>
</html>