package ru.bardinpetr.delivery.common.libs.messages.msg.sensors;

import lombok.*;
import ru.bardinpetr.delivery.common.libs.messages.msg.MessageRequest;
import ru.bardinpetr.delivery.common.libs.messages.msg.location.Position;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class HumanDetectionConfigRequest extends MessageRequest {
    private Position location;
    private double accuracy;
}
