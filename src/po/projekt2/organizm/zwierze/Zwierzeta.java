package po.projekt2.organizm.zwierze;
import po.projekt2.swiat.Punkt;
import po.projekt2.organizm.Organizm;
import po.projekt2.swiat.Swiat;

import java.awt.*;
import java.util.Random;
import java.util.Vector;
public abstract class Zwierzeta extends Organizm{
public Zwierzeta(Swiat s)
{
    super(s);
    cel = new Punkt(0,0);
}

    public Punkt getCel() {
        return cel;
    }

    public void setCel(Punkt cel) {
        this.cel = cel;
    }
    public void Decyduj(Organizm org2, Swiat s) {
        if (org2 == null) {
            Przesun(s);
        } else if (org2 != null && org2.getInicjatywa() == 0) {
            org2.Kolizja(s, this);
        } else {
          if  (org2.getClass().getSimpleName().equals(getClass().getSimpleName())) {
          Dzieci(s, org2);
          }
          else
          {
            org2.Kolizja(s, this);
          }


        }
    }
    public void Przesun(Swiat s)
    {
        s.mapa[getCel().getY()][getCel().GetX()]=this;
        s.mapa[getPunkt().getY()][getPunkt().GetX()]=null;
        setPozycja(getCel());

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
            s.getKomentator().pokonanie(Wypisz(), drugi.Wypisz());
            usunOrganizm(s);
            if (drugi instanceof Zwierzeta)
            {
                ((Zwierzeta) drugi).Przesun(s);
            }

        }
    }
    @Override
    public void Akcja(Swiat swiat)
    {
        Punkt p  = SzukajMiejsca();
        if (p.GetX()!=getPunkt().GetX() || p.getY()!=getPunkt().getY())
        {
            setCel(p);
        Decyduj(swiat.mapa[p.getY()][p.GetX()], swiat);
}
    }

    @Override
    public Punkt SzukajMiejsca() {
       Random generator = new Random();
       boolean udalosie = false;
       int los;
       Punkt dest = new Punkt (getPunkt().GetX(), getPunkt().getY());
       for (int i = 0; i <10 ; i++)
       {
           if(!udalosie)
           {
               los = generator.nextInt(4);
               switch(los){
                   case 0:
                       if (dest.getY()>=1)
                       {
                           dest.setY(dest.getY()-1);
                           udalosie=true;
                       }
                       break;
                   case 1:
                       if (dest.GetX() < s.getSzer() - 1) {
                           dest.setX(dest.GetX() + 1);
                           udalosie = true;
                       }
                       break;

                   case 2:
                       if (dest.getY() < s.getWys() - 1) {
                           dest.setY(dest.getY() + 1);
                           udalosie = true;
                       }
                       break;

                   case 3://3
                       if (dest.GetX() >= 1) {
                           dest.setX(dest.GetX() - 1);
                           udalosie = true;
                       }
                       break;


               }

           }

       }
       return dest;
    }

public abstract void Dzieci(Swiat s, Organizm org2);

    protected Punkt cel;


}
