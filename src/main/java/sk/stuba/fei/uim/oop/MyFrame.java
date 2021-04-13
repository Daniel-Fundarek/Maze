package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    private Manager manager;
    private MyCanvas canvas;
    public MyFrame()  {
        this.manager = new Manager();
        this.canvas = new MyCanvas(manager);
        manager.setCanvas(this.canvas);
        createFrame();



    }

    private void createFrame() {
        JFrame frame = new JFrame("Maze");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Counter: 0"  );
        JPanel buttonPanel  = new JPanel();
        frame.setLayout(new BorderLayout());
        buttonPanel.setLayout(new GridLayout(6,3));

        createButtons(buttonPanel);

        frame.add(buttonPanel, BorderLayout.EAST);
        panel.add(label);
        manager.setLabel(label);
        frame.add("West",panel);

        frame.add("Center",canvas);

        frame.setVisible(true);
        canvas.addKeyListener(new MyKeyListener(manager) );
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
        buttonPanel.add(new JLabel(""));
        buttonPanel.add(buttonLeft);
        buttonPanel.add(buttonReset);
        buttonPanel.add(buttonRight);
        buttonPanel.add(new JLabel(""));
        buttonPanel.add(buttonDown);
        buttonPanel.add(new JLabel(""));
        buttonPanel.add(new JLabel(""));
        buttonPanel.add(new JLabel(""));
        buttonPanel.add(new JLabel(""));
        buttonPanel.add(new JLabel(""));





    }
}
