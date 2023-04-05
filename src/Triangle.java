public class Triangle {
    public class Triangle extends Object3D{
        private Point3D pointA;
        private Point3D pointB;
        private Point3D pointC;

        // Plane equation: ax + by + cz + d = 0
        //R(t) = (1-t)C + tP
        private double a;
        private double b;
        private double c;
        private double d;
        public Triangle(Point3D pointA, Point3D pointB, Point3D pointC){
            this.pointA = pointA;
            this.pointB = pointB;
            this.pointC = pointC;
            updateEquation();
        }

        public boolean hit(Ray ray){

        }

        private void updateEquation(){
            Vector3D vectorAB = new Vector3D(pointB.getx() - pointA.getx(),pointB.gety() - pointA.gety(),pointB.getz() - pointA.getz());
            Vector3D vectorBC = new Vector3D(pointC.getx() - pointA.getx(),pointC.gety() - pointA.gety(),pointC.getz() - pointA.getz());
            Vector3D normal = new Vector3D(vectorAB.crossProduct(vectorBC));
            a = normal.getx();
            b = normal.gety();
            c = normal.getz();
            d = (a  * -pointA.getx()) + (b  * -pointA.gety()) + (c * -pointA.getz());
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
            updateEquation();
        }

        public void setPoint2(Point3D pointB) {
            this.pointB = pointB;
            updateEquation();
        }

        public void setPoint3(Point3D pointC) {
            this.pointC = pointC;
            updateEquation();
        }

        public String toString(){
            return "Points: " + pointA + "," + pointB + "," + pointC + "\nequation: " + a + "x+" + b + "y+" + c + "z+" + d + " = 0";
        }

    }
}
