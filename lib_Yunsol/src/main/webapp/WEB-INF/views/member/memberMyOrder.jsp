<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Page Title
		============================================= -->
<section id="page-title">
	<div class="container clearfix">
		<h1>주문 내역</h1>
	</div>
</section>
<!-- #page-title end -->

<!-- Content
		============================================= -->
 	
<section id="content">
	<div class="content-wrap">
		<div class="container clearfix">
		<form:form action="myOrder.do" id="myOrder-form" class="nobottommargin" method = "get">
				<select id="selectBox" class="form-control" style="width:120px;	float:left;">
					<option value="${pageContext.request.contextPath}/member/myOrder.do?rent_status=9" >전체</option>
					<option value="${pageContext.request.contextPath}/member/myOrder.do?rent_status=0">대여</option>
					<option value="${pageContext.request.contextPath}/member/myOrder.do?rent_status=1">반납</option>
					<option value="${pageContext.request.contextPath}/member/myOrder.do?rent_status=2">예약</option>
					<option value="${pageContext.request.contextPath}/member/myOrder.do?rent_status=3">대여대기</option>
					<option value="${pageContext.request.contextPath}/member/myOrder.do?rent_status=4">취소</option>
					<option value="${pageContext.request.contextPath}/member/myOrder.do?rent_status=5">무인대여</option>
				</select>
				<br><br> 
		</form:form>
		<c:if test="${param.rent_status != null }">
				<script type="text/javascript">
	 					$('#selectBox').change(function(){
							location.href=$(this).val();
						});	
	 					$(function() {
	 						$('#selectBox').val('${pageContext.request.contextPath}/member/myOrder.do?rent_status=${param.rent_status}');
	 					});
				</script>
		</c:if>		
		
		<c:if test="${param.rent_status == null }">
				<script type="text/javascript">
	 					$('#selectBox').change(function(){
							location.href=$(this).val();
						});	
	 					$(function() {
 							$('#selectBox').val('${pageContext.request.contextPath}/member/myOrder.do?rent_status=9');
	 					});
				</script>
		</c:if>


			<label>도서대여 내역</label>
			<form:form action="myOrder.do" id="myOrder-form"
				class="nobottommargin">
				<div class="panel panel-default">
					<div class="panel-body">

						<table class="table table-hover provideList">
							<thead>
								<tr>
									<th>주문번호</th>
									<th>도서정보</th>
									<th>구분</th>
									<th>도서관</th>
									<th>대여날짜</th>
									<th>반납날짜</th>
									<th>상태</th>
									<th>비고</th>
									<th>연체</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${count > 0 }">
									<c:forEach var="rent" items="${list_rent }">
										<tr>
											<td>${rent.rent_num }</td>
											<td><a href="${pageContext.request.contextPath}/member/myOrderDetail.do?rent_num=${rent.rent_num}&list_num=${rent.list_num}&list_title=${rent.list_title}">${rent.list_title }</a></td>
											<c:if test="${rent.rent_status == 3 }">
											<td>대기</td>
											</c:if>
											<c:if test="${rent.rent_status == 0 }">
											<td>일반</td>
											</c:if>
											<c:if test="${rent.rent_status == 2 || rent.rent_status == 4 }">
											<td>예약</td>
											</c:if>
											<c:if test="${rent.rent_status == 5 }">
											<td>무인</td>
											</c:if>
											<td>북수원 도서관</td>
											<td>${rent.rent_regdate }</td>
											<td>${rent.rent_returndate }</td>
												<c:choose>
													<c:when test="${rent.rent_status == 0 }">
														<td>대여</td>
													</c:when>
													<c:when test="${rent.rent_status == 1 }">
														<td>반납</td>
													</c:when>
													<c:when test="${rent.rent_status == 2 }">
														<td>예약</td>
													</c:when>
													<c:when test="${rent.rent_status == 3 }">
														<td>대여대기</td>
													</c:when>
													<c:when test="${rent.rent_status == 4 }">
														<td>취소
													</c:when>
													<c:when test="${rent.rent_status == 5 }">
														<td>무인대여</td>
													</c:when>
												</c:choose>
												
											<td>
												<c:if test="${rent.rent_status == 2 }">
													<input type="hidden" id="rent_num" name="rent_num"
														class="rent_num" value="${rent.rent_num }">
													<input type="hidden" id="list_num" name="list_num"
														class="list_num" value="${rent.list_num }">
													<a id="reserveCancel-button"
														class="btn btn-primary reserveCancel-button" data-num ="${rent.rent_num }" data-num1="${rent.list_num }"
														onclick="${pageContext.request.contextPath}/book/reserveCancel.do?list_num=${rent.list_num}&rent_num=${rent.rent_num}"
														href="${pageContext.request.contextPath}/member/myOrder.do">취소</a>
												</c:if>
											</td>
										</tr>
									</c:forEach>
								</c:if>
							</tbody>
						</table>
						<c:if test="${count == 0 }">
							<p style="text-align: center; font-size: 20px;">도서대여 및 예약 내역이 없습니다.</p>
						</c:if>
						<div style="text-align: center;">${pagingHtml }</div>
					</div>
				</div>
			</form:form>



			<%-- <label>도서예약 내역</label>
			<form:form action="myOrder.do" id="myOrder-form" class="nobottommargin">
			<div class="panel panel-default">
				<div class="panel-body">
					<table class="table table-hover provideList">
						<thead>
							<tr>
								<th>주문번호</th>
								<th>도서정보</th>
								<th>도서관</th>
								<th>대여날짜<br>(예약날짜)</th>
								<th>반납날짜<br>(예약취소 날짜)</th>
								<th>상태</th>
								<th>비고</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="res" items="${list_reserve}">
								<tr>
									<td>${res.rent_num }</td>
									<td><a href = "${pageContext.request.contextPath}/book/detail.do?list_num=${res.list_num}&list_title=${res.list_title}&list_filename=${res.list_filename}">${res.list_title }</a></td>
									<td>북수원 도서관</td>
									<td>${res.reserve_date}</td>
									<c:if test="${res.reserve_dateCancel != null }">
									<td>${res.reserve_dateCancel }</td>
									</c:if>
									<c:if test="${res.reserve_dateCancel == null }">
									<td></td>
									</c:if>
									<c:choose>
										<c:when test="${res.reserve_order == 2 }">
											<td>예약</td>
											<td><a id = "reserveDateCancel-button" class = "btn btn-primary"
											href = "${pageContext.request.contextPath}/member/myOrder.do">취소</a></td>
										</c:when>
										<c:when test="${res.reserve_order == 3 }">
											<td>예약취소</td>
										</c:when>
									</c:choose>
								</tr>
								<input type = "hidden" id = "list_title" name = "list_title" value = "${res.list_title }">
								<input type = "hidden" id = "rent_num" name = "rent_num" value = "${res.rent_num }">
								<input type = "hidden" id = "list_num" name = "list_num" value = "${res.list_num }">
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</form:form> --%>
		
		</div>
	</div>
</section>
