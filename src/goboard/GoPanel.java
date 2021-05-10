package goboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JPanel;

public class GoPanel extends JPanel {
	private GoBoard board;
    


    public GoPanel(int width, int height) {
        // Add key and mouse listeners to our canvas
        initializeMouseListener();
        initializeKeyListener();
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
            		redrawdesel();
            		movsel(dir);
            		redrawsel();
        			break;
            	}}
			public void keyReleased(KeyEvent e){}
            public void keyTyped(KeyEvent e) {}
        });
    }

    private void redrawdesel() {
		// TODO Auto-generated method stub
		
	}
	private void movsel(int dir) {
		// TODO Auto-generated method stub
		
	}
	private void redrawsel() {
		// TODO Auto-generated method stub
		
	}
}
