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
    //method for generating move coordinates based on string input
    //(see comment directly below)
    public void convertToCoord(String in) {
    }
    */

    //checks if move is ok
    //no jumps right now, no kings
    public boolean proper(int r1, int c1, int r2, int c2) {
	boolean good = false;

	if (((Player)getPiece(r1,c1)).getFriend()) 
	    if (!getPiece(r2,c2).getStatus()) //if empty spot
	        good = (r1 - 1 == r2 && Math.abs(c2 - c1) == 1); //if in right row
	else 
	    if (!getPiece(r2,c2).getStatus()) 
	        good = (r1 + 1 == r2 && Math.abs(c2 - c1) == 1);

	return good;	
    }

    //make this take in diff inputs "FL" etc. and convert them? (helper fxn?)
    //do above later-- just use coordinates now
    //so parameters eventually (String[] input)
    public void move(int r1, int c1, int r2, int c2) {
	if (proper(r1,c1,r2,c2)) {
	    boolean stat1 = grid[r1][c1].getStatus();
	    boolean stat2 = grid[r2][c2].getStatus();
	    grid[r1][c1].setStatus(!stat1);
	    grid[r2][c2].setStatus(!stat2);
	}
    }


    //return Piece at 
    public Piece getPiece(int r, int c) {
	return grid[r][c];
    }
    
    
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

    //no jumps or kings
    public boolean hasMoves(int r, int c) {
    	boolean moves = false;
	if (getPiece(r,c).getFriend()) 
	    moves = !getPiece(r-1,c+1).getStatus() || !getPiece(r-1,c-1).getStatus();
	else 
	    moves = !getPiece(r+1,c+1).getStatus() || !getPiece(r+1,c-1).getStatus();
    	return moves;
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

	b.move(2,2,1,3);
	System.out.println(b);
	
    }

}
