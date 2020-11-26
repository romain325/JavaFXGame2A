package main.java.core.control;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.EnumSet;
import java.util.Set;

// "Singleton" with context
public class KeyBinder {
    private static Scene scene = null;
    private static KeyBinder instance = null;

    private final Set<KeyCode> keyDown = EnumSet.allOf(KeyCode.class);

    private KeyBinder(){
        clearKeyDown();
        setScene(KeyBinder.scene);
    }

    public static KeyBinder getInstance() throws Exception {
        if(scene == null || instance == null){
            throw new Exception("Context needs to be precised in order to get an Instance");
        }else{
            return instance;
        }
    }


    public static void initContext(Scene scene){
        if(scene != null && instance != null){
            instance.removeKeyListener();
        }
        KeyBinder.scene = scene;
        instance = new KeyBinder();
    }


    public void setScene(Scene scene){
        scene.setOnKeyPressed(this::onKeyPressed);
        scene.setOnKeyReleased(this::onKeyReleased);
    }

    protected void onKeyPressed(KeyEvent e){
        keyDown.add(e.getCode());
    }

    protected void onKeyReleased(KeyEvent e){
        keyDown.remove(e.getCode());
    }

    protected void clearKeyDown(){
        keyDown.clear();
    }

    protected void removeKeyListener(){
        KeyBinder.scene.setOnKeyReleased(null);
        KeyBinder.scene.setOnKeyPressed(null);
    }

    public boolean isKeyDown(KeyCode code){
        return keyDown.contains(code);
    }

}
