package cs5004.marblesolitaire.model;

/**
 * @author Yong Shi
 * @since 2021-7-8
 *
 * This is the Marble Solitaire Model implementation class.
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel{
    int[][] game;
    int r;
    int c;

    /**
     * This is the first constructor to take no parameter
     * and create arm thickness 3 and with empty slot at center.
     */
    public MarbleSolitaireModelImpl() {
        // in this my whole code, use 1 rep the position with marble
        // 0 rep empty; and -1 rep for out of board on left and -2 for right
        this.game = new int[][] {
                /*
                {-1,-1,1,1,1,-2,-2},
                {-1,-1,1,1,1,-2,-2},
                {1,1,1,1,1,1,1},
                {1,1,1,0,1,1,1},
                {1,1,1,1,1,1,1},
                {-1,-1,1,1,1,-2,-2},
                {-1,-1,1,1,1,-2,-2}
                 */

                /**
                 * test of game start, to test move, game over, quit.
                */
                {-1,-1,0,0,0,-2,-2},
                {-1,-1,0,0,0,-2,-2},
                {0,0,0,0,0,0,0},
                {0,1,1,0,0,0,0},
                {0,0,0,0,0,0,0},
                {-1,-1,0,0,0,-2,-2},
                {-1,-1,0,0,1,-2,-2}

        };
        this.r = 7;
        this.c = 7;
    }

    /**
     * This is the 2nd constructor to take 2 parameters for the empty slot
     * and create arm thickness 3 and with empty slot as the parameters.
     */
    public MarbleSolitaireModelImpl(int sRow, int sCol) {
        int r=7, c=7;
        if (sRow>=r || sRow<0 || sCol>=c || sCol<0) {
            throw new IllegalArgumentException("Invalid empty cell position ("+sRow+","+sCol+")");
        }
        // in this my whole code, use 1 rep the position with marble
        // 0 rep empty; and -1 rep for out of board on left and -2 for right
        int[][] newGame =new int[][] {
                {-1,-1,1,1,1,-2,-2},
                {-1,-1,1,1,1,-2,-2},
                {1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1},
                {-1,-1,1,1,1,-2,-2},
                {-1,-1,1,1,1,-2,-2}
        };
        if (newGame[sRow][sCol]>0) {
            newGame[sRow][sCol] = 0;
        }else if (newGame[sRow][sCol]<0){
            throw new IllegalArgumentException("Invalid empty cell position ("+sRow+","+sCol+")");
        }
        this.game = newGame;
        this.r = r;
        this.c = c;
    }

    /**
     * This is the 3rd constructor to take one parameter of arm thickness
     * and create arm thickness with parameter and with empty slot at center.
     */
    public MarbleSolitaireModelImpl(int armThk) {
        // row and col total length is armThk*3-2
        int r=armThk*3-2;
        int c=armThk*3-2;
        if (armThk<1 || armThk%2!=1 || armThk>r || armThk>c) {
            throw new IllegalArgumentException("arm thickness should be a positive odd number");
        }
        // in this my whole code, use 1 rep the position with marble
        // 0 rep empty; and -1 rep for out of board on left and -2 for right
        int[][] newGame =new int[r][c];
        for (int i=0;i<r;i++) {
            for (int j=0;j<c;j++) {
                if ((i<(r-armThk)/2 || i>r-1-(r-armThk)/2) && j<(c-armThk)/2) {
                    newGame[i][j] = -1;
                }else if ((i<(r-armThk)/2 || i>r-1-(r-armThk)/2) && j>c-1-(c-armThk)/2) {
                    newGame[i][j] = -2;
                }else {
                    newGame[i][j] = 1;
                }
            }
        }
        newGame[(r-1)/2][(c-1)/2] = 0;
        this.game = newGame;
        this.r = r;
        this.c = c;
    }

    /**
     * This is the 4th constructor to take parameters of arm thickness and empty slot
     * and create arm thickness with parameter and with empty slot with parameters.
     */
    public MarbleSolitaireModelImpl(int armThk, int sRow, int sCol) {
        int r=armThk*3-2;
        int c=armThk*3-2;
        if (sRow>=r || sRow<0 || sCol>=c || sCol<0) {
            throw new IllegalArgumentException("Invalid empty cell position ("+sRow+","+sCol+")");
        }
        if (armThk<1 || armThk%2!=1 || armThk>r || armThk>c) {
            throw new IllegalArgumentException("arm thickness should be a positive odd number");
        }
        // in this my whole code, use 1 rep the position with marble
        // 0 rep empty; and -1 rep for out of board on left and -2 for right
        int[][] newGame =new int[r][c];
        for (int i=0;i<r;i++) {
            for (int j=0;j<c;j++) {
                if ((i<(r-armThk)/2 || i>r-1-(r-armThk)/2) && j<(c-armThk)/2) {
                    newGame[i][j] = -1;
                }else if ((i<(r-armThk)/2 || i>r-1-(r-armThk)/2) && j>c-1-(c-armThk)/2) {
                    newGame[i][j] = -2;
                }else {
                    newGame[i][j] = 1;
                }
            }
        }
        if (newGame[sRow][sCol]>0) {
            newGame[sRow][sCol] = 0;
        }else if (newGame[sRow][sCol]<0){
            throw new IllegalArgumentException("Invalid empty cell position ("+sRow+","+sCol+")");
        }
        this.game = newGame;
        this.r = r;
        this.c = c;
    }

    /**
     * This is the toString method that end of each line with no space print out
     * so I use \b to eat each line the last one space, and last line no \n.
     */
    @Override
    public String toString() {
        StringBuilder printOut = new StringBuilder();
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++) {
                if (game[i][j]==-1) {
                    printOut.append("  ");
                }else if (game[i][j]==0) {
                    printOut.append("_ ");
                }else if (game[i][j]==1) {
                    printOut.append("o ");
                }
            }
            if (i<r-1) {
                printOut.append("\b\n");
            }else if (i==r-1) {
                printOut.append("\b");
            }
        }
        return printOut.toString();
    }

    /**
     * This is the canMove helper method to check if the given x,y slot can move or not.
     * Basic algorithm is for any valid position if meet the game move rule
     * will return true, at the up/dn/l/r 4 directions.
     */
    @Override
    public boolean canMove(int x, int y) {
        if (x>=r || x<0 || y>=c || y<0 || game[x][y]!=1) {
            return false;
            // throw new IllegalArgumentException("Invalid cell position move from Row and Column ("+x+","+y+")");
        }
        if (x+2<r && game[x+1][y]==1 && game[x+2][y]==0){
            return true;
        }else if (x-2>=0 && game[x-1][y]==1 && game[x-2][y]==0) {
            return true;
        }else if (y+2<c && game[x][y+1]==1 && game[x][y+2]==0) {
            return true;
        }else if (y-2>=0 && game[x][y-1]==1 && game[x][y-2]==0) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * This is the move method with taking from x,y position to x,y position.
     * So here I use the canMove helper to check the from x,y can move, and to x,y is empty,
     * then make the move, to reset the original position to empty and
     * route position to empty, destination to occupied.
     */
    @Override
    public void move(int fromRow, int fromColumn, int toRow, int toColumn) {
        if (canMove(fromRow, fromColumn)) {
            if (toRow==fromRow+2 && toColumn==fromColumn) {
                game[fromRow][fromColumn] = 0;
                game[fromRow+1][fromColumn] = 0;
                game[fromRow+2][fromColumn] = 1;
            } else if (toRow==fromRow-2 && toColumn==fromColumn) {
                game[fromRow][fromColumn] = 0;
                game[fromRow-1][fromColumn] = 0;
                game[fromRow-2][fromColumn] = 1;
            } else if (toRow==fromRow && toColumn==fromColumn+2) {
                game[fromRow][fromColumn] = 0;
                game[fromRow][fromColumn+1] = 0;
                game[fromRow][fromColumn+2] = 1;
            } else if (toRow==fromRow && toColumn==fromColumn-2) {
                game[fromRow][fromColumn] = 0;
                game[fromRow][fromColumn-1] = 0;
                game[fromRow][fromColumn-2] = 1;
            } else {
                // throw new IllegalArgumentException("Invalid cell position move to Row and Column ("+toRow+","+toColumn+")");
            }
        } else {
            // throw new IllegalArgumentException("Invalid cell position move from Row and Column ("+fromRow+","+fromColumn+")");
        }
    }

    /**
     * this is the get game state method that actually I already did the format at toString,
     * so just use it.
     * @return toString()
     */
    @Override
    public String getGameState() {
        return this.toString();
    }

    /**
     * this is the check if game is over, algorithm I use
     * is to check every slot on board if can move, means not over yet
     * @return boolean
     */
    @Override
    public boolean isGameOver() {
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (game[i][j]==1 && canMove(i,j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * this is get score method, simply to add all the 1 together, which
     * will be the total sum of the left marble on board.
     * @return int
     */
    @Override
    public int getScore() {
        int score = 0;
        for (int i=0;i<r;i++) {
            for (int j=0;j<c;j++) {
                if (game[i][j]==1) {
                    score++;
                }
            }
        }
        return score;
    }

}
