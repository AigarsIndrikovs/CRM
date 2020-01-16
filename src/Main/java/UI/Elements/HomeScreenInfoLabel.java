package UI.Elements;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HomeScreenInfoLabel extends Label {
    public HomeScreenInfoLabel(String labelName) {
        super (labelName);
        setFont(Font.font(55));
        setStyle("-fx-background-color:WHITE");

    }
}
