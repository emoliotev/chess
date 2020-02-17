package Chess;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class ApplicationMain {
	
public static void main(String[] args) {
	JFrame windowFrame = new JFrame();
	windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	windowFrame.setSize(500, 500);
	GameBoardPanel panel = new GameBoardPanel();
	windowFrame.add(panel);
	windowFrame.addMouseListener(panel);

	new AbstractTest() {
		
		@Override
		public void initClassMethod() {
			// TODO Auto-generated method stub
			
		}
	};
	
	
	windowFrame.setVisible(true);
	
	
	String[] collection = new String[] {
		"H", "B", "C"	
	};
	
}
}
