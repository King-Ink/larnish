package Arts;

import java.io.Serializable;

public class m implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int rand(int i) {
		 if (i==0)return(0);
		 int a = Math.abs(Arts.R.nextInt())%i;
		return a;
	}

	public int con(int x, int b,  int t) {
		if(x>t)return t;
		if(x<b)return b;
		return x;
	}


}
//InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW); 
//im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "up");
//im.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0, 0), "interact");
//im.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0), "downleft");
//im.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0), "down");
//im.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0), "downright");
//im.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD4, 0), "left");
//im.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, 0), "wait");
//im.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD6, 0), "right");
//im.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0), "upleft");
//im.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0), "up");
//im.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, 0), "upright");
//im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
//ActionMap am = getActionMap();
//am.put("interact", new AbstractAction() {public void actionPerformed(ActionEvent e) {here().act();repaint();}});
//am.put("downleft", new AbstractAction() {public void actionPerformed(ActionEvent e) {you.move(-1,1);repaint();}});
//am.put("down", new AbstractAction() {public void actionPerformed(ActionEvent e)     {you.move( 0,1);repaint();}});
//am.put("downright", new AbstractAction() {public void actionPerformed(ActionEvent e){you.move( 1,1);repaint();}});
//am.put("left", new AbstractAction() {public void actionPerformed(ActionEvent e)     {you.move(-1,0);repaint();}});
//am.put("wait", new AbstractAction() {public void actionPerformed(ActionEvent e)     {repaint();}});
//am.put("right", new AbstractAction() {public void actionPerformed(ActionEvent e)    {you.move( 1,0);repaint();}});
//am.put("upleft", new AbstractAction() {public void actionPerformed(ActionEvent e)   {you.move(-1,-1);repaint();}});
//am.put("up", new AbstractAction() {public void actionPerformed(ActionEvent e)       {you.move(0,-1);repaint();}});
//am.put("upright", new AbstractAction() {public void actionPerformed(ActionEvent e)  {you.move(1,-1);repaint();}});
//am.put("enter", new AbstractAction() {public void actionPerformed(ActionEvent e)  {if(mode=="name")submit();repaint();}});