<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jQuery EasyUI Demo</title>
</head>
<%@include file="common.jsp" %>

<body class="easyui-layout">

<div data-options="region:'west',split:true" title="West" style="width:180px;">
    <div class="easyui-accordion" data-options="fit:true,border:false">

        <div title="Title2" data-options="selected:true" style="padding:10px;">
            <ul class="easyui-tree"
                data-options="url:'./res/tree_data1.json',method:'get',animate:true,lines:true"></ul>
            <ul class="easyui-tree">
                <li>
                    <span>Foods</span>
                    <ul>
                        <li>
                            <span>Fruits</span>
                            <ul>
                                <li>apple</li>
                                <li>orange</li>
                            </ul>
                        </li>
                        <li>
                            <span>Vegetables</span>
                            <ul>
                                <li>tomato</li>
                                <li>carrot</li>
                                <li>cabbage</li>
                                <li>potato</li>
                                <li>lettuce</li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>

        <div title="Menu" data-options="iconCls:'icon-search'" style="padding:10px;">
            <a href="#" onclick="addTab('Datagrid','table2.html',true)">Datagrid</a>
        </div>
    </div>
</div>

<!--North-->
<div data-options="region:'north'" style="height:50px"></div>
<!--Center-->
<div data-options="region:'center',title:'',iconCls:'icon-ok'">
    <div id="aa" class="easyui-tabs" data-options="fit:true,border:false,plain:true,tabWidth:112" >
    </div>
</div>
<!--South-->
<div data-options="region:'south',split:true" style="height:25px;">
    <div style="text-align: center; color: gray;">
			<span style="padding-left: 10px;">Copyright
				&nbsp;© 2015</span> &nbsp; 版权所有
    </div>
</div>
</body>

<script type="text/javascript">
    $(document).ready(function() {
        addTab('首页','home.html',false);
    });

    $(function () {
        var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
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
            }]
        });
    })
</script>
</html>