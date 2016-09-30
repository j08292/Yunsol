<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section id="page-title">

			<div class="container clearfix">
				<h1>독서마라톤</h1>
				<ol class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/main/main.do">Home</a></li>
					<li class="active">Marathon</li>
				</ol>
			</div>

		</section>
<div class="content-wrap">
	<div class="container clearfix">
		<h4>독서마라톤이란?</h4>
		<p>
		독서활동을 마라톤에 접목시켜 42,195페이지를 읽으면 완주하는 경기
		</p>
		<br>
		<h4>완주혜택</h4>
		<p>
		완주 메달 배송
		무료배송쿠폰
		도서 대출 권수 확대
		</p>
		<br>
		<h4>참여방법</h4>
		<p>
		아래의 [참가하기] 버튼을 눌러 신청하여 [마이 페이지]>[대출내역] 또는 [내 독서마라톤 현황]>[대출내역]에서 [별점한줄평]을 등록하면 자동으로 페이지가 누적됩니다.
		</p>
		<br>
		<h4>유의사항</h4>
		<p>
		본 도서관에서 대출하지 않았던 책에 [별점한줄평]을 등록했을 경우에는 누적되지 않습니다.<br>
		[별점한줄평]을 장난으로 기록한 경우, 모니터링 후 사전 연락 없이 삭제됩니다.<br>
		[마이 페이지]에서 주소를 다시 확인하여 정확하게 입력해주세요.<br>
		1회 완주 후 다시 완주할 경우에는 완주혜택이 없습니다.
		</p>
		<c:if test="${empty userId || member.mrt_status eq 0}">
		<input type="button" value="참가하기" onclick="location.href='${pageContext.request.contextPath }/event/applyMarathon.do'" class="button button-desc button-3d button-rounded button-green center" >
		</c:if>
		<c:if test="${member.mrt_status eq 1 || member.mrt_status eq 2}">
		<input type="button" value="내 독서마라톤 현황" onclick="location.href='${pageContext.request.contextPath }/event/myMarathon.do'" class="button button-desc button-3d button-rounded button-teal center">
		</c:if>
	</div>
</div>