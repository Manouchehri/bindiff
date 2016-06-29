package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.*;
import javax.swing.*;

public class PercentageThreeBarCellRenderer extends AbstractTableCellRenderer
{
    private final Color leftBarColor;
    private final Color centerBarColor;
    private final Color rightBarColor;
    private final Color emptyBarColor;
    private final Color textColor;
    
    public PercentageThreeBarCellRenderer(final Color leftBarColor, final Color centerBarColor, final Color rightBarColor, final Color emptyBarColor, final Color textColor) {
        this.leftBarColor = leftBarColor;
        this.centerBarColor = centerBarColor;
        this.rightBarColor = rightBarColor;
        this.emptyBarColor = emptyBarColor;
        this.textColor = textColor;
    }
    
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object o, final boolean b, final boolean b2, final int n, final int n2) {
        this.buildAndSetToolTip(table, n);
        this.setFont(this.isBoldFont(table, n) ? PercentageThreeBarCellRenderer.BOLD_FONT : PercentageThreeBarCellRenderer.NORMAL_FONT);
        if (o instanceof PercentageThreeBarCellData) {
            this.setIcon(new PercentageThreeBarIcon((PercentageThreeBarCellData)o, this.leftBarColor, this.centerBarColor, this.rightBarColor, this.emptyBarColor, this.textColor, table.getSelectionBackground(), b, -1, 0, table.getColumnModel().getColumn(n2).getWidth() - 2, table.getRowHeight() - 2));
        }
        return this;
    }
}
