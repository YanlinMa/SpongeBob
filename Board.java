import java.util.ArrayList;


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
	//System.out.println(r + ", " + c);
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
    public static boolean inBounds(int x) {
	return x >= 0 && x <= 7;
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
		    else if (addMoves(r,c)) {
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
	    if (x.getID().equals(s)) {
		return true;
	    }
	}
	return false;
    }

    
    //checks if move is ok
    //no jumps right now, no kings
    public boolean proper(int r1, int c1, int r2, int c2) {
	boolean prop = (inBounds(r1) &&
			inBounds(c1) &&
			inBounds(r2) &&
			inBounds(c2));

	if (prop && getPiece(r2,c2) instanceof Player) {
	    prop = !getPiece(r2,c2).getStatus(); //other spot must be blank

	    if (prop) {
		if (((Player)getPiece(r1,c1)).getFriend()) {
		    prop = (r1 - 1 == r2 && Math.abs(c2 - c1) == 1);  //if simple move forward


		    //check for jumps and king moves

		    if (!prop && (getPiece(r1,c1) instanceof Player)) {
			if (getPlayerRC(r1,c1).isKing())
			    prop = (r1 + 1 == r2 && Math.abs(c2 - c1) == 1);
		    }

		    if (!prop && (inBounds(r1-1) && inBounds(c1+1)) //JR
			&& getPiece(r1 - 1,c1 + 1) instanceof Player) {
			prop = ((r1 - 2 == r2 && c2 - c1 == 2) && (getPiece(r1 - 1,c1 + 1).getStatus()) &&
				(getPlayerRC(r1-1,c1+1).isOpponent()));
		    }
		    if (!prop && (inBounds(r1-1) && inBounds(c1-1)) //JL
			&& getPiece(r1 - 1,c1 - 1) instanceof Player) {
			prop = ((r1 - 2 == r2 && c2 - c1 == -2) && (getPiece(r1 - 1,c1 - 1).getStatus()) &&
				getPlayerRC(r1-1,c1-1).isOpponent());
		    }
		    
		}
		else {
		    prop = (r1 + 1 == r2 && Math.abs(c2 - c1) == 1);

		    if ((!prop && getPiece(r1,c1) instanceof Player)) {
			if (getPlayerRC(r1,c1).isKing())
			    prop = (r1 - 1 == r2 && Math.abs(c2 - c1) == 1);
		    }

		    //check for jumps
		    if (!prop && inBounds(r1+1) && inBounds(c1-1) //JR
			&& getPiece(r1 + 1,c1 - 1) instanceof Player) {
			
			prop = ((r1 + 2 == r2 && c2 - c1 == -2) && (getPiece(r1 + 1,c1 - 1).getStatus()) &&
				(getPlayerRC(r1+1,c1-1).getFriend()));
		    }
		    if (!prop && inBounds(r1+1) && inBounds(c1+1) //JL
			&& getPiece(r1 + 1,c1 + 1) instanceof Player) {

			prop = ((r1 + 2 == r2 && c2 - c1 == 2) && (getPiece(r1 + 1,c1 + 1).getStatus()) &&
				getPlayerRC(r1+1,c1+1).getFriend());
		    }
		}
	    }
	}

	return prop;	
    }


    public boolean jump(int r1, int c1, int r2, int c2) {
	System.out.println("here");

	
	if (getPlayerRC(r1,c1).getFriend()) {
	    if (inBounds(r1-1) && inBounds(c1+1)) {
		if (getPiece(r1 - 1,c1 + 1) instanceof Player) {
		    if ((r1 - 2 == r2 && c2 - c1 == 2) && (getPiece(r1 - 1,c1 + 1).getStatus()) &&
			(getPlayerRC(r1-1,c1+1).isOpponent())) {
			getPlayerRC(r1-1,c1+1).setStatus(false);
			return true;
		    }
		}
	    }

	    if (inBounds(r1-1) && inBounds(c1-1)) {
		
		if (getPiece(r1 - 1,c1 - 1) instanceof Player) {
		    if ((r1 - 2 == r2 && c2 - c1 == -2) && (getPiece(r1 - 1,c1 - 1).getStatus()) &&
			getPlayerRC(r1-1,c1-1).isOpponent()) {
			getPlayerRC(r1-1,c1-1).setStatus(false);
			return true;
		    }
		}
	    }
	}

	else {
	    if (inBounds(r1+1) && inBounds(c1+1)) {
		
		if (getPiece(r1 + 1,c1 + 1) instanceof Player) { 	
		    if ((r1 + 2 == r2 && c2 - c1 == 2) && (getPiece(r1 + 1,c1 + 1).getStatus()) &&
			(getPlayerRC(r1+1,c1+1).getFriend())) {
			getPlayerRC(r1+1,c1+1).setStatus(false);
			return true;
		    }
		}
	    }
	    if (inBounds(r1+1) && inBounds(c1-1)) {
		if (getPiece(r1 + 1,c1 - 1) instanceof Player) {
		    if ((r1 + 2 == r2 && c2 - c1 == -2) && (getPiece(r1 + 1,c1 - 1).getStatus()) &&
			getPlayerRC(r1+1,c1-1).getFriend()) {
			getPlayerRC(r1+1,c1-1).setStatus(false);
			return true;
		    }
		}
	    }
	}
	return false;
    }
    
    
    //'moves' pieces
    //returns true if move was jump
    public boolean move(int r1, int c1, int r2, int c2) {
	boolean isJump = false;
	
	if (proper(r1,c1,r2,c2)) {
	    
	    if (jump(r1,c1,r2,c2))
		isJump = true;//rm jumped piece if is jump

	    //move piece
	    boolean side = (getPlayerRC(r1,c1).getFriend());
	    boolean stat1 = getPiece(r1,c1).getStatus();
	    boolean stat2 = getPiece(r2,c2).getStatus();
	    getPiece(r1,c1).setStatus(!stat1);
	    getPiece(r2,c2).setStatus(!stat2);
	    ((Player)getPiece(r2,c2)).setFriend(side); //set appropriate side

	    if (side) { //set as king if appropriate
		if (r2 == 0)
		    ((Player)getPiece(r2,c2)).setKing(true);
	    }
	    else if (getPlayerRC(r1,c1).isKing()) {
		((Player)getPiece(r2,c2)).setKing(true);
	    }
	    else {
		if (r2 == 7)
		    ((Player)getPiece(r2,c2)).setKing(true);
	    }
	    
	    popALists(); //update movables
	    
	}
	return isJump;
    }
    

    //add to the player's moves AL
    //return true if has moves, false otherwise -- JUMPING BACKWARDS NOT IMPLEMENTED
    public boolean addMoves(int r, int c) {
	getPlayerRC(r,c).getMoves().clear();

	if (!getPlayerRC(r,c).getStatus())
	    return false;
	
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
	    if (proper(r,c,r-2,c-2)) {
		getPlayerRC(r,c).getMoves().add("JL");
		hasMoves++;
	    }
	    if (proper(r,c,r-2,c+2)) {
		getPlayerRC(r,c).getMoves().add("JR");
		hasMoves++;
	    }
	    if (proper(r,c,r+1,c-1)) {
		getPlayerRC(r,c).getMoves().add("BL");
		hasMoves++;
	    }
	    if (proper(r,c,r+1,c+1)) {
		getPlayerRC(r,c).getMoves().add("BR");
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
	    if (proper(r,c,r+2,c-2)) {
		getPlayerRC(r,c).getMoves().add("JL");
		hasMoves++;
	    }
	    if (proper(r,c,r+2,c+2)) {
		getPlayerRC(r,c).getMoves().add("JR");
		hasMoves++;
	    }
	    if (proper(r,c,r-1,c-1)) {
		getPlayerRC(r,c).getMoves().add("BL");
		hasMoves++;
	    }
	    if (proper(r,c,r-1,c+1)) {
		getPlayerRC(r,c).getMoves().add("BR");
		hasMoves++;
	    }
	}
	return hasMoves > 0;
    }

}
