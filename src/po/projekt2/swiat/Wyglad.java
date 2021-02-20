package po.projekt2.swiat;

import po.projekt2.organizm.zwierze.Czlowiek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

public class Wyglad extends JFrame implements KeyEventDispatcher {


    public Wyglad() {
        super("Emilia Preuss - 180157");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(10, 10, 1500, 1000);
        setVisible(true);
        setFocusable(true);
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(this);
        requestFocus();

    }

    public void utworz() {
        JButton nowa = new JButton("Nowa gra");
        nowa.setBounds(30,30,150,150);
        add(nowa, BorderLayout.CENTER);
        nowa.setVisible(true);

        nowa.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed (ActionEvent e){
            getContentPane().removeAll();
            repaint();
            JTextField w1 = new JTextField();
            JTextField w2 = new JTextField();
            w1.setBorder(BorderFactory.createTitledBorder("x"));
            w2.setBorder(BorderFactory.createTitledBorder("y"));

            JButton ustaw = new JButton("Wprowadz wymiary planszy");
            ustaw.setBounds(30, 200, 200, 150);
            w1.setBounds(100, 30, 150, 50);
            w2.setBounds(300, 30, 150, 50);
            add(ustaw);
            add(w1);
            add(w2);
            ustaw.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    szero = Integer.parseInt(w1.getText());
                    wyso = (Integer.parseInt(w2.getText()));

                   ustawprzyciski(0);
                }
            });

        }
    });

    setVisible(true);

}
    private void ustawprzyciski(int x)
    {
        if(x==0) {
            swiat = new Swiat(szero, wyso, this);
        }
        plansza = new Plansza(swiat, szero, wyso);

        getContentPane().removeAll();
        repaint();

        plansza.Rysuj();
        plansza.setBounds(30,100 , 50*szero + 50, 50*wyso +50 );
        add(plansza, BorderLayout.CENTER);
        plansza.setVisible(true);

       JButton tura = new JButton("Nowa Tura");
      tura.setBounds(30, 30, 150 ,50);
     add(tura, BorderLayout.CENTER);
     tura.setVisible(true);
     tura.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {


        Tura(swiat);


    }
        });
        JButton skill= new JButton("Umiejetnosc");
        skill.setBounds(200,30, 150, 50);
        add(skill, BorderLayout.CENTER);
        skill.setVisible(true);
        skill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            { if (swiat.cz.isZywy()) {
                swiat.cz.Skill();
            }else
            {
                    swiat.getKomentator().niezyje();
            }
            }
        });
        JButton Zapisz = new JButton("Zapisz stan gry");
        Zapisz.setBounds(380,30,150,50);
        add(Zapisz, BorderLayout.CENTER);
        Zapisz.setVisible(true);
        Zapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zapisz();
            }
        });
        JButton laduj = new JButton("Zaladuj");
        laduj.setBounds(560,30,150,50);
        add(laduj, BorderLayout.CENTER);
        laduj.setVisible(true);
        laduj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zaladuj();
            }
        });
        JButton wyjdz = new JButton("Wyjdz");
        wyjdz.setBounds(740,30,150,50);
        add(wyjdz, BorderLayout.CENTER);
        wyjdz.setVisible(true);
        wyjdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        komentarze = new JTextArea();
        koment = new JScrollPane(komentarze);
        koment.setBounds(51*szero+100,  100, 600, wyso*50);
        add(koment);
        koment.setVisible(true);

         }

        public void Tura(Swiat s)
        {

            komentarze.setText("");
            swiat.wykonajTure();
            plansza.Rysuj();
            plansza.revalidate();
            plansza.repaint();


        }
        public void zapisz()
        {
            swiat.zapis();
        }
        public void zaladuj()
        {   try
            {

                Punkt s = swiat.laduj();
               szero = s.GetX();
                wyso=s.getY();
                ustawprzyciski(1);


            }
            catch(FileNotFoundException ex)
            {
                ex.printStackTrace();
            }
        }
        public void dodajKomentarz(String tekst)
        {
            komentarze.append(tekst);
        }




    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {

           int kierunek = e.getKeyCode();
           switch (kierunek) {
               case KeyEvent.VK_UP: {
                   if(swiat.cz.isZywy()) {
                       swiat.cz.setKierunek(0);
                   }
                   break;
               }
               case KeyEvent.VK_RIGHT: {
                   if(swiat.cz.isZywy()) {
                       swiat.cz.setKierunek(1);
                   }
                   break;
               }
               case KeyEvent.VK_DOWN: {
                   if(swiat.cz.isZywy())
                   {
                   swiat.cz.setKierunek(2);
                   }
                   break;
               }
               case KeyEvent.VK_LEFT: {
                   if(swiat.cz.isZywy()) {
                       swiat.cz.setKierunek(3);
                   }
                   break;
               }


           }

        return false;
    }
    private Plansza plansza;
    private int wyso,szero;
    private Swiat swiat;
    private JTextArea komentarze;
    private JScrollPane koment;

}
