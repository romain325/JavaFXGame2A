package main.java.core.control;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.java.core.control.action.Action;
import main.java.core.control.action.Idle;
import main.java.core.personnage.Joueur;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

// All Static ?
public class KeyBinder {
    private static Scene scene = null;

    private static Set<KeyCode> keyDown = new HashSet<>();

    public static void initContext(Scene scene){
        if(KeyBinder.scene != null){
            KeyBinder.removeKeyListener();
        }
        KeyBinder.scene = scene;
        setScene(KeyBinder.scene);
    }

    private static void setScene(Scene scene){
        scene.setOnKeyPressed(KeyBinder::onKeyPressed);
        scene.setOnKeyReleased(KeyBinder::onKeyReleased);
    }

    protected static void onKeyPressed(KeyEvent e){
        keyDown.add(e.getCode());
    }

    protected static void onKeyReleased(KeyEvent e){
        keyDown.remove(e.getCode());
    }

    protected static void clearKeyDown(){
        keyDown.clear();
    }

    protected static void removeKeyListener(){
        KeyBinder.scene.setOnKeyReleased(null);
        KeyBinder.scene.setOnKeyPressed(null);
    }

    public static boolean hasKeyDown(){ return keyDown.isEmpty(); }

    public static boolean isKeyDown(KeyCode code){
        return keyDown.contains(code);
    }

    public static InteractKey getCurrentInteract(){
        if (hasKeyDown()) return InteractKey.NONE_KEY;
        return InteractKey.getInteractKey((KeyCode) keyDown.toArray()[0]);
    }

    public static Action getCurrentAction(PlayerController playerController) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return getCurrentInteract().getAction(playerController);
    }

}
