<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container clearfix">
	
	<section id="page-title" class="page-title-center">
	<div class="page-title-center">
		<h2>${speech.speech_title}</h2>
	</div>
	</section>
	<div class="content-wrap" align="center">
	<p data-animate="bounceInUp">신청되었습니다.<br>
	<c:if test="${speechReserve.speech_reserve_status eq 0}">
	신청금은 <strong><fmt:formatNumber type="currency" value="${speech.speech_price}" pattern="###,###"/>원</strong> 입니다.
	<br><br>
	아래의 계좌로 신청금을 보내주세요.<br>
	<strong>신한은행 123-456-78910</strong>
	<br><br>
	3일 이내로 입금이 안되었을 경우 취소될 수 있습니다.
	</c:if>
	</p>
	<input type="button" value="목록으로" onclick="location.href='list.do'" class="button button-3d button-large button-rounded button-teal" data-animate="swing">
	<input type="button" value="신청현황보기" onclick="location.href='reserveWaiting.do?speech_num=${speech.speech_num}'" class="button button-3d button-large button-rounded button-yellow button-light" data-animate="swing">
	</div>
	
</div>