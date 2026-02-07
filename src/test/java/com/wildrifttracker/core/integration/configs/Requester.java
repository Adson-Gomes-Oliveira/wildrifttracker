package com.wildrifttracker.core.integration.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public abstract class Requester {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    protected ResultActions post(String url, Object body) throws Exception {
        return mockMvc.perform(
                MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(body))
        );
    }

    protected ResultActions get(String url) throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.get(url));
    }

    protected ResultActions put(String url, Object body) throws Exception {
        return mockMvc.perform(
                MockMvcRequestBuilders.put(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(body))
        );
    }

    protected ResultActions patch(String url, Object body) throws Exception {
        return mockMvc.perform(
                MockMvcRequestBuilders.patch(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(body))
        );
    }

    protected ResultActions delete(String url) throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.delete(url));
    }
}
