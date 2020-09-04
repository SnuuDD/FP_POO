import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        MiVentana mw= new MiVentana();
        mw.setResizable(false);
        mw.setSize(680,680);
        mw.setVisible(true);
        mw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}