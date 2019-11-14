package org.putt.micronaut.passport.model;

import lombok.Data;

@Data
public class RequestFactory {

    int id;
    String name;
    int number;
    int min;
    int max;
    RequestFactory requestFactoryAction;

    public enum RequestFactoryAction {
        DELETED( "delete"),
        UPDATED( "update"),
        ADDED( "add"),
        REGENERATE( "regenerate"),
        LOAD( "load"),
        CREATED( "create");

        public final String value;
        RequestFactoryAction(String value) {
            this.value = value;
        }
    }
}
