public class Checkers {

    public static void main(String[] args) {
	System.out.println("\tCHECKERS\n\n");
	/* TWO PLAYER FXNALITY TO BE ADDED LATER	
	System.out.println("Type 1 for one player, 2 for two players; defaults to one player: \n");
	//player input
	
	if (numPlayers == 1) { 
	    System.out.println("Choose level of difficulty (1, 2, or 3)");	
	    //take player level input
	    play(level);
	}
	*/

    }


    public void play(int level) {
	boolean win = false;
	//until win = true, run following code
	Board b = new Board();
	System.out.println(b);
	//user input for which piece (piece's number);
	//user input for move (FL, FR, JFL, JFR, BL, BR, JBL, JBR)
	//store [pieceNum, moveDirection]
	b.move(moveArray);
	System.out.println(b);
	//check if win / possibility of other jumps -- loop this
	//if not, generate opponent move based on level
	//store in moveArray
	b.move(moveArray);
	System.out.println(b);
	//check if win
	//update boolean
	//back to loop
    }

}
