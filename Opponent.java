public class Opponent extends Piece { //is this notation right?


    public String toString() {
	String retStr = "";
	
	if (!getStatus()) 
	    retStr = "=====\n=====\n=====";

	else if (isKing())
	    retStr = "=====\noking\n=====";

	else
	    retStr = "=====\noppce\n=====";
    }      
    

}
