<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>首页</title>
  <link rel="stylesheet" type="text/css" href="/static/themes/default/easyui.css">
  <link rel="stylesheet" type="text/css" href="/static/themes/icon.css">
  <script type="text/javascript" src="/static/js/jquery.min.js"></script>
  <script type="text/javascript" src="/static/js/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="/static/js/easyui-lang-zh_CN.js"></script>
</head>

<body>

<#--begin 数据表格工具栏 -->
<div id="tb" style="padding:5px;height:auto">
  <div style="margin-bottom:5px">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
       onclick="openAddForm()">添加</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="openEditForm()">修改</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
       onclick="deleteRows()">删除</a>
  </div>
  <div>
    用户名: <input class="easyui-textbox" id="username" style="width:80px">
    部门:
    <select id="paramDeptId" class="easyui-combotree"
            data-options="url:'/sys/depts/tree',method:'get'" multiple
            style="width:200px;"></select>
    <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchRows()">查询</a>
  </div>
</div>
<#--end 数据表格工具栏 -->

<table id="dataTable">
</table>


<#--begin 添加或修改数据的表单对话框 -->
<div id="dlg" class="easyui-dialog" style="width:500px;height:auto;padding:10px 20px"
     closed="true" modal="true" buttons="#dlg-buttons">
  <form id="fm">
    <table width="100%">
      <tr hidden>
        <td width="35%">ID</td>
        <td><input class="easyui-textbox" name="userId" style="width:100%;"></td>
      </tr>
      <tr>
        <td width="35%">用户名</td>
        <td><input class="easyui-textbox" name="username" style="width:100%;"></td>
      </tr>
      <tr>
        <td width="35%">密码</td>
        <td><input class="easyui-textbox" name="password" style="width:100%;"></td>
      </tr>
      <tr>
        <td width="35%">手机</td>
        <td><input class="easyui-textbox" name="mobile" style="width:100%;"></td>
      </tr>
      <tr>
        <td width="35%">邮箱</td>
        <td><input class="easyui-textbox" name="email" style="width:100%;"></td>
      </tr>
      <tr>
        <td width="35%">状态</td>
        <td>
          <input type="radio" name="status" value="1" checked="checked"> 启用
          <input type="radio" name="status" value="0"> 禁用
        </td>
      </tr>
      <tr>
        <td width="35%">部门</td>
        <td>  <select class="easyui-combotree"
                      data-options="url:'/sys/depts/tree',method:'get'" name="deptId" style="width:100%;"></select></td>
      </tr>
    </table>
  </form>
</div>
<div id="dlg-buttons">
  <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="submitFormData()">保存</a>
  <a href="#" class="easyui-linkbutton" iconCls="icon-cancel"
     onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>

<#--end 添加或修改数据的表单对话框 -->

<script>
  const ADD_DIALOG_TITLE = '添加信息';
  const EDIT_DIALOG_TITLE = '编辑信息';
  const MESSAGEER_TITLE = '操作提示';
  const MESSAGEER_SUCCESS_MSG = '操作成功!';
  const SELECT_DELETE_ROW_MSG = '请选择要删除的数据!';
  const CONFIRM_DELETE_ROW_MSG = '确认要删除选中的数据吗?';
  const SELECT_SINGLE_ROW_MSG='请不要选择多行数据!';
  const OPERATOR_URL = '/sys/users';

  var $dlg = $('#dlg');
  var $fm = $('#fm');
  var $dt = $("#dataTable");
  var $paramDeptIdComboBox = $("#paramDeptId");
  var submitFormMethod = "POST";

  function openAddForm() {
    $dlg.dialog('open').dialog('setTitle', ADD_DIALOG_TITLE);
    $fm.form('reset');
    submitFormMethod = "POST";
  }
  function openEditForm() {
    var rows = $dt.datagrid('getSelections');
    if (rows.length === 1) {
      $dlg.dialog('open').dialog('setTitle', EDIT_DIALOG_TITLE);
      $fm.form('reset');
      $fm.form('load', rows[0]);
      submitFormMethod = "PUT";
    } else if(rows.length > 1){
      $.messager.show({
        title: MESSAGEER_TITLE,
        msg: SELECT_SINGLE_ROW_MSG,
        timeout: 2000,
        showType: 'slide'
      });
    } else {
      $.messager.show({
        title: MESSAGEER_TITLE,
        msg: SELECT_DELETE_ROW_MSG,
        timeout: 2000,
        showType: 'slide'
      });
    }

  }

  function searchRows() {
    var $tree=$paramDeptIdComboBox.combotree('tree');
    var deptIdList=$tree.tree('getChecked','checked').map( node => {return node.id});
    var paramObj={};
    var usernameValue = $("#username").val();
    if( !usernameValue ) {
      paramObj.username = usernameValue;
    }
    if(deptIdList.length != 0){
      paramObj.deptId=  deptIdList.join(",");
    }
    $dt.datagrid('load', paramObj);
  }
  function deleteRows() {
    var rows = $dt.datagrid('getSelections');
    if (0 != rows.length) {
      $.messager.confirm(MESSAGEER_TITLE, CONFIRM_DELETE_ROW_MSG, function (r) {
        if (r) {
          var obj = [];
          $.each(rows, function (i, v) {
            obj[i] = v.userId;
          });
          $.ajax({
            url: OPERATOR_URL,
            type: 'DELETE',
            data: JSON.stringify(obj),
            dataType: 'json',
            contentType: 'application/json',
            success: function () {

              $dlg.dialog('close');

              $dt.datagrid('reload');

              $.messager.show({
                title: MESSAGEER_TITLE,
                msg: MESSAGEER_SUCCESS_MSG,
                timeout: 3000,
                showType: 'slide'
              });

            },
            error: function (data) {
              $.messager.show({
                title: MESSAGEER_TITLE,
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
        title: MESSAGEER_TITLE,
        msg: SELECT_DELETE_ROW_MSG,
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
      url: OPERATOR_URL,
      type: submitFormMethod,
      data: JSON.stringify(obj),
      dataType: 'json',
      contentType: 'application/json',
      success: function () {

        $dlg.dialog('close');

        $dt.datagrid('reload');

        $.messager.show({
          title: MESSAGEER_TITLE,
          msg: MESSAGEER_SUCCESS_MSG,
          timeout: 3000,
          showType: 'slide'
        });

      },
      error: function (data) {
        $.messager.show({
          title: MESSAGEER_TITLE,
          msg: data.msg,
          timeout: 3000,
          showType: 'slide'
        });
      }
    });
  }

  $(function () {
    $dt.datagrid({
      collapsible: true,
      fitColumns: true,
      toolbar: '#tb',
      fit: true,
      url: OPERATOR_URL,
      method: 'get',
      loadFilter: function (data) {
        var menuData = {};
        menuData.total = data.data.total;
        menuData.rows = data.data.records;
        return menuData;
      },
      pagination: true,
      columns: [[
        {field: 'userId', title: '编号', width: 80},
        {field: 'username', title: '用户名', width: 80},
        {field: 'mobile', title: '手机', width: 80},
        {field: 'deptId', title: '部门', width: 80},
        {field: 'createTime', title: '添加时间', width: 80},
        {field: 'status', title: '状态', width: 80}

      ]]
    });
  });
</script>
</body>
</html>