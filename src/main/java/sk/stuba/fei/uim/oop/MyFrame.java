package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    Player player;
    public MyFrame(Player player) throws HeadlessException {
    createCanvas();
    this.player = player;

    }

    private void createCanvas() {
        JFrame frame = new JFrame("Frame");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Maze");

        panel.add(label);
        frame.add(panel);
        frame.add(new MyCanvas());
        frame.setVisible(true);
        addKeyListener(new MyKeyListener(player) );
        frame.setSize(700,700);
    }
}
