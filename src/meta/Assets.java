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
    public static Image Kelinci;
    public static Image Sapi;
    public static Image Unta;
    public static Image Keju;
    public static Image Burger;
    public static Image Sate;
    public static Image DagingAyam;
    public static Image DagingBebek;
    public static Image DagingDomba;
    public static Image DagingKelinci;
    public static Image DagingSapi;
    public static Image DagingUnta;
    public static Image SusuSapi;
    public static Image SusuUnta;
    public static Image TelurAyam;
    public static Image TelurBebek;
    public static Image Truck;
    public static Image Well;
    public static Image Mixer;

    public void init(){
        try{
            Ayam = ImageIO.read(getClass().getResource("img/Ayam.png"));
            Bebek = ImageIO.read(getClass().getResource("img/Bebek.png"));
            Domba = ImageIO.read(getClass().getResource("img/Domba.pnd"));
            Kelinci = ImageIO.read(getClass().getResource("img/Kelinci.png"));
            Sapi = ImageIO.read(getClass().getResource("img/Sapi.png"));
            Unta = ImageIO.read(getClass().getResource("img/Unta.png"));
            DagingAyam = ImageIO.read(getClass().getResource("img/DagingAyam.png"));
            DagingBebek = ImageIO.read(getClass().getResource("img/DagingBebek.png"));
            DagingDomba = ImageIO.read(getClass().getResource("img/DagingDomba.pnd"));
            DagingKelinci = ImageIO.read(getClass().getResource("img/DagingKelinci.png"));
            DagingSapi = ImageIO.read(getClass().getResource("img/DagingSapi.png"));
            DagingUnta = ImageIO.read(getClass().getResource("img/DagingUnta.png"));
            TelurAyam = ImageIO.read(getClass().getResource("img/TelurAyam.png"));
            TelurBebek = ImageIO.read(getClass().getResource("img/TelurBebek.png"));
            SusuSapi = ImageIO.read(getClass().getResource("img/SusuSapi.png"));
            SusuUnta = ImageIO.read(getClass().getResource("img/SusuUnta.png"));
            Truck = ImageIO.read(getClass().getResource("img/Truck.png"));
            Well = ImageIO.read(getClass().getResource("img/Well.png"));
            Mixer = ImageIO.read(getClass().getResource("img/Mixer.pnd"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
