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
  * 角色与菜单对应关系 前端控制器
  * </p>
*
* @author t09
* @since 2019-06-12
*/

@Controller
@RequestMapping("/sys/role-menus")


public class RoleMenuController extends BaseController {

    @Resource
    private IRoleMenuService roleMenuService;

    @GetMapping("{id}")
    @ResponseBody
    public AjaxResult getById(@PathVariable Long id) {
        RoleMenu roleMenu =  roleMenuService.getById(id);
        return AjaxResult.ok().put(AjaxResult.DATA_TAG, roleMenu);
    }

    @PostMapping
    @ResponseBody
    public AjaxResult add(@RequestBody RoleMenu roleMenu)throws Exception {
        roleMenuService.save(roleMenu);
        return AjaxResult.ok();
    }

    @PutMapping
    @ResponseBody
    public AjaxResult update(@RequestBody RoleMenu roleMenu)throws Exception {
        roleMenuService.updateById(roleMenu);
        return AjaxResult.ok();
    }

    @DeleteMapping
    @ResponseBody
    public AjaxResult delete(@RequestBody List<Long> ids)throws Exception {

        roleMenuService.removeByIds(ids);
        return AjaxResult.ok();
    }

  @GetMapping
  @ResponseBody
  public AjaxResult list(@RequestParam(value="page",defaultValue = "1")Long pageIndex,
                         @RequestParam(value="rows",defaultValue = "5")Long pageSize,
                         RoleMenu roleMenu) {
      IPage<RoleMenu> page  = new Page<>(pageIndex,pageSize);
      QueryWrapper<RoleMenu> queryWrapper = new QueryWrapper<>(roleMenu);
      roleMenuService.page(page, queryWrapper);
      return AjaxResult.ok().put("data",page);
  }

}
