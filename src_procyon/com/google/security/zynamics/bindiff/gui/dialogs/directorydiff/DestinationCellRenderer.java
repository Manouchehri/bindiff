package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import javax.swing.table.*;
import java.io.*;
import com.google.common.base.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.resources.*;

public class DestinationCellRenderer extends DefaultTableCellRenderer
{
    private final String workspacePath;
    
    public DestinationCellRenderer(final String s) {
        Preconditions.checkArgument(new File(s).exists(), (Object)"Workspace path must exist");
        this.workspacePath = (String)Preconditions.checkNotNull(s);
    }
    
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object o, final boolean b, final boolean b2, final int n, final int n2) {
        final Component tableCellRendererComponent = super.getTableCellRendererComponent(table, o, false, false, n, n2);
        final String format = String.format("%s%s%s", this.workspacePath, File.separator, o);
        if (n2 == 3) {
            tableCellRendererComponent.setBackground(Color.WHITE);
            if (new File(format).exists()) {
                tableCellRendererComponent.setBackground(Colors.TABLE_CELL_PRIMARY_UNMATCHED_BACKGROUND);
            }
        }
        return tableCellRendererComponent;
    }
}
