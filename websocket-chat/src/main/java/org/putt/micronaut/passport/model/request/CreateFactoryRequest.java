package org.putt.micronaut.passport.model.request;

import lombok.Data;

@Data
public class CreateFactoryRequest {


    String name;
    int number;
    int min;
    int max;

}
