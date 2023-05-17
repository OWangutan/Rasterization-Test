
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;




public class Camera extends JPanel{
  private Point3D position;
  private ArrayList<Triangle> scene = new ArrayList<Triangle>();
  private ArrayList<Triangle> renderList = new ArrayList<Triangle>();
  private Point3D focus;


  public Camera (Point3D position, ArrayList<Triangle> scene) {
    this.position = position;
    setFov(70);
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
        if (e.getKeyCode() == KeyEvent.VK_E) {
          position.sety(position.gety() - 10);
          setup(scene);
        }
        if (e.getKeyCode() == KeyEvent.VK_Q) {
          position.sety(position.gety() + 10);
          setup(scene);
        }
        //just needs correct math for rotation
        if (e.getKeyCode() == KeyEvent.VK_UP) {
          for (int i = 0; i < scene.size();i++) {
            scene.get(i).setPoint1(Rotate.rotatePoints(scene.get(i).getPointA(),.1,0,0));
            scene.get(i).setPoint2(Rotate.rotatePoints(scene.get(i).getPointB(),.1,0,0));
            scene.get(i).setPoint3(Rotate.rotatePoints(scene.get(i).getPointC(),.1,0,0));
          }
          setup(scene);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
          for (int i = 0; i < scene.size();i++) {
            scene.get(i).setPoint1(Rotate.rotatePoints(scene.get(i).getPointA(),-.1,0,0));
            scene.get(i).setPoint2(Rotate.rotatePoints(scene.get(i).getPointB(),-.1,0,0));
            scene.get(i).setPoint3(Rotate.rotatePoints(scene.get(i).getPointC(),-.1,0,0));
          }
          setup(scene);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
          for (int i = 0; i < scene.size();i++) {
            scene.get(i).setPoint1(Rotate.rotatePoints(scene.get(i).getPointA(),0,-.1,0));
            scene.get(i).setPoint2(Rotate.rotatePoints(scene.get(i).getPointB(),0,-.1,0));
            scene.get(i).setPoint3(Rotate.rotatePoints(scene.get(i).getPointC(),0,-.1,0));
          }
          setup(scene);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
          for (int i = 0; i < scene.size();i++) {
            scene.get(i).setPoint1(Rotate.rotatePoints(scene.get(i).getPointA(),0,.1,0));
            scene.get(i).setPoint2(Rotate.rotatePoints(scene.get(i).getPointB(),0,.1,0));
            scene.get(i).setPoint3(Rotate.rotatePoints(scene.get(i).getPointC(),0,.1,0));
          }
          setup(scene);
        }
      }
      @Override
      public void keyReleased(KeyEvent e) {
      }
    });


    setup(scene);


  }
  public void setFov(double fov){
    double focusDistance = getWidth()/2 * Math.sin(Math.toRadians(90 - fov/2))/Math.sin(Math.toRadians(fov/2));
    focus = new Point3D(0, 0, -focusDistance);
  }
  private void setup(ArrayList<Triangle> scene){
    renderList.clear();
    setFov(70);


    for (int i = 0; i < scene.size(); i++){
      renderList.add(scene.get(i).shift(position));
    }
    //sorting renderList
    int n = renderList.size();
    for (int i = 1; i < n; ++i) {
      Triangle key = renderList.get(i);
      int j = i - 1;
      while (j >= 0 && renderList.get(j).getCenter().getDistance(focus) > key.getCenter().getDistance(focus)) {
        renderList.set(j + 1, renderList.get(j));
        j = j - 1;
      }
      renderList.set(j + 1, key);
    }


    for (int i = 0; i < renderList.size();i++){
      System.out.println(renderList.get(i));
      System.out.println(renderList.get(i).getCenter());


    }
    //System.out.println(focus);
  }
  protected void paintComponent(Graphics g){
    super.paintComponent(g);


    g.setColor(new Color(200,200,255));
    g.fillRect(0,0,getWidth(),getHeight());
    for(int i = renderList.size()-1; i >= 0; i--){
      //System.out.println(renderList.get(i));
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

