CHECKERS IN TERMINAL

The game gives the user an option of playing against another person on the same Terminal session,
or against AI methods on the computer.

If the computer is chosen as an opponent, the player can then choose what level to play, out of easy, medium, or hard.

~~~~~~~~~~~~~~~~~~~~~~~~~

Gameplay:

Once the original board is displayed for the player, they are then asked to select the the piece they want to move.
********method undetermined.

The player(s) is prompted to choose a numbered piece and can enter L, R, BL, BR to move left, right, back-left, back-right respectively. These selections are filtered so the piece must exist and the move must be allowed by game rules.

Levels are implemented with the presence of checkers strategies (or the lack thereof) in the moves of the opponent. After the player selects a level, the algorithm will scan the board to judge the best move to counteract the player’s advance.

The goal is to take out all the opponent's pieces, and the game will be won when all of the opponent's pieces have been killed, or when the opponent has no more moves.

~~~~~~~~~~~~~~~~~~~~~~~~~

To execute:

javac Checkers.java
java Checkers

