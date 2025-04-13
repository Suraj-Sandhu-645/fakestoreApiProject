package com.example.productandpayment.service;

import com.example.productandpayment.exceptions.ProductNotFoundException;
import com.example.productandpayment.models.Product;
import org.springframework.data.domain.Page;
import com.example.productandpayment.repositories.ProductRepository;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId) throws ProductNotFoundException;

    Page<Product> getAllProducts(int pageNumber, int pageSize);

    Product addNewProduct(Product product);

    void deleteSingleProduct(Long product_id) throws ProductNotFoundException;
  
    List<Product> getLimitedProducts(Integer num);

    Product updateProduct(Long id, Product product) throws ProductNotFoundException;

    Product replaceProduct(Long id, Product product);
}
