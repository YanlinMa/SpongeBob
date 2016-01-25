import java.util.ArrayList;

public class LevelH extends Board {
 
    //if there is a jump available, the AI takes it
    //assumes moves left
    public String[] AIMove() {
	boolean canKill = false;
	String id = "";
	String move = "";
	int[] dangerLoc = new int[2];
	boolean dangerDir = false; //true -> right, false -> left
	boolean danger = false;
	String[] ret = new String[2];

	for (Player x : opponents) {
	    if (x.getMoves().contains("JR") ||
		x.getMoves().contains("JL")) {
		canKill = true;
	        id = x.getID();
	    }
	}

	for (Player x : friends) {
	    if (x.getMoves().contains("JR")) {
		dangerLoc = findRCbyID(x.getID());
		dangerDir = true;
		danger = true;
	    }
	    else if (x.getMoves().contains("JL")) {
		dangerLoc = findRCbyID(x.getID());
	        dangerDir = false;
		danger = true;
	    }
	}


	if (canKill) {
	    if (Math.random() < .75) {
		ret[0] = id;
		if (getPlayer(id).getMoves().contains("JR"))
		    ret[1] = "JR";
		else
		    ret[1] = "JL";
	    }
	}
	else if (danger) {
	    ret[0] = id;
	    if (dangerDir && inBounds(dangerLoc[0]+1) && inBounds(dangerLoc[1]+1)) {
		if (grid[dangerLoc[0]+1][dangerLoc[1]+1] instanceof Player) {
		    if (getPlayerRC(dangerLoc[0]+1,dangerLoc[1]+1).getMoves().contains("FR")) {
			ret[1] = "FR";
		    }
		    else if (getPlayerRC(dangerLoc[0]+1,dangerLoc[1]+1).getMoves().contains("FL")) {
			ret[1] = "FL";
		    }
		}
	    }
	    else if (inBounds(dangerLoc[0]+1) && inBounds(dangerLoc[1]-1)){
		if (grid[dangerLoc[0]+1][dangerLoc[1]-1] instanceof Player) {
		    if (getPlayerRC(dangerLoc[0]+1,dangerLoc[1]-1).getMoves().contains("FR")) {
			ret[1] = "FR";
		    }
		    else if (getPlayerRC(dangerLoc[0]+1,dangerLoc[1]-1).getMoves().contains("FL")) {
			ret[1] = "FL";
		    }
		}
	    }
	}
        if (ret[1] == null || ret[0] == null) { //move random piece randomly
	    Player x = opponents.get((int)(Math.random()*opponents.size()));
	    ret[0] = x.getID();
	    ret[1] = x.randMove();
	}
	
	return ret;

    }

}
