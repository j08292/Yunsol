<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${member.mrt_status eq 1 || member.mrt_status eq 2}">
<section id="page-title">
	<div class="container clearfix">
		<h1>내 마라톤 현황</h1>
				<ol class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/main/main.do">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/event/marathonInfo.do">Marathon Info</a></li>
					<li class="active">My Marathon</li>
				</ol>
	</div>
</section>

<div class="container clearfix">
	
	<h2></h2>
	<div>
	<c:set var="sum" value="0"/>
	
	<c:forEach var="page" items="${pageList}">
		<c:set var="sum" value="${sum + page.list_page}"/>
	</c:forEach>
	현재 <strong><fmt:formatNumber type="currency" value="${sum - ((sum/42195) - (sum/42195%1))*42195}" pattern="###,###"/></strong>페이지 읽음(<fmt:formatNumber value="${(sum/42195) - (sum/42195%1)}" type="number"/>회 완주) <small>총 <strong><fmt:formatNumber type="currency" value="${sum}" pattern="###,###"/></strong>페이지 읽음</small><br>
	<br>
	완주까지 남은 페이지 <strong><fmt:formatNumber type="currency" value="${42195-(sum - ((sum/42195) - (sum/42195%1))*42195)}" pattern="###,###"/></strong>페이지<br>
	<br>
	</div>
	<c:if test="${sum >=42195 && member.mrt_status eq 1 }">
		<input type="button" value="완주혜택 신청하기" onclick="javascript:finish_event(${sum},${member.mrt_status});">
	</c:if>
	<br>
	<hr size="100%">
	<h4>달성률</h4>
	
	<ul class="skills">
	    <li data-percent="${(sum - ((sum/42195) - (sum/42195%1))*42195)/42192 * 100}">
	        <div class="progress" style="width: ${(sum - ((sum/42195) - (sum/42195%1))*42195)/42192 * 100}%;">
	            <div class="progress-percent">
		            <div class="counter counter-inherit counter-instant">
			            <span data-from="0" data-to="${(sum - ((sum/42195) - (sum/42195%1))*42195)/42192 * 100}" data-refresh-interval="50" data-speed="1100">
			            	${(sum - ((sum/42195) - (sum/42195%1))*42195)/42192 * 100}</span>%</div>
	            </div>
	        </div>
	    </li>
	</ul>
	
	
	<br>
	<hr size="100%">
	<h4>[대출내역]</h4>
	<br>
	<c:if test="${count == 0}">
	<div align="center">대출 내역이 없습니다.</div>
	</c:if>
	<c:if test="${count > 0}">
	<table class="table table-hover"  style="text-align:center;">
		<thead>
			<tr>
				<th style="text-align:center;">책번호</th>
				<th style="text-align:center;">책제목</th>
				<th style="text-align:center;">페이지 수</th>
				<th style="text-align:center;">대여날짜</th>
				<th style="text-align:center;">반납날짜</th>
				<th style="text-align:center;">한줄평</th>
			</tr>
		</thead>
		
		
		<tbody>
		<c:forEach var="article" items="${rentedList}">
			<tr>
				<td>${article.list_num}</td>
				<td>${article.list_title}</td>
				<td><fmt:formatNumber type="currency" value="${article.list_page}" pattern="###,###"/></td>
				<td>${article.rent_regdate}</td>
				<td>${article.rent_returndate}</td>
				<td>
				<c:if test="${article.gradecheck eq 1}">
				한줄평을 남기셨습니다.
				</c:if>
				<c:if test="${article.gradecheck eq 0}">
				<input type="button" value="한줄평쓰기" onclick="">
				</c:if>
				</td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
	
	</c:if>
</div>
</c:if>