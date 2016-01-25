import java.util.ArrayList;

//accounts for attributes of the pieces on the checkerboard

public abstract class Piece {

    //instance variables
    protected boolean king;
    protected boolean status; 
    protected int row;
    protected int col;

    //default constructor
    public Piece() {
	king = false;
	status = true;
    }
    
    //returns whether a piece is a king
    public boolean isKing() {
	return king;
    }
    
    //returns whether a piece exists or not
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

    //abstract method
    //opponents/players will show up differently on the board
    public abstract String toString();
    
}
