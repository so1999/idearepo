<%--
  User: Sun
  Date: 2015/11/20
  Time: 17:41
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<script type="text/javascript" src="./res/jquery.min.js"></script>
<script type="text/javascript" src="./res/jquery.easyui.min.js"></script>
<script type="text/javascript" src="./res/common.js"></script>
<link rel="stylesheet" type="text/css" href="./res/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="./res/themes/icon.css">
<link rel="stylesheet" type="text/css" href="./res/themes/demo.css">

<script type="text/javascript">
    $(function () {
        var fcolumn = [[{
            field: "ID",
            checkbox: true
        }]];
        var columns = [[{
            field: "usrId",
            title: "ID",
            width: 160,
            align: 'center'
        },{
            field: "usrName",
            title: "用户名",
            width: 160,
            align: 'center'
        }, {
            field: "password",
            title: "密码",
            width: 200,
            align: 'center'
        }, {
            field: "lastIp",
            title: "Last IP",
            width: 200,
            align: 'center'
        }, {
            field: "lastVisit",
            title: "最后登陆",
            width: 200,
            align: 'center'
        }]];
        datagrid("#tt", "", "selectAll.html", "#tb", "id", columns, fcolumn);
    });
</script>
<div id="tb" style="height: 28px; display: none; overflow:hidden">
    <div style="margin: 2px;">
        Date From: <input class="easyui-datebox" style="width:110px">
        To: <input class="easyui-datebox" style="width:110px">
        Language:
        <select class="easyui-combobox" panelHeight="auto" style="width:100px">
            <option value="java">Java</option>
            <option value="c">C</option>
            <option value="basic">Basic</option>
        </select>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a>
    </div>
</div>
<table id="tt">
</table>

<script type="text/javascript">
    $(function () {
        var pager = $('#tt').datagrid().datagrid('getPager');
        pager.pagination({
            buttons: [{
                iconCls: 'icon-add',
                handler: function () {
                    alert('add');
                }
            }, {
                iconCls: 'icon-edit',
                handler: function () {
                    alert('edit');
                }
            }, {
                iconCls: 'icon-remove',
                handler: function () {
                    alert('remove');
                }
            }]
        });
    })
</script>

