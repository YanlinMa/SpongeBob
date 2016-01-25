CHECKERS

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

~~~~~~~~~~~~~~~~~~~~~~~~~

To execute:

javac Checkers.java
java Checkers
