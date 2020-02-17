package Chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


public class GameBoardPanel extends JPanel implements MouseListener {
	
private final int TILE_SIDE = 50;
private static int colorRow = -1;
private static int colorCol = -1;
private static Color color;
	public void paint(Graphics g) {

		for(int row = 0; row < 8; row++) {
			for(int col = 0; col < 8; col++) {
				render(g, row, col);
			}
		}

		GameBoard.init();
		GameBoard.render(g, TILE_SIDE);

		//g.setColor(Color.GREEN);
		//g.fillRect(10, 10, 100, 100);
	}
	
	private void render(Graphics g, int row, int col) {
		boolean isRowEven 	= (row % 2 == 0);
		boolean isColEvent 	= (col % 2 == 0);
		
		boolean isWhite 	= (isRowEven && isColEvent) ||
							  (!isRowEven && !isColEvent);
		
		Color tileColor = isWhite ? Color.WHITE 
								  : Color.BLACK;
		
		int tileX = col * TILE_SIDE;
		int tileY = row * TILE_SIDE;

		if (colorRow >= 0 && colorCol >= 0
				&& (colorCol >= tileY && colorCol <= tileY + TILE_SIDE)
				&& (colorRow >= tileX && colorRow <= tileX + TILE_SIDE)) {
			g.setColor(color);
			g.fillRect(tileX, tileY, TILE_SIDE, TILE_SIDE);
			System.out.println(tileY + " " + tileX);
		} else {
			g.setColor(tileColor);
			g.fillRect(tileX, tileY, TILE_SIDE, TILE_SIDE);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouse clicked at point:"
				+ e.getX() + " "
				+ e.getY() + "mouse clicked :" + e.getClickCount());

		if (color == Color.BLUE) {
			colorRow = e.getX();
			colorCol = e.getY() - 25;
			color = Color.RED;
		} else if (colorRow < 0 && colorCol < 0) {
			colorRow = e.getX();
			colorCol = e.getY() - 25;
			color = Color.RED;
		} else {
			color = Color.BLUE;
		}
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
