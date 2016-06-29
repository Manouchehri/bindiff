/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.resources.Colors;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class DestinationCellRenderer
extends DefaultTableCellRenderer {
    private final String workspacePath;

    public DestinationCellRenderer(String string) {
        Preconditions.checkArgument(new File(string).exists(), "Workspace path must exist");
        this.workspacePath = (String)Preconditions.checkNotNull(string);
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        Component component = super.getTableCellRendererComponent(jTable, object, false, false, n2, n3);
        String string = String.format("%s%s%s", this.workspacePath, File.separator, object);
        if (n3 != 3) return component;
        component.setBackground(Color.WHITE);
        File file = new File(string);
        if (!file.exists()) return component;
        component.setBackground(Colors.TABLE_CELL_PRIMARY_UNMATCHED_BACKGROUND);
        return component;
    }
}

