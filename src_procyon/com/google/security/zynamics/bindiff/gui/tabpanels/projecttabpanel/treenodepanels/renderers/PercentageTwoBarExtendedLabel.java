package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.resources.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class PercentageTwoBarExtendedLabel extends JLabel
{
    private final PercentageTwoBarExtendedIcon matchBarIcon;
    
    public PercentageTwoBarExtendedLabel(final PercentageTwoBarExtendedCellData percentageTwoBarExtendedCellData, final Color color, final Color color2, final Color color3, final int n) {
        this.setIcon(this.matchBarIcon = new PercentageTwoBarExtendedIcon(percentageTwoBarExtendedCellData, color, color2, color3, Colors.GRAY160, Colors.GRAY32, -2, 0, 1, n - 1));
        this.setBorder(new LineBorder(Color.black));
    }
    
    @Override
    public void paint(final Graphics graphics) {
        this.matchBarIcon.setWidth(this.getWidth() + 1);
        super.paint(graphics);
    }
    
    public void updateData(final int n, final int n2, final int n3) {
        this.matchBarIcon.updateData(n, n2, n3);
        this.updateUI();
    }
}
