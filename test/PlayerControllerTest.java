import javafx.application.Application;
import main.java.View.MainFrame;


public class PlayerControllerTest {


    public static void main(String[] args) throws InterruptedException {
        int NS_PER_FRAME = 33000000;
        long fin = 0;
        //Application.launch(MainFrame.class, args);
        for (int i = 0; i< 5; i++){
            long debut = System.nanoTime();
            System.out.println(debut - fin);
            while(System.nanoTime() - debut <= NS_PER_FRAME){
                Thread.sleep(1);
            }
            System.out.println(System.nanoTime() - debut);
            fin = System.nanoTime();
        }
    }
}
