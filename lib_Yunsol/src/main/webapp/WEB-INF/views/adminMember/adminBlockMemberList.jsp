<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div>
	<h1 class="page-header">
		차단회원목록
	</h1>
	<form action="list.do" id="search_form" method="post">
		<div align="center">
			<select name="keyfield">
				<option value="mem_id">ID</option>
			</select> <input type="text" size="16" name="keyword"> 
			<input type="submit" value="찾기">
		</div>
	</form>
	<br>
	<c:if test="${count == 0}">
		<div align="center">차단회원이 없습니다.</div>
	</c:if>

	<c:if test="${count > 0 }">
				<c:forEach var="article" items="${list}">
					<div style="width: 70%; margin: 0 auto;">
						<div class="panel panel-danger">
							<div class="panel-heading">
								<h3 class="panel-title" style="text-align: center">${article.mem_id}</h3>
							</div>
							<div class="panel-body">
								<div class="col-md-6 text-left">
									차단일자: ${article.penalty_regdate}<br>
									회원상태: 차단 <input type="button" value="차단해지" class="btn btn-xs btn-danger" onclick="javascript:blockcancel_event('${article.mem_id}')">
								</div>
								<div class="col-md-6 text-left">
									차단해지일: ${article.penalty_blockcanceldate}<br> 
									<input type="button" value="사유 보기" id="reasonOpen_${article.mem_id}" onclick="selectData('${article.mem_id}');" class="btn btn-xs btn-info">
									<input type="button" value="사유 닫기" id="reasonClose_${article.mem_id}" onclick="hideData('${article.mem_id}');" class="btn btn-xs btn-info" style="display:none;">
								</div>
							</div>
								<!-- 사유보기 ajax -->
								<div id="output_${article.mem_id}">
								</div>
								<br>
								<div id="loading" style="display:none;">
									<img src="${pageContext.request.contextPath}/resources/event/images/ajax-loader.gif">
								</div>
						</div>
					</div>
				</c:forEach>
		<div align="center">${pagingHtml }</div>
	</c:if>

</div>