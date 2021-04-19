package sk.stuba.fei.uim.oop;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
    private Manager manager;
    private int moveX;
    private int moveY;



    public MyActionListener(Manager manager, int moveX, int moveY) {
        this.manager = manager;
        this.moveX = moveX;
        this.moveY = moveY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            manager.keyResponse(moveY,moveX);
    }
}
