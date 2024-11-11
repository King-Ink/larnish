package Arts;
import java.awt.Color;
class stone extends Thing{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	m M =new m();
stone(int x,int y)
 {
   this.x = x;
   this.y = y;
   this.BC = new Color(M.rand(10)+50,M.rand(10)+50, M.rand(10)+50);;
   this.block = true;
   Arts.Map.set(x,y,this);
 }
}