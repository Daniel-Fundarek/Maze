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
        JFrame frame = new JFrame("Maze");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Counter: 0"  );

        frame.setLayout(new BorderLayout());
        panel.add(label);
        manager.setLabel(label);
        frame.add("West",panel);

        frame.add("Center",canvas);

        frame.setVisible(true);
        frame.addKeyListener(new MyKeyListener(manager) );
        frame.setSize(700,700);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }
}
