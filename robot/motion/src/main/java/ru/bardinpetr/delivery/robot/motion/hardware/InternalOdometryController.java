package ru.bardinpetr.delivery.robot.motion.hardware;

import ru.bardinpetr.delivery.robot.motion.hardware.models.MotorParams;

import java.time.Duration;
import java.time.Instant;

/**
 * Used to predict current reference position knowing only when speed was changed.
 * Returns position calculated to current time.
 */
public class InternalOdometryController {

    private MotorParams motors = new MotorParams(0, 0);
    private double[] position = new double[]{0, 0};
    private Instant lastUpdateTime;

    public double[] getPosition() {
        if (lastUpdateTime == null) return position;

        var delta = Duration.between(lastUpdateTime, Instant.now()).toSeconds();
        var speedX = motors.getSpeed() * Math.cos(motors.getDirection());
        var speedY = motors.getSpeed() * Math.sin(motors.getDirection());

        return new double[]{position[0] + speedX * delta, position[1] + speedY * delta};
    }

    public void update(MotorParams currentTarget) {
        position = getPosition();
        motors = currentTarget;
        lastUpdateTime = Instant.now();
    }
}
