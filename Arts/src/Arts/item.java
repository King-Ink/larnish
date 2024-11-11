package Arts;

import java.awt.Color;

public class item extends Thing {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	item(String name,int x, int y){
		
		  this.name = name.trim();
		  this.P='*';
		  this.x = x;
		  this.y = y;
		  this.C = Color.BLACK;
		  this.BC= new Color(200,200,200,0);
		  if(name == "grot") this.name=grot(M.rand(20));
		  this.hidden = false;
		 
		 }
		 public String toString(){return name+" "+x+" "+y;
		}

		String grot(int A)
		 {
		 switch(A) {
		    case 0: return "pot lid";
		    case 1: return "mound of offal";
		    case 2: return "sword that was broken";
		    case 3: return "salted snail";
		    case 4: return "key";
		    case 5: return "toadstool";
		    case 6: return "greenish spindle";
		    case 7: return "tin soldier";
		    case 8: return "broken yo-yo";
		    case 9: return "Rampart subway map";
		    case 10: return "Cormorant's the One! button";
		    case 11: return "beer can (empty)";
		    case 12: return "golden bejewelled falcon";
		    case 13: return "hamster cage";
		    case 14: return "wooden nickel";
		    case 15: return "three-dollar bill";
		    case 16: return "rosebud";
		    case 17: return "water pistol";
		    case 18: return "shattered skull";
		    case 19: return "jawbone of an ass";
		  }
		  return "platic bag";
		 }

		}
