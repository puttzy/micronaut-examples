package org.putt.micronaut.passport.service;

import org.putt.micronaut.passport.dao.FactoryDao;
import org.putt.micronaut.passport.model.RequestFactory;
import org.putt.micronaut.passport.model.ResponseFactory;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class Factory {

    FactoryDao factoryDao;

    public Factory(FactoryDao factoryDao){
        this.factoryDao = factoryDao;
    }

    public List<ResponseFactory> getAllFactories(){
        return factoryDao.getAllFactories();
    }

    public ResponseFactory createResponseFactory(RequestFactory requestFactory){

        return factoryDao.createFactory(requestFactory);
    }

}
