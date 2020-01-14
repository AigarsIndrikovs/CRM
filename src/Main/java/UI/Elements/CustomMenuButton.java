package UI.Elements;

import javafx.scene.control.Button;

public class CustomMenuButton extends Button {
    public CustomMenuButton(String buttonName) {
        super (buttonName);
        setPrefSize(100, 30);
        setTextFill(javafx.scene.paint.Color.RED);

    }
}