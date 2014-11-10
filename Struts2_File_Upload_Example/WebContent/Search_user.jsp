<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<jsp:include page="header.jsp"></jsp:include>
</head>


 <body>
 
 <s:form action="searchUser" method="POST" enctype="multipart/form-data" >
 <s:textfield name="SearchText" label="SEARCH FOR NAME HERE" /> 
 <s:submit value="SEARCH" name="submit" />

</s:form>


<s:iterator value="comboMeals">
<s:url id="url" action="SearchuserPro">
    <s:param name="uname"><s:property/></s:param>
</s:url>
<s:a href="%{url}" ><s:property/></s:a>
   
  </s:iterator>
</body>
</html>