<tr>
<td>
<table width="100%" cellspacing="0" cellpadding="0">
<html:form action="filter">
<tr>
    <td width="5" heigh="10"
        style="background-image: url(images/table4.gif);"></td>
    <td class="tabledata">&nbsp;<bean:message key="select.categories"/>:</td>
    <td width="6" heigh="10"
        style="background-image: url(images/table5.gif);"></td>
</tr>
<tr>
    <td width="5" heigh="10"
        style="background-image: url(images/table4.gif);"></td>
    <td class="tabledata">
        <table border="0" cellspacing="5">
            <tr>
                <td><bean:message key="possible.choices"/><br/>
                    <html:select property="selectedCategorys" multiple="true"
                                 styleId="uiOptionTransfer_source1"
                                 styleClass="uiOptionTransfer_target">
                        <html:optionsCollection property="categorys"/>
                    </html:select></td>
                <td><input type="button" value="&raquo;"
                           title='<bean:message key="move.all.options.to.target"/>'
                           onClick="uiOptionTransfer_transferAll(uiOptionTransfer_object1);selectionChanged(); return false;"/>
                    <br/>
                    <input type="button" value="&gt;"
                           title='<bean:message key="move.selected.options.to.target.list"/>'
                           onClick="uiOptionTransfer_transfer(uiOptionTransfer_object1);selectionChanged(); return false;"/>
                    <br/>
                    <input type="button" value="&lt;"
                           title='<bean:message key="delete.selected.options.from.target"/>'
                           onClick="uiOptionTransfer_return(uiOptionTransfer_object1);selectionChanged(); return false;"/>
                    <br/>
                    <input type="button" value="&laquo;"
                           title='<bean:message key="delete.all.options.from.target"/>'
                           onClick="uiOptionTransfer_returnAll(uiOptionTransfer_object1); selectionChanged();return false;"/>
                </td>
                <td><bean:message key="actual.selection"/><br/>
                    <html:select property="selectedCategorys"
                                 styleId="uiOptionTransfer_target1"
                                 multiple="true"
                                 onchange="selectionChanged();"
                                 styleClass="uiOptionTransfer_target">
                        <html:optionsCollection property="categorys2"/>
                    </html:select>
                    <html:hidden styleId="categoriesPriorities" property="categoriesPriorities"/>
                </td>
                
                <%--<td><div id="slider" /></td>--%>
                <td><div id="slider" style="visibility:hidden;" /></td>
            </tr>
        </table>
    </td>
    <td width="6" heigh="10"
        style="background-image: url(images/table5.gif);"></td>
</tr>
<tr>


    <!-- Script for this menu--->
    <script language="javascript">
        var uiOptionTransfer_object1;


        function uiOptionTransfer_init1() {
            var src = document.getElementById('uiOptionTransfer_source1');

            uiOptionTransfer_object1 = new uiOptionTransfer_Globals(null, null, 'uiOptionTransfer_source1', 'uiOptionTransfer_target1', 'uiOptionTransfer_distance1');
            uiOptionTransfer_fillStates(uiOptionTransfer_object1);
            uiOptionTransfer_onSubmit(uiOptionTransfer_object1);
        }

        sliderValuesArray = new Object();
        currentlySelectedCategoryIndex = 0;

        uiOptionTransfer_init1();
    </script>
    <tr>
        <td width="5" heigh="10"
            style="background-image: url(images/table4.gif);"></td>
        <td class="tabledata">&nbsp;<bean:message key="select.positions"/>:</td>
        <td width="6" heigh="10"
            style="background-image: url(images/table5.gif);"></td>
    </tr>
    <!-- Page positions ------>
    <tr>
        <td width="5" heigh="10"
            style="background-image: url(images/table4.gif);"></td>
        <td class="tabledata">
            <table border="0" cellspacing="5">
                <tr>
                    <td><bean:message key="possible.choices"/><br/>
                        <html:select property="selectedCategorys" multiple="true"
                                     styleId="uiOptionTransfer_source2"
                                     styleClass="uiOptionTransfer_target">
                            <html:optionsCollection property="pagePositionsCollection1"/>
                        </html:select></td>
                    <td><input type="button" value="&raquo;"
                               title='<bean:message key="move.all.options.to.target"/>'
                               onClick="uiOptionTransfer_transferAll(uiOptionTransfer_object2); return false;"/>
                        <br/>
                        <input type="button" value="&gt;"
                               title='<bean:message key="move.selected.options.to.target.list"/>'
                               onClick="uiOptionTransfer_transfer(uiOptionTransfer_object2); return false;"/>
                        <br/>
                        <input type="button" value="&lt;"
                               title='<bean:message key="delete.selected.options.from.target"/>'
                               onClick="uiOptionTransfer_return(uiOptionTransfer_object2); return false;"/>
                        <br/>
                        <input type="button" value="&laquo;"
                               title='<bean:message key="delete.all.options.from.target"/>'
                               onClick="uiOptionTransfer_returnAll(uiOptionTransfer_object2); return false;"/>
                    </td>
                    <td><bean:message key="actual.selection"/><br/>
                        <html:select property="selectedCategorys"
                                     styleId="uiOptionTransfer_target2" multiple="true"
                                     styleClass="uiOptionTransfer_target">
                            <html:optionsCollection property="pagePositionsCollection2"/>
                        </html:select></td>
                </tr>
            </table>
        </td>
        <td width="6" heigh="10"
            style="background-image: url(images/table5.gif);"></td>
    </tr>
