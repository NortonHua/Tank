package com.norton.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame frame=new TankFrame();

        //初始化敌方坦克
        for(int i=0;i<5;i++){
            frame.tanks.add(new Tank(50+i*80,200,Dir.DOWN,Group.BAD,frame));
        }
        while (true){
            Thread.sleep(50);
            frame.repaint();

        }

    }
}
