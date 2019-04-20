package meta;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Kelas Assets yang merepresentasikan pengambilan gambar dari file png
 */

public class Assets {
    public static Image Ayam;
    public static Image Bebek;
    public static Image Domba;
    public static Image Kambing;
    public static Image Sapi;
    public static Image Unta;
    public static Image Unta;
    public static Image Unta;
    public static Image Unta;
    public static Image Unta;

    public void init(){
        try{
            Ayam = ImageIO.read(getClass().getResource("img/Ayam.png"));
            Bebek = ImageIO.read(getClass().getResource("img/Bebek.png"));
            Domba = ImageIO.read(getClass().getResource("img/Domba.pnd"));
            Kambing = ImageIO.read(getClass().getResource("img/Kambing.png"));
            Sapi = ImageIO.read(getClass().getResource("img/Sapi.png"));
            Unta = ImageIO.read(getClass().getResource("img/UNta.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
