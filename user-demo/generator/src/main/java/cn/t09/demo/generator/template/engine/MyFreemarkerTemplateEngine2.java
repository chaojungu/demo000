package cn.t09.demo.generator.template.engine;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

/**
 * Created by gcjun on 2019/6/11 0011.
 */
public class MyFreemarkerTemplateEngine2 extends AbstractTemplateEngine {

    private Configuration configuration;

    @Override
    public MyFreemarkerTemplateEngine2 init(ConfigBuilder configBuilder) {
        super.init(configBuilder);
        configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setDefaultEncoding(ConstVal.UTF8);
        configuration.setClassForTemplateLoading(MyFreemarkerTemplateEngine2.class, StringPool.SLASH);
        return this;
    }

    @Override
    public String templateFilePath(String filePath) {
        return filePath + ".ftl";
    }

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
        Template template = configuration.getTemplate("/templates/View.ftl.ftl");
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            template.process(objectMap, new OutputStreamWriter(fileOutputStream, ConstVal.UTF8));
        }
        logger.debug("模板:" + templatePath + ";  文件:" + outputFile);
    }
}
