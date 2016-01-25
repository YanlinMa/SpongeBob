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
  	
  	//see if any of them can jump
	for (Player x : opponents) {
	    if (x.getMoves().contains("JFR") ||
		x.getMoves().contains("JFL")) {
		canKill = true;
	        id = x.getID();
	    }
	}

    	//see if any of the user's pieces can jump
	for (Player x : friends) {
	    if (x.getMoves().contains("JFR")) {
		dangerLoc = findRCbyID(x.getID());
		dangerDir = true;
		danger = true;
	    }
	    else if (x.getMoves().contains("JFL")) {
		dangerLoc = findRCbyID(x.getID());
	        dangerDir = false;
		danger = true;
	    }
	}

  	//if can jump, do it
	if (canKill) {
	    ret[0] = id;
	    if (getPlayer(id).getMoves().contains("JFR"))
		ret[1] = "JFR";
	    else
		ret[1] = "JFL";
	}
	//if not, move away from player's jump
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
	//finally, if all fails, move randomly
        if (ret[1] == null || ret[0] == null) { //move random piece randomly
	    Player x = opponents.get((int)(Math.random()*opponents.size()));
	    ret[0] = x.getID();
	    ret[1] = x.randMove();
	}
	
	return ret;

    }

}
