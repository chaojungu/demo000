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

<table id="menuTable">

</table>

<script>
  $(function () {
    $("#menuTable").datagrid({
      singleSelect: true,
      collapsible: true,
      fitColumns:true,
      fit:true,
      url: '/sys/menus',
      method: 'get',
      loadFilter: function (data) {
        var menuData = {};
        menuData.total = data.data.total;
        menuData.rows = data.data.records;
        return menuData;
      },
      pagination: true,
      columns: [[
        {field: 'menuId', title: '编号', width: 80},
        {field: 'name', title: '权限名称', width: 80},
        {field: 'icon', title: '样式名', width: 80},
        {field: 'orderNum', title: '显示顺序', width: 80},
        {field: 'parentId', title: '父级菜单编号', width: 80},
        {field: 'type', title: '菜单类型', width: 80}

      ]]
    });
  });
</script>
</body>
</html>