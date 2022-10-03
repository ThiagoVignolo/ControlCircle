package controlcircle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author Thiago Vignolo
 */
public class ControlCircle extends Application {
    MainCircle maincircle = new MainCircle();
    
    @Override
    public void start(Stage primaryStage) {
        
        
        HBox hbox = new HBox();
        
        Button btnEnlarge = new Button();
        btnEnlarge.setText("Enlarge");
        Button btnShrink = new Button();
        btnShrink.setText("Shrink");

        btnEnlarge.setOnAction(new EnlargeHandler());
        btnShrink.setOnAction(new ShrinkHandler());
        
        hbox.getChildren().add(btnEnlarge);
        hbox.getChildren().add(btnShrink);
        
        BorderPane root = new BorderPane();
        root.setCenter(maincircle);
        root.setBottom(hbox);
        
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Control Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    class MainCircle extends StackPane{
        Circle circle = new Circle();
        
        public MainCircle(){
            getChildren().add(circle);
            circle.setFill(Color.TRANSPARENT);
            circle.setStroke(Color.BLACK);
            circle.setRadius(50.0f);
        }
        
        public void Enlarge(){
            circle.setRadius(circle.getRadius() +10);
        }
        
        public void Shrink(){
            circle.setRadius(circle.getRadius() -10);
        }
    }
    
    private class EnlargeHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle (ActionEvent event) {
            maincircle.Enlarge();
        }
    }
    
    private class ShrinkHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle (ActionEvent event) {
            maincircle.Shrink();
        }
    }
    
}
