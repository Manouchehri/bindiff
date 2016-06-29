/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.BackgroundIcon;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.AbstractTableCellRenderer;
import com.google.security.zynamics.bindiff.resources.Colors;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class SimilarityConfidenceCellRenderer
extends AbstractTableCellRenderer {
    public static Color calcColor(double d2) {
        if (d2 < 0.0) return Colors.GRAY192;
        if (d2 > 1.0) return Colors.GRAY192;
        return Color.getHSBColor(0.31f * (float)d2, 0.3f, 0.9f);
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        this.buildAndSetToolTip(jTable, n2);
        this.setFont(!this.isBoldFont(jTable, n2) ? NORMAL_FONT : BOLD_FONT);
        if (!(object instanceof Double)) return this;
        double d2 = (Double)object;
        this.setIcon(new BackgroundIcon(d2 == -1.0 ? NOT_ACCESSABLE_TEXT : String.format("%.2f", d2), 0, Colors.GRAY32, d2 == -1.0 ? NOT_ACCESSABLE_COLOR : SimilarityConfidenceCellRenderer.calcColor((Double)object), jTable.getSelectionBackground(), bl2, -1, 0, jTable.getColumnModel().getColumn(n3).getWidth() - 1, jTable.getRowHeight() - 1));
        return this;
    }
}

