<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<section id="page-title">

            <div class="container clearfix">
                <h1>Password Forms</h1>
                <ol class="breadcrumb">
                    <li><a href="#">Home</a></li>
                    <li><a href="qnaList.do">QnA List</a></li>
                    <li class="active">Password Forms</li>
                </ol>
            </div>

</section>

<section id="content">
	<div class="content-wrap">
		<div class="container clearfix">
			<form:form id="conditional-form" action="qnaPasswd.do" commandName="qnaCommand" method="post" class="nobottommargin" novalidate="novalidate">
			   <div class="col_full">
			       <label for="form-condition-1">Enter Password</label>
			       <form:password path="qna_passwd" class="sm-form-control required" id="form-condition-1" name="form-condition-1" value=""/>
			   		<form:errors element="div" class="error-color" />
			   </div>
			
			   <div class="col_full" id="form-condition-submit" style="display:none;">
			        <button class="button button-3d nomargin" type="submit">확인</button>
			    </div>
			</form:form>
		</div>
	</div>
</section>

<script>
jQuery(document).ready( function($){
    var conditionValidator = $("#conditional-form").validate({
        rules: {
            'form-condition-1': {
                required: true,
                minlength: 4
            }
        }
    });

    $('#form-condition-1').bind('input propertychange', function() {
    	  if( conditionValidator.element( "#form-condition-1" ) === true ) {
              $('#form-condition-submit').fadeIn();
          } else {
              $('#form-condition-submit').fadeOut();
          }
    	});

    });
</script>
