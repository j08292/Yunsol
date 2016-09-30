function initAdminReplyList(event_num){
   location.href="detail.do?event_num="+event_num;
}

$(document).ready(function(){
   var cuttentPage;
   var count;
   var rowCount;
   //댓글목록
   function selectData(pageNum,event_num){
      currentPage = pageNum;
      
      if(pageNum == 1){
         //처음 호출시는 해당 ID의 div의 내부 내용을 제거
         $('#output').empty();
      }
      //로딩 이미지 노출
      $('loading').show();
      
      //댓글 목록 Ajax
      $.ajax({
         type:'post',
         data:{pageNum:pageNum, event_num:event_num},
         url:'listReplyAjax.do',
         datatype:'json',
         cache:false,
         timeout:30000,
         success:function(data){
            //로딩이미지 감추기
            $('#lodaing').hide();
            count = data.count;
            rowCount = data.rowCount;
            var list = data.list;
            
            if(count < 0 || list == null){
               alert('목록 호출 오류 발생');
            }else{
               $(list).each(function(index,item){
                  var output = '';
                  output += '<div class="item" id="i'+item.event_re_num+'">';
                  output += '<h4>' + item.mem_id + '</h4>';
                  output += '<div class="sub-item">';
                  output += '<p>' + item.event_re_content + '</p>';
                  output += '<div>' + item.event_re_date;
                  output += ' <input type="button" data-num="'+item.event_re_num+'" data-id="'+item.mem_id+'" class="delete_button btn btn-xs btn-danger" value="삭제">';
                  output += '<hr size="1" noshade>';
                  output += '</div>';
                  output += '</div>';
                  output += '</div>';
                  
                  //문서 객체에 추가
                  $('#output').append(output);
               });
               
               //paging button처리
               if(currentPage>=Math.ceil(count/rowCount)){
                  //다음 페이지가 없음
                  $('.paging_button').hide();
               }else{
                  //다음 페이지가 있음
                  $('.paging_button').show();
               }
            }
         },
         error:function(){
            //로딩 이미지 감추기
            $('#loading').hide();
            alert('네트워크 오류 발생');
         }
      });
   }
   
   //다음 댓글 보기 버튼 클릭시 데이터 추가
   $('.paging_button input').click(function(){
      var pageNum = currentPage + 1;
      selectData(pageNum,$('#event_num').val());
   });
   
   
   // 댓글 삭제
   $(document).on('click', '.delete_button', function(){
      // 댓글 번호
      var event_re_num = $(this).attr('data-num');
      //작성자 아이디
      var mem_id = $(this).attr('data-id');
      
      $.ajax({
         type:'post',
         data:{event_re_num:event_re_num, mem_id:mem_id},
         url:'deleteReplyAjax.do',
         dataType:'json',
         cache:false,
         timeout:30000,
         success:function(data){
            alert('삭제 완료!');
            initAdminReplyList($('#event_num').val());            
         },
      error:function(){
         alert('네트워크 오류발생');
      }
   });
   });
   //초기 데이터(목록) 호출
   selectData(1,$('#event_num').val());
});

function delete_event(event_num){
   if (confirm("정말 삭제하시겠습니까?") == true) { //확인
      location.href='detailDelete.do?event_num='+ event_num;
   }else{
      return;
   }
}