<%@ page import="org.apache.struts.action.*,
                 java.util.Iterator"%>
<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:errors/>
<html:messages id="msg" message="true" header="messages.header" footer="messages.footer" >
 <bean:write name="msg" />
</html:messages>
<html:form action="resource.do"  enctype="multipart/form-data"> 
<html:hidden property="action"/>
<html:hidden property="resourceId"/>
<html:hidden property="userId"/>
<html:hidden property="file"/>

<html:hidden property="contentType"/>
<tr><td>
	<table width="100%"cellspacing="0" cellpadding="0"><tr>
	<td><img src="images/table1.gif"></td>
	<td width="100%" class="tableheader"><bean:message key="resource.add.title"/></td>
	<td><img src="images/table2.gif"></td>
	</tr></table>
</td></tr>

<tr><td>
	<table width="100%" cellspacing="0" cellpadding="0"><tr>
		
		<td width="5" heigh="10" style="background-image: url(images/table4.gif);"></td>
		<td><table width="100%" cellspacing="0" cellpadding="0">		
		<tr>
			<td height="10" class="tabledata"><table border="0" width="100%" cellspacing="5"><tr><td class="maintext"><nobr><bean:message key="resource.name"/></nobr></td></tr></table></td>
			<td height="10" class="tabledata"><table border="0" width="100%" cellspacing="5"><tr><td class="maintext"><html:text  property="resourceName" size="28"/></td></tr></table></td>
		</tr> 
		<tr>
			<td height="10" class="tabledata"><table border="0" width="100%" cellspacing="5"><tr><td class="maintext"><nobr><bean:message key="resource.type"/></nobr></td></tr></table></td> 
			<td height="10" class="tabledata"><table border="0" width="100%" cellspacing="5"><tr><td class="maintext"><html:select  property="typeId" styleClass="defType"><html:optionsCollection property="typesCollection" /></html:select></td></tr></table></td> 
		</tr>
		<tr>
			<td height="10" class="tabledata"><table border="0" width="100%" cellspacing="5"><tr><td class="maintext"><nobr><bean:message key="resource.file"/></nobr></td></tr></table></td> 
			<td height="10" class="tabledata"><table border="0" width="100%" cellspacing="5"><tr><td class="maintext"><html:file property="theFile" size="50"/></td></tr></table></td>
		</tr> 
		
		<tr>
			<td height="10" colspan="2" class="tabledata"><table border="0" width="100%" cellspacing="5"><tr><td class="maintext"><html:submit /></td></tr></table></td>
		</tr>
		
		</table></td>
		<td width="6" heigh="10" style="background-image: url(images/table5.gif);"></td>
		
	</tr></table>
</td></tr>

<tr><td>
	<table width="100%" cellspacing="0" cellpadding="0"><tr>
	<td><img src="images/table6.gif"></td>
	<td width="100%" heigh="10" style="background-image: url(images/table8.gif);"></td>
	<td><img src="images/table7.gif"></td>
	</tr></table>
</td></tr>
</html:form>