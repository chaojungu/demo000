package cn.t09.auth.sys.controller;


import cn.t09.auth.sys.entity.User;
import cn.t09.auth.sys.service.IUserService;
import cn.t09.common.AjaxResult;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author t09
 * @since 2019-06-06
 */
@RestController
@RequestMapping("/sys/users")
public class UserController {

    @Resource
    private IUserService userService;

    // 根据id获取用户信息
    @GetMapping("{userId}")
    public AjaxResult getById(@PathVariable Long userId) {
        User user = userService.getById(userId);
        return AjaxResult.ok().put(AjaxResult.DATA_TAG, user);
    }

    // 添加用户信息
    @PostMapping
    public AjaxResult add(@RequestBody User user) {
        userService.save(user);
        return AjaxResult.ok();
    }

    // 修改用户信息
    @PutMapping
    public AjaxResult update(@RequestBody User user) {
        userService.updateById(user);
        return AjaxResult.ok();
    }

    // 删除用户信息
    @DeleteMapping
    public AjaxResult delete(@RequestBody List<Long> userIds) {
        // 系统管理员不能被删除
        if (userIds.indexOf(1L) > 0) {
            return AjaxResult.error("系统管理员不能被删除");
        }

        // 当前用户不能被删除

        // 删除指定用户信息
        userService.removeByIds(userIds);

        return AjaxResult.ok();
    }

    // 分页获取用户信息
    @GetMapping
    public AjaxResult list(@RequestParam(value="p",defaultValue = "1")Long pageIndex,
                           @RequestParam(value="s",defaultValue = "5")Long pageSize,
                           User user) {
        IPage<User> page  = new Page<>(pageIndex,pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
        queryWrapper.orderByDesc("create_time");
        userService.page(page, queryWrapper);
        return AjaxResult.ok().put("data",page);
    }

}
