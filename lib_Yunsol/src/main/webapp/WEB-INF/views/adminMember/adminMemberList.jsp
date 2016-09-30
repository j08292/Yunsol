<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div>
	<h1 class="page-header">
		<spring:message code="adminMember.list.title" />
	</h1>
	<form action="list.do" id="search_form" method="post">
		<div align="center">
			<select name="keyfield">
				<option value="mem_id">ID</option>
				<option value="mem_name">이름</option>
				<option value="mem_cell">연락처</option>
				<option value="mem_address">주소</option>
				<option value="all">전체</option>
			</select> <input type="text" size="16" name="keyword"> <input
				type="submit" value="찾기">
		</div>
	</form>
	<c:if test="${count == 0}">
		<div align="center">등록된 회원정보가 없습니다.</div>
	</c:if>

	<c:if test="${count > 0 }">
		<div class="panel panel-default">
			<div class="panel-heading" style="text-align: center">회원 검색결과</div>
			<form action="list.do" class="form-inline" id="detail-form"
				method="post" style="text-align: center">
				<c:forEach var="article" items="${list}">
					<div style="width: 70%; margin: 0 auto;">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title">${article.mem_id}</h3>
							</div>
							<div class="panel-body">
								<div class="col-md-6 text-left">
									이름: ${article.mem_name}<br> 이메일: ${article.mem_email}<br>
									연락처: ${article.mem_cell}<br> 주소: ${article.mem_address}
								</div>
								<div class="col-md-6 text-left">
									가입일: ${article.mem_regdate}<br> 회원등급:
									<c:if
										test="${article.mem_level == 0 || article.mem_level == 1}">일반회원</c:if>
									<c:if test="${article.mem_level == 2}">관리자</c:if>
									<br> 회원상태:
									<c:if
										test="${article.block_count == 0}">
										<span style="color: blue;">정상</span> | <a href="javascript:block_message('${article.mem_id}')"><span
											style="color: grey;">차단</span></a>
									</c:if>
									<c:if test="${article.block_count>0}">
										<a href="javascript:blockcancel_event('${article.mem_id}')"><span style="color: grey;">정상</span></a> | <span
											style="color: red;">차단</span>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</form>
		</div>
		<div align="center">${pagingHtml }</div>
	</c:if>
</div>