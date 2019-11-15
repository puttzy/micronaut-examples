package org.putt.micronaut.passport.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.putt.micronaut.passport.model.request.CreateFactoryRequest;
import org.putt.micronaut.passport.model.request.UpdateFactoryRequest;
import org.putt.micronaut.passport.service.Util;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public class FactoryResponse extends CreateFactoryRequest {

    Integer id;
    List<Node> nodes;

    public FactoryResponse(CreateFactoryRequest requestFactory){
        super();

        this.setMax(requestFactory.getMax());
        this.setMin(requestFactory.getMin());
        this.setName(requestFactory.getName());
        this.setNumber(requestFactory.getNumber());
        this.setNodes(generateNodes(requestFactory.getNumber(), requestFactory.getMin(), requestFactory.getMax()));
    }

    public FactoryResponse(UpdateFactoryRequest requestFactory){
        super();
        this.setId((requestFactory.getId()));
        this.setMax(requestFactory.getMax());
        this.setMin(requestFactory.getMin());
        this.setName(requestFactory.getName());
        this.setNumber(requestFactory.getNumber());
        this.setNodes(generateNodes(requestFactory.getNumber(), requestFactory.getMin(), requestFactory.getMax()));
    }

    @Data
    public class Node{
        Long id;
        Long value;
    }

    private List<Node> generateNodes(int numberOfNodes, int min, int max){
        List <Node> nodes = new ArrayList<>();
        for (int i = 0 ; i < numberOfNodes ; i++){
            Node node = new Node();
            node.setId((long)i);
            node.setValue((long)Util.getRandomIntegerBetweenRange(min, max));
            nodes.add(node);
        }
        return nodes;
    }

}
