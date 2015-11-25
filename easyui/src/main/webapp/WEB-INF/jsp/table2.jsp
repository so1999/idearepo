<%@include file="common.jsp" %>
<table id="dg" title="Datagrid"
       data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true,url:'selectAll.html',method:'get'">
    <thead>
    <tr>
        <th data-options="field:'userId',width:100">User ID</th>
        <th data-options="field:'userName',width:150">User Name</th>
        <th data-options="field:'password',width:100,align:'left'">Password</th>
        <th data-options="field:'lastIp',width:200,align:'left'">Last IP</th>
        <th data-options="field:'lastVisit',width:240">Last Visit</th>
    </tr>
    </thead>
</table>
<script type="text/javascript">
    $(function () {
        var pager = $('#dg').datagrid().datagrid('getPager');
        pager.pagination({
            buttons: [{
                iconCls: 'icon-search',
                handler: function () {
                    alert('search');
                }
            }, {
                iconCls: 'icon-add',
                handler: function () {
                    alert('add');
                }
            }, {
                iconCls: 'icon-edit',
                handler: function () {
                    edit('#dg','edit');
                }
            }]
        });
    })
</script>


