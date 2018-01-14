/**
 * 
 */

var count1 = 0;
var count2 = 0;

$(document).ready(function(){
   $(".input").bind("keyup", function() {
       if (!(event.keyCode >= 37 && event.keyCode <= 40)) {
          var inputVal = $(this).val();
          $(this).val(inputVal.replace(/[^a-z0-9]/gi, ''));
       }
    });
   
     function ajaxGo(vv){
       $.ajax({
         url:'../idChk',
         type:'POST',
         data:{userid:vv},
         success:function(data){
            if($.trim(data)==0){
               if(confirm('사용가능한 아이디입니다.\r사용하시겠습니까?')){
                  $("#userid").attr("readonly","readonly");
                  count1=1;
                  if(count1==1&&count2==1){
                     $("#submit").attr("disabled", false);
                        $("#submit").attr("type","submit");
                  }
               }else{}
            }else{
            alert("중복된 아이디입니다.");
               $("#userid").val("");
            } 
         }
      }); 
   }
      $("#uidBtn").click(function(){
         var vv = $("#userid").val();
         if(vv.length>=6){
            ajaxGo(vv);               
         }else{
            alert('아이디가 너무 짧습니다.');
         }
      });
      
      $('.btn_pop').click(function(){
         $(".bx_pop").fadeToggle();
      });
      

   }); 
   
function samepassword(){
   if(document.getElementById('password').value.length<6){
      document.getElementById('res').innerHTML = '6자리 이상 비밀번호를 입력해주세요.';
   }else{
      document.getElementById('res').innerHTML = '';
   }
      if(document.getElementById('password').value!=''&& document.getElementById('confirm').value !=''){

         if(document.getElementById('password').value == document.getElementById('confirm').value){
         document.getElementById('res').innerHTML = '비밀번호가 일치합니다.';
         document.getElementById('res').style.color='black';
         count2=1;
         if(count1==1&&count2==1){
            $("#submit").attr("disabled", false);
             $("#submit").attr("type","submit");
         }
      }else{
         document.getElementById('res').innerHTML = '비밀번호가 일치하지 않습니다.';
         document.getElementById('res').style.color='red';
         count2=0;
      }
   }
}

   
   