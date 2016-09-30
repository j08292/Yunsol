<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Page Heading -->
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">
			관리자페이지 <small>Statistics Overview</small>
		</h1>
		<ol class="breadcrumb">
			<li class="active"><i class="fa fa-dashboard"></i> Dashboard</li>
		</ol>
	</div>
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="alert alert-info alert-dismissable">
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">&times;</button>
			<i class="fa fa-info-circle"></i> <strong>Hello ${userId}?</strong> Try
			out SB Admin 2 for additional features!
		</div>
	</div>
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-3 col-md-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-6">
						<h3>대여 대기자</h3>
					</div>
					<div class="col-xs-6 text-right">
						<div class="huge">${rentWaitingCount}</div>
						<div>New Lending!</div>
					</div>
				</div>
			</div>
			<a href="${pageContext.request.contextPath}/admin/bookrent/list.do?keyfield=rent_status&keyword=3">
				<div class="panel-footer">
					<span class="pull-left">View Details</span> <span
						class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
					<div class="clearfix"></div>
				</div>
			</a>
		</div>
	</div>
	<div class="col-lg-3 col-md-6">
		<div class="panel panel-green">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-6">
						<h3>희망 도서</h3>
					</div>
					<div class="col-xs-6 text-right">
						<div class="huge">${wishlistCount}</div>
						<div>New Application!</div>
					</div>
				</div>
			</div>
			<a href="${pageContext.request.contextPath}/admin/wishlist/list.do?keyfield=wish_status&keyword=0">
				<div class="panel-footer">
					<span class="pull-left">View Details</span> <span
						class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
					<div class="clearfix"></div>
				</div>
			</a>
		</div>
	</div>	
	<div class="col-lg-3 col-md-6">
		<div class="panel panel-yellow">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-6">
						<!-- <i class="fa fa-comments fa-5x"></i> -->
						<h3>강연 신청자</h3>
					</div>
					<div class="col-xs-6 text-right">
						<div class="huge">${speechReserveCount}</div>
						<div>New Applicant!</div>
					</div>
				</div>
			</div>
			<a href="${pageContext.request.contextPath}/admin/speech/noCheckReserveList.do">
				<div class="panel-footer">
					<span class="pull-left">View Details</span> <span
						class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
					<div class="clearfix"></div>
				</div>
			</a>
		</div>
	</div>
	<div class="col-lg-3 col-md-6">
		<div class="panel panel-red">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-6">
						<!-- <i class="fa fa-comments fa-5x"></i> -->
						<h3>강연 취소자</h3>
					</div>
					<div class="col-xs-6 text-right">
						<div class="huge">${speechCancelCount}</div>
						<div>New Revoker!</div>
					</div>
				</div>
			</div>
			<a href="${pageContext.request.contextPath}/admin/speech/speechReserveCancelList.do">
				<div class="panel-footer">
					<span class="pull-left">View Details</span> <span
						class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
					<div class="clearfix"></div>
				</div>
			</a>
		</div>
	</div>	
</div>
<div class="row">
	<div class="col-lg-3 col-md-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-6">
						<h3>도서 예약자</h3>
					</div>
					<div class="col-xs-6 text-right">
						<div class="huge">${bookReserveCount}</div>
						<div>New Reservation!</div>
					</div>
				</div>
			</div>
			<a href="${pageContext.request.contextPath}/admin/bookrent/list.do?keyfield=rent_status&keyword=2">
				<div class="panel-footer">
					<span class="pull-left">View Details</span>
					<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
					<div class="clearfix"></div>
				</div>
			</a>
		</div>
	</div>
	<div class="col-lg-3 col-md-6">
		<div class="panel panel-green">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-6">
						<h3>마라톤 완주자</h3>
					</div>
					<div class="col-xs-6 text-right">
						<div class="huge">${marathonCount}</div>
						<div>New Finisher!</div>
					</div>
				</div>
			</div>
			<a href="${pageContext.request.contextPath}/admin/marathon/list.do?keyfield=marathon_status&keyword=0">
				<div class="panel-footer">
					<span class="pull-left">View Details</span> <span
						class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
					<div class="clearfix"></div>
				</div>
			</a>
		</div>
	</div>
	<div class="col-lg-3 col-md-6">
		<div class="panel panel-yellow">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-7">
						<h3>QnA 답변대기</h3>
					</div>
					<div class="col-xs-5 text-right">
						<div class="huge">${qnaWaitingCount}</div>
						<div>New Question!</div>
					</div>
				</div>
			</div>
			<a href="${pageContext.request.contextPath}/admin/qna/list.do?keyfield=qna_replyCount&keyword=답변대기">
				<div class="panel-footer">
					<span class="pull-left">View Details</span> <span
						class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
					<div class="clearfix"></div>
				</div>
			</a>
		</div>
	</div>
	<div class="col-lg-3 col-md-6">
		<div class="panel panel-red">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-7">
						<h3>지난 이벤트</h3>
					</div>
					<div class="col-xs-5 text-right">
						<div class="huge">${prevEventCount}</div>
						<div>New PrevEvent!</div>
					</div>
				</div>
			</div>
			<a href="${pageContext.request.contextPath}/admin/event/prevEventList.do">
				<div class="panel-footer">
					<span class="pull-left">View Details</span> <span
						class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
					<div class="clearfix"></div>
				</div>
			</a>
		</div>
	</div>
