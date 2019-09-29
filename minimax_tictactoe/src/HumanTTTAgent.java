
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * An example class implementing Agent class for human players. The
 * implementation is coupled with the actual game (here, TickTackToe) the agent
 * is playing.
 *
 *
 */
public class HumanTTTAgent extends Agent implements ActionListener {

    //public int row = -1;
    //public int col = -1;
    static Scanner in = new Scanner(System.in);

    public HumanTTTAgent(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    
    @Override
    public void makeMove(Game game) {

        TicTacToe tttGame = (TicTacToe) game;

        //System.out.println("here");
        System.out.println("Enter Row and Col");

        while (true) {
            //System.out.println("here");
            int i = -1, k = -1, row, col;
            while (true) {
                int flag = 0;
                for (i = 0; i < 3; i++) {
                    for (k = 0; k < 3; k++) {
                        System.out.println("Waiting for input");
                        if (tttGame.buttons[i][k].value == 1) {
                            flag = 1; //System.out.println("IN THE LOOP"); 
                            tttGame.buttons[i][k].reset();
                            break;
                        }
                    }
                    if (flag == 1) {
                        break;
                    }
                }
                if (flag == 1) {
                    break;
                }
            }
            //i = -1; k = -1;
            System.out.println("value of i" + i + " value of k " + k);
            //Scanner in = new Scanner(System.in);
            //int row = in.nextInt();
            //int col = in.nextInt();

            row = i;
            col = k;
            //if(row==-1 && col==-1) continue; 

            if (tttGame.isValidCell(row, col)) {
                //System.out.println("Row is "+row+" Col is "+col); 
                tttGame.board[row][col] = role;
                tttGame.buttons[row][col].setIcon(tttGame.buttons[row][col].O);
                //row = -1; col = -1;
                break;

            } else {
                System.out.println("Please enter a valid row and col!!!");
                JOptionPane.showMessageDialog(null, "Please enter a valid row and col!!!");
            }
        }

    }
    

    /////For using user input 
    /*
    @Override
    public void makeMove(Game game) {

        TicTacToe tttGame = (TicTacToe) game;

        //System.out.println("here");
        System.out.println("Enter Row and Col");

        while (true) {

            Scanner in = new Scanner(System.in);
            int row = in.nextInt();
            int col = in.nextInt();

            //if(row==-1 && col==-1) continue; 
            if (tttGame.isValidCell(row, col)) {
                //System.out.println("Row is "+row+" Col is "+col); 
                tttGame.board[row][col] = role;
                tttGame.buttons[row][col].setIcon(tttGame.buttons[row][col].O);
                //row = -1; col = -1;
                break;

            } else {
                System.out.println("Please enter a valid row and col!!!");
            }
        }

    }
    */
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("presses");
    }

}
