import java.util.ArrayList;


/* INFO
   - contains essential board fxnality w/o levels
*/


/* TO DO:

   - implement user-friendly move fxns and its helpers
   - king and jump functionality
   - multiple jump functionality
   - check win, return winner methods
   - hasMoves() may be simplified using proper()
   - write movesLeftOnBoard()
   - NEED PROPER()? AND OTHER FXNS?

*/

public abstract class Board {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //instance variables
    
    protected Piece[][] grid = new Piece[8][8];
    protected ArrayList<Player> movables = new ArrayList<Player>(); //pieces w moves left
    protected ArrayList<Player> opponents = new ArrayList<Player>(); //opponents w moves left
    protected ArrayList<Player> friends = new ArrayList<Player>(); //friends w moves left

    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //constructor
    
    public Board() {
	setup();
        popALists();
    }

    

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //accessors

    //return Piece at 
    public Piece getPiece(int r, int c) {
	return grid[r][c];
    }

    //return player by ID
    //only use when certain of existence
    public Player getPlayer(String i) {
	Player ret = new Player("A",1,2); 
	for (Player x : movables) {
	    if (x.getID() == i)
		ret = x;
	}
	return ret;
    }

    

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //helpers

    //checks if within checkerboard
    public static boolean outOfBounds(int x) {
	return x < 0 || x > 7; 
    }


    
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //ABSTRACT
    
    public abstract String[] AIMove();
    

    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //methods

           
    //populates grid with Pieces in starting formation
    public void setup() {
	
	for (int c = 0; c < 8; c+=2) {

	    grid[0][c] = new Player("A",0,c,false);
	    grid[0][c+1] = new Empty();

	    grid[1][c] = new Empty();
	    grid[1][c+1] = new Player("B",1,c+1,false);
	    
	    grid[2][c] = new Player("C",2,c,false);
	    grid[2][c+1] = new Empty();

	    grid[5][c] = new Empty();
	    grid[5][c+1] = new Player("D",5,c+1);

	    grid[6][c] = new Player("E",6,c);
	    grid[6][c+1] = new Empty();

	    grid[7][c] = new Empty();
	    grid[7][c+1] = new Player("F",7,c+1);
	    
	    grid[3][c] = new Empty(); 
	    grid[3][c+1] = new Player("G",3,c+1,false, false);
	    
	    grid[4][c] = new Player("H",4,c,false, false);
	    grid[4][c+1] = new Empty();
	}

    }



    //populate ALs
    public void popALists() {
	movables.clear();
	opponents.clear();
	friends.clear();
	
	for (int r = 0; r < 8; r++) {
	    for (int c = 0; c < 8; c++) {
		if (getPiece(r,c) instanceof Player) {
		    if (((Player)getPiece(r,c)).getFriend()) {
			if (addMoves(r,c)) {
			    friends.add((Player)getPiece(r,c));
			}
			else if (addMoves(r,c))
			    opponents.add((Player)getPiece(r,c));
		    }
		}
	    }
	}
	
	movables.addAll(opponents);
	movables.addAll(friends);
    }

    
    
    //prints out checkerboard (grid)
    public String toString() {
	String retStr = "";
	for (int r = 0; r < 8; r++) {
	    for (int c = 0; c < 8; c++) {
	        retStr += grid[r][c] + "\t";
	    }
	    retStr += "\n";
	}
	return retStr;
    }


    //================================================
    //moving pieces

    //if usable piece
    public boolean contains(String s) {
	for (Player x : friends) {
	    if (x.getID() == s)
		return true;
	}
	return false;
    }

    
    //checks if move is ok
    //no jumps right now, no kings
    public boolean proper(int r1, int c1, int r2, int c2) {
	boolean prop = !(outOfBounds(r1) ||
			 outOfBounds(c1) ||
			 outOfBounds(r2) ||
			 outOfBounds(c2));

	if (prop && getPiece(r2,c2) instanceof Player) {
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
    //returns true if move successful, false otherwise
    public boolean move(int r1, int c1, int r2, int c2) {
	if (proper(r1,c1,r2,c2)) {
	    boolean side = ((Player)getPiece(r2,c2)).getFriend();
	    boolean stat1 = getPiece(r1,c1).getStatus();
	    boolean stat2 = getPiece(r2,c2).getStatus();
	    getPiece(r1,c1).setStatus(!stat1);
	    getPiece(r2,c2).setStatus(!stat2);
	    ((Player)getPiece(r2,c2)).setFriend(side); //set appropriate side

	    popALists(); //update movables
	    return true;
	}
	return false;
    }

/*
    //move for players using id
    public void move(String id, String m) {
	int r = getPlayer(id).row;
	int c = getPlayer(id).col;

	if (getPlayer(id).getFriend()) {
	    if (m == "FL")
		move(r,c,r-1,c+1,true);
	    else //(m == "FR")
		move(r,c,r-1,c-1,true);
	}
	else {
	    if (m == "FR")
		move(r,c,r+1,c+1,false);
	    else //(m == "FL")
		move(r,c,r+1,c-1,false);

	}
    }
*/
    /*
    //no jumps or kings
    public boolean hasMoves(int r, int c) {
    	boolean moves = getPiece(r,c).getStatus();

	if (moves) {
	    if (((Player)getPiece(r,c)).getFriend()) 
		moves = proper(r,c,r-1,c-1) || proper(r,c,r-1,c+1);
	    else 
		moves = proper(r,c,r+1,c+1) || proper(r,c,r+1,c-1);
	}
	
	return moves;
    }
    */

    public Player getPlayerRC(int r, int c) {
	return (Player)getPiece(r,c);
    }

    public boolean addMoves(int r, int c) {
	getPlayerRC(r,c).getMoves().clear();
	int hasMoves = 0;
	
	if (getPlayerRC(r,c).getFriend()) {
	    if ( proper(r,c,r-1,c-1)) {
		getPlayerRC(r,c).getMoves().add("FL");
		hasMoves++;
	    }
	    if (proper(r,c,r-1,c+1)) {
		getPlayerRC(r,c).getMoves().add("FR");
		hasMoves++;
	    }
	}
	else {
	    if ( proper(r,c,r+1,c-1)) {
		getPlayerRC(r,c).getMoves().add("FL");
		hasMoves++;
	    }
	    if (proper(r,c,r+1,c+1)) {
		getPlayerRC(r,c).getMoves().add("FR");
		hasMoves++;
	    }
	}
	return hasMoves > 0;
    }

}
