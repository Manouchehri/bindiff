package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.*;
import javax.swing.*;

public class PercentageTwoBarCellRenderer extends AbstractTableCellRenderer
{
    private final Color leftBarColor;
    private final Color rightBarColor;
    private final Color emptyBarColor;
    private final Color leftTextColor;
    private final Color totalTextColor;
    private final Color rightTextColor;
    
    public PercentageTwoBarCellRenderer(final Color leftBarColor, final Color rightBarColor, final Color emptyBarColor, final Color leftTextColor, final Color totalTextColor, final Color rightTextColor) {
        this.leftBarColor = leftBarColor;
        this.rightBarColor = rightBarColor;
        this.emptyBarColor = emptyBarColor;
        this.leftTextColor = leftTextColor;
        this.totalTextColor = totalTextColor;
        this.rightTextColor = rightTextColor;
    }
    
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object o, final boolean b, final boolean b2, final int n, final int n2) {
        this.buildAndSetToolTip(table, n);
        this.setFont(this.isBoldFont(table, n) ? PercentageTwoBarCellRenderer.BOLD_FONT : PercentageTwoBarCellRenderer.NORMAL_FONT);
        if (o instanceof PercentageTwoBarCellData) {
            this.setIcon(new PercentageTwoBarIcon((PercentageTwoBarCellData)o, this.leftBarColor, this.rightBarColor, this.emptyBarColor, this.leftTextColor, this.totalTextColor, this.rightTextColor, table.getSelectionBackground(), b, -1, 0, table.getColumnModel().getColumn(n2).getWidth() - 2, table.getRowHeight() - 2));
        }
        return this;
    }
}
