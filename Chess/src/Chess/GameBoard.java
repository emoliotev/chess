package Chess;

import Chess.PieceColor;
import Chess.Bishop;
import Chess.King;
import Chess.Peice.*;

import java.awt.*;

public class GameBoard {
	
	public static Peice board[][] = new Peice[9][9];
	public static Peice activePeice;
	
	public static void init() {

		initPiece(new Rook(PieceColor.BLACK, 1, 0));
		initPiece(new Knight(PieceColor.BLACK, 1, 1));
		initPiece(new Bishop(PieceColor.BLACK, 1, 2));
		initPiece(new Queen(PieceColor.BLACK, 1, 3));
		initPiece(new King(PieceColor.BLACK, 1, 4));
		initPiece(new Bishop(PieceColor.BLACK, 1, 5));
		initPiece(new Knight(PieceColor.BLACK, 1, 6));
		initPiece(new Rook(PieceColor.BLACK, 1, 7));

		initPiece(new Pawn(PieceColor.BLACK, 2, 0));
		initPiece(new Pawn(PieceColor.BLACK, 2, 1));
		initPiece(new Pawn(PieceColor.BLACK, 2, 2));
		initPiece(new Pawn(PieceColor.BLACK, 2, 3));
		initPiece(new Pawn(PieceColor.BLACK, 2, 4));
		initPiece(new Pawn(PieceColor.BLACK, 2, 5));
		initPiece(new Pawn(PieceColor.BLACK, 2, 6));
		initPiece(new Pawn(PieceColor.BLACK, 2, 7));

		initPiece(new Rook(PieceColor.WHITE, 8, 0));
		initPiece(new Knight(PieceColor.WHITE, 8, 1));
		initPiece(new Bishop(PieceColor.WHITE, 8, 2));
		initPiece(new Queen(PieceColor.WHITE, 8, 3));
		initPiece(new King(PieceColor.WHITE, 8, 4));
		initPiece(new Bishop(PieceColor.WHITE, 8, 5));
		initPiece(new Knight(PieceColor.WHITE, 8, 6));
		initPiece(new Rook(PieceColor.WHITE, 8, 7));

		initPiece(new Pawn(PieceColor.WHITE, 7, 0));
		initPiece(new Pawn(PieceColor.WHITE, 7, 1));
		initPiece(new Pawn(PieceColor.WHITE, 7, 2));
		initPiece(new Pawn(PieceColor.WHITE, 7, 3));
		initPiece(new Pawn(PieceColor.WHITE, 7, 4));
		initPiece(new Pawn(PieceColor.WHITE, 7, 5));
		initPiece(new Pawn(PieceColor.WHITE, 7, 6));
		initPiece(new Pawn(PieceColor.WHITE, 7, 7));
	}
	
	public static void initPiece(Peice piece) {
		
		// int row = piece.row;
		int row = piece.getRow();
		
		// int col = piece.col;
		int col = piece.getCol();
		
		board[row][col] = piece;
	}
	
	public static boolean isPieceSelectable(int row, int col) {
		return(board[row][col] != null); 
	}
	
	
	public static void selectPiece(int row, int col) {
		activePeice = board[row][col];
	}
	
	public static boolean isPieceMovable(int row, int col) {
		return activePeice.isMovePosible(row, col);
	}
	
	// Bad design
	public static void move(int row, int col) {
		
		board[row][col] = activePeice;
		activePeice.move(row, col);
	}
	
	
	public static void movePiece(int row, int col) {
		
		// int currentRow = activePeice.row;
		int currentRow = activePeice.getRow();
		
		// int currentCol = activePeice.col;
		int currentCol = activePeice.getCol();
		
		activePeice.move(row, col);
		board[row][col] = activePeice;
		
		board[currentRow][currentCol] = null; 
	}
	
	public static void render(Graphics g, int tile) {
		Peice currentTile = null;
		for(int i = 0; i < board.length; i ++) {
			for(int j = 0; j < board.length - 1; j++) {
				boolean isRowEven 	= (i % 2 == 0);
				boolean isColEvent 	= (j % 2 == 0);

				boolean isWhite 	= (isRowEven && isColEvent) ||
						(!isRowEven && !isColEvent);

				Color peiceColor = isWhite ? Color.WHITE
						: Color.BLACK;

				currentTile  = board[i][j];
				String tileSignature = (currentTile == null) ? 
										" " :
										currentTile.getStignature() + " ";

				g.setColor(peiceColor);
				g.drawString(tileSignature, j * tile, i * tile);
			}
//			System.out.println();
		}
	}
}