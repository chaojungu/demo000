package cn.t09.auth.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gcjun on 2019/6/12.
 */
@Controller
public class PageController {
    // index.html  ==> page:index   ==> index.ftl
    // index.html  ==> page:index
    @RequestMapping("/{page}.html")
    public String toPage(@PathVariable String page){
        return page;
    }
}
