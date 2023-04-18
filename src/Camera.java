import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Camera extends JPanel{
  private Point3D position;
  private ArrayList<Object3D> scene;
  private Point3D focus;

  public Camera (Point3D position, ArrayList<Object3D> scene) {
    this.position = position;
    this.scene = scene;
    updateFov(70);
  }
  public void updateFov(double fov){
    double focusDistance = getWidth()/2 * Math.sin(Math.toRadians(90 - fov/2))/Math.sin(Math.toRadians(fov/2));
    focus = new Point3D(position.getx(), position.gety(), position.getz() - focusDistance);
  }
  protected void paintComponent(Graphics g){
    super.paintComponent(g);

    for(int i = 0; i < scene.size(); i++){
      g.fillPolygon(scene.get(i).render(focus));
    }

    try {
        Thread.sleep(1000);
    } catch(Exception e) {
        System.out.println(e);
    }
      repaint();
  }
}


/* notes
    weighted average: R(t) = (1-t)C + tP

    I = R(t)

    line Equation: Δyx - Δxy + bΔx = 0 == ax +by + c = 0

    panel Equation: ax + by +cz + d = 0
 */