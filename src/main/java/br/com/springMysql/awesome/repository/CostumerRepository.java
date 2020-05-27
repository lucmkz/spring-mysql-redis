package br.com.springMysql.awesome.repository;

import br.com.springMysql.awesome.model.Costumer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CostumerRepository extends CrudRepository<Costumer, Long> {

    List<Costumer> findByNameIgnoreCaseContaining(String name);
}
