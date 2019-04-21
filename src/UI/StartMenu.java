package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu extends JFrame {
    public static void main(String[] args) {
        try {
            StartMenu frame = new StartMenu();
            frame.setVisible(true);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public StartMenu(){
        setTitle("Start Menu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JButton btn = new JButton("New");
        btn.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Launcher frame = new Launcher();
                frame.setVisible(true);
                setLayout(null);
                setVisible(false);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        }));
        add(btn);
    }
}
