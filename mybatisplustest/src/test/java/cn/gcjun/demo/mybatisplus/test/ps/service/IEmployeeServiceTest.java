package cn.gcjun.demo.mybatisplus.test.ps.service;

import cn.gcjun.demo.mybatisplus.test.ps.entity.Employee;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by gcjun on 2019/6/4.
 */

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class IEmployeeServiceTest {

    @Resource
    private IEmployeeService service;

    @Test
    public void testCount() {
        int count = service.count();
        System.out.println(count);
    }

    @Test
    public void testCountByWrap() {
        int count = service.count(new QueryWrapper<Employee>().like("name","张"));
        System.out.println(count);
    }

    @Test
    public void test3() {
        int count = service.count();
        System.out.println(count);
    }

}