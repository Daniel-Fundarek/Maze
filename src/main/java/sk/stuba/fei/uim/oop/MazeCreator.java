package sk.stuba.fei.uim.oop;

import java.util.Random;
import java.util.ArrayList;
public class MazeCreator {
    private Random random = new Random();
    private int[][] maze = new int[60][60];

    public MazeCreator() {
        createBorder();

        createMaze();

    }

    private void createBorder(){
        for (int row =0;row< maze.length; row++){
            for (int column =0;column< maze[0].length; column++){
                if (row == 0 || row ==  maze.length-1 || column == 0 || column ==  maze[0].length-1){
                    maze[row][column]= 3; // okraj
                }
                else if(row%2 ==0 || column%2 == 0){
                    maze[row][column]= 2;   // policko steny ale nerozhodnute ci to stena bude
                }
                else{
                    maze[row][column]= 0;
                }
            }
        }
    }
    private void printMaze(){
        for (int row =0;row< maze.length; row++){
            for (int column =0;column< maze[0].length; column++) {
                System.out.print(" " + maze[row][column]);
            }
            System.out.println();
        }

    }
    private void createMaze(){


        for (int row = 1; row < maze.length;row++){
            for(int column = 1;column < maze[0].length;column++){
                if(row == 1 && column ==1)
                    clearWall(row,column);
                else
                    breakWall(row,column);
            }
            printMaze();
        }


    }

    private boolean checkWall(int row, int column,int mode){
        boolean wall = false;
        if(mode == 1) {
            if (maze[row][column] == 2) {
                wall = true;
            }
        }
        else{
            if (maze[row][column] == 1) {
                wall = true;
            }
        }
        return wall;

    }
    private ArrayList<ArrayList<Integer>> evaluateTile(int row, int column,int mode){
        ArrayList<ArrayList<Integer>> positionOfWall = create2dArraylist();
        for (int rowOfArray = 0; rowOfArray < positionOfWall.size(); rowOfArray++) {
            if (!checkWall(row + positionOfWall.get(rowOfArray).get(0), column + positionOfWall.get(rowOfArray).get(1),mode)) {
                positionOfWall.remove(rowOfArray);
                rowOfArray--;
            }
        }
        return positionOfWall;
    }
    public int[][] getMaze() {
        return maze;
    }

    private void clearWall(int row, int column){
        System.out.println();
        int mode = 1; //hladaj este npouzite steny , ine cislo by boli steny ktore su uz ulozene
        if (row<= maze.length && column <= maze[0].length && maze[row][column] == 0) {
            maze[row][column] = 9; // visited
            ArrayList<ArrayList<Integer>> positionOfWall;

            positionOfWall= evaluateTile(row,column,mode);

            if (positionOfWall.size()>0) {
                int randomWall = random.nextInt(positionOfWall.size());
                for (int i = 0; i < positionOfWall.size(); i++) {
                    if (randomWall == i) {
                        maze[row + positionOfWall.get(i).get(0)][column + positionOfWall.get(i).get(1)] = 5;
                    } else {
                        maze[row + positionOfWall.get(i).get(0)][column + positionOfWall.get(i).get(1)] = 1;
                    }
                }
                System.out.println(positionOfWall.get(randomWall).get(0)+ "  " + positionOfWall.get(randomWall).get(1));
                System.out.println(positionOfWall);
                clearWall(row + 2*positionOfWall.get(randomWall).get(0),column + 2*positionOfWall.get(randomWall).get(1));
            }
            else{

            }
        }

    }
    private void breakWall(int row,int column){
        if (row<= maze.length && column <= maze[0].length && maze[row][column] == 0) {
            int mode = 0; // searching for walls that were already created
            ArrayList<ArrayList<Integer>> positionOfWall;

            positionOfWall= evaluateTile(row,column,mode);
            int randomWall = random.nextInt(positionOfWall.size());
            maze[row + positionOfWall.get(randomWall).get(0)][column + positionOfWall.get(randomWall).get(1)] = 5;
            clearWall(row,column);
        }
    }
    private ArrayList<ArrayList<Integer>> create2dArraylist(){

        ArrayList<ArrayList<Integer>> positionOfWall = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 4; i++) {
            positionOfWall.add(new ArrayList<Integer>());
        }
        positionOfWall.get(0).add(0, -1);
        positionOfWall.get(0).add(1, 0);

        positionOfWall.get(1).add(0, 1);
        positionOfWall.get(1).add(1, 0);

        positionOfWall.get(2).add(0, 0);
        positionOfWall.get(2).add(1, -1);

        positionOfWall.get(3).add(0, 0);
        positionOfWall.get(3).add(1, 1);
        return positionOfWall;
    }

}