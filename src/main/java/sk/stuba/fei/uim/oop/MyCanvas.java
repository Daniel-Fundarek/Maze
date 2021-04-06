package sk.stuba.fei.uim.oop;

import java.awt.*;

public class MyCanvas extends Canvas {
    MazeCreator creator = new MazeCreator();
    private int[][] maze;
    public MyCanvas() {

        maze =  creator.getMaze();
    }

    @Override
    public void paint(Graphics g) {
        idk(g);
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
    private void idk(Graphics g){

        for (int row =0;row< maze.length-1; row++){
            for (int column =0;column< maze[0].length-1; column++) {
                if (maze[row][column] ==1 || maze[row][column] == 2){
                    g.setColor(Color.BLACK);
                }

                else{
                    g.setColor(Color.WHITE);
                }
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

        }
        g.setColor(Color.BLACK);
        Graphics2D g2 = (Graphics2D)g;
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(2));
        g2.drawRect(10,10,11* (maze[0].length-2),11* (maze.length-2));
        g2.setStroke(oldStroke);

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

    private void markViableTiles(int row, int column, int directionX ,int  directionY){
        if (maze[row + directionY][column+directionX] == 0){

            markViableTiles(column+directionX,row+directionY, directionX, directionY);
        }
        else{

        }
    }


}
