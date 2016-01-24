import java.util.ArrayList;

/*TO THINK ABOUT / DO:
  
  - need default constructor?
  - actually make it look like a piece
  - get rid of rows in Piece.java and here

*/

public class Player extends Piece {

    //instance variables
    private boolean friend; //where true is player, false is AI
    private String ID;
    private ArrayList<String> moves = new ArrayList<String>(); //possible moves

    
    //overloaded constructors

    public Player(String i, int r, int c) {
	super();
	friend = true;
	row = r;
	col = c;
	ID = i + col;
    }

    public Player(String i, int r, int c, boolean f) {
	this(i,r,c);
	friend = f;
    }
    
    public Player(String i, int r, int c, boolean s, boolean f) {
        this(i,r,c,f);
	status = s;
    }


    //accessor for friend
    public boolean getFriend() {
	return friend;
    }

    public String getID() {
	return ID;
    }

    public ArrayList<String> getMoves() {
	return moves;
    }

    public String randMove() {
	return moves.get((int)(Math.random()*moves.size()));
    }
    


    public void setFriend(boolean b) {
	friend = b;
    }

    public boolean isOpponent() {
	return !friend;
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
