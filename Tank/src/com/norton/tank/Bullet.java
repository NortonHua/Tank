package com.norton.tank;

import java.awt.*;

public class Bullet {
    private static final int SPEED=10;
    private int x,y;
    private Dir dir;
    private boolean live=true;
    private TankFrame frame;
    public static int WIDTH=ImageMar.bulletD.getWidth();
    public static int HEIGHT=ImageMar.bulletD.getHeight();

    public Bullet(int x, int y, Dir dir,TankFrame frame ) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.frame=frame;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        if(!live){
            frame.bullets.remove(this);
        }
        switch (dir){
            case UP:
                g.drawImage(ImageMar.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ImageMar.bulletD,x,y,null);
                break;
            case LEFT:
                g.drawImage(ImageMar.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ImageMar.bulletR,x,y,null);
                break;
        }
        move();
    }

    private void move() {
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
        if(x<0||y<0||x>TankFrame.GAMW_WIDTH||y>TankFrame.GAME_HEIGHT){
            live=false;
        }
    }

}
