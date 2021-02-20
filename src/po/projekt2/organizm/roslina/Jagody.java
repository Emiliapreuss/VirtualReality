package po.projekt2.organizm.roslina;

import po.projekt2.organizm.Organizm;
import po.projekt2.organizm.zwierze.Zwierzeta;
import po.projekt2.swiat.Punkt;
import po.projekt2.swiat.Swiat;

import java.awt.*;

public class Jagody extends Roslina{
    public Jagody(Swiat s)
    {
        super(s);
        sila=99;
        prawd=0.2;
        symbol="J";
        kolor= new Color(110,100, 200);
    }
    @Override
    public String Wypisz()
    {
        return "WILCZE JAGODY";
    }
    @Override
    public void Kolizja(Swiat s, Organizm org2)
    {
        if(org2 instanceof Zwierzeta)
        {
            s.getKomentator().pokonanie(org2.Wypisz(),Wypisz());
            org2.usunOrganizm(s);
        }

    }
    @Override
    public void Siej(Swiat s, Punkt p)
    {
        s.getKomentator().sianie(Wypisz());
        Jagody jag = new Jagody(s);
        jag.setPozycja(p);
        s.DodajOrganizm(jag);
    }
}
