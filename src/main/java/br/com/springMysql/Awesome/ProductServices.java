package br.com.springMysql.Awesome;

import br.com.springMysql.Awesome.Repository.ProductRepository;
import br.com.springMysql.Awesome.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {

    private ProductRepository productRepository;

    @Autowired
    public ProductServices(ProductRepository productRepository) {this.productRepository = productRepository;}


    @CacheEvict(value = "product", key = "#product.getId()")
    public Product createProduct (Product product){
        Product result = null;

        if(!productRepository.exists(product.getId())) {
            result = this.productRepository.save(product);
        }
        return result;
    }

    @Cacheable(value = "product")
    public Product getProduct(Long id) {
        System.out.println("product cache");
        return this.productRepository.findOne(id);
    }

    @CachePut(value ="product", key = "#id")
    public Product updateProduct(Long id, Product product) {
        Product result = null;
        if(productRepository.exists(product.getId())) {
            result = this.productRepository.save(product);
        }
        return result;
    }

    @CacheEvict(value = "product", key = "#id")
    public boolean deleteProduct(Long id) {
        boolean deleted = false;

        if(productRepository.exists(id)) {
            this.productRepository.delete(id);
            deleted = true;
        }
        return deleted;
    }

}
