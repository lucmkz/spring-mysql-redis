package br.com.springMysql.Awesome.services;

import br.com.springMysql.Awesome.Repository.CostumerRepository;
import br.com.springMysql.Awesome.model.Costumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class CostumerService {

    private CostumerRepository costumerRepository;

    @Autowired
    public CostumerService(CostumerRepository costumerRepository) {this.costumerRepository = costumerRepository;}

    //  Remove key when create a new product
    @CacheEvict(value = "costumer", key = "#costumer.getId()")
    public Costumer createCostumer (Costumer costumer){
        System.out.println("createModel cache");
        Costumer result = null;

        if(!costumerRepository.exists(costumer.getId())) {
            result = this.costumerRepository.save(costumer);
        }
        return result;
    }
}
