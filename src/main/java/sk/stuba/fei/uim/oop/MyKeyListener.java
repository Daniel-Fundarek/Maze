package sk.stuba.fei.uim.oop;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    Player player;

    public MyKeyListener(Player player) {
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            player.setPositionY(player.getPositionY() - 2);
        }

        if (key == KeyEvent.VK_RIGHT) {
            player.setPositionY(player.getPositionY() + 2);
        }

        if (key == KeyEvent.VK_UP) {
            player.setPositionX(player.getPositionX() - 2);
        }

        if (key == KeyEvent.VK_DOWN) {
            player.setPositionX(player.getPositionX() + 2);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
