import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Camera extends JPanel{
  private Point3D position;
  private ArrayList<Triangle> scene = new ArrayList<Triangle>();
  private ArrayList<Triangle> renderList = new ArrayList<Triangle>();
  private Point3D focus;

  public Camera (Point3D position, ArrayList<Triangle> scene) {
    this.position = position;
    setFocusable(true);
    addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {

      }

      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
          position.setz(position.getz() + 10);
          setup(scene);
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
          position.setx(position.getx() - 10);
          setup(scene);
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
          position.setz(position.getz() - 10);
          setup(scene);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
          position.setx(position.getx() + 10);
          setup(scene);
        }
      }
      @Override
      public void keyReleased(KeyEvent e) {
      }
    });
    setup(scene);
  }public void setFov(double fov){
    double focusDistance = getWidth()/2 * Math.sin(Math.toRadians(90 - fov/2))/Math.sin(Math.toRadians(fov/2));
    System.out.println(focusDistance);
    focus = new Point3D(position.getx(), position.gety(), position.getz() - focusDistance);
  }
  private void setup(ArrayList<Triangle> scene){
    renderList.clear();
    for (int i = 0; i < scene.size(); i++){
      renderList.add(scene.get(i).shift(position));
    }

  }
  protected void paintComponent(Graphics g){
    super.paintComponent(g);
    //anti-aliasing
    Graphics2D g2 = (Graphics2D)g;
    RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    g2.setRenderingHints(rh);

    g.setColor(new Color(255,255,200));
    g.fillRect(0,0,getWidth(),getHeight());
    for(int i = 0; i < renderList.size(); i++){
      g.setColor(renderList.get(i).getColor());
      Polygon triangle = renderList.get(i).render(focus);
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