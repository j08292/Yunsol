<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
   <h1 class="align-center">이벤트 상세보기</h1>
   <div class="table-responsive">
       <table class="table table-striped">
          
            <thead>
                <tr>
                   <th colspan="4">글 제목: ${event.event_title}</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                   <th>번호 : ${event.event_num}</th>
                    <th>작성자 : ${event.mem_id}</th>
                    <th style="text-align:right;">등록날짜 : ${event.event_regdate}</th>
                    <th style="text-align:right;">조회수 : ${event.event_hit}</th>
                </tr>
                <tr>
                    <td colspan="4">
                    <br>
                    ${event.event_content}<br>
                    <br>
                    <p>
                   <c:if test="${!empty event.event_filename}">
                    <img src="${pageContext.request.contextPath}/event_upload/${event.event_filename}"></img><br><br>
                 </c:if>                        
                 </p>
                    </td>
                </tr>
            </tbody>
        </table>
    
   
     <div align="right">
     <input type="button" value="목록으로" onclick="location.href='list.do'" class="btn btn-sm btn-info">
     <input type="button" value="삭제"
           onclick="javascript:delete_event(${event.event_num});" class="btn btn-sm btn-danger">
     </div>
     <hr size="1" width="100%">
     
   
   <input type="hidden" name="event_num" value="${event.event_num}" id="event_num">
   <input type="hidden" name="mem_id" value="${userId}" id="userId">
   
   <!-- 목록출력 -->
   <div id="output"></div>
   <div class="paging_button" style="display: none;">
      <input type="button" value="다음글 보기" class="btn btn-xs btn-info">
   </div>
   <div id="loading" style="display: none;">
      <img src="${pageContext.request.contextPath}/resources/user/images/ajax-loader.gif">
   </div>   
</div>