<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="container clearfix">
	
	
	
	
	
	
	 <section id="content">

            <div class="content-wrap">

                <div class="container clearfix">
	
	 	<hr size="1" width="100%">
	
		<div>
			<h2 style="text-align:center;">&lt;${notice.notice_title}&gt;</h2>
			<ul style="list-style:none;">
				<li>번호 : ${notice.notice_num}</li>
				<li>작성자 : 운영자</li>
				<li>조회수 : ${notice.notice_hit}</li>
				<li>등록날짜 : ${notice.notice_regdate}</li>
			</ul>
					<hr size="1" width="100%">
						
			
			
			<br><br>
			<p>${notice.notice_content}</p>
			
		</div>
		<br><br><br><br><br><br>
			<div style="text-align:center;">
			<a href="list.do" class="btn btn-default btn-sm">목록으로</a>
			</div>
		
		
		    </div>

            </div>

        </section>
		
		<%-- <div class="page-title-center">
			<h2>${notice.notice_title}</h2>
			<div style="text-align:right;">
				<a href="list.do">목록으로</a>
			</div>
		</div>
	</section>
	<ul style="list-style:none;">
		<li>번호 : ${notice.notice_num}</li>
		<li>작성자 : 운영자</li>
		<li>조회수 : ${notice.notice_hit}</li>
		<li>등록날짜 : ${notice.notice_regdate}</li>
	</ul>
	<hr size="1" width="100%">
	<p>${notice.notice_content}</p>
	<hr size="1" width="100%">	 --%>
</div>