package po.projekt2.organizm.zwierze;

import po.projekt2.organizm.Organizm;
import po.projekt2.swiat.Punkt;
import po.projekt2.swiat.Swiat;

import java.awt.*;
import java.util.Random;

public class Zolw extends Zwierzeta {

    public Zolw(Swiat s)
    {
        super(s);
        sila=2;
        inicjatywa=1;
        symbol="Z";
        kolor = new Color(33, 206, 33);
    }
    public boolean OdbijAtak(Organizm atak)
    {
        if (atak.getSila() < 5)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    @Override
    public String Wypisz()
    {
        return "ZOLW";
    }
    @Override
    public void Kolizja(Swiat s, Organizm drugi)
    {
        if(getSila()>drugi.getSila())
        {
            s.getKomentator().pokonanie(drugi.Wypisz(),Wypisz());
            drugi.usunOrganizm(s);
        }
        else
        {
            if (OdbijAtak(drugi))
            {
                s.getKomentator().Odbij(Wypisz(), drugi.Wypisz());
            }

            else
            {
                s.getKomentator().pokonanie(Wypisz(), drugi.Wypisz());
                usunOrganizm(s);
                if (drugi instanceof Zwierzeta)
                {
                    ((Zwierzeta) drugi).Przesun(s);
                }

            }
        }

    }
    @Override
    public void Akcja(Swiat s)
    {
        Random rand = new Random();
        int a = rand.nextInt(4);
        if (a==3)//25%szans
        {
            Punkt p = SzukajMiejsca();
            if(p.GetX()!=polozenie.GetX() || p.getY() != polozenie.getY())
            {
                setCel(p);
                Decyduj(s.mapa[p.getY()][p.GetX()],s);
            }
        }
    }
    @Override
    public void Dzieci(Swiat s, Organizm org2)
    {
        Zolw zolw = new Zolw(s);
        Punkt p=SzukajMiejsca();
        if (!(s.mapa[p.getY()][p.GetX()] instanceof Zolw))
        {
            if (s.mapa[p.getY()][p.GetX()]==null)
            {
                s.getKomentator().rozmnozenie(Wypisz(),'r');
                zolw.setPozycja(p);
                s.DodajOrganizm(zolw);
            }
            else if (s.mapa[p.getY()][p.GetX()] != null && s.mapa[p.getY()][p.GetX()].getSila() < zolw.getSila())
            {
                s.getKomentator().rozmnozenie(Wypisz(),'p');
                s.mapa[p.getY()][p.GetX()].usunOrganizm(s);
                zolw.setPozycja(p);
                s.DodajOrganizm(zolw);
            }
            else
            {
                s.getKomentator().rozmnozenie(Wypisz(),'s');
            }
        }
        else
        {
            p=org2.SzukajMiejsca();
            if (!(s.mapa[p.getY()][p.GetX()] instanceof Zolw))
            {
                if (s.mapa[p.getY()][p.GetX()]==null)
                {
                    s.getKomentator().rozmnozenie(Wypisz(),'r');
                    zolw.setPozycja(p);
                    s.DodajOrganizm(zolw);
                }
                else if (s.mapa[p.getY()][p.GetX()] != null && s.mapa[p.getY()][p.GetX()].getSila() < zolw.getSila())
                {
                    s.getKomentator().rozmnozenie(Wypisz(),'p');
                    s.mapa[p.getY()][p.GetX()].usunOrganizm(s);
                    zolw.setPozycja(p);
                    s.DodajOrganizm(zolw);
                }
                else
                {
                    s.getKomentator().rozmnozenie(Wypisz(),'p');
                }
            }
        }
    }



}
