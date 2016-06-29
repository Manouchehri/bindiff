package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import javax.swing.table.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.zylib.general.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.zylib.gui.*;

public abstract class AbstractTableCellRenderer extends DefaultTableCellRenderer
{
    public static Color NOT_ACCESSABLE_COLOR;
    public static String NOT_ACCESSABLE_TEXT;
    protected static Font NORMAL_FONT;
    protected static Font BOLD_FONT;
    
    protected boolean isBoldFont(final JTable table, final int n) {
        if (!(table instanceof AbstractTable)) {
            return false;
        }
        final AbstractTable abstractTable = (AbstractTable)table;
        final Diff diff = abstractTable.getTableModel().getDiff();
        if (diff == null) {
            final Diff rowDiff = AbstractTable.getRowDiff(abstractTable, n);
            return rowDiff != null && rowDiff.getViewManager().getFlowgraphViewsData().size() > 0;
        }
        final ViewManager viewManager = diff.getViewManager();
        final Pair viewAddressPair = AbstractTable.getViewAddressPair((AbstractTable)table, n);
        return viewManager.containsView((IAddress)viewAddressPair.first(), (IAddress)viewAddressPair.second());
    }
    
    public void buildAndSetToolTip(final JTable table, final int n) {
        if (!(table instanceof AbstractTable)) {
            return;
        }
        final AbstractTable abstractTable = (AbstractTable)table;
        this.setToolTipText(abstractTable.getToolTipForRow(abstractTable.getDiff(), n));
    }
    
    @Override
    public abstract Component getTableCellRendererComponent(final JTable p0, final Object p1, final boolean p2, final boolean p3, final int p4, final int p5);
    
    static {
        AbstractTableCellRenderer.NOT_ACCESSABLE_COLOR = Colors.GRAY250;
        AbstractTableCellRenderer.NOT_ACCESSABLE_TEXT = "";
        AbstractTableCellRenderer.NORMAL_FONT = GuiHelper.DEFAULT_FONT;
        AbstractTableCellRenderer.BOLD_FONT = new Font(AbstractTableCellRenderer.NORMAL_FONT.getName(), 1, AbstractTableCellRenderer.NORMAL_FONT.getSize());
    }
}
