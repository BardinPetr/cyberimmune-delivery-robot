package ru.bardinpetr.delivery.robot.motion.hardware;

import ru.bardinpetr.delivery.libs.messages.msg.location.Position;
import ru.bardinpetr.delivery.robot.motion.hardware.models.MotorParams;

public class MotorController {
    private final InternalOdometryController odometryController;
    private final MotorRestrictions restrictions;
    private MotorParams currentTarget = new MotorParams();

    public MotorController(MotorRestrictions restrictions) {
        this.restrictions = restrictions;
        odometryController = new InternalOdometryController();
    }

    public void set(MotorParams params) {
        currentTarget = restrictions.apply(params);
        odometryController.update(currentTarget);
        // send commands to motors
    }

    public MotorRestrictions getRestrictions() {
        return restrictions;
    }

    public MotorParams getCurrentTarget() {
        return currentTarget;
    }

    public Position getReferenceIdealPosition() {
        return odometryController.getPosition();
    }
}
