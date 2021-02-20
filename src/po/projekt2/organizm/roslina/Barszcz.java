package po.projekt2.organizm.roslina;

import po.projekt2.organizm.Organizm;
import po.projekt2.organizm.zwierze.Zwierzeta;
import po.projekt2.swiat.Punkt;
import po.projekt2.swiat.Swiat;

import java.awt.*;
import java.util.Random;

public class Barszcz extends Roslina{
public Barszcz(Swiat s) {
    super(s);
    sila = 10;
    prawd = 0.2;
    symbol="B";
    kolor= new Color(0,102,0);
}
@Override
public String Wypisz()
{
    return "BARSZCZ SOSNOWSKIEGO";
}
@Override
    public void Akcja(Swiat s)
{
    Punkt p = getPunkt();
    if (p.GetX() - 1 >= 0 && p.GetX() <= s.getSzer() )
    {
        if(s.mapa[p.getY()][p.GetX() - 1]!=null)
        {
            if(!(s.mapa[p.getY()][p.GetX() - 1].getSymbol()=="C")) {
                if (s.mapa[p.getY()][p.GetX() - 1] instanceof Zwierzeta) {
                    s.getKomentator().Barszcz(s.mapa[p.getY()][p.GetX() - 1].Wypisz(), Wypisz() );
                    s.mapa[p.getY()][p.GetX() - 1].usunOrganizm(s);
                }
            }
        }

    }
    if (p.GetX() + 1 >= 0 && p.GetX() + 1 < s.getSzer() )
    {
        if ( s.mapa[p.getY()][p.GetX() + 1]!=null)
        {
            if(!(s.mapa[p.getY()][p.GetX() + 1].getSymbol()=="C"))
            {
                if (s.mapa[p.getY()][p.GetX() + 1] instanceof Zwierzeta) {
                    s.getKomentator().Barszcz(s.mapa[p.getY()][p.GetX() + 1].Wypisz(), Wypisz() );
                    s.mapa[p.getY()][p.GetX() + 1].usunOrganizm(s);
                }
            }
        }

    }
    if (p.getY() - 1 >= 0 && p.getY()  <= s.getWys() )
    {
        if(s.mapa[p.getY() - 1][p.GetX()] != null)
        {
            if(!(s.mapa[p.getY() - 1][p.GetX()].getSymbol()=="C")) {
                if (s.mapa[p.getY() - 1][p.GetX()] instanceof Zwierzeta) {
                    s.getKomentator().Barszcz(s.mapa[p.getY()- 1][p.GetX() ].Wypisz(), Wypisz() );
                    s.mapa[p.getY() - 1][p.GetX()].usunOrganizm(s);
                }
            }
            }
    }
    if (p.getY() + 1 >= 0 && p.getY() + 1 < s.getWys() )
    {
        if(s.mapa[p.getY() + 1][p.GetX()]!=null) {
            if (!(s.mapa[p.getY() + 1][p.GetX()].getSymbol() == "C")) {
                if (s.mapa[p.getY() + 1][p.GetX()] instanceof Zwierzeta) {
                    s.getKomentator().Barszcz(s.mapa[p.getY() + 1][p.GetX()].Wypisz(), Wypisz());
                    s.mapa[p.getY() + 1][p.GetX()].usunOrganizm(s);
                }
            }
        }
    }
    Random gen = new Random();

    double los = gen.nextDouble();
    if (los < getPrawd())
    {
        Punkt cel = SzukajMiejsca();
        if (cel.GetX()!=getPunkt().GetX() || cel.getY()!=getPunkt().getY())
        {
            Siej(s,cel);
        }
    }
}
@Override
public void Siej(Swiat s, Punkt cel)
{
    s.getKomentator().sianie(Wypisz());
    Barszcz barszcz = new Barszcz(s);
    barszcz.setPozycja(cel);
    s.DodajOrganizm(barszcz);

}
@Override
    public void Kolizja(Swiat s, Organizm org2)
{
    if(org2 instanceof Zwierzeta)
    {
        if(!(org2.getSymbol()=="C")) {
            s.getKomentator().pokonanie(org2.Wypisz(),Wypisz());
            org2.usunOrganizm(s);

        }
        else
        {
            s.getKomentator().pokonanie(Wypisz(),org2.Wypisz());
            usunOrganizm(s);
        }
    }

}

}
