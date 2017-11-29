package com.ps.bakeryapp.services;

import com.ps.bakeryapp.models.Product;
import com.ps.bakeryapp.repositories.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;
    private Product product;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        product = new Product();
        product.setId(1L);
        product.setName("chleb");

        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    public void shouldReturnProductById() throws Exception {

        //given
        Optional<Product> productOptional = Optional.of(product);

        //when
        when(productRepository.findById(1L)).thenReturn(productOptional);

        //then
        assertEquals("chleb", productService.findById(1L).getName());
    }

    @Test
    public void shouldSaveProductAndReturnNewSavedInstance () throws Exception {

        //given
        Product savedProduct;

        //when
        when(productRepository.findByName(anyString())).thenReturn(Optional.ofNullable(null));
        when(productRepository.findById(anyLong())).thenReturn(Optional.ofNullable(product));
        savedProduct = productService.saveProduct(product);

        //then
        verify(productRepository, times(1)).save(product);
        assertEquals("chleb", savedProduct.getName());
    }



}