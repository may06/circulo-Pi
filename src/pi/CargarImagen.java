/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author May
 */
public class CargarImagen {  

    
    private BufferedImage imageActual;
    private int alto;
    private int ancho;
    private int aleatorios = 1000;
    private int puntosImagen;
    private int DiferenciaPi;

    public BufferedImage abrirImagen() {

        BufferedImage bmp = null;
        JFileChooser selector = new JFileChooser();
        selector.setDialogTitle("Seleccione una imagen");
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & GIF & BMP & PNG", "jpg", "gif", "bmp", "png");
        selector.setFileFilter(filtroImagen);
        int flag = selector.showOpenDialog(null);
        if (flag == JFileChooser.APPROVE_OPTION) {
            try {
                File imagenSeleccionada = selector.getSelectedFile();
                bmp = ImageIO.read(imagenSeleccionada);
            } catch (IOException e) {
            }
        }
        imageActual = bmp;

        return bmp;
    }

    public BufferedImage simular(String rep) {
        aleatorios = Integer.parseInt(rep);
        alto = imageActual.getHeight();
        ancho = imageActual.getWidth();
        aleatorios();
        return imageActual;
    }

    private void aleatorios() {

        puntosImagen = 0;
        Color newColor = new Color(255, 0,0);
        for (int i = 0; i < aleatorios; i++) {
            int x = generarAleatorio(0, ancho);
            int y = generarAleatorio(0, alto);
            Color color = new Color(this.imageActual.getRGB(x, y));
            if (color.equals(new Color(0, 0, 0))) {
                puntosImagen++;
            }
            imageActual.setRGB(x, y, newColor.getRGB());
        }

    }

    private int generarAleatorio(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    public int getAncho() {
        return ancho; 
    }

    public int getAlto() {
        return alto;
    }

    public int getPuntosImagen() {
        return (int) ((puntosImagen) + Math.random());
    }
    
    public int getDiferenciaPi(int PuntosImagen, int generarAleatorio) {
        
      return (int) ((PuntosImagen) / (generarAleatorio) *4 - Math.PI);
     //   return DiferenciaPi;
 
    }

    String getDiferenciaPi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}

