<jsp:include page="index.jsp"></jsp:include>
<hr/>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:form action="loginprocess">
<s:textfield name="username" label="Name"></s:textfield>
<s:password name="userpass" label="Password"></s:password>
<s:submit value="login"></s:submit>
</s:form>