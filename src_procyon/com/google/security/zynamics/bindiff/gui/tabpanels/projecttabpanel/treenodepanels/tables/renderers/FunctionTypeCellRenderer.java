package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.resources.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.*;
import javax.swing.*;

public class FunctionTypeCellRenderer extends AbstractTableCellRenderer
{
    public static Color calcColor(final EFunctionType eFunctionType) {
        switch (FunctionTypeCellRenderer$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EFunctionType[eFunctionType.ordinal()]) {
            case 1: {
                return Colors.GRAY250;
            }
            case 2: {
                return Colors.FUNCTION_TYPE_LIBRARY;
            }
            case 3: {
                return Colors.FUNCTION_TYPE_THUNK;
            }
            case 4: {
                return Colors.FUNCTION_TYPE_IMPORTED;
            }
            case 5: {
                return Colors.GRAY250;
            }
            default: {
                return Colors.GRAY160;
            }
        }
    }
    
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object o, final boolean b, final boolean b2, final int n, final int n2) {
        this.buildAndSetToolTip(table, n);
        this.setFont(this.isBoldFont(table, n) ? FunctionTypeCellRenderer.BOLD_FONT : FunctionTypeCellRenderer.NORMAL_FONT);
        if (o instanceof EFunctionType) {
            final boolean b3 = !o.toString().equals(EFunctionType.UNKNOWN.toString());
            this.setIcon(new BackgroundIcon(b3 ? o.toString() : FunctionTypeCellRenderer.NOT_ACCESSABLE_TEXT, 0, Colors.GRAY32, b3 ? calcColor((EFunctionType)o) : FunctionTypeCellRenderer.NOT_ACCESSABLE_COLOR, table.getSelectionBackground(), b, -1, 0, table.getColumnModel().getColumn(n2).getWidth() - 1, table.getRowHeight() - 1));
        }
        return this;
    }
}
