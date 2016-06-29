/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageThreeBarExtendedBarIcon;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageThreeBarExtendedCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.AbstractTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class PercentageFourBarCellRenderer
extends AbstractTableCellRenderer {
    private final Color leftBarColor;
    private final Color centerLeftBarColor;
    private final Color centerRightBarColor;
    private final Color rightBarColor;
    private final Color emptyBarColor;
    private final Color textColor;

    public PercentageFourBarCellRenderer(Color color, Color color2, Color color3, Color color4, Color color5, Color color6) {
        this.leftBarColor = color;
        this.centerLeftBarColor = color2;
        this.centerRightBarColor = color3;
        this.rightBarColor = color4;
        this.emptyBarColor = color5;
        this.textColor = color6;
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        this.buildAndSetToolTip(jTable, n2);
        this.setFont(!this.isBoldFont(jTable, n2) ? NORMAL_FONT : BOLD_FONT);
        if (!(object instanceof PercentageThreeBarExtendedCellData)) return this;
        this.setIcon(new PercentageThreeBarExtendedBarIcon((PercentageThreeBarExtendedCellData)object, this.leftBarColor, this.centerLeftBarColor, this.centerRightBarColor, this.rightBarColor, this.emptyBarColor, this.textColor, jTable.getSelectionBackground(), bl2, -1, 0, jTable.getColumnModel().getColumn(n3).getWidth() - 2, jTable.getRowHeight() - 2));
        return this;
    }
}

