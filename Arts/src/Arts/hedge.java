package Arts;

class hedge extends Thing{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

hedge(int x,int y)
 { 
   this.name="hedge";
   this.text="you push through the thorny hedge";
   this.P = '♣';
   this.x = x;
   this.y = y;
   this.C = Arts.Map.grass().brighter();
   this.BC = Arts.Map.grass();
   Arts.Map.set(x,y,this);
 }
 
public void act(){ 
     if(Arts.you.Str.test(-5))
     {
     Arts.aPrint("you yank the hedge from the ground");
     new Cell(Arts.you.x,Arts.you.y,Arts.Map.grass());
     Arts.here().destroyed=true;
     name = "folliage";
     P='*';    
if(Arts.you.inventory.size()<9){
	Arts.you.inventory.add(this);
     }
   else
   {  
	   Arts.aPrint("your arms are full so you leave it here");
    x=Arts.you.x;
    y=Arts.you.y;
    Arts.Map.items.add(this);
   }
 }
 else
	 Arts. aPrint("you are to weak to pull up the hedge");
}
}
