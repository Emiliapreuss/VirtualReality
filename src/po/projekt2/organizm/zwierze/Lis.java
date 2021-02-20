package po.projekt2.organizm.zwierze;

import po.projekt2.organizm.Organizm;
import po.projekt2.swiat.Punkt;
import po.projekt2.swiat.Swiat;

import java.awt.*;

public class Lis extends Zwierzeta {
    public Lis(Swiat s)
    {
        super(s);
        sila=3;
        inicjatywa=7;
        symbol="L";
        kolor = new Color(219, 56, 7, 191);
    }
    @Override
    public String Wypisz()
    {
        return "LIS";
    }
@Override
    public void Akcja(Swiat s)
{
    Punkt p=SzukajMiejsca();
    if(p.GetX()!=getPunkt().GetX() || p.getY() != getPunkt().getY())
    {

        setCel(p);

        if ((s.mapa[getCel().getY()][getCel().GetX()] == null) || (s.mapa[getCel().getY()][getCel().GetX()].getSila() <= getSila()))
        {
            Decyduj(s.mapa[getCel().getY()][getCel().GetX()], s);
        }
        else
        {
            s.getKomentator().lis();
        }


    }


    }
@Override
    public void Dzieci(Swiat s, Organizm org2)
{
    Lis lis = new Lis(s);
    Punkt p=SzukajMiejsca();
    if (!(s.mapa[p.getY()][p.GetX()] instanceof Lis))
    {
        if (s.mapa[p.getY()][p.GetX()]==null)
        {
            s.getKomentator().rozmnozenie(Wypisz(),'r');
            lis.setPozycja(p);
            s.DodajOrganizm(lis);
        }
        else if (s.mapa[p.getY()][p.GetX()] != null && s.mapa[p.getY()][p.GetX()].getSila() < lis.getSila())
        {
            s.getKomentator().rozmnozenie(Wypisz(),'p');
            s.mapa[p.getY()][p.GetX()].usunOrganizm(s);
            lis.setPozycja(p);
            s.DodajOrganizm(lis);
        }
        else
        {
            s.getKomentator().rozmnozenie(Wypisz(),'s');
        }
    }
    else
    {
        p=org2.SzukajMiejsca();
        if (!(s.mapa[p.getY()][p.GetX()] instanceof Lis))
        {
            if (s.mapa[p.getY()][p.GetX()]==null)
            {
                s.getKomentator().rozmnozenie(Wypisz(),'r');
                lis.setPozycja(p);
                s.DodajOrganizm(lis);
            }
            else if (s.mapa[p.getY()][p.GetX()] != null && s.mapa[p.getY()][p.GetX()].getSila() < lis.getSila())
            {
                s.getKomentator().rozmnozenie(Wypisz(),'p');
                s.mapa[p.getY()][p.GetX()].usunOrganizm(s);
                lis.setPozycja(p);
                s.DodajOrganizm(lis);
            }
            else
                {
                    s.getKomentator().rozmnozenie(Wypisz(),'s');
                }
        }
    }
}

}
