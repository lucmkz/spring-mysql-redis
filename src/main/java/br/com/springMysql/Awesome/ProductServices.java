package br.com.springMysql.Awesome;

import br.com.springMysql.Awesome.Repository.ProductRepository;
import br.com.springMysql.Awesome.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {

    private ProductRepository productRepository;

    @Autowired
    public ProductServices(ProductRepository productRepository) {this.productRepository = productRepository;}

    @Cacheable(value = "product")
    public Product getProduct(Long id) {
        System.out.println("teste cache");
        return this.productRepository.findOne(id);
    }
}
