package po.projekt2.swiat;

import po.projekt2.organizm.Organizm;

import po.projekt2.organizm.roslina.*;
import po.projekt2.organizm.zwierze.*;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


public class Swiat {
    public Swiat(int szer, int wys, Wyglad w){
        this.wys=wys;
        this.szer=szer;
        this.liczba=(int)(0.4*wys*szer);
        this.tura=0;
        this.mapa =new Organizm[wys][szer];
        this.Ilustracja=w;
        this.komentator = new Komentator(this);
        Czysc();
       UstawOrganizmy();
    }

    public int getSzer() {
        return szer;
    }

    public int getTura() {
        return tura;
    }

    public int getLiczba() {
        return liczba;
    }

    public int getWys() {
        return wys;
    }

    public void setLiczba(int liczba)
    { this.liczba =  (int) 0.4* liczba; }

    public void setSzer(int szer) {
        this.szer = szer;
    }

    public void setTura(int tura) {
        this.tura = tura;
    }

    public void setWys(int wys) {
        this.wys = wys;
    }

    public Wyglad getIlustracja() {
        return Ilustracja;
    }

    public Komentator getKomentator() {
        return komentator;
    }

    public void UstawOrganizmy() {
    Punkt p = new Punkt(getSzer() / 2, getWys() / 2);
    cz = new Czlowiek(this);
    cz.setPozycja(p);
    mapa[cz.getPunkt().getY()][cz.getPunkt().GetX()] = cz;
    int ustaw = 1;
    while (ustaw < liczba) {
            p.losuj(wys, szer);
            if (mapa[p.getY()][p.GetX()] == null) {
                SetOrganizm(p,false, "x");
                ustaw++;
            }
        }
    }
    public void DodajOrganizm(Organizm org)
    {
    Punkt p = org.getPunkt();
    mapa[p.getY()][p.GetX()]=org;
    }

    public Organizm getOrganizm(Punkt p)
    {
        return mapa[p.getY()][p.GetX()];
    }
    public Organizm getOrganizm(int x, int y)
    {
        return mapa[y][x];
    }

    public void SetOrganizm(Punkt p, boolean plik, String znak)
        {
            int ktory=0;
            if(!plik) {
                Random gen = new Random();
                ktory = gen.nextInt(11);
            }
            else if(plik)
            {
                switch (znak) {
                    case "A":
                    { ktory=0; break;}
                    case "C":
                    {ktory = 1 ; break;}
                    case "L":
                    {ktory = 2; break;}
                    case "O":
                    {ktory = 3; break;}
                    case "W":
                    {ktory = 4; break;}
                    case "Z":
                    {ktory = 5; break;}
                    case "B":
                    {ktory = 6; break;}
                    case "G":
                    {ktory = 7; break;}
                    case "J":
                    {ktory = 8; break;}
                    case "M":
                    {ktory = 9; break;}
                    case "T":
                    {ktory = 10; break;}
                }

            }
            switch (ktory)
            {
                case 0: {
                    Antylopa an = new Antylopa(this);
                    an.setPozycja(p);
                    mapa[p.getY()][p.GetX()] = an;
                break;
                }
                case 1: {
                    Cyberowca c = new Cyberowca(this);
                    c.setPozycja(p);
                    mapa[p.getY()][p.GetX()] = c;
                break;
                }
                case 2: {
                        Lis l = new Lis(this);
                        mapa[p.getY()][p.GetX()] = l;
                        l.setPozycja(p);
                        break;
                    }
                case 3: {
                    Owca o = new Owca(this);
                    mapa[p.getY()][p.GetX()] = o;
                    o.setPozycja(p);
                    break;
                }
                case 4: {
                    Wilk w = new Wilk(this);
                    mapa[p.getY()][p.GetX()] = w;
                    w.setPozycja(p);
                    break;
                }
                case 5: {
                    Zolw z = new Zolw(this);
                    mapa[p.getY()][p.GetX()] = z;
                    z.setPozycja(p);
                break;
                }
                case 6: {
                    Barszcz b = new Barszcz(this);
                    mapa[p.getY()][p.GetX()] = b;
                    b.setPozycja(p);
                    break;
                }
                    case 7: {
                        Guarana g = new Guarana(this);
                        mapa[p.getY()][p.GetX()] = g;
                        g.setPozycja(p);
                        break;
                    }
                case 8: {
                    Jagody j = new Jagody(this);
                    mapa[p.getY()][p.GetX()] = j;
                    j.setPozycja(p);
                break;
                }
                case 9: {
                    Mlecz m = new Mlecz(this);
                    mapa[p.getY()][p.GetX()] = m;
                    m.setPozycja(p);
                    break;
                }
                case 10: {
                    Trawa t = new Trawa(this);
                    mapa[p.getY()][p.GetX()] = t;
                    t.setPozycja(p);
                    break;
                }
            }
        }
    public void Czysc()
    {
        for (int w=0; w< wys ;w ++) {
            for (int s = 0; s < szer; s++)
            {
                    mapa[w][s]=null;
            }
        }
    }
    public Punkt laduj() throws FileNotFoundException
    { boolean istnieje = false;
    Scanner scanner = new Scanner(new File("zapis.txt"));
    int wys = scanner.nextInt();
    int szer = scanner.nextInt();
    int tura = scanner.nextInt();
    Punkt s = new Punkt(szer, wys);
    Czysc();
    this.szer=szer;
    this.wys=wys;
    this.liczba=(int)0.4*wys*szer;
    this.tura=tura;
    this.mapa =new Organizm[wys][szer];
    Czysc();
    while(scanner.hasNext())
    {

        int px =scanner.nextInt();
        int py = scanner.nextInt();
        scanner.nextLine();
        String symbol = scanner.nextLine();
        int sila = scanner.nextInt();
        int in = scanner.nextInt();
        int wiek = scanner.nextInt();
        boolean czlowiek = scanner.nextBoolean();
        Punkt p = new Punkt(px, py);
        if(czlowiek)
        {
            cz = new Czlowiek(this);
            cz.setPozycja(p);
            mapa[p.getY()][p.GetX()]=cz;
            int off = scanner.nextInt();
            int on = scanner.nextInt();
            boolean skill= scanner.nextBoolean();
            boolean zywy = scanner.nextBoolean();
            cz.setOff(off);
            cz.setOn(on);
            cz.setSkill(skill);
            cz.setZywy(zywy);
             istnieje = true;

        }
        else
        {
           SetOrganizm(p, true, symbol);

        }
        mapa[p.getY()][p.GetX()].setSila(sila);
        mapa[p.getY()][p.GetX()].setInicjatywa(in);
        mapa[p.getY()][p.GetX()].setWiek(wiek);

    }
        if(!istnieje)
        {
            cz.setZywy(false);
        } komentator.laduj();
                return s;
    }
    public void wykonajTure()
    {
        for (int i = 0; i< wys; i++)
        {
            for (int j = 0; j < szer; j++)
            {
                if(mapa[i][j]!=null)
                {
                    if(mapa[i][j] instanceof Barszcz)
                    {
                        listabarszcz.add((Barszcz)mapa[i][j]);
                    }
                    kolejka.add(mapa[i][j]);
                }
            }
        }
    if(kolejka.size()==1)
    {
        if (kolejka.element() instanceof Czlowiek)
        {
            komentator.Wygrana();
        }

    }

        for(Organizm o : kolejka)
        {
            if(!(o.isUsuniete())) {
                o.Akcja(this);
                o.setWiek(o.getWiek() + 1);
            }
        }



    kolejka.removeAll(kolejka);
    listabarszcz.removeAll(listabarszcz);
    tura++;

    }

