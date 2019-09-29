package com.norton.tank;

import java.awt.*;

public class Bullet {
    private static final int SPEED=10;
    private int x,y;
    private Dir dir;
    private boolean living=true;
    private TankFrame frame;
    public static int WIDTH=ImageMar.bulletD.getWidth();
    public static int HEIGHT=ImageMar.bulletD.getHeight();
    private Group group=Group.BAD;

    public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Bullet(int x, int y, Dir dir,Group group,TankFrame frame ) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group=group;
        this.frame=frame;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        if(!living){
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
            living=false;
        }
    }

	public void collideWith(Tank tank) {
		if(this.group==tank.getGroup()) return;
		//用一个rect来记录子弹的位置
		Rectangle rect1=new Rectangle(this.x,this.y,WIDTH,HEIGHT);
		Rectangle rect2=new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
		if(rect1.intersects(rect2)){
			tank.die();
			this.die();
		}
	}

	private void die() {
		// TODO Auto-generated method stub
		this.living=false;
	}

}
