<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String keyfield  =  request.getParameter("keyfield");
	
	if(keyfield.equals("mem_id")){
		
	 out.println("<input type='text' size='16' name='keyword'>"); 
	}else{
	 out.println("<select name='keyword'>");
	 out.println("<option value=''>선택하세요</option> "); 
	 out.println("<option value='0'>신청중</option> "); 
	 out.println("<option value='1'>신청 확정</option> "); 
	 out.println("<option value='2'>취소 신청</option> "); 
	 out.println("<option value='3'>취소 완료</option> ");
	 out.println("</select>");
	}
	
%>