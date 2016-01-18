/*TO THINK ABOUT / DO:

  - how should status be used
  - is there a easier than the boolean king to change toString?
  - is protected correct?
  - is pieceNum necessary or just use naming system?

 */

public abstract class Piece {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // instance variables
    protected boolean king;
    protected boolean status; // this for dead / alive? wb king?
    protected int pieceNum;


    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //methods
    
    
    //returns whether a piece is a king
    public boolean isKing() {
	return king;
    }
    
    //returns whether a piece is existing or not
    public boolean getStatus() {
	return status;
    }

    //returns pieceNum
    public int getPieceNum() {
	return pieceNum;
    }

    //sets king
    public void setKing(boolean x) {
	king = x;
    }

    //sets status
    public void setStatus(boolean x) {
	status = x;
    }

    //sets pieceNum
    public void setPieceNum(int x) {
	pieceNum =  x;
    }


    
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ABSTRACT METHODS
    
    //opponents/players will show up differently on the board
    public abstract String toString();
}
