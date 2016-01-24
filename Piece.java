import java.util.ArrayList;

/*TO THINK ABOUT / DO:

  - naming system? -- implement later

 */

public abstract class Piece {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // instance variables
    protected boolean king;
    protected boolean status; 
    protected int row;
    protected int col;
   

    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //methods

    //default constructor
    public Piece() {
	king = false;
	status = true;
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
