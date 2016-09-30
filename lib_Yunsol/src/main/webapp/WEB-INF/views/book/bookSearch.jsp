<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Stylesheets
	============================================= -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<!--[if lt IE 9]>
		<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
	<![endif]-->

<!-- External JavaScripts
	============================================= -->
<!-- Document Title
	============================================= -->
<title>도서 검색</title>

<!-- Page Title
		============================================= -->
<section id="page-title">

	<div class="container clearfix">
		<h1>도서 검색</h1>
	</div>

</section>
<!-- #page-title end -->

<!-- Content
		============================================= -->
<section id="content">

	<div class="content-wrap">

		<div class="container clearfix">

			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel-heading" style = "text-align:center"></div>

					<div class="panel-body">
						<form action="search.do" class="form-inline" id="search-form"
							method="post" style = "text-align:center">

							<select name="keyfield" id="selectBox" class="form-control">
								<!-- 컬럼명 -->
								<option value="list_title">도서명</option>
								<option value="list_publish">출판사</option>
								<option value="list_writer">저자</option>
								<option value="list_code">ISBN코드</option>
								<option value="all">전체</option>
							</select>

							<!-- 검색어 -->
							<input type="text" size="25" name="keyword" id="keyword"
								class="form-control"> <input type="submit" value="찾기"
								class="btn btn-default" id = "search-button">
						</form>
					</div>
				</div>
					
				<c:if test="${count == 0 }">
					<div>도서 검색결과가 없습니다.</div>
				</c:if>
				<c:if test="${count > 0 }">
				<label style = "font-size:18px">도서 검색결과</label>
					<div class="panel panel-default">
						<div class="panel-heading"></div>
						<form action="search.do" class="form-inline" id="detail-form"
							method="post" style = "text-align:center">
						
						<table class="table table-hover provideList">
							<thead>
								<tr>
									<th>제목</th>
									<th>작가</th>
									<th>출판사</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="book" items="${list}">
									<tr>
										<td><a href="${pageContext.request.contextPath}/book/detail.do?list_title=${book.list_title}&list_filename=${book.list_filename }&list_num=${book.list_num }">
										<img src="/lib/upload/${book.list_filename}" width="80" height="120"></a></td>
										<td>${book.list_title}</td>
										<td>${book.list_writer}</td>
										<td>${book.list_publish}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</form>
					</div>
					<p style = "text-align:center;">${pagingHtml }</p>
				</c:if>
			</div>

		</div>
	</div>

</section>
<!-- #content end -->

<!-- Go To Top
	============================================= -->
<div id="gotoTop" class="icon-angle-up"></div>

<!-- Footer Scripts
	============================================= -->
<script type="text/javascript" src="js/functions.js"></script>