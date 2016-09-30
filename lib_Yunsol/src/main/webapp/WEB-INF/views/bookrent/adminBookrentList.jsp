<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div>
	<h1 class="page-header"><spring:message code="bookrent.list.title"/></h1>
	<form action="list.do" id="search_form" method="get">
		<div align="center">
			<select name="keyfield" id="bookrentSearch">
				<option value="rent_num">대출번호</option>
				<option value="list_title">제목</option>
				<option value="list_code">ISBN</option>
				<option value="mem_id">대출자</option>
				<option value="rent_status">도서상태</option>
				<option value="all">전체</option>
			</select>
			<span id="output">
				<input type="text" size="16" name="keyword" id="textbox">
			</span>
			<input type="submit" value="찾기">
		</div>
	</form>
	<c:if test="${count == 0}">
		<div class="align-center">대출된 도서가 없습니다.</div>
	</c:if>
	<c:if test="${count > 0}">
		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th style="text-align:center;">대출번호</th>
						<th style="text-align:center;">제목</th>
						<th style="text-align:center;">ISBN</th>
						<th style="text-align:center;">대출자</th>
						<th style="text-align:center;">대출일</th>
						<th style="text-align:center;">반납예정일</th>
						<th style="text-align:center;">연체일</th>
						<th style="text-align:center;">도서상태</th>
						<th style="text-align:center;">반납처리</th>
					</tr>
				</thead>
				<tbody style="text-align:center;">
					<c:forEach var="article" items="${list}">
						<tr>
							<td>${article.rent_num}</td>
							<td>${article.list_title}</td>
							<td>${article.list_code}</td>
							<td>${article.mem_id}</td>
							<td>${article.rent_regdate}</td>
							<td><c:choose>
									<c:when test="${article.rent_status == 0}">
									${article.rent_returndate}
								</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose></td>
							<td><c:choose>							
									<c:when test="${article.rent_status == 0}">
										<!-- 대출중 도서의 연체일 구하기 -->
										<jsp:useBean id="toDay" class="java.util.Date" />
										<fmt:parseDate var="returnDate" value="${article.rent_returndate}" pattern="yyyy-MM-dd" />
										<fmt:parseNumber value="${toDay.time / (1000*60*60*24)}" integerOnly="true" var="nowDays" scope="request" />
										<fmt:parseNumber value="${returnDate.time / (1000*60*60*24)}" integerOnly="true" var="oldDays" scope="request" />
										<c:choose>
											<c:when test="${toDay > article.rent_returndate}">
												<c:if test="${(nowDays - oldDays) != 0}">
													<font color="red"> ${nowDays - oldDays} </font>
												</c:if>
												<c:if test="${(nowDays - oldDays) == 0}">
													-
												</c:if>								
											</c:when>
											<c:otherwise>-</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>-</c:otherwise>
								</c:choose></td>
							<td><c:if test="${article.rent_status == 0}">대출중</c:if>
								<c:if test="${article.rent_status == 2}">예약중</c:if>
								<c:if test="${article.rent_status == 3}">대출대기</c:if></td>
							<td>
								<c:if test="${article.rent_status == 0}"><!-- 대출 도서 -->
									<c:if test="${(nowDays - oldDays) > 0}"><!-- 연체 도서 -->
										<input type="button" onclick="javascript:insertPenalty_event(${article.rent_num},'${article.mem_id}','${article.list_title}',${nowDays - oldDays});" value="반납" class="btn btn-xs btn-warning">
									</c:if>
									<c:if test="${(nowDays - oldDays) <= 0}">									
										<input type="button" onclick="javascript:bookReturn_event(${article.rent_num},${article.rent_status},'${article.list_title}',${article.list_num});" value="반납" class="btn btn-xs btn-warning">										
									</c:if>
								</c:if>								
								<c:if test="${article.rent_status == 3}"><!-- 대출대기 도서 -->
									<input type="button" onclick="javascript:bookRent_event(${article.rent_num},'${article.list_title}');" value="대출" class="btn btn-xs btn-primary">
									<input type="button" onclick="javascript:bookCancel_event(${article.rent_num},'${article.list_title}');" value="취소" class="btn btn-xs btn-danger">
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div align="center">${pagingHtml}</div>
	</c:if>
</div>