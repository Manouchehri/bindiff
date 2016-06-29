package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;

public class DefaultCellRenderer extends DefaultTableCellRenderer
{
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object o, final boolean b, final boolean b2, final int n, final int n2) {
        return super.getTableCellRendererComponent(table, o, false, false, n, n2);
    }
}
