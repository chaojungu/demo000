package cn.t09.auth.sys.service.impl;

import cn.t09.auth.sys.entity.RoleMenu;
import cn.t09.auth.sys.mapper.RoleMenuMapper;
import cn.t09.auth.sys.service.IRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色与菜单对应关系 服务实现类
 * </p>
 *
 * @author t09
 * @since 2019-06-06
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

}
