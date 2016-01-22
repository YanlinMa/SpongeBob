/* INFO
   - contains essential board fxnality w/o levels
*/


/* TO DO:

   - implement user-friendly move fxns and its helpers
   - king and jump functionality
   - multiple jump functionality
   - check win, return winner methods

*/

public abstract class Board {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //instance variables
    
    protected Piece[][] grid = new Piece[8][8];
    //private int countP = 0;
    //private int countO = 0;


    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //constructor
    
    public Board() {
	setup();
    }



    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //accessors

    //return Piece at 
    public Piece getPiece(int r, int c) {
	return grid[r][c];
    }

    

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //helpers

    //checks if within checkerboard
    public static boolean outOfBounds(int x) {
	return x < 0 || x > 7; 
    }

    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //ABSTRACT
    
    public abstract void AIMove();
    

    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //methods

           
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
	        retStr += grid[r][c] + " ";
	    }
	    retStr += "\n";
	}
	return retStr;
    }


    //================================================
    //moving pieces

    //if usable piece
    public boolean yourPiece(int r, int c) {
        return ( ((Player)getPiece(r,c)).getFriend() &&
		 getPiece(r,c).getStatus() );
    }

    
    //checks if move is ok
    //no jumps right now, no kings
    public boolean proper(int r1, int c1, int r2, int c2) {
	boolean prop = !(outOfBounds(r1) ||
			 outOfBounds(c1) ||
			 outOfBounds(r2) ||
			 outOfBounds(c2));
	prop = getPiece(r1,r2) instanceof Player;

	if (prop) {
	    if (((Player)getPiece(r1,c1)).getFriend()) 
		prop = (!getPiece(r2,c2).getStatus() &&
			(r1 - 1 == r2 && Math.abs(c2 - c1) == 1));
	    else
		prop = (!getPiece(r2,c2).getStatus() &&
			(r1 + 1 == r2 && Math.abs(c2 - c1) == 1));
	}

	return prop;	
    }


    
    //'moves' pieces
    //ASSUMES PROPER ALREADY
    public void move(int r1, int c1, int r2, int c2) {
	boolean stat1 = grid[r1][c1].getStatus();
	boolean stat2 = grid[r2][c2].getStatus();
	grid[r1][c1].setStatus(!stat1);
	grid[r2][c2].setStatus(!stat2);

    }


    //no jumps or kings
    public boolean hasMoves(int r, int c) {
    	boolean moves = false;
	if (((Player)getPiece(r,c)).getFriend()) {
	    if (r % 2 == 1 && c == 7) //if edge piece
		moves = !getPiece(r-1,c-1).getStatus();
	    else if (r % 2 == 0 && c== 0)
		moves = !getPiece(r-1,c+1).getStatus();
	    else 
		moves = !getPiece(r-1,c+1).getStatus() || !getPiece(r-1,c-1).getStatus();
	}
	else {
	    if (r % 2 == 1 && c == 7) //if edge piece
		moves = !getPiece(r+1,c-1).getStatus();
	    else if (r % 2 == 0 && c== 0)
		moves = !getPiece(r+1,c+1).getStatus();
	    else
		moves = !getPiece(r+1,c+1).getStatus() || !getPiece(r+1,c-1).getStatus();
	}
	
	return moves;
    }   
    
}
