package po.projekt2.organizm.zwierze;

import po.projekt2.organizm.Organizm;
import po.projekt2.swiat.Punkt;
import po.projekt2.swiat.Swiat;

import java.awt.*;
import java.util.Random;

public class Antylopa extends Zwierzeta {

    public Antylopa(Swiat s)
    {
        super(s);
        sila=4;
        inicjatywa=4;
        symbol="A";
        kolor=new Color(73, 76, 61);

    }
    @Override
    public String Wypisz()
    {
        return "ANTYLOPA";
    }
    @Override
    public void Dzieci(Swiat s, Organizm org2)
    {
        Antylopa anty = new Antylopa(s);
        Punkt p=SzukajMiejsca();
        if (!(s.mapa[p.getY()][p.GetX()] instanceof Antylopa))
        {
            if (s.mapa[p.getY()][p.GetX()]==null)
            {
                s.getKomentator().rozmnozenie(Wypisz(),'r');
                anty.setPozycja(p);
                s.DodajOrganizm(anty);
            }
            else if (s.mapa[p.getY()][p.GetX()] != null && s.mapa[p.getY()][p.GetX()].getSila() < anty.getSila())
            {
                s.getKomentator().rozmnozenie(Wypisz(),'p');
                s.mapa[p.getY()][p.GetX()].usunOrganizm(s);
                anty.setPozycja(p);
                s.DodajOrganizm(anty);
            }
            else
            {
                s.getKomentator().rozmnozenie(Wypisz(),'s');
            }
        }
        else
        {
            p=org2.SzukajMiejsca();
           if (!(s.mapa[p.getY()][p.GetX()] instanceof Antylopa))
           {
               if (s.mapa[p.getY()][p.GetX()]==null)
               {
                   s.getKomentator().rozmnozenie(Wypisz(),'r');
                   anty.setPozycja(p);
                   s.DodajOrganizm(anty);
               }
               else if (s.mapa[p.getY()][p.GetX()] != null && s.mapa[p.getY()][p.GetX()].getSila() < anty.getSila())
               {
                   s.getKomentator().rozmnozenie(Wypisz(),'p');
                   s.mapa[p.getY()][p.GetX()].usunOrganizm(s);
                   anty.setPozycja(p);
                   s.DodajOrganizm(anty);
               }
               else
               {
                   s.getKomentator().rozmnozenie(Wypisz(),'s');
               }
           }
        }

    }
    @Override
    public void Kolizja(Swiat s, Organizm drugi)
    {
        if (!Unik())
        {
            if (getSila()>drugi.getSila())
            {
                s.getKomentator().pokonanie(drugi.Wypisz(), Wypisz());
                drugi.usunOrganizm(s);

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
        else
        {
            if (drugi instanceof Zwierzeta)
            {
                ((Zwierzeta) drugi).Przesun(s);
            }
        }
    }
    @Override
    public Punkt SzukajMiejsca()
    {
        Punkt dest = new Punkt (getPunkt().GetX(), getPunkt().getY());
        boolean udalosie = false;
        Random ran = new Random();
        for (int i = 0; i < 10; i++)
        {
            if (!udalosie)
            {

                int a = ran.nextInt(4);
                switch (a)
                {
                    case 0: //0
                        if (dest.getY() >= 2) {
                            dest.setY(dest.getY() - 2);
                            udalosie = true;
                        }
                        else if (dest.getY() >= 1) {
                            dest.setY(dest.getY() - 1);
                            udalosie = true;
                        }
                        break;

                    case 1:
                        if (dest.GetX() < s.getSzer() - 2) {
                            dest.setX(dest.GetX() + 2);
                            udalosie = true;
                        }
                        else if (dest.GetX() < s.getSzer() - 1) {
                            dest.setX(dest.GetX() + 1);
                            udalosie = true;
                        }
                        break;

                    case 2:
                        if (dest.getY() < s.getWys() - 2) {
                            dest.setY(dest.getY() + 2);
                            udalosie = true;
                        }
                        else if (dest.getY() < s.getWys() - 1) {
                            dest.setY(dest.getY() + 1);
                            udalosie = true;
                        }
                        break;

                    case 3:
                        if (dest.GetX() >= 2) {
                            dest.setX(dest.GetX() - 2);
                            udalosie = true;
                        }
                        else if (dest.GetX() >= 1) {
                            dest.setX(dest.GetX() - 1);
                            udalosie = true;
                        }
                        break;

                }
            }
        }
        return dest;
    }
    private  boolean Unik()
    {
        Random ran = new Random();
        int a = ran.nextInt(2);
        if (a==1)
        {
            Punkt p = Ucieczka(s);
            if (p.getY()!=polozenie.getY() || p.GetX() != polozenie.GetX())
            {
                setCel(p);
                Przesun(s);
                s.getKomentator().Ucieczka(Wypisz());
                return true;
            }
        }
        return false;
    }
    private Punkt Ucieczka(Swiat s)
    {
        Punkt dest = new Punkt (  getPunkt().GetX(), getPunkt().getY());
        boolean udalosie = false;
        Random ran = new Random();
        int a = ran.nextInt(4);
        for (int i = 0; i < 10; i++)
        {
            if (!udalosie)
            {
                switch (a)
                {
                    case 0:
                        if( (dest.getY() >= 1) &&(s.mapa[dest.getY() - 1][dest.GetX()]==null)){
                            dest.setY(dest.getY() - 1);
                            udalosie = true;
                        }
                        break;

                    case 1:
                        if( (dest.GetX() < s.getSzer() - 1) && (s.mapa[dest.getY()][dest.GetX() + 1]==null)){
                            dest.setX(dest.GetX() + 1);
                            udalosie = true;
                        }
                        break;

                    case 2:
                        if( (dest.getY() < s.getWys() - 1) &&(s.mapa[dest.getY() + 1][dest.GetX()]==null)){
                            dest.setY(dest.getY() + 1);
                            udalosie = true;
                        }
                        break;

                    case 3:
                        if( (dest.GetX() >= 1) &&(s.mapa[dest.getY()][dest.GetX() - 1]==null)){
                            dest.setX(dest.GetX() - 1);
                            udalosie = true;
                        }
                        break;

                }
            }
        }
        return dest;

    }
}
