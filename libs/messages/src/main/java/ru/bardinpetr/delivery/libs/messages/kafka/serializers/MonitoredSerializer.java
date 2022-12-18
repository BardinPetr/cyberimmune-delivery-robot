package ru.bardinpetr.delivery.libs.messages.kafka.serializers;

import org.springframework.kafka.support.serializer.JsonSerializer;
import ru.bardinpetr.delivery.libs.messages.msg.MessageRequest;

public class MonitoredSerializer extends JsonSerializer<MessageRequest> {

    public MonitoredSerializer() {
        super();
        this.noTypeInfo();
    }
}
