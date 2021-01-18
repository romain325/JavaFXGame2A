package main.java.core.item;

import main.java.core.logic.Action;
import main.java.core.visual.sprite.StaticItemSprite;

public class InteractZone extends Item {
    public InteractZone(String nom,int x, int y, int w, int h, String message,boolean hasCollision, boolean hasUnlimitedConso) {
        super(nom, new StaticItemSprite(x,y,w,h), message, hasCollision, hasUnlimitedConso,0,0);
    }
    public InteractZone(String nom,int x, int y, int w, int h, String message,boolean hasCollision, boolean hasUnlimitedConso, Action action) {
        super(nom, new StaticItemSprite(x,y,w,h), message, hasCollision, hasUnlimitedConso,0,0);
        this.action = action;
    }
    public InteractZone(ItemDTO dto) {
        super(dto);
    }
}
