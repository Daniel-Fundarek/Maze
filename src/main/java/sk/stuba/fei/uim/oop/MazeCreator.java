package sk.stuba.fei.uim.oop;

import java.util.Random;
import java.util.ArrayList;
public class MazeCreator {
    Random random = new Random();
    private int[][] maze = new int[11][11];

    public MazeCreator() {
        createBorder();

        createMaze(1,1);

    }

    private void createBorder(){
        for (int row =0;row< maze.length; row++){
            for (int column =0;column< maze[0].length; column++){
                if (row == 0 || row ==  maze.length-1 || column == 0 || column ==  maze[0].length-1){
                    maze[row][column]= 1; // okraj
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
    private void createMaze(int row, int column){

        clearWall(row,column);

    }
    private boolean checkWall(int row, int column){
        boolean wall = false;
        if(maze[row][column] == 2){
            wall = true;
        }
        return wall;

    }
    private void clearWall(int row, int column){
        System.out.println();
        if (row<= maze.length && column <= maze[0].length && maze[row][column] == 0) {
            maze[row][column] = 9;
            printMaze();

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

            for (int rowOfArray = 0; rowOfArray < positionOfWall.size(); rowOfArray++) {
                if (!checkWall(row + positionOfWall.get(rowOfArray).get(0), column + positionOfWall.get(rowOfArray).get(1))) {
                    positionOfWall.remove(rowOfArray);
                    rowOfArray--;
                }
            }
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
        }

    }
}