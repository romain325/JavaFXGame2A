import main.java.Control.PlayerController;
import main.java.Launch.GameLoop;
import main.java.Launch.Main;
import main.java.Personnage.Joueur;


public class PlayerControllerTest {
    public final Joueur j = new Joueur("Roberto");
    public final PlayerController controller = new PlayerController(j);

    public static void main(String[] args) {
        GameLoop g = new GameLoop();
        g.run();
    }
}
