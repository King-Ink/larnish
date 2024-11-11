package Arts;

import java.awt.Color;

public class wall extends Thing{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	wall(int x,int y, Color BC)
	 {
	   this.x = x;
	   this.y = y;
	   this.BC = BC;
	   this.block = true;
	   Arts.Map.set(x,y,this);
	 }
}
