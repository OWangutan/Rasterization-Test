public final class Rotate {



        public static int calculateX(Point3D p,double A,double B,double C) {
            double i = p.getx();
            double j = p.gety();
            double k = p.getz();
            return (int)(j * Math.sin(A) * Math.sin(B) * Math.cos(C) - k * Math.cos(A) * Math.sin(B) *
                         Math.cos(C) + j * Math.cos(A) * Math.sin(C) + k  * Math.sin(A) * Math.sin(C) +
                         i * Math.cos(B) * Math.cos(C));
        }
    public static int calculateY(Point3D p,double A,double B,double C) {
        double i = p.getx();
        double j = p.gety();
        double k = p.getz();
        return (int)(j * Math.cos(A) * Math.cos(C) + k * Math.sin(A) * Math.cos(C) - j * Math.sin(A) *
                     Math.sin(B) * Math.sin(C) + k * Math.cos(A) * Math.sin(B) * Math.sin(C) - i *
                     Math.cos(B) * Math.sin(C));
    }
    public static int calculateZ(Point3D p,double A,double B,double C) {
        double i = p.getx();
        double j = p.gety();
        double k = p.getz();
        return (int)(k * Math.cos(A) * Math.cos(B) - j * Math.sin(A) * Math.cos(B) + i * Math.sin(B));
    }
//    float calculateX(int i, int j, int k) {
//        return j * sin(A) * sin(B) * cos(C) - k * cos(A) * sin(B) * cos(C) +
//                j * cos(A) * sin(C) + k * sin(A) * sin(C) + i * cos(B) * cos(C);
//    }
//
//    float calculateY(int i, int j, int k) {
//        return j * cos(A) * cos(C) + k * sin(A) * cos(C) -
//                j * sin(A) * sin(B) * sin(C) + k * cos(A) * sin(B) * sin(C) -
//                i * cos(B) * sin(C);
//    }
//
//    float calculateZ(int i, int j, int k) {
//        return k * cos(A) * cos(B) - j * sin(A) * cos(B) + i * sin(B);
//    }

        }