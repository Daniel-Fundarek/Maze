package sk.stuba.fei.uim.oop;

import java.awt.*;

public class MyCanvas extends Canvas {
    MazeCreator creator = new MazeCreator();
    int playerPositionX = 5;
    int playerPositionY = 7;
    private int[][] maze;
    public MyCanvas() {

        maze =  creator.cloneTwoDimArray();
    }

    @Override
    public void paint(Graphics g) {
        drawBoard(g);
    }
    private void drawHorizontalLines(int row,int column, Graphics g){

        g.fillRect(11*column,11*row+9,20,2);

    }
    private void drawVerticalLines(int row,int column, Graphics g){
        g.fillRect(11*column+9,11*row,2,20);

    }
    private void drawDots(int row,int column, Graphics g){
        g.fillRect(11*column+9,11*row+9,2,2);

    }
    private void drawRectangles(int row, int column,Graphics g){

        g.fillRect(11*column,11*row,20,20);

    }
    private void drawBoard(Graphics g){

        for (int row =0;row< maze.length-1; row++){
            for (int column =0;column< maze[0].length-1; column++) {
                if (maze[row][column] ==1 || maze[row][column] == 2){
                    g.setColor(Color.BLACK);
                }
                else if (maze[row][column] == 9){
                    g.setColor(Color.BLUE);
                }
                else{
                    g.setColor(Color.WHITE);
                }

               drawBoard(row,column,g);


            }

        }
        g.setColor(Color.BLACK);
        Graphics2D g2 = (Graphics2D)g;
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(2));
        g2.drawRect(10,10,11* (maze[0].length-2),11* (maze.length-2));
        g2.setStroke(oldStroke);

        markViableTiles(playerPositionY,playerPositionX,1,0,g);
        markViableTiles(playerPositionY,playerPositionX,-1,0,g);
        markViableTiles(playerPositionY,playerPositionX,0,1,g);
        markViableTiles(playerPositionY,playerPositionX,0,-1,g);

    }
    private void drawBoard(int row, int column  ,Graphics g){
        if(row%2 == 0 && column%2 ==0){
            // nakresli male bodky iba
            drawDots(row,column,g);
            System.out.println("BODDKY:row: "+ row + "column: " +column);

        }
        else if(row%2 == 1 && column%2 ==1){
            // nakresli stvorce
            drawRectangles(row,column,g);
            System.out.println("Stvreoce:row: "+ row + "column: " +column);
        }
        else if(row%2 == 0 && column%2 ==1){
            // nakresli horizontalne ciary
            drawHorizontalLines(row,column,g);
            System.out.println("Hozrizontalne:row: "+ row + "column: " +column);
        }
        else if(row%2 == 1 && column%2 ==0){
            // nakresli vertikalne  ciary

            drawVerticalLines(row,column,g);
            System.out.println("Vertikalne:row: "+ row + "column: " +column);
        }
    }

    private void markViableTiles(int row, int column, int directionX ,int  directionY, Graphics g){
        if (maze[row + directionY][column+directionX] == 0){
            g.setColor(Color.CYAN);
            drawBoard(row + directionY,column+directionX, g);
            markViableTiles(row+directionY ,column+directionX, directionX, directionY,g);
        }
        else{

        }
    }


}
