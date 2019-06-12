package cn.t09.auth.sys.service.impl;

import cn.t09.auth.sys.entity.Log;
import cn.t09.auth.sys.mapper.LogMapper;
import cn.t09.auth.sys.service.ILogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author t09
 * @since 2019-06-12
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

}
