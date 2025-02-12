/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildingdesighn;


import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
public class BuildingExample1 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create the building model
        Group building = new Group();
    // Create the base of the building
        Box base = new Box(150, 50, 100);
        PhongMaterial color1 =new PhongMaterial(Color.GRAY);
        base.setMaterial(color1);
       // base.setTranslateY(200);
        building.getChildren().add(base);
  // Create the first floor
        Box floor1 = new Box(80, 40, 80);
      PhongMaterial color2 =new PhongMaterial(Color.RED);
        floor1.setMaterial(color2);
        floor1.setTranslateY(250);
        building.getChildren().add(floor1);
     // Create the second floor
        Box floor2 = new Box(70, 40, 70);
        PhongMaterial color3 =new PhongMaterial(Color.BLUE);
        floor2.setMaterial(color3);
        floor2.setTranslateY(310);
        building.getChildren().add(floor2);
      // Create the roof
        Cylinder roof = new Cylinder(40, 30);
        PhongMaterial color4 =new PhongMaterial(Color.GREEN);
        roof.setMaterial(color4);
        roof.setTranslateY(400);
        roof.setRotationAxis(new Point3D(1, 0, 0));
        //roof.setRotate(90);
        building.getChildren().add(roof);
     // Add a rotate transform to the building
        Rotate rotateX = new Rotate(0, Rotate.X_AXIS);
        Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
        building.getTransforms().addAll(rotateX, rotateY);
   // Create a perspective camera
        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setTranslateZ(-500);
// Create a scene and add the building and camera to it
        Scene scene = new Scene(building, 800, 600);
        scene.setCamera(camera);
        // Add mouse event handlers to rotate the building and handle mouse clicks
        scene.setOnMouseDragged((MouseEvent event) -> {
            rotateX.setAngle(-event.getY());
            rotateY.setAngle(event.getX());
        });

        // Add keyboard event handlers to move the camera
        scene.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.W) {
                camera.setTranslateZ(camera.getTranslateZ() - 10);
            } else if (event.getCode() == KeyCode.S) {
                camera.setTranslateZ(camera.getTranslateZ() + 10);
            } else if (event.getCode() == KeyCode.A) {
                camera.setTranslateX(camera.getTranslateX() - 10);
            } else if (event.getCode() == KeyCode.D) {
                camera.setTranslateX(camera.getTranslateX() + 10);
            }else if (event.getCode() == KeyCode.C) {
                camera.setTranslateY(camera.getTranslateY() - 10);
            } else if (event.getCode() == KeyCode.B) {
                camera.setTranslateY(camera.getTranslateY() + 10);
            }
            

        });
    // Show the stage and set the scene
        primaryStage.setScene(scene);
        primaryStage.setTitle("Complex Building Model");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
