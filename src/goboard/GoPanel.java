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

public class GoPanel extends JPanel {
	private GoBoard board;
    int xsel=0,ysel=0,elwidth,elheight,
    		cxdim,cydim,
    		seltype;
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
        	public void componentHidden(ComponentEvent e) {
        		updatedim(e.getComponent());}
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
        		int dir;
            	switch(e.getKeyCode()) {
            	case(KeyEvent.VK_LEFT):
            		dir=0;
            	case(KeyEvent.VK_UP):
            		dir=1;
            	case(KeyEvent.VK_RIGHT):
            		dir=2;
            	case(KeyEvent.VK_DOWN):
            		dir=3;
            		movsel(dir);
        			break;
            	}}
			public void keyReleased(KeyEvent e){}
            public void keyTyped(KeyEvent e) {}
        });
    }
	private void movsel(int dir) {
		//fix this
		redrawdesel();
		switch(dir) {
		case(0):
			xsel--;
			break;
		case(1):
			ysel--;
			break;
		case(2):
			xsel++;
			break;
		case(3):
			ysel++;
			break;
		}
		redrawsel();
	}

    private void redrawdesel() {
		// TODO Auto-generated method stub
		
	}
	private void redrawsel() {
		redrawdesel();
		//TODO: sel
		//temporary thing, why implement clipping if you won't use it you idiot
		repaint();
	}
	
	
	@Override
    public void paint(Graphics g) {
		int x1=g.getClipBounds().x/cxdim;
		int y1=g.getClipBounds().y/cydim;
		int x2=x1+g.getClipBounds().width/cxdim+1;
		int y2=y1+g.getClipBounds().height/cydim+1;
		Bnode stone;int ix,stx=x1*elwidth,sty=y1*elheight;
    	for(int iy=y1;iy<y2;iy++) {
    		for(ix=x1;ix<x2;ix++) {
    			//keep things simple for now.
    			stone=board.getstoneat(ix,iy);
    			if(stone.type==board.empty) {g.setColor(Color.gray);}
    			else if(stone.type==board.stone_1) {g.setColor(Color.white);}
    			else if(stone.type==board.stone_2) {g.setColor(Color.black);}
    			g.fillOval(stx,sty,cxdim,cydim);
    			stx+=cydim;
    		}
    		sty+=cxdim;
    	}
		//just draw the selection box bc it's easy
		//remember to do this properly later
    	g.setColor(selvalid?Color.blue:Color.red);
    	g.drawRect(xsel*cxdim,ysel*cydim,cxdim,cydim);
	}
}
