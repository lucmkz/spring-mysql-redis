package br.com.springMysql.Awesome.Repository;

import br.com.springMysql.Awesome.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByNameIgnoreCaseContaining(String name);
}
