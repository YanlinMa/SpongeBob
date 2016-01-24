import java.util.ArrayList;

/*TO THINK ABOUT / DO:
  
  - need default constructor?
  - actually make it look like a piece
  - get rid of rows in Piece.java and here

*/

public class Player extends Piece {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //instance variables
    private boolean friend; //where true is player, false is AI
    private String ID;
    private ArrayList<String> moves = new ArrayList<String>(); //possible moves


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //accessors
    
    //accessor for friend
    public boolean getFriend() {
	return friend;
    }


    //accessor for ID
    public String getID() {
	return ID;
    }


    //accessor for moves AL
    public ArrayList<String> getMoves() {
	return moves;
    }
    

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //mutators

    //set friend
    public void setFriend(boolean b) {
	friend = b;
    }



    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //methods
    
    //get random item from moves
    public String randMove() {
	return moves.get((int)(Math.random()*moves.size()));
    }


    //return if player is an opponent
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
