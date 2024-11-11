package Arts;

import java.awt.Color;

class feature extends Thing{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

feature(String name,char P,int x,int y, Color C, Color BC)
 {
   this.name = name;
   this.P = P;
   this.x = x;
   this.y = y;
   this.C = C;
   this.BC= BC;
   Arts.Map.set(x,y,this);
 }
}
