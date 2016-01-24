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

        //find row and column of player w this id
	int[] rc = b.findRCbyID(id);
	int r1 = rc[0];
	int c1 = rc[1];
	
	//user selects which move
	System.out.print("choose a move " +
			 ((Player)b.getPiece(r1,c1)).getMoves() + ": ");
	String m = Keyboard.readString();
	
	while (!(((Player)b.getPiece(r1,c1)).getMoves().contains(m))) {
	    System.out.print("please choose another move: ");
	    m = Keyboard.readString();
	}
	
	//find row and column for move
	

	/*
	//move users piece
	b.move(r1,c1,r2,c2);

	//call for AI move
        //convert that to rows and columns -- MAKE THESE SEPARATE FXNS?
	//call b.move() on those rows and columns
	       
	System.out.println(b);
	*/
    }

   
    public int[] findRCbyM(String m) {

    }
    

}


