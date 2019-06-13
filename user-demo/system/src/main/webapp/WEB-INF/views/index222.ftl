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
<div data-options="region:'north',border:false" style="height:60px;padding:10px">
  north region
</div>
<div data-options="region:'west',split:true,title:'导航菜单'" style="width:210px;">
  <div id="sm"></div>
</div>
<div data-options="region:'south',border:false"
     style="height:50px;padding:10px;">south region
</div>
<div data-options="region:'center',split:true,collapsible:true">
  <div class="easyui-panel" data-options="fit:true">
    <div class="easyui-tabs" id="tt" data-options="fit:true">
      <div title="首页" style="padding:10px" data-options="fit:true">
        <p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
        <ul>
          <li>easyui is a collection of user-interface plugin based on jQuery.</li>
        </ul>
      </div>
    </div>
  </div>


</div>
<script type="text/javascript">
  var iframe = 1;
  var data = [{
    text: '系统管理',
    iconCls: 'icon-sum',
    state: 'open',
    children: [{
      text: '菜单管理',
      href: '/menu.html'
    }, {
      text: 'Option2'
    }, {
      text: 'Option3',
      children: [{
        text: 'Option31'
      }, {
        text: 'Option32'
      }]
    }]
  }, {
    text: 'Item2',
    iconCls: 'icon-more',
    children: [{
      text: 'Option4'
    }, {
      text: 'Option5'
    }, {
      text: 'Option6'
    }]
  }];

  $('#sm').sidemenu({
    data: data,
    onSelect: function (node) {
      //console.info(node);
      var $tt = $("#tt");
      if ($tt.tabs("exists", node.text)) {
        $tt.tabs("select", node.text);
      } else {
        if (iframe) {
          var content = '<iframe scrolling="auto" frameborder="0"  src="' + node.href + '" style="width:100%;height:100%;"></iframe>';
          $tt.tabs("add", {
            title: node.text,
            content: content,
            fit: true,
            closable: true
          });
        } else {
          $tt.tabs("add", {
            title: node.text,
            href: node.href,
            fit: true,
            closable: true
          });
        }

      }

    }
  });

  function toggle() {
    var opts = $('#sm').sidemenu('options');
    $('#sm').sidemenu(opts.collapsed ? 'expand' : 'collapse');
    opts = $('#sm').sidemenu('options');
    $('#sm').sidemenu('resize', {
      width: opts.collapsed ? 60 : 200
    })
  }
</script>
</body>
</html>