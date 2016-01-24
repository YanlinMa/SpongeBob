import java.util.ArrayList;

public class LevelE extends Board {
    
    //move random opponent piece randomly, no kings
    //assumes there are moves left
    public String[] AIMove() {
	String[] ret = new String[2];

        //select random piece from opponents
	Player x = opponents.get((int)(Math.random()*opponents.size()));
	ret[0] = x.getID();
	
	//select random move from that player's moves list
        String m = x.randMove();
	ret[1] = m;

	//return that move
	return ret;

    }

}
