package com.cyy.chinamobile.tianditu;

import com.cyy.chinamobile.tianditu.point.PointApplication;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Li lei
 * @date 2019年02月27日 16:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PointApplication.class)
public abstract class BaseSpringJUnitTest {

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;
    private static Logger logger = LoggerFactory.getLogger(BaseSpringJUnitTest.class);

    /**
     * 在每个方法执行之前都初始化MockMvc对象
     * @date  11:09 2019/2/28
     */
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
}
