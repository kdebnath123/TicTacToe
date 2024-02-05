import javax.swing.*;
import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;

    private Image Ximage, Oimage;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col) {

        this.row = row;
        this.col = col;

        Ximage = new ImageIcon("Resources/X.png").getImage();
        Oimage = new ImageIcon("Resources/O.png").getImage();

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }


    public void draw(Graphics g, TicTacToeViewer t){

        int x_corner = TicTacToeViewer.X_OFFSET + (TicTacToeViewer.BOX_SIZE* col);
        int y_corner = TicTacToeViewer.Y_OFFSET + (TicTacToeViewer.BOX_SIZE*row);
        int size = TicTacToeViewer.BOX_SIZE;

        g.drawRect(x_corner, y_corner, size, size);

        if(isWinningSquare){
            g.setColor(Color.green);
            g.fillRect(x_corner,y_corner,size,size);
        }

        switch (marker){
            case "-":
                break;

            case "X":
                g.drawImage(Ximage, x_corner, y_corner, size, size, t);
                break;
            case "O":
                g.drawImage(Oimage,x_corner, y_corner, size, size, t);
                break;
        }
    }

}
