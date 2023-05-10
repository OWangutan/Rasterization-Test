import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Object3D> scene = new ArrayList<Object3D>();
        Point3D p1 = new Point3D(-50,-50,5);
        Point3D p2 = new Point3D(50,-50,5);
        Point3D p3 = new Point3D(50,50,5);
        Triangle test = new Triangle(p1,p2,p3);
        scene.add(test);

        JFrame frame = new JFrame();
        frame.setSize(320,240);
        Camera camera = new Camera(new Point3D(0,0,0),scene);
        frame.add(camera);
        frame.setVisible(true);
        camera.setFov(70);
    }
}