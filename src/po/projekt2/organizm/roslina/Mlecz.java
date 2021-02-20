package po.projekt2.organizm.roslina;

import po.projekt2.swiat.Punkt;
import po.projekt2.swiat.Swiat;

import java.awt.*;
import java.util.Random;

public class Mlecz extends Roslina {
    public Mlecz(Swiat s)
    {
        super(s);
        prawd=0.5;
        symbol="M";
        kolor = new Color(250,150,0);
    }
    @Override
    public String Wypisz()
    {
        return "MLECZ";
    }
    @Override
    public void Akcja(Swiat s)
    {
        Random gen = new Random();
        for(int i = 0; i< 3; i++)
        {
        double los = gen.nextDouble();
        if (los< getPrawd())
        {
            Punkt cel = SzukajMiejsca();
            if (cel.GetX()!=getPunkt().GetX() || cel.getY()!=getPunkt().getY())
            {
                Siej(s,cel);
            }
        }
        }
    }
    @Override
    public void Siej(Swiat s, Punkt p)
    {
        s.getKomentator().sianie(Wypisz());
        Mlecz m = new Mlecz(s);
        m.setPozycja(p);
        s.DodajOrganizm(m);
    }

}
