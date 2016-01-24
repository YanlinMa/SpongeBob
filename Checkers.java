/* TO DO:
   - split play function into separate helpers?
   - two-player functionality (only if time allows)
   - elaborate on welcome message, instructions
   - winning / tie games
   - play again features
   - make sure user inputs are ok (default selections or while loops)
   - write direction function
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

	//print board
	System.out.println(b);
	
	//user selects piece to move
	System.out.print("enter the id of the piece to move: ");
        String id = Keyboard.readString();

	while (!b.contains(id)) {
	    System.out.print("Please enter another id: ");
	    id = Keyboard.readString();   
	}

	//user selects which move
	System.out.print("choose a move " +
			 (b.getPlayer(id)).getMoves() + ": ");
	String m = Keyboard.readString();
	
	while (!(b.getPlayer(id).getMoves().contains(m))) {
	    System.out.print("please choose another move: ");
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
	b.move(r1,c1,r2,c2);
	System.out.println(b);

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

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

        //move AI piece
	b.move(r1,c1,r2,c2);
	
	System.out.println(b);
    }

}


