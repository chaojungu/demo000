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
    * 角色
    * </p>
*
* @author t09
* @since 2019-06-12
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("sys_role")
    public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

            /**
            * 角色名称
            */
    private String roleName;

            /**
            * 备注
            */
    private String remark;

            /**
            * 部门ID
            */
    private Long deptId;

            /**
            * 创建时间
            */
    private Date createTime;


}
