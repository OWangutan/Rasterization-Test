import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Camera extends JPanel{
    protected void paintComponent(Graphics g){
        super.paintComponent(g);




        try {
            Thread.sleep(1000);
        } catch(Exception e) {
            System.out.println(e);
        }
        //repaint();
    }
}


/* notes
    weighted average: R(t) = (1-t)C + tP

    I = R(t)

    line Equation: Δyx - Δxy + bΔx = 0 == ax +by + c = 0

    panel Equation: ax + by +cz + d = 0
 */