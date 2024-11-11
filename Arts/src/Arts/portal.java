package Arts;

import java.awt.Color;

public class portal extends door{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
String place = "city";
int x1;
int y1;
	portal(char P,int x, int y, int x1, int y1, String place) {
		super(x, y);
		this.P=P;
		this.x1=x1;
        this.y1=y1;
		this.place=place;
		this.C = Color.BLACK;
        this.BC = Color.WHITE;
		Arts.Map.set(x,y,this);
	}
	public void act(){
	    Arts.Map.make(place);
	    Arts.you.x=x1;
	    Arts.you.y=y1;
	    Arts.you.x=x1;
	    Arts.you.y=y1;
	    Arts.Map.see(Arts.you.x,Arts.you.y);
		 }
}
