/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarExtendedCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarExtendedIcon;
import com.google.security.zynamics.bindiff.resources.Colors;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class PercentageTwoBarExtendedLabel
extends JLabel {
    private final PercentageTwoBarExtendedIcon matchBarIcon;

    public PercentageTwoBarExtendedLabel(PercentageTwoBarExtendedCellData percentageTwoBarExtendedCellData, Color color, Color color2, Color color3, int n2) {
        this.matchBarIcon = new PercentageTwoBarExtendedIcon(percentageTwoBarExtendedCellData, color, color2, color3, Colors.GRAY160, Colors.GRAY32, -2, 0, 1, n2 - 1);
        this.setIcon(this.matchBarIcon);
        this.setBorder(new LineBorder(Color.black));
    }

    @Override
    public void paint(Graphics graphics) {
        this.matchBarIcon.setWidth(this.getWidth() + 1);
        super.paint(graphics);
    }

    public void updateData(int n2, int n3, int n4) {
        this.matchBarIcon.updateData(n2, n3, n4);
        this.updateUI();
    }
}

