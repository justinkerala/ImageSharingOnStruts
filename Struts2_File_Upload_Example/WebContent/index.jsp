<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
<s:head />
</head>
 <s:actionerror />
 <s:actionmessage/>
 <body>
 <s:form action="uploadAction" method="POST" enctype="multipart/form-data">
 <s:textarea name="Uname" label="ENTER NAME:"/><br/>
 <s:textarea name="Pro_name" label="ENTER USERNAME:"/><br>
 <s:file name="uploadFile" label="ENTER PROFILE PICTURE: " size="40" /> 
 <s:textarea name="Pro_about" label="ABOUT YOU:"/><br>
 <s:textarea name="Pro_cam" label="CAMERA USING:"/><br>
 <s:textarea name="Pro_mail" label="ENTER YOUR EMAIL:"/><br>
 <s:textarea name="Pro_pwd" label="ENTER A PASSWORD:"/><br>
 <s:textarea name="Con_pwd" label="CONFIRM YOUR PASSWORD:"/><br>
 <s:submit value="Upload" name="submit" />
</s:form>
</body>