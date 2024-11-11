package Arts;

import java.awt.Graphics;

public class window extends door{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	window(int x, int y) {
		super(x, y);
		this.P='━';
		this.block=true;
		
	}
	  public void show(Graphics g) {
			if(!hidden) {
			   g.setColor(BC);
			   g.fillRect(20+x*20, 40+y*20, 20, 20);  
			   g.setColor(C);
			   if(Arts.Monospaced.canDisplay(P))g.setFont(Arts.Monospaced);
			   else
			   if(Arts.Symbola.canDisplay(P))g.setFont(Arts.Symbola);
			   else
			   if(Arts.Noto.canDisplay(P))g.setFont(Arts.Noto);
			   
			   g.drawString("\uD83E\uDE9F",x*20+22,y*20+56);
			}
		}
}
