<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div>
	<h1 class="page-header">
	<spring:message code="speech.list.title"/> | <a href="${pageContext.request.contextPath}/admin/speech/noCheckReserveList.do"><small>강연 미승인 신청자</small></a> | <a href="${pageContext.request.contextPath}/admin/speech/speechReserveCancelList.do"><small>강연 예약 취소자</small></a>
	</h1>
	
	<form action="list.do" id="search_form" method="get">
		<div align="center">
				<select name="keyfield">
					<option value="speech_title">제목</option>
					<option value="speech_date">날짜</option>
				</select>
				<input type="text" size="16" name="keyword">
				<input type="submit" value="찾기">
		</div>
	</form>
	<div align="right"><input type="button" value="등록" onclick="location.href='write.do'" class="btn btn-sm btn-primary"></div>
	<c:if test="${count == 0}">
	<div align="center">등록된 게시물이 없습니다.</div>
	</c:if>

	<c:if test="${count > 0}">
	<div class="table-responsive">
		<table class="table table-hover">
			<thead> 
				<tr>
					<th style="text-align:center;">강연번호</th>
					<th style="text-align:center;">강연제목</th>
					<th style="text-align:center;">강연날짜</th>
					<th style="text-align:center;">최대 참가인원</th>
					<th style="text-align:center;">신청인원</th>
					<th style="text-align:center;">수정/취소</th>
				</tr>
			</thead>
			<c:forEach var="article" items="${list}">
			<tbody style="text-align:center;">
				<tr>
					<td>${article.speech_num}</td>
					<td><c:if test="${article.speech_status eq 0}">
						${article.speech_title}
						</c:if>
						<c:if test="${article.speech_status eq 1}">
						<del>${article.speech_title}</del> (일정 취소)
						</c:if>
					</td>
					<td>${article.speech_date}</td>
					<td>${article.speech_people}명</td>
					<td><a href="reservationList.do?speech_num=${article.speech_num}">${article.countres}명</a></td>
					<td>
						
						<c:if test="${article.speech_status eq 0}">
							<a href="update.do?speech_num=${article.speech_num}" class="btn btn-xs btn-warning">수정</a>
							<a href="javascript:cancel_event(${article.speech_num})" class="btn btn-xs btn-danger">일정취소</a>
						</c:if>
						<c:if test="${article.speech_status eq 1}">
							<a href="javascript:delete_event(${article.speech_num},${article.countres});" class="btn btn-xs btn-danger">일정삭제</a>
						</c:if>
					</td>
				</tr>
			</tbody>
			</c:forEach>
		</table>
	</div>
	<div align="center">${pagingHtml}</div>
	</c:if>
</div>