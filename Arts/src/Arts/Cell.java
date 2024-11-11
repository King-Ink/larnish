package Arts;

import java.awt.Color;

public class Cell extends Thing{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Cell(char P, int x, int y, Color BC) {
		  this.name="ground";
		   this.text="step";
		this.x=x;
		this.y=y;
		this.P=P;
		this.BC = BC;
		Arts.Map.set(x,y,this);
	}

	public Cell(int x, int y, Color BC) {
		this.x=x;
		this.y=y;
		this.BC = BC;
		Arts.Map.set(x,y,this);
	}


		//public void over(){};
	}

