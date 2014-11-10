<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <%@ taglib prefix="s" uri="/struts-tags" %>

<jsp:include page="adminhead.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="viewComp" method="POST">
NO:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<s:property value="compnos"/></br>
SENDER:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<s:property value="sender"/></br>
AGAINST&nbsp&nbsp&nbsp&nbsp&nbsp<s:property value="uname"/></br>
SUBJECT&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<s:property value="subject"/></br>
DETAILS&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<s:property value="details"/></br>
MAIL STATUS:&nbsp&nbsp&nbsp<s:property value="mailst"/></br>
BLOCK HIM
<s:url id="url" action="mailHim" >
<s:param name="uname"><s:property value="uname"/></s:param>
</s:url>
<s:a href="%{url}" >MAIL TO HIM</s:a>
<s:submit value="MOVE TO NEXT" action="changer" method="next"/>
</s:form>
</body>

</html>