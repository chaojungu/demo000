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
  * 角色 前端控制器
  * </p>
*
* @author t09
* @since 2019-06-12
*/

@Controller
@RequestMapping("/sys/roles")


public class RoleController extends BaseController {

    @Resource
    private IRoleService roleService;

    @GetMapping("{roleId}")
    @ResponseBody
    public AjaxResult getById(@PathVariable Long roleId) {
        Role role =  roleService.getById(roleId);
        return AjaxResult.ok().put(AjaxResult.DATA_TAG, role);
    }

    @PostMapping
    @ResponseBody
    public AjaxResult add(@RequestBody Role role)throws Exception {
        roleService.save(role);
        return AjaxResult.ok();
    }

    @PutMapping
    @ResponseBody
    public AjaxResult update(@RequestBody Role role)throws Exception {
        roleService.updateById(role);
        return AjaxResult.ok();
    }

    @DeleteMapping
    @ResponseBody
    public AjaxResult delete(@RequestBody List<Long> roleIds)throws Exception {

        roleService.removeByIds(roleIds);
        return AjaxResult.ok();
    }

  @GetMapping
  @ResponseBody
  public AjaxResult list(@RequestParam(value="page",defaultValue = "1")Long pageIndex,
                         @RequestParam(value="rows",defaultValue = "5")Long pageSize,
                         Role role) {
      IPage<Role> page  = new Page<>(pageIndex,pageSize);
      QueryWrapper<Role> queryWrapper = new QueryWrapper<>(role);
      roleService.page(page, queryWrapper);
      return AjaxResult.ok().put("data",page);
  }

}
