package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MyButtonPanel extends JPanel {
    private Manager manager;

    public MyButtonPanel( Manager manager) {
        this.manager = manager;
        setLayout(new GridLayout(6,3));
        createButtons(this);
    }
    private void createButtons(JPanel buttonPanel){
        MyButton  buttonUp = new MyButton(" Up");
        MyButton buttonDown = new MyButton("Down");
        MyButton buttonLeft = new MyButton("Left");
        MyButton buttonRight = new MyButton("Right");
        MyButton buttonReset = new MyButton("Reset");

        buttonUp.addActionListener(new MyActionListener(manager,0,-2));
        buttonDown.addActionListener(new MyActionListener(manager,0,2));
        buttonLeft.addActionListener(new MyActionListener(manager,-2,0));
        buttonRight.addActionListener(new MyActionListener(manager,2,0));
        buttonReset.addActionListener(new MyResetListener(manager));

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
