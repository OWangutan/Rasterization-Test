public class Rotate {
    private int[][] point;
    //0 == 0. 1 == 1, 2 == sin, 3 == -sin, 4 == cos, 5 == -cos
    private static int[][] rotationMatrixX = new int[][] {{},
                                                          {},
                                                          {}};

    private static int[][] rotationMatrixY = new int[][] {{},
                                                          {},
                                                          {}};

    private static int[][] rotationMatrixZ = new int[][] {{},
                                                          {},
                                                          {}};;

    public Rotate() {

    }

    //returns x,y of new point (same Z as old point)
    public static Point3D rotatePoints(Point3D origin, Point3D point, double degrees) {

        //x and y of point being rotated
        double x = point.getx();
        double y = point.gety();

        //x and y of origin of rotation
        double xO = origin.getx();
        double yO = origin.gety();

        //new points
        double newX = (((x - xO) * Math.cos(Math.toRadians(degrees)) - (y-yO) * (Math.sin(Math.toRadians(degrees))+xO)));
        double newY = (((x - xO) * Math.sin(Math.toRadians(degrees)) + (y-yO) * (Math.cos(Math.toRadians(degrees))+yO)));

        //create new object for new point location
        return new Point3D(newX, newY, point.getz());
    }


}

//
//   x, ==   cos a  | -sin a   y
//   y, ==   sin a  | cos a  * x
//
