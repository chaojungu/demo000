package cn.t09.auth.sys.entity;

    import com.baomidou.mybatisplus.annotation.TableName;
    import com.baomidou.mybatisplus.annotation.IdType;
    import java.util.Date;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 系统用户
    * </p>
*
* @author t09
* @since 2019-06-12
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("sys_user")
    public class User implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

            /**
            * 用户名
            */
    private String username;

            /**
            * 密码
            */
    private String password;

            /**
            * 邮箱
            */
    private String email;

            /**
            * 手机号
            */
    private String mobile;

            /**
            * 状态  0：禁用   1：正常
            */
    private Integer status;

            /**
            * 部门ID
            */
    private Long deptId;

            /**
            * 创建时间
            */
    private Date createTime;


}
