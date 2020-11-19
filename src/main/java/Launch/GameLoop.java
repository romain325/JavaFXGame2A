package main.java.Launch;

public class GameLoop {
    private static Boolean IsRunning = false;

    public void run(){
        IsRunning = true;
        while (IsRunning){

        }
    }

    public static void EndGame(){
        IsRunning = false;
    }
}
