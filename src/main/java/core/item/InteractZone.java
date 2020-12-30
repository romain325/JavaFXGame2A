package main.java.core.item;

import main.java.core.visual.sprite.StaticItemSprite;

public abstract class InteractZone extends Item{
    public InteractZone(String nom, int w, int h) {
        super(nom, new StaticItemSprite(0,0,w,h));
    }
}
