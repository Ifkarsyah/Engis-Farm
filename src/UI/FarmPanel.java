package UI;


import javax.swing.*;
import java.awt.*;

import static meta.Constant.sizeColMap;
import static meta.Constant.sizeRowMap;

class FarmPanel extends JPanel {

    public FarmPanel() {
        super(new GridLayout(sizeRowMap, sizeColMap));

        JButton[][] map = new JButton[sizeRowMap][sizeColMap];

        for (int i = 0; i < sizeRowMap; i++) {
            for (int j = 0; j < sizeColMap; j++) {
                map[i][j] = new JButton("-" );
                add(map[i][j]);
            }
        }
    }
}
