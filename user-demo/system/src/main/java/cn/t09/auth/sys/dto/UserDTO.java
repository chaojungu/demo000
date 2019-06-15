package cn.t09.auth.sys.dto;

import java.util.List;
import lombok.Data;

/**
 * Created by gcjun on 2019/6/15.
 */
@Data
public class UserDTO {
    private String username;
    private List<Long> deptId;
}
