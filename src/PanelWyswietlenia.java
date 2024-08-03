import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PanelWyswietlenia extends JPanel{
    private JTextField zmiennaA;
    private JTextField zmiennaB;
    private JTextField figura;
    private JTextField kolor;
    private JLabel wynik;


    public PanelWyswietlenia()
    {
        JLabel polecenie=new JLabel("Program shows all posible moves of chosen chess figure.",SwingConstants.CENTER);
        polecenie.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel polecenie1=new JLabel("First, you need to specify the color of chess pieces and the pawn, and then their place on the board. ",SwingConstants.CENTER);
        JLabel polecenie10=new JLabel("Where king is k and knight is s. ",SwingConstants.CENTER);
        JLabel polecenie2=new JLabel("The position is given in numbers from 1 to 8 (even for letters, corresponding to A-1, B-2, and so on).",SwingConstants.CENTER);
        JLabel polecenie3=new JLabel("The color of the pawns and the figure are given as the first letter of the given color and figure.",SwingConstants.CENTER);
        JLabel polecenie4=new JLabel("The white chess pieces are placed at the bottom of the board (1,2) and the black chess pieces are at the top of the board (7,8) in the basic arrangement. ",SwingConstants.CENTER);
        JLabel polecenie5=new JLabel("How the program work: ",SwingConstants.CENTER);

        polecenie1.setFont(new Font("Arial",Font.PLAIN, 12));
        polecenie10.setFont(new Font("Arial",Font.PLAIN, 12));
        polecenie2.setFont(new Font("Arial",Font.PLAIN, 12));
        polecenie3.setFont(new Font("Arial",Font.PLAIN, 12));
        polecenie4.setFont(new Font("Arial",Font.PLAIN, 12));
        polecenie5.setFont(new Font("Arial",Font.PLAIN, 14));

        JPanel panel3=new JPanel(new GridLayout(9,1));
        panel3.add(new JLabel());
        panel3.add(polecenie);
        panel3.add(polecenie5);
        panel3.add(polecenie1);
        panel3.add(polecenie10);
        panel3.add(polecenie4);
        panel3.add(polecenie3);
        panel3.add(polecenie2);
        panel3.add(new JLabel());
        panel3.setBackground(Color.white);
        add(panel3);

        JLabel etykirtaZmiannaA= new JLabel("Position 1 to 8 (vertical position): ",SwingConstants.RIGHT);
        JLabel etykietaZmiennaB= new JLabel("Position 1 to 8 (horizontal position A-H): ",SwingConstants.RIGHT);
        JLabel Figura=new JLabel("Figure: ",SwingConstants.RIGHT);
        JLabel Kolor=new JLabel("Chess color: ",SwingConstants.RIGHT);
        zmiennaA=new JTextField(2);
        zmiennaB=new JTextField(2);
        figura= new JTextField(2);
        kolor=new JTextField(2);

        JButton przyciskOblicz=new JButton("Show");
        przyciskOblicz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wyswietlenieTablicy();
            }
        });
        wynik=new JLabel("");

        JPanel panel=new JPanel(new GridLayout(6,2));
        panel.add(Kolor);
        panel.add(kolor);
        panel.add(Figura);
        panel.add(figura);
        panel.add(etykirtaZmiannaA);
        panel.add(zmiennaA);
        panel.add(etykietaZmiennaB);
        panel.add(zmiennaB);
        panel.add(new JLabel());
        panel.add(przyciskOblicz);
        panel.add(new JLabel());
        panel.setBackground(Color.white);
        add(panel);

        JPanel panel1=new JPanel(new GridLayout(1,1));
        panel1.add(wynik);
        panel1.setBackground(Color.white);
        add(panel1);
    }

    private void wyswietlenieTablicy() {

        try {
            String figuraspr=figura.getText();
            String kolorspr=kolor.getText();

            if(kolorspr.length()==1&&figuraspr.length()==1)
            {
                if("w".equalsIgnoreCase(kolorspr)) {
                    try {
                        int zmienna1 = Integer.parseInt(zmiennaA.getText());
                        int zmienna2 = Integer.parseInt(zmiennaB.getText());

                        if (zmienna1 <= 0 || zmienna1 >= 9 || zmienna2 <= 0 || zmienna2 >= 9) {
                            throw new NumberFormatException();
                        }
                        wynik.setText("");
                        if("r".equalsIgnoreCase(figuraspr)||"b".equalsIgnoreCase(figuraspr)||"p".equalsIgnoreCase(figuraspr)||"k".equalsIgnoreCase(figuraspr)||"q".equalsIgnoreCase(figuraspr)||"s".equalsIgnoreCase(figuraspr)) {
                            Biale biale = new Biale();
                            biale.Sprawdzenie(figuraspr, zmienna1 - 1, zmienna2 - 1);
                            String[][] uzupelnionaPlansza=biale.getPlansza();
                            wyswietlPlansze(uzupelnionaPlansza, zmienna1-1, zmienna2-1);

                        }
                        else{
                            wynik.setText("Incorrect figure.");
                        }
                    } catch (NumberFormatException ex) {
                        wynik.setText("Error: Please enter correct information.");
                    }
                }
                else if("b".equalsIgnoreCase(kolorspr))
                {
                    try {
                        int zmienna1 = Integer.parseInt(zmiennaA.getText());
                        int zmienna2 = Integer.parseInt(zmiennaB.getText());

                        if (zmienna1 <= 0 || zmienna1 >= 9 || zmienna2 <= 0 || zmienna2 >= 9) {
                            throw new NumberFormatException();
                        }
                        wynik.setText("");
                        if("r".equalsIgnoreCase(figuraspr)||"b".equalsIgnoreCase(figuraspr)||"p".equalsIgnoreCase(figuraspr)||"k".equalsIgnoreCase(figuraspr)||"q".equalsIgnoreCase(figuraspr)||"s".equalsIgnoreCase(figuraspr)) {

                            Czarne czarne = new Czarne();
                            czarne.Sprawdzenie(figuraspr, zmienna1 - 1, zmienna2 - 1);
                            String[][] uzupelnionaPlansza=czarne.getPlansza();
                            wyswietlPlansze(uzupelnionaPlansza, zmienna1-1, zmienna2-1);
                        }
                        else{
                            wynik.setText("Incorrect figure.");
                        }
                    } catch (NumberFormatException ex) {
                        wynik.setText("Error: Please enter correct information.");
                    }
                }
                else{
                    wynik.setText("Incorrect color entered. Try again.");
                }

            } else{
                wynik.setText("Error sign. Enter one letter.");
            }
        } catch(StringIndexOutOfBoundsException ex)
        {
         wynik.setText("Wrong sign. Enter one letter.");
        }
    }

    private void wyswietlPlansze(String [][] plansza, int a, int b) {
        String[] pomocnicza={"A", "B", "C", "D", "E", "F", "G", "H"};
        JPanel panel2 = new JPanel(new GridLayout(9, 9));
        panel2.add(new JLabel(""));
        for(int i=0;i<8;i++) {
            JLabel litery=new JLabel(pomocnicza[i]);
            panel2.add(litery).setFont(new Font("Arial", Font.BOLD, 18));
        }

        String[] pomocnicza1={"1", "2", "3", "4", "5", "6", "7", "8"};
        for (int i = 0; i < 8; i++) {
            JLabel wynik3 = new JLabel(pomocnicza1[i]);

            panel2.add(wynik3).setFont(new Font("Arial", Font.BOLD, 18));
            for (int j = 0; j < 8; j++) {
                JTextField wynik2 = new JTextField(plansza[i][j]);
                wynik2.setEditable(false); // Ustawia pole jako niemożliwe do edycji

                if(i%2==0&& j%2==0)
                {
                    panel2.add(wynik2).setBackground(Color.BLACK);
                    panel2.add(wynik2).setForeground(Color.WHITE);
                }
                if(i%2==1&&j%2==1)
                {
                    panel2.add(wynik2).setBackground(Color.BLACK);
                    panel2.add(wynik2).setForeground(Color.WHITE);
                }
                if(i==a&&j==b)
                {
                    panel2.add(wynik2).setForeground(Color.RED);
                }
                panel2.add(wynik2).setFont(new Font("Arial", Font.BOLD, 18));
            }
        }

        JOptionPane.showMessageDialog(this,panel2, "MovesTable", JOptionPane.INFORMATION_MESSAGE);
    }
}
