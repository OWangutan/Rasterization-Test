import java.util.ArrayList;
import java.awt.*;
public final class Shapes3D {
    public static ArrayList<Triangle> addSquare(Point3D point1, Point3D point2){
        return new ArrayList<Triangle>();
    }
    public static ArrayList<Triangle> addCube(Point3D pos ,double w, double h,double l, Color color){
        ArrayList<Triangle> triangles = new ArrayList<Triangle>();
        Point3D point1 = new Point3D(pos);
        Point3D point2 = new Point3D(pos.getx() + w,pos.gety(),pos.getz());
        Point3D point3 = new Point3D(pos.getx(),pos.gety() + h,pos.getz());
        Point3D point4 = new Point3D(pos.getx() + w,pos.gety() + h,pos.getz());
        Point3D point5 = new Point3D(pos.getx() ,pos.gety(),pos.getz() + l);
        Point3D point6 = new Point3D(pos.getx() + w,pos.gety(),pos.getz() + l);
        Point3D point7 = new Point3D(pos.getx(),pos.gety()+ h,pos.getz() + l);
        Point3D point8 = new Point3D(pos.getx() + w,pos.gety() + h,pos.getz() + l);

        triangles.add(new Triangle(point1,point2,point3,color));
        triangles.add(new Triangle(point2,point3,point4,color));
        triangles.add(new Triangle(point1,point3,point5,color));
        triangles.add(new Triangle(point3, point5, point7,color));
        triangles.add(new Triangle(point1,point5,point6, color));
        triangles.add(new Triangle(point1, point2, point6,color));
        triangles.add(new Triangle(point3, point4, point7, color));
        triangles.add(new Triangle(point4, point8,point7,color));
        triangles.add(new Triangle(point2, point4,point6,color));
        triangles.add(new Triangle(point6, point8, point4, color));
        triangles.add(new Triangle(point5, point6,point7, color));
        triangles.add(new Triangle(point6, point7, point8, color));

        return triangles;
    }
    public static ArrayList<Triangle> addTree(Point3D pos ,double sizeMultiplier) {
        ArrayList<Triangle> tree = new ArrayList<Triangle>();
        Color leaves = new Color(58, 95, 11);
        Color trunk = new Color (114, 95, 75 );
        tree.addAll(addCube(pos, 100,50,100,leaves));
        return tree;
    }

}
