package org.putt.micronaut.passport.service;

import org.putt.micronaut.passport.dao.FactoryDao;
import org.putt.micronaut.passport.model.request.CreateFactoryRequest;
import org.putt.micronaut.passport.model.request.UpdateFactoryRequest;
import org.putt.micronaut.passport.model.response.FactoryResponse;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class Factory {

    private FactoryDao factoryDao;


    public Factory(FactoryDao factoryDao){
        this.factoryDao = factoryDao;
    }

    public List<FactoryResponse> getAllFactories(){
        return factoryDao.getAllFactories();
    }

    public FactoryResponse createResponseFactory(CreateFactoryRequest requestFactory){

        return  factoryDao.insertFactory(createFactory(requestFactory))     ;
    }

    public FactoryResponse updateResponseFactory(UpdateFactoryRequest requestFactory){
        FactoryResponse factoryResponse = new FactoryResponse(requestFactory);
        factoryDao.updateFactory(factoryResponse);
        return factoryDao.getFactoryById(factoryResponse.getId());
    }

    private FactoryResponse createFactory(CreateFactoryRequest requestFactory){

        return new FactoryResponse(requestFactory);
    }

}
