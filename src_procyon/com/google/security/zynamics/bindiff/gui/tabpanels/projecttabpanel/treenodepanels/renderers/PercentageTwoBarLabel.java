package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.resources.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class PercentageTwoBarLabel extends JLabel
{
    private final PercentageTwoBarIcon matchBarIcon;
    
    public PercentageTwoBarLabel(final PercentageTwoBarCellData percentageTwoBarCellData, final Color color, final Color color2, final int n) {
        (this.matchBarIcon = new PercentageTwoBarIcon(percentageTwoBarCellData, color, color2, Colors.GRAY160, Colors.GRAY32, Colors.GRAY32, Colors.GRAY32, Colors.GRAY32, false, -2, 0, 1, n - 1)).showAdditionalPercetageValues(true);
        this.setIcon(this.matchBarIcon);
        this.setBorder(new LineBorder(Color.black));
    }
    
    @Override
    public void paint(final Graphics graphics) {
        this.matchBarIcon.setWidth(this.getWidth() + 1);
        super.paint(graphics);
    }
    
    public void updateData(final int n, final int n2) {
        this.matchBarIcon.updateData(n, n2);
        this.updateUI();
    }
}
