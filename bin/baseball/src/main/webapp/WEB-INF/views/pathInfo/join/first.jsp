<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.regex.Matcher"%>
<%@ page import="java.util.regex.Pattern"%>

	<p class="kb">Stat Factory ȸ������ </p>
	<span class="notnull" id="alarm">*�� �ִ� �������� ����� ������</span>
	<form action="join" enctype="multipart/form-data" method="post">
		<table width="80%" class="type04 aa">
			<tr>
				<td class="test"><span class="notnull">*</span>���̵�</td>
				<td>
				<input placeholder="���̵�" type="text" name="userid"  id="userid" maxlength="12"> 
				<input class="button button4" type="button" value="�ߺ�Ȯ��" id="uidBtn" required="required"/></td>
			</tr>
			<tr>
				<td class="test"><span class="notnull">*</span>�г���</td>
				<td colspan="2"><input placeholder="�г���" type="text" id="nick" name="nick"required="required"></td>
			</tr>
			<tr>
				<td class="test"><span class="notnull">*</span>��й�ȣ</td>
				<td colspan="2"><input placeholder="��й�ȣ" required="required" type="password" name="password" id="password" onchange="samepassword()"></td>
				
			</tr>
			<tr>
				<td class="test"><span class="notnull">*</span>��й�ȣ Ȯ��</td>
				<td><input type="password" placeholder="��й�ȣ Ȯ��"  name="confirm" required="required"id="confirm" onchange="samepassword()"><br>
				<span id = "res" ></span></td>
			</tr>
			<tr>
				<td class="test"><span class="notnull">*</span>�̸�</td>
				<td colspan="2"><input required="required" placeholder="�̸�" type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td class="test"><span class="notnull">*</span>����</td>
				<td><input type="file" name="file" id="file" required="required"></td>
			</tr>
			<tr>
				<td class="test"><span class="notnull">*</span>�������</td>
				<td><input type="date" min="1900-01-01" max="2015-12-31" name="birth" id="birth" required="required" ></td>
			</tr>
			<tr>
				<td>�ּ�</td>
				<td colspan="2"><input placeholder="�ּ�" type="text" name="address" id="address"></td>
			</tr>
			<tr>
				<td>�޴���</td>
				<td colspan="2"><input placeholder="�޴���" type="text" name="phone" id="phone"></td>
			</tr>
			<tr>
				<td>���ŵ���</td>
				<td colspan="2"><input type="radio" name="receivemail"
					value="����" checked="checked">���� <input type="radio"
					name="receivemail" value="�ź�">�ź�</td>
			</tr>
			<tr>
				<td>��ȣ����</td>
				<td colspan="2"><select name="preferTeam">
						<option value="lgtwins">LGƮ����</option>
						<option value="ncdinos">NC���̳뽺</option>
						<option value="kiatigers">���Ÿ�̰���</option>
						<option value="samsunglions">�Ｚ���̿���</option>
						<option value="doosanbears">�λ꺣�</option>
						<option value="hanhwaeagles">��ȭ�̱۽�</option>
						<option value="ktwiz">KT����</option>
						<option value="nexenheroes">�ؼ��������</option>
						<option value="skwyverns">SK���̹���</option>
						<option value="lottegiants">�Ե����̾���</option>
				</select></td>
			</tr>

			<tr>
				<td colspan="2" align="center" class="btns" >
					<input class="button button4" type="button" id="submit" disabled="disabled" value="ȸ�� ����" />
					<a href="../../../../baseball/pathInfo/home/notice/first" class="button button4">��������</a>
				</td>
			</tr>
		</table>
	</form>
