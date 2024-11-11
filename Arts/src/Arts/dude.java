package Arts;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;

class dude extends Thing {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int rightEdge = 825;
	m M =new m();
    ArrayList < Thing > inventory = new ArrayList < Thing > ();
    String God = "";
    String Place = "Halekshelil";
    int prioryLVL = 0;
    int guardLVL = 0;
    char gender = '⚲';
    int dosh = 0;
    int alignment=0;
    
    //Atributes
    stat Str = new stat("Str", 1, 1, 10, 0);
    stat Dex = new stat("Dex", 1, 1, 10, 0);
    stat Con = new stat("Con", 1, 1, 10, 0);
    stat Int = new stat("Int", 1, 1, 10, 0);
    stat Wis = new stat("Wis", 1, 1, 10, 0);
    stat Pow = new stat("Pow", 1, 1, 10, 0);
    dude(char P, int x, int y) {
        this.P = P;
        this.x = x;
        this.y = y;
        this.C = Color.white;
        this.BC = new Color(0,0,0,0);
        this.name = "";
    }
    public String toString()
      {
        return ( name+" "+God+" "+Place+" "+prioryLVL+" "+guardLVL+" "+(int)gender+" "+dosh+" "+alignment+" "+Str+" "+Dex+" "+Con+" "+Int+" "+Wis+" "+Pow);
       }
    public void show(Graphics g) {
    	
    	  g.setColor(BC);
		   g.fillRect(20+x*20, 40+y*20, 20, 20);  
		   g.setColor(C);
		   g.drawString(""+P,x*20+20,y*20+55);
    	g.setColor(Color.WHITE);
        g.drawString(dosh + "￠", rightEdge, 100);
        g.setFont(Arts.Symbola);
        g.drawString("Inventory", rightEdge, 125);
        int a = 0;
        for (Thing I: inventory) {
            int n = (int)('➀');
            g.drawString((char)(n + a + 10) + " " + I.name, rightEdge, 150 + 25 * a++);
        }
        a = 0;

        g.drawString("Items here", rightEdge, 375);
        Arts.ThingsHere.clear();
        for (Thing i: Arts.Map.items) {
            if (i.x == x && i.y == y) {
            	 Arts.ThingsHere.add(i);
                int n = (int)('①');
                g.drawString((char)(n + a) + " " + i.name, rightEdge, 400 + 25 * a++);
            }
        }
        String desc = name;
        if (gender != '⚲') desc = gender + desc;
        if (prioryLVL > 0) desc = "Catechumen " + desc;
        if (God == "") desc += " The Godless";
        else
            desc += " of " + God;
        desc += " in " + Place;
       
        g.drawString(desc, 10, 20);
        String stats = Str.show() + Dex.show() + Con.show() + Int.show() + Wis.show() + Pow.show();
        g.drawString(stats, 20, 855);
    }
void sleep(){
     Str.sleep();
     Dex.sleep();
     Con.sleep();
     Int.sleep();
     Wis.sleep();
     Pow.sleep();
   }
public void move(int i, int j) {
	// this is where you bump into stuff
	if(Arts.mode == "move") {
	if(!Arts.Map.at(i+x,j+y).block) {
	x+=i;
	y+=j;
	}
	Arts.Map.see(x,y);
	}
}
}

class stat implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	m M =new m();
    String name = "";
    int cur = 0;
    int norm = 0;
    int max = 0;
    int train = 0;
    stat(String name, int cur, int norm, int max, int train) {
        this.name = name;
        this.cur =cur;
        this.norm = norm;
        this.max = max;
        this.train = train;
    }
    String show() {
        String out = name + " ";
        for (int i = 0; i < max; i++) {
            if (cur > i)
                if (train > i)
                    out += ":";
                else
                    out += ".";
        }
        out += " ";
        return out;
    }
    boolean test(int dif) {
        if (M.rand(10) < cur-dif) return true;
        train++;
        return false;
    }
    void sleep(){
        if(train>=cur && cur<max){cur++;train=0;}
    }
    public String toString(){
                   return (cur+" "+norm+" "+max+" "+train);
                   }
}
