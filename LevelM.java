//Medium
//if there is a possible move to kill off an opponent's piece, implement this
//if piece at danger, move away 
//if both of the above are true, randomly select one to do
//if no opponent pieces are near, move a random piece forward

public class LevelM extends Board {
    
	//pick a random opponent piece
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
    
    	//possibility to kill off a player piece
	public void killPlayer() {
		int[] randP = randPiece();
		int r = randP[0];
		int c = randP[1];
		if (getPiece(r+1,c+1) instanceof Player) {
			if (getPiece(r+2,c+2) instanceof Empty) {
				move(r,c,r+2,c+2);
				//kill off player piece at (r+1,c+1)
			}
		}
		else if (getPiece(r+1,c-1) instanceof Player) {
			if (getPiece(r+2,c-2) instanceof Empty) {
				move(r,c,r+2,c-2);
				//kill off player piece at (r+1,c-1)
			}
		}
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
	    LevelX b = new LevelX();
	    System.out.println(b);
	    b.move(5,1,4,2);
    	System.out.println(b);
    }

}
