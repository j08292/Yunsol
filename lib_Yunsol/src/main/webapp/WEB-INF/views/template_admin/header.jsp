<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c"	uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/admin/main.do">관리자 페이지</a>
            </div>
            <!-- Top Menu Items -->
            	
            <ul class="nav navbar-right top-nav">
            	<li>
            		<a href="${pageContext.request.contextPath }/main/main.do">사용자 페이지</a>
            	</li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>
						${userId }님
					 <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href = "${pageContext.request.contextPath }/member/logout.do"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#mem_manage"><i class="fa fa-user"></i> 회원 관리 <i class="fa fa-fw fa-caret-down"></i></a>
                    	<ul id="mem_manage" class="collapse">
                            <li>
                                <a href="${pageContext.request.contextPath}/admin/member/list.do">회원 정보 조회</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/admin/blockmember/list.do">차단 회원 관리</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#book_manage"><i class="fa fa-fw fa-file"></i> 도서관리  <i class="fa fa-fw fa-caret-down"></i></a>
                   		<ul id="book_manage" class="collapse">
                            <li><a
						href="${pageContext.request.contextPath}/admin/booklist/list.do">도서
							현황</a></li>
					<li><a
						href="${pageContext.request.contextPath}/admin/bookrent/list.do">대출
							현황</a></li>
					<li><a
						href="${pageContext.request.contextPath}/admin/wishlist/list.do">희망
							도서</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/admin/speech/list.do"><i class="fa fa-fw fa-table"></i> 강연 관리</a>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#board_manage"><i class="fa fa-fw fa-edit"></i> 게시판 관리  <i class="fa fa-fw fa-caret-down"></i></a>
                    	<ul id="board_manage" class="collapse">
                            <li><a
						href="${pageContext.request.contextPath}/admin/notice/list.do">공지사항</a>
					</li>
					<li><a href="${pageContext.request.contextPath}/admin/review/list.do">감상평</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/grade/list.do">한줄평</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/qna/list.do">QnA</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#event_manage"><i class="fa fa-fw fa-dashboard"></i> 이벤트 관리  <i class="fa fa-fw fa-caret-down"></i></a>
                    	<ul id="event_manage" class="collapse">
                            
                            <li>
                                <a href="${pageContext.request.contextPath }/admin/event/list.do">이벤트 목록</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath }/admin/marathon/list.do">독서마라톤 완주자</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>