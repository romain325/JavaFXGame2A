package main.java.core.visual;

public enum ZIndex {
    MAP(1,false),
    BUILDING(2,true),
    ITEM(3,false),
    CHARACTER(4,true),
    GENERAL_UI(5,false),
    //DIALOG(6,false),
    MENU(7,false)
    ;

    private int zindex;
    private boolean hasCollision;

    ZIndex(int zindex, boolean hasCollision){
        this.zindex = zindex;
        this.hasCollision = hasCollision;
    }

    /**
     * index of the instance
     * @return index
     */
    public int getIndex() {
        return zindex;
    }

    /**
     * has collision
     * @return instance collision
     */
    public boolean hasCollision() {
        return hasCollision;
    }
}
