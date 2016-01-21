import cs1.Keyboard;

public class Checkers {

    public static void main(String[] args) {
	System.out.println("\tWELCOME TO\n\t CHECKERS\n\n");
	//elaborate on welcome msg? instructions?
	
	//TWO PLAYER FXNALITY TO BE ADDED LATER	
	
	Checkers game = new Checkers();
	game.play();
	
	// WIN MESSAGES
	
	//PLAY AGAIN? looping feature that sets up a boolean and keeps running play til player says no

    }


    public void play() {
	boolean win = false; // WHAT ABOUT TIE GAMES? may need a boolean to record who the winner is / if tie
	//until win = true, run following code
	Board b = new Board();
	System.out.println(b);
	//user input for coordinates of piece to move
	System.out.println("Enter row of piece to move: ");
	int pr = Keyboard.readInt();
	System.out.println("Enter column of piece to move: ");
	int pc = Keyboard.readInt();
	//user input for coordinates to move to
	System.out.println("Enter row of place to move to: ");
	int mr = Keyboard.readInt();
	System.out.println("Enter column of place to move to: ");
	int mc = Keyboard.readInt();
	b.move(pr,pc,mr,mc);
	System.out.println(b);
    }

}
