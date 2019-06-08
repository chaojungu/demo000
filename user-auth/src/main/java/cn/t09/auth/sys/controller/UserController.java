package cn.t09.auth.sys.controller;


import cn.t09.auth.sys.entity.User;
import cn.t09.auth.sys.service.IUserService;
import cn.t09.common.AjaxResult;
import javax.annotation.Resource;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author t09
 * @since 2019-06-06
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("getById")
    public AjaxResult getById(@RequestParam Long userId){
        User user = userService.getById(userId);
        return AjaxResult.ok().put(AjaxResult.DATA_TAG,user);
    }

}
