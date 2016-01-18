/*TO THINK ABOUT / DO:

  - how should status be used
  - is there a easier than the boolean king to change toString?
  - is protected correct?

 */

public abstract class Piece {

    // instance variables
    protected boolean king;
    protected boolean status; // this for dead / alive? wb king?

    
    
    //returns whether a piece is a king
    public boolean isKing() {
	return king;
    }
    
    //returns whether a piece is existing or not
    public boolean getStatus() {
	return status;
    }

    //sets king
    public void setKing(boolean x) {
	king = x;
    }

    //sets status
    public void setStatus(boolean x) {
	status = x;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ABSTRACT METHODS
    
    //opponents/players will show up differently on the board
    public abstract String toString();
}
