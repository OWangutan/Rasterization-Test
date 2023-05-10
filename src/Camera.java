import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Camera extends JPanel{
  private Point3D position;
  private ArrayList<Object3D> scene = new ArrayList<Object3D>();
  private Point3D focus;

  public Camera (Point3D position, ArrayList<Object3D> scene) {
    this.position = position;
    setFocusable(true);
    addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {

      }

      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
          position.sety(position.gety()+10);
          setup(scene);
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {

        }
        if (e.getKeyCode() == KeyEvent.VK_S) {

        }
        if (e.getKeyCode() == KeyEvent.VK_D) {

        }
      }
      @Override
      public void keyReleased(KeyEvent e) {
      }
    });
    setBackground(new Color(255,255,200));
    setup(scene);
  }







  public void setFov(double fov){
    double focusDistance = getWidth()/2 * Math.sin(Math.toRadians(90 - fov/2))/Math.sin(Math.toRadians(fov/2));
    System.out.println(focusDistance);
    focus = new Point3D(position.getx(), position.gety(), position.getz() - focusDistance);
  }
  private void setup(ArrayList<Object3D> scene){
    for (int i = 0; i < scene.size(); i++){
      this.scene.add(scene.get(i).shift(position));
    }
  }
  protected void paintComponent(Graphics g){
    super.paintComponent(g);
    g.fillRect(0,0,getWidth(),getHeight());
    for(int i = 0; i < scene.size(); i++){
      Polygon triangle = scene.get(i).render(focus);
      triangle.translate(getWidth()/2,getHeight()/2);
      g.fillPolygon(triangle);
    }
    try {
        Thread.sleep(100);
    } catch(Exception e) {
        System.out.println(e);
    }
      repaint();
  }
}


