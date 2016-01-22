/* TO DO:
   - split play function into separate helpers?
   - two-player functionality (only if time allows)
   - elaborate on welcome message, instructions
   - winning / tie games
   - play again features
 */


import cs1.Keyboard;

public class Checkers {

    public static void main(String[] args) {
	System.out.println("\n\tWELCOME TO\n\t CHECKERS\n\n");
	
	Checkers game = new Checkers();
	game.play();

    }


    public void play() {

	//user input for what level to create correct board
	//--ask for user input for what level they want here

	
	//user input for coordinates of piece to move
	System.out.println("Enter row of piece to move: ");
	int r1 = Keyboard.readInt();
	System.out.println("Enter column of piece to move: ");
	int c1 = Keyboard.readInt();
	//user input for coordinates to move to
	System.out.println("Enter row of place to move to: ");
	int r2 = Keyboard.readInt();
	System.out.println("Enter column of place to move to: ");
	int c2 = Keyboard.readInt();

    }

}
