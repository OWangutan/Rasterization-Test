import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Camera extends JPanel{
  private Point3D position;
  private ArrayList<Object3D> scene = new ArrayList<Object3D>();
  private Point3D focus;

  public Camera (Point3D position, ArrayList<Object3D> scene) {
    this.position = position;
    updateFov(70);
    setup(scene);
  }
  private void updateFov(double fov){
    double focusDistance = getWidth()/2 * Math.sin(Math.toRadians(90 - fov/2))/Math.sin(Math.toRadians(fov/2));
    focus = new Point3D(position.getx(), position.gety(), position.getz() - focusDistance);
  }
  private void setup(ArrayList<Object3D> scene){
    for (int i = 0; i < scene.size(); i++){
      this.scene.add(scene.get(i).shift(position));
    }
  }
  protected void paintComponent(Graphics g){
    super.paintComponent(g);
    for(int i = 0; i < scene.size(); i++){

      g.fillPolygon(scene.get(i).//translate(getWidth()/2,getHeight()/2));
    }

    try {
        Thread.sleep(1000);
    } catch(Exception e) {
        System.out.println(e);
    }
      repaint();
  }
}


