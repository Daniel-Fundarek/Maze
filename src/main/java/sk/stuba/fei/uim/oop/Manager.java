package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class Manager {
    Player player;
    MazeCreator mazeCreator;
    int[][] maze;
    MyCanvas canvas;
    JLabel label;



    public Manager() {
        this.player = new Player();
        this.mazeCreator = new MazeCreator();
        this.maze = mazeCreator.cloneTwoDimArray();
        maze[player.getPositionY()][player.getPositionX()] = 3; // kde je hrac
        markAllViableTiles(player.getPositionY(), player.getPositionX());
        // paint

    }

    public void keyResponse(int moveY, int moveX){
        if (moveY + player.getPositionY() >= 1 && moveX + player.getPositionX() >= 1) {
            if (maze[player.getPositionY() + moveY][player.getPositionX() + moveX] == 2 || maze[player.getPositionY() + moveY][player.getPositionX() + moveX] == 9) {
                player.setPositionY(player.getPositionY() + moveY);
                player.setPositionX(player.getPositionX() + moveX);
                maze = mazeCreator.cloneTwoDimArray();
                markAllViableTiles(player.getPositionY(), player.getPositionX());
                //repaint

                // skontroluj ci niesom v cieli //
                if (maze[player.getPositionY() ][player.getPositionX() ] == 9) {

                    player.setPositionY(1);
                    player.setPositionX(1);
                    player.setCounter(player.getCounter() + 1);
                    label.setText("Counter: "+ player.getCounter());
                    System.out.println("Presiel si bludisko"+ player.getCounter());
                    mazeCreator.createNewMaze();
                    maze = mazeCreator.cloneTwoDimArray();
                    markAllViableTiles(player.getPositionY(), player.getPositionX());

                }
                canvas.repaint();


            }
        }
    }

    private void markAllViableTiles(int row, int column){
        markViableTile(row,column,1,0);
        markViableTile(row,column,-1,0);
        markViableTile(row,column,0,1);
        markViableTile(row,column,0,-1);
    }


    private void markViableTile(int row, int column, int directionX ,int  directionY){
        if (maze[row + directionY][column+directionX] == 0){  // kde je cesta

            maze[row + directionY][column+directionX] = 2; // kam moze hrac ist
            markViableTile(row+directionY ,column+directionX, directionX, directionY);
        }
        else{

        }
    }

    public void setCanvas(MyCanvas canvas) {
        this.canvas = canvas;
    }

    public int[][] getMaze() {
        return maze;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }
}
