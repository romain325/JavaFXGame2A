package main.java.core.control;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.EnumSet;
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


    public static void setScene(Scene scene){
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

    public static boolean isKeyDown(KeyCode code){
        return keyDown.contains(code);
    }

}
