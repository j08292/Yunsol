<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  


    <!-- Stylesheets(지우면안됨X)-->


    <link rel="stylesheet" href="css/responsive.css" type="text/css" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <!--[if lt IE 9]>
    	<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->

    <!-- External JavaScripts(지우면안됨X) -->
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/plugins.js"></script>
	

        <!-- Page Title(지우면안됨X) -->
        <section id="page-title">

            <div class="container clearfix">
                <h1><spring:message code="review.write.title"/></h1>
                <span>Start Buying your Favourite Theme</span>
                <ol class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li class="active">Shop</li>
                </ol>
            </div>

        </section><!-- #page-title end -->

        <!-- Content(지우면안됨X)-->
        <section id="content">

            <div class="content-wrap">

                <div class="container clearfix">

                   <!-- 내용입력 시작-->
                   <div>
                   	
                   	<form:form action="update.do" enctype="multipart/form-data"
						                               commandName="command"
						                               id="modify_form">
                   	<form:errors element="div" class="error-color"/>
                   		<ul>
                   			<li>
                   				<label for="review_title">제목</label>
                   				<form:input class="title_nari" path="review_title"/>
								<form:errors path="review_title" class="error-color"/>
                   			</li>
                   			<li>
                   				<label for="review_content">내용</label>
                   				<form:textarea class="content_nari" path="review_content"/>
								<form:errors path="review_content" class="error-color"/>
                   			</li>
                   			<li>
                   				<label for="upload">파일업로드</label>
                   				<input type="file" name="upload" id="upload" />								
								<c:if test="${!empty command.review_file }">
								<br>
								<span>(${command.review_file})파일이 등록되어 있습니다.
								다시 업로드하면 기존 파일은 삭제됩니다.</span>
								</c:if>
                   			</li>
                   			<li class="align-center">
                   				<input type="submit" class="btn btn-default" value="전송">
                   				<input type="button" value="목록" class="btn btn-default" 
                   				onclick="location.href='list.do'">
                   			
                   			</li>
                   		</ul>
                   	
                   	</form:form>
                   	
                   </div>
                   
                   
                    <!-- 내용입력 끝-->

                </div>

            </div>

        </section>
        <!-- #content end -->

    
    <!-- Go To Top (지우면안됨X)-->
    <div id="gotoTop" class="icon-angle-up"></div>

    <!-- Footer Scripts (지우면안됨X)-->
    <script type="text/javascript" src="js/functions.js"></script>

</body>
</html>