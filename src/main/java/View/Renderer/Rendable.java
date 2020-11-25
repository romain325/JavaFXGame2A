package main.java.View.Renderer;

public interface Rendable extends Comparable<Rendable> {
    int getZindex();
    void render();

    @Override
    default int compareTo(Rendable rendable){
        return - Integer.compare(this.getZindex(), rendable.getZindex());
    }
}
