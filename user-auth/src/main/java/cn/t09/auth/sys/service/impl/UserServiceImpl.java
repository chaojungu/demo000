package cn.t09.auth.sys.service.impl;

import cn.t09.auth.sys.entity.User;
import cn.t09.auth.sys.mapper.UserMapper;
import cn.t09.auth.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author t09
 * @since 2019-06-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
