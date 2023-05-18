import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.io.IOException;




//sound imports
import java.io.File;
import javax.sound.sampled.*;




public class Main {


    public static void main(String[] args) {
        ArrayList<Triangle> scene = new ArrayList<Triangle>();
        //ground
        Point3D ground = new Point3D(0,0,0);
        Color[] groundColor = { new Color(86, 125,70),
                new Color(126,200,80)};
        int x = 0;


        for (int i = 0; i < 21; i++){
            for(int j = 0; j < 21; j++){
                scene.addAll(Shapes3D.addSquareX(new Point3D(ground.getx() + 250 * j,ground.gety(),ground.getz() + 250 * i),250,250,groundColor[x]));
                if(x == 0){
                    x = 1;
                } else {
                    x = 0;
                }
            }
        }
        //car
        scene.addAll(Shapes3D.addRaceCar1(new Point3D(0,-200,0)));




        int height = 720;
        int width = 1280;
        JFrame frame = new JFrame();
        frame.setSize(width,height);
        frame.setResizable(false);
        Camera camera = new Camera(new Point3D(0,-100,0),scene,1280,720);
        frame.add(camera);
        frame.setVisible(true);
        camera.setFov(70);


        String filePath = "Trance - 009 Sound System Dreamscape (HD).wav";
        Clip clip = playMusic(filePath);


        if (clip != null) {
            // Adjust the volume (0.0f to 1.0f)
            float volume = 0f; // 50% volume
            setVolume(clip, volume);
        }


    }
    public static Clip playMusic(String filePath) {
        try {
            // Create an AudioInputStream from the specified file path
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());


            // Get the Clip
            Clip clip = AudioSystem.getClip();


            // Open the AudioInputStream and start playing
            clip.open(audioInputStream);
            clip.start();


            // Return the Clip object
            return clip;


        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
        }


        // Return null if an error occurs
        return null;
    }
    public static void setVolume(Clip clip, float volume) {
        if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);


            // Convert linear volume value to decibels
            float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);


            gainControl.setValue(dB);
        }
    }
}
