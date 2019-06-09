package ${package.Controller};

<#assign serviceIntanceName = "${table.serviceName?substring(1)?uncap_first}">
<#list table.fields as field>
    <#if field.keyFlag>
        <#assign keyPropertyName="${field.propertyName}"/>
    </#if>
</#list>
import cn.t09.common.AjaxResult;
import ${package.Service}.*;
import ${package.Entity}.*;

import org.springframework.web.bind.annotation.RequestMapping;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

import java.util.List;
/**
* <p>
  * ${table.comment!} 前端控制器
  * </p>
*
* @author ${author}
* @since ${date}
*/
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}s<#else>${table.entityPath}s</#if>")

<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>
    @Resource
    private ${table.serviceName} ${serviceIntanceName};

    @GetMapping("{${keyPropertyName}}")
    public AjaxResult getById(@PathVariable Long ${keyPropertyName}) {
        ${entity} entity =  ${serviceIntanceName}.getById(${keyPropertyName});
        return AjaxResult.ok().put(AjaxResult.DATA_TAG, entity);
    }

    @PostMapping
    public AjaxResult add(@RequestBody ${entity} entity) {
        ${serviceIntanceName}.save(entity);
        return AjaxResult.ok();
    }

    @PutMapping
    public AjaxResult update(@RequestBody ${entity} entity) {
        ${serviceIntanceName}.updateById(entity);
        return AjaxResult.ok();
    }

    @DeleteMapping
    public AjaxResult delete(@RequestBody List<Long>  ${keyPropertyName}s) {

        ${serviceIntanceName}.removeByIds(${keyPropertyName}s);
        return AjaxResult.ok();
    }

  @GetMapping
  public AjaxResult list(@RequestParam(value="p",defaultValue = "1")Long pageIndex,
                         @RequestParam(value="s",defaultValue = "5")Long pageSize,
                         ${entity} entity) {
      IPage<${entity}> page  = new Page<>(pageIndex,pageSize);
      QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>(entity);
      ${serviceIntanceName}.page(page, queryWrapper);
      return AjaxResult.ok().put("data",page);
  }

}
