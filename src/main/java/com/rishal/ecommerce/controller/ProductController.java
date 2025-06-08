package com.rishal.ecommerce.controller;

import com.rishal.ecommerce.model.Product;
import com.rishal.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String showProducts(
            @RequestParam(required = false) String keyword,
            Model model
    ) {
        List<Product> products = productService.getAllProducts();

        if (keyword != null && !keyword.isBlank()) {
            String lower = keyword.toLowerCase();
            products = products.stream()
                    .filter(p ->
                            p.getName().toLowerCase().contains(lower) ||
                                    p.getDescription().toLowerCase().contains(lower)
                    )
                    .collect(Collectors.toList());
            if (products.isEmpty()) {
                model.addAttribute("message",
                        "No results found for \"" + keyword + "\"");
            }
        }

        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword);
        return "products";
    }
}
