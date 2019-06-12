package cn.t09.auth.sys.controller;

import cn.t09.auth.sys.service.*;
import cn.t09.auth.sys.entity.*;
import com.t09.demo.common.controller.BaseController;
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
  * 角色与部门对应关系 前端控制器
  * </p>
*
* @author t09
* @since 2019-06-12
*/

@Controller
@RequestMapping("/sys/role-depts")


public class RoleDeptController extends BaseController {

    @Resource
    private IRoleDeptService roleDeptService;

    @GetMapping("{id}")
    @ResponseBody
    public AjaxResult getById(@PathVariable Long id) {
        RoleDept roleDept =  roleDeptService.getById(id);
        return AjaxResult.ok().put(AjaxResult.DATA_TAG, roleDept);
    }

    @PostMapping
    @ResponseBody
    public AjaxResult add(@RequestBody RoleDept roleDept)throws Exception {
        roleDeptService.save(roleDept);
        return AjaxResult.ok();
    }

    @PutMapping
    @ResponseBody
    public AjaxResult update(@RequestBody RoleDept roleDept)throws Exception {
        roleDeptService.updateById(roleDept);
        return AjaxResult.ok();
    }

    @DeleteMapping
    @ResponseBody
    public AjaxResult delete(@RequestBody List<Long> ids)throws Exception {

        roleDeptService.removeByIds(ids);
        return AjaxResult.ok();
    }

  @GetMapping
  @ResponseBody
  public AjaxResult list(@RequestParam(value="page",defaultValue = "1")Long pageIndex,
                         @RequestParam(value="rows",defaultValue = "5")Long pageSize,
                         RoleDept roleDept) {
      IPage<RoleDept> page  = new Page<>(pageIndex,pageSize);
      QueryWrapper<RoleDept> queryWrapper = new QueryWrapper<>(roleDept);
      roleDeptService.page(page, queryWrapper);
      return AjaxResult.ok().put("data",page);
  }

}
