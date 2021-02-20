package po.projekt2.swiat;

import javax.swing.*;
import java.awt.*;

public class Plansza extends JPanel {

    public Plansza( Swiat s ,int x, int y)
    {
        this.x=x;
        this.y=y;
        this.s=s;
        setPlansza();
    }


    public void setPlansza()
    {

        GridLayout lay = new GridLayout(y,x);
        setLayout(lay);
        przyciski = new JButton[y][x];
        for (int w = 0; w< y ; w++)
        {
            for (int sz=0; sz<x; sz++)
            {
                przyciski[w][sz]= new JButton();
                przyciski[w][sz].setBackground(Color.GRAY);
                przyciski[w][sz].setMinimumSize(new Dimension(50,50));
                add(przyciski[w][sz]);
            }

        }

    }



    void Rysuj()
    {
        setBorder(BorderFactory.createTitledBorder("Tura: "+s.getTura()));
        for (int w = 0; w< y ; w++) {
            for (int sz = 0; sz < x; sz++)
            {
                if (s.getOrganizm(sz, w) == null) {
                przyciski[w][sz].setText("");
                przyciski[w][sz].setBackground(Color.GRAY);
            } else {
                przyciski[w][sz].setText(s.getOrganizm(sz, w ).getSymbol());
                przyciski[w][sz].setBackground(s.getOrganizm(sz, w).getKolor());
            }

            }
        }
    }
    private int x,y;

    private JButton[][] przyciski;
         private Swiat s;

}
