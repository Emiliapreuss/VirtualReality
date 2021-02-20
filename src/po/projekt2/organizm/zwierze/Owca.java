package po.projekt2.organizm.zwierze;

import po.projekt2.organizm.Organizm;
import po.projekt2.swiat.Punkt;
import po.projekt2.swiat.Swiat;

import java.awt.*;

public class Owca extends Zwierzeta {
    public Owca(Swiat s)
    {
        super(s);
        sila=4;
        inicjatywa=4;
        symbol="O";
        kolor = new Color(153, 138, 20, 158);

    }
    @Override
    public String Wypisz()
    {
        return "OWCA";
    }

@Override
public void Dzieci(Swiat s, Organizm org2)
{
    Owca owca = new Owca(s);
    Punkt p=SzukajMiejsca();
    if (!(s.mapa[p.getY()][p.GetX()] instanceof Owca))
    {
        if (s.mapa[p.getY()][p.GetX()]==null)
        {
            s.getKomentator().rozmnozenie(Wypisz(),'r');
            owca.setPozycja(p);
            s.DodajOrganizm(owca);
        }
        else if (s.mapa[p.getY()][p.GetX()] != null && s.mapa[p.getY()][p.GetX()].getSila() < owca.getSila())
        {
            s.getKomentator().rozmnozenie(Wypisz(),'p');
            s.mapa[p.getY()][p.GetX()].usunOrganizm(s);
            owca.setPozycja(p);
            s.DodajOrganizm(owca);
        }
        else
        {
            s.getKomentator().rozmnozenie(Wypisz(),'s');
        }
    }
    else
    {
        p=org2.SzukajMiejsca();
        if (!(s.mapa[p.getY()][p.GetX()] instanceof Owca))
        {
            if (s.mapa[p.getY()][p.GetX()]==null)
            {
                s.getKomentator().rozmnozenie(Wypisz(),'r');
                owca.setPozycja(p);
                s.DodajOrganizm(owca);
            }
            else if (s.mapa[p.getY()][p.GetX()] != null && s.mapa[p.getY()][p.GetX()].getSila() < owca.getSila())
            {
                s.getKomentator().rozmnozenie(Wypisz(),'p');
                s.mapa[p.getY()][p.GetX()].usunOrganizm(s);
                owca.setPozycja(p);
                s.DodajOrganizm(owca);
            }
            else
                {
                    s.getKomentator().rozmnozenie(Wypisz(),'s');
                }
        }
    }
}
}