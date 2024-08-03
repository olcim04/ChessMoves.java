public class Czarne extends PanelWyswietlenia{
    private String [][]plansza;

    public Czarne() {
        plansza = new String[8][8];
        // Inicjalizacja planszy, np. ustawienie pustych pól
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                plansza[i][j] = " ";
            }
        }
    }

    void Cpion(String[][] p, int a, int b) {
        String znaczek = " X";
        if (a == 6) {
            p[a - 1][b] = znaczek;
            p[a - 2][b] = znaczek;
        } else if (a == 0) {
            System.out.print("\nPionek mozna zastapic inna zbita juz wczesniej figura, poniewaz doszedl do konca planszy.");
        } else p[a - 1][b] = znaczek;

        plansza[a][b]=" P";
    }

    void Goniec(String[][]plansza, int a, int b){
        // Sprawdź możliwe ruchy po skosie w lewo górę
        sprawdzIRuch(plansza, a, b, -1, -1);

        // Sprawdź możliwe ruchy po skosie w prawo górę
        sprawdzIRuch(plansza, a, b, -1, 1);

        // Sprawdź możliwe ruchy po skosie w lewo dół
        sprawdzIRuch(plansza, a, b, 1, -1);

        // Sprawdź możliwe ruchy po skosie w prawo dół
        sprawdzIRuch(plansza, a, b, 1, 1);

        plansza[a][b]=" B";
    }

    public static void sprawdzIRuch(String[][] p, int startX, int startY, int stepX, int stepY) {
        int x = startX + stepX;
        int y = startY + stepY;
        String znaczek=" X";

        while (czyPoprawneWspolrzedne(x, y, p.length)) {
            p[x][y]=znaczek;
            x += stepX;
            y += stepY;
        }
    }

    public static boolean czyPoprawneWspolrzedne(int x, int y, int rozmiarPlanszy) {
        return x >= 0 && x < rozmiarPlanszy && y >= 0 && y < rozmiarPlanszy;
    }

    void Skoczek(String[][]p, int a, int b) {
        String znaczek = " X";
        if(a>1 && a<6 && b>1 && b<6) {
            p[a - 2][b - 1] = znaczek;
            p[a - 2][b + 1] = znaczek;

            p[a - 1][b - 2] = znaczek;
            p[a - 1][b + 2] = znaczek;

            p[a + 2][b + 1] = znaczek;
            p[a + 2][b - 1] = znaczek;

            p[a + 1][b + 2] = znaczek;
            p[a + 1][b - 2] = znaczek;
        }
        else if(a>1 && a<6 && b==1){
            p[a + 1][b + 2] = znaczek;
            p[a + 2][b + 1] = znaczek;
            p[a + 2][b - 1] = znaczek;
            p[a - 2][b - 1] = znaczek;
            p[a - 2][b + 1] = znaczek;
            p[a - 1][b + 2] = znaczek;
        }
        else if(a>1 && a<6 && b==0){
            p[a + 1][b + 2] = znaczek;
            p[a + 2][b + 1] = znaczek;
            p[a - 2][b + 1] = znaczek;
            p[a - 1][b + 2] = znaczek;
        }
        else if(a>1 && a<6 && b==6){
            p[a + 2][b + 1] = znaczek;
            p[a + 2][b - 1] = znaczek;
            p[a - 2][b - 1] = znaczek;
            p[a - 2][b + 1] = znaczek;
            p[a + 1][b - 2] = znaczek;
            p[a - 1][b - 2] = znaczek;
        }
        else if(a>1 && a<6 && b==7){
            p[a + 2][b - 1] = znaczek;
            p[a - 2][b - 1] = znaczek;
            p[a + 1][b - 2] = znaczek;
            p[a - 1][b - 2] = znaczek;
        }
        else if(b>1 && b<6 && a==6){
            p[a - 2][b - 1] = znaczek;
            p[a - 2][b + 1] = znaczek;
            p[a - 1][b - 2] = znaczek;
            p[a - 1][b + 2] = znaczek;
            p[a + 1][b + 2] = znaczek;
            p[a + 1][b - 2] = znaczek;
        }
        else if(b>1 && b<6 && a==7){
            p[a - 2][b - 1] = znaczek;
            p[a - 2][b + 1] = znaczek;
            p[a - 1][b - 2] = znaczek;
            p[a - 1][b + 2] = znaczek;
        }
        else if(a==0){
            if(b==0) {
                p[a + 2][b + 1] = znaczek;
                p[a + 1][b + 2] = znaczek;
            }
            else if(b==1){
                p[a + 2][b + 1] = znaczek;
                p[a + 1][b + 2] = znaczek;
                p[a+2][b-1]=znaczek;
            }
            else if(b==7){
                p[a+1][b-2]=znaczek;
                p[a+2][b-1]=znaczek;
            }
            else if(b==6){
                p[a+2][b+1]=znaczek;
                p[a+1][b-2]=znaczek;
                p[a+2][b-1]=znaczek;
            }
            else{
                p[a+2][b+1]=znaczek;
                p[a+1][b-2]=znaczek;
                p[a+2][b-1]=znaczek;
                p[a+1][b+2]=znaczek;
            }
        }else if(a==1){
            if(b==0) {
                p[a + 2][b + 1] = znaczek;
                p[a + 1][b + 2] = znaczek;
                p[a-1][b+2]=znaczek;
            }
            else if(b==1){
                p[a + 2][b + 1] = znaczek;
                p[a + 1][b + 2] = znaczek;
                p[a+2][b-1]=znaczek;
                p[a-1][b+2]=znaczek;
            }
            else if(b==7){
                p[a+1][b-2]=znaczek;
                p[a+2][b-1]=znaczek;
                p[a-1][b-2]=znaczek;
            }
            else if(b==6){
                p[a+2][b+1]=znaczek;
                p[a+1][b-2]=znaczek;
                p[a+2][b-1]=znaczek;
                p[a-1][b-2]=znaczek;
            }
            else{
                p[a+2][b+1]=znaczek;
                p[a+1][b-2]=znaczek;
                p[a+2][b-1]=znaczek;
                p[a+1][b+2]=znaczek;
                p[a-1][b-2]=znaczek;
                p[a-1][b+2]=znaczek;
            }
        }else if(a>1 && a<6 && b==0){
            p[a + 2][b + 1] = znaczek;
            p[a - 2][b + 1] = znaczek;
            p[a+1][b+2]=znaczek;
            p[a-1][b+2]=znaczek;
        }
        else if(a>1 && a<6 && b==1){
            p[a + 2][b + 1] = znaczek;
            p[a - 2][b + 1] = znaczek;
            p[a+1][b+2]=znaczek;
            p[a-1][b+2]=znaczek;
            p[a+2][b-1]=znaczek;
            p[a-2][b-1]=znaczek;
        }
        else if(a>1 && a<6 && b==7){
            p[a+1][b-2]=znaczek;
            p[a-1][b-2]=znaczek;
            p[a+2][b-1]=znaczek;
            p[a-2][b-1]=znaczek;
        }
        else if(a>1 && a<6 && b==6){
            p[a + 2][b - 1] = znaczek;
            p[a - 2][b - 1] = znaczek;
            p[a+1][b-2]=znaczek;
            p[a-1][b-2]=znaczek;
            p[a+2][b-1]=znaczek;
            p[a-2][b-1]=znaczek;
        }
        else if(a==7){
            if(b==0){
                p[a-1][b+2]=znaczek;
                p[a-2][b+1]=znaczek;
            }
            else if(b==1){
                p[a-2][b-1]=znaczek;
                p[a-1][b+2]=znaczek;
                p[a-2][b+1]=znaczek;
            }
            else if(b==7) {
                p[a-2][b-1]=znaczek;
                p[a-1][b-2]=znaczek;
            }
            else if(b==6){
                p[a-2][b+1]=znaczek;
                p[a-2][b-1]=znaczek;
                p[a-1][b-2]=znaczek;
            }
        }else if(a==6){
            if(b==0){
                p[a-1][b+2]=znaczek;
                p[a-2][b+1]=znaczek;
                p[a+1][b+2]=znaczek;
            }
            else if(b==1){
                p[a-2][b-1]=znaczek;
                p[a-1][b+2]=znaczek;
                p[a-2][b+1]=znaczek;
                p[a+1][b+2]=znaczek;
            }
            else if(b==7) {
                p[a-2][b-1]=znaczek;
                p[a-1][b-2]=znaczek;
                p[a+1][b-2]=znaczek;
            }
            else if(b==6){
                p[a-2][b+1]=znaczek;
                p[a-2][b-1]=znaczek;
                p[a-1][b-2]=znaczek;
                p[a+1][b-2]=znaczek;
            }
        }

        plansza[a][b]=" S";
    }

    void Wieza(String[][]p, int a, int b){
        String znaczek=" X";

        int l=a;
        int g=b;

        for (int i=0;i<a;i++)
            p[i][b]=znaczek;

        for(int i=a+1;i<9;i++){
            p[l][b]=znaczek;
            l++;
        }

        for(int j=0;j<b;j++)
            p[a][j]=znaczek;

        for (int j=b+1;j<9;j++){
            p[a][g]=znaczek;
            g++;
        }

        p[a][b]=" R";
    }

    public void Krol(String [][]p, int a, int b){
        String znaczek=" X";

        if(a>0 && a<7 && b>0 && b<7) {
            p[a - 1][b] = znaczek;
            p[a + 1][b] = znaczek;

            p[a][b - 1] = znaczek;
            p[a][b + 1] = znaczek;

            p[a + 1][b - 1] = znaczek;
            p[a + 1][b + 1] = znaczek;

            p[a - 1][b - 1] = znaczek;
            p[a - 1][b + 1] = znaczek;
        }
        else if(a==0)
        {
            if(b==0)
            {
                p[a+1][b+1]=znaczek;
                p[a+1][b]=znaczek;
                p[a][b+1]=znaczek;
            }
            else if(b==7)
            {
                p[a+1][b-1]=znaczek;
                p[a+1][b]=znaczek;
                p[a][b-1]=znaczek;
            }
            else{
                p[a+1][b-1]=znaczek;
                p[a+1][b]=znaczek;
                p[a][b-1]=znaczek;
                p[a+1][b+1]=znaczek;
                p[a][b+1]=znaczek;
            }
        }
        else if(a>0 && a<7 && b==0)
        {
            p[a+1][b+1]=znaczek;
            p[a+1][b]=znaczek;
            p[a][b+1]=znaczek;
            p[a-1][b]=znaczek;
            p[a-1][b+1]=znaczek;
        }
        else if(a==7){
            if(b==0)
            {
                p[a-1][b+1]=znaczek;
                p[a-1][b]=znaczek;
                p[a][b+1]=znaczek;
            }
            else if(b==7)
            {
                p[a-1][b-1]=znaczek;
                p[a-1][b]=znaczek;
                p[a][b-1]=znaczek;
            }
            else{
                p[a-1][b-1]=znaczek;
                p[a-1][b]=znaczek;
                p[a][b-1]=znaczek;
                p[a-1][b+1]=znaczek;
                p[a][b+1]=znaczek;
            }
        }
        else if(a>0 && a<7 && b==7)
        {
            p[a+1][b-1]=znaczek;
            p[a+1][b]=znaczek;
            p[a][b-1]=znaczek;
            p[a-1][b]=znaczek;
            p[a-1][b-1]=znaczek;
        }

        plansza[a][b]=" K";
    }

    public void Hetman(String[][]plansza, int a,int b ){
        String znaczek=" X";

        int k=a;
        int w=b;

        //poruszanie sie po lini prostej
        for (int i = 0; i < a; i++)
            plansza[i][b] = znaczek;

        for (int i = a + 1; i <= 8; i++){
            plansza[k][b] = znaczek;
            k++;}

        for (int j = 0; j < b; j++)
            plansza[a][j] = znaczek;

        for (int j = b + 1; j <= 8; j++){
            plansza[a][w] = znaczek;
            w++;}

        // Sprawdź możliwe ruchy po skosie w lewo górę
        sprawdzIRuch(plansza, a, b, -1, -1);

        // Sprawdź możliwe ruchy po skosie w prawo górę
        sprawdzIRuch(plansza, a, b, -1, 1);

        // Sprawdź możliwe ruchy po skosie w lewo dół
        sprawdzIRuch(plansza, a, b, 1, -1);

        // Sprawdź możliwe ruchy po skosie w prawo dół
        sprawdzIRuch(plansza, a, b, 1, 1);

        plansza[a][b]=" Q";
    }

    void Sprawdzenie(String figura, int zmienA, int zmienB) {

        Plansza p=new Plansza();

        if ("s".equalsIgnoreCase(figura)) {
            Skoczek(plansza,zmienA,zmienB);
        }
        else if ("q".equalsIgnoreCase(figura)) {
            Hetman(plansza,zmienA,zmienB);
        }
        else if ("k".equalsIgnoreCase(figura)) {
            Krol(plansza,zmienA,zmienB);
        }
        else if ("p".equalsIgnoreCase(figura)) {
            Cpion(plansza, zmienA, zmienB);
        }
        else if ("b".equalsIgnoreCase(figura)) {
            Goniec(plansza,zmienA,zmienB);
        }
        else if ("r".equalsIgnoreCase(figura)) {
            Wieza(plansza,zmienA,zmienB);
        }
    }

    public String[][] getPlansza() {
        // Tu powinieneś zwrócić planszę
        return plansza;
    }
}
