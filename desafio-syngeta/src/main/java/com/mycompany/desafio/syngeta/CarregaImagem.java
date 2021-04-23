/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.desafio.syngeta;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author thales
 */
public class CarregaImagem {
    // Lendo de um input stream

    public static void main(String[] args) {
        new CarregaImagem().carregar();

    }

    public void carregar() {

        try {

            BufferedImage imagem = ImageIO.read(new File("imagem.bmp"));

            int w = imagem.getWidth();
            int h = imagem.getHeight();
            int cont = 0;
            
            
            for (int lin = 0; lin < h; lin++) {
                for  (int col = 0; col < w; col++) {
                    if (imagem.getRGB(col, lin) == -10436608) {
                        cont++;
                    }
                }
            }
            System.out.println("Quantidade de pontos verdes: "+cont);
        } catch (IOException exc) {

            exc.printStackTrace();

        }
    }

}
