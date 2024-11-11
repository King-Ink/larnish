package Arts;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class map implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Thing[][] data = new Thing[40][40];
	m M =new m();
	static ArrayList<Thing> items = new ArrayList<Thing>();
	public map() {
		for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 40; j++) {
				data[i][j]=new Thing();
			}
		}
	}

	void see(int x,int y){
          x=M.con(x,1,39);
          y=M.con(y,1,39);
		  data[x][y].hidden=false;
		  data[x-1][y].hidden=false;
		  data[x+1][y].hidden=false;
		  data[x-1][y+1].hidden=false;
		  data[x+1][y+1].hidden=false;
		  data[x-1][y-1].hidden=false;
		  data[x+1][y-1].hidden=false;
		  data[x][y-1].hidden=false;
		  data[x][y+1].hidden=false;
		 
		}
	private void wild()
	{
		
		// pick 5 points on the map
		ArrayList<wCell> peak = new ArrayList<wCell>();
		for(int i = 0;i<5;i++)
		{
			double r =Arts.R.nextDouble()*Math.PI*2;
			peak.add(new wCell(' ',(int)(Math.sin(r)*(10+M.rand(10)))+20,(int)(Math.cos(r)*(10+M.rand(10)))+20+M.rand(5),Color.white));
			
		}	
		peak.add(new wCell(' ',23,23,Color.white));
		for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 40; j++) {
				 int altitude=0;
				 for(wCell p : peak)
				 {
					 altitude+= (400-((Math.pow(i-20,2)+ Math.pow(j-20,2))))/Math.sqrt(Math.pow(i-p.x,2)+Math.pow(j-p.y,2));
				 }
				 new wCell(' ',i,j,Color.WHITE);
				 data[i][j].altitude = altitude;
			}
		}
		for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 40; j++) {
				Thing p=data[i][j];
				 if (p.altitude>300)
					 p.BC=Color.WHITE;
				 else
				 if (p.altitude>200)
					new wCell(' ',i,j,grass().darker());
				 else
				 if (p.altitude>150)
					 new wCell(' ',i,j,grass());
				 else
				 if (p.altitude>110)
				new wCell(' ',i,j,grass().brighter());
				 else
				 if (p.altitude<=110 && p.altitude>90)
					 new wCell(' ',i,j,sand());
				 else
				 {
					new sea(i,j); 
				 }
				 }
				 
			  }
			 for(Thing p : peak) {
	                 new wCell(' ',p.x,p.y,Color.white);                     
			 }
			
		new portal('◎',20,20,0,21,"city");
		data[20][20].BC=grass();
		data[20][20].name="the city of Halekshelil : If you got the time we got the grime";
		 Arts.you.x=20;
		 //make the rivers
	}
	private void anthill(int x,int y)
 {
   new dungeon(36,3);
	for(int i=-2;i<=2;i++) {
		for(int j=-2;j<=2;j++)
	     {
	    	int d = 1+(Math.abs(i)+Math.abs(j))/4;
	         int r = M.rand(25)+100/d;
	         int g =data[x+i][y+j].BC.getGreen();
	         int b = M.rand(Math.min(r,g)) ;
	          data[x+i][y+j].BC=new Color(r,g,b);
	     }
	}

	    // dx=x;
	    // dy=y;
}

		 private void arena(int x,int y)
	 {
	   String name="The Halekshelil Arena:Two men enter ... or like a man and a monster ... two monsters sometimes .. you get it only one leaves. You wanna try?";
	    room(x,y,9,9);
	    new feature(name,'■',x+4,y,wood(),floor());
	    new wall(x+4,y+1,wall());
	    new wall(x+3,y+1,wall());
	    new wall(x+5,y+1,wall());
	       data[x+4][y+1].P='⚔';

	    //gladiator school
	    for(int i= x+3;i<=x+5;i++) {
			for(int j=y+9;j<y+11;j++) {
				new wall(i,j,wall());
			}
		}
	        new feature("gladiator school",'■',x+4,y+10,wood(),floor());
	         data[x+4][y+9].P=(char)(0x22D4);
	}
		 private void bank(int x,int y)
		 {

		   String name = "The 22/7 Natonal Bank of Larnish";
		   char P = '⛻';
		   Color C = wood();
		   Color BC= floor();
		   for(int i=x-2;i<x+3;i++) {
			for(int j=y;j<y+3;j++) {
				new wall(i,j,wall());
			}
		}
		       new feature(name,'■',x,y,C,BC);
		       data[x][y+1].P= P;
		 }
	private void barracks(int x,int y)
	 {
	   String name = "Barracks of the Halekshelil city guard";
	   char P = '✬';
	   Color C = Color.BLACK;
	   Color BC= floor();
	   for(int i=x;i<x+7;i++) {
		for(int j=y;j<y+3;j++) {
			new wall(i,j,wall());
		}
	}
	       new Barracks(name,'■',x+3,y+2,C,BC);
	       data[x+3][y+1].P= P;
	       data[x+3][y+1].C= Color.BLACK;
	 }

	void blank() {
		for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 40; j++) {
				//set(i,j,new Cell(' ',i,j,grass()));
				new stone(i,j);
			}
		}
	}

	private void citywall(int x, int y)
	 {
	   Square(0,0,40,40);
	   //gates
	   new portal('X',x,21,20,20,"wild");
	   data[21][20].name="Do you want to enter the wild?";
	   new portal('X',x,22,20,20,"wild");
	   data[22][20].name="Do you want to enter the wild?";
	   for(int i=2;i<10;i++)
	    {
	    new stone(i,20);
	    new stone(i,23);
	    }
	    for(int i=1;i<3;i++)
	    {
	    new stone(2,20-i);
	    new stone(2,23+i);
	    }
	    new stone(1,18);
	    new stone(1,25);
	 }

	private void college(int x,int y)
	 {
	  String name = "Fangelsi Gríslinga University";
	   char P = 'ℵ';
	   Color C = wood();
	   Color BC= floor();
	    for(int i=x;i<x+5;i++) {
			for(int j=y-3;j<y+4;j++) {
				new wall(i,j,wall());
			}
		}
	       new feature(name,'■',x,y,C,BC);
	       data[x+1][y].P= P;
	       new WC(x+0,y+4,'♂',"men's room");
	       new WC(x+2,y+4,'⚲',"restroom");
	       new WC(x+4,y+4,'♀',"ladies' room");
	       new recycle(x+4,y-4);
	 }
	private void coven(int x,int y)
	 {
	 String name = "Order of Cybl: No Boys allowed";
	   char P = '☾';
	   for(int i=x;i<x+3;i++) {
		for(int j=y;j<y+3;j++) {
			new wall(i,j,wall());
		}
	}
	       new portal('■',x+2,y+1,24,20,"coven");
	       data[x+2][y+1].name=name;
	       data[x+1][y+1].P= P;
	 }
	private void fountain(int x,int y)
	 {
	    for (int i = x; i < x + 6; i++) {
			for (int j = y; j < y + 6; j++) {
			      //map[i][j] = new Cell(i, j, floor);
			        if (i == x || i == x + 5|| j == y || j == y + 5) {
						new Cell(i, j,floor());
					} else {
					  new water(i, j);
					}
			          new wall(x+2,y+2,wall()); new wall(x+2,y+3,wall()); new wall(x+3,y+2,wall()); new wall(x+3,y+3,wall());
			}
		}
	 }
	private void home(int x, int y) {
		   String name = "a small humble but also crappy house";
		   char P = '⌂';
		   Color C = crayon();
		   Color BC= floor();
		   int ori = M.rand(4);
		 switch(ori)
		 {
		  case 0:
			      for(int i=x;i<x+2;i++) {
					for(int j=y-1;j<=y+1;j++) {
						new wall(i,j, C);
					}
				}
		              data[x+1][y].P=P;
		              ;break;
		   case 1: for(int i=x-1;i<x+2;i++) {
			for(int j=y;j<=y+1;j++) {
				new wall(i,j,C);
			}
		}
		                data[x][y+1].P=P;break;
		   case 2: for(int i=x-1;i<x+1;i++) {
			for(int j=y-1;j<=y+1;j++) {
				new wall(i,j,C);
			}
		}
		                data[x-1][y].P=P;break;
		    case 3: for(int i=x-1;i<x+2;i++) {
				for(int j=y;j<=y+1;j++) {
					new wall(i,j,C);
				}
			}
		                data[x][y+1].P=P;break;
		 }
		 new feature(name,'■',x,y,crayon(),BC);

		 }
	private void palace(int x,int y)
	 {
	   String name="The palace";
	   char P = '♛';
	    Square(x,y,20,13);
	    room(x+5,y+2,11,9);
	    new feature(name,'■',x,y+4,wood(),floor());
	    new feature(name,'■',x,y+6,wood(),floor());
	    new feature(name,'■',x,y+8,wood(),floor());
	    new feature(name,'■',x+5,y+5,wood(),floor());
	    new feature(name,'■',x+5,y+7,wood(),floor());
	       data[x+11][y+6].P= P;
	 }
	private void priory(int x,int y)
		 {
		   String name = "The Priory of Saint Greg the Nearly Holy";
		   char P = '☥';

		   Color C = wood();
		   Color BC= floor();
		   for(int i=x;i<x+7;i++) {
			for(int j=y;j<y+2;j++) {
				new wall(i,j,wall());
			}
		}
		       new prioryDoor(name,'■',x+3,y,C,BC);
		       data[x+3][y+1].P= P;
		 }

	private void sorcerer(int x,int y)
	 {
	   String name = "Socerer's Circle : good and evil? We are interested in hows not whys";
	   char P ='⯂';
	   for(int i=x;i<x+3;i++) {
		for(int j=y;j<y+3;j++) {
			new wall(i,j,wall());
		}
	}
	   new portal('■',x+2,y+1,24,20,"sorcerer");
           data[x+2][y+1].name=name;
	       data[x+1][y+1].P= P;
	 }

	private void temple(int x,int y)
	 {
	   //this.name = "the pantheon of Halekshelil";

	    room(x,y,11,11);
	    for(int i=x+1;i<11;i+=2)
	     {
	      new Cell(i, y+10,floor());
	     }
	       data[x+5][y+5].P= '⛩';
	       //set up altars
	       //elementals
	       new altar("The Fire",'▲',x+2,y+9,Color.RED,floor());
	       new altar("The Air",'|',x+4,y+9,Color.WHITE,floor());
	       new altar("The Earth",'－',x+6,y+9,Color.YELLOW,floor());
	       new altar("The Water",'▼',x+8,y+9,Color.BLUE,floor());
	       new altar("Elyon",'♄',x+1,y+3,Color.PINK,floor());
	       new altar("Anat",'♀',x+2,y+1,Color.ORANGE,floor());
	       new altar("Shapshu",'☉',x+4,y+1,Color.MAGENTA,floor());
	       new altar("Chemosh",'♂',x+6,y+1,Color.GREEN,floor());
	       new altar("Gad",'☿',x+8,y+1,Color.CYAN,floor());
	       new altar("Yam",'♃',x+9,y+3,Color.darkGray,floor());
	 }
	private void wizard_school(int x,int y)
	 {
	   String name = "Professor Emelius Browne's school of Wizardry : This ain't no hogwarts this ain't no Earthsea this ain't no fooling around";
	   char P = '۞';
	   for(int i=x;i<x+3;i++) {
		for(int j=y;j<y+3;j++) {
			new wall(i,j, wall());
		}
	}
	       new portal('■',x+2,y+1,24,20,"wizard");
	       data[x+2][y+1].name=name;
	       data[x+1][y+1].P= P;
	       
	 }
	
	private void tradingPost(int x, int y)
	 {
	   String name = "Rosetree's General Store : if you need it we generally have it";
	   char P = '∵';

	   Color C = wood();
	   Color BC= floor();
	   for(int i=x-1;i<x+2;i++) {
		for(int j=y-1;j<=y;j++) {
			new wall(i,j,wall());
		}
	}
	       data[x][y-1].P=P;
	       new feature(name,'■',x,y,C,BC);
	 }
	private void tavern(int x,int y)
	 {
		   String name = "The Wilted Rose";
		   char P = '⚘';

		   Color C = Color.green;
		   Color BC= floor();
		    for(int i=x;i<x+7;i++) {
				for(int j=y;j<y+6;j++) {
					new wall(i,j,wall());
				}
			}
		       new feature(name,'■',x+3,y+5,C,BC);
		       new feature("The court of miracles",' ',x+3,y,wall(),wall());
		       data[x+3][y].block=false;
		       data[x+3][y+4].P= P;

		 }
	private void recruiter(int x,int y)
	 {
	   String name = "Join the Larnish Army we promise your survivors will get paid";
	   char P = '♟';
	   Color C = wood();
	   Color BC= floor();
	    for(int i=x-1;i<x+2;i++) {
			for(int j=y-1;j<=y;j++) {
				new wall(i,j,wall());
			}
		}
	       new door(x,y);
	       data[x][y-1].P=P;
	       new feature(name,'■',x,y,C,BC);
	 }
	public Thing at(int i,int j) {return data[i][j];}
	////the CITY
	void city() {
		for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 40; j++) {
			    if(M.rand(8) <1) {
					new hedge(i, j);
				} else
			    {
			    new Cell(i, j, grass());
			    }
			  }
		}
		anthill(36,3);
		arena(14,27);
		bank(14,14);
		barracks(3,24);
		citywall(0, 0);
		college(9, 31);
		coven(1,36);
		fountain(12,19);
		priory(3,18);
		temple(1, 1);
        wizard_school(1,28);
  	    sorcerer(1,32);
		  for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				home(25+j*4-M.rand(2), 25+i*4-M.rand(2));
			}
			
		}

	  tradingPost(13,10);
		  recruiter(17,10);
		  palace(20,10);
		  tavern(12,2);
		  for (int i = 0; i < 40; i++)
			    for (int j = 0; j < 40; j++) if(M.rand(64)<1 && data[i][j].getClass() == Cell.class)items.add(new item("grot",i,j));
			 
	}
	@SuppressWarnings("rawtypes")
	int count(Class A) {
	  int out = 0;
	  for (int i = 1; i < 39; i++) {
		for (int j = 1; j < 39; j++) {
	      if (A == data[i][j].getClass()) {
			out++;
		}
	    }
	}
	  return out;
	}
	Color crayon () {
	// the houses are bright crayon colors
		return new Color(M.rand(2)*150+50,M.rand(2)*150+50,M.rand(2)*150+50);
	}
	void djiskra(int x, int y) {
	  // set node value to 666
	  for (int i = 0; i < 40; i++) {
		for (int j = 0; j < 40; j++) {
	      data[i][j].dij = 666;
	    }
	}
	  //set data[x][y] to 0
	  data[x][y].dij = 0;
	  for (int A = 0; A < 40; A++) {
	    for (int i = 1; i < 39; i++) {
			for (int j = 1; j < 39; j++) {
			    if (data[i][j].dij == A) {
			      setDji(i - 1, j - 1, A + 1);
			      setDji(i - 0, j - 1, A + 1);
			      setDji(i + 1, j - 1, A + 1);
			      setDji(i + 1, j + 0, A + 1);
			      setDji(i + 1, j + 1, A + 1);
			      setDji(i - 0, j + 1, A + 1);
			      setDji(i - 1, j + 1, A + 1);
			      setDji(i - 1, j + 0, A + 1);
			    }
			  }
		}
	  }
	}
