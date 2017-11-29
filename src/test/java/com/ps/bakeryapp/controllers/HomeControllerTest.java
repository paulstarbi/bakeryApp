package com.ps.bakeryapp.controllers;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


public class HomeControllerTest {

    private MockMvc mockMvc;

    @Test
    public void urlShouldReturnAppropriateView() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
        mockMvc.perform(get("/"))
                .andExpect(view().name("homepage"));
    }


}