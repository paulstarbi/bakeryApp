package com.ps.bakeryapp.controllers;

import com.ps.bakeryapp.models.Description;
import com.ps.bakeryapp.repositories.DescriptionRepository;
import com.ps.bakeryapp.services.DescriptionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class CompanyDescControllerTest {

    @Mock
    private DescriptionService descriptionService;

    private MockMvc mockMvc;
    private CompanyDescController descController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        descController = new CompanyDescController(descriptionService);
        mockMvc = MockMvcBuilders.standaloneSetup(descController).build();
    }

    @Test
    public void shouldReturnAppropriateViewAndContainsModelElements() throws Exception {

        //when
        when(descriptionService.findDescriptionById(anyLong())).thenReturn(new Description());

        //then
        mockMvc.perform(get("/ofirmie"))
                .andExpect(view().name("companyDesc"))
                .andExpect(model().attributeExists("description"));
    }
}