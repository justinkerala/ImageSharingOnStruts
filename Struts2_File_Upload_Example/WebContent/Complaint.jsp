<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp"/>
<%@ taglib prefix="s" uri="/struts-tags" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="sendcomplaint" method="POST" >
<s:select list="friends" name="friend"></s:select>
<s:textarea name="Subject" label="ENTER SUBJECT:"/><br/>
<s:textarea name="Details" label="ENTER DETAILS:"/><br>
<s:submit/>
</s:form>

</body>
</html>