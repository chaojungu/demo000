package cn.t09.auth.sys.controller;

import javax.annotation.Resource;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by gcjun on 2019/6/8.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:applicationContext.xml","classpath:springmvc-servlet.xml"})
public class BaseTest {

    protected MockMvc mockMvc;

    @Resource
    private WebApplicationContext wac;

    @Before
    public void before() throws Exception{
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
}
