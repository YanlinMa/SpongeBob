#CHECKERS
*Team SpongeBob - Andrea Ma, Jannie Li*


##About
The game is played against the computer with two possible levels of difficulty, easy or hard.

Once a level is selected, the original board is displayed for the player, and they are asked to select the ID of the piece
they want to move. The IDs are the first two characters that label each piece, and the third character is either P, which
stands for a regular piece, or K, which stands for a King. After the player inputs a valid ID, a list of possible directions
will be displayed for them. The possible directions include FL (front left), FR (front right), JFL (jump front left), JFR
(jump front right), and for king pieces, BL (back left), BR (back right), JBL (jump back left), and JBR (jump back right).
The player will input a valid move based on the directions provided, and the board will be reprinted after the move.

After the player makes their move, the computer will generate a move based on the difficulty of the game. Level Easy is
implemented with methods that randomly select a piece to move, and then randomly selects a direction to move in, while
Level Hard prioritizes killing the user's pieces and moves their own pieces away from danger.

The goal of the game is to take out all of the opponent's pieces, and the game will be won when all of the opponent's pieces
have been killed, or when the opponent has no more moves. Likewise, the player loses the game if all of their pieces have
been killed, or if they have no more possible moves.

##To Execute:
Type `javac Checkers.java`
then `java Checkers`
into Terminal after cloning or downloading this repository.
Make sure you're in the right folder (SpongeBob).


##Gameplay:

1. Choose a level (E or H).
2. The game will begin. 
3. Type the ID of the piece you want to move to select it. (The ID is the first two letters of what is displayed on your side of the checkerboard. You can tell a piece is yours if it doesn't have "AI" in front. The last letter, either P or K, represents the status of your piece. P is a player who can move only in the opposite direction from its original side. K is a king who can move in any direction.
4. You will be presented with a list of possible moves. Type one to choose it. The moves will be explained below.
5. Your game will end with either a tie or a winner. You will then be offered the option of playing it again.


##Levels

* **Easy (E)** : You are playing against a random select-random move system.
* **Hard (H)** : You are playing against a kill / move away depending on what's possible system.


##Moves

* **FR** : Forward Right
* **FL** : Forward Left
* **JFR** : Jump Front Right
* **JFL** : Jump Front Left
* **BR** : Back Right
* **BL** : Back Left
* **JBR** : Jump Back Right
* **JBL** : Jump Back Left
