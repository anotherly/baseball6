<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

	<form action="card3" method="post">
	<!-- ������! -->
		<input type="hidden" value="${param.userid }" name="userid"/>
	<input type="hidden" value="${param.user_name }" name="user_name"/>
	<input type="hidden" value="${param.user_phone}" name="user_phone"/>
	<input type="hidden" value="${param.money }" name="money"/>
	<input type="hidden" value="${param.stadium }" name="stadium" />
			<input type="hidden" value="${param.match_year}" name="match_year"/>
<input type="hidden" value="${param.match_month}" name="match_month"/>
<input type="hidden" value="${param.match_day}" name="match_day"/>
			<input type="hidden" value="${param.price }" name="price"/>
	<!-- ����ġ! -->	
		<table border="1">
			<tr>
				<td colspan="2">�ſ�ī������</td>
			</tr>
			<tr>
				<td colspan="2"><input type="radio" checked="checked" disabled="disabled" />
					�Ϲݽſ�ī�� <select name="cardcompany" required="required">
						<option value='' selected>ī�������� �����ϼ���</option>
						<option value='��������'>��������</option>
						<option value='�泲����'>�泲����</option>
						<option value='�λ�����'>�λ�����</option>
				</select></td>
			</tr>
			<tr>
				<td>�����ݾ�</td>
				<td><input type="text" value="${param.money }"
					readonly="readonly" name="money" /></td>
			</tr>
			<tr>
				<td>�Һμ���</td>
				<td><select>
				<option value="�Ͻú�">�Ͻú�</option>
				</select>
				</td>
			</tr>

			<tr>
				<td colspan="2" align="right"><input type="submit" value="�����ܰ�" /></td>
			</tr>
		</table>

	</form>
