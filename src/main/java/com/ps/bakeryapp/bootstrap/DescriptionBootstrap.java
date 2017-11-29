package com.ps.bakeryapp.bootstrap;

import com.ps.bakeryapp.models.Description;
import com.ps.bakeryapp.models.Product;
import com.ps.bakeryapp.services.DescriptionService;
import com.ps.bakeryapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class DescriptionBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private DescriptionService descriptionService;
    private ProductService productService;

    @Autowired
    public DescriptionBootstrap(DescriptionService descriptionService, ProductService productService) {
        this.descriptionService = descriptionService;
        this.productService = productService;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        descriptionService.saveDescription(getDescription());
        getProducts().forEach(product -> productService.saveProduct(product));
    }

    private Set<Product> getProducts() {

        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();

        p1.setName("bulka");
        p2.setName("razowy");
        p3.setName("bagietka");
        p4.setName("chleb");

        p1.setPrice(1.0);
        p2.setPrice(3.5);
        p3.setPrice(1.5);
        p4.setPrice(2.5);

        p1.setWeigh(0.25);
        p2.setWeigh(0.75);
        p3.setWeigh(0.35);
        p4.setWeigh(0.75);

        p1.setDescription(new Description(p1.getName()));
        p2.setDescription(new Description(p2.getName()));
        p3.setDescription(new Description(p3.getName()));
        p4.setDescription(new Description(p4.getName()));

        return new HashSet<>(Arrays.asList(p1, p2, p3, p4));
    }

    private Description getDescription() {

        Description description = new Description();
        description.setId(1L);
        description.setDescription("Lorem ipsum dolor sit amet," +
                " consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et " +
                "dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
                "voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident," +
                " sunt in culpa qui officia deserunt mollit anim id est laborum.");

        return description;
    }
}
