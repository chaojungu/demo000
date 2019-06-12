package cn.t09.auth.sys.service.impl;

import cn.t09.auth.sys.entity.Dict;
import cn.t09.auth.sys.mapper.DictMapper;
import cn.t09.auth.sys.service.IDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据字典表 服务实现类
 * </p>
 *
 * @author t09
 * @since 2019-06-12
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements IDictService {

}
