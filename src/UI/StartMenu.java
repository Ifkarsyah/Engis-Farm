package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu extends JFrame {
    /**
     *
     * main program untuk start menu
     * 
     */
    public static void main(String[] args) {
        try {
            StartMenu frame = new StartMenu();
            frame.setVisible(true);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * Konstruktor Start Menu
     * Menginisialisasi Start Menu dari Game
     */
    public StartMenu(){
        setTitle("Start Menu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 1000, 1000);
        JLabel background = new JLabel(new ImageIcon(StartMenu.class.getResource("/img/startmenu.png")));
        setContentPane(background);
        JButton btn = new JButton();
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
        btn.setIcon(new ImageIcon(StartMenu.class.getResource("/img/button.png")));
        btn.setBounds(430,400,219,145);
        background.add(btn);
    }
}
