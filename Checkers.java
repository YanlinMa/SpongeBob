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
	/*
	//user input for what level to create correct board
	System.out.println("Choose a level (X,1,2,3): ");
	String level = Keyboard.readString();
	*/
	//make board depending on level (currently there is one..)
	LevelX b = new LevelX();

	System.out.println(b);
	
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


	while (!b.move(r1,c1,r2,c2))
	    System.out.println("Please enter another set of coordinates");

	//b.AIMove();

	System.out.println(b);

	System.out.println(b);

    }

    public int[] getUserMove() {
    }

}


