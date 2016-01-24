//Medium
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
		if ((getPiece(r+1,c+1) instanceof Player)||(getPiece(r+2,c+2) instanceof Empty)) {
				move(r,c,r+2,c+2);
				//kill off player piece at (r+1,c+1)
			}
		}
		else if ((getPiece(r+1,c-1) instanceof Player)||(getPiece(r+2,c-2) instanceof Empty)) {
				move(r,c,r+2,c-2);
				//kill off player piece at (r+1,c-1)
			}
		}
	}
	
	//if opponent piece is in danger, move it away
	public void avoidKill() {
		int[] randP = randPiece();
		int r = randP[0];
		int c = randP[1];
		if ((getPiece(r+1,c+1) instanceof Player)||!(getPiece(r+2,c+2) instanceof Empty)||(getPiece(r+1,c-1) instanceof Empty)) {
			move(r,c,r+1,c-1);
		}
		else if ((getPiece(r+1,c-1) instanceof Player)||!(getPiece(r+2,c-2) instanceof Empty)||(getPiece(r+1,c+1) instanceof Empty)) {
			move(r,c,r+1,c+1);
		}
	}
	
	//if no interaction with player pieces, move a random piece forward
	//call LevelE.java?
	
	public static void main(String[] args) {
		LevelM b = new LevelM();
		System.out.println(b);
	}
	
}