    public void zapis()
    {
        File f = new File("zapis.txt");
        if(!(f.exists()))
        {
            try {
                f.createNewFile();
            }
            catch(Exception e)
            {
                komentator.plik();
            }
        }
        try {

            PrintWriter fw = new PrintWriter("zapis.txt");
            komentator.zapis();
            fw.println(wys+" "+szer+" "+tura);
             boolean isczlowiek = false;
           for(int i =0 ; i <wys ; i++) {
               for (int j = 0; j < szer; j++)
               {
                   if (mapa[i][j]!=null)
                   {

                       fw.println(mapa[i][j].getPunkt().GetX()+" "+mapa[i][j].getPunkt().getY());
                       fw.println(mapa[i][j].getSymbol());
                           fw.println(mapa[i][j].getSila()+" "+mapa[i][j].getInicjatywa()+" "+mapa[i][j].getWiek());
                       if (mapa[i][j] instanceof Czlowiek)
                       {
                           isczlowiek=true;
                           fw.println(isczlowiek);
                           fw.println(((Czlowiek)mapa[i][j]).getOff()+" "+((Czlowiek)mapa[i][j]).getOn()+ " "+((Czlowiek)mapa[i][j]).isSkill()+ " " +((Czlowiek)mapa[i][j]).isZywy());
                            isczlowiek=false;
                       }
                       else
                       {
                           fw.println(isczlowiek);
                       }

                   }
               }


           }
            fw.close();
        }catch (Exception e)
        {
            komentator.plik();
        }
        }

    Comparator<Organizm> porownanie = new Comparator<Organizm>()
    {
        @Override
        public int compare(Organizm o1, Organizm o2) {
            if (o1.getInicjatywa() == o2.getInicjatywa()) return ((o2.getWiek() - (o1.getWiek())));
            return (o2.getInicjatywa() - o1.getInicjatywa());
        }
    };


    public Czlowiek cz;
        public Organizm[][] mapa;
        private int szer, wys, liczba, tura;
    private Wyglad Ilustracja;
    private Komentator komentator;
    private PriorityQueue<Organizm> kolejka = new PriorityQueue<>(porownanie);
    public List<Barszcz> listabarszcz = new ArrayList<>();
    }


