<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container clearfix">
	<section id="page-title" class="page-title-center">
	<div class="page-title-center">
		<h2>${speech.speech_title}</h2>
	</div>
	</section>
	<div align="center">
	<table>
		<c:if test="${speech.speech_price != 0}">
		<tr>
			<td><strong>입금은행</strong></td>
			<td>신한은행</td>
		</tr>
		<tr>
			<td><strong>계좌번호</strong></td>
			<td>123-456-78910</td>
		</tr>
		<tr>
			<td><strong>입금금액</strong></td>
			<td><fmt:formatNumber type="currency" value="${speech.speech_price}" pattern="###,###"/>원</td>
		</tr>
		<tr>
			<td><strong>입금기한</strong></td>
			<td>${speechReserve.depositDate}</td>
		</tr>
		</c:if>
		<tr>
			<td><strong>승인여부</strong></td>
			<td>
				<c:if test="${speechReserve.speech_reserve_status eq 0}">입금 확인(대기)중입니다.</c:if>
				<c:if test="${speechReserve.speech_reserve_status eq 1}">신청 확정되었습니다.</c:if>
				<c:if test="${speechReserve.speech_reserve_status eq 2}">취소 신청되었습니다.</c:if>
				<c:if test="${speechReserve.speech_reserve_status eq 3}">취소 확정되었습니다.(취소완료)</c:if>
			</td>
		</tr>
	</table>
	<c:if test="${speechReserve.speech_reserve_status != 2 && speechReserve.speech_reserve_status != 3}">
	<input type="button" value="신청 취소하기" onclick="location.href='cancelReserve.do?speech_num=${speech.speech_num}&speech_reserve_status=2'" class="button button-3d button-small button-rounded button-red">
	</c:if>
	<input type="button" value="목록으로" onclick="location.href='list.do'" class="button button-3d button-small button-rounded button-teal">
	</div>
</div>