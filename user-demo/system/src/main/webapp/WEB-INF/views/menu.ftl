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

<#--begin 数据表格工具栏 -->
<div id="tb" style="padding:5px;height:auto">
  <div style="margin-bottom:5px">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
       onclick="openAddForm()">添加</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="openEditForm()">修改</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
       onclick="doDelRow()">删除</a>
  </div>
  <div>
    Date From: <input class="easyui-datebox" style="width:80px">
    To: <input class="easyui-datebox" style="width:80px">
    Language:
    <select class="easyui-combobox" panelHeight="auto" style="width:100px">
      <option value="java">Java</option>
      <option value="c">C</option>
      <option value="basic">Basic</option>
      <option value="perl">Perl</option>
      <option value="python">Python</option>
    </select>
    <a href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a>
  </div>
</div>
<#--end 数据表格工具栏 -->

<table id="dataTable">
</table>

<#--begin 添加或修改数据的表单对话框 -->
<div id="dlg" class="easyui-dialog" style="width:500px;height:auto;padding:10px 20px"
     closed="true" modal="true" buttons="#dlg-buttons">
  <form id="fm">
    <div style="margin-bottom:20px" hidden>
      <input class="easyui-textbox" name="menuId"
             style="width:100%" data-options="label:'ID'">
    </div>
    <div style="margin-bottom:20px">
      <input class="easyui-textbox" name="name"
             style="width:100%" data-options="label:'菜单名称',required:true">
    </div>
    <div style="margin-bottom:20px">
      <input class="easyui-textbox" name="icon"
             style="width:100%" data-options="label:'样式名'">
    </div>
    <div style="margin-bottom:20px">
      <input class="easyui-textbox" name="orderNum" value="0"
             style="width:100%" data-options="label:'显示顺序'">
    </div>
    <div style="margin-bottom:20px">
      <input class="easyui-textbox" name="parentId"
             style="width:100%" data-options="label:'父级菜单'">
    </div>
    <div style="margin-bottom:20px">
      <select class="easyui-combobox" name="type" label="菜单类型" required style="width:100%">
        <option value="0">目录</option>
        <option value="1">菜单</option>
        <option value="2">按钮</option>
      </select>
    </div>
  </form>
</div>
<div id="dlg-buttons">
  <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="submitFormData()">保存</a>
  <a href="#" class="easyui-linkbutton" iconCls="icon-cancel"
     onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>
<#--end 添加或修改数据的表单对话框 -->

<script>

  var $dlg = $('#dlg');
  var $fm = $('#fm');
  var $dt = $("#dataTable");
  var submitFormMethod = "POST";

  function openAddForm() {
    $dlg.dialog('open').dialog('setTitle', '添加信息');
    $fm.form('clear');
    submitFormMethod = "POST";
  }
  function openEditForm() {
    var row = $dt.datagrid('getSelected');
    if (row) {
      $dlg.dialog('open').dialog('setTitle', '编辑信息');
      $fm.form('clear');
      $fm.form('load', row);
      submitFormMethod = "PUT";
    }

  }
  function doDelRow() {
    var rows = $dt.datagrid('getSelections');
    if (0 != rows.length) {
      $.messager.confirm('操作提示', '你却认要删除数据吗', function (r) {
        if (r) {
          var obj = [];
          $.each(rows, function (i, v) {
            obj[i] = v.menuId;
          });
          $.ajax({
            url: '/sys/menus',
            type: 'DELETE',
            data: JSON.stringify(obj),
            dataType: 'json',
            contentType: 'application/json',
            success: function () {
              $dlg.dialog('close');
              $dt.datagrid('reload');
              $.messager.show({
                title: '操作提示',
                msg: '操作成功',
                timeout: 3000,
                showType: 'slide'
              });
            },
            error: function (data) {
              $.messager.show({
                title: '操作提示',
                msg: data.msg,
                timeout: 3000,
                showType: 'slide'
              });
            }
          });
        }
      });
    } else {
      $.messager.show({
        title: '操作提示',
        msg: '请选择要删除的数据',
        timeout: 2000,
        showType: 'slide'
      });
    }
  }
  function submitFormData() {
    var data = $fm.serializeArray();
    var obj = {};

    $.each(data, function (i, v) {
      obj[v.name] = v.value;
    })

    $.ajax({
      url: '/sys/menus',
      type: submitFormMethod,
      data: JSON.stringify(obj),
      dataType: 'json',
      contentType: 'application/json',
      success: function () {
        $dlg.dialog('close');
        $dt.datagrid('reload');
        $.messager.show({
          title: '操作提示',
          msg: '操作成功',
          timeout: 3000,
          showType: 'slide'
        });
      },
      error: function (data) {
        $.messager.show({
          title: '操作提示',
          msg: data.msg,
          timeout: 3000,
          showType: 'slide'
        });
      }
    });
  }

  $(function () {
    $dt.treegrid({
      idField: 'menuId',
      treeField: 'name',
      singleSelect: true,
      collapsible: true,
      fitColumns: true,
      toolbar: '#tb',
      fit: true,
      url: '/sys/menus?rows=-1',
      method: 'get',
      loadFilter: function (data) {
        var menuData = {};
        menuData.total = data.data.total;
        menuData.rows = data.data.records;
        menuData.rows.map(d => {
          if (d.parentId != 0) {
            d._parentId = d.parentId
          }
        });
        return menuData;
      },
      columns: [[
        {field: 'menuId', title: '编号', width: 80},
        {field: 'name', title: '权限名称', width: 80},
        {field: 'icon', title: '样式名', width: 80},
        {field: 'orderNum', title: '显示顺序', width: 80},
        {
          field: 'type', title: '菜单类型', width: 80, formatter: function (value, row, rowIndex) {
            return value == 0 ? '目录' :  (value == 1 ? '菜单' : '按钮');
          }
        }

      ]]
    });
  });
</script>
</body>
</html>