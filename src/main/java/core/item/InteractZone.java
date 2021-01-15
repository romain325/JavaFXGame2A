package main.java.core.item;

import main.java.core.logic.collision.Collisionable;
import main.java.core.visual.sprite.StaticItemSprite;
import main.java.core.visual.ui.InfoBox;

public class InteractZone extends Item {
    public InteractZone(String nom,int x, int y, int w, int h, String message,boolean hasCollision, boolean hasUnlimitedConso) {
        super(nom, new StaticItemSprite(x,y,w,h), message, hasCollision, hasUnlimitedConso,0,0);
    }
    public InteractZone(ItemDTO dto) {
        super(dto);
    }
}
