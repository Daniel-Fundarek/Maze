package sk.stuba.fei.uim.oop;

import java.awt.*;

public class MyCanvas extends Canvas {
    private Manager manager;
    private int[][] maze;
    public MyCanvas(Manager manager) {
        this.manager = manager;

    }



    @Override
    public void paint(Graphics g) {
        changeColorAndDrawBoard(g);
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
    private void changeColorAndDrawBoard(Graphics g){
        maze = manager.getMaze();
        for (int row =0;row< maze.length-1; row++){
            for (int column =0;column< maze[0].length-1; column++) {
                changeColor(row,column,g);
                drawBoard(row,column,g);


            }

        }
        g.setColor(Color.BLACK);
        Graphics2D g2 = (Graphics2D)g;
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(2));
        g2.drawRect(10,10,11* (maze[0].length-2),11* (maze.length-2));
        g2.setStroke(oldStroke);



    }
    private void changeColor(int row,int column,Graphics g){
        if (maze[row][column] ==1 ){ // stena
            g.setColor(Color.BLACK);
        }

        else if (row == manager.getEndY() && column == manager.getEndX()){ // ciel
            g.setColor(Color.GRAY);
        }
        else if(maze[row][column] == 2){ // kam sa mozem pohnut
            g.setColor(Color.CYAN);
        }
        else if (maze[row][column] == 8){ // hrac
            g.setColor(Color.YELLOW);
        }
        else if(maze[row][column] == 7) { // hrac
            g.setColor(Color.GREEN);
        }
        else{
            g.setColor(Color.WHITE);
        }
    }
    private void drawBoard(int row, int column  ,Graphics g){
        if(row%2 == 0 && column%2 ==0){
            // nakresli male bodky iba
            drawDots(row,column,g);
            //System.out.println("BODDKY:row: "+ row + "column: " +column);

        }
        else if(row%2 == 1 && column%2 ==1){
            // nakresli stvorce
            drawRectangles(row,column,g);
            //System.out.println("Stvreoce:row: "+ row + "column: " +column);
        }
        else if(row%2 == 0 && column%2 ==1){
            // nakresli horizontalne ciary
            drawHorizontalLines(row,column,g);
           // System.out.println("Hozrizontalne:row: "+ row + "column: " +column);
        }
        else if(row%2 == 1 && column%2 ==0){
            // nakresli vertikalne  ciary

            drawVerticalLines(row,column,g);
           // System.out.println("Vertikalne:row: "+ row + "column: " +column);
        }
    }




}
