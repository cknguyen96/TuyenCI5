import sun.awt.image.BufferedImageGraphicsConfig;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by PhamTuyen on 7/24/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;
    Image planeimage;
    Image planeimage1;
    BufferedImage bufferedImage;
    Graphics bufferedImageGraphic;
    int planeX = 250;
    int planeY = 650;
    int planeX1 = 300;
    int planeY1 = 600;
    Thread thread;
    public GameWindow(){
        System.out.println("Game Window constructor");
        this.setVisible(true);
        this.setSize(800,600);
        this.setLocation(0,0);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);

            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");

            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified");

            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println( "windowDeiconified");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("windowActivated");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("windowDeactivated");
            }
        });

        try {
            background = ImageIO.read(new File("resources/background.png"));
        } catch (IOException e) {
            e.printStackTrace();

        }
        try {
            planeimage = ImageIO.read(new File("resources/plane3.png"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try{
            planeimage1 = ImageIO.read(new File("resources/plane4.png"));
        }catch (IOException e2){
            e2.printStackTrace();
        }
      //  this.repaint();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        planeX -= 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        planeX += 10;
                        break;
                    case KeyEvent.VK_UP:
                        planeY -= 10;
                        break;
                    case KeyEvent.VK_DOWN:
                        planeY += 10;
                        break;
                }
          //      repaint();
            }
           
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println(e.getPoint().x + "," + e.getPoint().y);
            }
        });
        this.bufferedImage = new BufferedImage(600,800,BufferedImage.TYPE_INT_ARGB);
        this.bufferedImageGraphic = bufferedImage.getGraphics();
        thread = new Thread (this);
        thread.start();

    }

    @Override
    public void update(Graphics g) {
        bufferedImageGraphic.drawImage(background,0,0,null);
        bufferedImageGraphic.drawImage(planeimage, planeX, planeY, null);
        bufferedImageGraphic.drawImage(planeimage1, planeX1, planeY1, null);
       g.drawImage(bufferedImage,0,0,null);

    }

    @Override
    public void run() {
        while(true){
            try {
                Point mouseInfo= MouseInfo.getPointerInfo().getLocation();
                mouseInfo.x -= getLocationOnScreen().x;
                mouseInfo.y -= getLocationOnScreen().y;
                planeX1 = mouseInfo.x;
                planeY1 = mouseInfo.y;
                Thread.sleep(27);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
// them may bay 2