package cn.gcjun.demo.mybatisplus.test.ps.entity;

    import com.baomidou.mybatisplus.annotation.TableName;
    import com.baomidou.mybatisplus.annotation.TableField;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author gcjun
* @since 2019-06-04
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("ps_employee")
    public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 员工编码
            */
    private String code;

            /**
            * 员工姓名
            */
    private String name;

            /**
            * 岗位编码
            */
        @TableField("positionId")
    private String positionId;

            /**
            * 员工学历
            */
    private String education;

            /**
            * 工作经验(年份)
            */
    private Integer experience;

            /**
            * 职业技能
            */
    private String skill;

            /**
            * 部门编码
            */
        @TableField("deptId")
    private String deptId;

            /**
            * 所属公司
            */
        @TableField("orgId")
    private String orgId;

            /**
            * 备注
            */
    private String description;

            /**
            * 记录标记
            */
    private Integer flag;


}
