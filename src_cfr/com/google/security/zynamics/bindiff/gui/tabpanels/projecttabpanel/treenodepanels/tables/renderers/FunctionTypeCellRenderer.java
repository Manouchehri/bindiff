/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.BackgroundIcon;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.AbstractTableCellRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.FunctionTypeCellRenderer$1;
import com.google.security.zynamics.bindiff.resources.Colors;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class FunctionTypeCellRenderer
extends AbstractTableCellRenderer {
    public static Color calcColor(EFunctionType eFunctionType) {
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
        }
        return Colors.GRAY160;
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        this.buildAndSetToolTip(jTable, n2);
        this.setFont(!this.isBoldFont(jTable, n2) ? NORMAL_FONT : BOLD_FONT);
        if (!(object instanceof EFunctionType)) return this;
        boolean bl4 = !object.toString().equals(EFunctionType.UNKNOWN.toString());
        this.setIcon(new BackgroundIcon(bl4 ? object.toString() : NOT_ACCESSABLE_TEXT, 0, Colors.GRAY32, bl4 ? FunctionTypeCellRenderer.calcColor((EFunctionType)((Object)object)) : NOT_ACCESSABLE_COLOR, jTable.getSelectionBackground(), bl2, -1, 0, jTable.getColumnModel().getColumn(n3).getWidth() - 1, jTable.getRowHeight() - 1));
        return this;
    }
}

