package cn.t09.auth.sys.mapper;

import cn.t09.auth.sys.dto.UserDTO;
import cn.t09.auth.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author t09
 * @since 2019-06-12
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> PageByDTO(@Param("page")IPage<User> page,
        @Param("user")UserDTO user);
}
