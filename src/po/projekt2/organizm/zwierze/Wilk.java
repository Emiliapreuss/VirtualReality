package po.projekt2.organizm.zwierze;

import po.projekt2.organizm.Organizm;
import po.projekt2.swiat.Punkt;
import po.projekt2.swiat.Swiat;

import java.awt.*;

public class Wilk extends Zwierzeta{
    public Wilk(Swiat s)
    {
        super(s);
        sila=9;
        inicjatywa=5;
        symbol="W";
        kolor = new Color(0,30,30);
    }
    @Override
    public String Wypisz()
    {
        return "WILK";
    }
    @Override
    public void Dzieci(Swiat s, Organizm org2)
    {
        Wilk wilk = new Wilk(s);
        Punkt p=SzukajMiejsca();
        if (!(s.mapa[p.getY()][p.GetX()] instanceof Wilk))
        {
            if (s.mapa[p.getY()][p.GetX()]==null)
            {
                s.getKomentator().rozmnozenie(Wypisz(),'r');
                wilk.setPozycja(p);
                s.DodajOrganizm(wilk);
            }
            else if (s.mapa[p.getY()][p.GetX()] != null && s.mapa[p.getY()][p.GetX()].getSila() < wilk.getSila())
            {
                s.getKomentator().rozmnozenie(Wypisz(),'p');
                s.mapa[p.getY()][p.GetX()].usunOrganizm(s);
                wilk.setPozycja(p);
                s.DodajOrganizm(wilk);
            }
            else
            {
                s.getKomentator().rozmnozenie(Wypisz(),'s');
            }
        }
        else
        {
            p=org2.SzukajMiejsca();
            if (!(s.mapa[p.getY()][p.GetX()] instanceof Wilk))
            {
                if (s.mapa[p.getY()][p.GetX()]==null)
                {
                    s.getKomentator().rozmnozenie(Wypisz(),'r');
                    wilk.setPozycja(p);
                    s.DodajOrganizm(wilk);
                }
                else if (s.mapa[p.getY()][p.GetX()] != null && s.mapa[p.getY()][p.GetX()].getSila() < wilk.getSila())
                {
                    s.getKomentator().rozmnozenie(Wypisz(),'p');
                    s.mapa[p.getY()][p.GetX()].usunOrganizm(s);
                    wilk.setPozycja(p);
                    s.DodajOrganizm(wilk);
                }
                else
                {
                    s.getKomentator().rozmnozenie(Wypisz(),'s');
                }
            }
        }
    }
}
