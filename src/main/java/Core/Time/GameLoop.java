package main.java.Core.Time;

import javafx.animation.AnimationTimer;

public abstract class GameLoop extends AnimationTimer {
    private boolean isRunning;
    private long start;
    private long lastFrame;
    private double duration;


    @Override
    public void start() {
        super.start();
        isRunning = true;
    }

    @Override
    public void stop() {
        super.stop();
        isRunning = false;
        duration = 0;
    }

    @Override
    public void handle(long l) {
        duration = l/1e9; // convert from nano seconds
        // if not working
        // var  = (float) ((l - lastFrame) / 1e9)
        // lastFrame = l;
        // tick var
        tick((float) ((l - lastFrame) / 1e9));
        lastFrame = l;
    }

    // Injection
    public abstract void tick(float elapsedSec);
}
