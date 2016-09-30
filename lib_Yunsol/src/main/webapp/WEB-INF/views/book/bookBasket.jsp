<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Stylesheets
	============================================= -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />

<title>도서</title>

<!-- Page Title
		============================================= -->
		
<section id="page-title">

	<div class="container clearfix">
		<h1>책 바구니</h1>
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
					<div class="panel-body">
						<div>
							<form action="basket.do" id="cart-form" method="post">
								<table class="table table-hover provideList">
									<thead>
										<tr>
											<th></th>
											<th>도서명</th>
											<th>코드</th>
											<th>글쓴이</th>
											<th>출판사</th>
											<th>비고</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="basket" items="${list }">
											<tr>
												<td><a href = "${pageContext.request.contextPath}/book/detail.do?list_title=${basket.list_title}&list_filename=${basket.list_filename }&list_num=${basket.list_num }">
												<img src="/lib/upload/${basket.list_filename }" width="80" height="120"></a></td>
												<td>${basket.list_title}</td>
												<td>${basket.list_code}</td>
												<td>${basket.list_writer }</td>
												<td>${basket.list_publish }</td>
												<td><input type="hidden" id="basket_num" class = "basket_num"
													name="basket_num" value="${basket.basket_num }">
													<a id="delete-button" class="btn btn-primary delete-button" data-num= "${basket.basket_num }"
													href="${pageContext.request.contextPath}/book/basket.do">삭제</a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>

							</form>
						</div>
					</div>
				</div>
			</div>
			<p style="text-align: center;">
				<input type="hidden" name="list_title" id="list_title" value="${basket.list_title }"> 
				<input type="hidden" name="list" id="list" value="${list}"> 
				<a id="rent-button"	class="btn btn-primary"	href="${pageContext.request.contextPath}/book/rent.do">예약</a> 
				<input type="button" value="도서 찾기로" class="btn btn-primary"
					onclick="location.href='${pageContext.request.contextPath}/book/search.do'">
			</p>
		</div>
	</div>

</section>
<!-- #content end -->


<!-- Go To Top
	============================================= -->
<div id="gotoTop" class="icon-angle-up"></div>


