package com.norton.tank;

import com.norton.tank.ResourceMgr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageMar {
    public static BufferedImage tankL,tankU,tankD,tankR;
    public static BufferedImage bulletL,bulletU,bulletD,bulletR;

    static{
        try {
            tankL=ImageIO.read(ImageMar.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankR=ImageIO.read(ImageMar.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankD=ImageIO.read(ImageMar.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            tankU=ImageIO.read(ImageMar.class.getClassLoader().getResourceAsStream("images/tankU.gif"));

            bulletL=ImageIO.read(ImageMar.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletR=ImageIO.read(ImageMar.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletD=ImageIO.read(ImageMar.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            bulletU=ImageIO.read(ImageMar.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
