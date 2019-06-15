package cn.t09.auth.sys.controller;


import cn.t09.auth.sys.entity.Role;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import javax.annotation.Resource;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

/**
 * Created by gcjun on 2019/6/6.
 */
public class MenuControllerTest extends BaseTest{
    @Test
    public void listTreeBy() throws Exception {

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
            .get("/sys/menus/tree");

        mockMvc.perform(requestBuilder)
            .andDo(MockMvcResultHandlers.print());

    }
    @Test
    public void listTreeByRoleId() throws Exception {

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
            .get("/sys/menus/tree/1");

        mockMvc.perform(requestBuilder)
            .andDo(MockMvcResultHandlers.print());

    }
}