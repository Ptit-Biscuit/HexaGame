package com.company;

import com.company.listener.BoardListener;
import com.company.model.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {

    public static void main(String[] args) {
		JFrame f = new JFrame();
	    f.setPreferredSize(new Dimension(Board.WIDTH, Board.HEIGHT));
	    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	    Point centreEcran = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
	    f.setLocation((int) centreEcran.getX() - (Board.WIDTH / 2),
			    (int) centreEcran.getY() - (Board.HEIGHT / 2));

	    f.setLayout(new BorderLayout());
	    f.setBackground(Color.BLACK);

	    Board b = Board.getInstance();

	    BoardListener bl = new BoardListener();
	    b.addMouseListener(bl);
	    b.addMouseMotionListener(bl);

	    f.setContentPane(b);

	    f.pack();
	    f.setResizable(false);
	    f.setVisible(true);

	    f.addKeyListener(new KeyListener() {
		    @Override
		    public void keyTyped(KeyEvent e) {
			    switch (e.getKeyChar()) {
				    case 'c':
				    	Board.getInstance().rotate();
				    	break;
				    case '+':
					    Board.getInstance().addHexWidth(10);
					    break;
				    case '-':
				    	Board.getInstance().addHexWidth(-10);
				    	break;
			    }

		    	f.repaint();
		    }

		    @Override
		    public void keyPressed(KeyEvent e) {

		    }

		    @Override
		    public void keyReleased(KeyEvent e) {

		    }
	    });
    }
}
