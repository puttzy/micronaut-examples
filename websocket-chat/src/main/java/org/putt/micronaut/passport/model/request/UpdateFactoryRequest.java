package org.putt.micronaut.passport.model.request;

import lombok.Data;

@Data
public class UpdateFactoryRequest {

    int id;
    String name;
    int number;
    int min;
    int max;

}
