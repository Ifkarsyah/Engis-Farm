package entities.player;

import javax.swing.*;

public class PlayerViewInfo extends JPanel {
    JButton moneyView;
    JButton waterView;
    JList inventoryView;


    public PlayerViewInfo(PlayerModel playerModel) {
        super();
        this.moneyView = new JButton("Money: " + playerModel.getMoney());
        this.waterView = new JButton("Water: " + playerModel.getWater());
        this.inventoryView = new JList<>(playerModel.getInventory().toArray());

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new JLabel("Inventory"));
        add(inventoryView);
        add(moneyView);
        add(waterView);
    }

    public void updatePlayerInfoView(PlayerModel playerModel) {
        moneyView.setText("Money: " + playerModel.getMoney());
        waterView.setText("Water: " + playerModel.getWater());
        inventoryView.setListData(playerModel.getInventory().toArray());
    }
}
