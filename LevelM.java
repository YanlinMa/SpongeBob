import java.util.ArrayList;

public class LevelM extends Board {
    
	//pick a random opponent piece
	Player x = opponents.get((int)(Math.random()*opponents.size()));
	ret[0] = x.getID();
    
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
	public void random() {
		String m = x.randMove();
		ret[1] = m;
	}
	
	public String[] AIMove() {
		String[] ret = new String[2];
		killPlayer();
		avoidKill();
		random();
		return ret;
	}
	
}
