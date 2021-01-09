package main.java.core.item;

import main.java.core.logic.Interactive;
import main.java.core.logic.movement.Vector;
import main.java.utils.serialization.DTOElement;

import java.io.Serializable;

public class ItemDTO implements ItemProcuration, DTOElement<Item> {
    private final Vector pos;
    private final int width;
    private final int height;
    private final String nom;
    private String message = "";
    private final boolean hasCollision;
    private boolean hasIllimitedCollision;
    private boolean hasSprite;

    public ItemDTO(Item item) {
        this.pos = item.getPosition();
        this.width = item.getWidth();
        height  = item.getHeight();
        nom = item.getNom();
        message = item.getMessage();
        hasCollision = item.hasCollision();
        hasIllimitedCollision = item.hasIllimitedConsommation();
        hasSprite = item.getVisual().isVisible();
    }

    public boolean hasIllimitedConsommation() {
        return hasIllimitedCollision;
    }

    public String getMessage() {
        return message;
    }

    public Vector getPosition() {
        return pos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getNom() {
        return nom;
    }

    public boolean hasCollision() {
        return hasCollision;
    }

    public boolean hasSprite() {
        return hasSprite;
    }

    @Override
    public Item getInstance() {
        return new Item(this);
    }
}
