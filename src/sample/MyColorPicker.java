package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MyColorPicker extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public ColorPicker colorPicker(){
        ColorPicker colorPicker = new ColorPicker();

        final Color[] color = {colorPicker.getValue()};

        colorPicker.setOnAction(new EventHandler() {
            public void handle(Event t) {
                color[0] = colorPicker.getValue();
            }
        });

        VBox vBox = new VBox(colorPicker);
        //HBox hBox = new HBox(button1, button2);
        Scene scene = new Scene(vBox, 960, 600);
        return colorPicker;
    }


    @Override
    public void start(Stage primaryStage) {
    }
}
