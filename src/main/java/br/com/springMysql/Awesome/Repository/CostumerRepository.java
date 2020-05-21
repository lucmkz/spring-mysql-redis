package br.com.springMysql.Awesome.Repository;

import br.com.springMysql.Awesome.model.Costumer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CostumerRepository extends CrudRepository<Costumer, Long> {

    List<Costumer> findByNameIgnoreCaseContaining(String name);
}
