package po.projekt2.organizm.roslina;

import po.projekt2.organizm.Organizm;
import po.projekt2.organizm.zwierze.Zwierzeta;
import po.projekt2.swiat.Punkt;
import po.projekt2.swiat.Swiat;

import java.awt.*;

public class Guarana extends Roslina {
public Guarana(Swiat s)
{
    super(s);
    symbol="G";
    kolor = new Color(255,102,102);
}
    @Override
    public String Wypisz()
    {
        return "GUARANA";
    }
@Override
    public void Kolizja(Swiat s, Organizm org2)
{
    if (getSila()>org2.getSila())
    {
        s.getKomentator().pokonanie(org2.Wypisz(), Wypisz());
        org2.usunOrganizm(s);

    }
    else
    {
        s.getKomentator().pokonanie(Wypisz(), org2.Wypisz());
        usunOrganizm(s);
        if (org2 instanceof Zwierzeta)
        {
            org2.setSila(org2.getSila()+3);
            ((Zwierzeta) org2).Przesun(s);
            s.getKomentator().Sila(org2.Wypisz(),Wypisz());
        }


    }
}
@Override
    public void Siej(Swiat s, Punkt p)
{
    s.getKomentator().sianie(Wypisz());
    Guarana guara = new Guarana(s);
    guara.setPozycja(p);
    s.DodajOrganizm(guara);


}

}
