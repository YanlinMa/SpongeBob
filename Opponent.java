/*THINGS TO DO:

  - actually make it look like a piece

 */
/*TO THINK ABOUT / DO:
  
  - need default constructor?

 */

public class Opponent extends Piece { 

    
    // overloaded constructor
    public Opponent(boolean s) {
	king = false;
	status = s;
    }

    public String toString() {
	String retStr = "";
	
	if (!getStatus()) 
	    retStr = "=====\n=====\n=====";

	else if (isKing())
	    retStr = "=====\nOPkng\n=====";

	else
	    retStr = "=====\nOPpce\n=====";

	return retStr;
    }      


    public static void main(String[] args) {
	Opponent p = new Opponent(true);
	Opponent o = new Opponent(false);
	System.out.println(p + "\n\n");
	System.out.println(o + "\n\n");
	p.setKing(true);
	System.out.println(p);
    }

}
