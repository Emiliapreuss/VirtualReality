package po.projekt2.organizm.zwierze;


import po.projekt2.organizm.roslina.Barszcz;
import po.projekt2.swiat.Punkt;
import po.projekt2.swiat.Swiat;

import java.awt.*;

public class Cyberowca extends Owca{
    public Cyberowca(Swiat s)
    {
        super(s);
        sila=11;
        symbol="C";
        kolor = new Color(194, 162, 162);
        odleglosc=-1;
    }
    @Override
    public String Wypisz()
    {
        return "CYBEROWCA";
    }
    @Override
    public void Akcja(Swiat s)
    {
        Punkt p ;
        if(s.listabarszcz.size()!=0) {
            for (Barszcz b : s.listabarszcz)
            {
              int x = b.getPunkt().GetX() - getPunkt().GetX();
              if(x<0)
              {
                  x = -x;
              }
              int y = b.getPunkt().getY() - getPunkt().getY();
                if(y<0)
                {
                    y = -y;
                }
                int odl = x + y;
                if( odl<odleglosc || odleglosc== -1)
                {
                    odleglosc = odl;
                    barszcz = new Punkt(b.getPunkt().GetX(), b.getPunkt().getY());
                }
            }
            odleglosc = -1;

            if(barszcz.GetX()>getPunkt().GetX())
            {
                p = new Punkt(getPunkt().GetX()+1, getPunkt().getY());
                setCel(p);
                Decyduj(s.mapa[p.getY()][p.GetX()], s);
            }
            else if(barszcz.GetX()<getPunkt().GetX())
            {
                p= new Punkt(getPunkt().GetX()-1, getPunkt().getY());
                setCel(p);
                Decyduj(s.mapa[p.getY()][p.GetX()], s);
            }
            else if(barszcz.GetX()==getPunkt().GetX())
            {
                if(barszcz.getY()>getPunkt().getY())
                {
                    p = new Punkt(getPunkt().GetX(), getPunkt().getY()+1);
                    setCel(p);
                    Decyduj(s.mapa[p.getY()][p.GetX()], s);
                }
                else if(barszcz.getY()<getPunkt().getY())
                {
                    p= new Punkt(getPunkt().GetX(), getPunkt().getY()-1);
                    setCel(p);
                    Decyduj(s.mapa[p.getY()][p.GetX()], s);
                }
            }


        }
        else{
                p  = SzukajMiejsca();
                if (p.GetX()!=getPunkt().GetX() || p.getY()!=getPunkt().getY()) {
                setCel(p);
                Decyduj(s.mapa[p.getY()][p.GetX()], s);

            }
        }
    }
    private Punkt barszcz;
    private int odleglosc;
}
