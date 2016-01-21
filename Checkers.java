import Keyboard.Keyboard;

public class Checkers {

    public static void main(String[] args) {
	System.out.println("\tWELCOME TO\n\t CHECKERS\n\n");
	//elaborate on welcome msg? instructions?
	
	/* TWO PLAYER FXNALITY TO BE ADDED LATER	
	System.out.println("Enter 1 for one player, 2 for two players; defaults to one player: \n");
	//player input
	
	if (numPlayers == 1) { 
	    System.out.println("Choose level of difficulty (1, 2, or 3)");	
	    //take player level input
	    play(level);
	}
	*/
	
	Checkers game = new Checkers();
	game.play();
	
	/* WIN MESSAGES -- should these depend on the play() method's return or should play be doing this?
	System.out.println("Congratulations, you win!")
	System.out.println("Your opponent won. Better luck next time.")
	System.out.println("Type play again to replay, exit to exit the game.")
	*/
	
	//PLAY AGAIN? looping feature that sets up a boolean and keeps running play til player says no

    }


    public void play(int level) {
	boolean win = false; // WHAT ABOUT TIE GAMES? may need a boolean to record who the winner is / if tie
	//until win = true, run following code
	Board game = new Board();
	System.out.println(game);
	//user input for piece to move
	//int x = Keyboard.readInt();
	//user input coordinates of piece they want to move
	int px = Keyboard.readInt();
	int py = Keyboard.readInt();
	//user input for direction to move in (FL, FR, JFL, JFR, BL, BR, JBL, JBR)
	//String y = Keyboard.readString();
	//user input coordinates to move this piece to
	int mx = Keyboard.readInt();
	int my = Keyboard.readInt();
	//jumps?
	//store [pieceNum, moveDirection]
	game.move(px,py,mx,my); // move will convert
	System.out.println(game);
	//check if win / possibility of other jumps -- loop this
	//update boolean
	//if not win, generate opponent move based on level
	//store in moveArray
	//game.move(moveArray);
	//System.out.println(game);
	//check if win
	//update boolean
	//if not win, back to user input for which piece to move
    }

}
