package cn.t09.auth.sys.controller;

import cn.t09.auth.sys.entity.User;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDateTime;
import java.util.Date;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gcjun on 2019/6/6.
 */

public class UserControllerTest extends BaseTest {

    @Test
    public void getById() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/sys/users/1");

        mockMvc.perform(requestBuilder)
        .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void add() throws Exception {
        User user = new User();
        user.setUsername("lisi666");
        user.setPassword("123456");
        user.setEmail("lisi@qq.com");
        user.setMobile("12345678900");
        user.setStatus(0);
        user.setDeptId(1L);
        user.setCreateTime(LocalDateTime.now());

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/sys/users").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON.toJSONString(user));

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void update() throws Exception {
        User user = new User();
        user.setUserId(2L);
        user.setUsername("lisi333");
        user.setPassword("123456");
        user.setEmail("lisi@qq.com");
        user.setMobile("12345678900");
        user.setStatus(0);
        user.setDeptId(1L);
        user.setCreateTime(LocalDateTime.now());

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/sys/users").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON.toJSONString(user));

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void delete() throws Exception {
        long[] ids = {9,6};

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/sys/users").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON.toJSONString(ids));

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void list() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/sys/users");

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print());

    }

}