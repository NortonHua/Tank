package com.norton.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    Tank tank=new Tank(200,500,Dir.DOWN,this);
    List<Bullet> bullets=new ArrayList<>();
    List<Tank>  tanks=new ArrayList<>();
    public static final int GAMW_WIDTH=800,GAME_HEIGHT=600;

    public TankFrame(){
        this.setTitle("坦克大战");
        this.setSize(GAMW_WIDTH,GAME_HEIGHT);
        this.setResizable(false);
        this.setVisible(true);
        this.addKeyListener(new MyKeyListener());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    Image offScreeImage=null;

    @Override
    public void update(Graphics g) {
        if(offScreeImage==null){
            offScreeImage=this.createImage(GAMW_WIDTH,GAME_HEIGHT);
        }
        Graphics gOffScreen=offScreeImage.getGraphics();
        Color c=gOffScreen.getColor();
        gOffScreen.setColor(Color.black);
        gOffScreen.fillRect(0,0,GAMW_WIDTH,GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreeImage,0,0,null);
    }

    @Override
    public void paint(Graphics g) {
        Color c=g.getColor();
        g.setColor(Color.white);
        g.drawString("子弹的数量："+bullets.size(),10,60);
        g.setColor(c);
        tank.paint(g);
        for (int i=0;i<bullets.size();i++){
            bullets.get(i).paint(g);
        }

        for (int i=0;i<tanks.size();i++){
            tanks.get(i).paint(g);
        }
    }

    class MyKeyListener extends KeyAdapter {
        boolean bL=false;
        boolean bR=false;
        boolean bU=false;
        boolean bD=false;
        @Override
        public void keyReleased(KeyEvent e) {
            int key=e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL=false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=false;
                    break;
                case KeyEvent.VK_UP:
                    bU=false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=false;
                    break;
                case KeyEvent.VK_CONTROL:
                    tank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key=e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL=true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=true;
                    break;
                case KeyEvent.VK_UP:
                    bU=true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=true;
                    break;

                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if(!bL && !bU && !bR && !bD) tank.setMoving(false);
            else {
                tank.setMoving(true);
                if (bL){
                    tank.setDir(Dir.LEFT);

                }
                if (bU){
                    tank.setDir(Dir.UP);

                }
                if (bR){
                    tank.setDir(Dir.RIGHT);

                }
                if (bD){
                    tank.setDir(Dir.DOWN);

                }
            }

        }
    }


}
