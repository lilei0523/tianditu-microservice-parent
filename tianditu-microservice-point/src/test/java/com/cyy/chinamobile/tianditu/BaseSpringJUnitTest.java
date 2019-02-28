package com.cyy.chinamobile.tianditu;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Li lei
 * @date 2019年02月27日 16:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public abstract class BaseSpringJUnitTest {

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;
    private static Logger logger = LoggerFactory.getLogger(BaseSpringJUnitTest.class);

}
