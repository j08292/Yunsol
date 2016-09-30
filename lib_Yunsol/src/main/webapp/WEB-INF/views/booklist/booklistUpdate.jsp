<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div>  
	<h1 class="page-header"><spring:message code="booklist.update.title" /></h1>
	<c:if test="${command.list_status == 0 }">
		<div align="right"><input type="button" value="대출 정지" onclick="javascript:rentStop_event(${command.list_num},'${command.list_title}');" class="btn btn-danger"></div>
	</c:if>
	<div style="width:70%;margin:0 auto;"> 
	<form:form action="update.do" enctype="multipart/form-data" commandName="command" id="update_form">
		<form:errors element="div" class="error-color" />
		<div class="form-group">
			<label for="list_title">제목</label>
			<form:input path="list_title" class="form-control" />
			<form:errors path="list_title" class="error-color" />
		</div>
		<div class="form-group">
			<label for="list_writer">지은이</label>
			<form:input path="list_writer" class="form-control" />
			<form:errors path="list_writer" class="error-color" />
		</div>
		<div class="form-group">
			<label for="list_publish">출판사</label>
			<form:input path="list_publish" class="form-control" />
			<form:errors path="list_publish" class="error-color" />
		</div>
		<div class="form-group">
			<label for="list_code">ISBN</label>
			<form:input path="list_code" class="form-control" />
			<form:errors path="list_code" class="error-color" />
		</div>
		<div class="form-group">
			<label for="list_page">페이지수</label>
			<form:input path="list_page" class="form-control" />
			<form:errors path="list_page" class="error-color" />
		</div>
		<div class="form-group">
			<label for="upload">업로드</label>
			<div id="beforeImage">			
				<c:if test="${!empty command.list_filename}"><br>
					<span><img src="${pageContext.request.contextPath}/upload/${command.list_filename}" width=200 height=140></img>
					<br>(${command.list_filename})파일이 등록되어 있습니다.
					<br>다시 업로드하면 기존 파일은 삭제됩니다.</span>
				</c:if>
			</div>
			<div id="imagePreview"></div><br>
			<input type="file" name="upload" id="upload" onchange="ImagePreview();">
		</div>
		<div align="center">
			<input type="submit" value="수정" class="btn btn-warning">
			<input type="button" value="목록" class="btn btn-default" onclick="location.href='list.do'">
		</div>
	</form:form>
	</div>	
</div>