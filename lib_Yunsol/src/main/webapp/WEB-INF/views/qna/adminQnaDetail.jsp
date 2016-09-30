<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"	uri = "http://java.sun.com/jsp/jstl/core" %>
<div>
	<h1 class="align-center">Q&A게시판</h1>
	<div class="table-responsive">
    	<table class="table table-striped">
    		
            <thead>
                <tr>
                   <th colspan="4">글 제목: ${qnaCommand.qna_title}</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                	<th>번호 : ${qnaCommand.qna_num}</th>
                    <th>작성자 : ${qnaCommand.mem_id}</th>
                    <th style="text-align:right;">등록날짜 : ${qnaCommand.qna_regdate}</th>
                    <th style="text-align:right;">조회수 : ${qnaCommand.qna_hit}</th>
                </tr>
                <tr>
                    <td colspan="4">
                    <br>
                    ${qnaCommand.qna_content}<br>
                    <br>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
	
  	<div align="right">
  	<input type="button" value="목록으로" onclick="location.href='list.do'" class="btn btn-sm btn-info">
  	<input type="button" value="삭제"
  			onclick="javascript:delete_event(${qnaCommand.qna_num});" class="btn btn-sm btn-danger">
  	</div>
  	<hr size="1" width="100%">
  	<p>
  	  	<br>
 	 	<br>                   		
  		
  	</p>
  	<hr size="1" width="100%">
  	<p class="align-right">
  		
  	</p>
  	
  	<!-- 답변 -->
  	<span class="reply title">답변 달기</span>
  	<form id="qre_form">
  		<input type="hidden" name="qna_num"  value="${qnaCommand.qna_num}" id="qna_num">
		<input type="hidden" name="mem_id" value="${userId}" id="userId"> 
			<textarea rows="3" name="qna_re_content" id="qna_re_content" maxlength="300" class="form-control"></textarea>  
	    	<div id="qre_first">
	    		<span class="letter-count">300/300</span>
	    	</div>
	    	<div id="qre_second" style="align:right;">
	    		<input type="submit" value="전송" class="btn btn-default">
	    	</div>
    </form>
              	
    <!-- 목록출력 -->
  	<div id="output"></div>
  	<div class="paging_button" style="display:none;">
  		<input type="button" value="다음글 보기">
  	</div>
  	<div id="loading" style="display:none;">
  	<img src="${pageContext.request.contextPath}/resources/user/images/ajax-loader.gif">
  	  	
  	</div>
  	
  	<!-- 댓글수정 -->
  	<div id="modify_div" style="display:none;">
		<form id="mqre_form">
			<input type="hidden" name="qna_re_num" id="mqna_re_num">
			<input type="hidden" name="mem_id" id="muserId">
			<textarea rows="3" cols="50" name="qna_re_content" id="mqna_re_content" class="a"></textarea>
			<div id="mqre_first">
				<span class="letter-count">300/300</span>
			</div>  
			<div id="mqre_second" class="align-right">
				<input type="submit" value="수정">
				<input type="button" value="취소" class = "re-reset">
			</div>
			<hr size="1" noshade width="96%">
        </form>
	</div>
              <!--============ 내용입력 끝===============-->


</div>