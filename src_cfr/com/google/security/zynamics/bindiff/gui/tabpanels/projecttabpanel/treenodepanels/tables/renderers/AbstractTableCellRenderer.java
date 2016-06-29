/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTableModel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewManager;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public abstract class AbstractTableCellRenderer
extends DefaultTableCellRenderer {
    public static Color NOT_ACCESSABLE_COLOR = Colors.GRAY250;
    public static String NOT_ACCESSABLE_TEXT = "";
    protected static Font NORMAL_FONT = GuiHelper.DEFAULT_FONT;
    protected static Font BOLD_FONT = new Font(NORMAL_FONT.getName(), 1, NORMAL_FONT.getSize());

    protected boolean isBoldFont(JTable jTable, int n2) {
        if (!(jTable instanceof AbstractTable)) {
            return false;
        }
        AbstractTable abstractTable = (AbstractTable)jTable;
        Diff diff = abstractTable.getTableModel().getDiff();
        if (diff != null) {
            ViewManager viewManager = diff.getViewManager();
            Pair pair = AbstractTable.getViewAddressPair((AbstractTable)jTable, n2);
            return viewManager.containsView((IAddress)pair.first(), (IAddress)pair.second());
        }
        Diff diff2 = AbstractTable.getRowDiff(abstractTable, n2);
        if (diff2 == null) return false;
        if (diff2.getViewManager().getFlowgraphViewsData().size() <= 0) return false;
        return true;
    }

    public void buildAndSetToolTip(JTable jTable, int n2) {
        if (!(jTable instanceof AbstractTable)) {
            return;
        }
        AbstractTable abstractTable = (AbstractTable)jTable;
        Diff diff = abstractTable.getDiff();
        this.setToolTipText(abstractTable.getToolTipForRow(diff, n2));
    }

    @Override
    public abstract Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6);
}

