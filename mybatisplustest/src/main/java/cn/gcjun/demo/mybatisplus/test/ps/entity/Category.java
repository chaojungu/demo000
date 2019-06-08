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
    @TableName("ps_category")
    public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 类别名称
            */
    private String name;

            /**
            * 显示顺序
            */
    private Integer sort;

            /**
            * 备注
            */
    private String description;

            /**
            * 记录标记
            */
        @TableField("Flag")
    private Integer Flag;


}
