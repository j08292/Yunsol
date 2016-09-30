<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
 
   
    <!-- Stylesheets(지우면안됨X)-->

  
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <!--[if lt IE 9]>
    	<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->

    <!-- External JavaScripts(지우면안됨X) -->
	

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
                  
                   	<form:form action="write.do" enctype="multipart/form-data"
                   								commandNamd="review"
                   								id="register_form"	>
                   	
                   	<form:errors element="div" class="error-color"/>
                   	<ul>
                   		<li>    
                   			<label class="control-label col-sm-3" for="review_title">제목</label>
                   			<form:errors path="review_title" class="error-color"/>
                   			<form:input class="title_nari" path="review_title"/>
                   		</li>
                   		<li>
                   			<label class="control-label col-sm-3" for="review_content">내용</label>
                   			<form:errors path="review_content" class="error-color"/>
                   			<form:textarea class="content_nari" path="review_content" />
                   		</li>
                   		<li>
                   			<label class="control-label col-sm-3" for="upload">파일업로드</label>
                   			<input type="file" name="upload" id="upload">
                   		</li>
                   		
                   		<br>
                   		<li class="align-center">
                   			<input type="submit" class="btn btn-primary btn-sm" value="전송" >
                   			<input type="button" class="btn btn-default btn-sm" value="목록" onclick="location.href='list.do'">
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
    

</body>
</html>