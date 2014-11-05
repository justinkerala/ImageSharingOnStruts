<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
 <body background="d:\Myuploads\chilgAma.jpg">
<s:actionmessage/>
<s:actionerror/>
<form action="LoginCheck" method="post" class="login" >
<h1>SnapShare</h1>
<s:textfield name="uname" cssClass="login-input" />
<s:password name="pwd" cssClass="login-input"/>
<s:submit value="LOGIN" ccsClass="login-submit" align="center"/>
 <p class="login-help"><a href="<s:url value="/index.jsp"  />" target="_blank">REGISTER</a></p>

</form>
</body>
</html>