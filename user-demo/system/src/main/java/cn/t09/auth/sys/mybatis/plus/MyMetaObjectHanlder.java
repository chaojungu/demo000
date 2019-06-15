package cn.t09.auth.sys.mybatis.plus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import java.util.Date;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * Created by gcjun on 2019/6/15.
 */
@Component
public class MyMetaObjectHanlder implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setInsertFieldValByName("createTime",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
