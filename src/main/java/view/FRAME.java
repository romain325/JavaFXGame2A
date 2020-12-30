package main.java.view;

public enum FRAME {
    START_PAGE("StartPage"),
    PLAYABLE_CANVAS("PlayableCanvas")
    ;

    private String link;
    FRAME(String link){
        this.link = "/Vues/" + link + ".fxml";
    }

    public String getLink() {
        return link;
    }

}
