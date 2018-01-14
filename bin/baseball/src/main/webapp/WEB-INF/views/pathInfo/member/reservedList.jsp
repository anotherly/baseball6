<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">


$(document).on("click",".btn",function(){  
   var btn = $(this);
   var tr = btn.parent().parent();
   var td = tr.children();

   var res = confirm(td.eq(1).text()+'-'+td.eq(2).text()+'-'+td.eq(3).text()+'���� \n\r'+
      td.eq(4).text()+'Ȩ ���� ����Դϴ�.\r\n'+td.eq(5).text()+'����'+
      td.eq(6).text()+'��'+td.eq(7).text()+'�� �¼� ���Ÿ� ����Ͻðڽ��ϱ�?');
      
   if(res){
      

var $form = $('<form></form>');

$form.attr('action', 'cancel');
$form.attr('method', 'post');
$form.appendTo('body');
var example_1 = $('<input type="hidden" value="'+td.eq(8).text()+'" name="ticketinfo">'); 
var example_2 = $('<input type="hidden" value="'+td.eq(3).text()+'" name="match_day">'); 
var example_3 = $('<input type="hidden" value="'+td.eq(9).text()+'" name="price">'); 
var example_4 = $('<input type="hidden" value="'+td.eq(1).text()+'" name="match_year">'); 
var example_5 = $('<input type="hidden" value="'+td.eq(2).text()+'" name="match_month">'); 
var example_6 = $('<input type="hidden" value="'+td.eq(3).text()+'" name="match_day">'); 

$form.append(example_1);
$form.append(example_2);
$form.append(example_3);
$form.append(example_4);
$form.append(example_5);
$form.append(example_6);
$form.submit();
alert('���Ű� ��ҵǾ����ϴ�.');
   }else{
   }
});
      

</script>

</head>
<body>
<c:set var="now" value="<%=new java.util.Date()%>" />
<c:set var="sysYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>
<c:set var="sysMonth"><fmt:formatDate value="${now}" pattern="MM" /></c:set>
<c:set var="sysDay"><fmt:formatDate value="${now}" pattern="dd" /></c:set>
<c:set var="fullNow"><fmt:formatDate value="${now }" pattern="yyyyMMdd"/></c:set>
<c:out value="${sysYear}" /> - <c:out value="${sysMonth }"/> - <c:out value="${sysDay }" /> �� �Դϴ�.
ȯ�ҽ� ���ǻ���<br>
1. ȯ���� ������ ��¥�� �����۽ð� +24h �Դϴ�.<br>
2. ȯ�� �� ȯ�Ҽ����ᰡ �ΰ��˴ϴ�.<br>
   - 2~3�� �� : ȯ�Ҽ����� ����.<br>
   - 1~2�� �� : ȯ�Ҽ����� 10%.<br>
   - �������� ~ 1�� �� : ȯ�Ҽ����� 20%. <br>
   - ������ �� : ȯ�Ҽ����� 100%. <br>


   <table border="1" width="100%" id="tbl">
      <tr align="center">
         <td>��ȣ</td>
         <td>����</td>
         <td>��</td>
         <td>��</td>
         <td>����</td>
         <td>����</td>
         <td>��</td>
         <td>��</td>
         <td>Ƽ��</td>
         <td>����</td>
         <td>��������</td>
         <td>ȯ������</td>
         
      </tr>
      <c:forEach items="${data.dd }" var="i" varStatus="no">

      <c:if test="${i.cancel }">
         <tr align="center">
            <td>${no.index+1 }</td>
            <td>${i.match_year }</td>
            <td>${i.match_month }</td>
            <td>${i.match_day }</td>
            <td>${i.stadium }</td>
            <td>${i.seat }</td>
            <td>${i.listt }</td>
            <td>${i.line }</td>
            <td>${i.ticketinfo }</td>
            <td>${i.price }</td>
            <td>
            <c:choose>
                  <c:when test="${i.paid eq 1}">
            �����Ϸ�
            </c:when>
                  <c:otherwise>
            �������
            </c:otherwise>
               </c:choose></td>
            <c:choose>
                 <c:when test="${i.cancel && i.paid eq 1}">
               <td>
                  <input type="button" value="�������" 
                  class="btn" />
                   </td>

                  </c:when>
                  <c:otherwise>
                  <td>��ҺҰ�</td>
                  </c:otherwise>
               </c:choose>
         </tr>
   </c:if>
      </c:forEach>
   </table>
</body>
</html>