# 在项目中使用easyui

## 环境准备
1. 下载easyui
2. 在项目的webapp目录下创建一个存放静态资源的文件夹static
3. 把解压之后easyui目录下的themes文件夹复制到static文件夹
4. 复制以下三个js文件到static文件夹的js目录下
    1) 在解压目录下的jquery.min.js
    2) 在解压目录下的jquery.easyui.min.js
    3) 在解压目录下locale目录中的easyui-lang-zh_CN.js
    
## 写页面
  
  
  
 datagrid的返回数据的格式要求: {total:100,rows:[{第一行数据},{第二行数据}]},
 如果返回的数据不符合要求,使用loadFilter属性来自定义一个转换的函数,把返回的数据转为标准的数据格式
 
  