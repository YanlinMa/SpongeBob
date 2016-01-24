//Hard
//don't move the last row of chess pieces unless absolutely necessary
//other pieces move to form a pyramid
//get as many pieces to the opposite side
//should be based on user moves, to kill off user pieces and prevent user from reaching opponent side

public class LevelH extends Board {
  
  //disable all moves for the last row of chess pieces r=0
  //unless all other pieces get killed off or there are no more moves for the other pieces
  
  //move pieces toward the middle 
  //pieces with c<=3 add value to their column number, pieces with c>=4 subtract value from their column number
  
  //start moving pieces closest to player side
  //unless move will result in piece getting killed
  //(sometimes an opponent piece needs to be sacrificed so that a player piece would move
  //and allow opponent piece to reach the end)
  
  //if a player move allows for a kill, only follow through if the opponent piece does not also get killed
  //when possible, allow the opponent pieces to line up in a diagonal so the pieces cannot be killed
  
}
