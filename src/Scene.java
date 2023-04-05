import java.util.ArrayList;

public class Scene {
    import java.util.*;

    public class Scene{
        ArrayList<Object3D> objects;

        public Scene(){
            objects = new ArrayList<Object3D>();
        }
        public void add(Object3D object){
            objects.add(object);
        }
        public void remove(Object3D object){
            objects.remove(object);
        }
        public ArrayList<Object3D> get(){
            return objects;
        }

    }

}
