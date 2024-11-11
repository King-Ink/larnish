package Arts;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public class Thing implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	m M =new m();
	
	String name = "";
	String text = "";
	char P = ' ';
	int x=0;
	int y=0;
	int dij = 0;
	Color BC = new Color(0,M.rand(200),0);
	Color C = new Color(0,0,0);
	boolean block = false;
	boolean hidden=true;
	boolean destroyed=false;
	boolean auto = false;

	public int altitude;
	public Thing() {};
	public Thing(int x,int y) {
		this.x=x;
		this.y=y;
		Arts.Map.set(x,y,this);
	}
	void over(){
		 Arts.Print(name);
	 }
		
	@Override
	public String toString() {
	    return this.getClass()+","+name + "," + P + "," + x + "," + y + "," + BC + "," + C + "," + block+","+hidden;
//	               0              1           2         3         4         5          6          7          8

	}


	public void act(){
	  Arts.aPrint("You mess with the "+ name +"... interesting");
	 }

	public void interact(Graphics g){

	}
	

	public void show(Graphics g) {
		if(!hidden) {
		   g.setColor(BC);
		   g.fillRect(20+x*20, 40+y*20, 20, 20);  
		   g.setColor(C);
		   if(Arts.Monospaced.canDisplay(P))g.setFont(Arts.Monospaced);
		   else
		   if(Arts.Symbola.canDisplay(P))g.setFont(Arts.Symbola);
		   else
		   if(Arts.Teki.canDisplay(P))g.setFont(Arts.Teki);
		   
		   g.drawString(""+P,x*20+22,y*20+56);
		}
	}
	public void choose(int key) {
		// TODO Auto-generated method stub
		
	}
	

}
