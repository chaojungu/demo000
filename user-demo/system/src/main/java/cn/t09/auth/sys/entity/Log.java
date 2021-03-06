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
    * 系统日志
    * </p>
*
* @author t09
* @since 2019-06-12
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("sys_log")
    public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

            /**
            * 用户名
            */
    private String username;

            /**
            * 用户操作
            */
    private String operation;

            /**
            * 请求方法
            */
    private String method;

            /**
            * 请求参数
            */
    private String params;

            /**
            * 执行时长(毫秒)
            */
    private Long time;

            /**
            * IP地址
            */
    private String ip;

            /**
            * 创建时间
            */
    private Date createDate;


}
