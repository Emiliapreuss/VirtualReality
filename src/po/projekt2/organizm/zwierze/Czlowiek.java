package po.projekt2.organizm.zwierze;

import po.projekt2.organizm.Organizm;
import po.projekt2.swiat.Punkt;
import po.projekt2.swiat.Swiat;

import java.awt.*;
import java.util.Random;

public class Czlowiek extends Zwierzeta {
   public Czlowiek(Swiat s)
   {
       super(s);
       sila = 5;
       inicjatywa = 4;
       Punkt p = new Punkt(s.getSzer() / 2, s.getWys() / 2);
       setPozycja(p);
       on = 0;
       off = 0;
       zywy =true;
       skill = false;
       wcisniete = false;
       symbol="@";
       kolor=new Color(153, 107, 14);
       kierunek = -1;
   }

    public boolean isSkill() {
        return skill;
    }

    public boolean isWcisniete() {
        return wcisniete;
    }

    public boolean isZywy() {
        return zywy;
    }

    public int getOff() {
        return off;
    }

    public int getOn() {
        return on;
    }

    public void setOff(int off) {
        this.off = off;
    }

    public void setOn(int on) {
        this.on = on;
    }

    public void setSkill(boolean skill) {
        this.skill = skill;
    }

    public int getKierunek() {
        return kierunek;
    }

    public void setKierunek(int kierunek) {
        this.kierunek = kierunek;
    }

    public void setWcisniete(boolean wcisniete) {

       if(on==0 && skill==false) {
           this.wcisniete = wcisniete;
       }
    }

    public void setZywy(boolean zywy) {

       this.zywy=zywy;
    }
    public void Skill()
    {
        if (on>0)
        {
            s.getKomentator().aktywna(on);
        }
        else if(off>0)
        {
            s.getKomentator().nieaktywna(off);
        }
        else if(on==0 && wcisniete==false)
        {
            s.getKomentator().aktywowana();
            setWcisniete(true);
            SkillChange();
        }


    }
    public void SkillChange()
    {
        if(on>0)
        {
            on--;
            if(on==0)
            {
                skill=false;
                off=5;
                wcisniete=false;
            }
        }
        else if(off>0)
        {
            off--;
        }
        else if(wcisniete==true)
        {
            wcisniete = false;
            on = 5;
            skill=true;
        }

    }
  private void Ruch(int ile)
  {

          if(kierunek==-1)
          {
              s.getKomentator().czlowiekruch();
          }

              switch (kierunek) {
                  case 0:
                      if (getPunkt().getY() >= ile) {
                          cel.setX(getPunkt().GetX());
                          cel.setY(getPunkt().getY() - ile); //UP
                          kierunek = -1;

                      }
                      break;

                  case 1:
                      if (getPunkt().GetX() < s.getSzer()  - ile) {
                          cel.setX(getPunkt().GetX() + ile);
                          cel.setY(getPunkt().getY()); //RIGHT
                          kierunek = -1;

                      }
                      break;

                  case 2:
                      if (getPunkt().getY() < s.getWys()  - ile) {
                          cel.setX(getPunkt().GetX());
                          cel.setY(getPunkt().getY() + ile); //DOWN
                          kierunek = -1;

                      }
                      break;
                  case 3:
                      if (getPunkt().GetX() >= ile) {
                          cel.setX(getPunkt().GetX() - ile);
                          cel.setY(getPunkt().getY()); //LEFT
                          kierunek = -1;
                      }
                      break;
                  default: {
                      cel.setX(getPunkt().GetX());
                      cel.setY(getPunkt().getY());
                  }


              }

      }


    @Override
    public String Wypisz()
    {
        return "CZLOWIEK";
    }
@Override
public void Dzieci(Swiat s, Organizm org2)
{
}
    @Override
    public void Akcja(Swiat swiat) {
        int a = 1;
        if (on>2)
        {
            a=2;
        }
        else if (on>0)
        {
            Random gen = new Random();
            a=gen.nextInt(2);
            a+=1;
        }
        Ruch(a);
        Decyduj(s.mapa[cel.getY()][cel.GetX()], s);
        SkillChange();
   }

@Override
public void usunOrganizm(Swiat s)
{
    setZywy(false);
    s.getKomentator().Przegrana();
    s.mapa[polozenie.getY()][polozenie.GetX()].setUsuniete(true);
    s.mapa[polozenie.getY()][polozenie.GetX()]=null;

}

    private boolean zywy, skill, wcisniete;
   private int on, off, kierunek;
}
