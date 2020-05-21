package br.com.springMysql.Awesome.services;

import br.com.springMysql.Awesome.Repository.ProductRepository;
import br.com.springMysql.Awesome.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {this.productRepository = productRepository;}

//  Remove key when create a new product
    @CacheEvict(value = "product", key = "#product.getId()")
    public Product createProduct (Product product){
        System.out.println("createProduct cache");
        Product result = null;

        if(!productRepository.exists(product.getId())) {
            result = this.productRepository.save(product);
        }
        return result;
    }

//  Cacheable if "product"is not on cache, put it
    @Cacheable(value = "product")
    public Product getProduct(Long id) {
        System.out.println("getProduct cache");
        return this.productRepository.findOne(id);
    }

//  Update cache
    @CachePut(value ="product", key = "#id")
    public Product updateProduct(Long id, Product product) {
        System.out.println("updateProduct cache");
        Product result = null;
        if(productRepository.exists(product.getId())) {
            result = this.productRepository.save(product);
        }
        return result;
    }

//    Remove from cache if the product is retrived
    @CacheEvict(value = "listProducts", key = "#id")
    public boolean deleteProduct(Long id) {
        System.out.println("deleteProduct cache");
        boolean deleted = false;

        if(productRepository.exists(id)) {
            this.productRepository.delete(id);
            deleted = true;
        }
        return deleted;
    }

    @CacheEvict(value = "listProducts")
    public Iterable<Product> listAllProducts(){
        System.out.println("listAllProducts cache");
        return productRepository.findAll();
    }

    @CacheEvict(value = "findByNameIgnoreCaseContaining")
    public List<Product> findByNameIgnoreCaseContaining(String name) {
        return productRepository.findByNameIgnoreCaseContaining(name);
    }

}
