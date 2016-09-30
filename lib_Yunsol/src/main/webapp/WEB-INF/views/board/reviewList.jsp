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
	
        <!-- Page Title(지우면안됨X) -->
        <section id="page-title">

            <div class="container clearfix">
                <h3><spring:message code="review.list.title"/></h3>
                <span>감상평게시판 한줄 설명?</span>
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
                   	<form action="list.do" id="search_form" method="get">
                   		<ul class="search">
                   			<li>
                   				<select name="keyfield">
                   					<option value="review_title">제목</option>
                   					<option value="mem_id">ID</option>
                   					<option value="review_content">내용</option>
                   					<option value="all">전체</option>                   					
                   				</select>
                   			</li>
                   			<li>
                   				<input type="text" size="16" name="keyword" >
                   			</li>
                   			<li>
                   				<input type="submit" class="btn btn-default btn-sm" value="찾기">
                   			</li>
                   		</ul>                   		
                   	</form>
                   	<table>
                   		<tr>
                   			<td class="align-right">
                   				
								<input type="button" value="글쓰기" class="btn btn-primary btn-sm"
                   						 onclick="location.href='write.do'"<c:if test="${empty userId }">disabled="disabled"</c:if>>

                   				
                   				<c:if test="${userId }">
                   				<input type="button" value="글쓰기" class="btn btn-primary btn-sm"
                   						 onclick="location.href='write.do'">
                   				 </c:if>
                   			</td>
                   		</tr>                   		
                   	</table>
                   <br>
                   <c:if test="${count == 0 }">
                   	<div class="align-center">등록된 게시글이 없습니다.</div>
                   </c:if>
                   <c:if test="${count > 0 }">
                   <div class="table-responsive">
                   <table class="table" border="1" style="border:1px solid #FFFFFF;">
                  
                   	<tr>
                   		<th>번호</th>
                   		<th>제목</th>
                   		<th>ID</th>
                   		<th>날짜</th>
                   		<th>조회수</th>
                   		<th>좋아요</th>
                   		<th>싫어요</th>
                   	</tr>
                   	<c:forEach var="article" items="${list}">
                   		<tr>
                   			<td>${article.review_num}</td>
                   			<td><a href="detail.do?review_num=${article.review_num}">${article.review_title} <span class="badge">${article.review_replyCount}</span></a></td>
                   			<td>${article.mem_id}</td>
                   			<td>${article.review_regdate}</td>
                   			<td>${article.review_hit}</td>
                   			<td>${article.review_like}</td>
                   			<td>${article.review_dislike}</td>
                   		</tr>
                   		
                   	
                   	</c:forEach>
                   </table>
                   </div>
                   <div class="align-center">${pagingHtml}</div>
                   </c:if>
                   </div>
                    <!-- 내용입력 끝-->

                </div>

            </div>

        </section>
        <br> <br> <br> <br>
        <!-- #content end -->

    
    <!-- Go To Top (지우면안됨X)-->
    <div id="gotoTop" class="icon-angle-up"></div>

    <!-- Footer Scripts (지우면안됨X)-->
   

</body>
</html>