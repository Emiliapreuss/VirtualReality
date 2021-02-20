package po.projekt2.swiat;


import java.util.Random;

public class Punkt {
    public Punkt(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    public int GetX()
    {
        return this.x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }
    public void losuj(int w, int s)
    {

        Random generator = new Random();

            this.x = generator.nextInt(s);

            this.y = generator.nextInt(w);

    }
    private int x,y;
}
