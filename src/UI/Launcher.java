package UI;


import game.Game;

import javax.swing.*;
import java.awt.*;

class Launcher {
    private static final Game game = new Game();

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Engi's Farm");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            frame.add(game.mapController.mapView, BorderLayout.CENTER);
            frame.add(game.playerController.playerViewInfo, BorderLayout.EAST);
            frame.add(game.playerController.playerViewAction, BorderLayout.SOUTH);

            frame.pack();
            frame.setVisible(true);
        });
    }
}