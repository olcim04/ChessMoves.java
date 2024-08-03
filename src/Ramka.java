import javax.swing.*;
import java.awt.*;

public class Ramka extends JFrame{
    public static final int wysEkranu=1000;
    public static final int szerEkranu=1800;
    public Ramka()
    {
        setSize(szerEkranu/2, wysEkranu/2);
        setLocation(szerEkranu/4, wysEkranu/4);

        setTitle("Chess");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        PanelWyswietlenia wyswietlenie=new PanelWyswietlenia();
        wyswietlenie.setBackground(Color.white);
        Container powZawartosc=getContentPane();
        powZawartosc.add(wyswietlenie);
    }
}
