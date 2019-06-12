package cn.t09.auth.sys.service.impl;

import cn.t09.auth.sys.entity.Role;
import cn.t09.auth.sys.mapper.RoleMapper;
import cn.t09.auth.sys.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author t09
 * @since 2019-06-12
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
