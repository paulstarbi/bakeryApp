package com.ps.bakeryapp.services;

import com.ps.bakeryapp.models.Product;
import com.ps.bakeryapp.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private ProductRepository productRepository;

    @Autowired
    public ImageServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long productId, MultipartFile file) {
        Product product = productRepository.findById(productId).orElse(new Product());

        try {
            Byte[] byteImg = new Byte[file.getBytes().length];

            int iterator = 0;

            for (byte b : file.getBytes()) {
                byteImg[iterator++] = b;
            }

            product.setPicture(byteImg);

            productRepository.save(product);
        } catch (IOException e) {
            //TODO Error handling
            e.printStackTrace();
        }
    }
}
