package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    Manager manager;
    MyCanvas canvas;
    public MyFrame() throws HeadlessException {
        this.manager = new Manager();
        this.canvas = new MyCanvas(manager);
        manager.setCanvas(this.canvas);

    createFrame();



    }

    private void createFrame() {
        JFrame frame = new JFrame("Frame");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Maze");

        panel.add(label);
        frame.add(panel);
        frame.add(canvas);
        frame.setVisible(true);
        frame.addKeyListener(new MyKeyListener(manager) );
        frame.setSize(700,700);
    }
}
