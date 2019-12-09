
package com.example.MandelbrotSet.service;

import org.springframework.stereotype.Service;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

@Service
public class MandelbrotSet extends JComponent {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    public static final int ITERATIONS = 100;
    public static float SCALE_x = 0;
    public static float SCALE_y = 0;

    private BufferedImage buffer;


    public MandelbrotSet() {

        buffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);

    }

    @Override
    public void addNotify() {
        //set canvas dimension
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    //create image from default input
    public BufferedImage renderMandelbrotSet() {

        calculateScale_x(-1, 2);
        calculateScale_y(-1, 2);
        return getBufferedImage();

    }

    //create image from input
    public BufferedImage renderMandelbrotSetFromInput(int min_x, int max_x, int min_y, int max_y) {

        calculateScale_x(min_x, max_x);
        calculateScale_y(min_y, max_y);
        return getBufferedImage();

    }

    //calculate buffered image
    private BufferedImage getBufferedImage() {
        for(int x = 0; x < WIDTH;x++)
            for(int y = 0;y < HEIGHT;y++){
                int color = calculatePoint((x - WIDTH/2)/SCALE_x, (y - HEIGHT/2)/SCALE_y);

                buffer.setRGB(x, y, color);
            }
        return buffer;
    }

    //Calculate scale for X-axis
    public int calculateScale_x(int min_x, int max_x){

        SCALE_x = WIDTH/(max_x - min_x);
        return (int) SCALE_x;
    }

    //Calculate scale for Y-axis
    public int calculateScale_y(int min_y, int max_y){

        SCALE_y = HEIGHT/(max_y - min_y);
        return (int) SCALE_y;
    }

    //Calculate x,y point re=x, im=y
    public int calculatePoint(float re , float im) {

        float cRe = re;
        float cIm = im;

        int i = 0;

        for(;i< ITERATIONS;i++){

            float nRe = re*re - im*im + cRe;
            float nIm = 2 * re * im + cIm;
            re = nRe;
            im = nIm;

            if(re*re + im*im > 4) break;
        }

        if(i == ITERATIONS)return 0x0000000;
        return Color.HSBtoRGB(((float)i / ITERATIONS ), 0.5f, 1);


    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(buffer, 0,0, null);
    }




}



