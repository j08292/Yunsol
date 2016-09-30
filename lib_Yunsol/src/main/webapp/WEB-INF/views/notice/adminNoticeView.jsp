<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div>
	<h1 class="align-center">공지사항</h1>
	<div class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th colspan="4">글 제목: ${notice.notice_title}</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>번호 : ${notice.notice_num}</th>
					<th>작성자 : ${notice.mem_id}</th>
					<th style="text-align: right;">등록날짜 : ${notice.notice_regdate}</th>
					<th style="text-align: right;">조회수 : ${notice.notice_hit}</th>
				</tr>
				<div align="right">
					<input type="button" value="목록으로" onclick="location.href='list.do'"
						class="btn btn-sm btn-info">
				</div>
				<tr>
					<td colspan="4"><br>${notice.notice_content}<br>
					<br></td>
				</tr>
			</tbody>
		</table>
	</div>

	<div align="right">
		<input type="button" value="수정"
			onclick="location.href='update.do?notice_num=${notice.notice_num}'"
			class="btn btn-sm btn-warning"> <input type="button"
			value="삭제" onclick="javascript:delete_event(${notice.notice_num});"
			class="btn btn-sm btn-danger">
	</div>
	<hr size="1" width="100%">

</div>