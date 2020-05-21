package br.com.springMysql.Awesome.services;

import br.com.springMysql.Awesome.Repository.CostumerRepository;
import br.com.springMysql.Awesome.model.Costumer;
import br.com.springMysql.Awesome.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //  Cacheable if "product"is not on cache, put it
    @Cacheable(value = "costumer")
    public Costumer getCostumer(Long id) {
        System.out.println("getCostumer cache");
        return this.costumerRepository.findOne(id);
    }

    //  Update cache
    @CachePut(value ="costumer", key = "#id")
    public Costumer updateCostumer(Long id, Costumer costumer) {
        System.out.println("updateCostumer cache");
        Costumer result = null;
        if(costumerRepository.exists(costumer.getId())) {
            result = this.costumerRepository.save(costumer);
        }
        return result;
    }

    //    Remove from cache if the costumer is retrived
    @CacheEvict(value = "listCostumer", key = "#id")
    public boolean deleteCostumer(Long id) {
        System.out.println("deleteCostumer cache");
        boolean deleted = false;

        if(costumerRepository.exists(id)) {
            this.costumerRepository.delete(id);
            deleted = true;
        }
        return deleted;
    }

    @CacheEvict(value = "listCostumer")
    public Iterable<Costumer> listAllCostumer(){
        System.out.println("listAllCostumer cache");
        return costumerRepository.findAll();
    }

    @CacheEvict(value = "findByNameIgnoreCaseContaining")
    public List<Costumer> findByNameIgnoreCaseContaining(String name) {
        return costumerRepository.findByNameIgnoreCaseContaining(name);
    }

}
