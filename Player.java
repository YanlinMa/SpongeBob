import java.util.ArrayList;

//accounts for attributes of the player's pieces

public class Player extends Piece {
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //instance variables
    private boolean friend; //where true is player, false is AI
    private String ID;
    private ArrayList<String> moves = new ArrayList<String>(); //possible moves
    
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //overloaded constructors
    
    public Player(String i, int c) {
	super();
	friend = true;
	col = c;
	ID = i + col;
    }

    public Player(String i, int c, boolean f) {
	this(i,c);
	friend = f;
    }
    
    public Player(String i, int c, boolean s, boolean f) {
        this(i,c,f);
	status = s;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //accessor methods
    
    //return friend
    public boolean getFriend() {
	return friend;
    }

    //return ID
    public String getID() {
	return ID;
    }

    //return moves
    public ArrayList<String> getMoves() {
	return moves;
    }
    
    //mutators

    //set friend
    public void setFriend(boolean b) {
	friend = b;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //methods
    
    //select random move
    public String randMove() {
	return moves.get((int)(Math.random()*moves.size()));
    }

    //true if player is an opponent
    public boolean isOpponent() {
	return !friend;
    }

    //find row and column based on move
    public int[] findRCbyM(String m, int r, int c) {
	int[] rc = new int[2];
	if (getFriend()) {
	    if (m.equals("FL")) {
		rc[0] = r-1;
		rc[1] = c-1;
	    }
	    else if (m.equals("FR")) {
		rc[0] = r-1;
		rc[1] = c+1;
	    }
	    else if (m.equals("JFL")) {
		rc[0] = r-2;
		rc[1] = c-2;
	    }
	    else if (m.equals("JFR")) {
		rc[0] = r-2;
		rc[1] = c+2;
	    }
	    else if (m.equals("BL")) {
		rc[0] = r+1;
		rc[1] = c-1;
	    }
	    else if (m.equals("BR")) {
		rc[0] = r+1;
		rc[1] = c+1;
	    }
	    else if (m.equals("JBL")) {
		rc[0] = r+2;
		rc[1] = c-2;
	    }
	    else if (m.equals("JBR")) {
		rc[0] = r+2;
		rc[1] = c+2;
	    }
	}
	else {
	    if (m.equals("FL")) {
		rc[0] = r+1;
		rc[1] = c-1;
	    }
	    else if (m.equals("FR")) {
		rc[0] = r+1;
		rc[1] = c+1;
	    }
	    else if (m.equals("JFL")) {
		rc[0] = r+2;
		rc[1] = c-2;
	    }
	    else if (m.equals("JFR")) {
		rc[0] = r+2;
		rc[1] = c+2;
	    }
	    else if (m.equals("BL")) {
		rc[0] = r-1;
		rc[1] = c-1;
	    }
	    else if (m.equals("BR")) {
		rc[0] = r-1;
		rc[1] = c+1;
	    }
	    else if (m.equals("JBL")) {
		rc[0] = r-2;
		rc[1] = c-2;
	    }
	    else if (m.equals("JBR")) {
		rc[0] = r-2;
		rc[1] = c+2;
	    }
	}
	return rc;
    }
    
    //overwrite toString()
    public String toString() {
	String retStr = "";

	if (friend) {
	    if (!getStatus()) 
		retStr = "[   ]";

	    else if (isKing())
		retStr = "[" + ID + "K]";

	    else
		retStr = "[" + ID + "P]";
	}
	else {
	    if (!getStatus()) 
		retStr = "[   ]";

	    else if (isKing())
		retStr = "[AIK]";

	    else
		retStr = "[AIP]";
	}
	
	return retStr;

    }

}
