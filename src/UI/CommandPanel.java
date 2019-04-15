package UI;

import javax.swing.*;

class CommandPanel extends JPanel {
    public CommandPanel() {
        super();
        add(new JButton("TALK"));
        add(new JButton("KILL"));
        add(new JButton("INTERACT"));
        add(new JButton("MIX"));
        add(new JButton("GROW"));
    }
}
