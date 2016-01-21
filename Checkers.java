import java.util.Scanner;

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
    }

}
