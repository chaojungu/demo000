package cn.t09.auth.sys.service.impl;

import cn.t09.auth.sys.entity.Menu;
import cn.t09.auth.sys.mapper.MenuMapper;
import cn.t09.auth.sys.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author t09
 * @since 2019-06-06
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
