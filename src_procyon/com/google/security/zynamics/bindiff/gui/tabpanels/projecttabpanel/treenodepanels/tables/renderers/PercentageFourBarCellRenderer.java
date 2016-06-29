package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.*;
import javax.swing.*;

public class PercentageFourBarCellRenderer extends AbstractTableCellRenderer
{
    private final Color leftBarColor;
    private final Color centerLeftBarColor;
    private final Color centerRightBarColor;
    private final Color rightBarColor;
    private final Color emptyBarColor;
    private final Color textColor;
    
    public PercentageFourBarCellRenderer(final Color leftBarColor, final Color centerLeftBarColor, final Color centerRightBarColor, final Color rightBarColor, final Color emptyBarColor, final Color textColor) {
        this.leftBarColor = leftBarColor;
        this.centerLeftBarColor = centerLeftBarColor;
        this.centerRightBarColor = centerRightBarColor;
        this.rightBarColor = rightBarColor;
        this.emptyBarColor = emptyBarColor;
        this.textColor = textColor;
    }
    
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object o, final boolean b, final boolean b2, final int n, final int n2) {
        this.buildAndSetToolTip(table, n);
        this.setFont(this.isBoldFont(table, n) ? PercentageFourBarCellRenderer.BOLD_FONT : PercentageFourBarCellRenderer.NORMAL_FONT);
        if (o instanceof PercentageThreeBarExtendedCellData) {
            this.setIcon(new PercentageThreeBarExtendedBarIcon((PercentageThreeBarExtendedCellData)o, this.leftBarColor, this.centerLeftBarColor, this.centerRightBarColor, this.rightBarColor, this.emptyBarColor, this.textColor, table.getSelectionBackground(), b, -1, 0, table.getColumnModel().getColumn(n2).getWidth() - 2, table.getRowHeight() - 2));
        }
        return this;
    }
}
