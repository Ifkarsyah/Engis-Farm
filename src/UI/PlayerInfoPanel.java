package UI;

import javax.swing.*;

class PlayerInfoPanel extends JPanel {
    private String[] playerInventory = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    public PlayerInfoPanel() {
        super();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addInventory();
        int playerMoney = 100;
        add(new JButton("Money: " + playerMoney));
        int playerWater = 100;
        add(new JButton("Water: " + playerWater));
    }

    private void addInventory() {
        add(new JLabel("Inventory"));
        add(new JList<>(playerInventory));
    }
}
