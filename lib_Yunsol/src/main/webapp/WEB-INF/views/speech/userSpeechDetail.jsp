<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container clearfix">
	<section id="page-title" class="page-title-center">
	<div class="page-title-center">
		<h2>${speech.speech_title}</h2>
	</div>
	</section>
	<div align="right">
	<input type="button" value="목록으로" onclick="location.href='list.do'" class="button button-3d button-small button-rounded button-teal">
	</div>
	<div class="col_half">
	강연날짜 : ${speech.speech_date} <br><br>
	강연장소 : ${speech.speech_location} ${speech.speech_location2}
	</div>
	<div class="col_half col_last">
	신청인원 : 총 ${speech.speech_people}명 | <strong>${speech.speech_people-res}</strong>명 신청가능 <br><br>
	강연가격 : 
		<c:choose>
			<c:when test="${speech.speech_price eq 0}">무료 </c:when>
			<c:otherwise><fmt:formatNumber type="currency" value="${speech.speech_price}" pattern="###,###"/>원</c:otherwise>
		</c:choose>
	</div>
	
	<hr size="1" width="100%">
	<p>
		${speech.speech_content}
	</p>
	<hr size="1" width="100%">
	<div class="col_one_third">강연번호 : ${speech.speech_num}</div>
	<div class="col_one_third">조회수 : ${speech.speech_hit}</div>
	<div class="col_one_third col_last">등록날짜 : ${speech.speech_regdate}</div>
	
	

		<c:if test="${speech.speech_people-res > 0}">
			<!-- 이미 신청한 사람은 신청현황보기만 보여지게 -->
			<c:if test="${empty speechReserve.mem_id}">
			<c:choose>
				<c:when test="${speech.speech_price eq 0}">
					<div align="center">
						<input type="button" value="신청하기" class="button button-desc button-3d button-rounded button-green center" onclick="location.href='reserveSuccess.do?speech_num=${speech.speech_num}&speech_reserve_status=1'"><br>
					</div>
				</c:when>
				<c:otherwise>
					<div align="center">
						<input type="button" value="신청하기" class="button button-desc button-3d button-rounded button-green center" onclick="location.href='reserveSuccess.do?speech_num=${speech.speech_num}&speech_reserve_status=0'"><br>
					</div>
				</c:otherwise>
			</c:choose>
			</c:if>
			
			<!-- 신청하지 않은사람은 신청하기만 보여지게 -->
			<c:if test="${not empty speechReserve.mem_id}">
			<div align="center">
				<input type="button" value="신청현황보기" onclick="location.href='reserveWaiting.do?speech_num=${speech.speech_num}'" class="button button-desc button-3d button-rounded button-teal center">
			</div>
			</c:if>
		</c:if>
		<!-- 예약 불가능한 상태 -->
		<c:if test="${speech.speech_people-res <= 0}">
			<div align="center">
				<h4>신청 마감되었습니다.</h4>
			</div>
		</c:if>

	
</div>