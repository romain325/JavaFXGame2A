package main.java.core.item;

import main.java.utils.Vector;
import main.java.utils.serialization.DTOElement;

public class ItemDTO implements ItemProcuration, DTOElement<Item> {
    private final Vector pos;
    private final int width;
    private final int height;
    private final String nom;
    private String message = "";
    private final boolean hasCollision;
    private final boolean hasIllimitedCollision;
    private final boolean hasSprite;
    private final int hintVal;
    private final int apparitionDay;

    public ItemDTO(Item item) {
        this.pos = item.getPosition();
        this.width = item.getWidth();
        height  = item.getHeight();
        nom = item.getNom();
        message = item.getMessage();
        hasCollision = item.hasCollision();
        hasIllimitedCollision = item.hasIllimitedConsommation();
        hasSprite = item.getVisual().isVisible();
        hintVal = item.getHintValue();
        apparitionDay = item.getApparitionDay();
    }

    @Override
    public boolean hasIllimitedConsommation() {
        return hasIllimitedCollision;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Vector getPosition() {
        return pos;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public boolean hasCollision() {
        return hasCollision;
    }

    @Override
    public int getHintValue() {
        return hintVal;
    }

    @Override
    public int getApparitionDay() {
        return apparitionDay;
    }

    /**
     * Getter
     * @return value
     */
    public boolean hasSprite() {
        return hasSprite;
    }

    @Override
    public Item getInstance() {
        return new Item(this);
    }
}
