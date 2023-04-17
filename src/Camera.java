import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Camera extends JPanel{
  private Point3D position;
  private ArrayList<Object3D> scene;

  public Camera (Point3D position, ArrayList<Object3D> scene) {
    this.position = position;
    this.scene = scene;
  }
  protected void paintComponent(Graphics g){
    super.paintComponent(g);

    for(int i = 0; i < scene.size(); i++){
      g.fillPolygon(scene.get(i).render());
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