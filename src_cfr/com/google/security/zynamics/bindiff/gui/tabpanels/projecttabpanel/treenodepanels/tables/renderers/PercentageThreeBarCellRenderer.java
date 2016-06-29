/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageThreeBarCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageThreeBarIcon;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.AbstractTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class PercentageThreeBarCellRenderer
extends AbstractTableCellRenderer {
    private final Color leftBarColor;
    private final Color centerBarColor;
    private final Color rightBarColor;
    private final Color emptyBarColor;
    private final Color textColor;

    public PercentageThreeBarCellRenderer(Color color, Color color2, Color color3, Color color4, Color color5) {
        this.leftBarColor = color;
        this.centerBarColor = color2;
        this.rightBarColor = color3;
        this.emptyBarColor = color4;
        this.textColor = color5;
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        this.buildAndSetToolTip(jTable, n2);
        this.setFont(!this.isBoldFont(jTable, n2) ? NORMAL_FONT : BOLD_FONT);
        if (!(object instanceof PercentageThreeBarCellData)) return this;
        this.setIcon(new PercentageThreeBarIcon((PercentageThreeBarCellData)object, this.leftBarColor, this.centerBarColor, this.rightBarColor, this.emptyBarColor, this.textColor, jTable.getSelectionBackground(), bl2, -1, 0, jTable.getColumnModel().getColumn(n3).getWidth() - 2, jTable.getRowHeight() - 2));
        return this;
    }
}

