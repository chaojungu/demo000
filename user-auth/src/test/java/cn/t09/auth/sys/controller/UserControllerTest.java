package cn.t09.auth.sys.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

/**
 * Created by gcjun on 2019/6/6.
 */

public class UserControllerTest extends BaseTest {

    @Test
    public void getById() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
            .get("/sys/user/getById?userId=1");
        ResultActions resultActions = mockMvc.perform(requestBuilder);

        resultActions.andDo(MockMvcResultHandlers.print());

    }

}