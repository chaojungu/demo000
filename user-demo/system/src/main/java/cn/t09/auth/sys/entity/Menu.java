package cn.t09.auth.sys.entity;

    import com.alibaba.fastjson.annotation.JSONField;
    import com.baomidou.mybatisplus.annotation.TableName;
    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 菜单管理
    * </p>
*
* @author t09
* @since 2019-06-12
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("sys_menu")
    public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;

            /**
            * 父菜单ID，一级菜单为0
            */
    private Long parentId;

            /**
            * 菜单名称
            */
    private String name;

            /**
            * 菜单URL
            */
    private String url;

            /**
            * 授权(多个用逗号分隔，如：user:list,user:create)
            */
    private String perms;

            /**
            * 类型   0：目录   1：菜单   2：按钮
            */
    private Integer type;

            /**
            * 菜单图标
            */
    private String icon;

            /**
            * 排序
            */
    private Integer orderNum;


}
