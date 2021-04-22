package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;


public class MyFrame extends JFrame {
    private Manager manager;
    private MyCanvas canvas;
    private JLabel label;


    public MyFrame(Manager manager, MyCanvas canvas, JLabel label)  {
        this.manager = manager;
        this.canvas = canvas;
        this.label = label;
        createFrame();
    }

    private void createFrame() {
        JFrame frame = new JFrame("Maze");
        JPanel panel = new JPanel();
        MyButtonPanel buttonPanel = new MyButtonPanel(manager);
        frame.setLayout(new BorderLayout());
        canvas.setFocusable(true);
        frame.add(buttonPanel, BorderLayout.EAST);
        panel.add(label);
        frame.add("West",panel);

        frame.add("Center",canvas);

        frame.setVisible(true);
        canvas.addKeyListener(new MyKeyListener(manager) );
        canvas.addMouseListener(new MyMouseAdapter(manager));
        canvas.addMouseMotionListener(new MyMouseAdapter(manager));
        frame.pack();
        frame.setSize(610,400);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }
}
