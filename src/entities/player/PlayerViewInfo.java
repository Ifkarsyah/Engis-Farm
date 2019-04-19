package entities.player;

import javax.swing.*;

@SuppressWarnings("unchecked")
public class PlayerViewInfo extends JPanel {
    private final JButton moneyView;
    private final JButton waterView;
    private final JList inventoryView;


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
