package com.ps.bakeryapp.services;

import com.ps.bakeryapp.models.Product;
import com.ps.bakeryapp.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product productToSave) {

        Optional<Product> product = productRepository.findByName(productToSave.getName());

        if(!product.isPresent()) {
            productRepository.save(productToSave);
//            log.info("Add product to base");
        } else {
//            log.info("Product already exist in base");

        }

        return productRepository.findById(productToSave.getId()).get();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Set<Product> getAll() {
        Set<Product> result = new HashSet<>();
        productRepository.findAll().forEach(product -> result.add(product));
        return result;
    }

}


