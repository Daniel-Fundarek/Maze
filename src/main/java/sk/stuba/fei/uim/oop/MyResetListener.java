package sk.stuba.fei.uim.oop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyResetListener implements ActionListener {
        private Manager manager;


        public MyResetListener(Manager manager) {
            this.manager = manager;
        }



        @Override
        public void actionPerformed(ActionEvent e) {
                manager.reset();
        }

    }
