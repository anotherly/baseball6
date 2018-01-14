<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<style type="text/css">
.titi{
font-size:20px;
}
.titi .ketket{
font-family:'Jeju Myeongjo', serif;
	font-size:20px;
		color: #004080;
			text-decoration:none;
}
.tab_con{
font-size:15px;
color:black;
}



</style>
</head>

<body>
	<form action="cnt" method="post" class="titi"> <!-- ticket으로 이동합니다. -->
	
	<!-- 병화형님 value에다가 형이 넘겨주신방식으로 넣으시면됩니다 -->
	<input type="hidden" value="${param.home }" name="stadium"/>
	<input type="hidden" value="${param.year }" name="match_year"/>
	<input type="hidden" value="${param.month }" name="match_month"/>
	<input type="hidden" value="${param.day }" name="match_day"/>
	<!--  여기까지     -->
	
	<span class="ketket">${param.home } 홈 구장 ${param.year }년 ${param.month}월 ${param.day }일 경기</span>
	<input type="hidden" value="${loginVo.userid }" name="userid"/>
	
		<table border=1 class="type04">
			<tr>
				<td>
				<div class="tab_con b0" id="b0" style="display: block;"><img src="../resources/img/All.png" alt="모든구역"/></div>
				<div class="tab_con b1" id="b1" style="display: none"><img src="../resources/img/VIP.png" alt="VIP구역" /></div> 
				<div class="tab_con b2" id="b2" style="display: none;"><img src="../resources/img/R-1.png" alt="R-1구역"/></div> 
				<div class="tab_con b3" id="b3" style="display: none;"><img src="../resources/img/R-2.png" alt="R-2구역"/></div> 
				<div class="tab_con b4" id="b4" style="display: none;"><img src="../resources/img/S-1.png" alt="S-1구역"/></div> 
				<div class="tab_con b5" id="b5" style="display: none;"><img src="../resources/img/S-2.png" alt="S-2구역"/></div> 
				<div class="tab_con b6" id="b6" style="display: none;"><img src="../resources/img/A-1.png" alt="A-1구역"/></div> 
				<div class="tab_con b7" id="b7" style="display: none;"><img src="../resources/img/A-2.png" alt="A-2구역"/></div> 
				</td>
				
				<td>
					<p id="tabid"> <!-- 사진과 구역선택하는 라디오 버튼을 연결 -->
					 <input type="radio" name="seat" value="b1" id="VIP"><label for="VIP">VIP구역 - 15000원</label><br>
					 <input type="radio" name="seat" value="b2" id="R1"><label for="R1">R-1구역 - 12000원</label><br>
					 <input type="radio" name="seat" value="b3" id="R2"><label for="R2">R-2구역 - 12000원</label><br>
					 <input type="radio" name="seat" value="b4" id="S1"><label for="S1">S-1구역 - 10000원</label><br>
					 <input type="radio" name="seat" value="b5" id="S2"><label for="S2">S-2구역 - 10000원</label><br>
					 <input type="radio" name="seat" value="b6" id="A1"><label for="A1">A-1구역 - 8000원</label><br>
					 <input type="radio" name="seat" value="b7" id="A2"><label for="A2">A-2구역 - 8000원</label><br>
					</p><span>티켓 매 수:<select name="cnt" id="cnt">
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
					</span>
					<p align="center"><input type="submit" value="다음으로"/></p>
				</td>
			</tr>
		</table>
	</form>

	<script type=text/javascript>  
	  /* $('#tabid a').on('click',function(){
		    var _this = $(this);
		    var tab_con = $('.tab_con');
	
		    _this.siblings().removeClass('on');
		    _this.addClass('on');
		    tab_con.css('display','none');
		    $('.tab_con.'+_this.attr('href')).css('display','block');
		    return false;
		}); */
		
	  $('#tabid input[type=radio]').on('click',function(){
		 
		    var _this = $(this);
		    var tab_con = $('.tab_con');
		    _this.siblings().removeClass('on');
		    _this.addClass('on');
		    tab_con.css('display','none'); 
		    $('.tab_con.'+_this.attr('value')).css('display','block');
		    _this.checked = true;
		}); /* 선택함과 동시에 클릭한 라디오 버튼의 value로 display block을 설정 */
	</script>
 </body>
</html>