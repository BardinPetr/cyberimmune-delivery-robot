package ru.bardinpetr.delivery.libs.messages.msg.location;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Position {
    private double x = 0;
    private double y = 0;

    private long timestampSeconds;

    public Position(double x, double y) {
        timestampSeconds = Instant.now().getEpochSecond();
        this.x = x;
        this.y = y;
    }

    public double distance(Position other) {
        return Math.hypot(x - other.getX(), y - other.getY());
    }

    public Position plus(Position b) {
        return new Position(x + b.getX(), y + b.getY(), Math.max(b.timestampSeconds, timestampSeconds));
    }

    public Position divide(double val) {
        return new Position(x / val, y / val, timestampSeconds);
    }

    @Override
    public Position clone() {
        return new Position(x, y, timestampSeconds);
    }
}
