import javax.swing.*;
import java.awt.*;
public class Triangle extends Object3D{
        private Point3D pointA;
        private Point3D pointB;
        private Point3D pointC;
        public Triangle(Point3D pointA, Point3D pointB, Point3D pointC){
            this.pointA = pointA;
            this.pointB = pointB;
            this.pointC = pointC;
        }


        public Polygon render(Point3D focus){
            Point3D[] pPoints = {pointA, pointB, pointC};
            int[] xpoints = new int[3];
            int[] ypoints = new int[3];
            for(int i = 0; i < 3; i++){
                Vector3D vector = Vector3D.newVector(focus,pPoints[i]);
                double t = (-focus.getz())/vector.getz();

            }
            return new Polygon(xpoints, ypoints, 3);
        }



        public Point3D getPointA() {
            return pointA;
        }

        public Point3D getPointB() {
            return pointB;
        }

        public Point3D getPointC() {
            return pointC;
        }

        public void setPoint1(Point3D pointA) {
            this.pointA = pointA;
        }

        public void setPoint2(Point3D pointB) {
            this.pointB = pointB;
        }

        public void setPoint3(Point3D pointC) {
            this.pointC = pointC;
        }

        public String toString(){
            return "Points: " + pointA + "," + pointB + "," + pointC;
        }

    }

