<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
	<h1 class="page-header">
	마라톤 완주자 목록
	</h1>
	<form action="list.do" id="search_form" method="get">
		<div align="center">
				<select name="keyfield" id="marathonSearch">
					<option value="mem_id">ID</option>
					<option value="marathon_status">완주혜택상태</option>
				</select>
				<span id="output">
					<input type="text" size="16" name="keyword" id="textbox">
				</span>
				<input type="submit" value="찾기">
		</div>
	</form>
	<c:if test="${count == 0}">
	<div align="center">완주신청한 회원이 없습니다.</div>
	</c:if>
	
	
	<c:if test="${count > 0}">
	<div class="table-responsive">
		<table class="table table-hover">
			<thead> 
				<tr>
					<th style="text-align:center;">번호</th>
					<th style="text-align:center;">ID</th>
					<th style="text-align:center;">이름</th>
					<th style="text-align:center;">주소</th>
					<th style="text-align:center;">전화번호</th>
					<th style="text-align:center;">페이지</th>
					<th style="text-align:center;">신청날짜</th>
					<th style="text-align:center;">완주혜택상태</th>
					<th style="text-align:center;">상태변경</th>
				</tr>
			</thead>
			<c:forEach var="article" items="${list}">
			<tbody style="text-align:center;">
				<tr>
					<td>${article.marathon_num}</td>
					<td>${article.mem_id}</td>
					<td>${article.mem_name}</td>
					<td>${article.mem_address}</td>
					<td>${article.mem_cell}</td>
					<td><fmt:formatNumber type="currency" value="${article.marathon_page}" pattern="###,###"/></td>
					<td>${article.marathon_regdate}</td>
					<td>
						<c:if test="${article.marathon_status eq 0}">
							신청중
						</c:if>
						<c:if test="${article.marathon_status eq 1}">
							발송처리
						</c:if>
					</td>
					<td>
						<c:if test="${article.marathon_status eq 0}">
							<input type="button" value="완주 확인" class="btn btn-xs btn-success" 
							onclick="javascript:check_event(${article.marathon_num})">
						</c:if>
						<c:if test="${article.marathon_status eq 1}">
							<input type="button" value="취소" class="btn btn-xs btn-success" 
							onclick="javascript:cancel_event(${article.marathon_num})">
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