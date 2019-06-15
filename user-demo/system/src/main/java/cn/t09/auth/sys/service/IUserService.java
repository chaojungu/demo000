package cn.t09.auth.sys.service;

import cn.t09.auth.sys.dto.UserDTO;
import cn.t09.auth.sys.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author t09
 * @since 2019-06-12
 */
public interface IUserService extends IService<User> {

    IPage<User> pageByDTO(IPage<User> page, UserDTO user);
}
