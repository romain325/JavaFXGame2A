package main.java.view.renderer;

public enum ZIndex {
    MAP(1,false),
    BUILDING(2,true),
    ITEM(3,false),
    CHARACTER(4,true),
    GENERAL_UI(5,false),
    DIALOG(6,false),
    MENU(7,false)
    ;

    private int zindex;
    private boolean hasCollision;

    ZIndex(int zindex, boolean hasCollision){
        this.zindex = zindex;
        this.hasCollision = hasCollision;
    }

    public int getIndex() {
        return zindex;
    }

    public boolean hasCollision() {
        return hasCollision;
    }
}
