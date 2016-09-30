<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div>
	<h1 class="align-center">감상평 게시판</h1>
	<div class="table-responsive">
		<table class="table table-striped">

			<thead>
				<tr>
					<th colspan="4">글 제목: ${review.review_title}</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>번호 : ${review.review_num}</th>
					<th>작성자 : ${review.mem_id}</th>
					<th style="text-align: right;">등록날짜 : ${review.review_regdate}</th>
					<th style="text-align: right;">조회수 : ${review.review_hit}</th>
				</tr>
				<c:if test="${!empty review.review_file}">
					<tr>
						<th>첨부파일 : <a
							href="file.do?review_file=${review.review_file}">${review.review_file}</a></th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
				</c:if>				
				<tr>
					<td colspan="4"><br>
					<c:if test="${!empty review.review_file}">
						<img src="file.do?review_file=${review.review_file}" width=512 height=384></img>
						<br><br>
					</c:if>
					${review.review_content}<br><br></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div align="right">
		<input type="button" value="목록으로" onclick="location.href='list.do'" class="btn btn-sm btn-info">
		<input type="button" value="삭제" onclick="javascript:delete_event(${review.review_num});" class="btn btn-sm btn-danger">
	</div>
	<hr size="1" width="100%">
	

	<!-- review.reply.js에 넘겨주는 글번호,아이디 -->
	<input type="hidden" name="review_num" value="${review.review_num}" id="review_num">
	<input type="hidden" name="mem_id" value="${userId}" id="userId">
	<!-- 댓글 목록출력 -->
	<div id="output"></div>
	<div class="paging_button" style="display: none;">
		<input type="button" value="다음글 보기" class="btn btn-xs btn-info">
	</div>
	<div id="loading" style="display: none;">
		<img src="${pageContext.request.contextPath}/resources/user/images/ajax-loader.gif">
	</div>
</div>