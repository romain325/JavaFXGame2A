package main.java.core.logic;

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
        if(l - lastFrame >= 30_000_000){
            tick();
            lastFrame = l;
        }
    }

    // Injection
    public abstract void tick();
}