</div>

<!-- 차단회원 관리 -->

	<div class="row">
		<div class="col-lg-2">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<i class="fa fa-fw fa-user"></i> 차단회원
					</h3>
				</div>
				<div class="panel-body">
				<c:if test="${penaltyRowCount == 0}">
				현재 차단된 회원이 없습니다.
				</c:if>
				<c:if test="${penaltyRowCount > 0}">
					<div class="list-group">
						<c:forEach var="penalty" items="${penaltyList}">
							<a href="${pageContext.request.contextPath}/admin/blockmember/list.do?keyfield=mem_id&keyword=${penalty.mem_id}" class="list-group-item"> <span class="badge">${penalty.regdate_String}</span>ID: ${penalty.mem_id}
							</a>
						</c:forEach>
					</div>
				</c:if>
					<div class="text-right">
						<a href="${pageContext.request.contextPath}/admin/blockmember/list.do">View All Activity <i
							class="fa fa-arrow-circle-right"></i></a>
					</div>
				</div>
			</div>
		</div>

<!-- 차단회원 관리 -->

<!-- 인기도서 차트 -->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
   google.charts.load('current', {'packages':['corechart', 'bar' ]});
   google.charts.setOnLoadCallback(drawChart);
   
   function drawChart() {      
      var data1 = google.visualization.arrayToDataTable([
            [ '', '도서 대여량', '희망도서 신청 수' , '신규 입고 도서량'],
            [ '두달전', ${bookRentCount_2}, ${wishlistCount_2}, ${booklistCount_2}],
            [ '한달전', ${bookRentCount_1}, ${wishlistCount_1}, ${booklistCount_1}],
            [ '이번달',${bookRentCount_0}, ${wishlistCount_0}, ${booklistCount_0}] ]);

      var data2 = google.visualization.arrayToDataTable([
               ['list_title', 'rent_count'],
               <c:forEach var="article" items="${rentRankList}" end="1">
                        ['${article.list_title}', ${article.rent_count}],
               </c:forEach>
                     <c:forEach var="article" items="${rentRankList}" begin="2">
                        ['${article.list_title}', ${article.rent_count}]
               </c:forEach>
             ]); 
      
      var options1 = {
      };
      var options2 = {
                   pieHole: 0.5,
                   pieSliceTextStyle: {
                     color: 'black'
                   }
                 };

      var chart1 = new google.charts.Bar(document.getElementById('columnchart_material'));
      var chart2 = new google.visualization.PieChart(document.getElementById('donut_single'));
      chart1.draw(data1, options1);
      chart2.draw(data2, options2);
   }   
   
</script>
<!-- 인기도서 차트 -->

	<div class="col-lg-5">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="fa fa-long-arrow-right fa-fw"></i>인기도서
				</h3>
			</div>
			<div id="donut_single" style="width: 100%; height: 300px;"></div>
		</div>
	</div>
	<div class="col-lg-5">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="fa fa-bar-chart-o fa-fw"></i> 최근 3개월 도서 현황
				</h3>
			</div>
			<div class="panel-body">
				<div id="columnchart_material" style="width: 100%; height: 270px;"></div>
			</div>
		</div>
	</div>
</div>
<!-- 최근 3개월 도서현황 비교 -->