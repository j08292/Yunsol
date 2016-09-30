<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div>
	<h1 class="page-header">
		<spring:message code="grade.list.title" />
	</h1>
	<form action="list.do" id="search_form" method="get">
		<div align="center">
			<select name="keyfield">
				<option value="mem_id">ID</option>
				<option value="grade_content">내용</option>
				<option value="all">전체</option>
			</select> <input type="text" size="16" name="keyword"> <input
				type="submit" value="찾기">
		</div>
	</form>
	<c:if test="${count==0}">
		<div class="align-center">등록된 한줄평이 없습니다.</div>
	</c:if>
	<c:if test="${count>0}">
		<div align="right">
			<input type="button" value="삭제" onclick="ajaxGradeDelete();"
				class="btn btn-xs btn-danger">
		</div>
		<div class="table-responsive">
			<table class="table table-hover">
				<colgroup>
					<col style="width: 7%;">
					<col style="width: 14%;">
					<col style="width: 10%;">
					<col style="width: 32%;">
					<col style="width: 12%;">
					<col style="width: 10%;">
					<col style="width: 14%;">
				</colgroup>
				<thead>
					<tr>
						<th style="text-align: center;">글번호</th>
						<th style="text-align: center;">책제목</th>
						<th style="text-align: center;">작성자</th>
						<th style="text-align: center;">한줄평</th>
						<th style="text-align: center;">별점</th>
						<th style="text-align: center;">작성일</th>
						<th style="text-align: center;">전체 선택/해제<input
							type="checkbox" id="allCheck" name="grade_num"></th>
					</tr>
				</thead>
				<tbody style="text-align: center;">
					<c:forEach var="article" items="${list}">
						<tr>
							<td>${article.grade_num}</td>
							<td>${article.list_title}</td>
							<td>${article.mem_id}</td>
							<td style="max-width: 30%;">
								<c:if test="${fn:length(article.grade_content) > 16}">
									<div id="shortContent_${article.grade_num}">
										<c:out value="${fn:substring(article.grade_content,0,15)}" />
										<a href="javascript:adminGradeView(${article.grade_num}); this.onclick=null;">...</a>
									</div>
									<!-- 한줄평 더보기 ajax -->
									<div id="output_${article.grade_num}"></div>
									<div id="loading" style="display: none;">
										<img src="${pageContext.request.contextPath}/resources/event/images/ajax-loader.gif">
									</div>
								</c:if>
								<c:if test="${fn:length(article.grade_content) <= 16}">
								    ${article.grade_content}
								</c:if></td>
							<td><img
								src="${pageContext.request.contextPath}/resources/grade/images/${article.grade_star}.PNG">
							</td>
							<td>${article.grade_regdate}</td>
							<td><input type="checkbox" value="${article.grade_num}"	name="grade_num"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div align="center">${pagingHtml}</div>
	</c:if>
</div>