package UI;

import entities.player.PlayerViewAction;
import entities.player.PlayerViewInfo;
import game.Game;

import javax.swing.*;
import java.awt.*;

class Launcher {
    static Game game = new Game();
    static PlayerViewInfo playerViewInfo = new PlayerViewInfo(game.mapModel.playerModel);
    static PlayerViewAction playerViewAction = new PlayerViewAction(game.mapModel.playerModel, game.mapModel);

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Engi's Farm");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.add(game.mapView, BorderLayout.CENTER);
            frame.add(playerViewInfo, BorderLayout.EAST);
            frame.add(playerViewAction, BorderLayout.SOUTH);

            frame.pack();
            frame.setVisible(true);
        });
    }
}