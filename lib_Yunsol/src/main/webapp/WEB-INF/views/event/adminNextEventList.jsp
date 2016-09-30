<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<h1 class="page-header">
		예정 이벤트 | <a href="${pageContext.request.contextPath}/admin/event/list.do"><small>진행중 이벤트</small></a> | <a href="${pageContext.request.contextPath}/admin/event/prevEventList.do"><small>지난 이벤트</small></a>
	</h1>
	<form action="nextEventList.do" id="search_form" method="get">
		<div align="center">
			<select name="keyfield" id="booklistSearch">
				<option value="event_title">제목</option>
				<option value="event_content">내용</option>
				<option value="all">전체</option>
			</select>
			<span id="output">
				<input type="text" size="16" name="keyword" id="textbox">
			</span>
			<input type="submit" value="찾기">
		</div>
	</form>
	<c:if test="${count == 0}">
		<div align="center">예정 이벤트가 없습니다.</div>
	</c:if>
	<c:if test="${count > 0}">
		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th style="text-align:center;">이벤트번호</th>
						<th style="text-align:center;">제목</th>
						<th style="text-align:center;">사진</th>
						<th style="text-align:center;">시작날짜</th>
						<th style="text-align:center;">종료날짜</th>
						<th style="text-align:center;">작성일</th>
						<th style="text-align:center;">삭제</th>
						
					</tr>
				</thead>
				<tbody style="text-align:center;">
					<c:forEach var="article" items="${list}">
						<tr>
							<td>${article.event_num}</td>
							<td><a href="update.do?event_num=${article.event_num}">${article.event_title} <span class="badge">${article.event_replyCount}</span></a></td>
							<td><c:choose>
									<c:when test="${!empty article.event_filename}">						
										<img src="${pageContext.request.contextPath}/event_upload/${article.event_filename}" height="50px" class="adminListImage" alt="이벤트사진">
									</c:when>
									<c:otherwise>파일 없음</c:otherwise>
								</c:choose>
							</td>
							<td>${article.event_startdate}</td>
							<td>${article.event_enddate}</td>
							<td>${article.event_regdate}</td>
							<td><a href="javascript:del_event(${article.event_num});" class="btn btn-xs btn-danger">삭제</a></td>
						</tr>						
					</c:forEach>				
				</tbody>
			</table>
		</div>
		<div align="center">${pagingHtml}</div>
	</c:if>
</div>