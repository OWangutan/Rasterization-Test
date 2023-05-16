public class Rotate {
    public static Point3D rotatePoints(Point3D point, double A, double B, double C) {
        return new Point3D(calculateX(point, A, B, C),calculateY(point, A, B, C),calculateZ(point, A, B, C));
    }
    private static double calculateX(Point3D p,double A,double B,double C) {
        double i = p.getx();
        double j = p.gety();
        double k = p.getz();
        return (j * Math.sin(A) * Math.sin(B) * Math.cos(C) - k * Math.cos(A) * Math.sin(B) *
                Math.cos(C) + j * Math.cos(A) * Math.sin(C) + k  * Math.sin(A) * Math.sin(C) +
                i * Math.cos(B) * Math.cos(C));
    }
    private static double calculateY(Point3D p,double A,double B,double C) {
        double i = p.getx();
        double j = p.gety();
        double k = p.getz();
        return (j * Math.cos(A) * Math.cos(C) + k * Math.sin(A) * Math.cos(C) - j * Math.sin(A) *
                Math.sin(B) * Math.sin(C) + k * Math.cos(A) * Math.sin(B) * Math.sin(C) - i *
                Math.cos(B) * Math.sin(C));
    }
    private static double calculateZ(Point3D p,double A,double B,double C) {
        double i = p.getx();
        double j = p.gety();
        double k = p.getz();
        return (k * Math.cos(A) * Math.cos(B) - j * Math.sin(A) * Math.cos(B) + i * Math.sin(B));
    }
}
