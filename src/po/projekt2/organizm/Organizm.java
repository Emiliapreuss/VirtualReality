package po.projekt2.organizm;
import po.projekt2.organizm.zwierze.Czlowiek;
import po.projekt2.swiat.Punkt;
import po.projekt2.swiat.Swiat;

import java.awt.*;
import java.util.Random;

abstract public class Organizm {

    public Organizm(Swiat s) {
        this.s = s;
        this.wiek = 0;
        this.inicjatywa = 0;
        this.sila = 0;
        this.symbol=".";
        this.usuniete=false;
        this.kolor=Color.GRAY;
    }

    public boolean isUsuniete() {
        return usuniete;
    }

    public void setUsuniete(boolean usuniete) {
        this.usuniete = usuniete;
    }

    public int getSila() {
        return this.sila;
    }

    public void setSila(int sila) {
        this.sila = sila;
    }

    public int getInicjatywa() {
        return this.inicjatywa;
    }

    public void setInicjatywa(int ini) {
        this.inicjatywa = ini;
    }

    public int getWiek() {
        return this.wiek;
    }

    public void setWiek(int w) {
        this.wiek = w;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Color getKolor() {
        return kolor;
    }

    public void setKolor(Color kolor) {
        this.kolor = kolor;
    }

    public Punkt getPunkt() {
        return polozenie;
    }

    public void setPozycja(int x, int y) {
        polozenie = new Punkt(x, y);
    }

    public void setPozycja(Punkt p)
    {
        polozenie = new Punkt(p.GetX(), p.getY());

    }

    public void usunOrganizm(Swiat s)
    {
        s.mapa[polozenie.getY()][polozenie.GetX()].setUsuniete(true);
    s.mapa[polozenie.getY()][polozenie.GetX()]=null;
    }
    public abstract void Akcja(Swiat swiat);
    public abstract void Kolizja(Swiat swiat, Organizm drugi);
    public abstract Punkt SzukajMiejsca();
    public abstract String Wypisz();

protected int sila, wiek, inicjatywa;
protected Swiat s;
protected Punkt polozenie;
    protected Color kolor;
    protected String symbol;
   protected  boolean usuniete;

}

