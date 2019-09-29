package com.norton.tank;

import com.norton.tank.ResourceMgr;

import java.awt.*;

public class Tank {

    private int x,y;
    private Dir dir=Dir.DOWN;
    private static final int SPEED=5;
    private boolean moving=false;
    private TankFrame frame;
    public static int WIDTH=ImageMar.tankD.getWidth();
    public static int HEIGHT=ImageMar.tankD.getHeight();


    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Tank(int x, int y, Dir dir,TankFrame frame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.frame=frame;
    }

    public void paint(Graphics g) {
        Color c=g.getColor();
        switch (dir){
            case UP:
                g.drawImage(ImageMar.tankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ImageMar.tankD,x,y,null);
                break;
            case LEFT:
                g.drawImage(ImageMar.tankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ImageMar.tankR,x,y,null);
                break;
        }
        moving();
    }

    private void moving() {
          if(!moving) return;
            switch (dir) {
                case UP:
                    y -= SPEED;
                    break;
                case RIGHT:
                    x += SPEED;
                    break;
                case LEFT:
                    x -= SPEED;
                    break;
                case DOWN:
                    y += SPEED;
                    break;
            }

    }

    public void fire() {
        int bx=this.x+Tank.WIDTH/2-Bullet.WIDTH/2;
        int by=this.y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
       frame.bullets.add(new Bullet(bx,by,this.dir,frame ));
    }
}
