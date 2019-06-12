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
  * 数据字典表 前端控制器
  * </p>
*
* @author t09
* @since 2019-06-12
*/

@Controller
@RequestMapping("/sys/dicts")


public class DictController extends BaseController {

    @Resource
    private IDictService dictService;

    @GetMapping("{id}")
    @ResponseBody
    public AjaxResult getById(@PathVariable Long id) {
        Dict dict =  dictService.getById(id);
        return AjaxResult.ok().put(AjaxResult.DATA_TAG, dict);
    }

    @PostMapping
    @ResponseBody
    public AjaxResult add(@RequestBody Dict dict)throws Exception {
        dictService.save(dict);
        return AjaxResult.ok();
    }

    @PutMapping
    @ResponseBody
    public AjaxResult update(@RequestBody Dict dict)throws Exception {
        dictService.updateById(dict);
        return AjaxResult.ok();
    }

    @DeleteMapping
    @ResponseBody
    public AjaxResult delete(@RequestBody List<Long> ids)throws Exception {

        dictService.removeByIds(ids);
        return AjaxResult.ok();
    }

  @GetMapping
  @ResponseBody
  public AjaxResult list(@RequestParam(value="page",defaultValue = "1")Long pageIndex,
                         @RequestParam(value="rows",defaultValue = "5")Long pageSize,
                         Dict dict) {
      IPage<Dict> page  = new Page<>(pageIndex,pageSize);
      QueryWrapper<Dict> queryWrapper = new QueryWrapper<>(dict);
      dictService.page(page, queryWrapper);
      return AjaxResult.ok().put("data",page);
  }

}
