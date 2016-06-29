/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarCellData;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarIcon;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.AbstractTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class PercentageTwoBarCellRenderer
extends AbstractTableCellRenderer {
    private final Color leftBarColor;
    private final Color rightBarColor;
    private final Color emptyBarColor;
    private final Color leftTextColor;
    private final Color totalTextColor;
    private final Color rightTextColor;

    public PercentageTwoBarCellRenderer(Color color, Color color2, Color color3, Color color4, Color color5, Color color6) {
        this.leftBarColor = color;
        this.rightBarColor = color2;
        this.emptyBarColor = color3;
        this.leftTextColor = color4;
        this.totalTextColor = color5;
        this.rightTextColor = color6;
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        this.buildAndSetToolTip(jTable, n2);
        this.setFont(!this.isBoldFont(jTable, n2) ? NORMAL_FONT : BOLD_FONT);
        if (!(object instanceof PercentageTwoBarCellData)) return this;
        this.setIcon(new PercentageTwoBarIcon((PercentageTwoBarCellData)object, this.leftBarColor, this.rightBarColor, this.emptyBarColor, this.leftTextColor, this.totalTextColor, this.rightTextColor, jTable.getSelectionBackground(), bl2, -1, 0, jTable.getColumnModel().getColumn(n3).getWidth() - 2, jTable.getRowHeight() - 2));
        return this;
    }
}

