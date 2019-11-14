package org.putt.micronaut.passport.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.putt.micronaut.passport.service.Util;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public class ResponseFactory extends RequestFactory {


    List<Node> nodes;
    ResponseFactoryAction responseFactoryAction;

    public ResponseFactory(RequestFactory requestFactory){
        super();
        this.id = requestFactory.getId();;
        this.max = requestFactory.getMax();
        this.min = requestFactory.getMin();
        this.name = requestFactory.getName();
        this.nodes = generateNodes(requestFactory.getNumber());
    }

    @Data
    public class Node{
        Long id;
        Long value;
    }

    private List<Node> generateNodes(int numberOfNodes){
        List <Node> nodes = new ArrayList<>();
        for (int i = 0 ; i < numberOfNodes ; i++){
            Node node = new Node();
            node.setId((long)i);
            node.setValue((long)Util.getRandomIntegerBetweenRange(1, 100));
            nodes.add(node);
        }
        return nodes;
    }

    public enum ResponseFactoryAction {
        DELETED( "deleted"),
        UPDATED( "updated"),
        ADDED( "added"),
        LOADED( "loaded"),
        CREATED( "created");

        public final String value;
        ResponseFactoryAction(String value) {
            this.value = value;
        }
    }
}
