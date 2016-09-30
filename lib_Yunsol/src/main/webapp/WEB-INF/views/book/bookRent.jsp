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
		<h1>결제</h1>
	</div>

</section>
<!-- #page-title end -->

<!-- Content
		============================================= -->
<section id="content">

	<div class="content-wrap">

		<div class="container clearfix">
			<form:form action="rent.do" commandName="command" id="rent-form"
				class="nobottommargin" method="post">
				
				<label>도서 대여정보</label>
				<div class="panel-group">
					<div class="panel panel-default">
						<div class="panel-body">
							<div>
								<table class="table table-hover provideList">
									<thead>
										<tr>
											<th></th>
											<th>도서명</th>
											<th>코드</th>
											<th>저자</th>
											<th>출판사</th>
											<th>개수</th>
											<th>대여 가격</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="basket" items="${list }">
											<tr>
												<td><a href = "${pageContext.request.contextPath}/book/detail.do?list_title=${basket.list_title}&list_filename=${basket_list_filename}&list_num=${list_num}">
												<img src="/lib/upload/${basket.list_filename }" width="80" height="120"></a></td>
												<td>${basket.list_title}</td>
												<td>${basket.list_code}</td>
												<td>${basket.list_writer}</td>
												<td>${basket.list_publish}</td>
												<td>${basket.basket_amount }</td>
												<td>${basket.basket_price }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<div style = "text-align:right;">
									<c:if test="${num>=5}">
										<td>[도서 대여가격] : ${price } + [배송비] : 0 = [합계] : ${total }원</td>
									</c:if>
									<c:if test="${num<5}">
										<td>[도서 대여가격] : ${price } + [배송비] : 2000 = [합계] : ${total }원</td>
									</c:if>
									<br><br>
									<span class = "glyphicon glyphicon-ok"></span>&nbsp;&nbsp;<span>5권 이상 대여하실 경우 배송비 무료</span>
								</div>
							</div>
						</div>
					</div>
				</div>


				<label style = "font-size:18px;">배송지 정보</label><br>
				<label>기존 배송지</label>&nbsp;&nbsp;<input type = "radio" name="gener" checked="checked" id = "existing-radio">&nbsp;&nbsp;&nbsp;&nbsp;
				<label>새로운 배송지</label>&nbsp;&nbsp;<input type = "radio" name="gener" id = "new-radio">
				
				<div class="panel-group" id = "existing-panel">
					<div class="panel panel-default">
						<div class="panel-body">
							<div>
								<table class="table table-hover provideList">
									<thead>
									</thead>
									<tbody>
											<div class="col_full">
												<label for="delivery_name">이름:</label>
												<form:input path="delivery_name" class="form-control" style = "width:25%;" value = "${member.mem_name }" />
											</div>

											<div class="col_full">
												<label for="delivery_cell">전화번호:</label>
												<form:input path="delivery_cell" class="form-control" style = "width:25%;" value = "${member.mem_cell }"/>
											</div>

											<div class="col_full">
												<label for="delivery_email">이메일 주소:</label>
												<form:input path="delivery_email" class="form-control" style = "width:25%;" value = "${member.mem_email }"/>
											</div>

											<!-- daum 우편번호 시작 -->
											<div class="col_full">
												<label for="postcode">우편번호:</label> 
												<br>
												<input type = "text" placeholder="우편번호"
													class="form-control"  style = "width:25%;" value = "${member.sample3_postcode }"/>
												- <br>
												<label for="address">주소:</label>
												<input type = "text" id = "address" class="form-control"
													placeholder="주소" style = "width:50%;" value = "${member.mem_address }"/>

											</div>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				
				
								
				<div class="panel-group" id = "new-panel">
					<div class="panel panel-default">
						<div class="panel-body">
							<div>
								<table class="table table-hover provideList">
									<thead>
									</thead>
									<tbody>
											<div class="col_full">
												<label for="delivery_name">이름:</label>
												<form:input path="delivery_name" class="form-control" style = "width:25%;" />
											</div>

											<div class="col_full">
												<label for="delivery_cell">전화번호:</label>
												<form:input path="delivery_cell" class="form-control" style = "width:25%;"/>
											</div>

											<div class="col_full">
												<label for="delivery_email">이메일 주소:</label>
												<form:input path="delivery_email" class="form-control" style = "width:25%;"/>
											</div>

											<!-- daum 우편번호 시작 -->
											<div class="col_full">
												<label for="sample3_postcode">우편번호:</label> 
												<input type="button" onclick="sample3_execDaumPostcode()"
													value="우편번호 찾기"><br>
												<form:input path="sample3_postcode" placeholder="우편번호"
													class="form-control"  style = "width:25%;"/>
												- <br>

												<div id="wrap"
													style="display: none; border: 1px solid; width: 500px; height: 300px; margin: 5px 0; position: relative">
													<img
														src="//i1.daumcdn.net/localimg/localimages/07/postcode/320/close.png"
														id="btnFoldWrap"
														style="cursor: pointer; position: absolute; right: 0px; top: -1px; z-index: 1"
														onclick="foldDaumPostcode()" alt="접기 버튼">
												</div>
												<label for="delivery_address">주소:</label>
												<form:input path="delivery_address" class="form-control"
													placeholder="주소" style = "width:50%;"/>

											</div>

											<script
												src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
											<script>
												// 우편번호 찾기 찾기 화면을 넣을 element
												var element_wrap = document
														.getElementById('wrap');

												function foldDaumPostcode() {
													// iframe을 넣은 element를 안보이게 한다.
													element_wrap.style.display = 'none';
												}

												function sample3_execDaumPostcode() {
													// 현재 scroll 위치를 저장해놓는다.
													var currentScroll = Math
															.max(
																	document.body.scrollTop,
																	document.documentElement.scrollTop);
													new daum.Postcode(
															{
																oncomplete : function(
																		data) {
																	// 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

																	// 각 주소의 노출 규칙에 따라 주소를 조합한다.
																	// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
																	var fullAddr = data.address; // 최종 주소 변수
																	var extraAddr = ''; // 조합형 주소 변수

																	// 기본 주소가 도로명 타입일때 조합한다.
																	if (data.addressType === 'R') {
																		//법정동명이 있을 경우 추가한다.
																		if (data.bname !== '') {
																			extraAddr += data.bname;
																		}
																		// 건물명이 있을 경우 추가한다.
																		if (data.buildingName !== '') {
																			extraAddr += (extraAddr !== '' ? ', '
																					+ data.buildingName
																					: data.buildingName);
																		}
																		// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
																		fullAddr += (extraAddr !== '' ? ' ('
																				+ extraAddr
																				+ ')'
																				: '');
																	}

																	// 우편번호와 주소 정보를 해당 필드에 넣는다.
																	document
																			.getElementById('sample3_postcode').value = data.zonecode; //5자리 새우편번호 사용
																	document
																			.getElementById('delivery_address').value = fullAddr;

																	// iframe을 넣은 element를 안보이게 한다.
																	// (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
																	element_wrap.style.display = 'none';

																	// 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
																	document.body.scrollTop = currentScroll;
																},
																// 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
																onresize : function(
																		size) {
																	element_wrap.style.height = size.height
																			+ 'px';
																},
																width : '100%',
																height : '100%'
															})
															.embed(element_wrap);

													// iframe을 넣은 element를 보이게 한다.
													element_wrap.style.display = 'block';
												}
											</script>
											<!-- daum 우편번호 끝 -->
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				
				<label style = "font-size:18px;">결제정보</label>
				<div class = "panel-group">
					<div class = "panel panel-default">
						<div class = "panel-body">
							<div>
								<table class = "table table-hover provideList">
									<thead>
										<tr>
											<th>결제 금액</th>
											<th>${total }</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<th>결제방식</th>
											<td>무통장입금</td>											
											<th>계좌번호</th>
											<td>123-4567-890</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				
				<p style="text-align: center;">
					<input type = "submit" id="payment-button" class="btn btn-primary"	value = "결제하기"
					onclick = "success()">
					
					<script type="text/javascript">
						function success(){
							alert("결제가 완료되었습니다.");
						}
					</script>
					
					<input type="button" value="장바구니로 가기" class="btn btn-primary"
						onclick="history.go(-1)">
				</p>
			</form:form>
		</div>
	</div>

</section>
<!-- #content end -->

<!-- Go To Top
	============================================= -->
<div id="gotoTop" class="icon-angle-up"></div>


