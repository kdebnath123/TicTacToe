import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {

    public static final int HEIGHT = 600, WIDTH = 600,
                            TITLE_BAR_HEIGHT = 22,
                            X_OFFSET = 50, Y_OFFSET = 50,
                            BOX_SIZE = 50;

    public static final String TITLE  = "TIC-TAC-TOE";

    private Square[][] board;

    public TicTacToeViewer(Square[][] board){

        this.board = board;

        this.setSize(WIDTH, HEIGHT);
        this.setTitle(TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void paint(Graphics g){
        // Clear screen
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0, WIDTH, HEIGHT);

        // Draw grid
        g.setColor(Color.GREEN);
        g.drawRect(X_OFFSET, Y_OFFSET, 500, 500);


    }


}
