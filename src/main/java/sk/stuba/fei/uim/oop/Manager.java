package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Manager {
    private Player player;
    private MazeCreator mazeCreator;
    private int[][] maze;
    private MyCanvas canvas;
    private JLabel label;
    private int previousMousePositionX =1;
    private int previousMousePositionY =1;
    private  int endX;
    private  int endY;




    public Manager() {
        this.player = new Player();
        this.mazeCreator = new MazeCreator();
        this.maze = mazeCreator.cloneTwoDimArray();
        endX = mazeCreator.getEndX();
        endY = mazeCreator.getEndY();
        markAllViableTiles(player.getPositionY(), player.getPositionX());
        placePlayerOnBoard();

        this.canvas = new MyCanvas(this);
        new MyFrame(this,this.canvas);


        //paint

    }
    public void mouseResponse(int y,int x){
        int moveY = 0;
        int moveX = 0;
        if (player.getMoveWithMouse() == true) {
            moveY = y - player.getPositionY();
            moveX = x - player.getPositionX();
            player.setMoveWithMouse(false);
            response(moveY, moveX);
            canvas.repaint();

        }
        else if (player.getPositionY() == y && player.getPositionX() == x){
            player.setMoveWithMouse(true);
        }
    }
    public void keyResponse(int moveY, int moveX){
        response(moveY, moveX);
        canvas.repaint();
    }
    public void response(int moveY, int moveX){
        if (moveY + player.getPositionY() >= 1 && moveX + player.getPositionX() >= 1) {
            eraseHighlight();
            if (maze[player.getPositionY() + moveY][player.getPositionX() + moveX] == 2 ){
                // upravit pre mys na end sa da kliknut hned
                player.setPositionY(player.getPositionY() + moveY);
                player.setPositionX(player.getPositionX() + moveX);
                maze = mazeCreator.cloneTwoDimArray();
                markAllViableTiles(player.getPositionY(), player.getPositionX());
                checkForEnd();
                placePlayerOnBoard();

            }
        }
    }
    private void checkForEnd(){
        if (player.getPositionY() == endY && player.getPositionX() == endX) {


            player.setCounter(player.getCounter() + 1);
            restart();

        }
    }
    private void eraseHighlight(){
        if(maze[previousMousePositionY][previousMousePositionX] == 7){
            maze[previousMousePositionY][previousMousePositionX] = 2;
        }
    }
    public void motionResponse(int mousePositionX, int mousePositionY){
        if (player.getMoveWithMouse() == true){
            if ( previousMousePositionX!= mousePositionX || previousMousePositionY != mousePositionY) {
                System.out.println(player.getMoveWithMouse());
                highlightTile(mousePositionX, mousePositionY);
            }
        }
    }
    private void highlightTile(int mousePositionX, int mousePositionY){
        if (maze[mousePositionY][mousePositionX] == 2) {
            eraseHighlight();
            maze[mousePositionY][mousePositionX] = 7; // highlighted
            placePlayerOnBoard();
            previousMousePositionY = mousePositionY;
            previousMousePositionX = mousePositionX;
            canvas.repaint();

        }

    }

    private void placePlayerOnBoard(){
        maze[player.getPositionY()][player.getPositionX()]=8;
    }


    private void markAllViableTiles(int row, int column){
        markViableTile(row,column,1,0);
        markViableTile(row,column,-1,0);
        markViableTile(row,column,0,1);
        markViableTile(row,column,0,-1);
    }


    private void markViableTile(int row, int column, int directionX ,int  directionY){
        if (maze[row + directionY][column+directionX] == 0){  // kde je cesta
            // upravit pre mys tak aby bolo oznacene aj policko end
            maze[row + directionY][column+directionX] = 2; // kam moze hrac ist
            markViableTile(row+directionY ,column+directionX, directionX, directionY);
        }
        else{

        }
    }

    private void restart(){
        player.setPositionY(1);
        player.setPositionX(1);
        label.setText("Counter: "+ player.getCounter());
       // System.out.println("Presiel si bludisko"+ player.getCounter());
        mazeCreator.createNewMaze();
        maze = mazeCreator.cloneTwoDimArray();
        markAllViableTiles(player.getPositionY(), player.getPositionX());
        placePlayerOnBoard();
    }

    public void reset(){
        player.setCounter(0);
        restart();
        canvas.repaint();
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
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
