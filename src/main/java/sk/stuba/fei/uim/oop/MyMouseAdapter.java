package sk.stuba.fei.uim.oop;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseAdapter extends MouseAdapter {
    private Manager manager;
    private int row = 0;
    private int column = 0;
    public MyMouseAdapter(Manager manager) {
        this.manager = manager;
    }

    private void whereAmI(int x, int y){
         row = 0;
         column = 0;
        if (x <9 || y <9 || y>317 || x > 317){
            row = 0;
            column = 0;
        }
        else {
            y = y - 9;
            x = x - 9;

            if (y % 22 != 0) {
                row += 1;
            }
            row = row + y / 22;
            if (x % 22 != 0) {
                column += 1;
            }
            column = column + x / 22;
            row = row * 2 - 1;
            column = column * 2 - 1;

        }
      //  System.out.println("riadok: " + row + " stlpec: " + column);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        whereAmI(e.getX(),e.getY());
        manager.mouseResponse(row, column);
    }


    @Override
    public void mouseMoved(MouseEvent e) {
        whereAmI(e.getX(),e.getY());
        manager.motionResponse(column,row);
    }
}
