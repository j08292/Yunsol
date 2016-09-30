<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div>  
	<h1 class="page-header"><spring:message code="booklist.list.title" /></h1>
	<form action="list.do" id="search_form" method="get">
		<div align="center">
			<select name="keyfield" id="booklistSearch">
				<option value="list_title">제목</option>
				<option value="list_num">등록번호</option>
				<option value="list_code">ISBN</option>
				<option value="list_status">도서상태</option>
				<option value="all">전체</option>
			</select>
			<span id="output">
				<input type="text" size="16" name="keyword" id="textbox">
			</span>
			<input type="submit" value="찾기">
		</div>
	</form>
	<div align="right"><input type="button" value="도서등록" class="btn btn-sm btn-primary" onclick="location.href='write.do'"></div>
	<c:if test="${count == 0}">
		<div align="center">등록된 도서가 없습니다.</div>
	</c:if>
	<c:if test="${count > 0}">
		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th style="text-align:center;">등록번호</th>
						<th style="text-align:center;">제목</th>
						<th style="text-align:center;">지은이</th>
						<th style="text-align:center;">출판사</th>
						<th style="text-align:center;">ISBN</th>
						<th style="text-align:center;">페이지수</th>
						<th style="text-align:center;">책사진</th>
						<th style="text-align:center;">입고날짜</th>
						<th style="text-align:center;">도서상태</th>
					</tr>
				</thead>
				<tbody style="text-align:center;">
					<c:forEach var="article" items="${list}">
						<tr>
							<td>${article.list_num}</td>
							<td><a href="update.do?list_num=${article.list_num}">${article.list_title}</a></td>
							<td>${article.list_writer}</td>
							<td>${article.list_publish}</td>
							<td>${article.list_code}</td>
							<td>${article.list_page}</td>
							<td><c:choose>
									<c:when test="${!empty article.list_filename}">						
										<img src="/lib/upload/${article.list_filename}" class="adminListImage" data-num="${article.list_num}" height="20px"/>
									</c:when>
									<c:otherwise>파일 없음</c:otherwise>
								</c:choose></td>
							<td>${article.list_regdate}</td>
							<td><c:if test="${article.list_status == 1}">대출정지</c:if>
								<c:if test="${article.list_status == 0}"></c:if></td>
						</tr>						
					</c:forEach>				
				</tbody>
			</table>
		</div>
		<div align="center">${pagingHtml}</div>
	</c:if>
</div>