package UI.Elements;

import javafx.scene.control.Button;

public class CustomButton extends Button {
    public CustomButton(String buttonName) {
        super (buttonName);
        setPrefSize(100, 30);
        setTextFill(javafx.scene.paint.Color.RED);

    }
}