<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
	  <h1 class="page-header">
	  강연 미승인 신청자 | <a href="${pageContext.request.contextPath}/admin/speech/speechReserveCancelList.do"><small>강연 예약 취소자</small></a> | <a href="${pageContext.request.contextPath}/admin/speech/list.do"><small>강연 목록</small></a>
	  </h1>
	<c:if test="${count == 0}">
	<div align="center">신청중인 회원이 없습니다.</div>
	</c:if>
	<c:if test="${count > 0}">
	<div class="table-responsive">
			<table class="table table-hover">
			<thead> 
				<tr>
					<th style="text-align:center;">강연신청번호</th>
					<th style="text-align:center;">강연제목</th>
					<th style="text-align:center;">ID</th>
					<th style="text-align:center;">신청날짜</th>
					<th style="text-align:center;">신청현황</th>
				</tr>
			</thead>
			<c:forEach var="article" items="${list}">
			<tbody style="text-align:center;">
				<tr>
					<td>${article.speech_reserve_num}</td>
					<td><a href="${pageContext.request.contextPath}/admin/speech/reservationList.do?speech_num=${article.speech_num}">${article.speech_title}</a></td>
					<td>${article.mem_id}</td>
					<td>${article.speech_reserve_date}</td>
					<td>
						신청확인중					
					</td>
				</tr>
			</tbody>
			</c:forEach>
			</table>
	<div align="center">${pagingHtml}</div>
	</div>
	</c:if>

</div>