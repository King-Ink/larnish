package Arts;

import java.awt.Color;

class WC extends Thing{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
	 * 
	 */

WC(int x, int y, char P, String Name){

this.name = Name;
  this.P = P;
   this.x = x;
   this.y = y;
   this.C = Color.black;
   this.BC= Color.GRAY;
   Arts.Map.set(x,y,this);
}
@Override
public void act()
   {
   if(Arts.you.gender!=P){Arts.aPrint("You go pee");Arts.you.gender = P;}
   }
}