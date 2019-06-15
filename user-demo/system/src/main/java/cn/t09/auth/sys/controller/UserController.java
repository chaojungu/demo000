package cn.t09.auth.sys.controller;

import cn.t09.auth.sys.dto.UserDTO;
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
  * 系统用户 前端控制器
  * </p>
*
* @author t09
* @since 2019-06-12
*/

@Controller
@RequestMapping("/sys/users")


public class UserController extends BaseController {

    @Resource
    private IUserService userService;

    @GetMapping("{userId}")
    @ResponseBody
    public AjaxResult getById(@PathVariable Long userId) {
        User user =  userService.getById(userId);
        return AjaxResult.ok().put(AjaxResult.DATA_TAG, user);
    }

    @PostMapping
    @ResponseBody
    public AjaxResult add(@RequestBody User user)throws Exception {
        userService.save(user);
        return AjaxResult.ok();
    }

    @PutMapping
    @ResponseBody
    public AjaxResult update(@RequestBody User user)throws Exception {
        userService.updateById(user);
        return AjaxResult.ok();
    }

    @DeleteMapping
    @ResponseBody
    public AjaxResult delete(@RequestBody List<Long> userIds)throws Exception {

        userService.removeByIds(userIds);
        return AjaxResult.ok();
    }

  @GetMapping
  @ResponseBody
  public AjaxResult list(@RequestParam(value="page",defaultValue = "1")Long pageIndex,
                         @RequestParam(value="rows",defaultValue = "5")Long pageSize,
      UserDTO user) {
      IPage<User> page  = new Page<>(pageIndex,pageSize);
      userService.pageByDTO(page,user);
      return AjaxResult.ok().put("data",page);
  }

}
