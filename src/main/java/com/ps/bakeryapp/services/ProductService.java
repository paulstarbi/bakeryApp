package com.ps.bakeryapp.services;

import com.ps.bakeryapp.models.Product;

import java.util.Set;

public interface ProductService {

    Product saveProduct(Product productToSave);

    Product findById(Long id);

    Set<Product> getAll();
}
