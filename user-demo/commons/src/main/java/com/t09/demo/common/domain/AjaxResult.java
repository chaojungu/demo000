package com.t09.demo.common.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gcjun on 2019/6/6.
 */

public class AjaxResult extends HashMap<String,Object> {
    private static final long serialVersionUID = 1L;

    public static final String CODE_TAG = "code";

    public static final String MSG_TAG = "msg";

    public static final String DATA_TAG = "data";

    public AjaxResult() {
        put(CODE_TAG, 0);
        put(MSG_TAG, "success");
    }

    public static AjaxResult error() {
        return error(500, "未知异常，请联系管理员");
    }
    public static AjaxResult error(String msg) {
        return error(500, msg);
    }

    public static AjaxResult error(int code, String msg) {
        AjaxResult r = new AjaxResult();
        r.put(CODE_TAG, code);
        r.put(MSG_TAG, msg);
        return r;
    }


    public static AjaxResult ok() {
        return  new AjaxResult();

    }
    public static AjaxResult ok(String msg) {
        AjaxResult r = new AjaxResult();
        r.put(MSG_TAG, msg);
        return r;
    }
    public static AjaxResult ok(Map<String, Object> map) {
        AjaxResult r = ok();
        r.putAll(map);
        return r;
    }

    @Override
    public AjaxResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}