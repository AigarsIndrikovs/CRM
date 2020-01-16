package UI.Elements;


import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class CustomLabel extends Label {
    public CustomLabel(String labelName) {
        super (labelName);
        setFont(Font.font(15));

    }
}
