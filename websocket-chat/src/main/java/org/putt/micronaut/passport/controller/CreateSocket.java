package org.putt.micronaut.passport.controller;

import io.micronaut.websocket.WebSocketBroadcaster;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.OnClose;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.ServerWebSocket;
import org.putt.micronaut.passport.model.request.CreateFactoryRequest;
import org.putt.micronaut.passport.model.response.FactoryResponse;
import org.putt.micronaut.passport.service.Factory;
import org.putt.micronaut.passport.service.Util;
import org.reactivestreams.Publisher;

import javax.inject.Inject;

@ServerWebSocket("/create/{topic}/{sessionId}")
public class CreateSocket {
    private WebSocketBroadcaster broadcaster;
    private Factory factory;

    private static final String THIS_TOPIC = "create";

    @Inject
    public CreateSocket(WebSocketBroadcaster broadcaster, Factory factory) {
        this.factory = factory;
        this.broadcaster = broadcaster;
    }


    @OnMessage
    public Publisher<FactoryResponse> createFactory(
            String topic,
            CreateFactoryRequest message,
            WebSocketSession session) {

        return topic.equalsIgnoreCase(THIS_TOPIC) ?  broadcaster.broadcast(factory.createResponseFactory(message), Util.isValid(topic)) : null;

    }

    @OnClose
    public Publisher<String> onClose(
            String sessionId,
            WebSocketSession session) {
        String msg = "["+ THIS_TOPIC +"]  Disconnected!";

        return broadcaster.broadcast(msg, Util.isValid(sessionId));
    }


}
