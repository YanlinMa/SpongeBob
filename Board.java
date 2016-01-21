/* TO THINK ABOUT / DO
   
   - are accessors needed for instance variables?
   - read comments throughout
   - implement user-friendly move fxns and its helpers
   - jump functionality (loop and check for multiple jumps) -- make this check if move is proper (right now it doesn't)
   probably should implement the user-friendly things first
   - check if swap and getPiece work
   - implement remaining methods and check if player can move / jump pieces

*/

public class Board {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //instance variables
    
    private Piece[][] grid = new Piece[8][8];
    //private int countP = 0;
    //private int countO = 0;


    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //constructors
    
    public Board() {
	setup();
    }

    

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //methods

    /*
    //swap pieces -- should just put this code in move instead of helper?
    public void swap(int[] pieceToMove, int[] whereToMove) {
	Piece old = grid[pieceToMove[0]][pieceToMove[1]]; //0 = row, 1 = column?
	grid[pieceToMove[0]][pieceToMove[1]] =
	    grid[whereToMove[0]][whereToMove[1]]; //??? cleaner way to do this?
        grid[whereToMove[0]][whereToMove[1]] = old;
    }

    
    //method for generating move coordinates based on string input
    //(see comment directly below)
    public void convertToCoord(String in) {
    }
    

    //make this take in diff inputs "FL" etc. and convert them? (helper fxn?)
    //do above later-- just use coordinates now
    //so parameters eventually (String[] input)
    public void move(int[] pieceToMove, int[] whereToMove) {

	//swap
        swap (pieceToMove, whereToMove);

	//check to see if jump-- if yes, convert that piece's status to false
	//must match these coordinates (we're only doing one-player)
	//and piece between must be an Opponent
	//cleaner way to do this?
	//CURRENTLY ASSUMES PLAYER MAKES ONLY LEGAL MOVES
	if (pieceToMove[0] - 2 == whereToMove[0] &&
	    Math.abs(pieceToMove[1] - whereToMove[1]) == 2) {
	    if (pieceToMove[1] - whereToMove[1] < 0) 
		grid[pieceToMove[0] - 1][pieceToMove[1] + 1].setStatus(false); //is this possible?
	    else
		grid[pieceToMove[0] - 1][pieceToMove[1] - 1].setStatus(false);
	}	
	//check for potential jumps and loop that fxnality til no more
	//to do later
    }

    //return Piece at 
    public Piece getPiece(int rInd, int cInd) {
	return grid[rInd][cInd];
	}
    */
    
    //populates grid with Pieces in starting formation
    public void setup() {
	
	for (int c = 0; c < 8; c+=2) {	    	    
	    grid[0][c] = new Player(false);
	    grid[0][c+1] = new Empty();
	    
	    grid[1][c] = new Empty();
	    grid[1][c+1] = new Player(false);
	    
	    grid[2][c] = new Player(false);
	    grid[2][c+1] = new Empty();

	    grid[5][c] = new Empty();
	    grid[5][c+1] = new Player();

	    grid[6][c] = new Player();
	    grid[6][c+1] = new Empty();

	    grid[7][c] = new Empty();
	    grid[7][c+1] = new Player();
	    
	    grid[3][c] = new Empty(); 
	    grid[3][c+1] = new Player(false, false);
	    
	    grid[4][c] = new Player(false, false);
	    grid[4][c+1] = new Empty();
	}

    }


    //prints out checkerboard (grid)
    public String toString() {
	String retStr = "";
	for (int r = 0; r < 8; r++) {
	    for (int c = 0; c < 8; c++) {
	        retStr += grid[r][c];
	    }
	    retStr += "\n";
	    for (int i = 0; i < 64; i++) {
		retStr += "-";
	    }
	    retStr += "\n";
	}
	return retStr;
    }

    /*
    //check for wins (not on UML) -- wb ties? what should it return?
    //should also return the winner, to add to SOP message in Checkers.java
    public boolean checkWin() {
        return true;
    }
    */

    public static void main(String[] args) {
    
	Board b = new Board();
	System.out.println(b);
	
    }

}
