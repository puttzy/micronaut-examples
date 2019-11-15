package org.putt.micronaut.passport.dao;

import org.putt.micronaut.passport.model.response.FactoryResponse;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class FactoryDao {

    private static Map<Integer, FactoryResponse> factoryMap = new HashMap<>();

    private static Integer id = 0;


    public List<FactoryResponse> getAllFactories(){
        return new ArrayList(factoryMap.values());
    }

    public FactoryResponse getFactoryById(Integer id){
        return factoryMap.get(id);
    }



    public void updateFactory(FactoryResponse factoryResponse){

        factoryMap.put(factoryResponse.getId(), factoryResponse);

    }

    public FactoryResponse insertFactory(FactoryResponse factoryResponse){
        factoryResponse.setId(id++);
        factoryMap.put(factoryResponse.getId(), factoryResponse);
        return factoryResponse;
    }



}
