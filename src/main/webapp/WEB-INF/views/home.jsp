<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />	
	<title>Home</title>
	
	<script src="http://code.jquery.com/jquery.min.js"></script>
	
	<script>
	
	$(document).ready(function() {
        	
        $('#btnReg').click(function(){
        	
        	var param = $('#frmReg').serializeArray();
        	var jsonParam = JSON.stringify(param);
        	
        	$.ajax({
				url: "/homepage/emailRegist.do",
				type: "POST",
				dataType: "json",
				data: jsonParam,
				contentType : "application/json; charset=UTF-8",
				success: function (data) {
					alert(data.rtnMsg);
					$("form").each(function() {  
						this.reset();  
					});
				},
				error:function(request,status,error){
			        alert("code:"+request.status+"\n"+"error:"+error);
			    }
				
			});
        	        	
        })
    
	});
        
        
    </script>
    
</head>
<body>
<h1>
	HiDays HomePage <br/>
	<spring:message code="hidays.title.home" text="HiDays Homepage" />
</h1>

<!-- 
<P>  The time on the server is ${serverTime}. </P>
 -->


<form id="frmReg" name="frmReg" action="/emailResist.co">
	이름 : <input id="userName" name="userName" size="6" type="text" />&nbsp;&nbsp;
	e-mail : <input id="userEmail" name="userEmail" size="20" type="text" />&nbsp;&nbsp;
	<input id="btnReg" name="btnReg" type="button" value="등록" />
</form>

</body>
</html>
