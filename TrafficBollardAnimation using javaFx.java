/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafic;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Cylinder;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TrafficBollardAnimation extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene=new Scene(root,600,600);
        scene.setFill(Color.SKYBLUE);
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setNearClip(0.1);
        camera.setFarClip(10000.0);
        camera.setTranslateZ(-1000);
        scene.setCamera(camera);

        // Create multiple bars for the traffic bollard
        int numBars = 8; // Change this value to create more or fewer bars
        double barRadius = 10.0;
        double barHeight = 200.0;
        double gapBetweenBars = 20.0;

        for (int i = 0; i < numBars; i++) {
            Cylinder bar = new Cylinder(barRadius, barHeight);
            bar.setTranslateX(200 * Math.cos(2 * Math.PI * i / numBars));
            bar.setTranslateZ(200 * Math.sin(2 * Math.PI * i / numBars));
           // bar.setRotationAxis(Cylinder.Y_AXIS);
            bar.setRotate(360 * i / numBars);
            root.getChildren().add(bar);

            // Create labels for each bar
            Text label = new Text("Bar " + (i + 1));
            label.setFont(Font.font(15));
            label.setFill(Color.BLACK);
            label.setTranslateX(bar.getTranslateX() - 30);
            label.setTranslateY(barHeight / 2 + gapBetweenBars + 10);
            label.setTranslateZ(bar.getTranslateZ());
            root.getChildren().add(label);
        }

        // Create an animation to rotate the bollard
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), event -> {
            root.setRotate(root.getRotate() + 1);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        primaryStage.setTitle("Traffic Bollard Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}