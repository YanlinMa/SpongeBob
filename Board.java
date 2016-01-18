public class Board {

    //instance variables
    
    private Object[][] grid = new Object[8][8];
    private int countP = 0;
    private int countO = 0;

    //accessors for instance variables

    
    //need method for generating move

    //make this take in diff inputs "FR" etc.
    public void move(int xInd, int yInd) {
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
