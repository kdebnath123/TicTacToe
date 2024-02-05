import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {

    public static final int HEIGHT = 600, WIDTH = 600,
                            BOX_SIZE = 150,
                            X_OFFSET = (WIDTH - BOX_SIZE*3) / 2,
                            Y_OFFSET = (HEIGHT - BOX_SIZE*3) / 2;

    public static final String TITLE  = "TIC-TAC-TOE";

    private TicTacToe t;
    private Square[][] board;

    public TicTacToeViewer(TicTacToe t){

        this.t = t;
        this.board = t.getBoard();

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
        g.setColor(Color.white);
        g.drawRect(X_OFFSET, Y_OFFSET, BOX_SIZE*3, BOX_SIZE*3);


        //Draw axes
        drawAxes(g);


        //Draw Squares
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                //Draw each square
                board[i][j].draw(g, this);
            }
        }


        if (t.getGameOver() ){
            drawWinner(g, t.getWinner());

        }



    }
    public void drawAxes(Graphics g){
        // Draw horizontal axis
        g.setColor(Color.white);

        for (int i = 0; i < 3; i++){
            g.drawString(String.valueOf(i), X_OFFSET + (BOX_SIZE* i) + BOX_SIZE / 2, Y_OFFSET - 10);
        }

        // Draw vert axis
        for (int i = 0; i < 3; i++){
            g.drawString(String.valueOf(i), X_OFFSET - 20, Y_OFFSET + (BOX_SIZE* i) + BOX_SIZE / 2);
        }
    }

    public void drawWinner(Graphics g, String winner){

        g.setColor(Color.white);
        if(winner.equals(TicTacToe.BLANK)) {
            g.drawString("TIE GAME", X_OFFSET, 550);
        }
        else{
            g.drawString(winner + " WINS", X_OFFSET, 550);
        }
    }

}
