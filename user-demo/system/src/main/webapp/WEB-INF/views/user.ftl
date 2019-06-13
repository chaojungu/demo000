<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>首页</title>
  <link rel="stylesheet" type="text/css" href="/static/themes/default/easyui.css">
  <link rel="stylesheet" type="text/css" href="/static/themes/icon.css">

  <script type="text/javascript" src="/static/js/jquery.min.js"></script>
  <script type="text/javascript" src="/static/js/jquery.easyui.min.js"></script>
</head>
<body>
<table class="easyui-datagrid" title="Basic DataGrid"
       data-options="singleSelect:true,collapsible:true,url:'/static/data1.json',method:'get'">
  <thead>
  <tr>
    <th data-options="field:'itemid',width:80">Item ID</th>
    <th data-options="field:'productid',width:100">Product</th>
  </tr>
  </thead>
</table>
</body>
</html>