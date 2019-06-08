package cn.gcjun.demo.mybatisplus.test.ps.service.impl;

import cn.gcjun.demo.mybatisplus.test.ps.entity.Employee;
import cn.gcjun.demo.mybatisplus.test.ps.mapper.EmployeeMapper;
import cn.gcjun.demo.mybatisplus.test.ps.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gcjun
 * @since 2019-06-04
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
