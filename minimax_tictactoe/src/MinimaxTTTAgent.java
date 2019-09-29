
/**
 * Example MiniMax agent extending Agent class.
 * Here, for simplicity of understanding min and max functions are written separately. One single function can do the task.
 *
 *
 */
public class MinimaxTTTAgent extends Agent {

    int noOfNodes = 0;

    public MinimaxTTTAgent(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void makeMove(Game game) {
        // TODO Auto-generated method stub

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        TicTacToe tttGame = (TicTacToe) game;
//        if (tttGame.BoardEmpty()) {
//            tttGame.board[1][1] = role;
//            tttGame.buttons[1][1].setIcon(tttGame.buttons[1][1].X);
//        } else 
        {
            CellValueTuple best = max(tttGame, 0, Integer.MAX_VALUE);
            if (best.col != -1) {
                tttGame.board[best.row][best.col] = role;
                tttGame.buttons[best.row][best.col].setIcon(tttGame.buttons[best.row][best.col].X);
            }
        }
        System.out.println("Number of Nodes Traversed " + noOfNodes);
        noOfNodes = 0;

    }

    private CellValueTuple max(TicTacToe game, int depth, int beta) {
        //noOfNodes++;
        int alpha = Integer.MIN_VALUE;
        // int beta = Integer.MAX_VALUE;
        CellValueTuple maxCVT = new CellValueTuple();
        maxCVT.utility = -100;

        int winner = game.checkForWin();
        if (game.isFinished()) {
            if (winner == 1) {
                maxCVT.utility = 1;
            }
            if (winner == 0) {
                maxCVT.utility = -1;
            }
            if (winner == -1) {
                maxCVT.utility = 0;
            }
            return maxCVT;
        }

        maxCVT.depth = depth;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game.isValidCell(i, j)) {

                    if (alpha >= beta) {
                        break;
                    }

                    noOfNodes++;
                    CellValueTuple temp = new CellValueTuple();
                    game.board[i][j] = role;

                    temp = min(game, depth++, alpha);

                    //beta = temp.beta;
                    game.board[i][j] = -1;
                    temp.row = i;
                    temp.col = j;
                    if (maxCVT.utility < temp.utility) {
                        maxCVT = temp;
                        //maxCVT.alpha = maxCVT.utility;
                        alpha = maxCVT.utility;
                        maxCVT.depth = depth;
                    }
                    if (maxCVT.utility == temp.utility && temp.utility == 1 && temp.depth < maxCVT.depth) {
                        maxCVT = temp;
                        //maxCVT.alpha = maxCVT.utility;
                        alpha = maxCVT.utility;
                    }

                    //if(maxCVT.utility>=alpha) alpha = maxCVT.utility;
//                    if (alpha >= beta) {
//                        break;
//                    }
                }

            }

//            if (alpha >= beta) {
//                        break;
//                    }
        }
        //Check if the terminating condition is fullfilled and return the object of CellValueTuple
        //implement max function of minimax/alpha-beta pruning algorithm
        //traverse the whole board
        //temporarily machine agent occupy the empty cell
        //call for min function of human agent
        //update maxcvt
        //go to previous state

        return maxCVT;

    }

    private CellValueTuple min(TicTacToe game, int depth, int alpha) {
        //noOfNodes++;
        int beta = Integer.MAX_VALUE;
        CellValueTuple minCVT = new CellValueTuple();
        minCVT.utility = 100;

        int winner = game.checkForWin();
        //System.out.println("winner min " + winner);
        if (game.isFinished()) {
            if (winner == 1) {
                minCVT.utility = 1;
            }
            if (winner == 0) {
                minCVT.utility = -1;
            }
            if (winner == -1) {
                minCVT.utility = 0;
            }
            return minCVT;
        }

        //Check if the terminating condition is fullfilled and return the object of CellValueTuple
        minCVT.depth = depth;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game.isValidCell(i, j)) {

                    if (alpha >= beta) {
                        break;
                    }
                    noOfNodes++;
                    CellValueTuple temp = new CellValueTuple();
                    game.board[i][j] = minRole();
                    temp = max(game, depth++, beta);

                    //alpha = temp.alpha;
                    game.board[i][j] = -1;
                    temp.row = i;
                    temp.col = j;
                    if (minCVT.utility > temp.utility) {
                        minCVT = temp;
                        //minCVT.beta = minCVT.utility;
                        beta = minCVT.utility;
                        minCVT.depth = depth;
                    }
                    if (minCVT.utility == temp.utility && temp.utility == -1 && temp.depth < minCVT.depth) {
                        minCVT = temp;
                        // minCVT.beta = minCVT.utility;
                        beta = minCVT.utility;
                    }
                    //if(minCVT.utility <= beta) beta = minCVT.utility;
//                    if (alpha >= beta) {
//                        break;
//                    }

                }

            }
//            if (alpha >= beta) {
//                        break;
//                    }
        }

        //implement min function of minimax/alpha-beta pruning algorithm 
        return minCVT;

    }

    private int minRole() {
        if (role == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    class CellValueTuple {

        int row, col, utility, depth;

        public CellValueTuple() {
            // TODO Auto-generated constructor stub
            row = -1;
            col = -1;
//            beta = Integer.MAX_VALUE;
//            alpha = Integer.MIN_VALUE;
        }
    }

}
