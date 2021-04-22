/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.desafio.syngeta;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author thales
 */
public class CarregaImagem {
    // Lendo de um input stream

    public static void main(String[] args) {
        System.out.println("dsas");
        new CarregaImagem().carregar();

    }

    public void carregar() {

        try {

            BufferedImage imagem = ImageIO.read(new File("imagem.bmp"));

            int w = imagem.getWidth();
            int h = imagem.getHeight();
            int[] pixels = imagem.getRGB(0, 0, w, h, null, 0, w);
            int[] result = new int[100];
            int cont = 0, aux =0;
            
            
            for (int lin = 0; lin < h; lin++) {
                for  (int col = 0; col < w; col++) {
                    

                    if (imagem.getRGB(col, lin) == -10436608) {
                        cont =2;
                        aux++;
                    }
                    if(cont == 2 && col < w-20){
                        pixels[w * lin + col]
                            = new Color(000, 000, 255).getRGB();
                    }
                    if(aux == 3){
                        aux =0;
                        cont = 0;
                    }
                }
                cont =0;

            }
            System.out.println(cont);

            imagem.setRGB(0, 0, w, h, pixels, 0, w);
            ImageIO.write(imagem, "PNG", new File("arteabstrata.png"));

        } catch (IOException exc) {

            exc.printStackTrace();

        }
    }

}
