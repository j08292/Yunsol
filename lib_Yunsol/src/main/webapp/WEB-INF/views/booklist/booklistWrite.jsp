<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div>  
	<h1 class="page-header"><spring:message code="booklist.write.title"/></h1>
	<div style="width:70%;margin:0 auto;"> 
	<form:form action="write.do" enctype="multipart/form-data" commandName="command" id="register_form">
		<form:errors element="div" class="error-color"/>					
			<div class="form-group">
				<label for="list_title">제목</label>
				<form:input path="list_title" class="form-control"/>
				<form:errors path="list_title" class="error-color"/>
			</div>
			<div class="form-group">
				<label for="list_writer">지은이</label>
				<form:input path="list_writer" class="form-control"/>
				<form:errors path="list_writer" class="error-color"/>
			</div>
			<div class="form-group">
				<label for="list_publish">출판사</label>
				<form:input path="list_publish" class="form-control"/>
				<form:errors path="list_publish" class="error-color"/>
			</div>
			<div class="form-group">
				<label for="list_code">ISBN</label>
				<form:input path="list_code" class="form-control"/>
				<form:errors path="list_code" class="error-color"/>
			</div>
			<div class="form-group">
				<label for="list_page">페이지수</label>
				<form:input path="list_page" class="form-control"/>
				<form:errors path="list_page" class="error-color"/>
			</div>
			<div class="form-group">
				<label for="upload">업로드</label>
				<div id="imagePreview"></div><br>
				<input type="file" name="upload" id="upload" onchange="ImagePreview();">
			</div>			
			<div align="center">
				<input type="submit" value="전송" class="btn btn-primary">
				<input type="button" value="목록" class="btn btn-default" onclick="location.href='list.do'">
			</div>		
	</form:form>
	</div>
</div>