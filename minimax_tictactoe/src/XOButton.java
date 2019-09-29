import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sadia
 */

   
public class XOButton extends JButton implements ActionListener{
    
    ImageIcon X,O;
    byte value = 0;
    int r;
    int c;
    int x,y; 
    
    
     
    
    
    public XOButton(int i,int j){
       X = new ImageIcon(this.getClass().getResource("x.png"));
       O = new ImageIcon(this.getClass().getResource("o.png"));
       x=i;
       y=j;
       
       this.addActionListener(this);
       
       
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        value = 1;
       
        System.out.println("BUTTON PRESSED at pos "+this.r+" "+this.c);
       
//       switch(value){
//           //case 0:  setIcon(null); break;
//           case 1:  setIcon(X);  break;
//           //case 2:  setIcon(O); break;
//            
//       }
    }
    public void reset(){
       value = 0;
    }
}
