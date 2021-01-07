package main.java.core.item;

import main.java.core.logic.collision.Collisionable;
import main.java.core.visual.sprite.StaticItemSprite;

public abstract class InteractZone extends Item {
    public InteractZone(String nom, int w, int h) {
        this(nom, w,h, false);
    }
    public InteractZone(String nom, int w, int h, boolean hasCollision) {
        super(nom, new StaticItemSprite(0,0,w,h), hasCollision);
    }
}
