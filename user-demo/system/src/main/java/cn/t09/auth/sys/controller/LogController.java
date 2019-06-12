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
  * 系统日志 前端控制器
  * </p>
*
* @author t09
* @since 2019-06-12
*/

@Controller
@RequestMapping("/sys/logs")


public class LogController extends BaseController {

    @Resource
    private ILogService logService;

    @GetMapping("{id}")
    @ResponseBody
    public AjaxResult getById(@PathVariable Long id) {
        Log log =  logService.getById(id);
        return AjaxResult.ok().put(AjaxResult.DATA_TAG, log);
    }

    @PostMapping
    @ResponseBody
    public AjaxResult add(@RequestBody Log log)throws Exception {
        logService.save(log);
        return AjaxResult.ok();
    }

    @PutMapping
    @ResponseBody
    public AjaxResult update(@RequestBody Log log)throws Exception {
        logService.updateById(log);
        return AjaxResult.ok();
    }

    @DeleteMapping
    @ResponseBody
    public AjaxResult delete(@RequestBody List<Long> ids)throws Exception {

        logService.removeByIds(ids);
        return AjaxResult.ok();
    }

  @GetMapping
  @ResponseBody
  public AjaxResult list(@RequestParam(value="page",defaultValue = "1")Long pageIndex,
                         @RequestParam(value="rows",defaultValue = "5")Long pageSize,
                         Log log) {
      IPage<Log> page  = new Page<>(pageIndex,pageSize);
      QueryWrapper<Log> queryWrapper = new QueryWrapper<>(log);
      logService.page(page, queryWrapper);
      return AjaxResult.ok().put("data",page);
  }

}
