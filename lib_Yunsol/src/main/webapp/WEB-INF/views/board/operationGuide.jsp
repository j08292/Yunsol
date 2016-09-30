<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
 
   
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
                <h1>온라인도서관 이용안내</h1>
                <span>Operation Guide</span>
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
                   <form:form action="operationGuide.do" enctype="multipart/form-data" method="get">
         			
         			<h4>1. 온라인 도서관 이용하기</h4>
         				 ▶  &nbsp;&nbsp;저희 온라인 도서관 OOOO은 희망하는 도서를 <b>온라인으로 예약 및 대여</b> 등의 서비스를 제공하는 홈페이지 입니다.<br>
         				  &nbsp;&nbsp;또한 회원들을 대상으로 다양한 <b>강연 및 이벤트</b> 등의 서비스가 제공됩니다. &nbsp;&nbsp;회원 가입 후 도서관의 다양한 서비스를 이용하시길 바랍니다.<br>
         				  편리한 서비스를 제공하기 위해 최선의 노력을 다하고 있으며 사용 안내를 위해 필요한 내용과 변경사항은 본 페이지를 통해 안내해드립니다.
         				 
         				 
         			<br><br><br><br><br>
         			
         			<h4>2. 도서대출  </h4>
         			
         				 ▶ &nbsp;로그인 후 상단의<b> &lt;BOOK &gt;</b>메뉴의 <b>'도서검색'</b>을 통해 희망하는 책을 검색한 후 대여가 가능합니다.<br>
         				 ▶&nbsp; 대여한 도서의 분실 또는 훼손시 동일 도서로 구입 또는 해당 도서의 현시가로 변상해야 합니다.<br>
         				 ▶&nbsp; 대여한 도서를 연체할 경우 도서대여가 일정기간 동안 정지됩니다.
         				 
         			<br><br><br><br><br>
         			
         			<h4>3. 그 외 문의사항  </h4>	 
         				 ▶ &nbsp;홈페이지 이용에 관한 문의사항이 있을 경우 상단의 <b>&lt;BOARD&gt;</b>메뉴의 <span href="${pageContext.request.contextPath}/board/qnaList.do"><b>질문게시판</b></span>을 이용해주시길 바랍니다.<br>
         				 &nbsp; &nbsp; &nbsp;	-  &nbsp;전화 문의(09:00am ~ 18:00pm) :☎ 123-456-7890 
         				 
					<!--
					- 이용안내 규정 정하기!<br>
					 1. 이용방법 - 가입, 대여방법<br>
					 2. 입금기한<br>
					 3. 연체규정?<br>
					 4. 문의사항이 있을 시 게시판으로 이동안내 문구<br>
					 5. 문의사항 - 전화번호, 이메일 안내 문구<br>
									(전화 이용시간 안내)<br>
					
					- 메인화면 사진 or 영상<br> -->
					
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