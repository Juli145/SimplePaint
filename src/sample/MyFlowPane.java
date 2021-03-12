package sample;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class MyFlowPane extends Application {

    @Override
    public void start(Stage stage){
        MySlider mySlider = new MySlider();
        MyColorPicker myColorPicker = new MyColorPicker();
        Color color = myColorPicker.colorPicker().getValue();

        FlowPane flowPane = new FlowPane(Orientation.VERTICAL, 10, 10);
        Canvas canvas = new Canvas(900, 700);
        flowPane.getChildren().add(canvas);
        flowPane.getChildren().add(mySlider.slider());
        flowPane.getChildren().add(mySlider.getLabel());
        flowPane.getChildren().add(mySlider.getButton());
        flowPane.getChildren().add(myColorPicker.colorPicker());

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0, 0, 1000, 700);

        canvas.setOnMouseDragged((event) -> {
            graphicsContext.setFill(myColorPicker.colorPicker().getValue());
            graphicsContext.fillRect(event.getX(), event.getY(),mySlider.slider.getValue(), mySlider.slider.getValue());
        });

        stage.setScene(new Scene(flowPane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(MyFlowPane.class);
    }
}
