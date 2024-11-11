package Arts;

import java.awt.Color;

public class door extends Thing {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	door(int x,int y)
	 { 
	   this.name = "door";
	   this.P='■';
	   this.x = x;
	   this.y = y;
	   this.BC = Arts.Map.floor();
	   this.C= new Color(M.rand(25), M.rand(25)+100, M.rand(25));
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

}


