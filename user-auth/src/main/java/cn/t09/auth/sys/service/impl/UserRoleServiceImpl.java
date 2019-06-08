package cn.t09.auth.sys.service.impl;

import cn.t09.auth.sys.entity.UserRole;
import cn.t09.auth.sys.mapper.UserRoleMapper;
import cn.t09.auth.sys.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与角色对应关系 服务实现类
 * </p>
 *
 * @author t09
 * @since 2019-06-06
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
