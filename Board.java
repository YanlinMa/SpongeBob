/* TO THINK ABOUT / DO
   
   - are accessors needed for instance variables?
   - read comments throughout
   - implement user-friendly move fxns and its helpers

*/

public class Board {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //instance variables
    
    private Object[][] grid = new Object[8][8];
    private int countP = 0;
    private int countO = 0;


    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //constructors
    
    public Board() {
	setup();
    }

    

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //methods
    
    
    //need method for generating move coordinates (see comment directly below)
    public void convertToCoord(String in) {
	
    }

    //make this take in diff inputs "FL" etc. and convert them? (helper fxn?)
    //do above later-- just use coordinates now
    public void move(String[] input) {
	
    }
    
    //public boolean canMove() -- ?? what was this again? necessary?
    //public voolean proper() -- same with this one?

    public Piece getPiece(int xInd, int yInd) {
    }

    public void setup() {
    }

    public String toString() {
    }


    //check for wins (not on UML) -- wb ties? what should it return?
    public boolean checkWin() {
    }

}
