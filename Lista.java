import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class Lista {
	private LinkedList<Bloque> enemigos;

	public Lista() {
		enemigos = new LinkedList<Bloque>();
	}

	public void bloqueAbajo() {
        Random ran1=new Random();
        Bloque tempBloque=new Bloque(ran1.nextInt(2700)+100,522);
        Random e = new Random();        
		Color col = new Color(e.nextInt(255), e.nextInt(255), e.nextInt(255));
		tempBloque.setCol(col);
		enemigos.add(tempBloque);
		
			//System.out.println("Enemigo creadP");

    }
    public void bloqueArriba() {
        Random ran1=new Random();
        Bloque tempBloque=new Bloque(ran1.nextInt(2700)+100,472);
        Random e = new Random();        
		Color col = new Color(e.nextInt(255), e.nextInt(255), e.nextInt(255));
		tempBloque.setCol(col);
		enemigos.add(tempBloque);
		
			//System.out.println("Enemigo creado");

	}

	public int tolalPelo() {
		int i=0;
		ListIterator<Bloque> iter = enemigos.listIterator();
		while (iter.hasNext()) {
			i++;
			}
		return i;

	}
	public void recorrer() {
		ListIterator<Bloque> iter = enemigos.listIterator();
		while (iter.hasNext()) {
			Bloque a = iter.next();
			if (a instanceof Bloque) {
				Bloque temp = (Bloque) a;
                temp.setX(temp.getX()-5);
				}
			}
	}

	
	public boolean delFigure(){
		enemigos.removeLast();
			return true;
	}

	public void paint(Graphics g) {
		ListIterator<Bloque> iter = enemigos.listIterator();
		while (iter.hasNext()) {
			Bloque a = iter.next();
			if (a instanceof Bloque) {
				Bloque temp = (Bloque) a;
				temp.paint(g);
			}
		}
    }
    public int checaChoque(int xinfd, int yinfd){
		//System.out.println(xinfd+" "+yinfd);
		ListIterator<Bloque> iter = enemigos.listIterator();
		while (iter.hasNext()) {
			Bloque a = iter.next();
			if (a instanceof Bloque) {
				Bloque temp = (Bloque) a;
                if( (xinfd>temp.getX() && xinfd<temp.getX()+temp.getR())){
					//System.out.println("Entro");
					if(yinfd>temp.getY() && yinfd<temp.getY()+temp.getR()) {return 1;}
				}
			}
		}return 0;
    }

}