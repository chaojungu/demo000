<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>首页</title>
  <link rel="stylesheet" type="text/css" href="/static/themes/default/easyui.css">
  <link rel="stylesheet" type="text/css" href="static/themes/icon.css">
  <script type="text/javascript" src="/static/js/jquery.min.js"></script>
  <script type="text/javascript" src="/static/js/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="/static/js/easyui-lang-zh_CN.js"></script>
</head>
<body class="easyui-layout">
<div class="easyui-layout" data-options="fit:true">
  <div data-options="region:'center',border:false">
    <table class="easyui-datagrid" id="dg">
    </table>
  </div>
</div>
<script>
  $(function () {
     $("#dg").datagrid({
       itColumns:true,
       autoRowHeight:false,
       pagination:true,
       fit:true,
       loadFilter:function (data) {
         var listData={};
         listData.rows = data.data.records;
         listData.total = data.data.total;
         console.info(listData);
         return listData;
       },
       singleSelect:true,
       url:'/sys/menus',
       method:'get',
       columns:[[
         {field:'menuId',title:'ID',width:80},
         {field:'name',title:'权限名称',width:100},
         {field:'icon',title:'样式',width:100},
         {field:'orderNum',title:'显示顺序',width:80,align:'right'},
         {field:'parentId',title:'父级id',width:80,align:'right'},
         {field:'type',title:'权限类型',width:80,align:'right'}
       ]]
     });
  })
</script>
</body>
</html>