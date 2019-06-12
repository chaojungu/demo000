package cn.t09.auth.sys.service.impl;

import cn.t09.auth.sys.entity.RoleDept;
import cn.t09.auth.sys.mapper.RoleDeptMapper;
import cn.t09.auth.sys.service.IRoleDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色与部门对应关系 服务实现类
 * </p>
 *
 * @author t09
 * @since 2019-06-12
 */
@Service
public class RoleDeptServiceImpl extends ServiceImpl<RoleDeptMapper, RoleDept> implements IRoleDeptService {

}
