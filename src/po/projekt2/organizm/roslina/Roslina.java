package po.projekt2.organizm.roslina;

import po.projekt2.organizm.Organizm;
import po.projekt2.organizm.zwierze.Zwierzeta;
import po.projekt2.swiat.Punkt;
import po.projekt2.swiat.Swiat;

import java.util.Random;

public abstract class Roslina extends Organizm{
   public Roslina(Swiat s)
    {
       super(s);
       prawd=0.3;
    }

    public double getPrawd() {
        return prawd;
    }

    public void setPrawd(double prawd) {
        this.prawd = prawd;
    }

    @Override
    public Punkt SzukajMiejsca() {
        Random generator = new Random();
        boolean udalosie = false;
        boolean udalo = false;
        int los;
        Punkt dest = new Punkt ( getPunkt().GetX(), getPunkt().getY());
        for (int i = 0; i < 10; i++) {
            if (!udalosie) {
                los = generator.nextInt(4);
                switch(los)
                {
                case 0:
                    if (dest.getY() >= 1) {
                        dest.setY(dest.getY() - 1);
                        udalo = true;
                    }
                    break;

                    case 1:
                    if (dest.GetX() < s.getSzer() - 1) {
                        dest.setX(dest.GetX() + 1);
                        udalo = true;
                    }
                    break;

                    case 2:
                    if (dest.getY() < s.getWys() - 1) {
                        dest.setY(dest.getY() + 1);
                        udalo = true;
                    }
                    break;

                    case 3:
                    if (dest.GetX() >= 1) {
                        dest.setX(dest.GetX() - 1);
                        udalo = true;
                    }
                    break;

            }
            if (udalo == true)
            {
                if (s.mapa[dest.getY()][dest.GetX()] == null)
                {
                    udalosie = true;
                }
                else
                {
                    dest.setX(getPunkt().GetX());
                    dest.setY(getPunkt().getY());
                    udalo = false;
                }
            }


            }
        }
        return dest;
    }
    @Override
    public void Akcja(Swiat s)
    {
        Random gen = new Random();

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
    @Override
    public void Kolizja(Swiat s, Organizm org2)
    {
        if(getSila()>org2.getSila())
        {
            s.getKomentator().pokonanie(org2.Wypisz(),Wypisz());
            org2.usunOrganizm(s);
        }
        else
            s.getKomentator().pokonanie(Wypisz(), org2.Wypisz());
            usunOrganizm(s);
        if (org2 instanceof Zwierzeta)
        {
            ((Zwierzeta) org2).Przesun(s);
        }

    }

    public abstract  void Siej(Swiat s, Punkt cel);
    protected double prawd;
}
