package org.putt.micronaut.passport.dao;

import org.putt.micronaut.passport.model.RequestFactory;
import org.putt.micronaut.passport.model.ResponseFactory;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class FactoryDao {

    static Map<Integer, ResponseFactory> factoryMap = new HashMap<>();

    static int id = 0;

    public List<ResponseFactory> getAllFactories(){
        return new ArrayList(factoryMap.values());
    }

    public ResponseFactory getNodeById(Integer id){
        return factoryMap.get(id);
    }

    public ResponseFactory updateFactoryName(Integer id, String name){
        ResponseFactory responseFactory =  factoryMap.get(id);
        responseFactory.setName(name);
        factoryMap.put(id, responseFactory);
        return responseFactory;
    }

    public ResponseFactory createFactory(RequestFactory requestFactory){
        requestFactory.setId(id++);
        ResponseFactory responseFactory = new ResponseFactory(requestFactory);
        responseFactory.setResponseFactoryAction(ResponseFactory.ResponseFactoryAction.ADDED);
        factoryMap.put(requestFactory.getId(), responseFactory);
        return responseFactory;
    }
}
