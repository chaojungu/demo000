package cn.t09.auth.sys.controller;

import cn.t09.common.AjaxResult;
import cn.t09.auth.sys.service.*;
import cn.t09.auth.sys.entity.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.List;

/**
 * <p>
 * 部门管理 前端控制器
 * </p>
 *
 * @author t09
 * @since 2019-06-09
 */
@RestController
@RequestMapping("/sys/depts")

public class DeptController {
    @Resource
    private IDeptService deptService;

    @ResponseBody
    @GetMapping("{deptId}")
    public AjaxResult getById(@PathVariable Long deptId) {
        Dept entity = deptService.getById(deptId);
        return AjaxResult.ok().put(AjaxResult.DATA_TAG, entity);
    }

    @PostMapping
    public AjaxResult add(@RequestBody Dept entity) {
        deptService.save(entity);
        return AjaxResult.ok();
    }

    @PutMapping
    public AjaxResult update(@RequestBody Dept entity) {
        deptService.updateById(entity);
        return AjaxResult.ok();
    }

    @DeleteMapping
    public AjaxResult delete(@RequestBody List<Long> deptIds) {

        deptService.removeByIds(deptIds);
        return AjaxResult.ok();
    }

    @GetMapping
    public AjaxResult list(@RequestParam(value = "p", defaultValue = "1") Long pageIndex,
                           @RequestParam(value = "s", defaultValue = "5") Long pageSize,
                           Dept entity) {
        IPage<Dept> page = new Page<>(pageIndex, pageSize);
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>(entity);
        deptService.page(page, queryWrapper);
        return AjaxResult.ok().put("data", page);
    }

}
