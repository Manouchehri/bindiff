/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarIcon;
import com.google.security.zynamics.bindiff.resources.Colors;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class PercentageTwoBarLabel
extends JLabel {
    private final PercentageTwoBarIcon matchBarIcon;

    public PercentageTwoBarLabel(PercentageTwoBarCellData percentageTwoBarCellData, Color color, Color color2, int n2) {
        this.matchBarIcon = new PercentageTwoBarIcon(percentageTwoBarCellData, color, color2, Colors.GRAY160, Colors.GRAY32, Colors.GRAY32, Colors.GRAY32, Colors.GRAY32, false, -2, 0, 1, n2 - 1);
        this.matchBarIcon.showAdditionalPercetageValues(true);
        this.setIcon(this.matchBarIcon);
        this.setBorder(new LineBorder(Color.black));
    }

    @Override
    public void paint(Graphics graphics) {
        this.matchBarIcon.setWidth(this.getWidth() + 1);
        super.paint(graphics);
    }

    public void updateData(int n2, int n3) {
        this.matchBarIcon.updateData(n2, n3);
        this.updateUI();
    }
}

