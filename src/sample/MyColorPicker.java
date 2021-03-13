package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class MyColorPicker extends Application {
    ColorPicker colorPicker = new ColorPicker();

    public void colorPicker(){
        colorPicker.valueProperty().addListener(new ChangeListener<Color>() {
            @Override public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
                colorPicker.setValue(newValue);
            }
        });
    }

    public ColorPicker getColorPicker(){
        return colorPicker;
    }

    @Override
    public void start(Stage primaryStage) {
    }
}
