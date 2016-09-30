<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div>
	<h1 class="page-header"><spring:message code="notice.list.title" /></h1>
	<form action="list.do" id="search_form" method="get">
		<div align="center">
			<select name="keyfield">
				<option value="notice_title">제목</option>
				<option value="mem_id">작성자</option>
				<option value="notice_content">내용</option>
				<option value="all">전체</option>
			</select>
			<input type="text" size="16" name="keyword">
			<input type="submit" value="찾기">
		</div>
	</form>
	<div align="right"><input type="button" value="등록" onclick="location.href='write.do'" class="btn btn-sm btn-primary"></div>
	<c:if test="${count==0}">
		<div align="center">등록된 게시물이 없습니다.</div>
	</c:if>
	<c:if test="${count > 0}">
		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th style="text-align:center;">번호</th>
						<th style="text-align:center;">제목</th>
						<th style="text-align:center;">작성자</th>
						<th style="text-align:center;">작성일</th>
					</tr>
				</thead>
				<c:forEach var="article" items="${list}">
					<tbody style="text-align:center;">					
						<tr>
							<td>${article.notice_num}</td>
							<td><a href="detail.do?notice_num=${article.notice_num}">${article.notice_title}</a></td>
							<td>${article.mem_id}</td>
							<td>${article.notice_regdate}</td>					
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>
		<div align="center">${pagingHtml}</div>
	</c:if>
</div>