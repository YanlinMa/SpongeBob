CHECKERS

The game gives the user an option of playing against another person on the same Terminal session,
or against AI methods on the computer.

If the computer is chosen as an opponent, the player can then choose what level to play, out of easy, medium, or hard.

~~~~~~~~~~~~~~~~~~~~~~~~~

Gameplay:

Once the original board is displayed for the player, they are asked to select the ID of the piece they want to move,
and a list of possible directions will be displayed for them. The player will then input one of the directions provided,
which may include FL (front left), FR (front right), and for king pieces, BL (back left), and BR (back right).

After the player makes their move, either the second player will then take their turn, or the computer will generate a move
based on the difficulty of the game.



Levels are implemented with the presence of checkers strategies (or the lack thereof) in the moves of the opponent. After the player selects a level, the algorithm will scan the board to judge the best move to counteract the player’s advance.

The goal is to take out all the opponent's pieces, and the game will be won when all of the opponent's pieces have been killed, or when the opponent has no more moves.

~~~~~~~~~~~~~~~~~~~~~~~~~

To execute:

javac Checkers.java
java Checkers
