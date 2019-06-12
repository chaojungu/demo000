package com.t09.demo.common.convertor;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串到日期类型的转换器
 */
public class StringToDateConvertor implements Converter<String,Date> {
    private String pattern;

    public StringToDateConvertor(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public Date convert(String source) {
        System.out.println("执行转换...");
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
// date=2012-5-12    ==> Date对象

// point=x,y   point=10,20  ==> Point对象（有x和y属性）
