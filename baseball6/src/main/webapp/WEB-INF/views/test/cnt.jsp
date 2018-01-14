<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" 
	type="text/javascript" ></script>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">/* ���ð����¼�/ ������ �¼�/ ���� �Ұ� �¼� css */
	input[type=checkbox] {
		display: none;
	}
	
	input[type=checkbox]+label {
		display: inline-block;
		cursor: pointer;
		line-height: 22px;
		padding-left: 22px;
		background: url(../resources/img/empty.JPG) left/22px no-repeat;
	}
	
	input[type=checkbox]:checked+label {
		background-image: url(../resources/img/selected.JPG);
	}
	
	input[type=checkbox]:disabled+label {
		background-image: url(../resources/img/blocked.JPG);
	}
	
	.kb{
font-family: 'Jeju Myeongjo', serif;
	font-size:50px;
	text-align: center;
	}
	
	.bt{
	}
</style>

<script>
	
	function count_ck(obj) {
		var chkbox = document.getElementsByName("chk");
		var chkCnt1 = 0;
		for (var i = 0; i < chkbox.length; i++) {
			if (chkbox[i].checked) {
				chkCnt1++; //���� DB�� ����Ǿ��ִ� �¼��� ������ ���ؼ� ���Ѵ�.
			}
		}

		if ((chkCnt1) == "${param.cnt}") { 
			$(":submit:not(:checked)").removeAttr("disabled", false);
		} else if ((chkCnt1) < "${param.cnt}") {
			$(":submit").attr("disabled", true);
		} else if ((chkCnt1) > "${param.cnt}") {
			alert("���ð����� �¼������� �ʰ��Ͽ����ϴ�.");
			obj.checked = false;
			return false; 
		} //�¼� ���ð����� �������� �Ѿ�� ��ư�� Ȱ��/��Ȱ��ȭ.


	}
</script>
</head>
<body>
	<!-- VIP�¼� - 15000�� / 
		R-1/2 - 12000�� / 
		S-1/2 - 10000�� / 
		A-1/2 - 8000�� -->
	
	<form action="checkTest" method="post"> <!-- checkTest�� �̵� -->
		<c:set value="${param.seat eq 'b1'?15000:
				param.seat eq 'b2' or param.seat eq 'b3'?12000:
				param.seat eq 'b4' or param.seat eq 'b5'?10000:8000}" var="price"/>
			
			<p class="kb"> �¼��� �����ϼ���</p>
		<input type="hidden" value="${price}" name="price" /> 
		<input type="hidden" value="${param.match_year}" name="match_year" /> 
		<input type="hidden" value="${param.match_month}" name="match_month" /> 
		<input type="hidden" value="${param.match_day}" name="match_day" />
		<input type="hidden" value="${param.userid }" name="userid" /> 
		<input type="hidden" value="${param.stadium }" name="stadium" /> 
		<input type="hidden" value="${param.cnt }" name="cnt" /> 
		<input type="hidden" value="${param.seat }" name="seat" />
		<table>

			<c:forEach begin="0" end="9" var="j" varStatus="g">
				<tr>
					<c:set
						value="${g.index eq 0 ?'A':g.index eq 1?'B': g.index eq 2?'C':g.index eq 3 
					?'D':g.index eq 4 ?'E':g.index eq 5 ?'F':g.index eq 6 ?'G':g.index eq 7?'H':g.index eq 8?'I':'J'}"
						var="c" />
					<td><c:out value="${c }" /></td>
					<c:forEach begin="1" end="20" var="i" varStatus="h">
						<td><input type="checkbox" id="${g.index*20+h.index}"
							name="chk" onClick="count_ck(this);"
							value="${c }${g.index*20+h.index }" /> <label
							for="${g.index*20+h.index}"> ${c }${g.index*20+h.index }</label></td>
					</c:forEach>
				</tr> <!-- 10�� 20�� �¼� ȭ��ܿ� �ѷ��ֱ� -->
			</c:forEach>
				<tr>
					<td>
					</td>
				</tr>
			<c:forEach items="${data.dd}" var="filled">
				<c:set var="asd" value="${filled.listt }${filled.line }" />
				
				<script> /* �ش� ����,����, �¼� ������ ������ ��ư ��Ȱ���� */
					var checked = document.getElementsByName("chk");
					for (var i = 0; i < 200; i++) {
						if (checked[i].value == "${asd}"
								&& "${filled.stadium}" == "${param.stadium}"
								&& "${filled.seat}" == "${param.seat}"
								&& "${filled.match_year}" == "${param.match_year}"
								&& "${filled.match_month}" == "${param.match_month}"
								&& "${filled.match_day}" == "${param.match_day}") {
							checked[i].disabled = true;
						}
					}
				</script>
			</c:forEach>
			<tr>
				<td class="bt"><input type="submit" value="��������" disabled="disabled" /></td>
			</tr>
		</table>
	</form>

</body>
</html>