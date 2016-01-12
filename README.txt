CHECKERS IN TERMINAL

The game of checkers with three levels -- easy, medium, and hard -- to be run in the terminal.

The game has the option of being played against another player (on the same Terminal session) or against the computer. The player will choose a color (black or white).

~~~~~~~~~~~~~~~~~~~~~~~~~

Gameplay:
The player(s) is prompted to choose a row and column they wish to move their piece to. The piece is selected using row/column. These selections are filtered so the piece must exist and the move must be allowed by game rules.

Levels are implemented with the presence checkers strategies (or the lack thereof) in the moves of the opponent. After the player selects a level, the algorithm will scan the board to judge the best move to counteract the player’s advance.

The game will be won when none of the player’s pieces remains.

~~~~~~~~~~~~~~~~~~~~~~~~~

To execute:
javac Checkers.java
java Checkers