<tr>


    <!-- Script for this menu--->
    <script language="javascript">
        var uiOptionTransfer_object2;


        function uiOptionTransfer_init2() {
            var src = document.getElementById('uiOptionTransfer_source2');

            uiOptionTransfer_object2 = new uiOptionTransfer_Globals(null, null, 'uiOptionTransfer_source2', 'uiOptionTransfer_target2', 'uiOptionTransfer_distance2');
            uiOptionTransfer_fillStates(uiOptionTransfer_object2);
            uiOptionTransfer_onSubmit(uiOptionTransfer_object2);
        }



        uiOptionTransfer_init2();
        function allPlacesClick(checked)
        {
            if (checked)
            {
                document.getElementById('uiOptionTransfer_category3').disabled = 'disabled';
                document.getElementById('uiOptionTransfer_source3').disabled = 'disabled';
                document.getElementById('uiOptionTransfer_target3').disabled = 'disabled';
                document.getElementById('allPlaces').value = true;

            }
            else
            {
                document.getElementById('uiOptionTransfer_category3').disabled = undefined;
                document.getElementById('uiOptionTransfer_source3').disabled = undefined;
                document.getElementById('uiOptionTransfer_target3').disabled = undefined;
                document.getElementById('allPlaces').value = false;
            }
        }
    </script>
    
    <tr>
        <td width="5" heigh="10"
            style="background-image: url(images/table4.gif);"></td>
        <td class="tabledata">
            <table border="0" cellspacing="5">
                <tr>
                    <td colspan="3"><html:checkbox property="allPlaces"
                                                   styleId="oldallPlaces" onclick="allPlacesClick(checked);"/>
                        <bean:message
                                key="display.creatives.on.all.adplaces"/></td>
                </tr>
            </table>
        </td>
        <td width="6" heigh="10"
            style="background-image: url(images/table5.gif);"></td>
    </tr>
<tr>
    
    <tr>
        <td width="5" heigh="10"
            style="background-image: url(images/table4.gif);"></td>
        <td class="tabledata">&nbsp;<bean:message key="select.certain"/>:</td>
        <td width="6" heigh="10"
            style="background-image: url(images/table5.gif);"></td>
    </tr>
    <tr>
        <td width="5" heigh="10"
            style="background-image: url(images/table4.gif);"></td>
        <td class="tabledata">
            <table border="0" cellspacing="5">
                <tr>
                    <td><bean:message key="possible.choices"/><br/>
                        <select id="uiOptionTransfer_category3"
                                class="uiOptionTransfer_category"
                                onchange="uiOptionTransfer_fillSrc(uiOptionTransfer_object3),
	 	uiOptionTransfer_fillStates(uiOptionTransfer_object3);">
                        </select> <br/>
                        <select id="uiOptionTransfer_source3"
                                class="uiOptionTransfer_target" multiple="multiple">
                        </select></td>
                    <td><input type="button" value="&raquo;"
                               title='<bean:message key="move.all.options.to.target"/>'
                               onClick="uiOptionTransfer_transferAll(uiOptionTransfer_object3); return false;"/>
                        <br/>
                        <input type="button" value="&gt;"
                               title='<bean:message key="move.selected.options.to.target.list"/>'
                               onClick="uiOptionTransfer_transfer(uiOptionTransfer_object3); return false;"/>
                        <br/>
                        <input type="button" value="&lt;"
                               title='<bean:message key="delete.selected.options.from.target"/>'
                               onClick="uiOptionTransfer_return(uiOptionTransfer_object3); return false;"/>
                        <br/>
                        <input type="button" value="&laquo;"
                               title='<bean:message key="delete.all.options.from.target"/>'
                               onClick="uiOptionTransfer_returnAll(uiOptionTransfer_object3); return false;"/>
                    </td>
                    <td><bean:message key="actual.selection"/><br/>
                        <select id="uiOptionTransfer_target3"
                                class="uiOptionTransfer_target" multiple="multiple">
                        </select></td>
                </tr>
            </table>
        </td>
        <td width="6" heigh="10"
            style="background-image: url(images/table5.gif);"></td>
    </tr>
