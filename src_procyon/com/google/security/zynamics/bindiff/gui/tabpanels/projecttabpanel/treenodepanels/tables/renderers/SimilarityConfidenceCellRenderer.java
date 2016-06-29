package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import com.google.security.zynamics.bindiff.resources.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.*;
import javax.swing.*;

public class SimilarityConfidenceCellRenderer extends AbstractTableCellRenderer
{
    public static Color calcColor(final double n) {
        if (n >= 0.0 && n <= 1.0) {
            return Color.getHSBColor(0.31f * (float)n, 0.3f, 0.9f);
        }
        return Colors.GRAY192;
    }
    
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object o, final boolean b, final boolean b2, final int n, final int n2) {
        this.buildAndSetToolTip(table, n);
        this.setFont(this.isBoldFont(table, n) ? SimilarityConfidenceCellRenderer.BOLD_FONT : SimilarityConfidenceCellRenderer.NORMAL_FONT);
        if (o instanceof Double) {
            final double doubleValue = (double)o;
            this.setIcon(new BackgroundIcon((doubleValue == -1.0) ? SimilarityConfidenceCellRenderer.NOT_ACCESSABLE_TEXT : String.format("%.2f", doubleValue), 0, Colors.GRAY32, (doubleValue == -1.0) ? SimilarityConfidenceCellRenderer.NOT_ACCESSABLE_COLOR : calcColor((double)o), table.getSelectionBackground(), b, -1, 0, table.getColumnModel().getColumn(n2).getWidth() - 1, table.getRowHeight() - 1));
        }
        return this;
    }
}
