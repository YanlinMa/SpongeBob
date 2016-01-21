public class Other {

    public static int[] randPiece(Board b) {
	int[] ret = new int[2];
	
	while (b.getPiece(r,c) instanceof Empty) {
	    r = (int)(Math.random()*8);
	    c = (int)(Math.random()*8);
	}
	ret[0] = r;
	ret[1] = c;
	return ret;
    }

    public static void nextMove(Board b) {
	int[] coo = randPiece(b);
	int r = coo[0];
	int c = coo[1];

        while ((b.getPiece(r,c).getFriend() || !b.getPiece(r,c).getStatus())
	       && !b.hasMoves(r,c)) { //until opponent piece and alive and has moves
	    coo = randPiece(b);
	    r = coo[0];
	    c = coo[1];
	}

	if (b.proper(r,c,r-1,c+1))
	    b.move(r,c,r-1,c+1);
	else
	    b.move(r,c,r-1,c-1); 
	    	
    }

    public static void main(String[] args) {

	Board b = new Board();

	nextMove(b);
	System.out.println(b);
	
    }

}
