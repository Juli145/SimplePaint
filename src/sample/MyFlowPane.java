package sample;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class MyFlowPane extends Application {
    FlowPane flowPane;
    Scene scene;
    Canvas canvas = new Canvas(900, 700);
    GraphicsContext graphicsContext;

    @Override
    public void start(Stage stage){
        graphicsContext = canvas.getGraphicsContext2D();

        MySlider mySlider = new MySlider();
        MyColorPicker myColorPicker = new MyColorPicker();

        flowPane = new FlowPane(Orientation.VERTICAL, 10, 10);

        flowPane.getChildren().add(canvas);
        flowPane.getChildren().add(mySlider.slider());
        flowPane.getChildren().add(mySlider.getLabel());
        flowPane.getChildren().add(mySlider.getButton());
        flowPane.getChildren().add(myColorPicker.getColorPicker());

        scene = new Scene(flowPane, 1100, 700);

        scene.setOnMousePressed(e ->{
            graphicsContext.beginPath();
            graphicsContext.fillRect(e.getSceneX(), e.getSceneY(), mySlider.slider.getValue(), mySlider.slider.getValue());
            graphicsContext.stroke();
        } );

        canvas.setOnMouseDragged((event) -> {
            graphicsContext.fillRect(event.getX(), event.getY(), mySlider.slider.getValue(), mySlider.slider.getValue());
            graphicsContext.setFill(myColorPicker.getColorPicker().getValue());
        });

        stage.setScene(scene);
        stage.show();
    }
}
