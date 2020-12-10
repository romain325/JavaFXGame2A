package main.java.view;

public enum FRAME {
    START_PAGE("StartPage"),
    OUTSIDE_MAIN("MainCanvas")
    ;

    private String link;
    FRAME(String link){
        this.link = "/Vues/" + link + ".fxml";
    }

    public String getLink() {
        return link;
    }

}
