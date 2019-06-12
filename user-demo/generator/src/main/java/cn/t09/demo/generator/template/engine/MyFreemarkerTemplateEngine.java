package cn.t09.demo.generator.template.engine;

import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Map;

/**
 * Created by gcjun on 2019/6/11 0011.
 */
public class MyFreemarkerTemplateEngine extends FreemarkerTemplateEngine {
    @Override
    public void writer(Map<String, Object> objectMap, String templatePath, String outputFile) throws Exception {
        TableInfo table = (TableInfo) objectMap.get("table");
        for (TableField field : table.getFields()) {
            if (field.isKeyFlag()) {
                objectMap.put("keyProperty",field.getPropertyName());
                objectMap.put("keyPropertyType",field.getPropertyType());
                break;
            }
        }


        super.writer(objectMap,templatePath,outputFile);
    }
}
