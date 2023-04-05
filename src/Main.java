import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Object3D> scene = new ArrayList<Object3D>();
        Point3D p1 = new Point3D(-5,-50,4);
        Point3D p2 = new Point3D(6,-60,1);
        Point3D p3 = new Point3D(4,-40,5);
        Triangle test = new Triangle(p1,p2,p3);
        scene.add(test);

        JFrame frame = new JFrame();
        frame.setSize(320,240);
        Camera panel = new Camera(new Point3D(0,0,0),scene);
        frame.add(panel);
        frame.setVisible(true);
    }
}