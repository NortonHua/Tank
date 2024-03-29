package com.norton.tank;

import java.awt.*;
import java.util.Random;

public class Tank {

    private int x,y;
    private Dir dir=Dir.DOWN;
    private static final int SPEED=1;
    private boolean moving=true;
    private TankFrame frame;
    public static int WIDTH=ImageMar.tankD.getWidth();
    public static int HEIGHT=ImageMar.tankD.getHeight();
    private boolean living=true;
    private Random random=new Random();
    private Group group=Group.BAD;


    public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

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

    public Tank(int x, int y, Dir dir,Group group,TankFrame frame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group=group;
        this.frame=frame;
    }

    public void paint(Graphics g) {
        if(!living){
        	frame.tanks.remove(this);
        }
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
            if(random.nextInt(10)>8) this.fire();

    }

    public void fire() {
        int bx=this.x+Tank.WIDTH/2-Bullet.WIDTH/2;
        int by=this.y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
       frame.bullets.add(new Bullet(bx,by,this.dir,this.group,frame ));
    }

	public void die() {
		// TODO Auto-generated method stub
		this.living=false;
	}
}
