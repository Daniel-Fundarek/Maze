package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;


public class MyFrame extends JFrame {
    private Manager manager;
    private MyCanvas canvas;
    JLabel label;


    public MyFrame(Manager manager, MyCanvas canvas, JLabel label)  {
        this.manager = manager;
        this.canvas = canvas;
        this.label = label;
        createFrame();
    }

    private void createFrame() {
        JFrame frame = new JFrame("Maze");
        JPanel panel = new JPanel();
        // = new JLabel("Counter: 0"  );
        JPanel buttonPanel  = new JPanel();
        frame.setLayout(new BorderLayout());
        buttonPanel.setLayout(new GridLayout(6,3));
        canvas.setFocusable(true);
        createButtons(buttonPanel);

        frame.add(buttonPanel, BorderLayout.EAST);
        panel.add(label);
        //manager.setLabel(label);
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

    private void createButtons(JPanel buttonPanel){
        JButton buttonUp = new JButton(" Up");
        JButton buttonDown = new JButton("Down");
        JButton buttonLeft = new JButton("Left");
        JButton buttonRight = new JButton("Right");
        JButton buttonReset = new JButton("Reset");

        buttonUp.addActionListener(new MyActionListener(manager,0,-2));
        buttonDown.addActionListener(new MyActionListener(manager,0,2));
        buttonLeft.addActionListener(new MyActionListener(manager,-2,0));
        buttonRight.addActionListener(new MyActionListener(manager,2,0));
        buttonReset.addActionListener(new MyActionListener(manager));


        buttonUp.setFocusable(false);
        buttonDown.setFocusable(false);
        buttonLeft.setFocusable(false);
        buttonRight.setFocusable(false);
        buttonReset.setFocusable(false);


        buttonPanel.add(new JLabel(""));
        buttonPanel.add(buttonUp);
        buttonPanel.add(buttonReset);

        buttonPanel.add(buttonLeft);
        buttonPanel.add(buttonDown);

        buttonPanel.add(buttonRight);
        buttonPanel.add(new JLabel(""));
        buttonPanel.add(new JLabel(""));
        buttonPanel.add(new JLabel(""));
        buttonPanel.add(new JLabel(""));
        buttonPanel.add(new JLabel(""));
        buttonPanel.add(new JLabel(""));
        buttonPanel.add(new JLabel(""));





    }
}
