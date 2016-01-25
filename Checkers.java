//INFO: driver for other fxns, contains play functionality

import cs1.Keyboard;

public class Checkers {

    private boolean win = false;

    public static void main(String[] args) {
	System.out.println("\n\t\t\tWELCOME TO\n\t\t\t CHECKERS\n");
	
	Checkers game = new Checkers();

	//play easy or hard depending on user input
	System.out.print("Choose a level (E,H): ");
	String level = Keyboard.readString();

	while (!(level.equals("E") || level.equals("H"))) {
	    System.out.print("Please enter one of the level options: " );
	    level = Keyboard.readString();
	}
	
	if (level.equals("E")) {
	    while (game.playE())
		game.playE();
	}
	else {
	    while (game.playH())
		game.playH();
	}
	
    }


    //============================================
    //play levelE
    public boolean playE() {


	LevelE b = new LevelE();
        

	System.out.println("\nDIRECTIONS\n");
	System.out.println("The ID of each piece is named by the first two characters, composed of a letter and a number,");
	System.out.println("with the third character displaying what kind of piece it is (P for regular piece, K for king)");
	System.out.println("The directional inputs include front left, front right, back left, and back right,");
	System.out.println("and any direction that has a 'J' in it stands for jump\n");
	System.out.println("BEGIN");

	while (b.opponents.size() > 0 && b.friends.size() > 0) {
	    
	    //print board
	    System.out.println();
	    System.out.print(b);
	
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

	    //move users piece
	    //if can do multiple jumps, ask for input on that jump
	    while (b.move(r1,c1,r2,c2)) {
		r1 = r2;
		c1 = c2; //these are current positions now
		if (b.getPlayerRC(r1,c1).getMoves().contains("JR") ||
		    b.getPlayerRC(r1,c1).getMoves().contains("JL") ||
		    b.getPlayerRC(r1,c1).getMoves().contains("JBL") ||
		    b.getPlayerRC(r1,c1).getMoves().contains("JBR")) {
		    System.out.println("Jump again: " +
				       b.getPlayer(id).getMoves() + ": ");
		    while (!(b.getPlayer(id).getMoves().contains(m))) {
			System.out.print("Invalid move. Please choose another move: ");
			m = Keyboard.readString();
	
			//find row and column for move
			rc = b.getPlayer(id).findRCbyM(m,r1,c1);
			r2 = rc[0];
			c2 = rc[1];
		    }
		}				    
	    }
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
		System.out.println("Computer's turn.");

	    }

	    else {
		break;
	    }

	}

	//end game messages
	if (b.movables.size() == 0)
	    System.out.println("Tie game!");
	
	if (b.opponents.size() == 0) 
	    System.out.println("Congratulations, you have won the game.\n");
	
	if (b.friends.size() == 0) 
	    System.out.println("Sorry, you have lost the game.\n");
	

	
	//play again?
	System.out.print("Would you like to play again? (Y/N): ");
	String x = Keyboard.readString();

	while (!(x.equals("Y") || x.equals("N"))) {
	    System.out.print("Please enter Y or N: ");
	    x = Keyboard.readString();
	}

	if (x.equals("Y"))
	    return true;
	return false;
	
    }




    //=============================================
    //play levelH
    public boolean playH() {


	LevelH b = new LevelH();
        

	System.out.println("\nDIRECTIONS\n");
	System.out.println("The pieces are named by IDs composed of a letter and a number,\nwith the third character displaying what kind of piece it is (P for regular piece, K for king)\n");
	System.out.println("BEGIN");

	while (b.opponents.size() > 0 && b.friends.size() > 0) {
	    
	    //print board
	    System.out.println();
	    System.out.print(b);
	
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

	    //move users piece
	    //if can do multiple jumps, ask for input on that jump
	    while (b.move(r1,c1,r2,c2)) {
		r1 = r2;
		c1 = c2; //these are current positions now
		if (b.getPlayerRC(r1,c1).getMoves().contains("JR") ||
		    b.getPlayerRC(r1,c1).getMoves().contains("JL") ||
		    b.getPlayerRC(r1,c1).getMoves().contains("JBL") ||
		    b.getPlayerRC(r1,c1).getMoves().contains("JBR")) {
		    System.out.println("Jump again: " +
				       b.getPlayer(id).getMoves() + ": ");
		    while (!(b.getPlayer(id).getMoves().contains(m))) {
			System.out.print("Invalid move. Please choose another move: ");
			m = Keyboard.readString();
	
			//find row and column for move
			rc = b.getPlayer(id).findRCbyM(m,r1,c1);
			r2 = rc[0];
			c2 = rc[1];
		    }
		}				    
	    }
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
		System.out.println("Computer's turn.");

	    }

	    else {
		break;
	    }

	}

	//end game messages
	if (b.movables.size() == 0)
	    System.out.println("Tie game!");
	
	if (b.opponents.size() == 0) 
	    System.out.println("Congratulations, you have won the game.\n");
	
	if (b.friends.size() == 0) 
	    System.out.println("Sorry, you have lost the game.\n");
	

	
	//play again?
	System.out.print("Would you like to play again? (Y/N): ");
	String x = Keyboard.readString();

	while (!(x.equals("Y") || x.equals("N"))) {
	    System.out.print("Please enter Y or N: ");
	    x = Keyboard.readString();
	}
	
	System.out.print("\f");
	
	if (x.equals("Y"))
	    return true;
	return false;

    }

}
