package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.*;
import java.awt.*;
import javax.swing.*;
import com.google.common.base.*;

public class IconCellRenderer extends AbstractTableCellRenderer
{
    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object o, final boolean b, final boolean b2, final int n, final int n2) {
        Preconditions.checkArgument(o instanceof Icon, (Object)"Value must be an Icon.");
        this.setHorizontalAlignment(0);
        this.setIcon((Icon)o);
        return this;
    }
}
