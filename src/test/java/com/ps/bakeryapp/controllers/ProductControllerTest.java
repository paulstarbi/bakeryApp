package com.ps.bakeryapp.controllers;

import com.ps.bakeryapp.models.Product;
import com.ps.bakeryapp.services.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


public class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    ProductService productService;
    ProductController productController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        productController = new ProductController(productService);

        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void shouldReturnAppropriateView() throws Exception {
        mockMvc.perform(get("/oferta"))
                .andExpect(view().name("offert"));
    }

    @Test
    public void shouldAddProductToRepository() throws Exception {
        Product product = new Product();
        product.setId(1L);

        when(productService.saveProduct(any())).thenReturn(product);

        mockMvc.perform(get("/add"))
                .andExpect(view().name("offert"));
    }
}