package Arts;

import java.awt.Color;
import java.awt.Graphics;

class recycle extends Thing{


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

recycle(int x, int y){
	this.name = "The Halekshelil Recyling System";
    this.x=x;
    this.y=y;
  this.P='♺';
   this.C = Color.BLACK;
   this.BC= Color.green;
   Arts.Map.set(x,y,this);
  }

  @Override
public void act(){
    Arts.aPrint("You engage The Halekshelil Recyling System ");
    Arts.you.Place = name;
    Arts.mode = "interact";
 }

  @Override
public void interact(Graphics g){
//   this.larnish.stroke(0);
//   this.larnish.strokeWeight(10);
//   this.larnish.fill(100,100,100);
//  this.larnish.rect(215,215,375,195);
//  this.larnish.noStroke();
//  this.larnish.fill(0);
//  this.larnish.textSize(20);
//  this.larnish.text("tap the number of the Thing you want to recycle * to leave",215,215,375,195);

  }

@Override
public void choose(int A)
  {
//    if(this.larnish.key-49<this.larnish.you.inventory.size() && this.larnish.key-49 >= 0)
//               {
//               //Thing d = you.inventory.get(key-49);
//               this.larnish.you.inventory.remove(this.larnish.key-49);
//               this.larnish.you.dosh++;
//               this.larnish.drawIt();
//               }
//    if (A== '*'){this.larnish.mode="move"; this.larnish.you.Place = "Halekshelil";  this.larnish.drawIt();return;}
  }
}