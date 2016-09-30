<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!--view 천체 -->
<div class="content-wrap">
	<div class="container clearfix">
		<!-- 이벤트 사진 받아오기 -->	
		<div class="col_full" align="center">
			<c:if test="${!empty event.event_filename}">
				<img alt="이벤트사진" src="${pageContext.request.contextPath}/event_upload/${event.event_filename}">
			</c:if>
		</div>
		
		<hr size="1" width="100%">	
			
		<div class="col_full">
			${event.event_content}	
		</div>
		<hr size="1" width="100%">
		
		<!-- 관리자만 할 수 있도록 레벨값을 줘야함 -->
		<p align="right">
			<input type="button" value="수정" onclick="location.href='update.do?event_num=${event.event_num}'">
			<input type="button" value="삭제" onclick="location.href='delete.do?event_num=${event.event_num}'">
		</p>
		
		
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading" style="text-align:center">댓글 달기</div>
			</div>
		<form id="re_form">
			<input type="hidden" name="event_num" value="${event.event_num}" id="event_num">
			<input type="hidden" name="mem_id" value="${userId}" id="userId">
			<textarea rows="4" name="event_re_content" maxlength="1000" id="event_re_content"
				class="col_full" <c:if test="${empty userId}">disabled="disabled"</c:if>
				><c:if test="${empty userId}">로그인해야 작성할수 있습니다.</c:if></textarea>
			
			<c:if test="${!empty userId}">
				<div id="re_first">
					<span class="letter-count">1000/1000</span>
				</div>
				<div id="re_second" align="right">
					<input type="submit" value="전송">
				</div>
			</c:if>
		</form>
		
		
		<!-- 목록출력 -->
		<div class="panel-body">
		<div id="output"></div>
		<div class="paging_button" style="display:none;">
			<input type="button" value="다음글보기">
		</div>
		</div>
		<div id="loading" style="display:none;">
			<img src="${pageContext.request.contextPath}/resources/event/images/ajax-loader.gif">
		</div>
		
		<!-- 수정폼 -->
		<div id="modify_div" style="display:none;">
			<form id="mre_form">
				<input type="hidden" name="event_re_num" id="mre_no">
				<input type="hidden" name="mem_id" id="muserId">
				<textarea rows="6" class="col_full" name="event_re_content"
					id="mre_content"></textarea>
				<div id="mre_first"><span class="letter-count">1000/1000</span></div>
				<div id="mre_second" align="right">
					<input type="submit" value="수정">
					<input type="button" value="취소" class="re-reset">
				</div>
				<hr size="1" noshade width="96%">	
			</form>
		</div>
		
		
	</div>
</div>