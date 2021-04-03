package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() throws HeadlessException {
    createCanvas();
    }

    private void createCanvas() {
        JFrame frame = new JFrame("Frame");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Maze");

        panel.add(label);
        frame.add(panel);
        frame.add(new MyCanvas());
        frame.setVisible(true);
        frame.setSize(600,600);
    }
}
