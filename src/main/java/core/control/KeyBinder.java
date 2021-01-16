package main.java.core.control;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.java.core.control.action.Action;

import java.util.HashSet;
import java.util.Set;

// All Static ?
// TODO Switch to singleton ? or one keybinder linked to a playerController
public class KeyBinder {
    private static Scene scene = null;
    private static Set<KeyCode> keyDown = new HashSet<>();

    /**
     * init context with a new scene
     * @param scene the scene to listen to
     */
    public static void initContext(Scene scene){
        if(KeyBinder.scene != null){
            KeyBinder.removeKeyListener();
        }
        KeyBinder.scene = scene;
        KeyBinder.scene.setOnKeyPressed(KeyBinder::onKeyPressed);
        KeyBinder.scene.setOnKeyReleased(KeyBinder::onKeyReleased);
    }

    /**
     * what to do on key pressed
     * @param e keyEvent
     */
    protected static void onKeyPressed(KeyEvent e){
        keyDown.add(e.getCode());
    }

    /**
     * what to do on key released
     * @param e keyEvent
     */
    protected static void onKeyReleased(KeyEvent e){
        keyDown.remove(e.getCode());
    }

    /**
     * Remove all listener from a scene
     */
    protected static void removeKeyListener(){
        KeyBinder.scene.setOnKeyReleased(null);
        KeyBinder.scene.setOnKeyPressed(null);
    }

    /**
     * Check if any key is down
     * @return has any key down
     */
    public static boolean hasKeyDown(){ return keyDown.isEmpty(); }

    /**
     * Check if a given key is down or not
     * @return is given key down
     */
    public static boolean isKeyDown(KeyCode code){
        return keyDown.contains(code);
    }

    /**
     * get currently down key
     * @return currently down key
     */
    public static InteractKey getCurrentInteract(){
        if (hasKeyDown()) return InteractKey.NONE_KEY;
        return InteractKey.getInteractKey((KeyCode) keyDown.toArray()[0]);
    }

    /**
     * get action related to the currently down key
     * @param playerController ingame player controller
     * @return action instance related to the current key
     */
    public static Action getCurrentAction(PlayerController playerController) {
        return getCurrentInteract().getAction(playerController);
    }

}
