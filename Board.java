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
    private int countP = 0;
    private int countO = 0;


    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //constructors
    
    public Board() {
	setup();
    }

    

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //methods


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

    
    //populates grid with Pieces in starting formation
    public void setup() {

	//populate first three rows
	boolean live = false;
	for (int r = 0; r < 3; r++) {
	    for (int c = 0; c < 8; c++) {
		grid[r][c] = new Opponent(live);  //update Opponent, does it display opposite color?
		live = !live;
	    }
	}

	//next two rows
	for (int r = 3; r < 5; r++) {
	    for (int c = 0; c < 8; c+2) {
		grid[r][c] = new Player(false); //make default Player false?
		grid[r][c+1] = new Opponent(false); // make default Opponent false?
	    }
	}

	//final three rows
	live = true; // make sure true-- i think it already is tho
	for (int r = 5; r < 8; r++) {
	    for (int c = 0; c < 8; c++) {
		grid[r][c] = new Player(live);
		live = !live;
	    }
	}
    }


    //prints out checkerboard (grid)
    public String toString() {
	for (Piece[] r : grid) {
	    for (Piece x : grid[r]) {
		System.out.print(x);
	    }
	    System.out.print("\n");
	}
    }


    //check for wins (not on UML) -- wb ties? what should it return?
    //should also return the winner, to add to SOP message in Checkers.java
    public boolean checkWin() {
    	if (countP==0||countO==0) {
    		return true;
    		//if countP==0, opponent wins
    		//if countO==0, player wins
		//need to check if there are any possible moves (player counts might not be equal to 0)
	}
    	//else if no more possible player moves, opponent wins
    	//else if no more possible opponent moves, player wins
    }

}
