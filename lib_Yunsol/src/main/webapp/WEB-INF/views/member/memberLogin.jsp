<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!-- Document Title
	============================================= -->
<title>로그인</title>


<!-- Page Title
		============================================= -->
<section id="page-title">

	<div class="container clearfix">
		<h1>로그인</h1>
		<ol class="breadcrumb">
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
					<li class="inline-block"><a href="#tab-login">로그인</a></li>
					<!-- <li class="inline-block"><a href="#tab-register">Register</a></li> -->
				</ul>

				<div class="tab-container">

					<div class="tab-content clearfix" id="tab-login">
						<div class="panel panel-default nobottommargin">
							<div class="panel-body" style="padding: 40px;">
							<%-- 	<form id="login-form" name="login-form" class="nobottommargin"
									action="write.do" method="post"> --%>

									<form:form action="login.do" commandName="command"
										id="login-form" class="nobottommargin">
										<form:errors element="div" class="error-color" />
										<span>${reason}</span>
										<br>
										<span>${blockcanceldate}</span>

										<li class="col_full"><label for="mem_id">아이디:</label>
											<form:input path="mem_id" class="form-control" />
											<form:errors path="mem_id" class="error-color"/>
										</li>

										<li class="col_full"><label for="mem_passwd">비밀번호:</label>
											<form:password path="mem_passwd" class="form-control" />
											<form:errors path="mem_passwd" class="error-color"/>	
										</li>

										<li class="col_full nobottommargin">
										<p style = "text-align:center; margin: 0 auto;"><input type="submit" 
											class="button button-3d button-black nomargin" value="로그인">
										</p>
								</form:form>
								
								
						
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>