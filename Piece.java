/*TO THINK ABOUT / DO:

  - how should status be used
  - is there a easier than the boolean king to change toString?
  - is the default constructor necessary?
  - is protected correct?

 */

public abstract class Piece {

    // instance variables
    protected boolean king;
    protected boolean status; // this for dead / alive? wb king?


    // default constructor -- needed?
    public Piece() {
	king = false;
	status = true;
    }

    // overloaded constructor
    public Piece(boolean s) {
	king = false;
	status = s;
    }
    
    //returns whether a piece is a king
    public boolean isKing() {
	return king;
    }
    
    //returns whether a piece is existing or not
    public boolean getStatus() {
	return status;
    }

    //sets king
    public setKing(boolean x) {
	king = x;
    }

    //sets status
    public setStatus(boolean x) {
	status = x;
    }


    // ABSTRACT METHODS
    
    //opponents/players will show up differently on the board
    abstract String toString();
}
