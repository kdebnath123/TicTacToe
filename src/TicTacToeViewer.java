import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {

    public static final int HEIGHT = 600, WIDTH = 600,
                            BOX_SIZE = 150,
                            X_OFFSET = (WIDTH - BOX_SIZE*3) / 2,
                            Y_OFFSET = (HEIGHT - BOX_SIZE*3) / 2;

    public Image Ximage;
    public Image Oimage;

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
        g.drawRect(X_OFFSET, Y_OFFSET, BOX_SIZE*3, BOX_SIZE*3);




        //Draw axes
        drawAxes(g);


        //Draw Sqaures
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                //Gives information for each loction to draw square
                // TODO: move equations into sqaure b/c pbulic
                // TODO: pass int window with this so sqaure knows where to draw itslef
                board[i][j].draw(X_OFFSET + (BOX_SIZE* j), Y_OFFSET + (BOX_SIZE*i), BOX_SIZE, g, this);
            }
        }


    }
    public void drawAxes(Graphics g){
        // Draw horizontal axis
        for (int i = 0; i < 3; i++){
            g.drawString(String.valueOf(i), X_OFFSET + (BOX_SIZE* i) + BOX_SIZE / 2, Y_OFFSET - 10);
        }

        // Draw verticle axis
        for (int i = 0; i < 3; i++){
            g.drawString(String.valueOf(i), X_OFFSET - 20, Y_OFFSET + (BOX_SIZE* i) + BOX_SIZE / 2);
        }
    }
}
