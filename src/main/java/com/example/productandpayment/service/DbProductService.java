package com.example.productandpayment.service;


import com.example.productandpayment.exceptions.ProductNotFoundException;
import com.example.productandpayment.models.Category;
import com.example.productandpayment.models.Product;
import com.example.productandpayment.repositories.CategoryRepository;
import com.example.productandpayment.repositories.ProductRepository;
import com.example.productandpayment.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;


@Service("dbProductService")
public class DbProductService implements ProductService {
    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    public DbProductService(ProductRepository productRepository,
                            CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId); // productId = 1;

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id: " + productId + "does not exist");
        }

        return optionalProduct.get();
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {

        Sort sort = Sort.by("price").ascending().and(Sort.by("title").descending());
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return productRepository.findAll(pageable);

        // Alternate way: Convert Page<Product> to a List<Product>
    }

    /*
    {
        "category": {
            "name": "phones",
            "description": "iphone devices"
        },
        "title" : "iphone",
        "price": "100000"
     }
     */

    @Override
    public Product addNewProduct(Product product) {
        Category category = product.getCategory();
        if(category.getId() == null){
            // We need to create a new Category object in the DB first
            category = categoryRepository.save(category);
            product.setCategory(category);
        }

        return productRepository.save(product);
    }

    @Override
    public void deleteSingleProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(productId);

        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with id: " + productId + "does not exist");
        }

        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> getLimitedProducts(Integer num) {
        return null;
    }

    // PATCH
    @Override
    public Product updateProduct(Long productId, Product product) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(productId);

        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with id: " + productId + "does not exist");
        }

        Product productInDb = productOptional.get();

        if(product.getTitle() != null) {
            productInDb.setTitle(product.getTitle());
        }

        if(product.getPrice() != null) {
            productInDb.setPrice(product.getPrice());
        }

        return productRepository.save(productInDb);
    }


    // PUT
    // TODO:: Homework to code this service
    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }
}
