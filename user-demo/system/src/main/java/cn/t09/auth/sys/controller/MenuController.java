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
  * 菜单管理 前端控制器
  * </p>
*
* @author t09
* @since 2019-06-12
*/

@Controller
@RequestMapping("/sys/menus")


public class MenuController extends BaseController {

    @Resource
    private IMenuService menuService;

    @GetMapping("{menuId}")
    @ResponseBody
    public AjaxResult getById(@PathVariable Long menuId) {
        Menu menu =  menuService.getById(menuId);
        return AjaxResult.ok().put(AjaxResult.DATA_TAG, menu);
    }

    @PostMapping
    @ResponseBody
    public AjaxResult add(@RequestBody Menu menu)throws Exception {
        menuService.save(menu);
        return AjaxResult.ok();
    }

    @PutMapping
    @ResponseBody
    public AjaxResult update(@RequestBody Menu menu)throws Exception {
        menuService.updateById(menu);
        return AjaxResult.ok();
    }

    @DeleteMapping
    @ResponseBody
    public AjaxResult delete(@RequestBody List<Long> menuIds)throws Exception {

        menuService.removeByIds(menuIds);
        return AjaxResult.ok();
    }

  @GetMapping
  @ResponseBody
  public AjaxResult list(@RequestParam(value="page",defaultValue = "1")Long pageIndex,
                         @RequestParam(value="rows",defaultValue = "5")Long pageSize,
                         Menu menu) {
      IPage<Menu> page  = new Page<>(pageIndex,pageSize);
      QueryWrapper<Menu> queryWrapper = new QueryWrapper<>(menu);
      menuService.page(page, queryWrapper);
      return AjaxResult.ok().put("data",page);
  }

}
