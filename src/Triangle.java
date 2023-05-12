import javax.swing.*;
import java.awt.*;
public class Triangle{
        private Point3D pointA;
        private Point3D pointB;
        private Point3D pointC;
        private Color color;
        public Triangle(Point3D pointA, Point3D pointB, Point3D pointC, Color color){
            this.pointA = pointA;
            this.pointB = pointB;
            this.pointC = pointC;
            this.color = color;
        }
        public Point3D getCenter(){
            return new Point3D((pointA.getx() + pointB.getx() + pointC.getx())/3,
                    (pointA.gety() + pointB.gety() + pointC.gety())/3,
                    (pointA.getx() + pointB.getx() + pointC.getx())/3);
        }

        public Polygon render(Point3D focus){
            Point3D[] pPoints = {pointA, pointB, pointC};
            int[] xpoints = new int[3];
            int[] ypoints = new int[3];
            for(int i = 0; i < 3; i++){
                Vector3D vector = Vector3D.newVector(focus,pPoints[i]);
                double t = (-focus.getz())/vector.getz();
                xpoints[i] = (int)(focus.getx()+ vector.getx()*t);
                ypoints[i] = (int)(focus.gety()+ vector.gety()*t);
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
        public Color getColor(){
            return color;
        }
        public Triangle shift(Point3D position){
          return new Triangle(Point3D.translate(pointA,position),Point3D.translate(pointB,position),Point3D.translate(pointC,position),color);
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

