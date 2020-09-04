import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;

public class Bloque{
        Random e=new Random();
       private  Color col=new Color(e.nextInt(255),e.nextInt(255),e.nextInt(255));
        private int x;
        private int y ;
        private int r;
        
        public Bloque() {
            this.x=300;
            this.y=20;
            this.r=50;
           this.col=col;
        }
        public Bloque(int x,int y) {
            this.x=x;
            this.y=y;
            this.r=50;
            this.col=col;
        }
    
        public int getX() {
            return x;
        }
    
        public void setX(int x) {
            this.x = x;
        }
    
        public int getY() {
            return y;
        }
    
        public void setY(int y) {
            this.y = y;
        }
    
        public int getR() {
            return r;
        }
    
        public void setR(int r) {
            this.r = r;
        }
    
        public Color getCol() {
            return col;
        }
    
        public void setCol(Color col) {
            this.col = col;
        }
        public void paint (Graphics g) 
        {
            g.setColor(col);
            g.fillRect(x,y,r,r);
            //g.drawOval(this.x, this.y, this.size, this.size);
        }
    

}