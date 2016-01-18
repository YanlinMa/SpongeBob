public abstract class Piece {

    // instance variables
    private boolean king;
    private boolean status; // this for dead / alive? wb king?


    // default constructor -- needed?
    public Piece() {
	king = false;
	status = true;
    }

    // overloaded constructor
    public Piece(boolean s) {
	kingt = false;
	status = s;
    }
    
    
    public boolean isKing() {
	return king;
    }
    

    public boolean getStatus() {
	return status;
    }


    abstract String toString();


    public setKing(boolean x) {
	king = x;
    }


    public setStatus(boolean x) {
	status = x;
    }

}
