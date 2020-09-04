import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MiVentana extends JFrame implements ActionListener,KeyListener{
    CanvasPrueba canvas;
    JPanel panel;
    //long tiempo=System.currentTimeMillis();

    public MiVentana(){
        super();
        this.setLayout(new BorderLayout());
        this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent e){  System.exit(0); } });
        

        panel = new JPanel();
        canvas = new CanvasPrueba();
        this.add(canvas, BorderLayout.CENTER);
       
    }
    @Override
    public void actionPerformed(ActionEvent event){
        
    }
    public void keyTyped(KeyEvent e) {
    }
 
    public void keyPressed(KeyEvent e) {;
    }
 
    public void keyReleased(KeyEvent e) {
    }
    
}