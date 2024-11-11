package Arts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class prioryDoor extends Thing implements KeyListener{
;

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
prioryDoor(String name,char P,int x,int y, Color C, Color BC)
 {
this.name = name;
   this.P = P;
   this.x = x;
   this.y = y;
   this.C = C;
   this.BC= BC;
   Arts.Map.set(x,y,this);
 }
  @Override
public void act(){
    Arts.aPrint("You enter the Priory. It smells like soup and balls");
    Arts.you.Place = name;
    Arts.Map.make("priory");
    Arts.Map.see(Arts.you.x,Arts.you.y);
 }
 @Override
public void interact(Graphics g){
	
	 g.setColor(Arts.Map.wood());
     g.fillRect(200,200,470,400);
     g.setColor(new Color(100,100,100));
     g.fillRect(215,215,445,375);
    
     g.setColor(new Color(100,100,100));
    
    int Y =0;
    int n = ('①');
    g.setColor(Color.black);
    g.drawString("Welcome to the Priory of Saint Greg",225,230+(Y++)*30);
    g.drawString("The nearly holy",300,230+(Y++)*30);
    g.drawString((char)n+" Would you like some soup?",235,230+(Y++)*30);
 if(Arts.you.gender != '♀')
   {
	 g.drawString((char)(n+Y-2)+" 1￠ for a bed?",235,230+(Y++)*30);
	 g.drawString((char)(n+Y-2)+" To take holy orders?",235,230+(Y++)*30);
    }
    else
    {
     g.drawString((char)(n+Y-2)+" do some cleaning",235,230+(Y++)*30);
     g.drawString((char)(n+Y-2)+" pray",235,230+(Y++)*30);
    }
    g.drawString((char)(n+Y-2)+" Talk to the Abbot?",235,230+(Y++)*30);
    g.drawString((char)(n+Y-2)+" Leave",235,230+(Y++)*30);
    g.setColor(Color.WHITE);
    g.drawString(Arts.asplain,10,880);
    g.drawString(Arts.splain,10,905);
    choose(Arts.key);
 }

 @Override
public void choose(int key)
  {
	 System.out.print(key); 
    switch(key){
       case KeyEvent.VK_NUMPAD1:Arts.aPrint("the Soup is adequate");break;
       case KeyEvent.VK_NUMPAD2:if(Arts.you.gender != '♀'){if (Arts.you.dosh>=1){Arts.aPrint("zzzzzzzzzzzzzzzzzzzzzz");Arts.you.sleep();Arts.you.dosh--;}
             else{Arts.aPrint("you don't have enough dosh");}
                }
                 else
                {
                  Arts.aPrint("you do some light cleaning the place now smell a little less like balls. the abbot gives you a penny");
                  Arts.you.alignment++;
                  Arts.you.dosh++;
                }
                break;
       case KeyEvent.VK_NUMPAD3:if(Arts.you.gender != '♀'){Arts.aPrint("after a brief class you are now declared a Catechumen");Arts.you.prioryLVL++;if(Arts.you.God!="Elyon") {
		Arts.you.God="HaShem";
	}}
                else
                {
                  Arts.aPrint("you feel pius");
                  Arts.you.alignment++;
                  Arts.you.Pow.test(0);
                }
                break;
       case KeyEvent.VK_NUMPAD4: Arts.aPrint("Anthony the Abbot complains about the ants");break;
       case KeyEvent.VK_NUMPAD5: Arts.aPrint("you leave"); Arts.you.Place = "Halekshelil"; Arts.mode="move";   ;break;
    }
  }
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

}