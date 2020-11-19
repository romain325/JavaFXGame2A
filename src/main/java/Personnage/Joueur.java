package main.java.Personnage;

public class Joueur extends Personnage {

    public Joueur(String nom) {
        super(nom);
    }

    public void setCoord(int x, int y){
        setX(x);
        setY(y);
    }

    @Override
    public void setX(int x) {
        //TODO Add collision Check
        super.setX(x);
    }

    @Override
    public void setY(int y) {
        //TODO Add collision Check
        super.setY(y);
    }

}
