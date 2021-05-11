package goboard;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JPanel;


@SuppressWarnings("serial")//the difficulties of extending something serializable and not being serializable yourself, I tell you.
public class GoPanel extends JPanel {
	private GoBoard board;
    int xsel=0,ysel=0,elwidth,elheight,
    		cxdim=1,cydim=1,
    		seltype=TypeS.stone_1;
    boolean selvalid=true;


    public GoPanel(int ewidth, int eheight) {
    	board=new GoBoard(ewidth,eheight);
    	this.elwidth=ewidth;
    	this.elheight=eheight;
    	
        // Add key and mouse listeners to our canvas
        initializeMouseListener();
        initializeKeyListener();
        
        this.setFocusable(true);

        this.addComponentListener(new ComponentListener() {
        	public void componentHidden(ComponentEvent e) {}
            public void componentMoved(ComponentEvent e) {}
            public void componentResized(ComponentEvent e) {
                updatedim(e.getComponent());}
            public void componentShown(ComponentEvent e) {
            	updatedim(e.getComponent());}
			private void updatedim(Component component) {
				cxdim=component.getWidth()/elwidth;
				cydim=component.getHeight()/elheight;
				//repaint();
				//gets repainted automatically, actually
			}
        });
    }
    
    private void initializeMouseListener() {
        MouseAdapter a = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	//calculate clicked cell, perhaps?
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseDragged(MouseEvent e) {}
            public void mouseWheelMoved(MouseWheelEvent e) {}
        };
        addMouseMotionListener(a);
        addMouseListener(a);
    }
    
    /**
     * Initialize the keyboard listener.
     */
    private void initializeKeyListener() {
        addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
            	switch(e.getKeyCode()) {
            	case(KeyEvent.VK_LEFT):
            	case(KeyEvent.VK_UP):
            	case(KeyEvent.VK_RIGHT):
            	case(KeyEvent.VK_DOWN):
            	case(KeyEvent.VK_1):
            	case(KeyEvent.VK_2):
            	case(KeyEvent.VK_SPACE):
        			movsel(e.getKeyCode());
        			break;
            	}
            	redrawsel();}
			public void keyReleased(KeyEvent e){}
            public void keyTyped(KeyEvent e) {}
        });
    }
	private void movsel(int dir) {
		//fix this
		redrawdesel();
		switch(dir) {
		case(KeyEvent.VK_LEFT):
			xsel--;
			break;
		case(KeyEvent.VK_UP):
			ysel--;
			break;
		case(KeyEvent.VK_RIGHT):
			xsel++;
			break;
		case(KeyEvent.VK_DOWN):
			ysel++;
			break;
		case(KeyEvent.VK_1):
			seltype=TypeS.stone_1;
			break;
		case(KeyEvent.VK_2):
			seltype=TypeS.stone_2;
			break;
		case(KeyEvent.VK_SPACE):
			if(selvalid) {board.place(xsel,ysel,seltype);}
			break;
		}
		selvalid=board.validplace(xsel,ysel,seltype);
		redrawsel();
	}

	
    private void redrawdesel() {
		//board.getstoneat(xsel,ysel).redraw();
    	repaint();
	}
	private void redrawsel() {
		redrawdesel();
    	//gra.drawOval(xsel*cxdim+10,ysel*cydim+10,cxdim-20,cydim-20);
		//TODO: sel
		//temporary thing, why implement clipping if you won't use it you idiot
		//repaint();
	}
	
	
	@Override
	public void paint(Graphics g) {
		fullpaint(g);
	}
	
	
	public void fullpaint(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(0,0,elwidth*cxdim,elheight*cydim);
		Bnode stone;int ix,stx=0,sty=0;
    	for(int iy=0;iy<elheight;iy++) {
    		stx=0;
    		for(ix=0;ix<elwidth;ix++) {
    			//keep things simple for now.
    			stone=board.getstoneat(ix,iy);
    			if(stone.type==TypeS.empty) {g.setColor(Color.gray);}
    			else if(stone.type==TypeS.stone_1) {g.setColor(Color.white);}
    			else if(stone.type==TypeS.stone_2) {g.setColor(Color.black);}
    			g.fillOval(stx,sty,cxdim,cydim);
    			stx+=cxdim;
    		}
    		sty+=cydim;
    	}
		//just draw the selection box bc it's easy
		//remember to do this properly later
    	g.setColor(selvalid?Color.blue:Color.red);
    	g.drawOval(xsel*cxdim+10,ysel*cydim+10,cxdim-20,cydim-20);
	}
	
    public void secpaint(Graphics g) {
		int x1=g.getClipBounds().x/cxdim;
		int y1=g.getClipBounds().y/cydim;
		int x2=x1+g.getClipBounds().width/cxdim+1;
		int y2=y1+g.getClipBounds().height/cydim+1;
		if(x2>elwidth) {x2=elwidth;}
		if(y2>elheight) {y2=elheight;}
		g.setColor(Color.green);
		g.fillRect(x1*cxdim,y1*cydim,(x2)*cxdim,(y2)*cydim);
		Bnode stone;int ix,stx=x1*elwidth,sty=y1*elheight;
    	for(int iy=y1;iy<y2;iy++) {
    		stx=x1*elwidth;
    		for(ix=x1;ix<x2;ix++) {
    			//keep things simple for now.
    			stone=board.getstoneat(ix,iy);
    			if(stone.type==TypeS.empty) {g.setColor(Color.gray);}
    			else if(stone.type==TypeS.stone_1) {g.setColor(Color.white);}
    			else if(stone.type==TypeS.stone_2) {g.setColor(Color.black);}
    			g.fillOval(stx,sty,cxdim,cydim);
    			stx+=cxdim;
    		}
    		sty+=cydim;
    	}
		//just draw the selection box bc it's easy
		//remember to do this properly later
    	g.setColor(selvalid?Color.blue:Color.red);
    	g.drawOval(xsel*cxdim+10,ysel*cydim+10,cxdim-20,cydim-20);
	}
}
