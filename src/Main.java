import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//sound imports
import java.io.File;
import javax.sound.sampled.*;

public class Main {
    public static void main(String[] args) {


        ArrayList<Triangle> scene = new ArrayList<Triangle>();

        Point3D point1 = new Point3D(-50,-50,5);
        Point3D point2 = new Point3D(-50,-100,50);
        Point3D point3 = new Point3D(-100,-50,50);

        Triangle tester = new Triangle(point1,point2,point3,new Color(255,0,0));

        scene.add(tester);


        //ground
        ArrayList<Triangle> ground = new ArrayList<Triangle>();
        Point3D g1 = new Point3D(-500,100,500);
        Point3D g2 = new Point3D(500,100,500);
        Point3D g3 = new Point3D(500,100,-500);
        Triangle ground1 = new Triangle(g1,g2,g3, new Color(31,71,24));
        ground.add(ground1);
        //      scene.add(ground1);

        Point3D g4 = new Point3D(-500,100,-500);
        Triangle ground2 = new Triangle(g1,g3,g4, new Color(31,71,24));
        ground.add(ground2);
        //     scene.add(ground2);


        //ground


        Point3D p1 = new Point3D(-50,-50,5);
        Point3D p2 = new Point3D(50,-50,5);
        Point3D p3 = new Point3D(50,50,5);

        Point3D tP3 = new Point3D(100,-50,-30);
        Triangle test = new Triangle(p1,p2,p3, new Color(31, 71, 24));
        Triangle test2 = new Triangle(p1,p2,tP3, new Color(58, 128, 46));
        Triangle test3 = new Triangle(p2,p3,tP3, new Color(104, 237, 81));
        scene.add(test);
        scene.add(test2);
        scene.add(test3);

        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setResizable(false);
        Camera camera = new Camera(new Point3D(0,0,0),scene);
        frame.add(camera);
        frame.setVisible(true);
        camera.setFov(70);
    }
}