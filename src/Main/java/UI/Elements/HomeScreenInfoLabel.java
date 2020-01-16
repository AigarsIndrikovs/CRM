package UI.Elements;

import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HomeScreenInfoLabel extends Label {
    public HomeScreenInfoLabel(String labelName) {
        super (labelName);
        setFont(Font.font(45));
        setStyle("-fx-background-color:WHITE");
        setStyle("-fx-font-weight: bold;");
        setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        setPrefWidth(120);

    }
}