<tr>
    
    <script language="javascript">
        var uiOptionTransfer_object3;




        function uiOptionTransfer_init3() {
            cats = new Array();
            var arr;

        <%=form.generateSourceStructure()%>

            uiOptionTransfer_object3 = new uiOptionTransfer_Globals(cats, 'uiOptionTransfer_category3', 'uiOptionTransfer_source3', 'uiOptionTransfer_target3', 'uiOptionTransfer_distance3');
            uiOptionTransfer_fillCat(uiOptionTransfer_object3);
            uiOptionTransfer_fillSrc(uiOptionTransfer_object3);
            uiOptionTransfer_fillTgt3(uiOptionTransfer_object3);
            uiOptionTransfer_onSubmit(uiOptionTransfer_object3);
            uiOptionTransfer_fillStates(uiOptionTransfer_object3);
        }

        function uiOptionTransfer_fillTgt3(obj) {
            var src = document.getElementById(obj.sourceId);
            var tgt = document.getElementById(obj.targetId);
            var item;
            var opt;
        <%=form.generateTargetStructure()%>


        }

        uiOptionTransfer_init3();
    </script>
</html:form>


<html:form action="filter" styleId="filterActionForm2">
    <html:hidden property="filterType"/>
    <html:hidden property="filterAction"/>
    <html:hidden property="campainId"/>
    <html:hidden property="bannerId" />
    <html:hidden property="selectedCategorysName"
                 styleId="selectedCategorysId"/>
    <html:hidden property="selectedPositions"
                 styleId="selectedPositionsId"/>
    <html:hidden property="registeredPlaces" styleId="selectedPlacesId"/>
    <html:hidden property="allPlaces" styleId="allPlaces"/>
    <td width="5" heigh="10"
        style="background-image: url(images/table4.gif);"></td>
    <td class="tabledata" cellspacing="5">
        <hr/>
        <table border="0" cellspacing="5" cellpadding="5">
            <tr>
                <td><img src="images/icons/update.png" style="cursor: pointer;"
                         onclick="selectionChanged();transform_categorys(uiOptionTransfer_object1,false);filterActionForm2.submit();"
                         title="<%=Msg.fetch("update",request)%>"
                         alt="<%=Msg.fetch("update",request)%>"/></td>
               <%-- <td><img src="images/icons/reset.png" style="cursor: pointer;"
                         onclick="document.location='<%=response.encodeURL("filter.do?filterAction=reset&filterType="+form.getFilterType()+"&campainId="+form.getCampainId())%> '"
                         title="<%=Msg.fetch("reset.content.filter.options",request)%>"
                         alt="<%=Msg.fetch("reset.content.filter.options",request)%>"/></td>
                <td><img src="images/icons/reset.png" style="cursor: pointer;"
                         onclick="selectionChanged();document.location='<%=response.encodeURL("filter.do?filterAction=resetAll&filterType="+form.getFilterType()+"&campainId="+form.getCampainId())%> '"
                         title="<%=Msg.fetch("reset.all.filters.options",request)%>"
                         alt="<%=Msg.fetch("reset.all.filters.options",request)%>"/></td>
                <td><img src="images/icons/save.png" style="cursor: pointer;"
                         onclick="selectionChanged();document.location='<%=response.encodeURL("filter.do?dataSource=template&templateAction=import&campainId="+form.getCampainId())%> '"
                         title="<%=Msg.fetch("save.all.filters.options.as.template",request)%>"
                         alt="<%=Msg.fetch("save.all.filters.options.as.template",request)%>"/>
                </td> --%>
            </tr>
        </table>
    </td>
    <td width="6" heigh="10"
        style="background-image: url(images/table5.gif);"></td>
</tr>
</table>
</td>
</tr>
<tr>
    <td>
        <table width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td><img src="images/table6.gif"></td>
                <td width="100%" heigh="10"
                    style="background-image: url(images/table8.gif);"></td>
                <td><img src="images/table7.gif"></td>
            </tr>
        </table>
    </td>
</tr>
</html:form>
<script language="javascript">
    allPlacesClick(document.getElementById('oldallPlaces').checked);
</script>