 
import java.awt.event.*;

public class Jugable extends Sprite implements KeyListener {
 
    private boolean arriba, abajo, izquierda, derecha;
 
    public void actualiza() {
        if(arriba==true) this.setY(this.getY()-10);
        if(abajo==true) this.setY(this.getY()+10);
        if(izquierda==true) this.setX(this.getX()-10);
        if(derecha==true) this.setX(this.getX()+10);
    }
 
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                abajo = false;
                break;
            case KeyEvent.VK_UP:
                arriba = false;
                break;
            case KeyEvent.VK_LEFT:
                izquierda = false;
                break;
            case KeyEvent.VK_RIGHT:
                derecha = false;
                break;
        }
    }
 

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                arriba = true;
                break;
            case KeyEvent.VK_LEFT:
                izquierda = true;
                break;
            case KeyEvent.VK_RIGHT:
                derecha = true;
                break;
            case KeyEvent.VK_DOWN:
                abajo = true;
                break;
        }
    }
 
    public void keyTyped(KeyEvent e) {

    }
}