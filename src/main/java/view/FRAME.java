package main.java.view;

public enum FRAME {
    START_PAGE("StartPage"),
    KNOWN_PLAYER_START("KnownStart"),
    PLAYABLE_CANVAS("PlayableCanvas"),
    GAME_OVER("GameOver")
    ;

    private String link;
    FRAME(String link){
        this.link = "/views/" + link + ".fxml";
    }

    public String getLink() {
        return link;
    }

}
