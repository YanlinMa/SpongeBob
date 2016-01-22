/*TO THINK ABOUT / DO:
  
  - need default constructor?
  - actually make it look like a piece

*/

public class Player extends Piece {

    //instance variables
    private boolean friend; //where true is player, false is AI

    
    //default constructor ?
    public Player() {
	king = false;
	status = true;
	friend = true;
    }
    
    //overloaded constructors

    public Player(boolean f) {
	this();
	friend = f;
    }
    
    public Player(boolean s, boolean f) {
	this();
	status = s;
	friend = f;
    }


    //accessor for friend
    public boolean getFriend() {
	return friend;
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
		retStr = "[  ]";

	    else if (isKing())
		retStr = "[RK]";

	    else
		retStr = "[RP]";
	}
	else {
	    if (!getStatus()) 
		retStr = "[  ]";

	    else if (isKing())
		retStr = "[OK]";

	    else
		retStr = "[OP]";
	}
	
	return retStr;

    }

}
