<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
	<div align="center">
	<h2>${speech.speech_title} 예약자 현황</h2>
	</div>
	<div align="right">
	<input type="button" value="목록으로" onclick="location.href='list.do'" class="btn btn-sm btn-info">
	</div>
	<br>
	강연 참가금액: <fmt:formatNumber type="currency" value="${speech.speech_price}" pattern="###,###"/>원<br>
	
	<form action="reservationList.do" id="search_form" method="get">
		<input type="hidden" value="${speech.speech_num}" name="speech_num">
		<div align="center">
				<select name="keyfield" id="speechReserveSearch">
					<option value="mem_id">ID</option>
					<option value="speech_reserve_status">신청상태</option>
				</select>
				<span id="output">
					<input type="text" size="16" name="keyword" id="textbox">
				</span>
				<input type="submit" value="찾기">
		</div>
	</form>
	<c:if test="${count == 0}">
	<div align="center">강연을 신청한 사람이 없습니다.</div>
	</c:if>
	<c:if test="${count > 0}">
	<div class="table-responsive">
		<table class="table table-hover">
			<thead> 
				<tr>
					<th style="text-align:center;">예약번호</th>
					<th style="text-align:center;">아이디</th>
					<th style="text-align:center;">이름</th>
					<th style="text-align:center;">예약일</th>
					<th style="text-align:center;">신청현황</th>
					<th style="text-align:center;">신청상태변경</th>
				</tr>
			</thead>
			<c:forEach var="article" items="${list}">
			<tbody style="text-align:center;">
				<tr>
					<td>${article.speech_reserve_num}</td>
					<td>${article.mem_id}</td>
					<td>${article.mem_name}</td>
					<td>${article.speech_reserve_date}</td>
					<td>
					<c:if test="${article.speech_reserve_status eq 0}">
						신청중
					</c:if>
					<c:if test="${article.speech_reserve_status eq 1}">
						신청 확정
					</c:if>
					<c:if test="${article.speech_reserve_status eq 2}">
						취소 신청
					</c:if>
					<c:if test="${article.speech_reserve_status eq 3}">
						취소 완료 <a href="javascript:delete_event(${speech.speech_num},${article.speech_reserve_num})"  class="btn btn-xs btn-danger">삭제</a>
					</c:if>
					</td>
					<td data-num="${article.speech_reserve_num}">
						<select name="status" class="status" data-num="${speech.speech_num}">
							<option value="0" <c:if test="${article.speech_reserve_status eq 0}">selected</c:if>>신청중</option>
							<option value="1" <c:if test="${article.speech_reserve_status eq 1}">selected</c:if>>신청 확정</option>
							<option value="2" <c:if test="${article.speech_reserve_status eq 2}">selected</c:if>>취소 신청</option>
							<option value="3" <c:if test="${article.speech_reserve_status eq 3}">selected</c:if>>취소 완료</option>
						</select>
						<input type="button" value="저장" class="save_Status btn btn-xs btn-success">
					</td>
				</tr>
			</tbody>
			</c:forEach>
		</table>
	</div>
	<div align="center">${pagingHtml}</div>
	</c:if>
</div>