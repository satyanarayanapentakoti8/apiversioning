package com.versioning.apiversioning.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserHeaderVersionController.class)
@TestPropertySource(properties = {
        "api.version.header-name=X-API-VERSION",
        "api.version.v1=1",
        "api.version.v2=2",
        "api.version.default=1"
})
public class UserHeaderVersionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testVersion1Header() throws Exception {
        mockMvc.perform(get("/api/users").header("X-API-VERSION", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Satya Pentakoti"));
    }

    @Test
    public void testVersion2Header() throws Exception {
        mockMvc.perform(get("/api/users").header("X-API-VERSION", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Satya"))
                .andExpect(jsonPath("$.lastName").value("Pentakoti"));
    }

    @Test
    public void testFallbackToDefaultVersion() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Satya Pentakoti"));
    }

    @Test
    public void testInvalidVersionHeader() throws Exception {
        mockMvc.perform(get("/api/users").header("X-API-VERSION", "999"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", containsString("Unsupported API version")));
    }
}
