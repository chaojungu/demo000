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
  * 用户与角色对应关系 前端控制器
  * </p>
*
* @author t09
* @since 2019-06-12
*/

@Controller
@RequestMapping("/sys/user-roles")


public class UserRoleController extends BaseController {

    @Resource
    private IUserRoleService userRoleService;

    @GetMapping("{id}")
    @ResponseBody
    public AjaxResult getById(@PathVariable Long id) {
        UserRole userRole =  userRoleService.getById(id);
        return AjaxResult.ok().put(AjaxResult.DATA_TAG, userRole);
    }

    @PostMapping
    @ResponseBody
    public AjaxResult add(@RequestBody UserRole userRole)throws Exception {
        userRoleService.save(userRole);
        return AjaxResult.ok();
    }

    @PutMapping
    @ResponseBody
    public AjaxResult update(@RequestBody UserRole userRole)throws Exception {
        userRoleService.updateById(userRole);
        return AjaxResult.ok();
    }

    @DeleteMapping
    @ResponseBody
    public AjaxResult delete(@RequestBody List<Long> ids)throws Exception {

        userRoleService.removeByIds(ids);
        return AjaxResult.ok();
    }

  @GetMapping
  @ResponseBody
  public AjaxResult list(@RequestParam(value="page",defaultValue = "1")Long pageIndex,
                         @RequestParam(value="rows",defaultValue = "5")Long pageSize,
                         UserRole userRole) {
      IPage<UserRole> page  = new Page<>(pageIndex,pageSize);
      QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>(userRole);
      userRoleService.page(page, queryWrapper);
      return AjaxResult.ok().put("data",page);
  }

}
