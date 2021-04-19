package sk.stuba.fei.uim.oop;

import javax.swing.*;

public class MyButton extends JButton {
    public MyButton(String text) {
        super(text);
        setFocusable(false);
    }
}
