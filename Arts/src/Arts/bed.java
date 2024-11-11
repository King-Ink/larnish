package Arts;

import java.awt.Color;
import java.awt.Graphics;

public class bed extends Thing {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		bed(int x,int y)
		 { 
		   this.name = "bed";
		   this.P='\uD83D';
		   this.x = x;
		   this.y = y;
		   this.BC = Arts.Map.floor();
		   this.C= Color.BLACK;
		   this.block = false;
		   this.auto=false;
		   Arts.Map.set(x,y,this);
		 }
		
		  void over(){
		Arts.Print(name);
		 if(auto)
		 {
		  block=true;
		  Arts.aPrint("click");
		 }
		 }
		  public void show(Graphics g) {
				if(!hidden) {
				   g.setColor(BC);
				   g.fillRect(20+x*20, 40+y*20, 20, 20);  
				   g.setColor(C);
//				   g.setFont(Arts.Symbola);
//				   g.setFont(Arts.Noto);
				   g.setFont(Arts.Monospaced);
				   
				   g.drawString("\uD83D\uDECF",x*20+22,y*20+56);
				}
			}
		  public void act(){
			  Arts.Print("zzzzzzzzzzzzz");
			  Arts.you.sleep();
		  }
	}


