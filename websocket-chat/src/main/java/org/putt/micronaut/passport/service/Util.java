package org.putt.micronaut.passport.service;

import io.micronaut.websocket.WebSocketSession;

import java.util.function.Predicate;

public class Util {


    public static double getRandomIntegerBetweenRange(double min, double max){
        return (int)(Math.random()*((max-min)+1))+min;

    }


    public static Predicate<WebSocketSession> isValid(String topic) {
        return webSocketSession -> topic.equalsIgnoreCase(webSocketSession.getUriVariables().get("topic", String.class, null));
    }

}
