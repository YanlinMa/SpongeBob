/* TO DO:
   - elaborate on welcome message, instructions
   - winning / tie games
   - play again features
*/


import cs1.Keyboard;

public class Checkers {

	private boolean win = false;

    public static void main(String[] args) {
	System.out.println("\n\t\t\tWELCOME TO\n\t\t\t CHECKERS\n");
	
	Checkers game = new Checkers();
	game.play();

	System.out.flush();

    }


    public void play() {

	/*
	//user input for what level to create correct board
	System.out.println("Choose a level (E,M,H): ");
	String level = Keyboard.readString();
	
	//make board depending on level (currently there is one..)

        if (level.equals("E")) {
	LevelE b = new LevelE();
	}
	else if (level.equals("M")) {
	LevelM b = new LevelM();
	}
	else {
	LevelH b = new LevelH();
	}
	*/
	LevelE b = new LevelE();
	System.out.println("DIRECTIONS\n");
	System.out.println("The pieces are named by IDs composed of a letter and a number,\nwith the third character displaying what kind of piece it is (P for regular piece, K for king)\n");
	System.out.println("BEGIN");

	while (b.opponents.size() > 0 && b.friends.size() > 0) {
	    
	    //print board
	    System.out.println();
	    System.out.println(b);
	
	    //user selects piece to move
	    System.out.print("Enter the ID (first two characters displayed) of the piece to move: ");
	    String id = Keyboard.readString();

	    while (!b.contains(id)) {
		System.out.print("Invalid ID. Please enter another ID: ");
		id = Keyboard.readString();   
	    }

	    //user selects which move
	    System.out.print("Choose a move " +
			     (b.getPlayer(id)).getMoves() + ": ");
	    String m = Keyboard.readString();
	
	    while (!(b.getPlayer(id).getMoves().contains(m))) {
		System.out.print("Invalid move. Please choose another move: ");
		m = Keyboard.readString();
	    }

	    //find row and column of player w this id
	    int[] rc = b.findRCbyID(id);
	    int r1 = rc[0];
	    int c1 = rc[1];	
	
	    //find row and column for move
	    rc = b.getPlayer(id).findRCbyM(m,r1,c1);
	    int r2 = rc[0];
	    int c2 = rc[1];

	    //move users piece -- STILL NEED EXTRA JUMP FXN
	    b.move(r1,c1,r2,c2);
	    System.out.println();
	    System.out.print(b);

	    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	    //if moves left, AI goes
	    if (b.opponents.size() > 0) {
	    
		//call for AI move
		String[] ai = b.AIMove();
		id = ai[0];
		m = ai[1];

		//find row and column of player w this id
		rc = b.findRCbyID(id);
		r1 = rc[0];
		c1 = rc[1];	
	
		//find row and column for move
		rc = b.getPlayer(id).findRCbyM(m,r1,c1);
		r2 = rc[0];
		c2 = rc[1];

		b.move(r1,c1,r2,c2);

	    }

	    else {
		break;
	    }

	}

	if (b.opponents.size() == 0) {
		System.out.println("Congratulations, you have won the game.");
	}
	
	if (b.friends.size() == 0) {
		System.out.println("Sorry, you have lost the game.");
	}
	
    }

}
