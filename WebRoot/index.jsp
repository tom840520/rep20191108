<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showperson.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type='text/javascript' src='/TestSringJdbc/dwr/interface/showperson.js'></script>
    <script type='text/javascript' src='/TestSringJdbc/dwr/engine.js'></script>
    <script type='text/javascript' src='/TestSringJdbc/dwr/util.js'></script>
 	<script type="text/javascript">
		function testAb()
		{
			alert(1);
			showperson.showPerson(function(data)
			{
				alert(data);
			})
		}
	</script>
  </head>
  
  <body  onload="testAb()">
    
  </body>
</html>
