/* THINGS TO THINK ABOUT / DO:

 - does this have to be a Piece (well, no, but should it?)
(currently is one bc don't want Object[][] but that's arbitrary)

*/

public class Empty extends Piece { 

    public String toString() {
	String retStr = "";

	retStr = "|======|";

	return retStr;
    }      

}
