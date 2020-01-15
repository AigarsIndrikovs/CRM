package UI.Elements;


import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class CreateLayoutCustomLabel extends Label {
    public CreateLayoutCustomLabel(String labelName) {
        super (labelName);
        setFont(Font.font(15));

    }
}
