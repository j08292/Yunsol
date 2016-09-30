
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>     
 <%@ taglib prefix = "c"	uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  


        <!-- Page Title(지우면안됨X) -->
        <section id="page-title">

            <div class="container clearfix">
                <h1><spring:message code="qna.write.title"/></h1>
                <span>Start Buying your Favourite Theme</span>
                <ol class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li class="active">Shop</li>
                </ol>
            </div>

        </section><!-- #page-title end -->

        <!-- Content(지우면안됨X)-->
        <section id="content">

            <div class="content-wrap">

                <div class="container clearfix">

                   <!-- ============ 내용입력 시작============ -->
                  
                   <div>
                   	<h2 class="align-center">${qnaCommand.qna_title}</h2>
                   	<ul style="list-style:none;">
                   		<li >번호 : ${qnaCommand.qna_num}</li>
                   		<li>ID : ${qnaCommand.mem_id}</li>
                   		<li>조회수 : ${qnaCommand.qna_hit}</li>
                   		<li>등록날짜 : ${qnaCommand.qna_regdate}</li>
                   		
                   		
                   	</ul>
                   	<hr size="1" width="100%">
                   	<p>
                  	 
                   	  	<br>
                  	 	<br>                   		
                   		${qnaCommand.qna_content}
                   		
                   	</p>
                   	<hr size="1" width="100%">
                   	
                   	<p class="align-right">
	                   	<input type="button" value="목록으로" class="btn btn-primary btn-sm"
	                   			onclick="location.href='qnaList.do?qna_num=${qnaCommand.qna_num}'">
                   		<c:if test="${!empty userId && userId == qnaCommand.mem_id}">
                   		
                   		<input type="button" value="수정" class="btn btn-default btn-sm"
                   			onclick="location.href='qnaUpdate.do?qna_num=${qnaCommand.qna_num}'">
                   		<input type="button" value="삭제" class="btn btn-default btn-sm"
                   			onclick="location.href='qnaDelete.do?qna_num=${qnaCommand.qna_num}'">
                   	</c:if>
                   	</p>
                   	<!-- 댓글 -->
                   	<span class="reply title">▶ 댓글 달기 </span>
                   	
                   	 	<br><br>
                   	<form id="qre_form">
                   		<input type="hidden" name="qna_num"  value="${qnaCommand.qna_num}" id="qna_num">
					    <input type="hidden" name="mem_id" value="${userId}" id="userId"> 
					    <textarea rows="3" cols="50" name="qna_re_content" class="content"
					    id="qna_re_content" maxlength="300" class="a"
					    <c:if test="${empty userId && mem_level ==2}">disabled="disabled"</c:if>
					    ><c:if test="${empty userId }"></c:if><c:if test="${mem_level != 2}">관리자만 작성할 수 있습니다.</c:if></textarea>  
					    <c:if test="${!empty userId && mem_level == 2}">
					    	<div id="qre_first">
					    		<span class="letter-count">300/300</span>
					    	</div>
					    	<div id="qre_second" class="align-right">
					    		<input type="submit"  class="btn btn-default btn-sm" value="전송">
					    	</div>
					</c:if>            	
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
                   	 	<textarea rows="3" cols="50" name="qna_re_content"
                   	 	id="mqna_re_content" class="a"></textarea>
                   	  	<div id="mqre_first"><span class="letter-count">300/300</span></div>  
						<div id="mqre_second" class="align-right">
							<input type="submit" class="btn btn-default btn-sm" value="수정">
							<input type="button" value="취소" class ="btn btn-danger btn-sm, re-reset">
						</div>
						<hr size="1" noshade width="96%">
                   	</form>
                   	</div>
                   </div> 	
                   	
                   	
                    <!--============ 내용입력 끝===============-->

                </div>

            </div>

        </section>
        <!-- #content end -->