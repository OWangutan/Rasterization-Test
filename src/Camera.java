import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;




public class Camera extends JPanel{
  int height;
  int width;
  private Point3D position;
  private ArrayList<Triangle> scene = new ArrayList<Triangle>();
  private ArrayList<Triangle> renderList = new ArrayList<Triangle>();
  private Point3D focus;
  private double focusDistance;
  private int groundY = 0;
  private int maxAngleUp = 16;
  private int maxAngleDown = -16;
  private int angle = 0;




  public Camera (Point3D position, ArrayList<Triangle> scene, int width, int height) {
    setBackground(new Color(      173, 216, 230));
    this.width = width;
    this.height = height;
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
          if (position.gety() < 0) {
            position.sety(position.gety() + 10);
            setup(scene);
          }
        }
        //just needs correct math for rotation
        if (e.getKeyCode() == KeyEvent.VK_UP) {
          if (angle < maxAngleUp) {
            groundY = groundY + 33;
            for (int i = scene.size()-1; i >= 0; i--) {
              Triangle triangle = scene.get(i).shift(new Point3D(position.getx(),position.gety(),position.getz() + focusDistance));
              triangle.setPoint1(Rotate.rotatePoints(triangle.getPointA(),.05,0,0));
              triangle.setPoint2(Rotate.rotatePoints(triangle.getPointB(),.05,0,0));
              triangle.setPoint3(Rotate.rotatePoints(triangle.getPointC(),.05,0,0));
              scene.set(i,triangle.unShift(new Point3D(position.getx(),position.gety(),position.getz() + focusDistance)));
            }
            setup(scene);
            angle++;
          }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
          if (angle > maxAngleDown) {
            groundY = groundY - 33;
            for (int i = scene.size()-1; i >= 0; i--) {
              Triangle triangle = scene.get(i).shift(new Point3D(position.getx(),position.gety(),position.getz() + focusDistance));
              triangle.setPoint1(Rotate.rotatePoints(triangle.getPointA(),-.05,0,0));
              triangle.setPoint2(Rotate.rotatePoints(triangle.getPointB(),-.05,0,0));
              triangle.setPoint3(Rotate.rotatePoints(triangle.getPointC(),-.05,0,0));
              scene.set(i,triangle.unShift(new Point3D(position.getx(),position.gety(),position.getz() + focusDistance)));
            }
            setup(scene);
            angle--;
          }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
          for (int i = scene.size()-1; i >= 0; i--) {
            Triangle triangle = scene.get(i).shift(new Point3D(position.getx(),position.gety(),position.getz() + focusDistance));
            triangle.setPoint1(Rotate.rotatePoints(triangle.getPointA(),0,-.05,0));
            triangle.setPoint2(Rotate.rotatePoints(triangle.getPointB(),0,-.05,0));
            triangle.setPoint3(Rotate.rotatePoints(triangle.getPointC(),0,-.05,0));
            scene.set(i,triangle.unShift(new Point3D(position.getx(),position.gety(),position.getz() + focusDistance)));
          }
          setup(scene);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
          for (int i = scene.size()-1; i >= 0; i--) {
            Triangle triangle = scene.get(i).shift(new Point3D(position.getx(),position.gety(),position.getz() + focusDistance));
            triangle.setPoint1(Rotate.rotatePoints(triangle.getPointA(),0,.05,0));
            triangle.setPoint2(Rotate.rotatePoints(triangle.getPointB(),0,.05,0));
            triangle.setPoint3(Rotate.rotatePoints(triangle.getPointC(),0,.05,0));
            scene.set(i,triangle.unShift(new Point3D(position.getx(),position.gety(),position.getz() + focusDistance)));
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
    focusDistance = -(width/2 * Math.sin(Math.toRadians(90 - fov/2))/Math.sin(Math.toRadians(fov/2))) ;
    focus = new Point3D(0, 0, focusDistance);
  }
  private void setup(ArrayList<Triangle> scene){
    renderList.clear();


    for (int i = 0; i < scene.size(); i++){
      Triangle triangle = scene.get(i).shift(position);
      if(triangle.getPointA().getz() > focusDistance && triangle.getPointB().getz() > focusDistance && triangle.getPointC().getz() > focusDistance) {


        renderList.add(triangle);
      }
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
  }
  private void followCar(Point3D car){
    position = car;
  }
  protected void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;


    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
    g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
    g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_OFF);


    for(int i = renderList.size()-1; i >= 0; i--){
      g2d.setColor(renderList.get(i).getColor());
      Polygon triangle = renderList.get(i).render(focus);
      triangle.translate(width/2,height/2);
      g2d.fillPolygon(triangle);


    }
    try {
      Thread.sleep(10);
    } catch(Exception e) {
      System.out.println(e);
    }
    repaint();
  }
}
