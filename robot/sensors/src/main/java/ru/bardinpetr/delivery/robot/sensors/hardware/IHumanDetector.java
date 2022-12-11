package ru.bardinpetr.delivery.robot.sensors.hardware;

import ru.bardinpetr.delivery.libs.messages.msg.sensors.HumanDetectionConfigRequest;

public interface IHumanDetector {
    void config(HumanDetectionConfigRequest config);

    void setCallback(Runnable runnable);
}
