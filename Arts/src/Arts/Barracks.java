package Arts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Barracks extends Thing{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Barracks(String name, char P, int x, int y, Color C, Color BC) {
		   this.name = name;
		   this.P = P;
		   this.x = x;
		   this.y = y;
		   this.C = C;
		   this.BC= BC;
		   Arts.Map.set(x,y,this);
		 }
		  public void act(){
		    Arts.aPrint("You enter the Barracks. It smells like leather and balls");
		    Arts.you.Place = name;
		    //Arts.place = "barracks"; 
		    Arts.Map.make("barracks");
		    Arts.Map.see(Arts.you.x,Arts.you.y);
		 }
		  
		 public void interact(Graphics g){
		  g.setColor(new Color(100,100,100));
		  g.fillRect(215,215,375,195);
		  g.setColor(Color.WHITE);
		  int Y =0; 
		  int n = (int)('①'); 
		  g.drawString("What ya want?, punk",405,230+(Y++)*20);
		 // textAlign(LEFT, CENTER);
		  g.drawString((char)(n+Y-1)+" report a crime",235,230+(Y++)*30);
		  g.drawString((char)(n+Y-1)+" turn in evidence",235,230+(Y++)*30);
		  g.drawString((char)(n+Y-1)+" Join up",235,230+(Y++)*30);
		  g.drawString((char)(n+Y-1)+" Talk to the Justicar",235,230+(Y++)*30);
		  g.drawString((char)(n+Y-1)+" Leave",235,230+(Y++)*30);
		  choose(Arts.key);
		 }
		 
		 public void choose(int A)
		  {
		    switch(A){
		       case KeyEvent.VK_NUMPAD1:Arts.aPrint("The Clerk barely pretends to write it down ");break;
		       case KeyEvent.VK_NUMPAD2:Arts.aPrint("The Clerk takes Arts.you to the evidence desk");Arts.you.x = x-2;Arts.you.y=y-1;Arts.here().act();break; 
		       case KeyEvent.VK_NUMPAD3:Arts.aPrint("you join the accademy");Arts.you.guardLVL++; break; 
		       case KeyEvent.VK_NUMPAD4:Arts.aPrint("Anthony the Abbot complains about the ants"); break;
		       case KeyEvent.VK_NUMPAD5:Arts.aPrint("you leave"); Arts.you.Place = "Halekshelil"; Arts.mode="move";   break;  
		    }
		  }

}

