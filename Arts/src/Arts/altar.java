package Arts;

import java.awt.Color;

class altar extends Thing{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
altar(String name,char P,int x,int y, Color C, Color BC)
 {
   this.name = name;
   this.P = P;
   this.x = x;
   this.y = y;
   this.C = C;
   this.BC= BC;
  Arts.Map.set(x,y,this);
 }
 public void over(){
 Arts.Print("An Altar to " + name);
 }
 public void act(){
  Arts.aPrint("You pray to "+ name +" they accept you");  
  Arts.you.God=name;
 }
}
