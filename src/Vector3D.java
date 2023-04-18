
public class Vector3D{
    private double x;
    private double y;
    private double z;
    public Vector3D(double x ,double y,double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Vector3D(Vector3D vector3D){
        this.x = vector3D.x;
        this.y = vector3D.y;
        this.z = vector3D.z;
    }
    public static Vector3D newVector(Point3D p,Point3D q){
        return new Vector3D( p.getx()- q.getx(),p.gety()- q.gety(),p.getz()- q.getz())
;    }
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
    public String toString(){
        return "("+x+","+y+","+z+")";
    }
}

