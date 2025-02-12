/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siolarsystem;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SolarSystemWithMoon extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setTranslateX(-400);
        camera.setTranslateZ(-1000);
        camera.setTranslateY(-300);
        Sphere sun = new Sphere(50);
        PhongMaterial sunMaterial = new PhongMaterial();
        sunMaterial.setDiffuseColor(Color.WHITE);
        sun.setMaterial(sunMaterial);
        root.getChildren().add(sun);
        int numPlanets = 7; // More than 4 planets
        for (int i = 0; i < numPlanets; i++) {
            Group planetGroup = new Group(); // Group for the planet and its moon(s)
            Sphere planet = new Sphere(10 + i * 2); // Incremental size for visual effect
            PhongMaterial planetMaterial = new PhongMaterial();
            planetMaterial.setDiffuseColor(Color.color(Math.random(), Math.random(), Math.random()));
            planet.setMaterial(planetMaterial);
            planetGroup.getChildren().add(planet); // Add the planet to its group

           if (i == 2) { // Let's add a moon to the third planet as an example
                Sphere moon = new Sphere(5); // Smaller sphere for the moon
                PhongMaterial moonMaterial = new PhongMaterial();
                moonMaterial.setDiffuseColor(Color.GRAY);
                moon.setMaterial(moonMaterial);
                moon.setTranslateX(30); // Position the moon relative to the planet
                planetGroup.getChildren().add(moon);
            }

            Circle orbit = new Circle(150 + i * 50); // Incremental radius for orbits
            orbit.setOpacity(10);// Invisible orbit path
         
            PathTransition transition = new PathTransition();
            transition.setNode(planetGroup); // Animate the whole group
            transition.setPath(orbit);
            transition.setInterpolator(Interpolator.LINEAR);
            transition.setDuration(Duration.seconds(10 + i * 2)); // Different durations for different orbital speeds
            transition.setOrientation(PathTransition.OrientationType.NONE);
            transition.setCycleCount(PathTransition.INDEFINITE);
            transition.play();

            root.getChildren().add(planetGroup);
        }
Scene scene = new Scene(root, 800, 600);
scene.setCamera(camera);
       scene.setFill(Color.BLACK);
        primaryStage.setTitle("Solar System Simulation with Moon");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
