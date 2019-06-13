# 项目采用技术
- ssm
- easyui

# 子模块说明
- generator 代码生成器 
- commons 通用代码(utils)
- system 权限管理模块

- /模块名/实体名s  GET  分页查询
> GET /sys/menus  分页查询所有菜单
> GET /sys/menus?parentId=1 分页查询父级id为1的子菜单

- /模块名/实体名s  POST  添加操作
- /模块名/实体名s  PUT  修改操作
- /模块名/实体名s  DELETE  删除操作
- /模块名/实体名s/{id}  GET  根据id查询


-  返回结果的形式
```json
{
  "code": 0 // code: 500
  "msg": "success" // "msg":"服务器内部错误"
  "data": []  // 传递服务器数据的地方
}

```

# springmvc使用freemark解析视图
1. 引入freemarker相关的jar包
```xml
        <!--模板引擎-->
        <dependency>
            <groupId>org.freemarker</groupId>
            <artifactId>freemarker</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
        </dependency>        
```
2. 在springmvc的配置文件中配置:
```xml
    <bean class="org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver">
        <!--指定返回给浏览器的内容类型和编码-->
        <property name="contentType" value="text/html;charset=utf-8"/>
        <property name="prefix" value="" />
        <property name="suffix" value=".ftl" />
        <!--当springmvc中存在多个视图解析器的时候,
        会根据order的大小来选择视图解析器解析视图,order小的先执行,如果没有找到,再执行后面解析器 -->
        <property name="order" value="1" />
    </bean>
    <!--freemarker相关的配置-->
    <bean id="freemarkerConfig" class="org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer">
        <!--freemarker模板所在的文件夹-->
        <property name="templateLoaderPath" value="/WEB-INF/views/"></property>
        <!--模板的文件编码-->
        <property name="defaultEncoding" value="UTF-8" />
    </bean>
```