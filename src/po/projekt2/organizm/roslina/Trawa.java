package po.projekt2.organizm.roslina;

import po.projekt2.swiat.Punkt;
import po.projekt2.swiat.Swiat;

import java.awt.*;

public class Trawa extends Roslina{
    public Trawa(Swiat s)
    {
        super(s);
        prawd=0.6;
        symbol="T";
        kolor=new Color(8, 123, 8);
    }
    @Override
    public String Wypisz()
    {
        return "TRAWA";
    }
    @Override
    public void Siej(Swiat s, Punkt p)
    {
        s.getKomentator().sianie(Wypisz());
        Trawa trawa = new Trawa(s);
        trawa.setPozycja(p);
        s.DodajOrganizm(trawa);
    }
}
