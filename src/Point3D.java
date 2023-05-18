public class Point3D{
    private double x;
    private double y;
    private double z;
    public Point3D(double x ,double y,double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Point3D(Point3D point3D){
        this.x = point3D.x;
        this.y = point3D.y;
        this.z = point3D.z;
    }
    public void setPosition(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double[] getXYZ() {
        double[] pos = {x,y,z};
        return pos;
    }
    public double getx(){
        return x;
    }
    public double getDistance(Point3D point){
        double distance = Math.sqrt(Math.pow(x - point.getx(),2)+ Math.pow(y - point.gety(),2)+ Math.pow(z - point.getz(),2));
        return distance;
    }
    public double gety(){
        return y;
    }
    public double getz(){
        return z;
    }
    public void setx(double x){
        this.x = x;
    }
    public void sety(double y){
        this.y = y;
    }
    public void setz(double z){
        this.z = z;
    }
    public static Point3D translate(Point3D point1, Point3D point2){
        return new Point3D(point1.x - point2.x, point1.y - point2.y, point1.z - point2.z);
    }
    public static Point3D unTranslate(Point3D point1, Point3D point2){
        return new Point3D(point1.x + point2.x, point1.y + point2.y, point1.z + point2.z);
    }
    public String toString(){
        return "("+x+","+y+","+z+")";
    }
}
