package com.rishal.ecommerce.service;

import com.rishal.ecommerce.model.Product;
import com.rishal.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void initProducts() {
        Product ps5 = new Product(
                "PlayStation 5",
                "Sony PlayStation 5 Console - Ultra HD Blu-ray Edition",
                549.99,
                "https://m.media-amazon.com/images/I/619BkvKW35L._AC_SL1500_.jpg"
        );

        Product headphones = new Product(
                "Sony Headphones",
                "Premium wireless noise-canceling over-ear headphones",
                59.99,
                "https://m.media-amazon.com/images/I/61Y30DpqSSL._AC_SL1500_.jpg"
        );

        Product iphone = new Product(
                "iPhone 14",
                "Apple smartphone with A15 Bionic chip and dual camera system",
                999.99,
                "https://m.media-amazon.com/images/I/71yzJoE7WlL._AC_UF1000,1000_QL80_.jpg"
        );

        Product tv = new Product(
                "Samsung Smart TV",
                "50-inch 4K UHD Smart LED TV with Alexa compatibility",
                499.99,
                "https://m.media-amazon.com/images/I/819Lw2PE8tL._AC_SL1500_.jpg"
        );

        productRepository.saveAll(List.of(ps5, headphones, iphone, tv));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
