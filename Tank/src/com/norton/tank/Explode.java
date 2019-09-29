package com.norton.tank;

import java.awt.*;

public class Explode {
    private int x,y;

    private boolean living=true;
    private TankFrame frame;
    public static int WIDTH=ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT=ResourceMgr.explodes[0].getHeight();

    private int step=0;
   

	public Explode(int x, int y, TankFrame frame ) {
        this.x = x;
        this.y = y;
        this.frame=frame;
        
        new Audio("audio/explode.wav").play();
    }

    

    public void paint(Graphics g) {
       g.drawImage(ResourceMgr.explodes[step++], x,y, null);
       
       if(step>=ResourceMgr.explodes.length) step=0;
    }

}
