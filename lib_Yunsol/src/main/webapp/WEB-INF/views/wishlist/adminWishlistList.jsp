<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div>
	<h1 class="page-header"><spring:message code="wishlist.list.title" /></h1>
	<form action="list.do" id="search_form" method="get">
		<div align="center">
			<select name="keyfield" id="wishlistSearch">
				<option value="wish_title">제목</option>
				<option value="wish_status">진행상태</option>
			</select>
			<span id="output">
				<input type="text" name="keyword" size="16" id="textbox">
			</span>          
            <input type="submit" value="찾기">
		</div>
	</form>
	<c:if test="${count == 0}">
		<div align="right">신청된 희망도서가 없습니다.</div>
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
						<th style="text-align:center;">신청날짜</th>
						<th style="text-align:center;">진행상태변경</th>
					</tr>
				</thead>
				<tbody style="text-align:center;">
					<c:forEach var="article" items="${list}">
						<tr>
							<td>${article.wish_num}</td>
							<td>${article.wish_title}</td>
							<td>${article.wish_writer}</td>
							<td>${article.wish_publish}</td>
							<td>${article.wish_regdate}</td>
							<td><select name="statusChange" class="status" data-num="${article.wish_num}">
									<option value="0"
										<c:if test="${article.wish_status == 0}">selected</c:if>>신청중</option>
									<option value="1"
										<c:if test="${article.wish_status == 1}">selected</c:if>>처리중</option>
									<option value="2"
										<c:if test="${article.wish_status == 2}">selected</c:if>>취소됨</option>
									<option value="3"
										<c:if test="${article.wish_status == 3}">selected</c:if>>소장중</option>
								</select>
								<input type="button" class="status_button btn btn-xs btn-success" value="변경"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div align="center">${pagingHtml}</div>
	</c:if>
</div>