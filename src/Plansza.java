import java.io.*;

public class Plansza {
    public void zapisz_plansza (String [][] p){

        String wP="dane.txt";
        String line="Wszystkie możliwe ruchy wybranego pionka.\n\n";

        String line1 = ("\n   A   B   C   D   E   F   G   H\n");
        String a="  ---+---+---+---+---+---+---+----\n";
        String b="  --------------------------------\n";

        try(FileOutputStream fos=new FileOutputStream(wP)) {
            fos.write(line.getBytes());
            fos.write(line1.getBytes());
            fos.write(b.getBytes());


            for (int i = 0; i < p.length; i++) {
                int k=i+1;
                String h="|\n";
                String o="| ";
                String line2=Integer.toString(k);
                fos.write(line2.getBytes());
                for (int j = 0; j < p.length; j++) {
                    fos.write(o.getBytes());
                    String wartosc=p[i][j];
                    fos.write(wartosc.getBytes());
                }
                if (i != 7) {
                    fos.write(h.getBytes());
                    fos.write(a.getBytes());
                } else {
                    fos.write(h.getBytes());
                    fos.write(b.getBytes());
                }
            }
            fos.flush();
        }
        catch(FileNotFoundException e){
            System.out.println("Blad "+e.getLocalizedMessage());
        }
        catch(IOException e){
            System.out.println("Blad "+e.getLocalizedMessage());
        }
    }

    public void wyswietl_plansza(String[][]p)
    {
        System.out.print("\n   A   B   C   D   E   F   G   H\n");
        String a="  ---+---+---+---+---+---+---+----\n";
        String b="  --------------------------------\n";

        System.out.print(b);
        for (int i = 0; i < p.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < p.length; j++) {
                System.out.print("| " + p[i][j]);
            }
            if (i != 7) {
                System.out.print("|\n");
                System.out.print(a);
            } else {
                System.out.print("|\n");
                System.out.print(b);
            }
        }
    }
}
