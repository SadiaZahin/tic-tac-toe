/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JFrame;
 


public class TTTFrame extends JFrame{
    public int r;
    public int c;
    
    JPanel p = new JPanel();
    XOButton Buttons[][] = new XOButton[3][3];
    public static void main(String[] args) {
        new TTTFrame();
    }
    public TTTFrame(){
        super("Tic Tac Toe");
        setSize(1000,1000);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        p.setLayout(new GridLayout(3,3));
        for(int i = 0; i<3; i++){
           for(int j = 0 ;j<3;j++){
            Buttons[i][j] = new XOButton(i,j);
           p.add(Buttons[i][j]);
           Buttons[i][j].r = i;
           Buttons[i][j].c = j;
           
           }
           
        }
        add(p);
        setVisible(true);
    }
    
    
    
}
