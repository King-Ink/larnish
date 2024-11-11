package Arts;

import java.awt.Color;
import java.awt.Graphics;

class evidence extends Thing{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	evidence(int x, int y){
	    this.name = "evidence";
	    this.x=x;
	    this.y=y;
	  this.P=' ';
	   this.C = Color.BLACK;
	   this.BC= Color.GRAY;
	   Arts.Map.set(x,y,this);
	  }
	  
	  public void act(){
	    Arts.aPrint("Okay what do Arts.you got?");
	    Arts.you.Place = name;
	    Arts.mode = "interact";
	 }
	  
	  public void interact(Graphics g){
	   g.setColor(Color.GRAY);
	  g.fillRect(215,215,375,195);
//	  noStroke();
	  g.setColor(Color.BLACK);
//	  textSize(20);
	  g.drawString("tap the number of the thing Arts.you want to turn in * to leave",215,215);
	  
	  }

	public void choose(char A)
	  {
	    if(A-49<Arts.you.inventory.size() && A-49 >= 0)
	               {
	               //Thing d = Arts.you.inventory.get(A-49);
	               Arts.you.inventory.remove(A-49);
	               }
	  //  if (A== '*'){Arts.mode="move"; Arts.you.Place = "Halekshelil";Arts.Map.data[x][y+1].block=false;  drawIt();return;}
	  }
	}