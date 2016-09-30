<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>     
 <%@ taglib prefix = "c"	uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

        <!-- Page Title(지우면안됨X) -->
        <section id="page-title">

            <div class="container clearfix">
                <h1><spring:message code="review.write.title"/></h1>
                <span>REVIEW VIEW</span>
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
            
                   	<h2 class="align-center">${review.review_title}</h2>
                   	<ul style="list-style:none;">
                   		<li >번호 : ${review.review_num}</li>
                   		<li>ID : ${review.mem_id }</li>
                   		<li>조회수 : ${review.review_hit}</li>
                   		<li>등록날짜 : ${review.review_regdate}</li>                   	
                   		<c:if test="${!empty review.review_file}">
                   		<li>첨부파일 : <a href="file.do?review_file=${review.review_file}">${review.review_file}</a></li>
                   		</c:if>
                   	</ul>
                   	<hr size="1" width="100%">
                   	<p>
                   		<c:if test="${!empty review.review_file}">
                  	 		<img src="file.do?review_file=${review.review_file}" width=512 height=384></img>
                  	 	</c:if>
                  	 	
                   	  	
                   	  	<br>
                  	 	<br>                   		
                   		${review.review_content}
                   		
                   	</p>
                   	
                   	<hr size="1" width="100%">
                   	<p class="align-right">
                   	<input type="button" value="목록으로" class="btn btn-primary btn-sm"
	                   			onclick="location.href='list.do?review_num=${review.review_num}'">
                   		<c:if test="${!empty userId && userId == review.mem_id}">
                   		
                   		<input type="button" value="수정"  class="btn btn-default btn-sm"
                   			onclick="location.href='update.do?review_num=${review.review_num}'">
                   		<input type="button" value="삭제"  class="btn btn-default btn-sm"
                   			onclick="location.href='delete.do?review_num=${review.review_num}'">
                   	</c:if>
                   	</p>
                   	<!-- 댓글 -->
                   	<span class="reply title">▶ 댓글달기 </span>
                   	
                   	<br><br>
                   	<form id="re_form" >
                   		<input type="hidden" name="review_num" value="${review.review_num}" id="review_num">
                   		<input type="hidden" name="mem_id" value="${userId}" id="userId">
                   		<textarea rows="3" cols="50" name="review_re_content" class="content"
                   		id="review_re_content" maxlength="300" class="a"
                   		 <c:if test="${empty userId}">disabled="disabled"</c:if>
                   		 ><c:if test="${empty userId}">로그인해야 작성할 수 있습니다.</c:if></textarea>
                 		<c:if test="${!empty userId}">
                 			<div id="re_first">
                 				<span class="letter-count">300/300</span>
                 			</div>
                 			<div id="re_second" class="align-right">
                 				<input type="submit" class="btn btn-default btn-sm" value="전송">
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
                   	  	<!-- 수정폼 -->
                   	  	<div id="modify_div" style="display:none;">
                   	  	<form id="mre_form">
                   	  	<input type="hidden" name="review_re_num" id="mreview_re_num">
                   	 	<input type="hidden" name="mem_id" id="muserId">
                   	 	<textarea rows="3" cols="50" name="review_re_content"
                   	 	id="mreview_re_content" class="a"></textarea>
                   	  	<div id="mre_first"><span class="letter-count">300/300</span></div>  
						<div id="mre_second" class="align-right">
							<input type="submit" class="btn btn-default btn-sm" value="수정">
							<input type="button"  value="취소" class ="btn btn-danger btn-sm, re-reset">
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