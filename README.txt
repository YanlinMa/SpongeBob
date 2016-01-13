CHECKERS IN TERMINAL

The game of checkers with three levels -- easy, medium, and hard -- to be run in the terminal.

The game has the option of being played against another player (on the same Terminal session) or against the computer. The player will choose a color (black or white).

~~~~~~~~~~~~~~~~~~~~~~~~~

Gameplay:

The player(s) is prompted to choose a numbered piece and can enter L, R, BL, BR to move left, right, back-left, back-right respectively. These selections are filtered so the piece must exist and the move must be allowed by game rules.

Levels are implemented with the presence of checkers strategies (or the lack thereof) in the moves of the opponent. After the player selects a level, the algorithm will scan the board to judge the best move to counteract the player’s advance.

The goal is to take out all the opponent's pieces, and the game will be won when all of the opponent's pieces have been killed, or when the opponent has no more moves.

~~~~~~~~~~~~~~~~~~~~~~~~~

To execute:

javac Checkers.java
java Checkers
