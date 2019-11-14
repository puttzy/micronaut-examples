package org.putt.micronaut.passport.controller;

import io.micronaut.websocket.WebSocketBroadcaster;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.OnClose;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.OnOpen;
import io.micronaut.websocket.annotation.ServerWebSocket;
import org.putt.micronaut.passport.model.RequestFactory;
import org.putt.micronaut.passport.model.ResponseFactory;
import org.putt.micronaut.passport.service.Factory;
import org.putt.micronaut.passport.service.Util;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import java.util.List;
import java.util.function.Predicate;

@ServerWebSocket("/create/{topic}")
public class CreateSocket {
    private WebSocketBroadcaster broadcaster;
    Factory factory;

    private static final String THIS_TOPIC = "create";

    @Inject
    public CreateSocket(WebSocketBroadcaster broadcaster, Factory factory) {
        this.factory = factory;
        this.broadcaster = broadcaster;
    }


    @OnMessage
    public Publisher<ResponseFactory> onMessage(
            String topic,
            RequestFactory message,
            WebSocketSession session) {

        return topic.equalsIgnoreCase(THIS_TOPIC) ?  broadcaster.broadcast(factory.createResponseFactory(message), Util.isValid(topic)) : null;

    }

    @OnClose
    public Publisher<String> onClose(
            WebSocketSession session) {
        String msg = "["+ THIS_TOPIC +"  Disconnected!";

        return broadcaster.broadcast(msg);
    }


}