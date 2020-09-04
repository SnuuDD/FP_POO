
import java.awt.*;
import javax.swing.ImageIcon;

public class Sprite{
    private int x,y; 
    private boolean visible;
    private String sprite;
 
    public Sprite() 
    {
       visible=true;
       x=y=0;
    }
 
    public boolean isVisble(){
        return visible;
    }
 
    public void setVisible(boolean v){
        visible=v;
    }
 
    public int getX(){
        return x;
    }
 
    public void setX(int i){
        x=i;
    }
 
    public int getY(){
        return y;
    }
 
    public void setY(int i){
        y=i;
    }
 
    public int getWidth(){
        return new ImageIcon(getClass().getResource(sprite)).getImage().getWidth(null);
    }
 
    public int getHeight(){
        return new ImageIcon(getClass().getResource(sprite)).getImage().getHeight(null);
    }
 
    public void setSprite(String n){
        sprite=n;
    }
 
    public String getSprite(){
        return sprite;
    }
 
    public void pintar(Graphics g,int xi,int yi){
        x=xi;
        y=yi;
        if (visible) g.drawImage(new ImageIcon(getClass().getResource(sprite)).getImage(), x, y, null);
    }
 
}