import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;

public class CanvasPrueba extends Canvas implements KeyListener, ActionListener{
	private BufferedImage im; 
	private Lista listEnemigos;
	private Timer timer;
	private Jugable pelota;
	private int direction,bandera=-1;
	private int yimg=0;
	private boolean xd=true;

    CanvasPrueba(){
		super();
		im=new BufferedImage(1600,680,BufferedImage.TYPE_INT_RGB);
		listEnemigos = new Lista();
		listEnemigos.bloqueAbajo();listEnemigos.bloqueArriba();
		listEnemigos.bloqueAbajo();listEnemigos.bloqueArriba();	
		listEnemigos.bloqueAbajo();listEnemigos.bloqueArriba();
		listEnemigos.bloqueAbajo();listEnemigos.bloqueArriba();
		listEnemigos.bloqueAbajo();listEnemigos.bloqueArriba();
		listEnemigos.bloqueAbajo();listEnemigos.bloqueArriba();
		listEnemigos.bloqueAbajo();listEnemigos.bloqueArriba();
		listEnemigos.bloqueAbajo();listEnemigos.bloqueArriba();
		listEnemigos.bloqueAbajo();listEnemigos.bloqueArriba();
		listEnemigos.bloqueAbajo();listEnemigos.bloqueArriba();
		listEnemigos.bloqueAbajo();listEnemigos.bloqueArriba();
		pelota = new Jugable();
		pelota.setSprite("poke.gif");
		pelota.setX(0);
		pelota.setY(500 - pelota.getHeight());
		repaint();
		pelota.actualiza();
		timer = new Timer(70, this);
		timer.start();
		addKeyListener(this);
		this.addKeyListener(pelota);
    }

	public void paint(Graphics g){
		if(bandera==-1) {
			Graphics graph=im.createGraphics();   
			graph.setColor(Color.WHITE);
			graph.fillRect(0,0,2000,2000);
			graph.drawImage(new ImageIcon(getClass().getResource("titl.png")).getImage(), 0, 0, null);		 
			g.drawImage(im, 0, 0, null);			                          
		}  
		if(bandera==0)
		{Graphics graph=im.createGraphics();   
		graph.drawImage(new ImageIcon(getClass().getResource("fondo.jpg")).getImage(), yimg, 0, null);
		pelota.pintar(graph, pelota.getX(), pelota.getY());
		listEnemigos.paint(graph);
		//graph.fillOval(pelota.getX()+50, pelota.getY()+50,5,5 );
		g.drawImage(im, 0, 0, null); } 
		if(bandera==1) {
			Graphics graph=im.createGraphics();   
			graph.setColor(Color.RED);
			graph.fillRect(0,0,2000,2000);
			graph.drawImage(new ImageIcon(getClass().getResource("UnU.gif")).getImage(), 150, 150, null);		 
			graph.setFont(new Font("BahnschriftCondensed", Font.PLAIN, 72));
			graph.setColor(Color.white);
			graph.drawString("Game Over", 680/2-193,520);
			g.drawImage(im, 0, 0, null);			                          
		}  
		if(bandera==2) {
			Graphics graph=im.createGraphics();   
			graph.setColor(Color.WHITE);
			graph.fillRect(0,0,2000,2000);
			graph.drawImage(new ImageIcon(getClass().getResource("tenor.gif")).getImage(), 100, 100, null);		 
			graph.setFont(new Font("BahnschriftCondensed", Font.PLAIN, 72));
			graph.setColor(Color.BLACK);
			graph.drawString("You Win!", 680/2-150,520);
			g.drawImage(im, 0, 0, null);			                          
		}                        
	}
	public void update(Graphics g)
	{
		Graphics offScreenGraphics;
		BufferedImage offscreen = null;
		Dimension d = this.getSize();
		
		offscreen = new BufferedImage(d.width,d.height,BufferedImage.TYPE_INT_ARGB);
		offScreenGraphics = offscreen.getGraphics();
		offScreenGraphics.setColor(this.getBackground());
		offScreenGraphics.fillRect(0,0,d.width,d.height);
		offScreenGraphics.setColor(this.getForeground());
		paint(offScreenGraphics);
		
		g.drawImage(offscreen,0,0,this);
	}	
	public void keyTyped(KeyEvent e) {}
	@Override
    public void keyPressed(KeyEvent e) {
		
		//System.out.println("Key Pressed");
		if(e.getKeyCode()==37){
			if(pelota.getX()>=0){
				pelota.setX(pelota.getX()-10);
				repaint();
			} 
		}
		if(e.getKeyCode()==10 && bandera==-1){
			bandera=0; 
		}
        else if(e.getKeyCode()==39){
				if(pelota.getX()>=0 && pelota.getX()<=301){
					pelota.setX(pelota.getX()+10);
					repaint(); 
				}
				if(pelota.getX()>=300){
					yimg=yimg-5;
					listEnemigos.recorrer();
					repaint();
				}
				if(yimg<=-2300){
					pelota.setX(pelota.getX()+7);
					if(yimg<=-2600){
					bandera=2;}
				}
			}
		else{ pelota.setX(pelota.getX()-10); }
		} 
		public void keyReleased(KeyEvent e) {}
		public void actionPerformed(ActionEvent d) {
			int y,size, banderatemp;

			banderatemp=listEnemigos.checaChoque(pelota.getX()+50,pelota.getY()+50);
			if (banderatemp==1){
				bandera =1;
			}
			if(this.getWidth()-pelota.getX()<=150){
				bandera=2;
			}
			y=pelota.getY();
			size=pelota.getHeight();
			if (direction==1) {
				pelota.setY(pelota.getY()+10);
					if (y>560-size) direction=-1;
					
			}
			else {
				pelota.setY(pelota.getY()-10);
					if (y<=this.getHeight()-this.getHeight()/2.5-size) direction=1;
			}

		
		repaint();

		}   
	

	
	
}
