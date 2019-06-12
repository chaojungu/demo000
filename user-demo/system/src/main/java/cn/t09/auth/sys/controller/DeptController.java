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
  * 部门管理 前端控制器
  * </p>
*
* @author t09
* @since 2019-06-12
*/

@Controller
@RequestMapping("/sys/depts")


public class DeptController extends BaseController {

    @Resource
    private IDeptService deptService;

    @GetMapping("{deptId}")
    @ResponseBody
    public AjaxResult getById(@PathVariable Long deptId) {
        Dept dept =  deptService.getById(deptId);
        return AjaxResult.ok().put(AjaxResult.DATA_TAG, dept);
    }

    @PostMapping
    @ResponseBody
    public AjaxResult add(@RequestBody Dept dept)throws Exception {
        deptService.save(dept);
        return AjaxResult.ok();
    }

    @PutMapping
    @ResponseBody
    public AjaxResult update(@RequestBody Dept dept)throws Exception {
        deptService.updateById(dept);
        return AjaxResult.ok();
    }

    @DeleteMapping
    @ResponseBody
    public AjaxResult delete(@RequestBody List<Long> deptIds)throws Exception {

        deptService.removeByIds(deptIds);
        return AjaxResult.ok();
    }

  @GetMapping
  @ResponseBody
  public AjaxResult list(@RequestParam(value="page",defaultValue = "1")Long pageIndex,
                         @RequestParam(value="rows",defaultValue = "5")Long pageSize,
                         Dept dept) {
      IPage<Dept> page  = new Page<>(pageIndex,pageSize);
      QueryWrapper<Dept> queryWrapper = new QueryWrapper<>(dept);
      deptService.page(page, queryWrapper);
      return AjaxResult.ok().put("data",page);
  }

}
