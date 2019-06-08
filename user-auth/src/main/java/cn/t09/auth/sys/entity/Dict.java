package cn.t09.auth.sys.entity;

    import com.baomidou.mybatisplus.annotation.TableName;
    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 数据字典表
    * </p>
*
* @author t09
* @since 2019-06-06
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("sys_dict")
    public class Dict implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            /**
            * 字典名称
            */
    private String name;

            /**
            * 字典类型
            */
    private String type;

            /**
            * 字典码
            */
    private String code;

            /**
            * 字典值
            */
    private String value;

            /**
            * 排序
            */
    private Integer orderNum;

            /**
            * 备注
            */
    private String remark;

            /**
            * 删除标记  -1：已删除  0：正常
            */
    private Integer delFlag;


}
