<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
 <%@ taglib prefix = "c"	uri = "http://java.sun.com/jsp/jstl/core" %>
   
    <!-- Stylesheets(지우면안됨X)-->
	
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
                <h3><spring:message code="review.list.title"/></h3>
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
                  <form:form action="qnaUpdate.do" enctype="multipart/form-data"
						                               commandName="qnaCommand"
						                               id="modify_form">
                  <ul>
	                  <li>
	                  	<label for="qna_title">제목</label>
	                  	<form:input class="title_nari" path="qna_title"/>
						<form:errors path="qna_title" class="qna_title"/>
	                  </li>
	                  <li>
	                 <label for="qna_content">비밀번호</label>
	                  <form:password path="qna_passwd" />
                   	<form:errors path="qna_passwd" class="error-color"/>
                   	</li>
                  <li>
                   	<label for="qna_content">내용</label>
                   	<form:textarea class="content_nari" path="qna_content"/>
					<form:errors path="qna_content" class="error-color"/>
                  </li>
                  <li class="align-center">
                 	<input type="submit" class="btn btn-default btn-sm" value="전송">
                 	<input type="button" class="btn btn-default btn-sm" value="목록" 
                 	onclick="location.href='qnaList.do'">
                 </li>
                  </ul>
                  
                  
                  </form:form>
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