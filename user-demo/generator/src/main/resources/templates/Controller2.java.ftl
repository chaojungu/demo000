package ${package.Controller};

<#assign serviceIntanceName = "${table.serviceName?substring(1)?uncap_first}">
import ${package.Service}.*;
import ${package.Entity}.*;
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import com.t09.demo.common.domain.AjaxResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
* <p>
  * ${table.comment!} 前端控制器
  * </p>
*
* @author ${author}
* @since ${date}
*/

@Controller
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}s<#else>${table.entityPath}s</#if>")


public class ${table.controllerName} extends ${superControllerClass} {

    @Resource
    private ${table.serviceName} ${serviceIntanceName};

    @GetMapping("{${keyProperty}}")
    @ResponseBody
    public AjaxResult getById(@PathVariable ${keyPropertyType} ${keyProperty}) {
        ${entity} ${entity?uncap_first} =  ${serviceIntanceName}.getById(${keyProperty});
        return AjaxResult.ok().put(AjaxResult.DATA_TAG, ${entity?uncap_first});
    }

    @PostMapping
    @ResponseBody
    public AjaxResult add(@RequestBody ${entity} ${entity?uncap_first})throws Exception {
        ${serviceIntanceName}.save(${entity?uncap_first});
        return AjaxResult.ok();
    }

    @PutMapping
    @ResponseBody
    public AjaxResult update(@RequestBody ${entity} ${entity?uncap_first})throws Exception {
        ${serviceIntanceName}.updateById(${entity?uncap_first});
        return AjaxResult.ok();
    }

    @DeleteMapping
    @ResponseBody
    public AjaxResult delete(@RequestBody List<${keyPropertyType}> ${keyProperty}s)throws Exception {

        ${serviceIntanceName}.removeByIds(${keyProperty}s);
        return AjaxResult.ok();
    }

  @GetMapping
  @ResponseBody
  public AjaxResult list(@RequestParam(value="page",defaultValue = "1")Long pageIndex,
                         @RequestParam(value="rows",defaultValue = "5")Long pageSize,
                         ${entity} ${entity?uncap_first}) {
      IPage<${entity}> page  = new Page<>(pageIndex,pageSize);
      QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>(${entity?uncap_first});
      ${serviceIntanceName}.page(page, queryWrapper);
      return AjaxResult.ok().put("data",page);
  }

}
