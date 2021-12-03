package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.CrashImpl;
import model.CrashInterface;
import model.Enemy;
import model.Bullet;

public class GamePanel extends JPanel implements MouseMotionListener, MouseListener {
    /**
     *
     */
    int bx, by, x, y, dx, dy; //background location bx,by; my plane location x,y; enemy dx,dy;
    int score = 0, count=0, state; //score,count,game state
    Image bg; //background image
    boolean db = false; //boom switch
    List<Bullet> bullet = new ArrayList<Bullet>(); //store bullet
    List<Enemy> enemy = new ArrayList<Enemy>(); //store enemy
    String bg1 = "src/images/background_1.png";
    String bg2 = "src/images/background_2.png";
    String bgStart = "src/images/start.png";
    String bgOver = "src/images/over.png";
    String bgPause = "src/images/pause.png";
    int width = 400, height = 650;
    String myPlane = "src/images/myPlane.png";
    String boo = "src/images/boom.png";
    String e1 = "src/images/e1.png";
    String e2 = "src/images/e2.png";
    String e3 = "src/images/e3.png";
    String e4 = "src/images/e4.png";

    //game state set
    public static final int START=1;
    public static final int RUNNING=2;
    public static final int PAUSE=3;
    public static final int OVER=4;

    //constructor
    public GamePanel() {
        state=START;
        bx = 0;
        by = 0;
        bg = new ImageIcon(bg1).getImage();

    }

    //paint method
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(state==RUNNING){
            String sc = "SCORE:" + String.valueOf(score);
            g.drawImage(bg, bx, by, width, height,null); //draw background
            g.setFont(new Font("TimesRoman", Font.BOLD, 16));
            g.setColor(Color.RED);
            g.drawString(sc, 2, 20); //draw the score

            Image hero = new ImageIcon(myPlane).getImage();
            g.drawImage(hero, x - 25, y - 60, null);  //draw my plane at upper of mouse location

            if (db) { //draw boom image
                Image boom = new ImageIcon(boo).getImage();
                g.drawImage(boom, dx, dy, null);
                db = false;
            }

            for (int i = 0; i < bullet.size(); i++) {
                bullet.get(i).drawBu(g);  //draw all bullets

            }

            for (int j = 0; j < enemy.size(); j++) {
                enemy.get(j).drawPlane(g); //draw all enemys

            }
        }else if(state==START){ //start image
            Image start=new ImageIcon(bgStart).getImage();
            g.drawImage(start, 0, 0, width, height, null);
        }else if(state==OVER){ //over image
            Image over=new ImageIcon(bgOver).getImage();
            g.drawImage(over, 0, 0, width, height, null);
        }else if(state==PAUSE){ //pause image
            Image pause=new ImageIcon(bgPause).getImage();
            g.drawImage(pause, 0, 0, width, height, null);
        }

    }

    // move
    public void Move() {
        new Thread() {
            @Override
            public void run() {
                super.run();

                while (true) {
                    if(state==RUNNING){

                        // set background not moving
                        count++;
                        by += 1;
                        if (by > 0) {
                            by = 0;
                            bg = new ImageIcon(bg2).getImage();
                        }

                        // create bullets
                        if (count % 3 == 0) {
                            bullet.add(new Bullet(x, y));
                        }
                        for (int a = 0; a < bullet.size(); a++) {
                            bullet.get(a).setY(bullet.get(a).getY() - 30); //bullet moving forward
                            if (bullet.get(a).getY() < 0) { //if bullet over panel
                                bullet.remove(a);

                            }
                        }

                        // create enemy
                        if (count % 21 == 0) {
                            enemy.add(new Enemy(e1));
                        }else if (count % 31 == 0) {
                            enemy.add(new Enemy(e2));
                        }else if (count % 41 == 0) {
                            enemy.add(new Enemy(e3));
                        }else if (count % 51 == 0) {
                            enemy.add(new Enemy(e4));
                        }
                        for (int b = 0; b < enemy.size(); b++) {
                            enemy.get(b).setY(enemy.get(b).getY() + 3); //enemy moving forward
                            if (enemy.get(b).getY() > height) { //if enemy over panel
                                //state=OVER; //game over, ok to remove this one now
                            }

                        }

                        // bullet and enemy crashImpl
                        CrashInterface crashInterface = new CrashImpl();
                        for (int j = 0; j < bullet.size(); j++) {
                            Bullet z = bullet.get(j);
                            for (int i = 0; i < enemy.size(); i++) {
                                Enemy d = enemy.get(i);
                                if (crashInterface.Boom(z, d)) { //crashImpl boom check
                                    score += 1; //score add 1
                                    dx = enemy.get(i).getX(); //enemy location
                                    dy = enemy.get(i).getY();
                                    db = true; //enemy boom
                                    enemy.remove(i); //remove enemy
                                    bullet.remove(j); //remove bullet
                                    break;
                                }
                            }
                        }

                        //plane crashImpl
                        for (int i = 0; i < enemy.size(); i++) {
                            Enemy d = enemy.get(i);
                            if (crashInterface.Boom2(d, x, y)) {
                                dx = enemy.get(i).getX();
                                dy = enemy.get(i).getY();
                                db = true;
                                state=OVER; //game over
                            }
                        }
                    }


                    repaint(); //repaint
                    try {
                        Thread.sleep(20); //sleep pause
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    //mouse click event
    @Override
    public void mouseClicked(MouseEvent e) {
        if(state==START||state==PAUSE){
            state=RUNNING;
        }else if (state==RUNNING){
            state=PAUSE;;
        }else if(state==OVER){

            //restart
            state=RUNNING;
            score=0;
            count=0;
            bx = 0;
            bg = new ImageIcon(bg1).getImage();
            by = 0;
            bullet = new ArrayList<Bullet>();
            enemy = new ArrayList<Enemy>();

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();

    }

}
