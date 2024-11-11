package Arts;

import java.awt.Color;

class water extends Thing{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	m M =new m();
water(int x,int y)
 {
this.name="splash";
   this.x = x;
   this.y = y;
   this.BC = new Color(M.rand(25),M.rand(25),M.rand(25)+100);
   Arts.Map.set(x,y,this);
 }


}