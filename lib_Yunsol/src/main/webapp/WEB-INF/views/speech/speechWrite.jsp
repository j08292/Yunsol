<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div>
	<h1 class="page-header"><spring:message code="speech.write.title"/></h1>
	<div style="width:70%;margin:0 auto;"> 
	<form:form action="write.do" commandName="command" id="register_form">
		<form:errors element="div" class="error-color"/>
			<div class="form-group">
				<label for="speech_title">강연 제목</label>
				<form:input path="speech_title" class="form-control"/>
				<form:errors path="speech_title" class="error-color"/>
			</div>
			<div class="form-group">
				<label for="speech_date">강연 날짜</label>
				<form:input path="speech_date" class="form-control" id="datepicker"/>
				<form:errors path="speech_date" class="error-color"/>
			</div>
			<div class="form-group">
				<label for="speech_people">최대 참여 인원</label>
				<form:input path="speech_people" class="form-control"/>
				<form:errors path="speech_people" class="error-color"/>
			</div>
			<div class="form-group">
				<label for="speech_price">강연 가격</label>
				<form:input path="speech_price" class="form-control"/>
				<form:errors path="speech_price" class="error-color"/>
			</div>
			<div class="form-group">
				<label for="speech_location">강연 장소</label><br>
				<input type="button" onclick="sample6_execDaumPostcode()" class="btn btn-default" value="주소 찾기"><br>
				<form:input path="speech_location" type="text" id="sample6_address" placeholder="주소" class="form-control"/>
				<form:input path="speech_location2" type="text" id="sample6_address2" placeholder="상세주소" class="form-control"/>
				<form:errors path="speech_location" class="error-color"/> 
			</div>
			<div class="form-group">
				<label for="speech_content">강연 내용</label>
				<form:textarea path="speech_content" class="form-control" rows="8"/>
				<form:errors path="speech_content" class="error-color"/>
			</div>
			<div align="center">
				<input type="submit" value="전송" class="btn btn-primary">
				<input type="button" value="목록" class="btn btn-default" onclick="location.href='list.do'">
			</div>
	</form:form>
	</div>
</div>