<jsp:include page="header.jsp"/>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<s:form id="urlRemove" action="Frequests">
  <s:iterator value="freq" status="rowStatus" id="name">
 
 <s:checkbox label="%{name}" name="rowsIndexToAdd" value="#rowStatus.index" fieldValue="%{name}" />
   
 <s:param name="add" ><s:property/></s:param> 
    <!-- output row details -->
  <s:url id="url" action="addhim">
    <s:param name="user"><s:property/></s:param>
</s:url>
 
  </s:iterator>
  <s:actionerror/>
<s:submit value="Add" onclick="%{url}"/>
</s:form>