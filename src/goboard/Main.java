package goboard;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		GoPanel panel = new GoPanel(10,10);
        window.setTitle("go");
        window.getContentPane().add(panel,BorderLayout.CENTER);
        window.pack();
        window.setLocation(100,100);
        window.setVisible(true);
        window.setSize(1000,800);
        window.validate();
        // Handle closing the window.
        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
	}

}
