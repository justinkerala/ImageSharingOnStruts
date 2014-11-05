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
  <s:actionerror />
 <s:actionmessage/>
 <s:form action="uploadUserpic" method="POST" enctype="multipart/form-data" >

 <s:file name="uploadFile" label="UPLOAD YOUR IMAGE HERE: " size="40" /> 
  <s:submit value="Upload" name="submit" />

</s:form>

</body>
</html>