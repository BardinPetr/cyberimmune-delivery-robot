package ru.bardinpetr.delivery.libs.messages.kafka.interfaces;

import ru.bardinpetr.delivery.libs.messages.MessageRequest;

public interface ITopicListener {
    <T extends MessageRequest> void onMessage(T data);
}