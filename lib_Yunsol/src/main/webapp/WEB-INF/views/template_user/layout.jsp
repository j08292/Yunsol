<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%-- stylesheet와 javascript 링크 ignore="true"로 설정하면 null일 때 실행되지 않음--%>
<tiles:importAttribute name="cssList" ignore="true"/>
<tiles:importAttribute name="jsList" ignore="true"/>  
<!DOCTYPE html>
<html dir="ltr" lang="en-US">
<head>

	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="author" content="SemiColonWeb" />

	<!-- Stylesheets
	============================================= -->
	<c:forEach var="cssName" items="${cssList}">
		<link rel="stylesheet" href="<c:out value='${cssName}'/>" type="text/css" />
	</c:forEach>   
	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
	<!--[if lt IE 9]>
		<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
	<![endif]-->

	<!-- External JavaScripts
	============================================= -->
	<c:forEach var="jsName" items="${jsList}">
		<script src="<c:out value='${jsName}' />"></script>
	</c:forEach>
	<!-- Document Title
	============================================= -->
	<title>Library</title>

</head>

<body class="stretched">

	<!-- Document Wrapper
	============================================= -->
	<div id="wrapper" class="clearfix">
		<!-- 헤더 시작 -->
		<tiles:insertAttribute name="header"/>
		<!-- 헤더 끝 -->
		<!-- 바디 시작 -->
		<tiles:insertAttribute name="body"/>
		<!-- 바디 끝 -->
		<!-- #content end -->
		<!-- 푸터 시작 -->
		<tiles:insertAttribute name="footer"/>
		<!-- 푸터 끝 -->
	</div><!-- #wrapper end -->

	<!-- Go To Top
	============================================= -->
	<div id="gotoTop" class="icon-angle-up"></div>

	<!-- Footer Scripts
	============================================= -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/user/js/functions.js"></script>

</body>
</html>