Color floor(){return new Color(M.rand(25)+100,M.rand(25)+100, M.rand(25)+100);}

Color grass(){return new Color(M.rand(25), M.rand(25)+100, M.rand(25));}
	ArrayList<Thing> Orphans() {
	  ArrayList <Thing> Orphans = new ArrayList <> ();
	  for (int i = 1; i < 39; i++) {
		for (int j = 1; j < 39; j++) {
	      if (data[i][j].getClass() == Cell.class && data[i][j].dij == 666) {
	        Orphans.add(data[i][j]);
	      }

	    }
	}
	  return Orphans;
	}

	void room(int x, int y, int w, int h) {
		  for (int i = x; i < x + w; i++) {
			for (int j = y; j < y + h; j++) {

		      if (i <= 39 && j <= 39 && i >= 0 && j >= 0) {
				if (data[i][j].P != '>' || data[i][j].P != '<') {
		           new Cell(i, j, floor());
		          if (i <= 39 && j <= 39 && i >= 0 && j >= 0) {
					if (i == x || i == x + w - 1 || j == y || j == y + h - 1 || i == 0 || i == 39 || j == 0 || j == 39) {
						new wall(i, j, wall());
					}
				}
		        }
			}
		    }
		}
		}

	void set(int i,int j,Thing A) {data[i][j]=A;}

		void setDji(int x, int y, int num) {
		  if (data[x][y].dij == 666 && !data[x][y].block && x > 0 && x < 40 && y > 0 && y < 40) {
			data[x][y].dij = num;
		}
		}

		void show(Graphics g){
			for (int i = 0; i < 40; i++) {
				for (int j = 0; j < 40; j++)
		    	{
		    		data[i][j].show(g);
		    	}
			}
		}

		void Square(int x, int y, int w, int h) {
			  for (int i = x; i < x + w; i++) {
				for (int j = y; j < y + h; j++) {
			            if (i == x || i == x + w - 1 || j == y || j == y + h - 1 || i == 0 || i == 39 || j == 0 || j == 39) {
							data[i][j] = new stone(i, j);
						}
			        }
			}
			    }

		Color stone(){return new Color(M.rand(10)+50,M.rand(10)+50, M.rand(10)+50);}

		void tunnel(int mx, int my, int dx, int dy) {
		  while (mx != dx) {
		    if (mx < dx) {
				mx++;
			} else {
				mx--;
			}
		    data[mx][my] = new Cell(mx, my, floor());
		  }
		  while (my != dy) {
		    if (my < dy) {
				my++;
			} else {
				my--;
			}
		    data[mx][my] = new Cell(mx, my, floor());
		  }
		}

		Color wall(){return new Color(M.rand(10)+200,M.rand(10)+200, M.rand(10)+200);}

			Color wood(){
				         int r = M.rand(25)+50;
				         int g = M.rand(r);
				         int b = Math.min(r, g);
				         return new Color(r,g,b);
				        }
			Color sand(){
		         int r = 240+M.rand(10);
		         int g = 210+M.rand(40);
		         int b = 150+M.rand(100);
		         return new Color(r,g,b);
		        }
			public void make(String place) {
				//save();
				Arts.place = place; 
				File f = new File("/Racy_Pictures_of_your_mom/"+Arts.you.name+"/directory/"+place+".map");
				System.out.println("does" + f +" exist?");
				if (f.exists()&& !f.isDirectory())
				 load();
				 else
				 {
				Arts.R.setSeed(Arts.level);
				switch(place)
				{
				case "city":city();break;
				case "barracks":Hbarracks();break;
				case "priory":Hpriory();break;
				case "wizard":Hwizard();break;
				case "sorcerer":Hsorcerer();break;
				case "coven":Hcoven();break;
				case "wild":wild();break;
				}
			 }
				save();
			}
			void save(){
				System.out.print("...savey");
				File theDir = new File("/Racy_Pictures_of_your_mom/"+Arts.you.name+"/directory");
				if (!theDir.exists())
				    theDir.mkdirs();
				    // save the map
				    System.out.println(theDir);
				    String filename = "/Racy_Pictures_of_your_mom/"+Arts.you.name+"/directory/"+Arts.place+".map";
				    ObjectOutputStream outputStream;
					try {
						outputStream = new ObjectOutputStream(new FileOutputStream(filename));
						outputStream.writeObject(data);
						outputStream.writeObject(items);
						outputStream.flush();
						outputStream.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
				}

			static void load() {
				System.out.print("loady");
				try {
					FileInputStream saveFile = new FileInputStream("/Racy_Pictures_of_your_mom/"+Arts.you.name+"/directory/"+Arts.place+".map");
					ObjectInputStream save = new ObjectInputStream(saveFile);
				     data=(Thing[][]) save.readObject();
				     items= (ArrayList<Thing>) save.readObject();
					save.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print(" load load");
			}
			private void Hbarracks() {
				Arts.Map.blank();
				//outer wall
				room(1,9,36,21);
				room(2,10,35,20);
				//reception 
				room(21,23,7,7);
				
				//armory
				room(21,10,7,8);
				new door(21,13);
				new door(27,13);
				new portal('■',24,29,6,26,"city"); 
				//office
				room(21,17,7,7);
				new door(24,17);
				new window(24,23);
				new door(21,26); // station
				new door(27,26);//dorm
				// beds
				for(int i =0;i<18;i+=2) {
					new bed(35,11+i);
			     	new bed(28,11+i);
				}
				//cells
				for(int i=0;i<16;i+=4)
				{
					room(2+i,10,5,4);
					new door(4+i,13);
					new bed(3+i,11);
					room(2+i,15,5,4);
					new door(4+i,15);
					new bed(3+i,17);
				}
				// evidence
				room(2,23,7,7);
				new door(8,26);
				//captains office
				room(2,18,7,6);
				new door(8,20);
				//move guy to door
				Arts.you.x=24;
				Arts.you.y=29;
				
				
				
			}

			private void Hpriory() {
				Arts.Map.blank();
				//outer wall
				room(1,9,36,15);
				new portal('■',22,9,6,18,"city"); 
				//chapel
				room(23,9,4,4);
				new door(26,10);
				room(23,20,4,4);
				new door(26,22);
				new altar("HaShem", '☥', 34, 16, Color.YELLOW, floor().brighter());
				for(int i=9;i<23;i+=2)
				 new wall(23,i,wall());
				for(int i=0;i<8;i+=2)
				{
					 new wall(30,13+i,wall());
					 new wall(30+i,13,wall());
					 new wall(30+i,19,wall());
				}
				for(int i =4;i<11;i++)
				{
					new wall(36,i+9,crayon().brighter());
				}
				// the cells
				new wall(5,12,wall());
				new door(5,13);
				new wall(5,14,wall());
				for(int i=2;i<22;i++)
				{
					if(i%2==1)
					{
				    new wall(i,10,wall());
				    new wall(i,11,wall());
					}
					else
					{
						new door(i,11);
						new bed(i,10);
					}
				}
				

				   room(1,15,9,9);
				   new door(6,15);
					for(int i=0;i<5;i++)
						for(int j=0;j<5;j++)
						  new hedge(i+3,j+17);
				//kitchen
					room(9,15,5,9);
					new door(9,17);
					new door(9,21);
					new door(13,17);
			   
					
				Arts.you.x=22;
				Arts.you.y=9;
				
				
				
			}
			public String toString() {return "hey baby wot up?";} 	
			private void Hwizard() {
				Arts.Map.blank();
				//outer wall
				room(16,16,9,9);
				new portal('■',24,20,3,29,"city"); 		
				Arts.you.x=24;
				Arts.you.y=20;
			}
			private void Hsorcerer() {
				Arts.Map.blank();
				//outer wall
				room(16,16,9,9);
				new portal('■',24,20,3,33,"city"); 		
				Arts.you.x=24;
				Arts.you.y=20;
			}
			private void Hcoven() {
				Arts.Map.blank();
				//outer wall
				room(16,16,9,9);
				new portal('■',24,20,3,37,"city"); 		
				Arts.you.x=24;
				Arts.you.y=20;
			}

}
