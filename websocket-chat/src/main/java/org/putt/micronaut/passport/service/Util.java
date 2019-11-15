package org.putt.micronaut.passport.service;

import io.micronaut.websocket.WebSocketSession;

import java.util.function.Predicate;

public class Util {

    private static final String TOPIC = "topic";
    private static final String SESSION_ID = "sessionId";

    public static double getRandomIntegerBetweenRange(double min, double max){
        return (int)(Math.random()*((max-min)+1))+min;

    }


    public static Predicate<WebSocketSession> isValid(String topic, String sessionId) {
        return webSocketSession -> topic.equalsIgnoreCase(webSocketSession.getUriVariables().get(TOPIC, String.class, null))
                && sessionId.equalsIgnoreCase(webSocketSession.getUriVariables().get(SESSION_ID, String.class, null));
    }

    public static Predicate<WebSocketSession> isValid(String topic) {
        return webSocketSession -> topic.equalsIgnoreCase(webSocketSession.getUriVariables().get(TOPIC, String.class, null));
    }



}
