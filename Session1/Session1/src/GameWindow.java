import models.Bullet;
import models.Enemy;
import models.Plane;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

/**
 * Created by PhamTuyen on 7/24/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Image background;
    Image plane1Image;
    Image plane2Image;
    Image bulletImage;
    Image enemyImage;
    Plane plane1;
    Plane plane2;
    Vector<Bullet> bulletVector;
    Vector<Enemy> enemyVector;
    BufferedImage bufferedImage;
    Graphics bufferedImageGraphic;
    int plane2Width;
    int plane2Height;
    int plane1Width;
    int plane1Height;
    Bullet bullet;


    public GameWindow() {
        System.out.println("Game Window constructor");
        this.setVisible(true);
        this.setSize(800, 600);
        //this.setLocation(0,0);
        plane1 = new Plane(250, 650);
        plane2 = new Plane(300, 600);
        bulletVector = new Vector<Bullet>();
        enemyVector = new Vector<Enemy>();

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
                System.out.println("windowDeiconified");
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
            plane1Image = ImageIO.read(new File("resources/plane3.png"));
            plane2Image = ImageIO.read(new File("resources/plane4.png"));
            bulletImage = ImageIO.read(new File("resources/bullet.png"));
            enemyImage = ImageIO.read(new File("resources/enemy_plane_white_3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_SPACE:
                        Bullet bullet = new Bullet();
                        bullet.moveTo(plane1.x , plane1.y);
                        bulletVector.add(bullet);
                        break;
                    case KeyEvent.VK_LEFT:
                        plane1.x -= 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        plane1.x += 10;
                        break;
                    case KeyEvent.VK_UP:
                        plane1.y -= 10;
                        break;
                    case KeyEvent.VK_DOWN:
                        plane1.y += 10;
                }
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
            public void mouseMoved(MouseEvent mouseEvent) {
                plane2.moveTo(mouseEvent.getX() - plane2Image.getWidth(null) / 2, mouseEvent.getY() - plane2Image.getHeight(null) / 2);
            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Bullet bullet = new Bullet();
                bullet.moveTo(plane2.x, plane2.y);
                bulletVector.add(bullet);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.bufferedImage = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        this.bufferedImageGraphic = bufferedImage.getGraphics();
        Thread thread = new Thread(this);
        thread.start();

    }

    @Override
    public void update(Graphics g) {

        bufferedImageGraphic.drawImage(background, 0, 0, null);
        bufferedImageGraphic.drawImage(plane1Image, plane1.x, plane1.y, null);
        bufferedImageGraphic.drawImage(plane2Image, plane2.x, plane2.y, null);
        for (Bullet bullet : bulletVector) {
            bufferedImageGraphic.drawImage(bulletImage, bullet.x, bullet.y, null);

         }
       for (int i = 0; i < enemyVector.size(); i++) {
        Enemy enemy = enemyVector.get(i);
           bufferedImageGraphic.drawImage(enemyImage, enemyVector.get(i).x, enemyVector.get(i).y, null);
     }
        g.drawImage(bufferedImage, 0, 0, null);

    }

    @Override
       public void run() {
        while (true) {
            try {

                    Enemy enemy = new Enemy();
                 enemy.moveEnemy(enemy.x, enemy.y);
                  Thread.sleep(50);
                    enemyVector.add(enemy);


                    Iterator<Enemy> enemyIterator = enemyVector.iterator();
                    Iterator<Bullet> bulletIterator = bulletIterator.iterator();

                while( enemyIterator.hasNext()) {
//               Enemy enemy = enemyIterator.next(); // trùng biến enemy có rồi, ko được khai báo lại "is already defined"
                    enemy = enemyIterator.next();
                    enemy.y += 10;
                    if (enemy.y > 650) {
                        enemyIterator.remove();
                    }
                    Rectangle enemyRectangle = new Rectangle(enemy.x, enemy.y, enemyImage.getWidth(null), enemyImage.getHeight(null));

                    while (bulletIterator.hasNext()) {
                        Bullet bullet = bulletIterator.next();
                        Rectangle bulletRectangle = new Rectangle(bullet.x, bullet.y, bulletImage.getWidth(null), bulletImage.getHeight(null));
                        if (enemyRectangle.intersects(bulletRectangle)) {
                            enemyIterator.remove();
                            bulletIterator.remove();
                            break;
                        }
                    }
                }
           //     Iterator<Bullet> bulletIterator = bulletVector.iterator();
                while (bulletIterator.hasNext()) {
                    Bullet bullet = bulletIterator.next();
                    bullet.y -= 10;
                    if (bullet.y <= 0) {
                        bulletIterator.remove();
                    }
                }
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
// delete mouse: java avt mouse visible.