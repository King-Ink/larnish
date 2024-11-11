package Arts;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
public class Arts extends JComponent implements KeyListener{  
	static Font Symbola;
	static Font Teki;
	static Font Monospaced;
	static Font Noto;
	static Random R = new Random();
	private static final long serialVersionUID = 1L;
	static map Map;
	static dude you = new dude('＠',0, 21);
	static ArrayList<Thing> ThingsHere = new ArrayList<Thing>();
	public static String mode = "name";
	static String asplain ="Welcome to Halekshelil";
	static String splain="The moon is full";
	public static int level=0;
	static String place = "city";
	static int key= ' ';

	public Arts() 
    { 
		try {
			f.setIconImage(ImageIO.read(new File("data/icon.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Symbola = new Font("Symbola", Font.TRUETYPE_FONT,19);
		Teki = new Font("Nishiki-teki", Font.TRUETYPE_FONT,20);
		Monospaced =new Font("Monospaced", Font.PLAIN,20);
		Noto = new Font("Noto Emoji", Font.PLAIN,20);
		R = new Random(level);
		you.inventory.add(new item("spoon",0,0));
		you.inventory.add(new item("towel",0,0));
		Map = new map();
		Map.blank();	
	//	Map.make(place);
	//    Map.see(you.x, you.y);
	    setSize(1000, 1000); 
	    setVisible(true);
       
    }  
	static JFrame f=new JFrame();  
	static Arts m=new Arts();
	public static int ticks;
        public static void main(String[] args) {   	
       f.addKeyListener(m);
       f.add(m);
       f.setSize(300,100);   
       f.setLocation(800, 400);
       f.setVisible(true);  
       f.setTitle("Larnish");
    }  
        public void paint (Graphics g) {
        	ticks++;
            Graphics2D g2 = (Graphics2D) g;
            Dimension dim = getSize();
            int w = (int) dim.getWidth();
            int h = (int) dim.getHeight();

            // Create the buffer
            BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D ig2 = image.createGraphics();
            ig2.setColor(Color.BLACK);
            ig2.fillRect(0,0, w, h);
            
            ig2.setFont(Symbola);  
            if(mode=="name") {
            	ig2.setColor(Color.white);
            	ig2.drawString("What is your name",10,20);
            	ig2.drawString(you.name,10,45);
            }
            else {
       	    Map.show(ig2);
       	    you.show(ig2);
       	    here().over();
            if(mode == "interact") {
            	System.out.print("hi");
            	here().interact(ig2);
            	here().choose(key);
            }
            else {
            ig2.drawString(asplain,10,880);
            ig2.drawString(splain,10,905);
            }
            }
            for(Thing i:Map.items){ i.show(ig2);}
            // Paint the buffer
            g2.drawImage(image, 0, 0, null);
        	
        }
	public static void Print(String string) {
		
		//System.out.println(string);
		splain=string;
		
	}
	public static void aPrint(String string) {
		//System.out.println(string);
		asplain=string;
	}

	public static Thing here() {
		return Map.at(you.x,you.y);
		
	}


	 void submit() {
		 System.out.println("submiting");;  
          f.setSize(1000,1000);  
          f.setLocation(600, 10);
          mode="move";
          Map.make("city");
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
		key = e.getKeyCode();
		char keyChar = e.getKeyChar();
		//System.out.print(e);
		if(mode=="name") {
        if (key==KeyEvent.VK_ENTER)
        	submit();
        else
        {
        	if(key ==' ' || Character.isLetter(keyChar))
        	     you.name+=keyChar;
        	     repaint();
        }
	  }
		if(mode=="move") {
			if(e.isControlDown())
			{
				
				switch (key) {
				  case KeyEvent.VK_NUMPAD1:pickup(0);break;
				  case KeyEvent.VK_NUMPAD2:pickup(1);break;
				  case KeyEvent.VK_NUMPAD3:pickup(2);break;
				  case KeyEvent.VK_NUMPAD4:pickup(3);break;
				  case KeyEvent.VK_NUMPAD5:pickup(4);break;
				  case KeyEvent.VK_NUMPAD6:pickup(5);break;
				  case KeyEvent.VK_NUMPAD7:pickup(6);break;
				  case KeyEvent.VK_NUMPAD8:pickup(7);break;
				  case KeyEvent.VK_NUMPAD9:pickup(8);break;
				}
			}
			else
				if(e.isAltDown())
				{
			     switch (key) {
				  case KeyEvent.VK_NUMPAD1:drop(0);break;
				  case KeyEvent.VK_NUMPAD2:drop(1);break;
				  case KeyEvent.VK_NUMPAD3:drop(2);break;
				  case KeyEvent.VK_NUMPAD4:drop(3);break;
				  case KeyEvent.VK_NUMPAD5:drop(4);break;
				  case KeyEvent.VK_NUMPAD6:drop(5);break;
				  case KeyEvent.VK_NUMPAD7:drop(6);break;
				  case KeyEvent.VK_NUMPAD8:drop(7);break;
				  case KeyEvent.VK_NUMPAD9:drop(8);break;
			     }
				}
			else
			 switch (key) {
			  case KeyEvent.VK_NUMPAD0:pickup(0);here().act();break;
			  case KeyEvent.VK_NUMPAD1:you.move(-1, 1);break;
			  case KeyEvent.VK_NUMPAD2:you.move( 0, 1);break;
			  case KeyEvent.VK_NUMPAD3:you.move( 1, 1);break;
			  case KeyEvent.VK_NUMPAD4:you.move(-1, 0);break;
			  case KeyEvent.VK_NUMPAD5:break;
			  case KeyEvent.VK_NUMPAD6:you.move( 1, 0);break;
			  case KeyEvent.VK_NUMPAD7:you.move(-1,-1);break;
			  case KeyEvent.VK_NUMPAD8:you.move( 0,-1);break;
			  case KeyEvent.VK_NUMPAD9:you.move( 1,-1);break;
			  case KeyEvent.VK_MINUS:drop(0);here().act();break;
			  case KeyEvent.VK_L:Map.load();break;
			  case KeyEvent.VK_S:Map.save();break;
			  }
			   repaint();
		}
		if(mode=="interact")
		{
			here().choose(key);
			 repaint();
		}
	}
	void drop(int A)
	{
		if(ThingsHere.size()<10)
		{
		Print("dropped the the "+you.inventory.get(A).name);
		you.inventory.get(A).x=you.x;
		you.inventory.get(A).y=you.y;
	    if(A<you.inventory.size() && ThingsHere.size()<9){Map.items.add(you.inventory.get(A));you.inventory.remove(you.inventory.get(A));}
		}
	}
	void pickup(int A)
	{
		if(ThingsHere.size()>0)
		{
		Print("picking the "+ThingsHere.get(A).name+" up");
	    if(A<ThingsHere.size() && you.inventory.size()<9){you.inventory.add(ThingsHere.get(A));Map.items.remove(ThingsHere.get(A));}
		}
	}

	
	
}
