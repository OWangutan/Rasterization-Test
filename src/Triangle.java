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

