package Arts;

import java.awt.Color;

class dungeon extends Thing{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	m M =new m();
dungeon(int x, int y)
 {
   this.name = "Entrace to an anthill";
   this.P = '●';
   this.x = x;
   this.y = y;
   this.C = Color.black;
   this.BC= new Color(M.rand(25)+100,M.rand(25)+100,M.rand(25));
   Arts.Map.set(x,y,this);
   //make the hill
  
 }
 public void act()
 {
 // saved();
   Arts.aPrint("you enter the anthill");
   Arts.level++;
//   println("level",level);
//      level();
//   println("level",level);   
//      you.x=ux;
//      you.y=uy;


 }
}
