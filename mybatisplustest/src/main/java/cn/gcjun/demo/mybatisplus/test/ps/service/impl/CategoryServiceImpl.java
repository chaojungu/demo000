package cn.gcjun.demo.mybatisplus.test.ps.service.impl;

import cn.gcjun.demo.mybatisplus.test.ps.entity.Category;
import cn.gcjun.demo.mybatisplus.test.ps.mapper.CategoryMapper;
import cn.gcjun.demo.mybatisplus.test.ps.service.ICategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
