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

    //return movables AL
    public ArrayList<Player> getMovables() {
	return movables;
    }

    //return opponents AL
    public ArrayList<Player> getOpponents() {
	return opponents;
    }

    //return friends AL
    public ArrayList<Player> getFriends() {
	return friends;
    }

    
    //return Piece at 
    public Piece getPiece(int r, int c) {
	return grid[r][c];
    }

    //assumes Player exists so only use in that context
    public int[] findRCbyID(String id) {
	int[] ret = new int[2];
	for (int r = 0; r < 8; r++) {
	    for (int c = 0; c < 8; c++) {
		if (grid[r][c] instanceof Player)
		    if (((Player)grid[r][c]).getID().equals(id)) {
			ret[0] = r;
			ret[1] = c;
		    }
	    }
	}
	return ret;
    }

    //get Player by ID
    public Player getPlayer(String id) {
	int[] rc = findRCbyID(id);
	int r = rc[0];
	int c = rc[1];
	if (getPiece(r,c) instanceof Player)
	    return getPlayerRC(r,c);
	return null;
    }

    
    //get Player by rc
    public Player getPlayerRC(int r, int c) {
	return (Player)getPiece(r,c);
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

	    grid[0][c] = new Player("A",c,false);
	    grid[0][c+1] = new Empty();

	    grid[1][c] = new Empty();
	    grid[1][c+1] = new Player("B",c+1,false);
	    
	    grid[2][c] = new Player("C",c,false);
	    grid[2][c+1] = new Empty();

	    grid[5][c] = new Empty();
	    grid[5][c+1] = new Player("D",c+1);

	    grid[6][c] = new Player("E",c);
	    grid[6][c+1] = new Empty();

	    grid[7][c] = new Empty();
	    grid[7][c+1] = new Player("F",c+1);
	    
	    grid[3][c] = new Empty(); 
	    grid[3][c+1] = new Player("G",c+1,false, false);
	    
	    grid[4][c] = new Player("H",c,false, false);
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
		    if (getPlayerRC(r,c).getFriend()) {
			if (addMoves(r,c)) 
			    friends.add(getPlayerRC(r,c));
		    }
		    else if (addMoves(r,c) && getPlayerRC(r,c).getStatus()) {
			opponents.add(getPlayerRC(r,c));
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
	    if (x.getID().equals(s))
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
	    boolean side = (getPlayerRC(r1,c1).getFriend());
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
