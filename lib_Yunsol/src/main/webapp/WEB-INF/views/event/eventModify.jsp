<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- Content -->
<div>
	<h1>이벤트 수정</h1>
	<div style="width:70%;margin:0 auto;"> 
	<form:form id="register-form" name="register-form" class="nobottommargin" action="update.do" commandName="command" enctype="multipart/form-data">
		<div class="form-group">
			<label for="event_title">제목:</label> 
			<input type="text" id="event_title" name="event_title" value="" class="form-control" />
		</div>

		<div class="form-group">
			<label for="event_content">내용:</label>
			<form:textarea path="event_content" rows="8" class="form-control" />
		</div>

		<div class="form-group">
			<label for="event_upload">파일:</label>
			<div id="beforeImage">
				<c:if test="${!empty command.event_filename}">
				<span><img src="${pageContext.request.contextPath}/event_upload/${command.event_filename}" width=200></img>
				<br>
				(${command.event_filename})파일이 등록되어 있습니다.
				다시 업로드하면 기존 파일은 삭제됩니다.</span>
				</c:if>
			</div>
			<div id="imagePreview"></div><br>
			<input type="file" name="upload" id="upload" class="form-control" onchange="ImagePreview();">
		</div>

		<div class="form-group">
			<label for="event_startdate">이벤트 시작일:</label> 
			<input type="date" id="event_startdate" name="event_startdate" value="" class="form-control" />
		</div>

		<div class="form-group">
			<label for="event_enddate">이벤트 종료일:</label> 
			<input type="date" id="event_enddate" name="event_enddate" value="" class="form-control" />
		</div>


		<div class="col_full nobottommargin" align="center">
			<input type="submit" class="btn btn-warning" id="register-form-submit" name="register-form-submit" value="수정" /> 
			<input type="button" class="btn btn-default" id="register-form-submit" name="register-form-submit" value="목록" onclick="location.href='list.do'" />
		</div>
	</form:form>
	</div>
</div>