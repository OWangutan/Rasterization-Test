import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


//sound imports
import java.io.File;
import javax.sound.sampled.*;


public class Main {
    public static void main(String[] args) {




        ArrayList<Triangle> scene = new ArrayList<Triangle>();
//
//        Point3D point1 = new Point3D(-50,-50,5);
//        Point3D point2 = new Point3D(-50,-100,50);
//        Point3D point3 = new Point3D(-100,-50,50);
//
//        Triangle tester = new Triangle(point1,point2,point3,new Color(255,0,0));
//
//        scene.add(tester);
//
//
//        //ground
//        ArrayList<Triangle> ground = new ArrayList<Triangle>();
//        Point3D g1 = new Point3D(-500,100,500);
//        Point3D g2 = new Point3D(500,100,500);
//        Point3D g3 = new Point3D(500,100,-500);
//        Triangle ground1 = new Triangle(g1,g2,g3, new Color(31,71,24));
//        ground.add(ground1);
//        //      scene.add(ground1);
//
//        Point3D g4 = new Point3D(-500,100,-500);
//        Triangle ground2 = new Triangle(g1,g3,g4, new Color(31,71,24));
//        ground.add(ground2);
//        //     scene.add(ground2);
//
//
//        //ground
//
//
//
//
        //face 1
        Point3D f1p1 = new Point3D(-50,-50,5);
        Point3D f1p2 = new Point3D(50,-50,5);
        Point3D f1p3 = new Point3D(50,50,5);


        Point3D f1p4 = new Point3D(-50,50,5);
        //face 2
        Point3D f2p1 = new Point3D(-50,-50,105);
        Point3D f2p2 = new Point3D(50,-50,105);
        //face 3
        Point3D f3p1 = new Point3D(-50,50,105);
        Point3D f3p2 = new Point3D(50,50,105);


//
//        Point3D tP3 = new Point3D(100,-50,-30);
        Triangle f1t1 = new Triangle(f1p1,f1p2,f1p3, new Color(3, 232, 252));
        Triangle f1t2 = new Triangle(f1p1,f1p4,f1p3, new Color (3, 232, 252));


        Triangle f2t1 = new Triangle(f1p1,f2p1,f1p2, new Color (3, 148, 252));
        Triangle f2t2 = new Triangle(f1p2,f2p2,f2p1,new Color (3, 148, 252));


        Triangle f3t1 = new Triangle(f2p2,f3p2,f3p1,new Color(3, 94, 252));
        Triangle f3t2 = new Triangle(f2p2,f2p1,f3p1,new Color(3, 94, 252));


        Triangle f4t1 = new Triangle(f3p1,f1p3,f3p2,new Color(3, 40, 252));
        Triangle f4t2 = new Triangle(f1p3,f1p4,f3p1,new Color(3, 40, 252));


        Triangle f5t1 = new Triangle(f1p4,f3p1,f2p1,new Color (32, 3, 252));
        Triangle f5t2 = new Triangle(f1p1,f2p1,f3p1, new Color (32, 3, 252));


        Triangle f6t1 = new Triangle(f1p2,f1p3,f3p2,new Color(17, 2, 99));
        Triangle f6t2 = new Triangle(f2p2,f1p2,f3p2, new Color(17, 2, 99));
//        Triangle test2 = new Triangle(p1,p2,tP3, new Color(58, 128, 46));
//        Triangle test3 = new Triangle(p2,p3,tP3, new Color(104, 237, 81));
        scene.add(f1t1);
        scene.add(f1t2);
        scene.add(f2t1);
        scene.add(f2t2);
        scene.add(f3t1);
        scene.add(f3t2);
        scene.add(f4t1);
        scene.add(f4t2);
        scene.add(f5t1);
        scene.add(f5t2);
        scene.add(f6t1);
        scene.add(f6t2);
//        scene.add(test2);
//        scene.add(test3);








        JFrame frame = new JFrame();
        frame.setSize(1920,1080);
        frame.setResizable(false);
        Camera camera = new Camera(new Point3D(0,0,0),scene);
        frame.add(camera);
        frame.setVisible(true);
        camera.setFov(70);






//        while (true) {
//            try {
//                Thread.sleep(10);
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//            int newX = Rotate.calculateX(p1,10,10,10);
//            int newY = Rotate.calculateY(p1,10,10,10);
//            int newZ = Rotate.calculateZ(p1,10,10,10);
//            p1.setx(newX);
//            p1.sety(newY);
//            p1.setz(newZ);
//
//        }


    }
}
