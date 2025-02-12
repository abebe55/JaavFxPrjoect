/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxexample1;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
public class BoxExample1 extends Application {
  @Override
    public void start(Stage primaryStage) {
        Box box = new Box(300, 200, 200);
        PhongMaterial color =new PhongMaterial(Color.RED);
        box.setMaterial(color); 
        Rotate rotateX = new Rotate(0, Rotate.X_AXIS);
        Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
        box.getTransforms().addAll(rotateX, rotateY);
        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setTranslateZ(-500);
        camera.setTranslateX(-300);
        camera.setTranslateY(-200);
        Group root = new Group();
        root.getChildren().add(box);
        Scene scene = new Scene(root,800,600);
        scene.setCamera(camera);
          scene.setOnMouseDragged((MouseEvent event) -> {
            rotateX.setAngle(-event.getY());
            rotateY.setAngle(event.getX());
        });
         EventHandler<MouseEvent> event=new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){
               PhongMaterial color =new PhongMaterial(Color.BLUE);
           box.setMaterial(color); 
            }   
        };
          box.addEventHandler(MouseEvent.MOUSE_CLICKED, event);
          box.removeEventHandler(MouseEvent.MOUSE_PRESSED , event);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple Box Rotation");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
