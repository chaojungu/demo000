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
<body class="easyui-layout">
<div data-options="region:'north',border:false">north region</div>
<div data-options="region:'west',split:true,title:'West'" style="width:150px;">
  <div id="sm"></div>
</div>
<div data-options="region:'south',border:false">south region</div>
<div data-options="region:'center',title:'Center'">
      <div id="tt" class="easyui-tabs" data-options="fit:true">
        <div title="首页" style="padding:20px;display:none;" data-options="fit:true">
          tab1
        </div>
      </div>
</div>

<script type="text/javascript">
  var menuData = [
                {
                    text: '系统管理',
                    iconCls: 'icon-sum',
                    state: 'open',
                    children: [{
                      text: '用户管理',
                      url:'/user.html'
                    }, {
                      text: '权限管理',
                      url: '/menu.html'
                    }, {
                      text: '部门管理',
                      url: '/dept.html'
                    }, {
                      text: '字典管理',
                      url: '/dict.html'
                    }, {
                      text: '日志管理',
                      url: '/log.html'
                    }, {
                      text: '角色管理',
                      url: '/role.html'
                    }]
                 },
                {
                  text: '一级菜单12',
                  iconCls: 'icon-more',
                  state: 'open',
                  children: [{
                    text: '二级菜单21'
                  }, {
                    text: '二级菜单22'
                  }]
                }
      ];


  $(function () {
    $.ajax({
      url:'/sys/menus/tree',
      type:'GET',
      dataType:'json',
      success:function (data) {
        $("#sm").sidemenu({
          data:data,
          width:'100%',
          onSelect:function(menu){
            console.info(menu);
            // 点击菜单的时候,显示选项卡
            if($("#tt").tabs('exists',menu.text)){
              $("#tt").tabs('select',menu.text);
            }else{
              var iframeContent='<iframe name="main" frameborder="0" src="'+menu.attributes.url+'" scrolling="yes" width="100%" height="98%"></iframe>';
              $("#tt").tabs('add',{
                title:menu.text,
                content:iframeContent,
                fit:true,
                closable: true
              });
            }

          }
        });
      }
    });


  });
</script>
</body>
</html>