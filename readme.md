#CHECKERS

*Team SpongeBob - Andrea Ma, Jannie Li*


##About

The game is played against the computer with two possible levels of difficulty, easy or hard.

The pieces are named by their IDs, which are the first two characters in their label (one is a letter, one is a number), and the third character is either P, which stands for a regular piece, or K, which stands for a King. The pieces that have "AI" as the first two characters of their label are the opponent pieces, which cannot be controlled by the player.

The moves are chosen from a list of possible directions, which may include FL (front left), FR (front right), JFL (jump front left), JFR (jump front right), and for king pieces, BL (back left), BR (back right), JBL (jump back left), and JBR (jump back right).

The computer generates moves based on the difficulty of the game. Level Easy is implemented with methods that randomly select a piece to move, and then randomly selects a direction to move in, while Level Hard prioritizes killing the user's pieces and moves their own pieces away from danger.

The goal of the game is to take out all of the opponent's pieces, and the game will be won when all of the opponent's pieces
have been killed, or when the opponent has no more moves. Likewise, the player loses the game if all of their pieces have
been killed, or if they have no more possible moves.


##To Execute:

Type `javac Checkers.java` then `java Checkers` into Terminal after cloning or downloading this repository.
Make sure you're in the right folder (SpongeBob).


##Gameplay:

1. Select a level of difficulty.
2. The game will begin. 
3. Type the ID of the piece to be moved.
4. A list of possible moves will be displayed. Type one of the moves to execute.
5. The computer will then generate the opponent's move.
6. After the game ends, you will be offered the option of playing again, or exiting.
