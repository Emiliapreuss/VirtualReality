package po.projekt2.swiat;

public class Komentator {
    Komentator(Swiat swiat)
    {
        this.s=swiat;
    }
    public void rozmnozenie(String nazwa, char x)
    {
        s.getIlustracja().dodajKomentarz("Nastapilo rozmnozenie organizmu "+nazwa+"\n");
        if(x=='s')
        {
            s.getIlustracja().dodajKomentarz("Mloda/y "+nazwa+ " zostala/y pokonana/y\n");
        }
        if(x=='p')
        {
            s.getIlustracja().dodajKomentarz("Mloda/y "+nazwa+" pokonala/y inny organizm\n");
        }
    }
    public void pokonanie(String pokonany, String wygrany)
    {
        s.getIlustracja().dodajKomentarz("Organizm "+pokonany+" zostal pokonany przez organizm "+wygrany+"\n");
    }
    public void sianie(String nazwa)
    {
        s.getIlustracja().dodajKomentarz("Nastąpilo zasianie rosliny o nazwie "+nazwa+"\n");
    }
    public void Barszcz(String nazwa, String atak)
    {
        s.getIlustracja().dodajKomentarz("Organizm "+nazwa+" znalazl sie w poblizu organizmu " + atak+ " i nie przezyl\n");
    }
    public void Wygrana()
    {
        s.getIlustracja().dodajKomentarz("\nCZLOWIEK POZOSTAL SAM NA PLANSZY, GRA WYGRANA!!!\n\n");
    }
    public void Przegrana()
    {
        s.getIlustracja().dodajKomentarz("\nCZLOWIEK UMARL :(\n\n");

    }
    public void Ucieczka(String a)
    {
        s.getIlustracja().dodajKomentarz("Organizmowi "+a+" udalo sie uciec\n");
    }
    public void Odbij(String nazwa, String atak )
    {
        s.getIlustracja().dodajKomentarz("Organizm "+nazwa+" odbil atak organizmu "+atak+"\n");
    }
    public void Sila(String jedzacy, String zjedzony)
    {
        s.getIlustracja().dodajKomentarz("Organizmowi "+jedzacy+" zwiekszono sile w wyniku zjedzenia organizmu "+zjedzony+"\n");

    }
    public void aktywowana()
    {
        s.getIlustracja().dodajKomentarz("Umiejetnosc SZYBKOSC ANTYLOPY zostala aktywowana\n");
    }
    public void aktywna(int ile)
    {
        s.getIlustracja().dodajKomentarz("Umiejetnosc jest jeszcze aktywna przez "+ile+" tur\n");
    }
    public void nieaktywna(int ile)
    {
        s.getIlustracja().dodajKomentarz("Umiejetnosc nie moze zostac aktywowana jeszcze przez "+ile+" tur\n");
    }
    public void plik()
    {
        s.getIlustracja().dodajKomentarz("Nie można utworzyć pliku\n");
    }
    public void zapis()
    {
        s.getIlustracja().dodajKomentarz("Stan gry zostal zapisany do pliku\n");
    }
    public void czlowiekruch()
    {
        s.getIlustracja().dodajKomentarz("\nNACISNIJ STRZALKE, BY PORUSZYC CZLOWIEKIEM!!!\n\n");
    }
    public void lis()
    {
        s.getIlustracja().dodajKomentarz("Lis wyweszyl silniejszego przeciwnika i nie przesuwa sie\n");
    }
    public void laduj()
    {
        s.getIlustracja().dodajKomentarz("Zaladowano stan gry z pliku\n") ;
    }
    public void niezyje()
    {
        s.getIlustracja().dodajKomentarz("Czlowiek nie zyje, nie mozna wlaczyc umiejetnosci\n");
    }

    private Swiat s;
}
