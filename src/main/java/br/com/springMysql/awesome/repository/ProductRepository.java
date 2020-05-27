package br.com.springMysql.awesome.repository;

import br.com.springMysql.awesome.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByNameIgnoreCaseContaining(String name);
}
