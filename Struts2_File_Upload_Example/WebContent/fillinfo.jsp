<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Email Form</title>
</head>
<body>
   <em>The form below uses Google's SMTP server. 
   So you need to enter a gmail username and password
   </em>
 <body>
 <s:form action="mail" method="POST" enctype="multipart/form-data">
 <s:textarea name="to" label="TO:"/><br/>
 <s:textarea name="subject" label="ENTER SUBJECCT:"/><br>
 <s:textarea name="body" label="ENTER BODY:" /> 
 <s:submit value="SEND" name="submit" />
</s:form>
</body>
</html>