package Chess;

import java.util.Scanner;
import Chess.PieceColor;
import Chess.GameBoard;
import Chess.Peice.*;
import Chess.PawnTest;

public class Application {
	
public static void main(String[] args) {
		
		
		Scanner scanerInstance = new Scanner(System.in);
		GameBoard.init();
		int selectRow;
		int selectCol;
		
		int moveRow;
		int moveCol;
		
		System.out.println("Hello Kasparov tron");
		System.out.println();
		while(true) {
//			GameBoard.render();
			
			System.out.print("Select row: ");
			selectRow = scanerInstance.nextInt();
			System.out.print("Select col: ");
			selectCol = scanerInstance.nextInt();
			
			if(GameBoard.isPieceSelectable(selectRow, selectCol)) {
				GameBoard.selectPiece(selectRow, selectCol);
				System.out.print("Selected piece" + GameBoard.activePeice.getStignature());
				
				System.out.print("Move row");
				moveRow = scanerInstance.nextInt();
				
				System.out.print("Move col");
				moveCol = scanerInstance.nextInt();
				
				if(GameBoard.isPieceMovable(moveRow, moveCol)) {
					GameBoard.movePiece(moveRow, moveCol);	
				}
				else {
					System.out.print("* Invalid move pls try again");	
				}
			}
			else {
				System.out.print("* Invalid selection pls try again");	
			}
		}
	}
}