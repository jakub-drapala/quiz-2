package com.drapala.quiz2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

public abstract class BaseControllerTest {

    protected ObjectMapper jsonMapper = new ObjectMapper();
    protected PageableHandlerMethodArgumentResolver pageableArgumentResolver = new PageableHandlerMethodArgumentResolver();
    protected MockMvc api;

    @Before
    public void setUp() {
        api = MockMvcBuilders.standaloneSetup(controller())
                .setCustomArgumentResolvers(new HandlerMethodArgumentResolver[]{pageableArgumentResolver})
                .build();
    }

    protected abstract Object controller();

    protected String json(Object object) throws JsonProcessingException {
        return jsonMapper.writeValueAsString(object);
    }
}
