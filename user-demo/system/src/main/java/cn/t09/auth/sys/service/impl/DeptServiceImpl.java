package cn.t09.auth.sys.service.impl;

import cn.t09.auth.sys.entity.Dept;
import cn.t09.auth.sys.mapper.DeptMapper;
import cn.t09.auth.sys.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门管理 服务实现类
 * </p>
 *
 * @author t09
 * @since 2019-06-12
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

}
