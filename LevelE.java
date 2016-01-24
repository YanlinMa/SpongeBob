/* TO DO:
 - test & simplify
 - other levels - should each be a separate method or ?
*/


public class LevelE extends Board {

    // return random opponent player piece in Board
    // that 
    public int[] randPiece() {
	int[] ret = new int[2];
	int r = (int)(Math.random()*8);
	int c = (int)(Math.random()*8);
	
	while (getPiece(r,c) instanceof Empty) {
	    r = (int)(Math.random()*8);
	    c = (int)(Math.random()*8);
	}

	ret[0] = r;
	ret[1] = c;
	return ret;
    }

    // move random piece randomly, no jumps / kings
    public void AIMove() {
	int[] coo = randPiece();
	int r = coo[0];
	int c = coo[1];

	while (!( ((Player)getPiece(r,c)).isOpponent() &&
		  getPiece(r,c).getStatus() &&
		  hasMoves(r,c))) {
	    r = (int)(Math.random()*8);
	    c = (int)(Math.random()*8); 
	}

	if (proper(r,c,r-1,c+1) && proper(r,c,r-1,c-1))
	    if (Math.random() < .5) //choose random move if two possible
	    	move(r,c,r-1,c+1);
	    else
	    	move(r,c,r-1,c+1);
	else
	    if (proper(r,c,r-1,c-1))
	    	move(r,c,r-1,c-1);
	    else
	    	move(r,c,r-1,c+1);

    }

    public static void main(String[] args) {
	LevelE b = new LevelE();
	System.out.println(b);
	b.move(5,1,4,2);
	System.out.println(b);
    }

}
