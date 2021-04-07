package sk.stuba.fei.uim.oop;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    Manager manager;

    public MyKeyListener(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            System.out.println("Lave");
            manager.keyResponse(0 , -2);
        }

        if (key == KeyEvent.VK_RIGHT) {
            System.out.println("prave");
            manager.keyResponse(0 , 2);

        }

        if (key == KeyEvent.VK_UP) {
            System.out.println("horne");
            manager.keyResponse(-2 , 0);
        }

        if (key == KeyEvent.VK_DOWN) {
            System.out.println("dolne");
            manager.keyResponse(2 , 0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
