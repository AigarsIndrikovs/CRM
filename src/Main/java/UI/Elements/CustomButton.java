package UI.Elements;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class CustomButton extends Button {
    public CustomButton(String buttonName) {
        super (buttonName);
        setPrefSize(100, 30);
        setTextFill(Color.BLACK);
    }
}