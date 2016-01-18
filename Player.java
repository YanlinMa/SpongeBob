/*THINGS TO DO:

  - actually make it look like a piece

/*TO THINK ABOUT / DO:
  
  - need default constructor?

 */

public class Player extends Piece { 

    
    // overloaded constructor
    public Player(boolean s) {
	king = false;
	status = s;
    }

    public String toString() {
	String retStr = "";
	
	if (!getStatus()) 
	    retStr = "=====\n=====\n=====";

	else if (isKing())
	    retStr = "=====\nPLkng\n=====";

	else
	    retStr = "=====\nPLpce\n=====";

	return retStr;
    }      

}
