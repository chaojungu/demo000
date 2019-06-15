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
public class RoleControllerTest extends BaseTest{
    @Resource
    MetaObjectHandler handler;
    @Test
    public void add() throws Exception {
        System.out.println(handler);
        Role role = new Role();
        role.setRoleName("333");
        role.setRemark("333");
        role.setDeptId(1L);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
            .post("/sys/roles").contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(JSON.toJSONString(role));

        mockMvc.perform(requestBuilder)
            .andDo(MockMvcResultHandlers.print());

    }
}