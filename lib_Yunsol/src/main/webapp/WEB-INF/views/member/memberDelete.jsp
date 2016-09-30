<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Stylesheets
	============================================= -->

<!-- Document Title
	============================================= -->
<title>회원탈퇴</title>


<!-- Page Title
		============================================= -->
<section id="page-title">

	<div class="container clearfix">
		<h1>회원탈퇴</h1>
		<ol class="breadcrumb">
			<li><a href = "${pageContext.request.contextPath}/member/update.do" style = "font-size: 10pt;">회원정보 수정</a></li>
			<li><a href = "${pageContext.request.contextPath}/member/detail.do" style = "font-size: 10pt;">회원 상세정보</a></li>
			<li><a href = "${pageContext.request.contextPath}/member/delete.do" style = "font-size: 10pt;">회원 탈퇴</a></li>
					
		</ol>
	</div>

</section>
<!-- #page-title end -->

<!-- Content
		============================================= -->
<section id="content">

	<div class="content-wrap">

		<div class="container clearfix">

			<div class="tabs divcenter nobottommargin clearfix"
				id="tab-login-register" style="max-width: 500px;">

				<ul class="tab-nav tab-nav2 center clearfix">
					<li class="inline-block"><a href="#tab-login">회원 탈퇴</a></li>
				</ul>

				<div class="tab-container">

					<div class="tab-content clearfix" id="tab-login">
						<div class="panel panel-default nobottommargin">
							<div class="panel-body" style="padding: 40px;">

								<form:form path="delete-form" class="nobottommargin"
									action="delete.do" method="post">

									<li class="col_full"><label for="mem_passwd">비밀번호:</label>
										<form:password path="mem_passwd" class="form-control" /> <form:errors
											path="mem_passwd" class="error-color" /></li>
									

									<div class="col_full nobottommargin">
										<input type="submit"
											class="button button-3d button-black nomargin" value="탈퇴">
									</div>

								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

